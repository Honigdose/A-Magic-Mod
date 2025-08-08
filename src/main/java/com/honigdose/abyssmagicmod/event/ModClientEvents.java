package com.honigdose.abyssmagicmod.event;




import com.honigdose.abyssmagicmod.AbyssMagicMod;
import com.honigdose.abyssmagicmod.light.DynamicLightsManager;
import com.honigdose.abyssmagicmod.light.IDynamicLightSource;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AbyssMagicMod.MOD_ID, value = Dist.CLIENT, bus   = Mod.EventBusSubscriber.Bus.FORGE
)
public class ModClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        // am Ende jedes Client-Ticks die Light-Manager-Routine aufrufen
        if (event.phase == TickEvent.Phase.END) {
            ClientLevel level = Minecraft.getInstance().level;
            if (level != null) {
                DynamicLightsManager.onClientTick(level);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        Entity e = event.getEntity();
        event.getLevel().isClientSide();
    }
}
