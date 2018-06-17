package com.outland.talents;

import net.minecraft.util.ResourceLocation;

/**
 * @author Xcisso
 *	This is the base class that holds info about each talent.
 */
public class TalentBase 
{
	int talentID = 0;
	String talentName = "";
	String talentDescription = "";
	String talentIconName = "";
	
	ResourceLocation textureLocation;
	
	public TalentBase(int _id, String _name, String _desc, String _icon)
	{
		
	}
	
	private ResourceLocation createResourceLocForTalent()
	{
		return new ResourceLocation("olm:textures/talenticons/" + talentIconName + ".png");
	}
	
}
