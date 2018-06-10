package com.outland.handlers;

import com.outland.Blocks.BlockBase;
import com.outland.Items.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

/**
 * @author Xcisso
 * 
 *	This class manages all the registering of blocks, items and everything else that needs registering.
 *	Please keep all registering here, to keep everything clean, thanks :D
 *
 */
@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegisterEvent(RegistryEvent.Register<Item> _event)
	{
		if(ItemBase.itemsToRegister.size() > 0)
		{
			//ModelLoader.setCustomModelResourceLocation(testItem, 0, new ModelResourceLocation(testItem.getRegistryName(), "testitem"));
			
			//_event.getRegistry().registerAll(ItemBase.itemsToRegister.toArray(new Item[0]));
			
			Item tempItem;
			
			for(int i = 0; i < ItemBase.itemsToRegister.size(); i++)
			{
				tempItem = ItemBase.itemsToRegister.get(i);
				_event.getRegistry().register(tempItem);
				ModelLoader.setCustomModelResourceLocation(tempItem, 
						0, 
						new ModelResourceLocation(
													tempItem.getRegistryName(), 
													tempItem.getUnlocalizedName()
													));
			}
		}
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> _event)
	{
		if(BlockBase.blocksToRegister.size() > 0)
		{
			_event.getRegistry().registerAll(BlockBase.blocksToRegister.toArray(new Block[0]));
		}
	}
	
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityEntry> _e) 
	{
		
	}


}
