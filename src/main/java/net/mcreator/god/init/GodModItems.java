
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.god.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.god.item.MaxManaItem;
import net.mcreator.god.GodMod;

public class GodModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, GodMod.MODID);
	public static final RegistryObject<Item> MAX_MANA = REGISTRY.register("max_mana", () -> new MaxManaItem());
	// Start of user code block custom items
	// End of user code block custom items
}
