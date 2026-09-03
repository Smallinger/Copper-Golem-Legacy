package com.github.smallinger.copperagebackport;

import com.github.smallinger.copperagebackport.registry.RegistryHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class ModSounds {
    
    // Copper Golem sounds - Unaffected (Regular)
    public static Supplier<SoundEvent> COPPER_GOLEM_DEATH_UNAFFECTED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HURT_UNAFFECTED;
    public static Supplier<SoundEvent> COPPER_GOLEM_STEP_UNAFFECTED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HEAD_SPIN_UNAFFECTED;
    
    // Copper Golem sounds - Exposed
    public static Supplier<SoundEvent> COPPER_GOLEM_DEATH_EXPOSED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HURT_EXPOSED;
    public static Supplier<SoundEvent> COPPER_GOLEM_STEP_EXPOSED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HEAD_SPIN_EXPOSED;
    
    // Copper Golem sounds - Weathered
    public static Supplier<SoundEvent> COPPER_GOLEM_DEATH_WEATHERED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HURT_WEATHERED;
    public static Supplier<SoundEvent> COPPER_GOLEM_STEP_WEATHERED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HEAD_SPIN_WEATHERED;
    
    // Copper Golem sounds - Oxidized
    public static Supplier<SoundEvent> COPPER_GOLEM_DEATH_OXIDIZED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HURT_OXIDIZED;
    public static Supplier<SoundEvent> COPPER_GOLEM_STEP_OXIDIZED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HEAD_SPIN_OXIDIZED;
    
    // Copper Golem sounds - General
    public static Supplier<SoundEvent> COPPER_GOLEM_SPAWN;
    public static Supplier<SoundEvent> COPPER_GOLEM_BECOME_STATUE;
    public static Supplier<SoundEvent> COPPER_GOLEM_SHEAR;
    
    // Copper Golem sounds - Item Interaction
    public static Supplier<SoundEvent> COPPER_GOLEM_ITEM_DROP;
    public static Supplier<SoundEvent> COPPER_GOLEM_ITEM_NO_DROP;
    public static Supplier<SoundEvent> COPPER_GOLEM_ITEM_GET;
    public static Supplier<SoundEvent> COPPER_GOLEM_ITEM_NO_GET;
    
    // Copper Chest sounds
    public static Supplier<SoundEvent> COPPER_CHEST_CLOSE;
    public static Supplier<SoundEvent> COPPER_CHEST_OPEN;
    
    // Copper Statue sounds
    public static Supplier<SoundEvent> COPPER_STATUE_BREAK;
    public static Supplier<SoundEvent> COPPER_STATUE_PLACE;
    public static Supplier<SoundEvent> COPPER_STATUE_HIT;
    public static Supplier<SoundEvent> COPPER_STATUE_BECOME;
    
    // Shelf sounds
    public static Supplier<SoundEvent> SHELF_ACTIVATE;
    public static Supplier<SoundEvent> SHELF_DEACTIVATE;
    public static Supplier<SoundEvent> SHELF_PLACE_ITEM;
    public static Supplier<SoundEvent> SHELF_TAKE_ITEM;
    public static Supplier<SoundEvent> SHELF_SINGLE_SWAP;
    public static Supplier<SoundEvent> SHELF_MULTI_SWAP;
    
    // Armor sounds
    public static Holder<SoundEvent> ARMOR_EQUIP_COPPER;
    
    // Weather sounds (End Flash)
    public static Supplier<SoundEvent> WEATHER_END_FLASH;

    public static void register() {
        Constants.LOG.info("Registering sounds for {}", Constants.MOD_NAME);
        
        RegistryHelper helper = RegistryHelper.getInstance();
        
        // Register Copper Golem sounds - Unaffected
        COPPER_GOLEM_DEATH_UNAFFECTED = registerSound(helper, "entity.copper_golem.death.unaffected");
        COPPER_GOLEM_HURT_UNAFFECTED = registerSound(helper, "entity.copper_golem.hurt.unaffected");
        COPPER_GOLEM_STEP_UNAFFECTED = registerSound(helper, "entity.copper_golem.step.unaffected");
        COPPER_GOLEM_HEAD_SPIN_UNAFFECTED = registerSound(helper, "entity.copper_golem.head_spin.unaffected");
        
        // Register Copper Golem sounds - Exposed
        COPPER_GOLEM_DEATH_EXPOSED = registerSound(helper, "entity.copper_golem.death.exposed");
        COPPER_GOLEM_HURT_EXPOSED = registerSound(helper, "entity.copper_golem.hurt.exposed");
        COPPER_GOLEM_STEP_EXPOSED = registerSound(helper, "entity.copper_golem.step.exposed");
        COPPER_GOLEM_HEAD_SPIN_EXPOSED = registerSound(helper, "entity.copper_golem.head_spin.exposed");
        
        // Register Copper Golem sounds - Weathered
        COPPER_GOLEM_DEATH_WEATHERED = registerSound(helper, "entity.copper_golem.death.weathered");
        COPPER_GOLEM_HURT_WEATHERED = registerSound(helper, "entity.copper_golem.hurt.weathered");
        COPPER_GOLEM_STEP_WEATHERED = registerSound(helper, "entity.copper_golem.step.weathered");
        COPPER_GOLEM_HEAD_SPIN_WEATHERED = registerSound(helper, "entity.copper_golem.head_spin.weathered");
        
        // Register Copper Golem sounds - Oxidized
        COPPER_GOLEM_DEATH_OXIDIZED = registerSound(helper, "entity.copper_golem.death.oxidized");
        COPPER_GOLEM_HURT_OXIDIZED = registerSound(helper, "entity.copper_golem.hurt.oxidized");
        COPPER_GOLEM_STEP_OXIDIZED = registerSound(helper, "entity.copper_golem.step.oxidized");
        COPPER_GOLEM_HEAD_SPIN_OXIDIZED = registerSound(helper, "entity.copper_golem.head_spin.oxidized");
        
        // Register Copper Golem sounds - General
        COPPER_GOLEM_SPAWN = registerSound(helper, "entity.copper_golem.spawn");
        COPPER_GOLEM_BECOME_STATUE = registerSound(helper, "entity.copper_golem.become_statue");
        COPPER_GOLEM_SHEAR = registerSound(helper, "entity.copper_golem.shear");
        
        // Register Copper Golem sounds - Item Interaction
        COPPER_GOLEM_ITEM_DROP = registerSound(helper, "entity.copper_golem.item_drop");
        COPPER_GOLEM_ITEM_NO_DROP = registerSound(helper, "entity.copper_golem.item_no_drop");
        COPPER_GOLEM_ITEM_GET = registerSound(helper, "entity.copper_golem.no_item_get");
        COPPER_GOLEM_ITEM_NO_GET = registerSound(helper, "entity.copper_golem.no_item_no_get");
        
        // Register Copper Chest sounds
        COPPER_CHEST_CLOSE = registerSound(helper, "block.copper_chest.close");
        COPPER_CHEST_OPEN = registerSound(helper, "block.copper_chest.open");
        
        // Register Copper Statue sounds
        COPPER_STATUE_BREAK = registerSound(helper, "block.copper_statue.break");
        COPPER_STATUE_PLACE = registerSound(helper, "block.copper_statue.place");
        COPPER_STATUE_HIT = registerSound(helper, "block.copper_statue.hit");
        COPPER_STATUE_BECOME = registerSound(helper, "block.copper_statue.become_statue");
        
        // Register Shelf sounds
        SHELF_ACTIVATE = registerSound(helper, "block.shelf.activate");
        SHELF_DEACTIVATE = registerSound(helper, "block.shelf.deactivate");
        SHELF_PLACE_ITEM = registerSound(helper, "block.shelf.place_item");
        SHELF_TAKE_ITEM = registerSound(helper, "block.shelf.take_item");
        SHELF_SINGLE_SWAP = registerSound(helper, "block.shelf.single_swap");
        SHELF_MULTI_SWAP = registerSound(helper, "block.shelf.multi_swap");
        
        // Register Armor sounds
        ARMOR_EQUIP_COPPER = registerSoundforHolder(helper, "item.armor.equip_copper");
        
        // Register Weather sounds (End Flash)
        WEATHER_END_FLASH = registerSound(helper, "weather.end_flash");
    }

    private static Supplier<SoundEvent> registerSound(RegistryHelper helper, String name) {
        // Register sounds under minecraft: namespace since they are vanilla backport features
        ResourceLocation id = ResourceLocation.withDefaultNamespace(name);
        return helper.registerAuto(Registries.SOUND_EVENT, name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    private static Holder<SoundEvent> registerSoundforHolder(RegistryHelper helper, String name) {
        // Register sounds under minecraft: namespace since they are vanilla backport features
        ResourceLocation id = ResourceLocation.withDefaultNamespace(name);
        return helper.registerAutoForHolder(Registries.SOUND_EVENT, name, () -> SoundEvent.createVariableRangeEvent(id));
    }
}
