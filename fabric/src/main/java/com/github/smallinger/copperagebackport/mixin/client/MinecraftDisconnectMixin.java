package com.github.smallinger.copperagebackport.mixin.client;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Intentionally left empty.
 *
 * The previous client disconnect hook attempted to restore minecraft namespace
 * registry entries before Fabric's own disconnect-time registry unmap logic
 * ran. That client-side restore was mutating registry state during disconnect
 * and is disabled so the vanilla/Fabric disconnect flow can proceed normally.
 */
@Mixin(Minecraft.class)
public abstract class MinecraftDisconnectMixin {}
