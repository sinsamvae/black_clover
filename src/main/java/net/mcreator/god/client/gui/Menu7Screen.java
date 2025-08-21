package net.mcreator.god.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.god.world.inventory.Menu7Menu;
import net.mcreator.god.procedures.ReturnMAProcedure;
import net.mcreator.god.procedures.RETMOVEProcedure;
import net.mcreator.god.procedures.GetThirdSkillProcedure;
import net.mcreator.god.procedures.GetSecondSkillProcedure;
import net.mcreator.god.procedures.GetFourthSkillProcedure;
import net.mcreator.god.procedures.GetFirstSkillProcedure;
import net.mcreator.god.procedures.GetFifthSkillProcedure;
import net.mcreator.god.network.Menu7ButtonMessage;
import net.mcreator.god.GodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Menu7Screen extends AbstractContainerScreen<Menu7Menu> {
	private final static HashMap<String, Object> guistate = Menu7Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_blank;
	ImageButton imagebutton_blank1;
	ImageButton imagebutton_blank3;
	ImageButton imagebutton_blank4;
	ImageButton imagebutton_blank2;
	ImageButton imagebutton_slotsmovebutton;
	ImageButton imagebutton_set;
	ImageButton imagebutton_set1;
	ImageButton imagebutton_set2;
	ImageButton imagebutton_set3;
	ImageButton imagebutton_set4;

	public Menu7Screen(Menu7Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("god:textures/screens/menu_7.png");

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

		guiGraphics.blit(new ResourceLocation("god:textures/screens/blankhold.png"), this.leftPos + -10, this.topPos + 160, 0, 0, 20, 20, 20, 20);

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
		guiGraphics.drawString(this.font,

				ReturnMAProcedure.execute(entity), -109, 7, -12829636, false);
		guiGraphics.drawString(this.font,

				RETMOVEProcedure.execute(entity), -18, 141, -12829636, false);
		guiGraphics.drawString(this.font,

				GetFirstSkillProcedure.execute(entity), -91, 34, -13421773, false);
		guiGraphics.drawString(this.font,

				GetSecondSkillProcedure.execute(entity), -91, 64, -12829636, false);
		guiGraphics.drawString(this.font,

				GetThirdSkillProcedure.execute(entity), -91, 94, -12829636, false);
		guiGraphics.drawString(this.font,

				GetFourthSkillProcedure.execute(entity), -91, 124, -12829636, false);
		guiGraphics.drawString(this.font,

				GetFifthSkillProcedure.execute(entity), 26, 34, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_blank = new ImageButton(this.leftPos + -82, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu7ButtonMessage(0, x, y, z));
				Menu7ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank", imagebutton_blank);
		this.addRenderableWidget(imagebutton_blank);
		imagebutton_blank1 = new ImageButton(this.leftPos + -46, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank1.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu7ButtonMessage(1, x, y, z));
				Menu7ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank1", imagebutton_blank1);
		this.addRenderableWidget(imagebutton_blank1);
		imagebutton_blank3 = new ImageButton(this.leftPos + 26, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank3.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu7ButtonMessage(2, x, y, z));
				Menu7ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank3", imagebutton_blank3);
		this.addRenderableWidget(imagebutton_blank3);
		imagebutton_blank4 = new ImageButton(this.leftPos + -10, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank4.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu7ButtonMessage(3, x, y, z));
				Menu7ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank4", imagebutton_blank4);
		this.addRenderableWidget(imagebutton_blank4);
		imagebutton_blank2 = new ImageButton(this.leftPos + 64, this.topPos + 180, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank2.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu7ButtonMessage(4, x, y, z));
				Menu7ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank2", imagebutton_blank2);
		this.addRenderableWidget(imagebutton_blank2);
		imagebutton_slotsmovebutton = new ImageButton(this.leftPos + -24, this.topPos + 134, 45, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_slotsmovebutton.png"), 45, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu7ButtonMessage(5, x, y, z));
				Menu7ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_slotsmovebutton", imagebutton_slotsmovebutton);
		this.addRenderableWidget(imagebutton_slotsmovebutton);
		imagebutton_set = new ImageButton(this.leftPos + -109, this.topPos + 31, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_set.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu7ButtonMessage(6, x, y, z));
				Menu7ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_set", imagebutton_set);
		this.addRenderableWidget(imagebutton_set);
		imagebutton_set1 = new ImageButton(this.leftPos + -109, this.topPos + 61, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_set1.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu7ButtonMessage(7, x, y, z));
				Menu7ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_set1", imagebutton_set1);
		this.addRenderableWidget(imagebutton_set1);
		imagebutton_set2 = new ImageButton(this.leftPos + -109, this.topPos + 91, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_set2.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu7ButtonMessage(8, x, y, z));
				Menu7ButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_set2", imagebutton_set2);
		this.addRenderableWidget(imagebutton_set2);
		imagebutton_set3 = new ImageButton(this.leftPos + -109, this.topPos + 121, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_set3.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu7ButtonMessage(9, x, y, z));
				Menu7ButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_set3", imagebutton_set3);
		this.addRenderableWidget(imagebutton_set3);
		imagebutton_set4 = new ImageButton(this.leftPos + 8, this.topPos + 31, 16, 16, 0, 0, 16, new ResourceLocation("god:textures/screens/atlas/imagebutton_set4.png"), 16, 32, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu7ButtonMessage(10, x, y, z));
				Menu7ButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_set4", imagebutton_set4);
		this.addRenderableWidget(imagebutton_set4);
	}
}
