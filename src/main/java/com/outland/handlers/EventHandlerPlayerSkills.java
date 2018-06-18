package com.outland.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventHandlerPlayerSkills 
{

		@SubscribeEvent
		public static void onLivingDamagedEvent(LivingDamageEvent _event)
		{
		}
		
		@SubscribeEvent
		public static void onLivingDealDamageEvent(LivingAttackEvent _event)
		{
		}
		
		/**	Called whenever player attacks and entity. Both server side and client side.
		 * @param _event
		 */
		@SubscribeEvent
		public static void onPlayerAttackEntity(AttackEntityEvent _event)
		{
			
			
		}
}
