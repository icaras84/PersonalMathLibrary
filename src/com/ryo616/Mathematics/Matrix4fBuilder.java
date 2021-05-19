package com.ryo616.Mathematics;

public class Matrix4fBuilder {

	/**
	 * 
	 * This method provides convenient translates a column-major matrix into a row-major matrix, the standard for mathematics
	 * 
	 * @param col1
	 * @param col2
	 * @param col3
	 * @param col4
	 * @return Matrix4f
	 */
	public static Matrix4f buildColumnMajorMatrix(float[] col1, float[] col2, float[] col3, float[] col4) {
		if (col1 != null && col1.length != 4) {throw new IllegalStateException("Error! col1 parameter is not the intended length of 4, actual length: " + col1.length);}
		if (col2 != null && col2.length != 4) {throw new IllegalStateException("Error! col2 parameter is not the intended length of 4, actual length: " + col2.length);}
		if (col3 != null && col3.length != 4) {throw new IllegalStateException("Error! col3 parameter is not the intended length of 4, actual length: " + col3.length);}
		if (col4 != null && col4.length != 4) {throw new IllegalStateException("Error! col4 parameter is not the intended length of 4, actual length: " + col4.length);}
		
		return new Matrix4f(
		new float[] {col1[0], col1[1], col1[2], col1[3],
					 col2[0], col2[1], col2[2], col2[3],
					 col3[0], col3[1], col3[2], col3[3],
					 col4[0], col4[1], col4[2], col4[3]}
		);
	}
	/**
	 * This method returns an identity matrix, when a vector or float array is multiplied by this, the output will be the same as the input
	 * @return Matrix4f
	 */
	public static Matrix4f buildIdentityMatrix() {
		return new Matrix4f(
		new float[] {1, 0, 0, 0, //first row
					 0, 1, 0, 0, //second row
					 0, 0, 1, 0, //third row
					 0, 0, 0, 1} //forth row
		);
	}
	/**
	 * This method constructs a matrix that, when a vector or float array is multiplied, scales all components by the factor that this matrix was constructed with
	 * @param factor
	 * @return Matrix4f
	 */
	public static Matrix4f buildScalingMatrix(float factor) {
		return new Matrix4f(
		new float[] {factor,      0,      0,      0, //first row
					      0, factor,      0,      0, //second row
					      0,      0, factor,      0, //third row
					      0,      0,      0, factor} //forth row
		);
	}
	/**
	 * This method is a more general scaling method, allowing you to distort individual elements of a float array or vector
	 * @param factor
	 * @return Matrix4f
	 */
	public static Matrix4f buildDistortionMatrix(Vector4f factor) {
		return new Matrix4f(
		new float[] {factor.x,        0,        0,        0, //first row
					        0, factor.y,        0,        0, //second row
					        0,        0, factor.z,        0, //third row
					        0,        0,        0, factor.w} //forth row
		);
	}
	
	/**
	 * This method generates a translation matrix so that vectors, or float arrays, multiplied with it would be translated correctly (assuming the w component of the vector begin multiplied is 1)
	 * @param translation
	 * @return Matrix4f
	 */
	public static Matrix4f buildTranslationMatrix(Vector3f translation) {
		return new Matrix4f(
		new float[] {1, 0, 0, translation.x, //first row
					 0, 1, 0, translation.y, //second row
					 0, 0, 1, translation.z, //third row
					 0, 0, 0,             1} //forth row
		);
	}
	
	public static Matrix4f buildShearX(float shearY, float shearZ) {
		return new Matrix4f(
		new float[] {     1, 0, 0, 0,
					 shearY, 1, 0, 0,
					 shearZ, 0, 1, 0,
					      0, 0, 0, 1}
		);
	}
	
	public static Matrix4f buildShearY(float shearX, float shearZ) {
		return new Matrix4f(
		new float[] {1, shearX, 0, 0,
					 0,      1, 0, 0,
					 0, shearZ, 1, 0,
					 0,      0, 0, 1}
		);
	}
	
