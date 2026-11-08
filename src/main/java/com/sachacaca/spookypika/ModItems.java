package com.sachacaca.spookypika;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, SpookyPikaMod.MODID);

    public static final RegistryObject<Item> SPOOKY_PIKA_SPAWN_EGG = ITEMS.register(
        "spooky_pika_spawn_egg",
        () -> new SpawnEggItem(ModEntities.SPOOKY_PIKA.get(), 0xE97820, 0x542078,
            new Item.Properties())
    );
}
