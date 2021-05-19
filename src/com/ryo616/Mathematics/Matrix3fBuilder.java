package com.ryo616.Mathematics;

public class Matrix3fBuilder {

	public static Matrix3f buildColumnMajorMatrix(float[] col1, float[] col2, float[] col3) {
		if (col1 != null && col1.length != 3) {throw new IllegalStateException("Error! col1 parameter is not the intended length of 3, actual length: " + col1.length);}
		if (col2 != null && col2.length != 3) {throw new IllegalStateException("Error! col2 parameter is not the intended length of 3, actual length: " + col2.length);}
		if (col3 != null && col3.length != 3) {throw new IllegalStateException("Error! col3 parameter is not the intended length of 3, actual length: " + col3.length);}
		
		return new Matrix3f(
		new float[] {col1[0], col1[1], col1[2],
					 col2[0], col2[1], col2[2],
					 col3[0], col3[1], col3[2]}
		);
	}
	
	public static Matrix3f buildIdentityMatrix() {
		return new Matrix3f(
		new float[] {1, 0, 0,
					 0, 1, 0,
					 0, 0, 1}
		);
	}
	
	public static Matrix3f buildScalingMatrix(float factor) {
		return new Matrix3f(
		new float[] {factor,      0,      0,
					      0, factor,      0,
					      0,      0, factor}
		);
	}
	
	public static Matrix3f buildDistortionMatrix(Vector3f factor) {
		return new Matrix3f(
		new float[] {factor.x,        0,        0,
					        0, factor.y,        0,
					        0,        0, factor.z}
		);
	}
	
	public static Matrix3f buildTranslationMatrix(Vector2f translation) {
		return new Matrix3f(
		new float[] {0, 0, translation.x,
					 0, 0, translation.y,
					 0, 0,             1}
		);
	}
	
	public static Matrix3f buildShearXMatrix(float factor) {
		return new Matrix3f(
		new float[] {1, factor, 0,
					 0,      1, 0,
					 0,      0, 1}
		);
	}
	
	public static Matrix3f buildShearYMatrix(float factor) {
		return new Matrix3f(
		new float[] {     1, 0, 0,
					 factor, 1, 0,
					      0, 0, 1}
		);
	}
	
	public static Matrix3f buildReflectX() {
		return new Matrix3f(
		new float[] {-1, 0, 0,
					  0, 1, 0,
					  0, 0, 1}
		);
	}
	
	public static Matrix3f buildReflectY() {
		return new Matrix3f(
		new float[] {1,  0, 0,
					 0, -1, 0,
					 0,  0, 1}
		);
	}
	
	public static Matrix3f buildRotationMatrix(float angle) {
		double theta = Math.toRadians(angle);
		float sin = (float) Math.sin(theta);
		float cos = (float) Math.cos(theta);
		return new Matrix3f(
		new float[] {cos, -sin, 0,
					 sin,  cos, 0,
					   0,  0,   1}
		);
	}
	
	public static Matrix3f buildRotationMatrix(Vector2f dir) {
		dir.normalize();
		float sin = Vector2f.dot2d(dir, new Vector2f(0, 1));
		float cos = Vector2f.dot2d(dir, new Vector2f(1, 0));
		return new Matrix3f(
		new float[] {cos, -sin, 0,
					 sin,  cos, 0,
					   0,    0, 1}
		);
	}
}
