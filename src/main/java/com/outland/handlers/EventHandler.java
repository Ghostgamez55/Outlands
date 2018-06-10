package com.outland.handlers;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import com.outland.main.OutlandMod;
import com.outland.renderers.RenderTalentScreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * @author Xcisso
 *
 *	This class handles all the event subscriptions, can use this to call a separate 
 *	class, but never subscribe to events outside this class
 */
@EventBusSubscriber
public class EventHandler 
{
	
	//	This event runs every single client tick. Be careful of how you use this one.
	@SubscribeEvent (priority = EventPriority.LOWEST)
	public static void onClientTick(TickEvent.ClientTickEvent _event)throws Exception 
	{
		if(KeyHandler.openGui_01.isPressed())
		{
			//	Set the players camera view to be first person. 0 first, 1 third, 2 third backwards
			OutlandMod.mc.gameSettings.thirdPersonView = 0;
			
			OutlandMod.mc.getRenderManager().setPlayerViewY(0);
			
			//	Open the gui.
			//	It keeps thrack of everything, and also creates the 3d rendered part of it.
			OutlandMod.mc.player.openGui(OutlandMod.instance, 0, OutlandMod.mc.world, 
					(int)OutlandMod.mc.player.posX, 
					(int)OutlandMod.mc.player.posY, 
					(int)OutlandMod.mc.player.posZ);
		}
	}
	
	
	/**
	 * This event runs after the rendering is done, and renders the player hand.
	 * @param _event The LastRenderTick event.
	 */
	@SubscribeEvent (priority = EventPriority.LOWEST)
	public static void onLastRenderTick(RenderWorldLastEvent _event)
	{
		//	Checking if the 3D render part of the talent screen is active, and tells it do do its render stuff.
		if(RenderTalentScreen.currentRenderer != null)
		{
			RenderTalentScreen.currentRenderer.OnRenderTick(_event.getPartialTicks());
		}
	}
	
	@SubscribeEvent
	public static void onGameOverlayRender(RenderGameOverlayEvent _event)
	{
		
			if(RenderTalentScreen.currentRenderer != null)
			{
				_event.setCanceled(true);
			}
	}
	
	@SubscribeEvent
	public static void onRenderPlayerHand(RenderHandEvent _event)
	{
			if(RenderTalentScreen.currentRenderer != null)
			{
				_event.setCanceled(true);
			}
	}
}
