package com.outland.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiButtonTalent extends GuiButton
{

	public GuiButtonTalent(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) 
	{
		super(buttonId, x, y, widthIn, heightIn, buttonText);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
     * Draws this button to the screen.
     */
	@Override
    public void drawButton(Minecraft _mc, int _mouseX, int _mouseY, float _partialTicks)
    {
    	super.drawButton(_mc, _mouseX, _mouseY, _partialTicks);
    }

}
