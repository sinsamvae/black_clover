package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnNameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Name: " + entity.getDisplayName().getString();
	}
}