	public static Matrix4f buildShearZ(float shearX, float shearY) {
		return new Matrix4f(
		new float[] {1, 0, shearX, 0,
					 0, 1, shearY, 0,
					 0, 0,      1, 0,
					 0, 0,      0, 1}
		);
	}
	
	/**
	 * This method returns a matrix that when multiplied by a vector, the output will be reflected across the X axis
	 * @return Matrix4f
	 */
	public static Matrix4f buildReflectX() {
		return new Matrix4f(
		new float[] {-1, 0, 0, 0, //first row
					  0, 1, 0, 0, //second row
					  0, 0, 1, 0, //third row
					  0, 0, 0, 1} //forth row
		);
	}
	
	/**
	 * This method returns a matrix that when multiplied by a vector, the output will be reflected across the Y axis
	 * @return Matrix4f
	 */
	public static Matrix4f buildReflectY() {
		return new Matrix4f(
		new float[] {1,  0, 0, 0, //first row
					 0, -1, 0, 0, //second row
					 0,  0, 1, 0, //third row
					 0,  0, 0, 1} //forth row
		);
	}
	
	/**
	 * This method returns a matrix that when multiplied by a vector, the output will be reflected across the Z axis
	 * @return Matrix4f
	 */
	public static Matrix4f buildReflectZ() {
		return new Matrix4f(
		new float[] {1, 0,  0, 0, //first row
					 0, 1,  0, 0, //second row
					 0, 0, -1, 0, //third row
					 0, 0,  0, 1} //forth row
		);
	}
	
	/**
	 * This method returns a matrix that when multiplied by a vector, the output will be reflected across the X and Z axes
	 * @return Matrix4f
	 */
	public static Matrix4f  buildReflectXZ() {
		return new Matrix4f(
		new float[] {-1, 0,  0, 0, //first row
					  0, 1,  0, 0, //second row
					  0, 0, -1, 0, //third row
					  0, 0,  0, 1} //forth row
		);
	}
	
	/**
	 * This method returns a matrix that when multiplied by a vector, the output will be reflected across the X and Y axes
	 * @return Matrix4f
	 */
	public static Matrix4f buildReflectXY() {
		return new Matrix4f(
		new float[] {-1,  0, 0, 0, //first row
					  0, -1, 0, 0, //second row
					  0,  0, 1, 0, //third row
					  0,  0, 0, 1} //forth row
		);
	}
	
	/**
	 * This method returns a matrix that when multiplied by a vector, the output will be reflected across the Y and Z axes
	 * @return Matrix4f
	 */
	public static Matrix4f buildReflectYZ() {
		return new Matrix4f(
		new float[] {1,  0,  0, 0, //first row
					 0, -1,  0, 0, //second row
					 0,  0, -1, 0, //third row
					 0,  0,  0, 1} //forth row
		);
	}
	
	/**
	 * This method returns a matrix that when multiplied by a vector, the output will be reflected across the X, Y, and Z axes
	 * @return Matrix4f
	 */
	public static Matrix4f buildMirror() {
		return new Matrix4f(
		new float[] {-1,  0,  0, 0, //first row
					  0, -1,  0, 0, //second row
					  0,  0, -1, 0, //third row
					  0,  0,  0, 1} //forth row
		);
	}
	
	/**
	 * This method creates a matrix that creates a rotation around the X axis
	 * @param angle
	 * @return Matrix4f
	 */
	public static Matrix4f buildRotateX(float angle) {
		float theta = (float) Math.toRadians(angle);
		float sin = (float) Math.sin(theta);
		float cos = (float) Math.cos(theta);
		return new Matrix4f(
		new float[] {1,   0,    0,  0, //first row
					 0, cos, -sin,  0, //second row
					 0, sin,  cos,  0, //third row
					 0,   0,    0,  1} //forth row
		);
	}
	
