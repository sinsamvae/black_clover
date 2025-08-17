package net.mcreator.god.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.god.world.inventory.CharacterCreationMenu;
import net.mcreator.god.procedures.SkinReturnProcedure;
import net.mcreator.god.procedures.ModelProcedure;
import net.mcreator.god.procedures.EyesReturnProcedure;
import net.mcreator.god.network.CharacterCreationButtonMessage;
import net.mcreator.god.init.GodModScreens.WidgetScreen;
import net.mcreator.god.GodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CharacterCreationScreen extends AbstractContainerScreen<CharacterCreationMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = CharacterCreationMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_mini_left_white;
	ImageButton imagebutton_mini_white_right;
	ImageButton imagebutton_mini_left_white1;
	ImageButton imagebutton_mini_white_right1;

	public CharacterCreationScreen(CharacterCreationMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("god:textures/screens/character_creation.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ModelProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 0, this.topPos + 99, 45, 0f, 0, livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("god:textures/screens/menu1.png"), this.leftPos + -145, this.topPos + -11, 0, 0, 300, 200, 300, 200);

		RenderSystem.disableBlend();
	}

	public HashMap<String, Object> getWidgets() {
		return guistate;
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				EyesReturnProcedure.execute(entity), -110, 21, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.god.character_creation.label_eyes"), -109, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.god.character_creation.label_skin"), -109, 52, -1, false);
		guiGraphics.drawString(this.font,

				SkinReturnProcedure.execute(entity), -110, 73, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.god.character_creation.label_create_your_character"), -46, 1, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_mini_left_white = new ImageButton(this.leftPos + -127, this.topPos + 16, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_mini_left_white.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new CharacterCreationButtonMessage(0, x, y, z, textstate));
				CharacterCreationButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_mini_left_white", imagebutton_mini_left_white);
		this.addRenderableWidget(imagebutton_mini_left_white);
		imagebutton_mini_white_right = new ImageButton(this.leftPos + -91, this.topPos + 16, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_mini_white_right.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new CharacterCreationButtonMessage(1, x, y, z, textstate));
				CharacterCreationButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_mini_white_right", imagebutton_mini_white_right);
		this.addRenderableWidget(imagebutton_mini_white_right);
		imagebutton_mini_left_white1 = new ImageButton(this.leftPos + -127, this.topPos + 70, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_mini_left_white1.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new CharacterCreationButtonMessage(2, x, y, z, textstate));
				CharacterCreationButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_mini_left_white1", imagebutton_mini_left_white1);
		this.addRenderableWidget(imagebutton_mini_left_white1);
		imagebutton_mini_white_right1 = new ImageButton(this.leftPos + -91, this.topPos + 70, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_mini_white_right1.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new CharacterCreationButtonMessage(3, x, y, z, textstate));
				CharacterCreationButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_mini_white_right1", imagebutton_mini_white_right1);
		this.addRenderableWidget(imagebutton_mini_white_right1);
	}
}
