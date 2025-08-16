package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

public class Line3Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String line1 = "";
		if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 1) {
			line1 = "+Can contract with Spirits/Devils";
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 2) {
			line1 = "+Can Evolve into a Dark Elf";
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 3) {
			line1 = "+More Benefits with Regen foods";
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 4) {
			line1 = "+Spawn in Witch Forest";
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 5) {
			line1 = "+Demonic Magic";
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 6) {
			line1 = "+???";
		}
		return line1;
	}
}
