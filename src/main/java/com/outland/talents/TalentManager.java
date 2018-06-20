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
	TalentBase[] talentList = new TalentBase[16];
	
	
	
	public TalentManager()
	{
		CreateTalents();
	}



	private void CreateTalents() 
	{
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
	
	public TalentBase getTalentWithID(int _id)
	{
		return this.talentList[_id];
	}
}