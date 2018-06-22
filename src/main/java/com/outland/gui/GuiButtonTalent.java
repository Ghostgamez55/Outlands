package com.outland.gui;

import org.lwjgl.opengl.GL11;

import com.outland.talents.TalentBase;
import com.outland.talents.TalentManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

public class GuiButtonTalent extends GuiButton
{
	boolean isHovering = false;
	int pageX = 0, pageY = 0;
	
	String buttonName = "";
	
	ResourceLocation iconTexture = new ResourceLocation("olm:textures/gui/talentscreen/talentstar.png");
	
	
	int xOffset = 0;
	
	TalentBase displayedTalent;
	
	
	public GuiButtonTalent(int buttonId, int x, int y, String _debugString, int _talentID) 
	{
		super(buttonId, x, y, 30, 30, "talent");
		buttonName = _debugString;
		
		displayedTalent = TalentManager.getTalentWithID(_talentID);
	}

	public GuiButtonTalent(int buttonId, int x, int y, String _debugString, TalentBase _talent) 
	{
		super(buttonId, x, y, 30, 30, "talent");
		buttonName = _debugString;
		
		displayedTalent = _talent;
	}
	
	
	/**
     * Draws this button to the screen.
     */
	@Override
    public void drawButton(Minecraft _mc, int _mouseX, int _mouseY, float _partialTicks)
    {
    	//super.drawButton(_mc, _mouseX, _mouseY, _partialTicks);
		
		GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        
        int xPositionWithOffset = this.x + this.xOffset;
        int yPositionWithOffset = this.y;
        
        this.isHovering = (_mouseX >= xPositionWithOffset && _mouseX <= xPositionWithOffset + this.width) && (_mouseY >= this.y && _mouseY <= this.y + this.height);
		
		if(!this.isHovering)
		{
	        GL11.glColor4f(1f, 1f, 1f, 1f);
		}
		else
		{
	        GL11.glColor4f(1f, 1f, 0.0f, 1f);
		}

		
		//	Draw the star texture.
		_mc.getTextureManager().bindTexture(iconTexture);
		this.drawModalRectWithCustomSizedTexture(xPositionWithOffset, yPositionWithOffset, 0, 0, this.width, this.height, 30, 30);
		
		
		
		int rectWidth = (_mc.fontRenderer.getStringWidth(this.displayedTalent.GetName()) / 2) + 2;
		int rectHeight = 10;
		int rectXCenter = (xPositionWithOffset + 15);
		int rectYCenter = (yPositionWithOffset + 36);
		this.drawRect(rectXCenter - rectWidth, rectYCenter - rectHeight, rectXCenter + rectWidth, rectYCenter + rectHeight, 0x7d001a1a);
		//this.drawGradientRect(left, top, right, bottom, startColor, endColor);
		
		
		
		int textColorRegular = 0xe6e6e6;
		//	Draw the text below the star.
		this.drawCenteredString(_mc.fontRenderer, this.displayedTalent.GetName(), xPositionWithOffset + 15, yPositionWithOffset + 27, textColorRegular);
		this.drawCenteredString(_mc.fontRenderer, "Required: " + this.displayedTalent.GetReqLevel(), xPositionWithOffset + 15, yPositionWithOffset + 37, textColorRegular);
		
		
		//	Draw the tooltip.
    }
	
	
	public void UpdatePosition(int _pageX)
	{
		this.xOffset = _pageX;
	}
	/**
     * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over this button and 2 if it IS hovering over
     * this button.
     */
	@Override
    protected int getHoverState(boolean mouseOver)
    {
    	return 1;
    }
	
	/**
     * Returns true if the mouse has been pressed on this control. Equivalent of MouseListener.mousePressed(MouseEvent
     * e).
     */
	@Override
    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
    {
		boolean test = this.enabled && this.visible && mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
		
		if(test)
		{
			System.out.println(this.buttonName);
		}
		
        return test;
    }

}
