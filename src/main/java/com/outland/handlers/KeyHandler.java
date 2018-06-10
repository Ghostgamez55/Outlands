package com.outland.handlers;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;


@EventBusSubscriber
public class KeyHandler 
{
	public static String keyBindCategory = "key.categories.outlandmod";
	
	
	/**
	 * 	The custom keybind for opening the talent screen
	 * 	default: K
	 */
	public static KeyBinding openGui_01;
	public static String openGui_01_name = "key.opengui01";
	
	
	public KeyHandler()
	{
		RegisterKeys();
	}
	
	
	/**
	 * Register our custom keybinds here
	 */
	private void RegisterKeys() 
	{
		openGui_01 = new KeyBinding(openGui_01_name, Keyboard.KEY_K, keyBindCategory);
		ClientRegistry.registerKeyBinding(openGui_01);
	}


	@SubscribeEvent
	public void onKeyInput(KeyInputEvent _event)
	{
		System.out.println("Key Pressed!!");
	}
}
