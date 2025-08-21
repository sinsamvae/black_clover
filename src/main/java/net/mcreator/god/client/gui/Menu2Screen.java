package net.mcreator.god.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.god.world.inventory.Menu2Menu;
import net.mcreator.god.procedures.ReturnStrenghProcedure;
import net.mcreator.god.procedures.ReturnSPProcedure;
import net.mcreator.god.procedures.ReturnLevelProcedure;
import net.mcreator.god.procedures.ReturnIntelProcedure;
import net.mcreator.god.procedures.ReturnHealthProcedure;
import net.mcreator.god.procedures.ReturnEnduranceProcedure;
import net.mcreator.god.network.Menu2ButtonMessage;
import net.mcreator.god.init.GodModScreens.WidgetScreen;
import net.mcreator.god.GodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Menu2Screen extends AbstractContainerScreen<Menu2Menu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = Menu2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_blank;
	ImageButton imagebutton_blank1;
	ImageButton imagebutton_blank3;
	ImageButton imagebutton_blank4;
	ImageButton imagebutton_blank2;
	ImageButton imagebutton_add;
	ImageButton imagebutton_add1;
	ImageButton imagebutton_add2;
	ImageButton imagebutton_add3;

	public Menu2Screen(Menu2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("god:textures/screens/menu_2.png");

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

		guiGraphics.blit(new ResourceLocation("god:textures/screens/menubook.png"), this.leftPos + -136, this.topPos + -11, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(new ResourceLocation("god:textures/screens/info.png"), this.leftPos + -82, this.topPos + 160, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("god:textures/screens/stat.png"), this.leftPos + -46, this.topPos + 160, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("god:textures/screens/teams.png"), this.leftPos + 26, this.topPos + 160, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("god:textures/screens/skills.png"), this.leftPos + -10, this.topPos + 160, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("god:textures/screens/armory.png"), this.leftPos + 62, this.topPos + 160, 0, 0, 20, 20, 20, 20);

		guiGraphics.blit(new ResourceLocation("god:textures/screens/blankhold.png"), this.leftPos + -46, this.topPos + 160, 0, 0, 20, 20, 20, 20);

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

				ReturnLevelProcedure.execute(entity), -109, 7, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnHealthProcedure.execute(entity), -91, 29, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnStrenghProcedure.execute(entity), -91, 56, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnEnduranceProcedure.execute(entity), -91, 84, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnSPProcedure.execute(entity), -28, 151, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnIntelProcedure.execute(entity), -91, 111, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_blank = new ImageButton(this.leftPos + -82, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu2ButtonMessage(0, x, y, z, textstate));
				Menu2ButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_blank", imagebutton_blank);
		this.addRenderableWidget(imagebutton_blank);
		imagebutton_blank1 = new ImageButton(this.leftPos + -46, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank1.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu2ButtonMessage(1, x, y, z, textstate));
				Menu2ButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_blank1", imagebutton_blank1);
		this.addRenderableWidget(imagebutton_blank1);
		imagebutton_blank3 = new ImageButton(this.leftPos + 26, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank3.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu2ButtonMessage(2, x, y, z, textstate));
				Menu2ButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_blank3", imagebutton_blank3);
		this.addRenderableWidget(imagebutton_blank3);
		imagebutton_blank4 = new ImageButton(this.leftPos + -10, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank4.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu2ButtonMessage(3, x, y, z, textstate));
				Menu2ButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_blank4", imagebutton_blank4);
		this.addRenderableWidget(imagebutton_blank4);
		imagebutton_blank2 = new ImageButton(this.leftPos + 62, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank2.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu2ButtonMessage(4, x, y, z, textstate));
				Menu2ButtonMessage.handleButtonAction(entity, 4, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_blank2", imagebutton_blank2);
		this.addRenderableWidget(imagebutton_blank2);
		imagebutton_add = new ImageButton(this.leftPos + -109, this.topPos + 25, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_add.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu2ButtonMessage(5, x, y, z, textstate));
				Menu2ButtonMessage.handleButtonAction(entity, 5, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_add", imagebutton_add);
		this.addRenderableWidget(imagebutton_add);
		imagebutton_add1 = new ImageButton(this.leftPos + -109, this.topPos + 52, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_add1.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu2ButtonMessage(6, x, y, z, textstate));
				Menu2ButtonMessage.handleButtonAction(entity, 6, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_add1", imagebutton_add1);
		this.addRenderableWidget(imagebutton_add1);
		imagebutton_add2 = new ImageButton(this.leftPos + -109, this.topPos + 79, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_add2.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu2ButtonMessage(7, x, y, z, textstate));
				Menu2ButtonMessage.handleButtonAction(entity, 7, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_add2", imagebutton_add2);
		this.addRenderableWidget(imagebutton_add2);
		imagebutton_add3 = new ImageButton(this.leftPos + -109, this.topPos + 106, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_add3.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu2ButtonMessage(8, x, y, z, textstate));
				Menu2ButtonMessage.handleButtonAction(entity, 8, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_add3", imagebutton_add3);
		this.addRenderableWidget(imagebutton_add3);
	}
}
