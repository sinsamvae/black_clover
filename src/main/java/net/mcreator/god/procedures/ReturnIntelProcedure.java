package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

public class ReturnIntelProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Intelligence: " + new java.text.DecimalFormat("##").format((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).intel);
	}
}
