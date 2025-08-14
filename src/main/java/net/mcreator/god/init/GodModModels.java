
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.god.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.god.client.model.Modelkamichigiri;
import net.mcreator.god.client.model.Modelgrimoire;
import net.mcreator.god.client.model.Modelblade;
import net.mcreator.god.client.model.ModelLAME_Converted;
import net.mcreator.god.client.model.ModelHellFire5;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GodModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelHellFire5.LAYER_LOCATION, ModelHellFire5::createBodyLayer);
		event.registerLayerDefinition(ModelLAME_Converted.LAYER_LOCATION, ModelLAME_Converted::createBodyLayer);
		event.registerLayerDefinition(Modelkamichigiri.LAYER_LOCATION, Modelkamichigiri::createBodyLayer);
		event.registerLayerDefinition(Modelblade.LAYER_LOCATION, Modelblade::createBodyLayer);
		event.registerLayerDefinition(Modelgrimoire.LAYER_LOCATION, Modelgrimoire::createBodyLayer);
	}
}
