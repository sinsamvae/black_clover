
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.god.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.god.client.renderer.WindSlashRenderer;
import net.mcreator.god.client.renderer.WindBladeRenderer;
import net.mcreator.god.client.renderer.WindBirdRenderer;
import net.mcreator.god.client.renderer.TornadoRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GodModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GodModEntities.WIND_SLASH.get(), WindSlashRenderer::new);
		event.registerEntityRenderer(GodModEntities.WIND_BIRD.get(), WindBirdRenderer::new);
		event.registerEntityRenderer(GodModEntities.TORNADO.get(), TornadoRenderer::new);
		event.registerEntityRenderer(GodModEntities.WIND_BLADE.get(), WindBladeRenderer::new);
	}
}
