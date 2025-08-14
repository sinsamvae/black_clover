package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

public class ReturnClassProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Social Rank: " + (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).SocialClass;
	}
}
