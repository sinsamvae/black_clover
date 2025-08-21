package net.mcreator.god.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.god.network.GodModVariables;
import net.mcreator.god.init.GodModParticleTypes;

public class LevelUpProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new GodModVariables.PlayerVariables())).xp > (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level
						* (100 + Math.floor((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level / 5))) {
			{
				double _setval = (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).xp
						- (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level
								* (15 + Math.floor((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level / 5));
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.xp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).level + 1;
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.level = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).SP + 10;
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (GodModParticleTypes.LEVEL_UP_PARTICLES.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 10, 2, 2, 2, 5);
		}
	}
}
