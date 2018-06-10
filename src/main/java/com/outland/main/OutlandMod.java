package com.outland.main;

import com.outland.Items.ItemArmorBase;
import com.outland.Items.ItemBase;
import com.outland.handlers.GuiHandler;
import com.outland.handlers.KeyHandler;
import com.outland.proxy.CommonProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = OutlandMod.MOD_ID, name = OutlandMod.MOD_NAME, version = OutlandMod.MOD_VERSION)
public class OutlandMod 
{
	public static final String MOD_ID = "olm"; //	OutLandMod
	public static final String MOD_NAME = "Outland RPG? Mod";
	public static final String MOD_VERSION = "alpha 1.0.0";
	
	public static final String CLIENT_PROXY_CLASS = "com.outland.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.outland.proxy.CommonProxy";
	 
	@Instance("olm")
	 public static OutlandMod instance;
	
	 @SidedProxy(clientSide = OutlandMod.CLIENT_PROXY_CLASS, serverSide = OutlandMod.COMMON_PROXY_CLASS)
	 public static CommonProxy proxy;
	 
	 
	 /**
	 * 	The instance of our GuiHandler
	 */
	private GuiHandler guiHandler = new GuiHandler();
	 
	 
	 /**
	 * A refrence to the minecraft instance.
	 */
	public static Minecraft mc;
	 
	 
	/**
	 * A refrence to our custom KeyHandler class.
	 * This class manages custom keybinds and keybord events.
	 */
	private KeyHandler keyHandler;
	

	
//	Creative Tabs
	 public static CreativeTabs modTab = new CreativeTabs("outland.tab1") {
		 
		@Override
		public ItemStack getTabIconItem() 
		{
			 return new ItemStack(Items.COAL);
		}
	 };

	 
	 public OutlandMod()
	 {
		 //	First we reference this class in the instance variable
		 instance = this;
		 
		 //	Then we get a reference to the current instance of Minecraft.
		 //	This is for easy reference to other classes in this mod.
		 mc = Minecraft.getMinecraft();
		 
		 keyHandler = new KeyHandler();
		 
		 for(int i = 0; i < 5; i++)
		 {
			 System.out.println("Initialized the mod!");
		 }
	 }

	 
	 @EventHandler
	 public void preInit(FMLPreInitializationEvent _event)
	 {
		 System.out.println("Running Event....");
		 System.out.println(_event.toString());
		 
		 CreateItems();
		 
	 }


	@EventHandler
    public void init(FMLInitializationEvent _event)
    {
		 System.out.println("Running Event....");
		 System.out.println(_event.toString());
		 
		 
		 NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, guiHandler);
		 
    }
	 
	 
	 @EventHandler
	 public void load(FMLLoadEvent  _event)
	 {
		 System.out.println("Running Event....");
		 System.out.println(_event.toString());
	 }
	 
	 @EventHandler
	 public void loadComplete(FMLLoadCompleteEvent _event)
	 {
		 System.out.println("Running Event....");
		 System.out.println(_event.toString());
	 }
	 
	 
	 //	Custom methods
	 

		/*
		 * ITEMS
		 */
		public static Item testItem;
		public static Item itemDeerHide;
		public static Item itemCyclopsEye;
		public static Item itemCookedDuckMeat;
		public static Item itemDuckFeather;
		public static Item itemRawDuckMeat;
		public static Item itemGoldCoin;
		
		public static Item itemVikingHelmet = new ItemArmorBase(ArmorMaterial.IRON, 0, EntityEquipmentSlot.HEAD)
				.setUnlocalizedName("vikinghelmet")
				.setRegistryName("vikinghelmet");
	 
	 /**
	 * 	This method creates all the items.
	 */
	private void CreateItems() 
	 {
		//	Regular items
		 this.testItem  = new ItemBase("testitem");
		 this.itemDeerHide = new ItemBase("deerhide");
		 this.itemCyclopsEye = new ItemBase("cyclopseye");
		 this.itemCookedDuckMeat = new ItemBase("cooked_duck_meat");
		 this.itemDuckFeather = new ItemBase("duckfeather");
		 this.itemRawDuckMeat = new ItemBase("raw_duck_meat");
		 this.itemGoldCoin = new ItemBase("gold_coin");
		 
		 //	Food items
		 
		 
		 //	Armor items
		 
	 }

}
