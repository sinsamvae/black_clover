package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

public class ReturnStrenghProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Strengh: " + new java.text.DecimalFormat("##").format((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).strenght);
	}
}
