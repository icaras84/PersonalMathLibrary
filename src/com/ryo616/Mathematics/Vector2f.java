package com.ryo616.Mathematics;

public class Vector2f {

	public float x, y;
	
	public Vector2f() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2f(float[] input) {
		this.x = input[0];
		this.y = input[1];
	}
	
	public float[] toArray() {
		return new float[] {this.x, this.y};
	}
	
	public float length() {
		return (float) (Math.sqrt(this.x * this.x + this.y * this.y)); 
	}
	
	public void normalize() {
		float length = this.length();
		this.x /= length;
		this.y /= length;
	}
	
	//Basic Mathematical Operations//
	
	public static Vector2f add(Vector2f a, Vector2f b) {
		return new Vector2f(a.x + b.x, a.y + b.y);
	}
	
	public static Vector2f sub(Vector2f a, Vector2f b) {
		return new Vector2f(a.x - b.x, a.y - b.y);
	}
	
	public static Vector2f mul(Vector2f a, float factor) {
		return new Vector2f(a.x * factor, a.y * factor);
	}
	
	public static Vector2f div(Vector2f a, float factor) {
		return new Vector2f(a.x / factor, a.y / factor);
	}
	
	public static float dot2d(Vector2f a, Vector2f b) {
		return (a.x * b.x + a.y * b.y);
	}
	
	public static Vector2f lerp(Vector2f a, Vector2f b, float factor) {
		return new Vector2f(a.x + (b.x - a.x) * factor, a.y + (b.y - a.y) * factor);
	}
}
