package net.mcreator.god.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelbroom<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("god", "modelbroom"), "main");
	public final ModelPart hexadecagon4;
	public final ModelPart hexadecagon2;
	public final ModelPart hexadecagon;
	public final ModelPart bb_main;

	public Modelbroom(ModelPart root) {
		this.hexadecagon4 = root.getChild("hexadecagon4");
		this.hexadecagon2 = root.getChild("hexadecagon2");
		this.hexadecagon = root.getChild("hexadecagon");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition hexadecagon4 = partdefinition.addOrReplaceChild("hexadecagon4", CubeListBuilder.create(), PartPose.offsetAndRotation(18.0F, 27.5F, -7.5F, 0.0F, 0.0F, 0.3927F));
		PartDefinition hexadecagon_r1 = hexadecagon4.addOrReplaceChild("hexadecagon_r1", CubeListBuilder.create().texOffs(10, 24).addBox(-1.75F, -1.5F, -0.2984F, 3.75F, 0.25F, 0.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.3655F, 0.147F, 0.3655F));
		PartDefinition hexadecagon_r2 = hexadecagon4.addOrReplaceChild("hexadecagon_r2", CubeListBuilder.create().texOffs(0, 24).addBox(-1.75F, -1.5F, -0.2984F, 3.75F, 0.25F, 0.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition hexadecagon_r3 = hexadecagon4.addOrReplaceChild("hexadecagon_r3", CubeListBuilder.create().texOffs(20, 23).addBox(-1.75F, -1.5F, -0.2984F, 3.75F, 0.25F, 0.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.3655F, -0.147F, 0.3655F));
		PartDefinition hexadecagon_r4 = hexadecagon4.addOrReplaceChild("hexadecagon_r4", CubeListBuilder.create().texOffs(10, 23).addBox(-1.75F, 1.0F, -0.2984F, 3.75F, 0.25F, 0.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.3655F, -0.147F, -0.3655F));
		PartDefinition hexadecagon_r5 = hexadecagon4.addOrReplaceChild("hexadecagon_r5", CubeListBuilder.create().texOffs(20, 22).addBox(-1.75F, 1.0F, -0.2984F, 3.75F, 0.25F, 0.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition hexadecagon_r6 = hexadecagon4.addOrReplaceChild("hexadecagon_r6", CubeListBuilder.create().texOffs(10, 22).addBox(-1.75F, 1.0F, -0.2984F, 3.75F, 0.25F, 0.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.3655F, 0.147F, -0.3655F));
		PartDefinition hexadecagon_r7 = hexadecagon4.addOrReplaceChild("hexadecagon_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-1.75F, -0.2984F, 1.25F, 3.75F, 0.3467F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.8249F, 0.274F, -0.2849F));
		PartDefinition hexadecagon_r8 = hexadecagon4.addOrReplaceChild("hexadecagon_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-1.75F, -0.2984F, 1.25F, 3.75F, 0.3467F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.4215F, 0.3614F, -0.1572F));
		PartDefinition hexadecagon_r9 = hexadecagon4.addOrReplaceChild("hexadecagon_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-1.75F, -0.2984F, 1.25F, 3.75F, 0.3467F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition hexadecagon_r10 = hexadecagon4.addOrReplaceChild("hexadecagon_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-1.75F, -0.2984F, 1.25F, 3.75F, 0.3467F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.4215F, 0.3614F, 0.1572F));
		PartDefinition hexadecagon_r11 = hexadecagon4.addOrReplaceChild("hexadecagon_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-1.75F, -0.2984F, 1.25F, 3.75F, 0.3467F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.8249F, 0.274F, 0.2849F));
		PartDefinition hexadecagon_r12 = hexadecagon4.addOrReplaceChild("hexadecagon_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-1.75F, -0.2984F, -1.5F, 3.75F, 0.3467F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.8249F, -0.274F, 0.2849F));
		PartDefinition hexadecagon_r13 = hexadecagon4.addOrReplaceChild("hexadecagon_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-1.75F, -0.2984F, -1.5F, 3.75F, 0.3467F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.4215F, -0.3614F, 0.1572F));
		PartDefinition hexadecagon_r14 = hexadecagon4.addOrReplaceChild("hexadecagon_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-1.75F, -0.2984F, -1.5F, 3.75F, 0.3467F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, -0.3927F, 0.0F));
		PartDefinition hexadecagon_r15 = hexadecagon4.addOrReplaceChild("hexadecagon_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-1.75F, -0.2984F, -1.5F, 3.75F, 0.3467F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.4215F, -0.3614F, -0.1572F));
		PartDefinition hexadecagon_r16 = hexadecagon4.addOrReplaceChild("hexadecagon_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-1.75F, -0.2984F, -1.5F, 3.75F, 0.3467F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.8249F, -0.274F, -0.2849F));
		PartDefinition hexadecagon2 = partdefinition.addOrReplaceChild("hexadecagon2", CubeListBuilder.create(), PartPose.offsetAndRotation(14.0F, 8.85F, -7.0F, 0.0F, 0.0F, -2.7925F));
		PartDefinition hexadecagon_r17 = hexadecagon2.addOrReplaceChild("hexadecagon_r17", CubeListBuilder.create().texOffs(0, 17).addBox(-5.75F, -1.5F, -1.2984F, 7.75F, 1.25F, 1.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.3655F, 0.147F, 0.3655F));
		PartDefinition hexadecagon_r18 = hexadecagon2.addOrReplaceChild("hexadecagon_r18", CubeListBuilder.create().texOffs(0, 14).addBox(-5.75F, -1.5F, -1.2984F, 7.75F, 1.25F, 1.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition hexadecagon_r19 = hexadecagon2.addOrReplaceChild("hexadecagon_r19", CubeListBuilder.create().texOffs(0, 11).addBox(-5.75F, -1.5F, -1.2984F, 7.75F, 1.25F, 1.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.3655F, -0.147F, 0.3655F));
		PartDefinition hexadecagon_r20 = hexadecagon2.addOrReplaceChild("hexadecagon_r20", CubeListBuilder.create().texOffs(0, 8).addBox(-5.75F, 1.0F, -1.2984F, 7.75F, 1.25F, 1.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.3655F, -0.147F, -0.3655F));
		PartDefinition hexadecagon_r21 = hexadecagon2.addOrReplaceChild("hexadecagon_r21", CubeListBuilder.create().texOffs(0, 5).addBox(-5.75F, 1.0F, -1.2984F, 7.75F, 1.25F, 1.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition hexadecagon_r22 = hexadecagon2.addOrReplaceChild("hexadecagon_r22", CubeListBuilder.create().texOffs(0, 2).addBox(-5.75F, 1.0F, -1.2984F, 7.75F, 1.25F, 1.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.3655F, 0.147F, -0.3655F));
		PartDefinition hexadecagon_r23 = hexadecagon2.addOrReplaceChild("hexadecagon_r23", CubeListBuilder.create().texOffs(18, 20).addBox(-5.75F, -0.2984F, 0.25F, 7.75F, 1.3467F, 1.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.8249F, 0.274F, -0.2849F));
		PartDefinition hexadecagon_r24 = hexadecagon2.addOrReplaceChild("hexadecagon_r24", CubeListBuilder.create().texOffs(20, 16).addBox(-5.75F, -0.2984F, 0.25F, 7.75F, 1.3467F, 1.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.4215F, 0.3614F, -0.1572F));
		PartDefinition hexadecagon_r25 = hexadecagon2.addOrReplaceChild("hexadecagon_r25", CubeListBuilder.create().texOffs(20, 14).addBox(-5.75F, -0.2984F, 0.25F, 7.75F, 1.3467F, 1.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition hexadecagon_r26 = hexadecagon2.addOrReplaceChild("hexadecagon_r26", CubeListBuilder.create().texOffs(20, 12).addBox(-5.75F, -0.2984F, 0.25F, 7.75F, 1.3467F, 1.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.4215F, 0.3614F, 0.1572F));
		PartDefinition hexadecagon_r27 = hexadecagon2.addOrReplaceChild("hexadecagon_r27", CubeListBuilder.create().texOffs(20, 10).addBox(-5.75F, -0.2984F, 0.25F, 7.75F, 1.3467F, 1.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.8249F, 0.274F, 0.2849F));
		PartDefinition hexadecagon_r28 = hexadecagon2.addOrReplaceChild("hexadecagon_r28", CubeListBuilder.create().texOffs(20, 8).addBox(-5.75F, -0.2984F, -2.5F, 7.75F, 1.3467F, 1.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.8249F, -0.274F, 0.2849F));
		PartDefinition hexadecagon_r29 = hexadecagon2.addOrReplaceChild("hexadecagon_r29", CubeListBuilder.create().texOffs(20, 18).addBox(-5.75F, -0.2984F, -2.5F, 7.75F, 1.3467F, 1.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.4215F, -0.3614F, 0.1572F));
		PartDefinition hexadecagon_r30 = hexadecagon2.addOrReplaceChild("hexadecagon_r30", CubeListBuilder.create().texOffs(20, 4).addBox(-5.75F, -0.2984F, -2.5F, 7.75F, 1.3467F, 1.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, -0.3927F, 0.0F));
		PartDefinition hexadecagon_r31 = hexadecagon2.addOrReplaceChild("hexadecagon_r31", CubeListBuilder.create().texOffs(20, 2).addBox(-5.75F, -0.2984F, -2.5F, 7.75F, 1.3467F, 1.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.4215F, -0.3614F, -0.1572F));
		PartDefinition hexadecagon_r32 = hexadecagon2.addOrReplaceChild("hexadecagon_r32", CubeListBuilder.create().texOffs(0, 20).addBox(-5.75F, -0.2984F, -2.5F, 7.75F, 1.3467F, 1.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.8249F, -0.274F, -0.2849F));
		PartDefinition hexadecagon = partdefinition.addOrReplaceChild("hexadecagon",
				CubeListBuilder.create().texOffs(16, 28).addBox(-16.0F, -8.2984F, 6.5F, 0.6F, 0.5967F, 0.5F, new CubeDeformation(0.0F)).texOffs(0, 29).addBox(-16.0F, -8.2984F, 9.0F, 0.6F, 0.5967F, 0.5F, new CubeDeformation(0.0F)).texOffs(18, 26)
						.addBox(-16.0F, -7.0F, 7.7016F, 0.6F, 0.5F, 0.5967F, new CubeDeformation(0.0F)).texOffs(0, 27).addBox(-16.0F, -9.5F, 7.7016F, 0.6F, 0.5F, 0.5967F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(27.5F, 31.1F, -7.6F, 0.0F, 0.0F, 0.384F));
		PartDefinition hexadecagon_r33 = hexadecagon.addOrReplaceChild("hexadecagon_r33",
				CubeListBuilder.create().texOffs(4, 27).addBox(-8.0F, -1.5F, -0.2984F, 0.6F, 0.5F, 0.5967F, new CubeDeformation(0.0F)).texOffs(22, 26).addBox(-8.0F, 1.0F, -0.2984F, 0.6F, 0.5F, 0.5967F, new CubeDeformation(0.0F)).texOffs(4, 29)
						.addBox(-8.0F, -0.2984F, 1.0F, 0.6F, 0.5967F, 0.5F, new CubeDeformation(0.0F)).texOffs(20, 28).addBox(-8.0F, -0.2984F, -1.5F, 0.6F, 0.5967F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r34 = hexadecagon.addOrReplaceChild("hexadecagon_r34",
				CubeListBuilder.create().texOffs(26, 26).addBox(-8.0F, -1.5F, -0.2984F, 0.6F, 0.5F, 0.5967F, new CubeDeformation(0.0F)).texOffs(14, 25).addBox(-8.0F, 1.0F, -0.2984F, 0.6F, 0.5F, 0.5967F, new CubeDeformation(0.0F)).texOffs(28, 28)
						.addBox(-8.0F, -0.2984F, 1.0F, 0.6F, 0.5967F, 0.5F, new CubeDeformation(0.0F)).texOffs(12, 27).addBox(-8.0F, -0.2984F, -1.5F, 0.6F, 0.5967F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r35 = hexadecagon.addOrReplaceChild("hexadecagon_r35",
				CubeListBuilder.create().texOffs(8, 29).addBox(-8.0F, -0.2984F, 1.0F, 0.6F, 0.5967F, 0.5F, new CubeDeformation(0.0F)).texOffs(24, 28).addBox(-8.0F, -0.2984F, -1.5F, 0.6F, 0.5967F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition hexadecagon_r36 = hexadecagon.addOrReplaceChild("hexadecagon_r36",
				CubeListBuilder.create().texOffs(28, 24).addBox(-8.0F, -0.2984F, 1.0F, 0.6F, 0.5967F, 0.5F, new CubeDeformation(0.0F)).texOffs(8, 27).addBox(-8.0F, -0.2984F, -1.5F, 0.6F, 0.5967F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 107).addBox(-13.0F, -2.0F, 0.0F, 2.75F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.4553F, -9.7039F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 126).addBox(-11.5F, -2.25F, 0.0F, 2.5F, 0.75F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-12.9485F, -24.7356F, 0.0F, 0.0F, 0.0F, -2.3562F));
		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(25, 126).addBox(-10.5F, -1.75F, 0.0F, 1.5F, 0.75F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.3561F, -20.669F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 126).addBox(-13.0F, -1.75F, 0.0F, 4.0F, 0.75F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -12.25F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 126).addBox(-17.0F, -2.0F, 0.0F, 34.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.25F, 0.0F, 0.0F, 0.0F, 0.3927F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hexadecagon4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hexadecagon2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hexadecagon.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
