package com.github.smallinger.copperagebackport.registry;

import com.github.smallinger.copperagebackport.Constants;
import com.github.smallinger.copperagebackport.item.tools.CopperTier;
import com.github.smallinger.copperagebackport.platform.Services;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.core.Direction;

import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.ITEM;

/**
 * Handles registration of all items for the mod.
 */
public class ModItems {
    
    // Spawn Egg
    public static Supplier<Item> COPPER_GOLEM_SPAWN_EGG;
    
    // Copper Tools
    public static Supplier<AxeItem> COPPER_AXE;
    public static Supplier<PickaxeItem> COPPER_PICKAXE;
    public static Supplier<ShovelItem> COPPER_SHOVEL;
    public static Supplier<HoeItem> COPPER_HOE;
    public static Supplier<SwordItem> COPPER_SWORD;
    
    // Copper Materials
    public static Supplier<Item> COPPER_NUGGET;
    
    // Copper Armor
    public static Supplier<ArmorItem> COPPER_HELMET;
    public static Supplier<ArmorItem> COPPER_CHESTPLATE;
    public static Supplier<ArmorItem> COPPER_LEGGINGS;
    public static Supplier<ArmorItem> COPPER_BOOTS;
    public static Supplier<Item> COPPER_HORSE_ARMOR;
    
    // Copper Chest Items
    public static Supplier<BlockItem> COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_CHEST_ITEM;
    
    // Waxed Copper Chest Items
    public static Supplier<BlockItem> WAXED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_CHEST_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_CHEST_ITEM;
    
    // Copper Button Items
    public static Supplier<BlockItem> COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_BUTTON_ITEM;
    
    // Waxed Copper Button Items
    public static Supplier<BlockItem> WAXED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_BUTTON_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_BUTTON_ITEM;
    
    // Copper Golem Statue Items
    public static Supplier<BlockItem> COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_GOLEM_STATUE_ITEM;
    
    // Waxed Copper Golem Statue Items
    public static Supplier<BlockItem> WAXED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM;
    
    // Shelf Items
    public static Supplier<BlockItem> OAK_SHELF_ITEM;
    public static Supplier<BlockItem> BIRCH_SHELF_ITEM;
    public static Supplier<BlockItem> SPRUCE_SHELF_ITEM;
    public static Supplier<BlockItem> JUNGLE_SHELF_ITEM;
    public static Supplier<BlockItem> ACACIA_SHELF_ITEM;
    public static Supplier<BlockItem> DARK_OAK_SHELF_ITEM;
    public static Supplier<BlockItem> MANGROVE_SHELF_ITEM;
    public static Supplier<BlockItem> CHERRY_SHELF_ITEM;
    public static Supplier<BlockItem> BAMBOO_SHELF_ITEM;
    public static Supplier<BlockItem> CRIMSON_SHELF_ITEM;
    public static Supplier<BlockItem> WARPED_SHELF_ITEM;
    public static Supplier<BlockItem> PALE_OAK_SHELF_ITEM; // Requires VanillaBackport for crafting
    
    // Copper Torch Item
    public static Supplier<StandingAndWallBlockItem> COPPER_TORCH_ITEM;
    
    // Copper Lantern Items (Weathering)
    public static Supplier<BlockItem> COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_LANTERN_ITEM;
    
    // Waxed Copper Lantern Items
    public static Supplier<BlockItem> WAXED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_LANTERN_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_LANTERN_ITEM;
    
    // Copper Chain Items (Weathering)
    public static Supplier<BlockItem> COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_CHAIN_ITEM;
    
    // Waxed Copper Chain Items
    public static Supplier<BlockItem> WAXED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_CHAIN_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_CHAIN_ITEM;
    
    // Copper Bars Items (Weathering)
    public static Supplier<BlockItem> COPPER_BARS_ITEM;
    public static Supplier<BlockItem> EXPOSED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> WEATHERED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> OXIDIZED_COPPER_BARS_ITEM;
    
    // Waxed Copper Bars Items
    public static Supplier<BlockItem> WAXED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_COPPER_BARS_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_COPPER_BARS_ITEM;
    
