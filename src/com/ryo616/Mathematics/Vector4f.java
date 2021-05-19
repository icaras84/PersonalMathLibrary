package com.ryo616.Mathematics;

public class Vector4f {

	public float x, y, z, w;
	
	public Vector4f() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.w = 0;
	}
	
	public Vector4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vector4f(Vector3f a, float w) {
		this.x = a.x;
		this.y = a.y;
		this.z = a.z;
		this.w = w;
	}
	
	public Vector4f(Vector2f a, float z, float w) {
		this.x = a.x;
		this.y = a.y;
		this.z = z;
		this.w = w;
	}
	
	public Vector4f(float[] input) {
		this.x = input[0];
		this.y = input[1];
		this.z = input[2];
		this.w = input[3];
	}
	
	public Vector2f xy() {
		return new Vector2f(this.x, this.y);
	}
	
	public Vector3f xyz() {
		return new Vector3f(this.x, this.y, this.z);
	}
	
	public float[] toArray() {
		return new float[] {this.x, this.y, this.z, this.w};
	}
	
	public String toString() {
		return "X: " + this.x + " Y: " + this.y + " Z: " + this.z + " W: " + this.w;
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
	
	//Basic Mathematical Operations//
	
	public static Vector4f add(Vector4f a, Vector4f b) {
		return new Vector4f(a.x + b.x, a.y + b.y, a.z + b.z, a.w + b.w);
	}
	
	public static Vector4f sub(Vector4f a, Vector4f b) {
		return new Vector4f(a.x - b.x, a.y - b.y, a.z - b.z, a.w - b.w);
	}
	
	public static Vector4f mul(Vector4f a, float factor) {
		return new Vector4f(a.x * factor, a.y * factor, a.z * factor, a.w * factor);
	}
	
	public static Vector4f div(Vector4f a, float factor) {
		return new Vector4f(a.x / factor, a.y / factor, a.z / factor, a.w / factor);
	}
	
	public static float dot4d(Vector4f a, Vector4f b) {
		return a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w;
	}
	
	public static Vector4f lerp(Vector4f a, Vector4f b, float factor) {
		return new Vector4f(a.x + (b.x - a.x) * factor, a.y + (b.y - a.y) * factor, a.z + (b.z - a.z) * factor, a.w + (b.w - a.w) * factor);
	}
}
