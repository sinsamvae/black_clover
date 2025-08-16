
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.god.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.god.client.gui.RaceSelectionScreen;
import net.mcreator.god.client.gui.Menu7Screen;
import net.mcreator.god.client.gui.Menu5Screen;
import net.mcreator.god.client.gui.Menu4Screen;
import net.mcreator.god.client.gui.Menu3Screen;
import net.mcreator.god.client.gui.Menu2Screen;
import net.mcreator.god.client.gui.Menu1Screen;
import net.mcreator.god.client.gui.KingsScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GodModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(GodModMenus.MENU_1.get(), Menu1Screen::new);
			MenuScreens.register(GodModMenus.MENU_2.get(), Menu2Screen::new);
			MenuScreens.register(GodModMenus.MENU_3.get(), Menu3Screen::new);
			MenuScreens.register(GodModMenus.MENU_4.get(), Menu4Screen::new);
			MenuScreens.register(GodModMenus.MENU_5.get(), Menu5Screen::new);
			MenuScreens.register(GodModMenus.KINGS.get(), KingsScreen::new);
			MenuScreens.register(GodModMenus.MENU_7.get(), Menu7Screen::new);
			MenuScreens.register(GodModMenus.RACE_SELECTION.get(), RaceSelectionScreen::new);
		});
	}
}