    // Lightning Rod Items (Weathering) - vanilla lightning_rod is extended via Mixin
    // These are the new oxidized variants registered under minecraft: namespace
    public static Supplier<BlockItem> EXPOSED_LIGHTNING_ROD_ITEM;
    public static Supplier<BlockItem> WEATHERED_LIGHTNING_ROD_ITEM;
    public static Supplier<BlockItem> OXIDIZED_LIGHTNING_ROD_ITEM;
    
    // Waxed Lightning Rod Items
    public static Supplier<BlockItem> WAXED_LIGHTNING_ROD_ITEM;
    public static Supplier<BlockItem> WAXED_EXPOSED_LIGHTNING_ROD_ITEM;
    public static Supplier<BlockItem> WAXED_WEATHERED_LIGHTNING_ROD_ITEM;
    public static Supplier<BlockItem> WAXED_OXIDIZED_LIGHTNING_ROD_ITEM;

    public static void register() {
        Constants.LOG.info("Registering items for {}", Constants.MOD_NAME);
        
        RegistryHelper helper = RegistryHelper.getInstance();
        
        // Register Spawn Egg (platform-specific implementation)
        COPPER_GOLEM_SPAWN_EGG = helper.registerAuto(ITEM, "copper_golem_spawn_egg",
            ModItemHelper::createSpawnEggItem);
        
        // Register Copper Chest Items
        COPPER_CHEST_ITEM = helper.registerAuto(ITEM, "copper_chest",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.COPPER_CHEST.get(), new Item.Properties()));
        
