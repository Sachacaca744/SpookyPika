package com.sachacaca.spookypika;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SpookyPikaMod.MODID);

    public static final RegistryObject<EntityType<SpookyPikaEntity>> SPOOKY_PIKA =
        ENTITY_TYPES.register("spooky_pika", () -> EntityType.Builder
            .of(SpookyPikaEntity::new, MobCategory.CREATURE)
            .sized(0.8F, 1.0F).clientTrackingRange(8).build("spooky_pika"));

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SPOOKY_PIKA.get(), SpookyPikaEntity.createAttributes().build());
    }
}
