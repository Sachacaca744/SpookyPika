package com.sachacaca.spookypika;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SpookyPikaModel<T extends SpookyPikaEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(
        new ResourceLocation(SpookyPikaMod.MODID, "spooky_pika"), "main");

    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leftEar;
    private final ModelPart rightEar;
    private final ModelPart tail;

    public SpookyPikaModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.head = body.getChild("head");
        this.leftEar = head.getChild("left_ear");
        this.rightEar = head.getChild("right_ear");
        this.tail = body.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition body = root.addOrReplaceChild("body",
            CubeListBuilder.create().texOffs(0, 0).addBox(-4, -5, -3, 8, 8, 6),
            PartPose.offset(0, 19, 0));
        PartDefinition head = body.addOrReplaceChild("head",
            CubeListBuilder.create().texOffs(0, 17).addBox(-4, -7, -4, 8, 7, 7)
                .texOffs(0, 32).addBox(-2, -2, -5, 4, 2, 2),
            PartPose.offset(0, -4, -1));
        head.addOrReplaceChild("left_ear",
            CubeListBuilder.create().texOffs(30, 17).addBox(-1, -8, -1, 2, 8, 2)
                .texOffs(30, 27).addBox(-1, -8, -1, 2, 2, 2, new CubeDeformation(0.2F)),
            PartPose.offset(-2, -6, 0));
        head.addOrReplaceChild("right_ear",
            CubeListBuilder.create().texOffs(30, 17).addBox(-1, -8, -1, 2, 8, 2)
                .texOffs(30, 27).addBox(-1, -8, -1, 2, 2, 2, new CubeDeformation(0.2F)),
            PartPose.offset(2, -6, 0));
        body.addOrReplaceChild("tail",
            CubeListBuilder.create().texOffs(40, 0).addBox(-1, -7, 0, 2, 8, 2)
                .texOffs(40, 10).addBox(-2, -9, 0, 4, 3, 2),
            PartPose.offset(3, -2, 2));
        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override public ModelPart root() { return root; }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        head.xRot = headPitch * ((float)Math.PI / 180F);
        leftEar.zRot = -0.12F + Mth.sin(ageInTicks * 0.08F) * 0.05F;
        rightEar.zRot = 0.12F - Mth.sin(ageInTicks * 0.08F) * 0.05F;
        tail.zRot = Mth.sin(ageInTicks * 0.12F) * 0.08F;
        body.xRot = Mth.cos(limbSwing * 0.7F) * 0.08F * limbSwingAmount;
    }
}
