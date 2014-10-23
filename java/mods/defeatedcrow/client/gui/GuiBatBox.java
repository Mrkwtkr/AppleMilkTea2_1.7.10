package mods.defeatedcrow.client.gui;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import mods.defeatedcrow.common.tile.energy.*;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiBatBox extends GuiContainer {
	
	private TileChargerBase tile;

	public GuiBatBox(EntityPlayer player, TileChargerBase tileentity) {
		super(new ContainerBatBox(player, tileentity));
		this.tile = tileentity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		//インベントリ名の描画
		String s = this.tile.hasCustomInventoryName() ? this.tile.getInventoryName() : I18n.format(this.tile.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
		
		//チャージゲージのマウスオーバー
		boolean b1 = this.func_146978_c(11, 26, 12, 27, par1, par2);
		if (b1)
		{
			int charge = this.tile.getChargeAmount();
			ArrayList<String> list1 = new ArrayList<String>();
			list1.add("Charge Amount : " + charge);
			this.drawHoveringText(list1, par1 - this.guiLeft, par2 - this.guiTop, fontRendererObj);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
 
		//テクスチャの指定
		//ResourceLocationの第一引数を付け足してドメインを指定することもできる
		//例:new ResourceLocation("sample", "textures/gui/container/furnace.png")
		this.mc.getTextureManager().bindTexture(new ResourceLocation("defeatedcrow", this.GuiTexPass()));
 
		//かまど描画処理
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		int i2;
 
		i1 = this.tile.getBurnTimeRemainingScaled(27);
		this.drawTexturedModalRect(k + 11, l + 53 - i1, 176, 43 - i1, 12, i1);
	}
	
	public String GuiTexPass()
	{
		return "textures/gui/batboxgui.png";
	}

}
