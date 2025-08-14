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

import net.mcreator.god.world.inventory.Menu3Menu;
import net.mcreator.god.procedures.ModelProcedure;
import net.mcreator.god.network.Menu3ButtonMessage;
import net.mcreator.god.GodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Menu3Screen extends AbstractContainerScreen<Menu3Menu> {
	private final static HashMap<String, Object> guistate = Menu3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_blank;
	ImageButton imagebutton_blank1;
	ImageButton imagebutton_blank3;
	ImageButton imagebutton_blank4;
	ImageButton imagebutton_blank2;
	ImageButton imagebutton_magic;
	ImageButton imagebutton_races;
	ImageButton imagebutton_magic1;
	ImageButton imagebutton_spirits;
	ImageButton imagebutton_method;
	ImageButton imagebutton_ki;

	public Menu3Screen(Menu3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("god:textures/screens/menu_3.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ModelProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 63, this.topPos + 117, 30, 0f + (float) Math.atan((this.leftPos + 63 - mouseX) / 40.0), (float) Math.atan((this.topPos + 68 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -100 && mouseX < leftPos + -76 && mouseY > topPos + 70 && mouseY < topPos + 94)
			guiGraphics.renderTooltip(font, Component.translatable("gui.god.menu_3.tooltip_demons"), mouseX, mouseY);
		if (mouseX > leftPos + -100 && mouseX < leftPos + -76 && mouseY > topPos + 25 && mouseY < topPos + 49)
			guiGraphics.renderTooltip(font, Component.translatable("gui.god.menu_3.tooltip_race"), mouseX, mouseY);
		if (mouseX > leftPos + -46 && mouseX < leftPos + -22 && mouseY > topPos + 70 && mouseY < topPos + 94)
			guiGraphics.renderTooltip(font, Component.translatable("gui.god.menu_3.tooltip_spirits"), mouseX, mouseY);
		if (mouseX > leftPos + -46 && mouseX < leftPos + -22 && mouseY > topPos + 25 && mouseY < topPos + 49)
			guiGraphics.renderTooltip(font, Component.translatable("gui.god.menu_3.tooltip_magic"), mouseX, mouseY);
		if (mouseX > leftPos + -100 && mouseX < leftPos + -76 && mouseY > topPos + 115 && mouseY < topPos + 139)
			guiGraphics.renderTooltip(font, Component.translatable("gui.god.menu_3.tooltip_mana_method"), mouseX, mouseY);
		if (mouseX > leftPos + -46 && mouseX < leftPos + -22 && mouseY > topPos + 115 && mouseY < topPos + 139)
			guiGraphics.renderTooltip(font, Component.translatable("gui.god.menu_3.tooltip_ki"), mouseX, mouseY);
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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_blank = new ImageButton(this.leftPos + -82, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu3ButtonMessage(0, x, y, z));
				Menu3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank", imagebutton_blank);
		this.addRenderableWidget(imagebutton_blank);
		imagebutton_blank1 = new ImageButton(this.leftPos + -46, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank1.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu3ButtonMessage(1, x, y, z));
				Menu3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank1", imagebutton_blank1);
		this.addRenderableWidget(imagebutton_blank1);
		imagebutton_blank3 = new ImageButton(this.leftPos + 26, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank3.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu3ButtonMessage(2, x, y, z));
				Menu3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank3", imagebutton_blank3);
		this.addRenderableWidget(imagebutton_blank3);
		imagebutton_blank4 = new ImageButton(this.leftPos + -10, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank4.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu3ButtonMessage(3, x, y, z));
				Menu3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank4", imagebutton_blank4);
		this.addRenderableWidget(imagebutton_blank4);
		imagebutton_blank2 = new ImageButton(this.leftPos + 62, this.topPos + 160, 20, 20, 0, 0, 20, new ResourceLocation("god:textures/screens/atlas/imagebutton_blank2.png"), 20, 40, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu3ButtonMessage(4, x, y, z));
				Menu3ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blank2", imagebutton_blank2);
		this.addRenderableWidget(imagebutton_blank2);
		imagebutton_magic = new ImageButton(this.leftPos + -55, this.topPos + 16, 40, 40, 0, 0, 40, new ResourceLocation("god:textures/screens/atlas/imagebutton_magic.png"), 40, 80, e -> {
			if (true) {
				GodMod.PACKET_HANDLER.sendToServer(new Menu3ButtonMessage(5, x, y, z));
				Menu3ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_magic", imagebutton_magic);
		this.addRenderableWidget(imagebutton_magic);
		imagebutton_races = new ImageButton(this.leftPos + -109, this.topPos + 16, 40, 40, 0, 0, 40, new ResourceLocation("god:textures/screens/atlas/imagebutton_races.png"), 40, 80, e -> {
		});
		guistate.put("button:imagebutton_races", imagebutton_races);
		this.addRenderableWidget(imagebutton_races);
		imagebutton_magic1 = new ImageButton(this.leftPos + -109, this.topPos + 61, 40, 40, 0, 0, 40, new ResourceLocation("god:textures/screens/atlas/imagebutton_magic1.png"), 40, 80, e -> {
		});
		guistate.put("button:imagebutton_magic1", imagebutton_magic1);
		this.addRenderableWidget(imagebutton_magic1);
		imagebutton_spirits = new ImageButton(this.leftPos + -55, this.topPos + 61, 40, 40, 0, 0, 40, new ResourceLocation("god:textures/screens/atlas/imagebutton_spirits.png"), 40, 80, e -> {
		});
		guistate.put("button:imagebutton_spirits", imagebutton_spirits);
		this.addRenderableWidget(imagebutton_spirits);
		imagebutton_method = new ImageButton(this.leftPos + -109, this.topPos + 106, 40, 40, 0, 0, 40, new ResourceLocation("god:textures/screens/atlas/imagebutton_method.png"), 40, 80, e -> {
		});
		guistate.put("button:imagebutton_method", imagebutton_method);
		this.addRenderableWidget(imagebutton_method);
		imagebutton_ki = new ImageButton(this.leftPos + -55, this.topPos + 106, 40, 40, 0, 0, 40, new ResourceLocation("god:textures/screens/atlas/imagebutton_ki.png"), 40, 80, e -> {
		});
		guistate.put("button:imagebutton_ki", imagebutton_ki);
		this.addRenderableWidget(imagebutton_ki);
	}
}
