
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.god.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.god.world.inventory.RaceSelectionMenu;
import net.mcreator.god.world.inventory.Menu7Menu;
import net.mcreator.god.world.inventory.Menu5Menu;
import net.mcreator.god.world.inventory.Menu4Menu;
import net.mcreator.god.world.inventory.Menu3Menu;
import net.mcreator.god.world.inventory.Menu2Menu;
import net.mcreator.god.world.inventory.Menu1Menu;
import net.mcreator.god.world.inventory.KingsMenu;
import net.mcreator.god.GodMod;

public class GodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, GodMod.MODID);
	public static final RegistryObject<MenuType<Menu1Menu>> MENU_1 = REGISTRY.register("menu_1", () -> IForgeMenuType.create(Menu1Menu::new));
	public static final RegistryObject<MenuType<Menu2Menu>> MENU_2 = REGISTRY.register("menu_2", () -> IForgeMenuType.create(Menu2Menu::new));
	public static final RegistryObject<MenuType<Menu3Menu>> MENU_3 = REGISTRY.register("menu_3", () -> IForgeMenuType.create(Menu3Menu::new));
	public static final RegistryObject<MenuType<Menu4Menu>> MENU_4 = REGISTRY.register("menu_4", () -> IForgeMenuType.create(Menu4Menu::new));
	public static final RegistryObject<MenuType<Menu5Menu>> MENU_5 = REGISTRY.register("menu_5", () -> IForgeMenuType.create(Menu5Menu::new));
	public static final RegistryObject<MenuType<KingsMenu>> KINGS = REGISTRY.register("kings", () -> IForgeMenuType.create(KingsMenu::new));
	public static final RegistryObject<MenuType<Menu7Menu>> MENU_7 = REGISTRY.register("menu_7", () -> IForgeMenuType.create(Menu7Menu::new));
	public static final RegistryObject<MenuType<RaceSelectionMenu>> RACE_SELECTION = REGISTRY.register("race_selection", () -> IForgeMenuType.create(RaceSelectionMenu::new));
}
