package com.outland.Items;

import com.outland.main.OutlandMod;
import com.outland.models.ModelVikingHelmet;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArmorBase extends ItemArmor
{

	public ItemArmorBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) 
	{
		super(materialIn, renderIndexIn, equipmentSlotIn);
		
		this.setCreativeTab(OutlandMod.modTab);
		
		ItemBase.itemsToRegister.add(this);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase _entLiving, ItemStack _is, EntityEquipmentSlot _slot, ModelBiped _default)
	{
		if(!_is.isEmpty())
		{
			if(_is.getItem() instanceof ItemArmor)
			{
				ModelVikingHelmet helmet = new ModelVikingHelmet();
				
				return new ModelVikingHelmet();
			}
		}
		
		return null;
	}
}
