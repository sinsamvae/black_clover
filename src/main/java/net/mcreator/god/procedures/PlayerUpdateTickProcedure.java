package net.mcreator.god.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.god.network.GodModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerUpdateTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		String name = "";
		double a = 0;
		double r = 0;
		double b = 0;
		double range = 0;
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new java.text.DecimalFormat("##.##")
					.format(((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 20) * (entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GodModVariables.PlayerVariables())).MaxHealth));
			entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Health = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
