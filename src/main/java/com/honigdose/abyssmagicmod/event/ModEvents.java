package com.honigdose.abyssmagicmod.event;

import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.particle.ModParticles;
import com.honigdose.abyssmagicmod.particle.custom.ScarletLeavesParticle;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AbyssMagicMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEvents {

    public static void registerParticles(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(
                ModParticles.SCARLET_LEAVES_PARTICLE.get(),
                ScarletLeavesParticle.Provider::new
        );
    }
}