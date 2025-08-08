package com.honigdose.abyssmagicmod.light;

import net.minecraft.client.multiplayer.ClientLevel;


import java.util.Iterator;
import java.util.Set;

import java.util.LinkedHashSet;


public class DynamicLightsManager {

    private static final Set<DynamicLightSource> containers = new LinkedHashSet<>();

    public static void register(IDynamicLightSource src) {
        containers.add(new DynamicLightSource(src));
    }


    public static void onClientTick(ClientLevel world) {
        Iterator<DynamicLightSource> it = containers.iterator();
        while (it.hasNext()) {
            DynamicLightSource cont = it.next();
            if (cont.onUpdate(world)) {
                it.remove();
            }
        }
    }
}