package com.github.smallinger.copperagebackport.fabric.client;

import com.github.smallinger.copperagebackport.Constants;
import com.github.smallinger.copperagebackport.mixin.client.MappedRegistryAccessor;
import com.mojang.serialization.Lifecycle;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.Reference2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Reference2IntMap;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

/**
 * Captures and restores the client's launch-time built-in registry raw-id state.
 *
 * <p>This is used on the client to restore registry internals to the same state
 * they had at game launch, which makes reconnect behave like a fresh client
 * startup without touching server/common registration behavior.</p>
 */
public final class ClientRegistryLaunchState {

    private static final Map<ResourceLocation, RegistrySnapshot> SNAPSHOTS =
        new HashMap<>();
    private static boolean captured;

    private ClientRegistryLaunchState() {}

    public static void captureLaunchState() {
        if (captured) {
            return;
        }

        int count = 0;

        for (Registry<?> registry : BuiltInRegistries.REGISTRY) {
            if (!(registry instanceof MappedRegistry<?> mappedRegistry)) {
                continue;
            }

            ResourceLocation registryId = registry.key().location();
            SNAPSHOTS.put(registryId, snapshot(mappedRegistry));
            count++;
        }

        captured = true;
        Constants.LOG.info(
            "Captured launch-time state for {} client registries",
            count
        );
    }

    public static void restoreLaunchState() {
        if (!captured || SNAPSHOTS.isEmpty()) {
            Constants.LOG.debug(
                "No client registry launch snapshot available to restore"
            );
            return;
        }

        int restored = 0;

        for (Registry<?> registry : BuiltInRegistries.REGISTRY) {
            if (!(registry instanceof MappedRegistry<?> mappedRegistry)) {
                continue;
            }

            ResourceLocation registryId = registry.key().location();
            RegistrySnapshot snapshot = SNAPSHOTS.get(registryId);
            if (snapshot == null) {
                continue;
            }

            restore(mappedRegistry, snapshot);
            restored++;
        }

        Constants.LOG.info(
            "Restored launch-time state for {} client registries",
            restored
        );
    }

    @SuppressWarnings("unchecked")
    private static RegistrySnapshot snapshot(MappedRegistry<?> registry) {
        MappedRegistryAccessor<Object> accessor = (MappedRegistryAccessor<
            Object
        >) registry;

        ObjectList<Holder.Reference<Object>> byId =
            accessor.copperagebackport$getById();
        Reference2IntMap<Object> toId = accessor.copperagebackport$getToId();
        Map<ResourceLocation, Holder.Reference<Object>> byLocation =
            accessor.copperagebackport$getByLocation();
        Map<ResourceKey<Object>, Holder.Reference<Object>> byKey =
            accessor.copperagebackport$getByKey();
        Map<Object, Holder.Reference<Object>> byValue =
            accessor.copperagebackport$getByValue();
        Map<ResourceKey<Object>, RegistrationInfo> registrationInfos =
            accessor.copperagebackport$getRegistrationInfos();
        Map<TagKey<Object>, HolderSet.Named<Object>> tags =
            accessor.copperagebackport$getTags();
        Lifecycle registryLifecycle =
            accessor.copperagebackport$getRegistryLifecycle();

        ObjectList<Holder.Reference<Object>> byIdCopy = new ObjectArrayList<>(
            byId.size()
        );
        for (int i = 0; i < byId.size(); i++) {
            byIdCopy.add(byId.get(i));
        }

        Reference2IntArrayMap<Object> toIdCopy = new Reference2IntArrayMap<>(
            toId.size()
        );
        toIdCopy.defaultReturnValue(toId.defaultReturnValue());
        for (Reference2IntMap.Entry<
            Object
        > entry : toId.reference2IntEntrySet()) {
            toIdCopy.put(entry.getKey(), entry.getIntValue());
        }

        Map<ResourceLocation, Holder.Reference<Object>> byLocationCopy =
            new HashMap<>(byLocation);
        Map<ResourceKey<Object>, Holder.Reference<Object>> byKeyCopy =
            new HashMap<>(byKey);
        Map<Object, Holder.Reference<Object>> byValueCopy = new HashMap<>(
            byValue
        );
        Map<ResourceKey<Object>, RegistrationInfo> registrationInfosCopy =
            new HashMap<>(registrationInfos);
        Map<TagKey<Object>, HolderSet.Named<Object>> tagsCopy = new HashMap<>(
            tags
        );

        return new RegistrySnapshot(
            byIdCopy,
            toIdCopy,
            toId.defaultReturnValue(),
            byLocationCopy,
            byKeyCopy,
            byValueCopy,
            registrationInfosCopy,
            tagsCopy,
            registryLifecycle
        );
    }

    @SuppressWarnings("unchecked")
    private static void restore(
        MappedRegistry<?> registry,
        RegistrySnapshot snapshot
    ) {
        MappedRegistryAccessor<Object> accessor = (MappedRegistryAccessor<
            Object
        >) registry;

        ObjectList<Holder.Reference<Object>> byId =
            accessor.copperagebackport$getById();
        Reference2IntMap<Object> toId = accessor.copperagebackport$getToId();
        Map<ResourceLocation, Holder.Reference<Object>> byLocation =
            accessor.copperagebackport$getByLocation();
        Map<ResourceKey<Object>, Holder.Reference<Object>> byKey =
            accessor.copperagebackport$getByKey();
        Map<Object, Holder.Reference<Object>> byValue =
            accessor.copperagebackport$getByValue();
        Map<ResourceKey<Object>, RegistrationInfo> registrationInfos =
            accessor.copperagebackport$getRegistrationInfos();

        byId.clear();
        byId.size(snapshot.byId.size());
        for (int i = 0; i < snapshot.byId.size(); i++) {
            byId.set(i, snapshot.byId.get(i));
        }

        toId.clear();
        toId.defaultReturnValue(snapshot.toIdDefaultReturnValue);
        for (Reference2IntMap.Entry<
            Object
        > entry : snapshot.toId.reference2IntEntrySet()) {
            toId.put(entry.getKey(), entry.getIntValue());
        }

        byLocation.clear();
        byLocation.putAll(snapshot.byLocation);

        byKey.clear();
        byKey.putAll(snapshot.byKey);

        byValue.clear();
        byValue.putAll(snapshot.byValue);

        registrationInfos.clear();
        registrationInfos.putAll(snapshot.registrationInfos);

        accessor.copperagebackport$setTags(new HashMap<>(snapshot.tags));
        accessor.copperagebackport$setRegistryLifecycle(
            snapshot.registryLifecycle
        );
    }

    private record RegistrySnapshot(
        ObjectList<Holder.Reference<Object>> byId,
        Reference2IntArrayMap<Object> toId,
        int toIdDefaultReturnValue,
        Map<ResourceLocation, Holder.Reference<Object>> byLocation,
        Map<ResourceKey<Object>, Holder.Reference<Object>> byKey,
        Map<Object, Holder.Reference<Object>> byValue,
        Map<ResourceKey<Object>, RegistrationInfo> registrationInfos,
        Map<TagKey<Object>, HolderSet.Named<Object>> tags,
        Lifecycle registryLifecycle
    ) {}
}
