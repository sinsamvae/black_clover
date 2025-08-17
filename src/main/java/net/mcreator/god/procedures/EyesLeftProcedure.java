package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

public class EyesLeftProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		double distance = 0;
		double Delta_X = 0;
		double Delta_Z = 0;
		double Delta_Y = 0;
		double Cur_Z = 0;
		double steps = 0;
		double Cur_Y = 0;
		double Cur_X = 0;
		if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).eye_color > 0) {
			{
				double _setval = (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).eye_color - 1;
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.eye_color = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
