package net.mcreator.god.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.god.world.inventory.KingsMenu;
import net.mcreator.god.procedures.KINGSSProcedure;
import net.mcreator.god.procedures.KINGHProcedure;
import net.mcreator.god.procedures.KINGDProcedure;
import net.mcreator.god.procedures.KINGCProcedure;
import net.mcreator.god.network.KingsButtonMessage;
import net.mcreator.god.GodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class KingsScreen extends AbstractContainerScreen<KingsMenu> {
	private final static HashMap<String, Object> guistate = KingsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_select;
	ImageButton imagebutton_new_piskel_10;
	ImageButton imagebutton_new_piskel_11;

	public KingsScreen(KingsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("god:textures/screens/kings.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("god:textures/screens/kingdoms_menu.png"), this.leftPos + -208, this.topPos + -29, 0, 0, 300, 200, 300, 200);

		if (KINGHProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("god:textures/screens/new_piskel_1.png"), this.leftPos + -19, this.topPos + 52, 0, 0, 32, 32, 32, 32);
		}
		if (KINGDProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("god:textures/screens/new_piskel.png"), this.leftPos + -19, this.topPos + 52, 0, 0, 32, 32, 32, 32);
		}
		if (KINGSSProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("god:textures/screens/new_piskel_3.png"), this.leftPos + -19, this.topPos + 52, 0, 0, 32, 32, 32, 32);
		}
		if (KINGCProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("god:textures/screens/new_piskel_2.png"), this.leftPos + -19, this.topPos + 52, 0, 0, 32, 32, 32, 32);
		}
		RenderSystem.disableBlend();
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
	}

	@Override
	public void init() {
		super.init();
		button_select = Button.builder(Component.translatable("gui.god.kings.button_select"), e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new KingsButtonMessage(0, x, y, z));
				KingsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -34, this.topPos + 87, 61, 20).build();
		guistate.put("button:button_select", button_select);
		this.addRenderableWidget(button_select);
		imagebutton_new_piskel_10 = new ImageButton(this.leftPos + -55, this.topPos + 52, 32, 32, 0, 0, 32, new ResourceLocation("god:textures/screens/atlas/imagebutton_new_piskel_10.png"), 32, 64, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new KingsButtonMessage(1, x, y, z));
				KingsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_new_piskel_10", imagebutton_new_piskel_10);
		this.addRenderableWidget(imagebutton_new_piskel_10);
		imagebutton_new_piskel_11 = new ImageButton(this.leftPos + 17, this.topPos + 52, 32, 32, 0, 0, 32, new ResourceLocation("god:textures/screens/atlas/imagebutton_new_piskel_11.png"), 32, 64, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new KingsButtonMessage(2, x, y, z));
				KingsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_new_piskel_11", imagebutton_new_piskel_11);
		this.addRenderableWidget(imagebutton_new_piskel_11);
	}
}
