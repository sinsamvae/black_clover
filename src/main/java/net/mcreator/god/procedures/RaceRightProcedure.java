package net.mcreator.god.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

public class RaceRightProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 1) {
			{
				double _setval = 2;
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race_count = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "Elf";
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 2) {
			{
				double _setval = 3;
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race_count = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "Dwarf";
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 3) {
			{
				double _setval = 4;
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race_count = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "Witch";
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 4) {
			{
				double _setval = 5;
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race_count = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "Devil";
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 5) {
			{
				double _setval = 6;
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race_count = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "Random";
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).race_count == 6) {
			{
				double _setval = 1;
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race_count = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "Human";
				entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.race = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
