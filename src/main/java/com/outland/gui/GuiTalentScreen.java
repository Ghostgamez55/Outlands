package com.outland.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import com.outland.main.OutlandMod;
import com.outland.renderers.RenderTalentScreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

/**
 * @author Xcisso
 *
 *	This Gui class handles the input from the player, and sends info to the 3d renderer.
 *	Please do not touch if you dont know exactly what you are doing :D
 */
public class GuiTalentScreen extends GuiScreen
{
	Minecraft mc;
	RenderManager rm;
	Tessellator tessellator;
	BufferBuilder vertexBuffer;
	FontRenderer fr;
	
	
	
	EntityPlayerSP player;
	
	public int mouseX = 0, mouseY = 0;
	public double mouseXP = 0, mouseYP = 0;
	
	
	public GuiTalentScreen()
	{
		mc = OutlandMod.mc;
		rm = mc.getRenderManager();
		tessellator = Tessellator.getInstance();
		vertexBuffer = tessellator.getBuffer();
		fr = mc.fontRenderer;
		
		player = mc.player;
		
	}
	
	@Override
	public void initGui()
    {
		/*
		if(RenderTalentScreen.currentRenderer != null)
			System.out.println("Did not properly close the renderer.");
		new RenderTalentScreen(this, mc, rm, tessellator, vertexBuffer, fr);
		*/
    }
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
	
	
	/* (non-Javadoc)
	 * @see net.minecraft.client.gui.GuiScreen#drawScreen(int, int, float)
	 */
	@Override
	public void drawScreen(int _x, int _y, float _f)
	{
		this.mouseX = _x;
		this.mouseY = _y;
		
		mouseXP = (double)this.mouseX / (double)this.width;
		mouseYP = (double)this.mouseY / (double)this.height;
		
		this.drawString(fr, "Debug:", 0, 0, 0xFFCC66);

		this.drawString(fr, "mouseX = " + mouseX + " % = " + mouseXP, 0, 10, 0xFFCC66);
		this.drawString(fr, "mouseY = " + mouseY, 0, 20, 0xFFCC66);
		
		this.drawString(fr, "playerViewY = " + rm.playerViewY + "", 0, 45, 0xFFCC66);
		this.drawString(fr, "playerViewX = " + rm.playerViewX + "", 0, 55, 0xFFCC66);
		
		
	}
	
	@Override
	protected void keyTyped(char _typedChar, int _keyCode) throws IOException
    {
		if(_typedChar == 'e')
		{
			this.CloseGui();
			return;
		}
		
		if(_typedChar == 'k')
		{
			this.CloseGui();
			return;
		}
		
		
		//	If we dont detect any custom keys, run the super method.
		super.keyTyped(_typedChar, _keyCode);
		
    }
	
	@Override
	public void onGuiClosed()
    {
		//RenderTalentScreen.currentRenderer.OnGuiDisable();
		
		//System.out.println("3D renderer is destroyed.");
    }
	
	/**
	 * 	Used to close the Gui screen.
	 * 	Handles the destruction of the 3D renderer as well.
	 */
	private void CloseGui()
	{
		this.mc.displayGuiScreen((GuiScreen)null);
        this.mc.setIngameFocus();

	}
	
	
}
