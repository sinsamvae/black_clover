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

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelLAME_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("god", "model_lame_converted"), "main");
	public final ModelPart bone;

	public ModelLAME_Converted(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(2, 4).addBox(-7.6F, -15.9F, 0.0F, 0.8F, 2.7F, 0.3F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));
		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(1, 2).addBox(-1.7F, -1.95F, 0.0F, 0.6F, 0.55F, 0.3F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0191F, -13.0232F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(3, 4).addBox(1.8F, -1.9F, 0.0F, 0.2F, 0.9F, 0.3F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.6588F, -16.8473F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(6, 6).addBox(1.8F, -1.9F, 0.0F, 0.2F, 0.9F, 0.3F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.4761F, -15.3765F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(1, 2).addBox(1.8F, -1.9F, 0.0F, 0.2F, 0.9F, 0.3F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.2761F, -16.0765F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(2, 1).mirror().addBox(-2.0F, -2.0F, 0.0F, 0.2F, 1.0F, 0.3F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.6556F, -16.8315F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(6, 6).addBox(-2.0F, -2.0F, 0.0F, 0.2F, 1.0F, 0.3F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9F, -15.4F, 0.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r7 = bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(1, 2).addBox(-2.0F, -2.0F, 0.0F, 0.2F, 1.0F, 0.3F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -16.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
