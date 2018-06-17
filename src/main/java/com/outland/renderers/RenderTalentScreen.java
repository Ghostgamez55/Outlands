package com.outland.renderers;

import org.lwjgl.opengl.GL11;

import com.outland.gui.GuiTalentScreen;
import com.outland.utils.Vector3;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

/**
 * @author Xcisso
 *	This class manages the 3d rendering part of the talent screen.
 *	Please notice me if you want to make any changes.
 *	
 *	TODO:
 *	NOTE: 	I'm setting this 3d renderer on pause, and i'm creating a 2d gui for the talent screen.
 *			This is because i simply dont have enough time to do this besides work at the moment.
 *
 */
public class RenderTalentScreen 
{
	public static RenderTalentScreen currentRenderer;
	
	//	The necessary instances needed for rendering the screen.
	Minecraft mc;
	RenderManager rm;
	Tessellator tessellator;
	BufferBuilder vertexBuffer;
	FontRenderer fr;
	EntityPlayerSP player;
	GuiTalentScreen parentGui;
	

	
	//	This is the position offset in the world of the players edge of the screen. 
	//	Multiply this by the distance away from the camera
	double baseXPosition = 1.25d;
	double baseYPosition = 0.7d;
	double unitsPerPixel = 0.0052356020942408d;
	
	
	/*
	 * TODO: Get rid of this
	 * Box Size Variables
	 */
	Vector3 backGroundSize = new Vector3(8, 2);
	Vector3 backGroundPos = new Vector3(0, 0, 60);
	
	Vector3 sideSize = new Vector3(25, 4);
	
	
	//	Texture variables.
	
	ResourceLocation defaultTexture = new ResourceLocation("olm:textures/gui/talentscreen/background.png");
	ResourceLocation cursorTexture = new ResourceLocation("olm:textures/gui/guitalents.png");
	
	/**
	 * 	This is the forward direction of the player.
	 * 	Used to calculate a position in front of the player camera.
	 */
	Vector3 playerLookDirection = new Vector3();
	
	
	/**
	 * 
	 * 	This is the constructor, it sets everything that this class needs.
	 * 
	 * 	Will most likely always be created from GuiTalentScreen.
	 */
	public RenderTalentScreen(GuiTalentScreen _parentGui, Minecraft _mc, RenderManager _rm, Tessellator _ts, BufferBuilder _bb, FontRenderer _fr)
	{
		mc = _mc;
		rm = _rm;
		tessellator = _ts;
		vertexBuffer = _bb;
		fr = _fr;
		player = mc.player;
		parentGui = _parentGui;
		
		OnGuiEnable();
	}
	
	
	
