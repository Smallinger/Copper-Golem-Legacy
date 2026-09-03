package com.github.smallinger.copperagebackport.registry;

import com.github.smallinger.copperagebackport.Constants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Base registry helper that works across both Fabric and Forge.
 * Implementations are provided in the loader-specific modules.
 */
public abstract class RegistryHelper {
    
    public static final String MINECRAFT_NAMESPACE = "minecraft";
    
    private static RegistryHelper instance;
    
    /**
     * Set of item/block names that should be registered under minecraft: namespace
     * because they are backported vanilla features from 1.21.5+
     */
    public static final Set<String> VANILLA_BACKPORT_IDS = new HashSet<>();
    
    static {
        // Copper Chests
        VANILLA_BACKPORT_IDS.add("copper_chest");
        VANILLA_BACKPORT_IDS.add("exposed_copper_chest");
        VANILLA_BACKPORT_IDS.add("weathered_copper_chest");
        VANILLA_BACKPORT_IDS.add("oxidized_copper_chest");
        VANILLA_BACKPORT_IDS.add("waxed_copper_chest");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_copper_chest");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_copper_chest");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_copper_chest");

        // Copper Golem Statues
        VANILLA_BACKPORT_IDS.add("copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("exposed_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("weathered_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("oxidized_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("waxed_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_copper_golem_statue");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_copper_golem_statue");
        
        // Copper Golem Entity
        VANILLA_BACKPORT_IDS.add("copper_golem");
        VANILLA_BACKPORT_IDS.add("copper_golem_spawn_egg");
        
        // Copper Chains
        VANILLA_BACKPORT_IDS.add("copper_chain");
        VANILLA_BACKPORT_IDS.add("exposed_copper_chain");
        VANILLA_BACKPORT_IDS.add("weathered_copper_chain");
        VANILLA_BACKPORT_IDS.add("oxidized_copper_chain");
        VANILLA_BACKPORT_IDS.add("waxed_copper_chain");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_copper_chain");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_copper_chain");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_copper_chain");
        
        // Copper Lanterns
        VANILLA_BACKPORT_IDS.add("copper_lantern");
        VANILLA_BACKPORT_IDS.add("exposed_copper_lantern");
        VANILLA_BACKPORT_IDS.add("weathered_copper_lantern");
        VANILLA_BACKPORT_IDS.add("oxidized_copper_lantern");
        VANILLA_BACKPORT_IDS.add("waxed_copper_lantern");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_copper_lantern");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_copper_lantern");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_copper_lantern");
        
