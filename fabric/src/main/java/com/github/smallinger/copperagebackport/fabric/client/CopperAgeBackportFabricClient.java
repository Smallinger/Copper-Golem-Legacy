package com.github.smallinger.copperagebackport.fabric.client;

import com.github.smallinger.copperagebackport.client.model.CopperGolemModel;
import com.github.smallinger.copperagebackport.client.renderer.CopperChestRenderer;
import com.github.smallinger.copperagebackport.client.renderer.CopperGolemRenderer;
import com.github.smallinger.copperagebackport.client.renderer.CopperGolemStatueRenderer;
import com.github.smallinger.copperagebackport.client.renderer.CopperItemRenderer;
import com.github.smallinger.copperagebackport.client.renderer.ShelfRenderer;
import com.github.smallinger.copperagebackport.fabric.client.ClientRegistryLaunchState;
import com.github.smallinger.copperagebackport.registry.ModBlockEntities;
import com.github.smallinger.copperagebackport.registry.ModBlocks;
import com.github.smallinger.copperagebackport.registry.ModEntities;
import com.github.smallinger.copperagebackport.registry.ModItems;
import com.github.smallinger.copperagebackport.registry.ModParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.registry.RegistryIdRemapCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

/**
 * Fabric client initializer responsible for all renderer registrations.
 */
public class CopperAgeBackportFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerParticles();
        registerModelLayers();
        registerRenderers();
        register3DItemRenderers();
        registerBlockRenderLayers();
        registerRegistryRemapCallbacks();
        ClientLifecycleEvents.CLIENT_STARTED.register(client ->
            ClientRegistryLaunchState.captureLaunchState()
        );
    }

    private void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(
            ModParticles.COPPER_FIRE_FLAME.get(),
            FlameParticle.Provider::new
        );
    }

    private void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(
            CopperGolemModel.LAYER_LOCATION,
            CopperGolemModel::createBodyLayer
        );
        EntityModelLayerRegistry.registerModelLayer(
            CopperGolemModel.STATUE_STANDING,
            CopperGolemModel::createStandingStatueBodyLayer
        );
        EntityModelLayerRegistry.registerModelLayer(
            CopperGolemModel.STATUE_RUNNING,
            CopperGolemModel::createRunningPoseBodyLayer
        );
        EntityModelLayerRegistry.registerModelLayer(
            CopperGolemModel.STATUE_SITTING,
            CopperGolemModel::createSittingPoseBodyLayer
        );
        EntityModelLayerRegistry.registerModelLayer(
            CopperGolemModel.STATUE_STAR,
            CopperGolemModel::createStarPoseBodyLayer
        );
    }

    private void registerRenderers() {
        EntityRendererRegistry.register(
            ModEntities.COPPER_GOLEM.get(),
            CopperGolemRenderer::new
        );
        BlockEntityRenderers.register(
            ModBlockEntities.COPPER_CHEST_BLOCK_ENTITY.get(),
            CopperChestRenderer::new
        );
        BlockEntityRenderers.register(
            ModBlockEntities.COPPER_GOLEM_STATUE_BLOCK_ENTITY.get(),
            CopperGolemStatueRenderer::new
        );
        BlockEntityRenderers.register(
            ModBlockEntities.SHELF_BLOCK_ENTITY.get(),
            ShelfRenderer::new
        );
    }

    private void register3DItemRenderers() {
        CopperItemRenderer renderer = new CopperItemRenderer();
        BuiltinItemRendererRegistry.DynamicItemRenderer dynamicRenderer =
            renderer::renderByItem;

        // Chest items
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.COPPER_CHEST_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.EXPOSED_COPPER_CHEST_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.WEATHERED_COPPER_CHEST_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.OXIDIZED_COPPER_CHEST_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.WAXED_COPPER_CHEST_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.WAXED_EXPOSED_COPPER_CHEST_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.WAXED_WEATHERED_COPPER_CHEST_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.WAXED_OXIDIZED_COPPER_CHEST_ITEM.get(),
            dynamicRenderer
        );

        // Statue items
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.COPPER_GOLEM_STATUE_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.EXPOSED_COPPER_GOLEM_STATUE_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.WEATHERED_COPPER_GOLEM_STATUE_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.WAXED_COPPER_GOLEM_STATUE_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM.get(),
            dynamicRenderer
        );
        BuiltinItemRendererRegistry.INSTANCE.register(
            ModItems.WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get(),
            dynamicRenderer
        );
    }

    private void registerBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderType.cutout(),
            ModBlocks.COPPER_TORCH.get(),
            ModBlocks.COPPER_WALL_TORCH.get(),
            // Copper Lanterns
            ModBlocks.COPPER_LANTERN.get(),
            ModBlocks.EXPOSED_COPPER_LANTERN.get(),
            ModBlocks.WEATHERED_COPPER_LANTERN.get(),
            ModBlocks.OXIDIZED_COPPER_LANTERN.get(),
            ModBlocks.WAXED_COPPER_LANTERN.get(),
            ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get(),
            ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get(),
            ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get(),
            // Copper Chains
            ModBlocks.COPPER_CHAIN.get(),
            ModBlocks.EXPOSED_COPPER_CHAIN.get(),
            ModBlocks.WEATHERED_COPPER_CHAIN.get(),
            ModBlocks.OXIDIZED_COPPER_CHAIN.get(),
            ModBlocks.WAXED_COPPER_CHAIN.get(),
            ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get(),
            ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get(),
            ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get(),
            // Copper Bars
            ModBlocks.COPPER_BARS.get(),
            ModBlocks.EXPOSED_COPPER_BARS.get(),
            ModBlocks.WEATHERED_COPPER_BARS.get(),
            ModBlocks.OXIDIZED_COPPER_BARS.get(),
            ModBlocks.WAXED_COPPER_BARS.get(),
            ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(),
            ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(),
            ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get()
        );
    }

    private void registerRegistryRemapCallbacks() {
        RegistryIdRemapCallback.event(BuiltInRegistries.ITEM).register(
            state -> {
                Minecraft minecraft = Minecraft.getInstance();
                minecraft.execute(this::rebuildItemModelShaper);
            }
        );
    }

    private void rebuildItemModelShaper() {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.getItemRenderer() == null) {
            return;
        }

        var itemModelShaper = minecraft.getItemRenderer().getItemModelShaper();

        for (Item item : BuiltInRegistries.ITEM) {
            if (item == Items.AIR) {
                continue;
            }

            itemModelShaper.register(
                item,
                ModelResourceLocation.inventory(
                    BuiltInRegistries.ITEM.getKey(item)
                )
            );
        }

        itemModelShaper.rebuildCache();
    }
}
