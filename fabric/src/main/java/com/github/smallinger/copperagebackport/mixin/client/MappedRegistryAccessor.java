package com.github.smallinger.copperagebackport.mixin.client;

import com.mojang.serialization.Lifecycle;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.Reference2IntMap;
import java.util.Map;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * Accessor for the mutable registry internals inside {@link MappedRegistry}.
 *
 * <p>This is used by the Fabric client disconnect fix to snapshot and restore
 * a coherent launch-time registry state without touching common/server-side
 * registration behavior.</p>
 */
@Mixin(MappedRegistry.class)
public interface MappedRegistryAccessor<T> {
    @Accessor("byId")
    ObjectList<Holder.Reference<T>> copperagebackport$getById();

    @Accessor("toId")
    Reference2IntMap<T> copperagebackport$getToId();

    @Accessor("byLocation")
    Map<
        ResourceLocation,
        Holder.Reference<T>
    > copperagebackport$getByLocation();

    @Accessor("byKey")
    Map<ResourceKey<T>, Holder.Reference<T>> copperagebackport$getByKey();

    @Accessor("byValue")
    Map<T, Holder.Reference<T>> copperagebackport$getByValue();

    @Accessor("registrationInfos")
    Map<
        ResourceKey<T>,
        RegistrationInfo
    > copperagebackport$getRegistrationInfos();

    @Accessor("tags")
    Map<TagKey<T>, HolderSet.Named<T>> copperagebackport$getTags();

    @Accessor("tags")
    void copperagebackport$setTags(Map<TagKey<T>, HolderSet.Named<T>> tags);

    @Accessor("registryLifecycle")
    Lifecycle copperagebackport$getRegistryLifecycle();

    @Accessor("registryLifecycle")
    void copperagebackport$setRegistryLifecycle(Lifecycle lifecycle);
}
