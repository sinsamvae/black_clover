package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

public class KnockbackProcedure {
	public static void execute(Entity target, Entity user, double scale) {
		if (target == null || user == null)
			return;
		target.push(
				(user.getLookAngle().x * scale
						* (((user.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level + 50)
								/ ((target.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level + target.getPersistentData().getDouble("level") + 50))),
				(user.getLookAngle().y * scale
						* (((user.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level + 50)
								/ ((target.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level + target.getPersistentData().getDouble("level") + 50))),
				(user.getLookAngle().z * scale * (((user.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level + 50)
						/ ((target.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level + target.getPersistentData().getDouble("level") + 50))));
	}
}
