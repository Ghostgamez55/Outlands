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
	int numberOfPoints = 0;
	int requiredLevel = 0;
	
	ResourceLocation textureLocation;
	
	public TalentBase(int _id, String _name, String _desc, int _maxPoints, int _reqLevel)
	{
		talentID = _id;
		talentName = _name;
		talentDescription = _desc;
		numberOfPoints = _maxPoints;
		requiredLevel = _reqLevel;
	}
	
	private ResourceLocation createResourceLocForTalent()
	{
		return new ResourceLocation("olm:textures/talenticons/" + talentIconName + ".png");
	}
	
}
