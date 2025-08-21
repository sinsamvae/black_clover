
package net.mcreator.god.command;

@Mod.EventBusSubscriber
public class BlackCloverCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("black_clover").requires(s -> s.hasPermission(1))
				.then(Commands.argument("Player", EntityArgument.players()).then(Commands.literal("add").then(Commands.argument("stat", StringArgumentType.word()).then(Commands.argument("number", DoubleArgumentType.doubleArg()))))));
	}

}
