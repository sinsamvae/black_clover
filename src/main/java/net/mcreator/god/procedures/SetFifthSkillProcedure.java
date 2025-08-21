package net.mcreator.god.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SetFifthSkillProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
boolean can_set = false;double check = 0;
if (!().equals("LOCKED")) {can_set = true;for (int index0 = 0; index0<8; index0++) {if ((((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new GodModVariables.PlayerVariables())).abilityselect)
.getOrCreateTag().getString(("skill"+check))).equals()) {can_set = false;}check = check+1;}if (can_set) {((entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new GodModVariables.PlayerVariables())).abilityselect)
.getOrCreateTag().putString(("skill"+(entity.getCapability(GodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new GodModVariables.PlayerVariables())).move), );if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal(), false);}else{if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("You already have this skill"), false);}}
}
}
