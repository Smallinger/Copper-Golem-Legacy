package com.github.smallinger.copperagebackport.neoforge.client;

import com.github.smallinger.copperagebackport.Constants;
import com.github.smallinger.copperagebackport.client.gui.ConfigScreen;
import com.github.smallinger.copperagebackport.registry.ModBlocks;
import com.github.smallinger.copperagebackport.registry.ModParticles;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

/**
 * Client-only setup for NeoForge.
 */
@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class CopperAgeBackportNeoForgeClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ModContainer modContainer = ModList.get().getModContainerById(Constants.MOD_ID).orElseThrow();
            modContainer.registerExtensionPoint(IConfigScreenFactory.class,
                (mc, parent) -> ConfigScreen.create(parent));

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_TORCH.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_WALL_TORCH.get(), RenderType.cutout());
            
            // Copper Lantern cutout render layers
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_COPPER_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_COPPER_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.OXIDIZED_COPPER_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_COPPER_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get(), RenderType.cutout());
            
            // Copper Chain cutout render layers
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_CHAIN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_COPPER_CHAIN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_COPPER_CHAIN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.OXIDIZED_COPPER_CHAIN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_COPPER_CHAIN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get(), RenderType.cutout());
            
            // Copper Bars cutout render layers
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_BARS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_COPPER_BARS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_COPPER_BARS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.OXIDIZED_COPPER_BARS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_COPPER_BARS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get(), RenderType.cutout());
        });
    }
    
    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.COPPER_FIRE_FLAME.get(), FlameParticle.Provider::new);
    }
}
