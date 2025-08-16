package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

public class ReturnLine1Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String line1 = "";
		if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 1) {
			line1 = "+No Stat Bonuses";
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 2) {
			line1 = "+50 Mana Bonus";
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 3) {
			line1 = "+60 Mana Bonus";
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 4) {
			line1 = "+5 Intelligence Bonus";
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 5) {
			line1 = "+20 Strengh/Mana Bonus";
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 6) {
			line1 = "+???";
		}
		return line1;
	}
}
