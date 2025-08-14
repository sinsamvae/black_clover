package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

public class AbilityDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String texture = "";
		boolean can_scroll = false;
		double count = 0;
		double id = 0;
		return "Skill: " + ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).abilityselect).getOrCreateTag()
				.getString(("skill" + (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).move));
	}
}
