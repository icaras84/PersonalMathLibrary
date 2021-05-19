package com.ryo616.Mathematics;

public class Vector3f {

	public float x, y, z;
	
	public Vector3f() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public Vector3f(float x, float y, float z) {
		this.x = x; 
		this.y = y;
		this.z = z;
	}
	
	public Vector3f(Vector2f a, float z) {
		this.x = a.x;
		this.y = a.y;
		this.z = z;
	}
	
	public Vector3f(float[] input) {
		this.x = input[0];
		this.y = input[1];
		this.z = input[2];
	}
	
	public Vector2f xy() {
		return new Vector2f(this.x, this.y);
	}
	
	public float[] toArray() {
		return new float[] {this.x, this.y, this.z};
	}
	
	public String toString() {
		return "X: " + this.x + " Y: " + this.y + " Z: " + this.z;
	}
	
	public float length() {
		return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}
	
	public void normalize() {
		float length = this.length();
		this.x /= length;
		this.y /= length;
		this.z /= length;
	}
	
	//Basic Mathematical Operations//
	
	public static Vector3f add(Vector3f a, Vector3f b) {
		return new Vector3f(a.x + b.x, a.y + b.y, a.z + b.z);
	}
	
	public static Vector3f sub(Vector3f a, Vector3f b) {
		return new Vector3f(a.x - b.x, a.y - b.y, a.z - b.z);
	}
	
	public static Vector3f mul(Vector3f a, float factor) {
		return new Vector3f(a.x * factor, a.y * factor, a.z * factor);
	}
	
	public static Vector3f div(Vector3f a, float factor) {
		return new Vector3f(a.x / factor, a.y / factor, a.z / factor);
	}
	
	public static float dot3d(Vector3f a, Vector3f b) {
		return a.x * b.x + a.y * b.y + a.z * b.x;
	}
	
	public static Vector3f lerp(Vector3f a, Vector3f b, float factor) {
		return new Vector3f(a.x + (b.x - a.x) * factor, a.y + (b.y - a.y) * factor, a.z + (b.z - a.z) * factor);
	}
	
	public static Vector3f reflect(Plane plane, Vector3f in) {
		Vector3f out = new Vector3f();
		
		Vector3f planePos = plane.pos.xyz();
		Vector3f planeDir = plane.dir.xyz();
		Vector3f inVec = Vector3f.sub(in, planePos);
		float scalar = Vector3f.dot3d(planeDir, inVec);
		Vector3f proj = Vector3f.lerp(new Vector3f(0, 0, 0), planeDir, scalar);
		out = Vector3f.add(proj, planePos);
		out = Vector3f.sub(in, out);
		out = Vector3f.mul(out, -1);
		out = Vector3f.add(out, planePos);
		out = Vector3f.add(out, proj);
		
		return out;
	}
}
