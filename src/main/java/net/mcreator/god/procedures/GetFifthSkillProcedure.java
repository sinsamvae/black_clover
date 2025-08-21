package net.mcreator.god.procedures;

import net.minecraftforge.eventbus.api.Event;

public class GetFifthSkillProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String skill = "";
		if (((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).attribute).equals("Wind")) {
			skill = "Tornado Fang";
		} else if (((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).attribute).equals("Water")) {
			skill = "Water Ball";
		}
		return skill;
	}
}
