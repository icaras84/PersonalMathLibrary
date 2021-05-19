package com.ryo616.Mathematics;

public class Quaternion {

	public float x, y, z, w;
	
	public Quaternion() {}
	
	public Quaternion(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Quaternion(Vector4f ijk) {
		this.x = ijk.x;
		this.y = ijk.y;
		this.z = ijk.z;
		this.w = ijk.w;
	}
	
	public float length() {
		return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
	}
	
	public void normalize() {
		float length = this.length();
		
		this.x /= length;
		this.y /= length;
		this.z /= length;
		this.w /= length;
	}
	
	public Quaternion conjugate() {
		return new Quaternion(this.x * -1, this.y * -1, this.z * -1, w);
	}
	
	public Vector4f toVector4f() {
		return new Vector4f(this.x, this.y, this.z, this.w);
	}
	
	public String toString() {
		return "X: " + this.x + " Y: " + this.y + " Z: " + this.z + " W: " + this.w; 
	}
	
	public static Quaternion qMul(Quaternion a, Quaternion b) {
		
		float w_ = a.w * b.w - a.x * b.x - a.y * b.y - a.z * b.z;
		float x_ = a.x * b.w + a.w * b.x + a.y * b.z - a.z * b.y;
		float y_ = a.y * b.w + a.w * b.y + a.z * b.x - a.x * b.z;
		float z_ = a.z * b.w + a.w * b.z + a.x * b.y - a.y * b.x;
		
		return new Quaternion(x_, y_, z_, w_);
	}
	
	public static Quaternion vMul(Quaternion a, Vector3f b) {
		
		float w_ = -a.x * b.x - a.y * b.y - a.z * b.z;
		float x_ = a.w * b.x + a.y * b.z - a.z * b.y;
		float y_ = a.w * b.y + a.z * b.x - a.x * b.z;
		float z_ = a.w * b.z + a.x * b.y - a.y * b.x;
		
		return new Quaternion(x_, y_, z_, w_);
	}
	
	
}
