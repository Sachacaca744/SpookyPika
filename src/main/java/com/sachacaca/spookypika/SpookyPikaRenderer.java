package com.sachacaca.spookypika;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SpookyPikaRenderer extends MobRenderer<SpookyPikaEntity, SpookyPikaModel<SpookyPikaEntity>> {
    private static final ResourceLocation TEXTURE =
        new ResourceLocation(SpookyPikaMod.MODID, "textures/entity/spooky_pika.png");

    public SpookyPikaRenderer(EntityRendererProvider.Context context) {
        super(context, new SpookyPikaModel<>(context.bakeLayer(SpookyPikaModel.LAYER)), 0.35F);
    }

    @Override
    public ResourceLocation getTextureLocation(SpookyPikaEntity entity) {
        return TEXTURE;
    }
}
