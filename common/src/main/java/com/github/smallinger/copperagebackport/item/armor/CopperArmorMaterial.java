package com.github.smallinger.copperagebackport.item.armor;

import com.github.smallinger.copperagebackport.Constants;
import com.github.smallinger.copperagebackport.ModSounds;
import com.google.common.base.Suppliers;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

/**
 * Copper armor material with stats between Leather and Chain.
 * Based on Minecraft 1.21.10 ArmorMaterials.COPPER:
 * - Durability Multiplier: 11 (Leather: 5, Chain: 15)
 * - Defense: Helmet=2, Chestplate=4, Leggings=3, Boots=1
 * - Enchantment Value: 8
 * - Toughness: 0.0
 * - Knockback Resistance: 0.0
 * - Repair: Copper Ingot
 */
public class CopperArmorMaterial {
    
    // Defense values
    private static final EnumMap<ArmorItem.Type, Integer> DEFENSE = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 1);
        map.put(ArmorItem.Type.LEGGINGS, 3);
        map.put(ArmorItem.Type.CHESTPLATE, 4);
        map.put(ArmorItem.Type.HELMET, 2);
        map.put(ArmorItem.Type.BODY, 4);
    });
    
    public static Supplier<Holder<ArmorMaterial>> COPPER;
    
    private static Holder<ArmorMaterial> createCopper() {
        ResourceLocation location = ResourceLocation.withDefaultNamespace("copper");
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));
        
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enummap.put(type, DEFENSE.get(type));
        }
        
        // Use our custom copper equip sound - defer the sound lookup
        Holder<SoundEvent> equipSound = Holder.direct(ModSounds.ARMOR_EQUIP_COPPER.get());
        
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(enummap, 8, equipSound, () -> Ingredient.of(Items.COPPER_INGOT), layers, 0.0F, 0.0F));
    }
    
    public static void init() {
        // Force static initialization and create the armor material supplier
        Constants.LOG.info("Registering Copper Armor Material for {}", Constants.MOD_NAME);
        // Memoize so createCopper() (which registers the armor material) runs only once,
        // even though 5 armor pieces each call COPPER.get().
        COPPER = Suppliers.memoize(CopperArmorMaterial::createCopper);
    }
}
