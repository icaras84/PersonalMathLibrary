package com.ryo616.Mathematics;

public class Matrix3f {

	public float[] matrix;
	
	public Matrix3f() {}
	
	public Matrix3f(float[] array) {
		if (array.length != 9) {
			throw new IllegalStateException("Error constructing Matrix! Passed in array length: " + array.length + " Intended array length: 9");
		}
		
		this.matrix = array;
	}
	
	public Matrix3f(float[] row1, float[] row2, float[] row3) {
		if (row1.length != 3) {throw new IllegalStateException("Error! row1 parameter is not the intended length of 3, actual length: " + row1.length);}
		if (row2.length != 3) {throw new IllegalStateException("Error! row2 parameter is not the intended length of 3, actual length: " + row2.length);}
		if (row3.length != 3) {throw new IllegalStateException("Error! row3 parameter is not the intended length of 3, actual length: " + row3.length);}
		
		this.matrix[0] = row1[0]; this.matrix[1] = row1[1]; this.matrix[2] = row1[2];
		this.matrix[3] = row2[0]; this.matrix[4] = row2[1]; this.matrix[5] = row2[2];
		this.matrix[6] = row3[0]; this.matrix[7] = row3[1]; this.matrix[8] = row3[2];
	}
	
	public String toString() {
		return (this.matrix[0] + " " + this.matrix[1] + " " + this.matrix[2] + " \n"
				+ this.matrix[3] + " " + this.matrix[4] + " " + this.matrix[5] + " \n"
				+ this.matrix[6] + " " + this.matrix[7] + " " + this.matrix[8] + " \n");
	}
	
	public static Vector3f vMul(Vector3f input, Matrix3f matIn) {
		
		float[] out = new float[3];
		
		out[0] = matIn.matrix[0] * input.x + matIn.matrix[1] * input.y + matIn.matrix[2] * input.z;
		out[1] = matIn.matrix[3] * input.x + matIn.matrix[4] * input.y + matIn.matrix[5] * input.z;
		out[2] = matIn.matrix[6] * input.x + matIn.matrix[7] * input.y + matIn.matrix[8] * input.z;
		
		return new Vector3f(out);
	}
	
	public static Vector3f fMul(float[] input, Matrix3f matIn) {
		
		if (input != null && input.length != 3) {throw new IllegalStateException("Error! 'input' parameter is not 3 in length, actual length: " + input.length);}
		
		float[] out = new float[3];
		
		out[0] = matIn.matrix[0] * input[0] + matIn.matrix[1] * input[1] + matIn.matrix[2] * input[2];
		out[1] = matIn.matrix[3] * input[0] + matIn.matrix[4] * input[1] + matIn.matrix[5] * input[2];
		out[2] = matIn.matrix[6] * input[0] + matIn.matrix[7] * input[1] + matIn.matrix[8] * input[2];
		
		return new Vector3f(out);
	}
	
	private static float dotFloatArr(float[] arr1, float[] arr2) {
		return arr1[0] * arr2[0] + arr1[1] * arr2[1] + arr1[2] * arr2[2];
	}
	
	private static float[] getCol(Matrix3f matIn, int num) {
		return new float[] {matIn.matrix[num], matIn.matrix[num + 3], matIn.matrix[num + 6]};
	}
	
	private static float[] getRow(Matrix3f matIn, int num) {
		return new float[] {matIn.matrix[num * 3], matIn.matrix[num * 3 + 1], matIn.matrix[num * 3 + 2]};
	}
	
	public static Matrix3f matrixMulMatrix(Matrix3f mat1, Matrix3f mat2) {
		float[][] cols = new float[][] {Matrix3f.getCol(mat2, 0), Matrix3f.getCol(mat2, 1), Matrix3f.getCol(mat2, 2)};
		float[][] rows = new float[][] {Matrix3f.getRow(mat1, 0), Matrix3f.getRow(mat1, 1), Matrix3f.getRow(mat1, 2)};
		float[] output = new float[9];
		
		for (int i = 0; i < 3; i++) {
			output[0 + i * 3] = Matrix3f.dotFloatArr(cols[0], rows[i]);
			output[1 + i * 3] = Matrix3f.dotFloatArr(cols[1], rows[i]);
			output[2 + i * 3] = Matrix3f.dotFloatArr(cols[2], rows[i]);
		}
		
		return new Matrix3f(output);
	}
	
	public static Matrix3f add(Matrix3f a, Matrix3f b) {
		float[] mat1 = a.matrix;
		float[] mat2 = b.matrix;
		float[] output = new float[9];
		for (int i = 0; i < 9; i++) {
			output[i] = mat1[i] + mat2[i];
		}
		return new Matrix3f(output);
	}
	
	public static Matrix3f scalarMulti(Matrix3f a, Matrix3f b) {
		float[] mat1 = a.matrix;
		float[] mat2 = b.matrix;
		float[] output = new float[9];
		for (int i = 0; i < 9; i++) {
			output[i] = mat1[i] * mat2[i];
		}
		return new Matrix3f(output);
	}
}
