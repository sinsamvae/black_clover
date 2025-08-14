package net.mcreator.god.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.god.entity.TornadoEntity;

public class TornadoModel extends GeoModel<TornadoEntity> {
	@Override
	public ResourceLocation getAnimationResource(TornadoEntity entity) {
		return new ResourceLocation("god", "animations/tornado.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TornadoEntity entity) {
		return new ResourceLocation("god", "geo/tornado.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TornadoEntity entity) {
		return new ResourceLocation("god", "textures/entities/" + entity.getTexture() + ".png");
	}

}
