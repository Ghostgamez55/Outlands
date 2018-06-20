package com.outland.talents;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



/**
 * @author Xcisso
 *	Each player has its own PlayerTalentInstance bound to them when they enter the server.
 *	We create one class on the server side, for each player, and one on the client side for the owning player.
 *	All changes happens through the server, to prevent cheating.
 */
public class PlayerTalentInstance 
{
	int experience = 0;
	int[] learnedTalents = new int[0];
}
