package com.github.smallinger.copperagebackport.fabric.platform;

import com.github.smallinger.copperagebackport.Constants;
import com.github.smallinger.copperagebackport.registry.RegistryHelper;
import net.fabricmc.fabric.impl.registry.sync.RegistrySyncManager;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Fabric implementation of the shared RegistryHelper.
 * Fabric registers content immediately against the built-in registries.
 * 
 * NOTE: We intentionally do NOT mark registries as MODDED when using minecraft: namespace,
 * because Fabric's registry sync will try to "unmap" those entries on disconnect,
 * which causes crashes. VanillaBackport/Platform use the same approach.
 */
public class FabricRegistryHelper extends RegistryHelper {

    private final List<RestorableEntry<?>> minecraftEntries = new ArrayList<>();

    private <T> Tuple<Holder<T>, Supplier<T>> registerWithNamespaceInternal(ResourceKey<? extends Registry<? super T>> registryKey,
                                                                            String namespace,
                                                                            String name,
                                                                            Supplier<T> supplier)
    {
        Registry<T> registry = (Registry<T>) BuiltInRegistries.REGISTRY.get(registryKey.location());
        if (registry == null) {
            throw new IllegalArgumentException("Unknown registry: " + registryKey.location());
        }

        boolean restoreBootstrapFlag = false;
        boolean originalPostBootstrap = false;

        if (MINECRAFT_NAMESPACE.equals(namespace)) {
            originalPostBootstrap = RegistrySyncManager.postBootstrap;
            if (originalPostBootstrap) {
                RegistrySyncManager.postBootstrap = false;
                restoreBootstrapFlag = true;
            }
        }

        T registered = supplier.get();
        Holder<T> holder;
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(namespace, name);

        try {
            holder = net.minecraft.core.Registry.registerForHolder(registry, id, registered);
            if (MINECRAFT_NAMESPACE.equals(namespace)) {
                cacheMinecraftEntry(registryKey, id, registered);
            }
        } finally {
            if (restoreBootstrapFlag) {
                RegistrySyncManager.postBootstrap = originalPostBootstrap;
            }
        }

        Constants.LOG.debug("Registered {} under namespace {}", name, namespace);

        return new Tuple<>(holder, () -> registered);
    }

    @Override
    public <T> Supplier<T> registerWithNamespace(ResourceKey<? extends Registry<? super T>> registryKey,
                                                  String namespace,
                                                  String name,
                                                  Supplier<T> supplier) {

        
        return registerWithNamespaceInternal(registryKey, namespace, name, supplier).getB();
    }

    @Override
    public <T> Holder<T> registerWithNamespaceForHolder(ResourceKey<? extends Registry<? super T>> registryKey,
                                                 String namespace,
                                                 String name,
                                                 Supplier<T> supplier) {
        return registerWithNamespaceInternal(registryKey, namespace, name, supplier).getA();
    }

    @Override
    public void fireRegistrationCallbacks() {
        super.fireRegistrationCallbacks();
    }

    private <T> void cacheMinecraftEntry(ResourceKey<? extends Registry<? super T>> registryKey,
                                         ResourceLocation id,
                                         T value) {
        minecraftEntries.add(new RestorableEntry<>(registryKey, id, value));
    }

    @Override
    public void restoreVanillaNamespaceEntries() {
        Constants.LOG.debug("Requested minecraft namespace restore for {} cached entries", minecraftEntries.size());

        if (minecraftEntries.isEmpty()) {
            return;
        }

        int restored = 0;
        for (RestorableEntry<?> entry : minecraftEntries) {
            restored += restoreEntry(entry) ? 1 : 0;
        }

        if (restored > 0) {
            Constants.LOG.info("Restored {} minecraft namespace entries", restored);
        } else {
            Constants.LOG.debug("Minecraft namespace already intact; no entries restored");
        }
    }

    @SuppressWarnings("unchecked")
    private <T> boolean restoreEntry(RestorableEntry<T> entry) {
        Registry<T> registry = (Registry<T>) BuiltInRegistries.REGISTRY.get(entry.registryKey.location());
        if (registry == null) {
            return false;
        }

        T existing = registry.get(entry.id);
        if (existing != null && Objects.equals(existing, entry.value)) {
            return false;
        }

        net.minecraft.core.Registry.register(registry, entry.id, entry.value);
        return true;
    }

    private record RestorableEntry<T>(ResourceKey<? extends Registry<? super T>> registryKey,
                                      ResourceLocation id,
                                      T value) {
    }
}