	/**
	 * This method creates a matrix that creates a rotation around the Y axis
	 * @param angle
	 * @return Matrix4f
	 */
	public static Matrix4f buildRotateY(float angle) {
		float theta = (float) Math.toRadians(angle);
		float sin = (float) Math.sin(theta);
		float cos = (float) Math.cos(theta);
		return new Matrix4f(
		new float[] { cos, 0, sin, 0, //first row
					    0, 1,   0, 0, //second row
					 -sin, 0, cos, 0, //third row
					    0, 0,   0, 1} //forth row
		);
	}
	
	/**
	 * This method creates a matrix that creates a rotation around the Z axis
	 * @param angle
	 * @return Matrix4f
	 */
	public static Matrix4f buildRotateZ(float angle) {
		float theta = (float) Math.toRadians(angle);
		float sin = (float) Math.sin(theta);
		float cos = (float) Math.cos(theta);
		return new Matrix4f(
		new float[] {cos,-sin,  0, 0, //first row
					 sin, cos,  0, 0, //second row
					   0,   0,  1, 0, //third row
					   0,   0,  0, 1} //forth row
		);
	}
	
	/**
	 * 
	 * This method creates a rotation matrix that is the combination of the X, Y, Z rotation matrices
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return Matrix4f
	 */
	public static Matrix4f buildGeneralRotation(float x, float y, float z) {
		Matrix4f output = Matrix4fBuilder.buildRotateY(y);
		output = Matrix4f.matrixMulMatrix(output, Matrix4fBuilder.buildRotateZ(z));
		output = Matrix4f.matrixMulMatrix(output, Matrix4fBuilder.buildRotateX(x));
		return output;
	}
	
	/**
	 * 
	 * This method converts a quaternion into a rotation matrix.
	 * 
	 * @param q
	 * @return Matrix4f
	 */
	public static Matrix4f buildQuaternionMatrix(Quaternion q) {
		return new Matrix4f(
		new float[] {2 * (q.w * q.w + q.x * q.x) - 1,     2 * (q.x * q.y - q.w * q.z),     2 * (q.x * q.z + q.w * q.y), 0, //first row
					     2 * (q.x * q.y + q.w * q.z), 2 * (q.w * q.w + q.y * q.y) - 1,     2 * (q.y * q.z - q.w * q.x), 0, //second row
					     2 * (q.x * q.z - q.w * q.y),     2 * (q.y * q.z + q.w * q.x), 2 * (q.w * q.w + q.z * q.z) - 1, 0, //third row
					                               0,                               0,                               0, 1} //forth row
		);
	}
	/**
	 * 
	 * @param width
	 * @param height
	 * @param fov
	 * @param nearPlane
	 * @param farPlane
	 * @return Matrix4f
	 */
	public static Matrix4f buildProjectionMatrix(float width, float height, float fov, float nearPlane, float farPlane) {
		float zq = farPlane / (farPlane - nearPlane);
		float f = (float) (1/Math.tan(Math.toRadians(fov/2)));
		return new Matrix4f(
		new float[] {height / width * f, 0,  0,               0, //first row
					                  0, f,  0,               0, //second row
					                  0, 0, zq, -nearPlane * zq, //third row
					                  0, 0, -1,               0} //forth row
		);
	}
	
	/**
	 * This is a method in which will return the transformations required to move the vectors of the world so that a camera can be moved and rotated in the world
	 * @param cam
	 * @return Matrix4f
	 */
	public static Matrix4f buildCameraMatrix(Vector3f pos, Vector3f right, Vector3f up, Vector3f forward) {
		
		Vector3f a = right;
		Vector3f b = up;
		Vector3f c = forward;
		Vector3f t = Vector3f.mul(pos, -1);
		
		return new Matrix4f(
		new float[] {a.x, a.y, a.z, Vector3f.dot3d(a, t),
					 b.x, b.y, b.z, Vector3f.dot3d(b, t),
					 c.x, c.y, c.z, Vector3f.dot3d(c, t),
					   0,   0,   0,                    1}
		);
	}
}
