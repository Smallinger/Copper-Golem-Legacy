package com.github.smallinger.copperagebackport.mixin.client;

import com.github.smallinger.copperagebackport.Constants;
import com.github.smallinger.copperagebackport.fabric.client.ClientRegistryLaunchState;
import net.fabricmc.fabric.impl.registry.sync.RegistrySyncManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Restores the client's built-in registry raw-id tables to their launch-time
 * state before Fabric performs disconnect-time unmapping.
 *
 * <p>This mod intentionally adds backported content under the {@code minecraft:}
 * namespace. On Fabric/Quilt 1.21.1, disconnect-time registry unmapping can
 * crash if a registry's raw-id table contains stale/null entries after a remote
 * remap. A full game restart works because registries start from a clean launch
 * state again. This mixin emulates that client-side reset right before Fabric's
 * unmap logic runs.</p>
 */
@Mixin(RegistrySyncManager.class)
public abstract class RegistrySyncManagerMixin {

    @Inject(method = "unmap", at = @At("HEAD"), remap = false)
    private static void copperagebackport$restoreLaunchRegistryState(
        CallbackInfo ci
    ) {
        try {
            ClientRegistryLaunchState.restoreLaunchState();
        } catch (Throwable throwable) {
            Constants.LOG.error(
                "Failed to restore client registry launch state before Fabric unmap",
                throwable
            );
        }
    }
}
