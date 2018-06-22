package com.outland.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class GuiTalentPageMining extends GuiTalentPageBase
{

	public GuiTalentPageMining(int _id, String _name) 
	{
		super(_id, _name);
		
		this.pageTexture = new ResourceLocation("olm:textures/gui/talentscreen/talentpage_mining.png");
	}
	
	
	
	@Override
	public GuiButtonTalent[] CreateButtons(int _pageX, int _pageY)
	{
		this.pagePosX = _pageX;
		this.pagePosY = _pageY;
		
		//	This is the position we want the button to be on the texture. We have to subtract 15 from this value(half the talent button size)
		int nextButtonX = 0;
		int nextButtonY = 0;
		
		GuiButtonTalent[] tempButtons = new GuiButtonTalent[3];
		
		nextButtonX = 128;
		nextButtonY = 195;
		tempButtons[0] = new GuiButtonTalent(4, pagePosX + nextButtonX - 15, pagePosY + nextButtonY - 15, this.pageName + " " + this.pageID, 0);

		nextButtonX = 128;
		nextButtonY = 150;
		tempButtons[1] = new GuiButtonTalent(4, pagePosX + nextButtonX - 15, pagePosY + nextButtonY - 15, this.pageName + " " + this.pageID, 1);

		nextButtonX = 128;
		nextButtonY = 29;
		tempButtons[2] = new GuiButtonTalent(4, pagePosX + nextButtonX - 15, pagePosY + nextButtonY - 15, this.pageName + " " + this.pageID, 2);
		
		
		this.talentButtonArray = tempButtons;
		return tempButtons;
	}



	@Override
	public void UpdateButtonList(int _xOffset) 
	{
		
		if(this.talentButtonArray != null)
			for(int i = 0; i < this.talentButtonArray.length; i++)
			{
				if(this.talentButtonArray[i] != null)
					this.talentButtonArray[i].UpdatePosition(_xOffset + (GuiTalentScreen.instance.pageWidth * this.pageID));
			}
	}



	@Override
	public ResourceLocation GetPageTexture() 
	{
		return this.pageTexture;
	}


}
