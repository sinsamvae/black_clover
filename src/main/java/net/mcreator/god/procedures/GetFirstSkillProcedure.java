package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

public class GetFirstSkillProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String skill = "";
		if (((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).attribute).equals("Wind")) {
			skill = "Crescent Kamaitachi";
		} else if (((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).attribute).equals("Water")) {
			skill = "Water Ball";
		}
		return skill;
	}
}
