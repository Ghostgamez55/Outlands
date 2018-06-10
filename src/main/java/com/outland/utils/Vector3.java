package com.outland.utils;

import net.minecraft.util.math.Vec3d;

/**
 * 	@author Xcisso
 *	A simplified version of unity's vector 3.
 *	Its a class that i like working with, and use a lot when doing 3d rendering.
 *	Please leave as is.
 */
public class Vector3
{
	public double X, Y, Z;
	
	
	/**
	 * Creates a new Vector3 with X, Y and Z of zero.
	 */
	public Vector3()
	{
		X = 0;
		Y = 0;
		Z = 0;
	}
	
	/**
	 * Sets the X, Y and Z to the passed double.
	 * @param _value the X, Y and Z value
	 */
	public Vector3(double _value)
	{
		X = _value;
		Y = _value;
		Z = _value;
	}
	
	/**
	 * Sets the X and Y value, and leaves the Z value at 0.
	 * Used as a Vector2 if you only need X and Y.
	 * 
	 * @param _x The X value of the vector.
	 * @param _y The Y value of the vector.
	 */
	public Vector3(double _x, double _y)
	{
		X = _x;
		Y = _y;
		Z = 0;
	}
	
	/**
	 * Creates a vector 3 with the passed values for X, Y and Z.
	 * 
	 * @param _x The X value of the vector.
	 * @param _y The Y value of the vector.
	 * @param _z The Z value of the vector.
	 */
	public Vector3(double _x, double _y, double _z)
	{
		X = _x;
		Y = _y;
		Z = _z;
	}
	
	
	/**
	 * Creates and returns a new vector3 with all values at 0.
	 * 
	 * @return a new Vector3
	 */
	public static Vector3 Zero()
	{
		return new Vector3(0, 0, 0);
	}
	
	/**
	 * Creates and returns a new vector3 with all values at 1.
	 * 
	 * @return A new Vector3
	 */
	public static Vector3 One()
	{
		return new Vector3(1, 1, 1);
	}
	
	/**
	 * A simple vector lerp.
	 * It lerps between 2 vectors, and returns a new vector with the interpolated values.
	 * 
	 * @param _a Vector to blend from.
	 * @param _b Vector to blend to.
	 * @param _f The lerp value, constrained between 0 and 1.
	 * @return A new vector with the lerped values.
	 */
	public static Vector3 Lerp(Vector3 _a, Vector3 _b, float _f)
	{
		float blendValue = Math.max(0, Math.min(1, _f));
		return new Vector3((_a.X*(1-_f)) + (_b.X * _f), (_a.Y*(1-_f)) + (_b.Y * _f), (_a.Z*(1-_f)) + (_b.Z * _f));
	}
	
	@Override
	public String toString()
	{
		return String.format("X:%1$f Y:%2$f Z:%3$f", X, Y, Z);
		
	}
	
	public static Vector3 FromVec3d(Vec3d _vec)
	{
		return new Vector3(_vec.x, _vec.y, _vec.z);
	}
	
	public static Vector3 Add(Vector3 _a, Vector3 _b)
	{
		Vector3 returnVector = new Vector3();
		returnVector.X = _a.X + _b.X;
		returnVector.Y = _a.Y + _b.Y;
		returnVector.Z = _a.Z + _b.Z;
		
		return returnVector;
	}
	public static Vector3 Sub(Vector3 _a, Vector3 _b)
	{
		Vector3 returnVector = new Vector3();
		returnVector.X = _a.X - _b.X;
		returnVector.Y = _a.Y - _b.Y;
		returnVector.Z = _a.Z - _b.Z;
		
		return returnVector;
	}
	
	public static Vector3 Multiply(Vector3 _a, Vector3 _b)
	{

		Vector3 returnVector = new Vector3();
		returnVector.X = _a.X * _b.X;
		returnVector.Y = _a.Y * _b.Y;
		returnVector.Z = _a.Z * _b.Z;
		
		return returnVector;
	}
	
	public static Vector3 Multiply(Vector3 _a, int _i)
	{

		Vector3 returnVector = new Vector3();
		returnVector.X = _a.X * _i;
		returnVector.Y = _a.Y * _i;
		returnVector.Z = _a.Z * _i;
		
		return returnVector;
	}
}
