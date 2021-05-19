package com.ryo616.Mathematics;

public class Plane {

	public Vector4f pos, dir;
	
	public Plane() {}
	
	public Plane(Vector4f pos, Vector4f dir) {
		this.pos = pos;
		this.dir = dir;
		this.dir.normalize();
	}
	
	public static float clipVector2f(Plane clipPlane, Vector2f lineStart, Vector2f lineEnd, Vector2f output) {
		
		Vector2f planeDir = clipPlane.dir.xy();
		Vector2f planePos = clipPlane.pos.xy();
		
		float plane_d = Vector2f.dot2d(planeDir, planePos);
		float ad = Vector2f.dot2d(lineStart, planeDir);
		float bd = Vector2f.dot2d(lineEnd, planeDir);
		float t = (plane_d - ad) / (bd - ad);
		
		if (output != null) {
			output.x = lineStart.x + (lineEnd.x - lineStart.x) * t;
			output.y = lineStart.y + (lineEnd.y - lineStart.y) * t;
		}
		
		return t;
	}
	/**
	 * Clips a passed in 3d line
	 * @param clipPlane : Plane : pos, dir
	 * @param lineStart : Start of the 3d line
	 * @param lineEnd : End of the 3d line
	 * @param output : Modified by reference to interpolate
	 * @return t : scalar value for interpolation
	 */
	public static float clipVector3f(Plane clipPlane, Vector3f lineStart, Vector3f lineEnd, Vector3f output) {
		
		Vector3f planeDir = clipPlane.dir.xyz();
		Vector3f planePos = clipPlane.pos.xyz();
		
		float plane_d = Vector3f.dot3d(planeDir, planePos);
		float ad = Vector3f.dot3d(lineStart, planeDir);
		float bd = Vector3f.dot3d(lineEnd, planeDir);
		float t = (plane_d - ad) / (bd - ad);
		
		if (output != null) {
			output.x = lineStart.x + (lineEnd.x - lineStart.x) * t;
			output.y = lineStart.y + (lineEnd.y - lineStart.y) * t;
			output.z = lineStart.z + (lineEnd.z - lineStart.z) * t;
		}
		
		return t;
	}
	/**
	 * Clips a passed in 4d line
	 * @param clipPlane : Plane : pos, dir
	 * @param lineStart : Start of the 4d line
	 * @param lineEnd : End of the 4d line
	 * @param output : Modified by reference to interpolate
	 * @return t : scalar value for interpolation
	 */
	public static float clipVector4f(Plane clipPlane, Vector4f lineStart, Vector4f lineEnd, Vector4f output) {
		
		Vector4f planeDir = clipPlane.dir;
		Vector4f planePos = clipPlane.pos;
		
		float plane_d = Vector4f.dot4d(planeDir, planePos); //add one because default value for W should be 0
		float ad = Vector4f.dot4d(lineStart, planeDir);
		float bd = Vector4f.dot4d(lineEnd, planeDir);
		float t = (plane_d - ad) / (bd - ad);
		
		if (output != null) {
			output.x = lineStart.x + (lineEnd.x - lineStart.x) * t;
			output.y = lineStart.y + (lineEnd.y - lineStart.y) * t;
			output.z = lineStart.z + (lineEnd.z - lineStart.z) * t;
			output.w = lineStart.w + (lineEnd.w - lineStart.w) * t;
		}
		
		return t;
	}
}
