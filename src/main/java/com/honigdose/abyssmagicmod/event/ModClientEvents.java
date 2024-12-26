package com.honigdose.abyssmagicmod.event;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import com.honigdose.abyssmagicmod.particle.custom.CuteCrystalParticle;
import com.honigdose.abyssmagicmod.particle.custom.ScarletLeavesParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AbyssMagicMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void registerParticle(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(
                ModParticles.SCARLET_LEAVES_PARTICLE.get(),
                ScarletLeavesParticle.Provider::new
        );
        Minecraft.getInstance().particleEngine.register(
                ModParticles.CUTE_CRYSTAL_PARTICLE.get(),
                CuteCrystalParticle.Provider::new
        );
    }

}