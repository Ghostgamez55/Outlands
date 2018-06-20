package com.outland.gui;

import net.minecraft.util.ResourceLocation;

public abstract class GuiTalentPageBase 
{
	public GuiButtonTalent[] talentButtonArray;
	public int pageID = 0;
	public String pageName = "";
	
	protected ResourceLocation pageTexture;
	
	public int pagePosX = 0, pagePosY = 0;
	
	public GuiTalentPageBase(int _id, String _name)
	{
		pageName = _name;
		pageID = _id;
	}
	
	
	public abstract void UpdateButtonList(int _xOffset);
	
	public abstract GuiButtonTalent[] CreateButtons(int _pageX, int _pageY);
	
	public abstract ResourceLocation GetPageTexture();
}