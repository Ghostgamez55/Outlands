package com.outland.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import com.outland.main.OutlandMod;
import com.outland.renderers.RenderTalentScreen;
import com.outland.utils.Vector3;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
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
	
	int centerX = 0;
	int centerY = 0;
	
	ResourceLocation backGroundImage = new ResourceLocation("olm:textures/gui/talentscreen/background.png");
	ResourceLocation[] talenPageTexture = new ResourceLocation[]{
			new ResourceLocation("olm:textures/gui/talentscreen/talentpage_mining.png"),
			new ResourceLocation("")
			};
	
	
	GuiTalentState guiState = GuiTalentState.Idle;
	
	Vector3 guiPosition = new Vector3(0, 0);
	int displayPage = 0;
	int pageCount = 3;
	int pageWidth = 256;
	float scrollSpeed = 25f;
	
	GuiButton testButton;
	
	
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
		
		centerX = this.width / 2;
		centerY = this.height / 2;
		
		CreateButtons();
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
		this.drawDefaultBackground();
		UpdateGuiPosition(_f);
		
		this.mouseX = _x;
		this.mouseY = _y;
		
		DrawTalentBackground();
		
		mouseXP = (double)this.mouseX / (double)this.width;
		mouseYP = (double)this.mouseY / (double)this.height;
		
		this.drawString(fr, "Debug:", 0, 0, 0xFFCC66);
		
		this.drawString(fr, "mouseX = " + mouseX + " % = " + mouseXP, 0, 10, 0xFFCC66);
		this.drawString(fr, "mouseY = " + mouseY, 0, 20, 0xFFCC66);
		
		this.drawString(fr, "playerViewY = " + rm.playerViewY + "", 0, 45, 0xFFCC66);
		this.drawString(fr, "playerViewX = " + rm.playerViewX + "", 0, 55, 0xFFCC66);
		
		
		this.drawString(fr, this.guiPosition.toString(), 200, 55, 0xFFCC66);

		DrawTalentpageMining(0);
		DrawTalentpageMining(1);
		DrawTalentpageMining(2);
		
		super.drawScreen(_x, _y, _f);
	}
	
	
	void UpdateGuiPosition(float _deltaTime)
	{
		switch(guiState)
		{
		case Idle:
			break;
		case MovingRight:
			this.guiPosition.X -= (double)(scrollSpeed * _deltaTime);
			if(this.guiPosition.X <= (-this.pageWidth * this.displayPage))
			{
				guiPosition.X = -this.pageWidth * this.displayPage;
				guiState = GuiTalentState.Idle;
			}
			
			break;
		case MovingLeft:
			this.guiPosition.X += (double)(scrollSpeed * _deltaTime);
			if(this.guiPosition.X >= (-this.pageWidth * this.displayPage))
			{
				guiPosition.X = -this.pageWidth * this.displayPage;
				guiState = GuiTalentState.Idle;
			}
			break;
		}
	}
	
	/**	This function is used to create and position all the buttons in the gui.
	 * 
	 */
	void CreateButtons()
	{
		System.out.println("Update Buttons");
		this.buttonList.clear();
		
		GuiButton buttonMoveRight = new GuiButton(0, 150, 100, 25, 25, ">");
		buttonMoveRight.visible = true;
		
		GuiButton buttonMoveLeft = new GuiButton(1, 50, 100, 25, 25, "<");
		buttonMoveRight.visible = true;
		
		this.buttonList.add(buttonMoveRight);
		this.buttonList.add(buttonMoveLeft);
	}
	
	@Override
    protected void actionPerformed(GuiButton _button)
    {
		if(guiState != GuiTalentState.Idle)
			return;
		
		switch(_button.id)
		{
			case 0:
				if(this.displayPage >= this.pageCount - 1)
					break;
				
				guiState = GuiTalentState.MovingRight;
				this.displayPage++;
				
				break;
			case 1:
				if(this.displayPage <= 0)
					break;
				
				guiState = GuiTalentState.MovingLeft;
				this.displayPage--;
				break;
			default:
				return;
		}
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
	
	
	private void DrawTalentBackground()
	{
		this.mc.getTextureManager().bindTexture(backGroundImage);
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, 512, 256);
	}
	
	/*
	 * This is where we draw the different pages
	 */
	void DrawTalentpageMining(int _id)
	{
		int pageOriginX = this.centerX - (pageWidth / 2);
		int pageOriginY = this.centerY - (pageWidth / 2);
		
		pageOriginX += _id*pageWidth;
		pageOriginX += this.guiPosition.X;
		
		this.mc.getTextureManager().bindTexture(this.talenPageTexture[0]);
		this.drawTexturedModalRect(pageOriginX, pageOriginY, 0, 0, 256, 256);
	}
	
	
	enum GuiTalentState
	{
		MovingRight,
		MovingLeft,
		Idle
	}
	
}
