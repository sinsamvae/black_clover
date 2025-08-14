package net.mcreator.god.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class WindSlashWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity(true);
		immediatesourceentity.getPersistentData().putDouble("Despawn", (immediatesourceentity.getPersistentData().getDouble("Despawn") + 1));
		if (immediatesourceentity.getPersistentData().getDouble("Despawn") >= 200) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.CLOUD, x, y, z, 3, 0.5, 0.5, 0.5, 0.1);
	}
}
