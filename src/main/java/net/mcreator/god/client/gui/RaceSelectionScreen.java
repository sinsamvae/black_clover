package net.mcreator.god.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.god.world.inventory.RaceSelectionMenu;
import net.mcreator.god.procedures.ReturnWitchProcedure;
import net.mcreator.god.procedures.ReturnRandomProcedure;
import net.mcreator.god.procedures.ReturnRaceProcedure;
import net.mcreator.god.procedures.ReturnLine2Procedure;
import net.mcreator.god.procedures.ReturnLine1Procedure;
import net.mcreator.god.procedures.ReturnHumanProcedure;
import net.mcreator.god.procedures.ReturnElfProcedure;
import net.mcreator.god.procedures.ReturnDwarfProcedure;
import net.mcreator.god.procedures.ReturnDevilProcedure;
import net.mcreator.god.procedures.Line3Procedure;
import net.mcreator.god.network.RaceSelectionButtonMessage;
import net.mcreator.god.init.GodModScreens.WidgetScreen;
import net.mcreator.god.GodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class RaceSelectionScreen extends AbstractContainerScreen<RaceSelectionMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = RaceSelectionMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_fleche_blanche_droite_1;
	ImageButton imagebutton_fleche_bleue_gauche_1;
	ImageButton imagebutton_slotsmovebutton;

	public RaceSelectionScreen(RaceSelectionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("god:textures/screens/race_selection.png");

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

		guiGraphics.blit(new ResourceLocation("god:textures/screens/racessss.png"), this.leftPos + -145, this.topPos + -20, 0, 0, 300, 200, 300, 200);

		if (ReturnHumanProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("god:textures/screens/human.png"), this.leftPos + -12, this.topPos + -11, 0, 0, 40, 40, 40, 40);
		}
		if (ReturnDevilProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("god:textures/screens/demon.png"), this.leftPos + -12, this.topPos + -11, 0, 0, 40, 40, 40, 40);
		}
		if (ReturnElfProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("god:textures/screens/elf.png"), this.leftPos + -13, this.topPos + -11, 0, 0, 42, 40, 42, 40);
		}
		if (ReturnWitchProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("god:textures/screens/witch.png"), this.leftPos + -12, this.topPos + -11, 0, 0, 40, 40, 40, 40);
		}
		if (ReturnDwarfProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("god:textures/screens/dwarf.png"), this.leftPos + -12, this.topPos + -11, 0, 0, 40, 40, 40, 40);
		}
		if (ReturnRandomProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("god:textures/screens/random.png"), this.leftPos + -12, this.topPos + -11, 0, 0, 40, 40, 40, 40);
		}
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

				ReturnRaceProcedure.execute(entity), -80, 52, -1, false);
		guiGraphics.drawString(this.font,

				ReturnLine1Procedure.execute(entity), -80, 79, -1, false);
		guiGraphics.drawString(this.font,

				Line3Procedure.execute(entity), -80, 133, -1, false);
		guiGraphics.drawString(this.font,

				ReturnLine2Procedure.execute(entity), -80, 106, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.god.race_selection.label_start"), -7, 156, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_fleche_blanche_droite_1 = new ImageButton(this.leftPos + 62, this.topPos + -2, 32, 32, 0, 0, 32, new ResourceLocation("god:textures/screens/atlas/imagebutton_fleche_blanche_droite_1.png"), 32, 64, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new RaceSelectionButtonMessage(0, x, y, z, textstate));
				RaceSelectionButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_fleche_blanche_droite_1", imagebutton_fleche_blanche_droite_1);
		this.addRenderableWidget(imagebutton_fleche_blanche_droite_1);
		imagebutton_fleche_bleue_gauche_1 = new ImageButton(this.leftPos + -82, this.topPos + -2, 32, 32, 0, 0, 32, new ResourceLocation("god:textures/screens/atlas/imagebutton_fleche_bleue_gauche_1.png"), 32, 64, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new RaceSelectionButtonMessage(1, x, y, z, textstate));
				RaceSelectionButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_fleche_bleue_gauche_1", imagebutton_fleche_bleue_gauche_1);
		this.addRenderableWidget(imagebutton_fleche_bleue_gauche_1);
		imagebutton_slotsmovebutton = new ImageButton(this.leftPos + -16, this.topPos + 151, 45, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_slotsmovebutton.png"), 45, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new RaceSelectionButtonMessage(2, x, y, z, textstate));
				RaceSelectionButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_slotsmovebutton", imagebutton_slotsmovebutton);
		this.addRenderableWidget(imagebutton_slotsmovebutton);
	}
}
