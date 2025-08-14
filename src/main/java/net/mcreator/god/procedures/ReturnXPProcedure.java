package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

public class ReturnXPProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "XP: " + new java.text.DecimalFormat("##").format((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).xp) + "/"
				+ new java.text.DecimalFormat("##").format((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level
						* (100 + Math.floor((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level / 5)));
	}
}
