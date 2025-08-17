// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelblade<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "lame_converted"), "main");
	private final ModelPart group;

	public Modelblade(ModelPart root) {
		this.group = root.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition group = partdefinition.addOrReplaceChild("group",
				CubeListBuilder.create().texOffs(4, 1)
						.addBox(0.0F, -13.4F, 1.4F, 0.8F, 1.9F, 0.2F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-0.6F, -11.6F, 1.4F, 2.0F, 9.2F, 0.2F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 1.0F, -1.9F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r1 = group.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(4, 0).addBox(-2.29F, -8.9F, 0.0F, 1.49F, 1.4F, 0.2F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.1446F, 2.5473F, 1.4F, 0.0F, 0.0F, -0.7505F));

		PartDefinition cube_r2 = group.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(1.3F, -1.0F, 0.0F, 0.2F, 1.0F, 0.2F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.2839F, -14.8544F, 1.4F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r3 = group.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -0.6F, 0.0F, 0.2F, 0.6F, 0.2F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.8863F, -13.2617F, 1.4F, 0.0F, 0.0F, 0.384F));

		PartDefinition cube_r4 = group.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 0).addBox(1.3F, -0.6F, 0.0F, 0.2F, 0.6F, 0.2F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0863F, -13.2617F, 1.4F, 0.0F, 0.0F, -0.384F));

		PartDefinition cube_r5 = group.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(4, 3).addBox(-1.9F, -0.6F, 0.0F, 0.6F, 0.6F, 0.2F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.3863F, -12.4617F, 1.4F, 0.0F, 0.0F, 0.733F));

		PartDefinition cube_r6 = group.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.9F, -1.9F, 0.0F, 0.3F, 0.6F, 0.1F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.6F, -12.7F, 1.4F, 0.0001F, 0.0249F, -0.4182F));

		PartDefinition cube_r7 = group.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -0.9F, 0.0F, 0.2F, 0.9F, 0.2F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0535F, -14.9154F, 1.4F, 0.0F, 0.0F, -0.4887F));

		PartDefinition cube_r8 = group.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.4F, -1.8F, 0.1F, 0.3F, 0.5F, 0.1F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.9F, -11.5F, 1.3F, 0.0F, 0.0F, 0.4538F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		group.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}