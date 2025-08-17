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

import net.mcreator.god.world.inventory.Menu5Menu;
import net.mcreator.god.procedures.ReturnXPProcedure;
import net.mcreator.god.procedures.ReturnStatusProcedure;
import net.mcreator.god.procedures.ReturnRaceProcedure;
import net.mcreator.god.procedures.ReturnNameProcedure;
import net.mcreator.god.procedures.ReturnLevelProcedure;
import net.mcreator.god.procedures.ModelProcedure;
import net.mcreator.god.network.Menu5ButtonMessage;
import net.mcreator.god.GodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Menu5Screen extends AbstractContainerScreen<Menu5Menu> {
	private final static HashMap<String, Object> guistate = Menu5Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_blank;
	ImageButton imagebutton_blank1;
	ImageButton imagebutton_blank3;
	ImageButton imagebutton_blank4;
	ImageButton imagebutton_blank2;

	public Menu5Screen(Menu5Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("god:textures/screens/menu_5.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ModelProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 66, this.topPos + 123, 50, 1.5f, 0, livingEntity);
		}
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

		guiGraphics.blit(new ResourceLocation("god:textures/screens/blankhold.png"), this.leftPos + 62, this.topPos + 160, 0, 0, 20, 20, 20, 20);

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

				ReturnNameProcedure.execute(entity), -109, 7, -13421773, false);
		guiGraphics.drawString(this.font,

				ReturnLevelProcedure.execute(entity), -109, 43, -13421773, false);
		guiGraphics.drawString(this.font,

				ReturnRaceProcedure.execute(entity), -109, 25, -13421773, false);
		guiGraphics.drawString(this.font,

				ReturnStatusProcedure.execute(entity), -109, 79, -13421773, false);
		guiGraphics.drawString(this.font,

				ReturnXPProcedure.execute(entity), -109, 61, -13421773, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_blank = new ImageButton(this.leftPos + -82, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu5ButtonMessage(0, x, y, z));
				Menu5ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank", imagebutton_blank);
		this.addRenderableWidget(imagebutton_blank);
		imagebutton_blank1 = new ImageButton(this.leftPos + -46, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank1.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu5ButtonMessage(1, x, y, z));
				Menu5ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank1", imagebutton_blank1);
		this.addRenderableWidget(imagebutton_blank1);
		imagebutton_blank3 = new ImageButton(this.leftPos + 26, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank3.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu5ButtonMessage(2, x, y, z));
				Menu5ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank3", imagebutton_blank3);
		this.addRenderableWidget(imagebutton_blank3);
		imagebutton_blank4 = new ImageButton(this.leftPos + -10, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank4.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu5ButtonMessage(3, x, y, z));
				Menu5ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank4", imagebutton_blank4);
		this.addRenderableWidget(imagebutton_blank4);
		imagebutton_blank2 = new ImageButton(this.leftPos + 62, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank2.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu5ButtonMessage(4, x, y, z));
				Menu5ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank2", imagebutton_blank2);
		this.addRenderableWidget(imagebutton_blank2);
	}
}