        EXPOSED_COPPER_CHEST_ITEM = helper.registerAuto(ITEM, "exposed_copper_chest",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.EXPOSED_COPPER_CHEST.get(), new Item.Properties()));
        
        WEATHERED_COPPER_CHEST_ITEM = helper.registerAuto(ITEM, "weathered_copper_chest",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.WEATHERED_COPPER_CHEST.get(), new Item.Properties()));
        
        OXIDIZED_COPPER_CHEST_ITEM = helper.registerAuto(ITEM, "oxidized_copper_chest",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.OXIDIZED_COPPER_CHEST.get(), new Item.Properties()));
        
        // Register Waxed Copper Chest Items
        WAXED_COPPER_CHEST_ITEM = helper.registerAuto(ITEM, "waxed_copper_chest",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.WAXED_COPPER_CHEST.get(), new Item.Properties()));
        
        WAXED_EXPOSED_COPPER_CHEST_ITEM = helper.registerAuto(ITEM, "waxed_exposed_copper_chest",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get(), new Item.Properties()));
        
        WAXED_WEATHERED_COPPER_CHEST_ITEM = helper.registerAuto(ITEM, "waxed_weathered_copper_chest",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get(), new Item.Properties()));
        
        WAXED_OXIDIZED_COPPER_CHEST_ITEM = helper.registerAuto(ITEM, "waxed_oxidized_copper_chest",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get(), new Item.Properties()));
        
        // Register Copper Button Items (NOT in vanilla - stays at copperagebackport: namespace)
        COPPER_BUTTON_ITEM = helper.register(ITEM, "copper_button",
            () -> new BlockItem(ModBlocks.COPPER_BUTTON.get(), new Item.Properties()));
        
        EXPOSED_COPPER_BUTTON_ITEM = helper.register(ITEM, "exposed_copper_button",
            () -> new BlockItem(ModBlocks.EXPOSED_COPPER_BUTTON.get(), new Item.Properties()));
        
        WEATHERED_COPPER_BUTTON_ITEM = helper.register(ITEM, "weathered_copper_button",
            () -> new BlockItem(ModBlocks.WEATHERED_COPPER_BUTTON.get(), new Item.Properties()));
        
        OXIDIZED_COPPER_BUTTON_ITEM = helper.register(ITEM, "oxidized_copper_button",
            () -> new BlockItem(ModBlocks.OXIDIZED_COPPER_BUTTON.get(), new Item.Properties()));
        
        // Register Waxed Copper Button Items (NOT in vanilla - stays at copperagebackport: namespace)
        WAXED_COPPER_BUTTON_ITEM = helper.register(ITEM, "waxed_copper_button",
            () -> new BlockItem(ModBlocks.WAXED_COPPER_BUTTON.get(), new Item.Properties()));
        
        WAXED_EXPOSED_COPPER_BUTTON_ITEM = helper.register(ITEM, "waxed_exposed_copper_button",
            () -> new BlockItem(ModBlocks.WAXED_EXPOSED_COPPER_BUTTON.get(), new Item.Properties()));
        
        WAXED_WEATHERED_COPPER_BUTTON_ITEM = helper.register(ITEM, "waxed_weathered_copper_button",
            () -> new BlockItem(ModBlocks.WAXED_WEATHERED_COPPER_BUTTON.get(), new Item.Properties()));
        
        WAXED_OXIDIZED_COPPER_BUTTON_ITEM = helper.register(ITEM, "waxed_oxidized_copper_button",
            () -> new BlockItem(ModBlocks.WAXED_OXIDIZED_COPPER_BUTTON.get(), new Item.Properties()));
        
        // Register Copper Golem Statue Items
        COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(ITEM, "copper_golem_statue",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.COPPER_GOLEM_STATUE.get(), new Item.Properties()));
        
        EXPOSED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(ITEM, "exposed_copper_golem_statue",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.EXPOSED_COPPER_GOLEM_STATUE.get(), new Item.Properties()));
        
        WEATHERED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(ITEM, "weathered_copper_golem_statue",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.WEATHERED_COPPER_GOLEM_STATUE.get(), new Item.Properties()));
        
        OXIDIZED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(ITEM, "oxidized_copper_golem_statue",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.OXIDIZED_COPPER_GOLEM_STATUE.get(), new Item.Properties()));
        
        // Register Waxed Copper Golem Statue Items
        WAXED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(ITEM, "waxed_copper_golem_statue",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.WAXED_COPPER_GOLEM_STATUE.get(), new Item.Properties()));
        
        WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(ITEM, "waxed_exposed_copper_golem_statue",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.WAXED_EXPOSED_COPPER_GOLEM_STATUE.get(), new Item.Properties()));
        
        WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(ITEM, "waxed_weathered_copper_golem_statue",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.WAXED_WEATHERED_COPPER_GOLEM_STATUE.get(), new Item.Properties()));
        
        WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM = helper.registerAuto(ITEM, "waxed_oxidized_copper_golem_statue",
            () -> ModItemHelper.create3DBlockItemForPlatform(ModBlocks.WAXED_OXIDIZED_COPPER_GOLEM_STATUE.get(), new Item.Properties()));
        
        // Register Shelf Items
        OAK_SHELF_ITEM = helper.registerAuto(ITEM, "oak_shelf",
            () -> new BlockItem(ModBlocks.OAK_SHELF.get(), new Item.Properties()));
        
        BIRCH_SHELF_ITEM = helper.registerAuto(ITEM, "birch_shelf",
            () -> new BlockItem(ModBlocks.BIRCH_SHELF.get(), new Item.Properties()));
        
        SPRUCE_SHELF_ITEM = helper.registerAuto(ITEM, "spruce_shelf",
            () -> new BlockItem(ModBlocks.SPRUCE_SHELF.get(), new Item.Properties()));
        
        JUNGLE_SHELF_ITEM = helper.registerAuto(ITEM, "jungle_shelf",
            () -> new BlockItem(ModBlocks.JUNGLE_SHELF.get(), new Item.Properties()));
        
        ACACIA_SHELF_ITEM = helper.registerAuto(ITEM, "acacia_shelf",
            () -> new BlockItem(ModBlocks.ACACIA_SHELF.get(), new Item.Properties()));
        
        DARK_OAK_SHELF_ITEM = helper.registerAuto(ITEM, "dark_oak_shelf",
            () -> new BlockItem(ModBlocks.DARK_OAK_SHELF.get(), new Item.Properties()));
        
        MANGROVE_SHELF_ITEM = helper.registerAuto(ITEM, "mangrove_shelf",
            () -> new BlockItem(ModBlocks.MANGROVE_SHELF.get(), new Item.Properties()));
        
        CHERRY_SHELF_ITEM = helper.registerAuto(ITEM, "cherry_shelf",
            () -> new BlockItem(ModBlocks.CHERRY_SHELF.get(), new Item.Properties()));
        
        BAMBOO_SHELF_ITEM = helper.registerAuto(ITEM, "bamboo_shelf",
            () -> new BlockItem(ModBlocks.BAMBOO_SHELF.get(), new Item.Properties()));
        
        CRIMSON_SHELF_ITEM = helper.registerAuto(ITEM, "crimson_shelf",
            () -> new BlockItem(ModBlocks.CRIMSON_SHELF.get(), new Item.Properties()));
        
        WARPED_SHELF_ITEM = helper.registerAuto(ITEM, "warped_shelf",
            () -> new BlockItem(ModBlocks.WARPED_SHELF.get(), new Item.Properties()));
        PALE_OAK_SHELF_ITEM = helper.registerAuto(ITEM, "pale_oak_shelf",
            () -> new BlockItem(ModBlocks.PALE_OAK_SHELF.get(), new Item.Properties()));
        
        // Register Copper Torch Item
        COPPER_TORCH_ITEM = helper.registerAuto(ITEM, "copper_torch",
            () -> new StandingAndWallBlockItem(
                ModBlocks.COPPER_TORCH.get(),
                ModBlocks.COPPER_WALL_TORCH.get(),
                new Item.Properties(),
                Direction.DOWN));

        // Register Copper Lantern Items (Weathering)
        COPPER_LANTERN_ITEM = helper.registerAuto(ITEM, "copper_lantern",
            () -> new BlockItem(ModBlocks.COPPER_LANTERN.get(), new Item.Properties()));
        
        EXPOSED_COPPER_LANTERN_ITEM = helper.registerAuto(ITEM, "exposed_copper_lantern",
            () -> new BlockItem(ModBlocks.EXPOSED_COPPER_LANTERN.get(), new Item.Properties()));
        
        WEATHERED_COPPER_LANTERN_ITEM = helper.registerAuto(ITEM, "weathered_copper_lantern",
            () -> new BlockItem(ModBlocks.WEATHERED_COPPER_LANTERN.get(), new Item.Properties()));
        
        OXIDIZED_COPPER_LANTERN_ITEM = helper.registerAuto(ITEM, "oxidized_copper_lantern",
            () -> new BlockItem(ModBlocks.OXIDIZED_COPPER_LANTERN.get(), new Item.Properties()));
        
        // Register Waxed Copper Lantern Items
        WAXED_COPPER_LANTERN_ITEM = helper.registerAuto(ITEM, "waxed_copper_lantern",
            () -> new BlockItem(ModBlocks.WAXED_COPPER_LANTERN.get(), new Item.Properties()));
        
        WAXED_EXPOSED_COPPER_LANTERN_ITEM = helper.registerAuto(ITEM, "waxed_exposed_copper_lantern",
            () -> new BlockItem(ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get(), new Item.Properties()));
        
        WAXED_WEATHERED_COPPER_LANTERN_ITEM = helper.registerAuto(ITEM, "waxed_weathered_copper_lantern",
            () -> new BlockItem(ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get(), new Item.Properties()));
        
        WAXED_OXIDIZED_COPPER_LANTERN_ITEM = helper.registerAuto(ITEM, "waxed_oxidized_copper_lantern",
            () -> new BlockItem(ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get(), new Item.Properties()));
        
        // Register Copper Chain Items (Weathering)
        COPPER_CHAIN_ITEM = helper.registerAuto(ITEM, "copper_chain",
            () -> new BlockItem(ModBlocks.COPPER_CHAIN.get(), new Item.Properties()));
        
        EXPOSED_COPPER_CHAIN_ITEM = helper.registerAuto(ITEM, "exposed_copper_chain",
            () -> new BlockItem(ModBlocks.EXPOSED_COPPER_CHAIN.get(), new Item.Properties()));
        
        WEATHERED_COPPER_CHAIN_ITEM = helper.registerAuto(ITEM, "weathered_copper_chain",
            () -> new BlockItem(ModBlocks.WEATHERED_COPPER_CHAIN.get(), new Item.Properties()));
        
        OXIDIZED_COPPER_CHAIN_ITEM = helper.registerAuto(ITEM, "oxidized_copper_chain",
            () -> new BlockItem(ModBlocks.OXIDIZED_COPPER_CHAIN.get(), new Item.Properties()));
        
        // Register Waxed Copper Chain Items
        WAXED_COPPER_CHAIN_ITEM = helper.registerAuto(ITEM, "waxed_copper_chain",
            () -> new BlockItem(ModBlocks.WAXED_COPPER_CHAIN.get(), new Item.Properties()));
        
        WAXED_EXPOSED_COPPER_CHAIN_ITEM = helper.registerAuto(ITEM, "waxed_exposed_copper_chain",
            () -> new BlockItem(ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get(), new Item.Properties()));
        
        WAXED_WEATHERED_COPPER_CHAIN_ITEM = helper.registerAuto(ITEM, "waxed_weathered_copper_chain",
            () -> new BlockItem(ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get(), new Item.Properties()));
        
        WAXED_OXIDIZED_COPPER_CHAIN_ITEM = helper.registerAuto(ITEM, "waxed_oxidized_copper_chain",
            () -> new BlockItem(ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get(), new Item.Properties()));
        
        // Register Copper Bars Items (Weathering)
        COPPER_BARS_ITEM = helper.registerAuto(ITEM, "copper_bars",
            () -> new BlockItem(ModBlocks.COPPER_BARS.get(), new Item.Properties()));
        
        EXPOSED_COPPER_BARS_ITEM = helper.registerAuto(ITEM, "exposed_copper_bars",
            () -> new BlockItem(ModBlocks.EXPOSED_COPPER_BARS.get(), new Item.Properties()));
        
        WEATHERED_COPPER_BARS_ITEM = helper.registerAuto(ITEM, "weathered_copper_bars",
            () -> new BlockItem(ModBlocks.WEATHERED_COPPER_BARS.get(), new Item.Properties()));
        
        OXIDIZED_COPPER_BARS_ITEM = helper.registerAuto(ITEM, "oxidized_copper_bars",
            () -> new BlockItem(ModBlocks.OXIDIZED_COPPER_BARS.get(), new Item.Properties()));
        
        // Register Waxed Copper Bars Items
        WAXED_COPPER_BARS_ITEM = helper.registerAuto(ITEM, "waxed_copper_bars",
            () -> new BlockItem(ModBlocks.WAXED_COPPER_BARS.get(), new Item.Properties()));
        
        WAXED_EXPOSED_COPPER_BARS_ITEM = helper.registerAuto(ITEM, "waxed_exposed_copper_bars",
            () -> new BlockItem(ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(), new Item.Properties()));
        
        WAXED_WEATHERED_COPPER_BARS_ITEM = helper.registerAuto(ITEM, "waxed_weathered_copper_bars",
            () -> new BlockItem(ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(), new Item.Properties()));
        
        WAXED_OXIDIZED_COPPER_BARS_ITEM = helper.registerAuto(ITEM, "waxed_oxidized_copper_bars",
            () -> new BlockItem(ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get(), new Item.Properties()));
        
        // Register Lightning Rod Items (Weathering)
        // Vanilla minecraft:lightning_rod is extended via Mixin, these are the new oxidized variants
        EXPOSED_LIGHTNING_ROD_ITEM = helper.registerAuto(ITEM, "exposed_lightning_rod",
            () -> new BlockItem(ModBlocks.EXPOSED_LIGHTNING_ROD.get(), new Item.Properties()));
        
        WEATHERED_LIGHTNING_ROD_ITEM = helper.registerAuto(ITEM, "weathered_lightning_rod",
            () -> new BlockItem(ModBlocks.WEATHERED_LIGHTNING_ROD.get(), new Item.Properties()));
        
        OXIDIZED_LIGHTNING_ROD_ITEM = helper.registerAuto(ITEM, "oxidized_lightning_rod",
            () -> new BlockItem(ModBlocks.OXIDIZED_LIGHTNING_ROD.get(), new Item.Properties()));
        
        // Register Waxed Lightning Rod Items
        WAXED_LIGHTNING_ROD_ITEM = helper.registerAuto(ITEM, "waxed_lightning_rod",
            () -> new BlockItem(ModBlocks.WAXED_LIGHTNING_ROD.get(), new Item.Properties()));
        
        WAXED_EXPOSED_LIGHTNING_ROD_ITEM = helper.registerAuto(ITEM, "waxed_exposed_lightning_rod",
            () -> new BlockItem(ModBlocks.WAXED_EXPOSED_LIGHTNING_ROD.get(), new Item.Properties()));
        
        WAXED_WEATHERED_LIGHTNING_ROD_ITEM = helper.registerAuto(ITEM, "waxed_weathered_lightning_rod",
            () -> new BlockItem(ModBlocks.WAXED_WEATHERED_LIGHTNING_ROD.get(), new Item.Properties()));
        
        WAXED_OXIDIZED_LIGHTNING_ROD_ITEM = helper.registerAuto(ITEM, "waxed_oxidized_lightning_rod",
            () -> new BlockItem(ModBlocks.WAXED_OXIDIZED_LIGHTNING_ROD.get(), new Item.Properties()));

        // Register Copper Tools
        // Copper Axe: 7.0 base attack damage + 1.0 material bonus = 8 total, -3.2 attack speed
        COPPER_AXE = helper.registerAuto(ITEM, "copper_axe",
            () -> new AxeItem(CopperTier.INSTANCE, new Item.Properties().stacksTo(1).attributes(AxeItem.createAttributes(CopperTier.INSTANCE, 7.0F, -3.2F))));
        
        // Copper Pickaxe: 1.0 base attack damage, -2.8 attack speed
        COPPER_PICKAXE = helper.registerAuto(ITEM, "copper_pickaxe",
            () -> new PickaxeItem(CopperTier.INSTANCE, new Item.Properties().stacksTo(1).attributes(PickaxeItem.createAttributes(CopperTier.INSTANCE, 1.0F, -2.8F))));
        
        // Copper Shovel: 1.5 base attack damage, -3.0 attack speed
        COPPER_SHOVEL = helper.registerAuto(ITEM, "copper_shovel",
            () -> new ShovelItem(CopperTier.INSTANCE, new Item.Properties().stacksTo(1).attributes(ShovelItem.createAttributes(CopperTier.INSTANCE, 1.5F, -3.0F))));
        
        // Copper Hoe: -1.0 base attack damage, -2.0 attack speed (official MC 1.21.10 values)
        COPPER_HOE = helper.registerAuto(ITEM, "copper_hoe",
            () -> new HoeItem(CopperTier.INSTANCE, new Item.Properties().stacksTo(1).attributes(HoeItem.createAttributes(CopperTier.INSTANCE, -1.0F, -2.0F))));
        
        // Copper Sword: 3.0 base attack damage, -2.4 attack speed
        COPPER_SWORD = helper.registerAuto(ITEM, "copper_sword",
            () -> new SwordItem(CopperTier.INSTANCE, new Item.Properties().stacksTo(1).attributes(SwordItem.createAttributes(CopperTier.INSTANCE, 3, -2.4F))));
        
        // Copper Nugget
        COPPER_NUGGET = helper.registerAuto(ITEM, "copper_nugget",
            () -> new Item(new Item.Properties()));
        
        // Copper Armor
        COPPER_HELMET = helper.registerAuto(ITEM, "copper_helmet",
            () -> new ArmorItem(com.github.smallinger.copperagebackport.item.armor.CopperArmorMaterial.COPPER.get(), ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(ArmorItem.Type.HELMET.getDurability(11))));
        
        COPPER_CHESTPLATE = helper.registerAuto(ITEM, "copper_chestplate",
            () -> new ArmorItem(com.github.smallinger.copperagebackport.item.armor.CopperArmorMaterial.COPPER.get(), ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(ArmorItem.Type.CHESTPLATE.getDurability(11))));
        
        COPPER_LEGGINGS = helper.registerAuto(ITEM, "copper_leggings",
            () -> new ArmorItem(com.github.smallinger.copperagebackport.item.armor.CopperArmorMaterial.COPPER.get(), ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(ArmorItem.Type.LEGGINGS.getDurability(11))));
        
        COPPER_BOOTS = helper.registerAuto(ITEM, "copper_boots",
            () -> new ArmorItem(com.github.smallinger.copperagebackport.item.armor.CopperArmorMaterial.COPPER.get(), ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(ArmorItem.Type.BOOTS.getDurability(11))));
        
        // Copper Horse Armor: 4 protection (between leather 3 and iron 5)
        // 1.21.1 uses AnimalArmorItem which derives texture path from ArmorMaterial key (copperagebackport:copper)
        // -> automatically looks for: copperagebackport:textures/entity/horse/armor/horse_armor_copper.png
        // Note: 1.20.1 uses custom CopperHorseArmorItem class because HorseArmorItem only supports minecraft namespace
        COPPER_HORSE_ARMOR = helper.registerAuto(ITEM, "copper_horse_armor",
            () -> new AnimalArmorItem(com.github.smallinger.copperagebackport.item.armor.CopperArmorMaterial.COPPER.get(), AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));
    }
}
