package com.sachacaca.spookypika;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SpookyPikaMod.MODID)
public class SpookyPikaMod {
    public static final String MODID = "spookypika";

    public SpookyPikaMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.ENTITY_TYPES.register(bus);
        ModItems.ITEMS.register(bus);
        bus.addListener(ModEntities::registerAttributes);
        bus.addListener(ClientSetup::registerRenderers);
        bus.addListener(ClientSetup::registerLayers);
    }
}