        // Copper Bars
        VANILLA_BACKPORT_IDS.add("copper_bars");
        VANILLA_BACKPORT_IDS.add("exposed_copper_bars");
        VANILLA_BACKPORT_IDS.add("weathered_copper_bars");
        VANILLA_BACKPORT_IDS.add("oxidized_copper_bars");
        VANILLA_BACKPORT_IDS.add("waxed_copper_bars");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_copper_bars");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_copper_bars");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_copper_bars");
        
        // Lightning Rod Weathering Variants
        // Vanilla minecraft:lightning_rod is extended via Mixin (LightningRodBlockMixin) to add weathering
        // These new oxidized variants are registered under minecraft: namespace
        VANILLA_BACKPORT_IDS.add("exposed_lightning_rod");
        VANILLA_BACKPORT_IDS.add("weathered_lightning_rod");
        VANILLA_BACKPORT_IDS.add("oxidized_lightning_rod");
        VANILLA_BACKPORT_IDS.add("waxed_lightning_rod");
        VANILLA_BACKPORT_IDS.add("waxed_exposed_lightning_rod");
        VANILLA_BACKPORT_IDS.add("waxed_weathered_lightning_rod");
        VANILLA_BACKPORT_IDS.add("waxed_oxidized_lightning_rod");
        
        // Copper Torch
        VANILLA_BACKPORT_IDS.add("copper_torch");
        VANILLA_BACKPORT_IDS.add("copper_wall_torch");
        
        // Copper Horse Armor
        VANILLA_BACKPORT_IDS.add("copper_horse_armor");
        
        // Copper Tools
        VANILLA_BACKPORT_IDS.add("copper_axe");
        VANILLA_BACKPORT_IDS.add("copper_pickaxe");
        VANILLA_BACKPORT_IDS.add("copper_shovel");
        VANILLA_BACKPORT_IDS.add("copper_hoe");
        VANILLA_BACKPORT_IDS.add("copper_sword");
        
        // Copper Armor
        VANILLA_BACKPORT_IDS.add("copper_helmet");
        VANILLA_BACKPORT_IDS.add("copper_chestplate");
        VANILLA_BACKPORT_IDS.add("copper_leggings");
        VANILLA_BACKPORT_IDS.add("copper_boots");
        
        // Copper Nugget
        VANILLA_BACKPORT_IDS.add("copper_nugget");
        
        // Shelves
        VANILLA_BACKPORT_IDS.add("oak_shelf");
        VANILLA_BACKPORT_IDS.add("spruce_shelf");
        VANILLA_BACKPORT_IDS.add("birch_shelf");
        VANILLA_BACKPORT_IDS.add("jungle_shelf");
        VANILLA_BACKPORT_IDS.add("acacia_shelf");
        VANILLA_BACKPORT_IDS.add("dark_oak_shelf");
        VANILLA_BACKPORT_IDS.add("mangrove_shelf");
        VANILLA_BACKPORT_IDS.add("cherry_shelf");
        VANILLA_BACKPORT_IDS.add("bamboo_shelf");
        VANILLA_BACKPORT_IDS.add("crimson_shelf");
        VANILLA_BACKPORT_IDS.add("warped_shelf");
        VANILLA_BACKPORT_IDS.add("pale_oak_shelf");
        
        // Block Entity Types (use same name as the block they represent)
        VANILLA_BACKPORT_IDS.add("copper_chest"); // Block entity for copper chests
        VANILLA_BACKPORT_IDS.add("shelf"); // Block entity for shelves
        VANILLA_BACKPORT_IDS.add("copper_golem_statue"); // Block entity for golem statues
        
        // Sound Events - Copper Golem
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.death.unaffected");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.hurt.unaffected");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.step.unaffected");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.head_spin.unaffected");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.death.exposed");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.hurt.exposed");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.step.exposed");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.head_spin.exposed");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.death.weathered");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.hurt.weathered");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.step.weathered");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.head_spin.weathered");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.death.oxidized");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.hurt.oxidized");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.step.oxidized");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.head_spin.oxidized");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.spawn");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.become_statue");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.shear");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.item_drop");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.item_no_drop");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.no_item_get");
        VANILLA_BACKPORT_IDS.add("entity.copper_golem.no_item_no_get");
        
        // Sound Events - Copper Chest
        VANILLA_BACKPORT_IDS.add("block.copper_chest.close");
        VANILLA_BACKPORT_IDS.add("block.copper_chest.open");
        
        // Sound Events - Copper Statue
        VANILLA_BACKPORT_IDS.add("block.copper_statue.break");
        VANILLA_BACKPORT_IDS.add("block.copper_statue.place");
        VANILLA_BACKPORT_IDS.add("block.copper_statue.hit");
        VANILLA_BACKPORT_IDS.add("block.copper_statue.become_statue");
        
        // Sound Events - Shelf
        VANILLA_BACKPORT_IDS.add("block.shelf.activate");
        VANILLA_BACKPORT_IDS.add("block.shelf.deactivate");
        VANILLA_BACKPORT_IDS.add("block.shelf.place_item");
        VANILLA_BACKPORT_IDS.add("block.shelf.take_item");
        VANILLA_BACKPORT_IDS.add("block.shelf.single_swap");
        VANILLA_BACKPORT_IDS.add("block.shelf.multi_swap");
        
        // Sound Events - Armor
        VANILLA_BACKPORT_IDS.add("item.armor.equip_copper");
        
        // Sound Events - Weather (End Flash)
        VANILLA_BACKPORT_IDS.add("weather.end_flash");
        
        // Particles
        VANILLA_BACKPORT_IDS.add("copper_fire_flame");
    }
    
    public static RegistryHelper getInstance() {
        if (instance == null) {
            throw new IllegalStateException("RegistryHelper not initialized!");
        }
        return instance;
    }
    
    public static void setInstance(RegistryHelper helper) {
        if (instance != null) {
            throw new IllegalStateException("RegistryHelper already initialized!");
        }
        instance = helper;
    }
    
    protected final List<Runnable> registrationCallbacks = new ArrayList<>();
    
    /**
     * Register under the mod's namespace (copperagebackport:)
     */
    public <T> Supplier<T> register(ResourceKey<? extends Registry<? super T>> registry, String name, Supplier<T> supplier) {
        return registerWithNamespace(registry, Constants.MOD_ID, name, supplier);
    }

    /**
     * Register under the mod's namespace (copperagebackport:)
     */
    public <T> Holder<T> registerForHolder(ResourceKey<? extends Registry<? super T>> registry, String name, Supplier<T> supplier) {
        return registerWithNamespaceForHolder(registry, Constants.MOD_ID, name, supplier);
    }

    /**
     * Register under a specific namespace (minecraft: or copperagebackport:)
     */
    public abstract <T> Supplier<T> registerWithNamespace(ResourceKey<? extends Registry<? super T>> registry, String namespace, String name, Supplier<T> supplier);

    /**
     * Register under a specific namespace (minecraft: or copperagebackport:)
     */
    public abstract <T> Holder<T> registerWithNamespaceForHolder(ResourceKey<? extends Registry<? super T>> registry, String namespace, String name, Supplier<T> supplier);

    /**
     * Register a backported entry under the minecraft: namespace.
     */
    public <T> Supplier<T> registerAuto(ResourceKey<? extends Registry<? super T>> registry, String name, Supplier<T> supplier) {
        return registerWithNamespace(registry, MINECRAFT_NAMESPACE, name, supplier);
    }

    /**
     * Register a backported entry under the minecraft: namespace.
     */
    public <T> Holder<T> registerAutoForHolder(ResourceKey<? extends Registry<? super T>> registry, String name, Supplier<T> supplier) {
        return registerWithNamespaceForHolder(registry, MINECRAFT_NAMESPACE, name, supplier);
    }
    
    public void onRegisterComplete(Runnable callback) {
        registrationCallbacks.add(callback);
    }
    
    /**
     * Invokes any callbacks that were queued during registration. Loader-specific entrypoints
     * should call this once their registries have finished wiring up deferred references.
     */
    public void flushRegistrationCallbacks() {
        fireRegistrationCallbacks();
    }

    protected void fireRegistrationCallbacks() {
        registrationCallbacks.forEach(Runnable::run);
        Constants.LOG.info("Fired {} registration callbacks", registrationCallbacks.size());
    }

    /**
     * Fabric overrides this to rebuild minecraft: entries after Fabric's registry sync unmaps them.
     * Other loaders keep the default no-op implementation.
     */
    public void restoreVanillaNamespaceEntries() {
        // no-op
    }

    protected ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name);
    }
    
    protected ResourceLocation minecraftId(String name) {
        return ResourceLocation.withDefaultNamespace(name);
    }
    
    /**
     * Check if a name should be registered under minecraft: namespace
     */
    public static boolean isVanillaBackport(String name) {
        return VANILLA_BACKPORT_IDS.contains(name);
    }
}