	/**
	 * Called on each render tick,
	 * render the talent screen ui here.
	 */
	public void OnRenderTick(float _deltaTime)
	{
		
		double X = 0;
		double Y = 0;
		double Z = 0;
		
		
		Vector3 size = new Vector3();
		
		GL11.glPushMatrix();
		GL11.glTranslated(0, player.eyeHeight, 0);//	Setting Y to be the height of the camera, so that everything rotates around
		GL11.glRotatef((float) -rm.playerViewY, 0.0F, 1.0F, 0.0F);		//	the camera point
		GL11.glRotatef((float) rm.playerViewX, 1.0F, 0.0F, 0.0F);
		
		
		
		//GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDepthMask(false);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		//GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_NORMALIZE);
		//GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4d(1, 1, 1, 1);
		
		this.BindTexture(defaultTexture);
		
		//	Get the forward look direction of the player.
		Entity ent = mc.getRenderViewEntity();
		this.playerLookDirection = Vector3.FromVec3d(ent.getForward().normalize());
		
		
		
		//	Do render stuff here
		
		vertexBuffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
		{
			Vector3 tempPos = new Vector3();
			
			tempPos = Vector3.Add(tempPos, Vector3.Multiply(this.playerLookDirection, 50));
			
			Vec3d tempPos2 = new Vec3d(0, 0, 0);
			
			tempPos2 = this.player.getPositionVector().subtract(ent.getPositionVector());
			
			//Background Plane
			Z = 20;
			
			X = 0;
			Y = 0;

			size.X = 26.4 - (0.055d);//this.baseXPosition * Z;
			System.out.println(this.baseXPosition * Z + "");
			size.Y = this.baseXPosition * Z / 2;
			
			double uv = 1/3.2d;
			double lerpUV = 1/3.2d * this.parentGui.mouseXP;
			
			
			vertexBuffer.pos(X - size.X, Y + size.Y, Z);
			vertexBuffer.tex(lerpUV + uv, 0);
			vertexBuffer.endVertex();

			vertexBuffer.pos(X + size.X, Y + size.Y, Z);
			vertexBuffer.tex(lerpUV, 0);
			vertexBuffer.endVertex();

			vertexBuffer.pos(X + size.X, Y - size.Y, Z);
			vertexBuffer.tex(lerpUV, 1);
			vertexBuffer.endVertex();

			vertexBuffer.pos(X - size.X, Y - size.Y, Z);
			vertexBuffer.tex(lerpUV + uv, 1);
			vertexBuffer.endVertex();
			
			
			
		}
		tessellator.draw();

		
		vertexBuffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
		{
			//	Draw the cursor box.
			
			this.BindTexture(cursorTexture);

			Z = 1;
			//X = Z * this.baseXPosition;
			//X = -this.Lerp(0, X * 2, this.parentGui.mouseXP) + X;
			//Y = Z * this.baseYPosition;
			//Y = -this.Lerp(0, Y*2, this.parentGui.mouseYP) + Y;
			
			X = 0.0936d * 9.4;
			
			size.X = this.unitsPerPixel * 15;
			size.Y = this.unitsPerPixel * 15;
			
			vertexBuffer.pos(X - size.X, Y + size.Y, Z);
			vertexBuffer.tex(1, 0);
			vertexBuffer.endVertex();

			vertexBuffer.pos(X + size.X, Y + size.Y, Z);
			vertexBuffer.tex(0, 0);
			vertexBuffer.endVertex();

			vertexBuffer.pos(X + size.X, Y - size.Y, Z);
			vertexBuffer.tex(0, 1);
			vertexBuffer.endVertex();

			vertexBuffer.pos(X - size.X, Y - size.Y, Z);
			vertexBuffer.tex(1, 1);
			vertexBuffer.endVertex();
			
		}
		tessellator.draw();
		

		
		
		//	End render stuff here.	
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_NORMALIZE);
		//GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glPopMatrix();
	}
	
	
	private void DrawQuad(double _posX, double _posY, double _posZ, Vector3 _size)
	{
		vertexBuffer.pos(_posX - _size.X, _posY + _size.Y, _posZ);
		vertexBuffer.tex(1, 0);
		vertexBuffer.endVertex();

		vertexBuffer.pos(_posX + _size.X, _posY + _size.Y, _posZ);
		vertexBuffer.tex(0, 0);
		vertexBuffer.endVertex();

		vertexBuffer.pos(_posX + _size.X, _posY - _size.Y, _posZ);
		vertexBuffer.tex(0, 1);
		vertexBuffer.endVertex();

		vertexBuffer.pos(_posX - _size.X, _posY - _size.Y, _posZ);
		vertexBuffer.tex(1, 1);
		vertexBuffer.endVertex();
		
	}
	
	private void DrawCube(double _posX, double _posY, double _posZ, double _size)
	{
		//	Front
		vertexBuffer.pos(_posX - _size, _posY + _size, _posZ - _size);
		vertexBuffer.tex(1, 0);
		vertexBuffer.endVertex();
	
		vertexBuffer.pos(_posX + _size, _posY + _size, _posZ - _size);
		vertexBuffer.tex(0, 0);
		vertexBuffer.endVertex();
	
		vertexBuffer.pos(_posX + _size, _posY - _size, _posZ - _size);
		vertexBuffer.tex(0, 1);
		vertexBuffer.endVertex();
	
		vertexBuffer.pos(_posX - _size, _posY - _size, _posZ - _size);
		vertexBuffer.tex(1, 1);
		vertexBuffer.endVertex();
		return;
		/*
		//	top
		vertexBuffer.pos(_posX - _size, _posY + _size, _posZ + _size);
		vertexBuffer.tex(1, 1);
		vertexBuffer.endVertex();
		
		vertexBuffer.pos(_posX - _size, _posY + _size, _posZ - _size);
		vertexBuffer.tex(1, 0);
		vertexBuffer.endVertex();

		vertexBuffer.pos(_posX + _size, _posY + _size, _posZ - _size);
		vertexBuffer.tex(0, 0);
		vertexBuffer.endVertex();

		vertexBuffer.pos(_posX + _size, _posY + _size, _posZ + _size);
		vertexBuffer.tex(0, 1);
		vertexBuffer.endVertex();
		*/
	}
	
	
	
	public void OnGuiEnable()
	{
		currentRenderer = this;
	}
			
	public void OnGuiDisable()
	{
		currentRenderer = null;
	}
	
	private void BindTexture(ResourceLocation _loc)
	{
		mc.getTextureManager().bindTexture(_loc);
	}
	
	private double Lerp(double _a, double _b, double _t)
	{
		double returnValue = (1-_t) * _a + _t * _b;
		if(returnValue < 0)
			returnValue *= -1;
		return returnValue;
	}
	
}
