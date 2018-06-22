package com.outland.talents;



/**
 * @author Xcisso
 * 	This class handles the talents. All the talents available are in the talentList.
 *
 */
public class TalentManager 
{
	
	/**
	 * This is the list of the existing talents. The index in the array, represents our own ID.
	 */
	static TalentBase[] talentList = new TalentBase[16];
	
	
	public static void CreateTalents() 
	{
		//	The talent IDs as well as the index it is in the list has to match, AND it has to be manually set.
		//	This is because we want the spell IDs to match our google document..
		
		/*
		 * MINING TALENTS
		 */
		talentList[0] = new TalentBase(0, "Lucky Ores", 
				"Increases the chance to drop an extra item when mining by 5% for each point.", 
				5, 0);
		talentList[1] = new TalentBase(1, "Hardened Pickaxe", 
				"Gives the player a 5% chance to not damage the pickaxe when mining.", 
				3, 15);
		talentList[2] = new TalentBase(2, "Swift-axe", 
				"Increases the mining speed by 7.5% for each point", 
				3, 25);
		talentList[3] = new TalentBase(3, "Dwarven Mystery Box", 
				"Increases the chance of dropping a Dwarven Mystery Box by 2% when mining minable blocks", 
				5, 40);
		talentList[4] = new TalentBase(4, "The Dwarf-th Sense", 
				"Unlocks the spell - Dwarf Vision", 
				1, 75);
		talentList[5] = new TalentBase(5, "Double-Up", 
				"When destroying a minable block, it has a 2% chance to destroy a block nearby as well.", 
				5, 40);
		talentList[6] = new TalentBase(6, "Mining Shout", 
				"Unlocks the spell - Mining Shout", 
				1, 75);
		
	}
	
	/**
	 * Gets a talent with a specified ID.
	 * @param _id The id of the talent you want to get.
	 * @return Returns the talent with the passed id.
	 */
	public static TalentBase getTalentWithID(int _id)
	{
		return talentList[_id];
	}
	
	/**
	 * Gets a talent by name, if it exists. Return null if the name don't match.
	 * Its a lot more efficient to get talents by ID. Only use this if you REALLY need to.
	 * @param _name The name of the talent you want to get.
	 * @return Returns the talent with the passed name, if it cant find it, returns null.
	 */
	public static TalentBase getTalentWithName(String _name)
	{
		String query = _name.toLowerCase();
		TalentBase returnTalent;
		
		for(int i = 0; i < talentList.length; i++)
		{
			
			if(talentList[i] != null)
			{
				returnTalent = talentList[i];
				if(query.equalsIgnoreCase(returnTalent.talentName))
					return returnTalent;
			}
		}
		/*
		 * If we reach this, it means that the name did not match any talents in the talent list..
		 */
		return null;
	}
	
	
	
	/**
	 * 	This function is used to convert the buttonTalent button ID to a spell ID
	 */
	public static int GetTalentIDFromButtonID(int _buttonID)
	{
		return 0;
	}
	
	/**
	 * 	This function returns a custom button id from the guipage its on, and the spell id you want to display.
	 */
	public static int GetButtonIDFromTalentAndPageID(int _pageID, int _talentID)
	{
		return 0;
	}
}