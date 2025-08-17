
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.god.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.god.world.inventory.RaceSelectionMenu;
import net.mcreator.god.world.inventory.Menu7Menu;
import net.mcreator.god.world.inventory.Menu5Menu;
import net.mcreator.god.world.inventory.Menu4Menu;
import net.mcreator.god.world.inventory.Menu3Menu;
import net.mcreator.god.world.inventory.Menu2Menu;
import net.mcreator.god.world.inventory.Menu1Menu;
import net.mcreator.god.world.inventory.KingsMenu;
import net.mcreator.god.world.inventory.CharacterCreationMenu;
import net.mcreator.god.GodMod;

import javax.annotation.Nullable;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, GodMod.MODID);
	public static final RegistryObject<MenuType<Menu1Menu>> MENU_1 = REGISTRY.register("menu_1", () -> IForgeMenuType.create(Menu1Menu::new));
	public static final RegistryObject<MenuType<Menu2Menu>> MENU_2 = REGISTRY.register("menu_2", () -> IForgeMenuType.create(Menu2Menu::new));
	public static final RegistryObject<MenuType<Menu3Menu>> MENU_3 = REGISTRY.register("menu_3", () -> IForgeMenuType.create(Menu3Menu::new));
	public static final RegistryObject<MenuType<Menu4Menu>> MENU_4 = REGISTRY.register("menu_4", () -> IForgeMenuType.create(Menu4Menu::new));
	public static final RegistryObject<MenuType<Menu5Menu>> MENU_5 = REGISTRY.register("menu_5", () -> IForgeMenuType.create(Menu5Menu::new));
	public static final RegistryObject<MenuType<KingsMenu>> KINGS = REGISTRY.register("kings", () -> IForgeMenuType.create(KingsMenu::new));
	public static final RegistryObject<MenuType<Menu7Menu>> MENU_7 = REGISTRY.register("menu_7", () -> IForgeMenuType.create(Menu7Menu::new));
	public static final RegistryObject<MenuType<RaceSelectionMenu>> RACE_SELECTION = REGISTRY.register("race_selection", () -> IForgeMenuType.create(RaceSelectionMenu::new));
	public static final RegistryObject<MenuType<CharacterCreationMenu>> CHARACTER_CREATION = REGISTRY.register("character_creation", () -> IForgeMenuType.create(CharacterCreationMenu::new));

	public static void setText(String boxname, String value, @Nullable ServerPlayer player) {
		if (player != null) {
			GodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> player), new GuiSyncMessage(boxname, value));
		} else {
			GodMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new GuiSyncMessage(boxname, value));
		}
	}

	public static class GuiSyncMessage {
		private final String textboxid;
		private final String data;

		public GuiSyncMessage(FriendlyByteBuf buffer) {
			this.textboxid = buffer.readComponent().getString();
			this.data = buffer.readComponent().getString();
		}

		public GuiSyncMessage(String textboxid, String data) {
			this.textboxid = textboxid;
			this.data = data;
		}

		public static void buffer(GuiSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeComponent(Component.literal(message.textboxid));
			buffer.writeComponent(Component.literal(message.data));
		}

		public static void handleData(GuiSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					GodModScreens.handleTextBoxMessage(message);
				}
			});
			context.setPacketHandled(true);
		}

		String editbox() {
			return this.textboxid;
		}

		String value() {
			return this.data;
		}
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		GodMod.addNetworkMessage(GuiSyncMessage.class, GuiSyncMessage::buffer, GuiSyncMessage::new, GuiSyncMessage::handleData);
	}
}
