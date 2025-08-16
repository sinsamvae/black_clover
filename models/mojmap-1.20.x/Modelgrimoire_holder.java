// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelgrimoire_holder<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "grimoire_holder"), "main");
	private final ModelPart bb_main;

	public Modelgrimoire_holder(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(38, 4)
						.addBox(-1.0F, -6.5F, -5.0F, 4.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(4, 4)
						.addBox(-2.0F, -13.5F, -6.0F, 1.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(4, 27)
						.addBox(3.0F, -13.5F, -6.0F, 1.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(14, 46)
						.addBox(4.0F, -14.75F, -1.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(34, 31)
						.addBox(-3.0F, -14.5F, -1.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(20, 46).addBox(-1.1F, -4.75F, -2.5F, 0.0F, 3.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.067F, -15.0F, -2.9875F, 1.5708F, 1.0036F, -3.1416F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 46).addBox(0.0F, -9.0F, -2.5F, 1.0F, 8.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-12.0F, -15.0F, 3.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(42, 41).addBox(0.0F, -10.0F, -2.5F, 1.0F, 6.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-11.0F, -15.0F, 7.0F, 1.5708F, 0.0F, -3.1416F));

		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(34, 43).addBox(0.0F, -10.0F, -2.5F, 1.0F, 8.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-13.0F, -15.0F, -2.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(42, 31).addBox(0.0F, -8.0F, -2.5F, 1.0F, 6.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -15.0F, -5.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(8, 46).addBox(-0.5F, -6.75F, -2.0F, 0.0F, 6.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.75F, -15.25F, 1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(34, 23).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 1.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -7.0F, -4.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r8 = bb_main
				.addOrReplaceChild("cube_r8",
						CubeListBuilder.create().texOffs(34, 15).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 1.0F, 7.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(1.0F, -7.0F, 7.0F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}