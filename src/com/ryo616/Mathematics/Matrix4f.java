package com.ryo616.Mathematics;

public class Matrix4f {

	public float[] matrix;
	
	public Matrix4f() {}
	
	public Matrix4f(float[] array) {
		
		if (array.length != 16) {
			throw new IllegalStateException("Error constructing Matrix! Passed in array length: " + array.length + " Intended array length: 16");
		}
		this.matrix = array;
		
	}
	
	public Matrix4f(float[] row1, float[] row2, float[] row3, float[] row4) {
		if (row1.length != 4) {throw new IllegalStateException("Error! row1 parameter is not the intended length of 4, actual length: " + row1.length);}
		if (row2.length != 4) {throw new IllegalStateException("Error! row2 parameter is not the intended length of 4, actual length: " + row2.length);}
		if (row3.length != 4) {throw new IllegalStateException("Error! row3 parameter is not the intended length of 4, actual length: " + row3.length);}
		if (row4.length != 4) {throw new IllegalStateException("Error! row4 parameter is not the intended length of 4, actual length: " + row4.length);}
		
		this.matrix[0] = row1[0]; this.matrix[1] = row1[1]; this.matrix[2] = row1[2]; this.matrix[3] = row1[3];
		this.matrix[4] = row2[0]; this.matrix[5] = row2[1]; this.matrix[6] = row2[2]; this.matrix[7] = row2[3];
		this.matrix[8] = row3[0]; this.matrix[9] = row3[1]; this.matrix[10] = row3[2]; this.matrix[11] = row3[3];
		this.matrix[12] = row4[0]; this.matrix[13] = row4[1]; this.matrix[14] = row4[2]; this.matrix[15] = row4[3];
	}
	/**
	 * This method makes the matrix into a String. 
	 */
	public String toString() {
		return (this.matrix[0] + " " + this.matrix[1] + " " + this.matrix[2] + " " + this.matrix[3] + " \n"
				+ this.matrix[4] + " " + this.matrix[5] + " " + this.matrix[6] + " " + this.matrix[7] + " \n"
				+ this.matrix[8] + " " + this.matrix[9] + " " + this.matrix[10] + " " + this.matrix[11] + " \n"
				+ this.matrix[12] + " " + this.matrix[13] + " " + this.matrix[14] + " " + this.matrix[15] + " \n");
	}
	
	/**
	 * 
	 * This method multiplies a Vector4f by a matrix
	 * 
	 * @param input
	 * @param matIn
	 * @return out
	 */
	public static Vector4f vMul(Vector4f input, Matrix4f matIn) {
		
		float[] out = new float[4];
		
		out[0] = matIn.matrix[0] * input.x + matIn.matrix[1] * input.y + matIn.matrix[2] * input.z + matIn.matrix[3] * input.w;
		out[1] = matIn.matrix[4] * input.x + matIn.matrix[5] * input.y + matIn.matrix[6] * input.z + matIn.matrix[7] * input.w;
		out[2] = matIn.matrix[8] * input.x + matIn.matrix[9] * input.y + matIn.matrix[10] * input.z + matIn.matrix[11] * input.w;
		out[3] = matIn.matrix[12] * input.x + matIn.matrix[13] * input.y + matIn.matrix[14] * input.z + matIn.matrix[15] * input.w;
		
		return new Vector4f(out);
	}
	
	/**
	 * 
	 * This method multiplies a float array representation of a Vector4f by a matrix
	 * 
	 * @param input
	 * @param matIn
	 * @return out
	 */
	public static float[] fMul(float[] input, Matrix4f matIn) {
		
		if (input != null && input.length != 4) {
			throw new IllegalStateException("Error! 'input' parameter is not 4 in length, actual length: " + input.length);
		}
		
		float[] out = new float[4];
		
		out[0] = matIn.matrix[0] * input[0] + matIn.matrix[1] * input[1] + matIn.matrix[2] * input[2] + matIn.matrix[3] * input[3];
		out[1] = matIn.matrix[4] * input[0] + matIn.matrix[5] * input[1] + matIn.matrix[6] * input[2] + matIn.matrix[7] * input[3];
		out[2] = matIn.matrix[8] * input[0] + matIn.matrix[9] * input[1] + matIn.matrix[10] * input[2] + matIn.matrix[11] * input[3];
		out[3] = matIn.matrix[12] * input[0] + matIn.matrix[13] * input[1] + matIn.matrix[14] * input[2] + matIn.matrix[15] * input[3];
		
		return out;
	}
	
	/**
	 * 
	 * Gets the column of a 4 by 4 matrix and the column number must be between 0 and 3
	 * 
	 * @param matIn
	 * @param colNumber
	 * @return output
	 */
	private static float[] getCol(Matrix4f matIn, int colNumber){
		
		if (colNumber / 3 > 1 || colNumber / 3 < 0) {
			throw new IllegalStateException("Error! colNumber is not valid, it must be a value between 0 and 3!");
		}
		
		float[] output = new float[] {matIn.matrix[0 + colNumber], matIn.matrix[4 + colNumber], matIn.matrix[8 + colNumber], matIn.matrix[12 + colNumber]};
		
		return output;
	}
	/**
	 * 
	 * Gets the row of a 4 by 4 matrix and the row number must be between 0 and 3
	 * 
	 * @param matIn
	 * @param rowNumber
	 * @return output
	 */
	private static float[] getRow(Matrix4f matIn, int rowNumber) {
		
		if ((rowNumber / 3) > 1 || (rowNumber / 3) < 0) {
			throw new IllegalStateException("Error! rowNumber is not valid, it must be a value between 0 and 3!");
		}
		
		float[] output = new float[] {matIn.matrix[4 * rowNumber], matIn.matrix[4 * rowNumber + 1], matIn.matrix[4 * rowNumber + 2], matIn.matrix[4 * rowNumber + 3]};
		
		return output;
	}
	
	/**
	 * 
	 * Takes the dot product of two float arrays of the same length
	 * 
	 * @param col
	 * @param row
	 * @return output
	 */
	private static float dotFloatArr(float[] col, float[] row) {
		if (col.length != 4 || row.length != 4) {throw new IllegalStateException("Error! col is " + col.length + " row is" + row.length + " Both must be the same length!");}
		return col[0] * row[0] + col[1] * row[1] + col[2] * row[2] + col[3] * row[3];
	}
	
	public static Matrix4f matrixMulMatrix(Matrix4f mat1, Matrix4f mat2) {
		
		float[][] cols = new float[][] {Matrix4f.getCol(mat2, 0), Matrix4f.getCol(mat2, 1), Matrix4f.getCol(mat2, 2), Matrix4f.getCol(mat2, 3)};
		float[][] rows = new float[][] {Matrix4f.getRow(mat1, 0), Matrix4f.getRow(mat1, 1), Matrix4f.getRow(mat1, 2), Matrix4f.getRow(mat1, 3)};
		float[] output = new float[16];
		
		for (int i = 0; i < 4; i++) {
			output[0 + i * 4] = Matrix4f.dotFloatArr(cols[0], rows[i]);
			output[1 + i * 4] = Matrix4f.dotFloatArr(cols[1], rows[i]);
			output[2 + i * 4] = Matrix4f.dotFloatArr(cols[2], rows[i]);
			output[3 + i * 4] = Matrix4f.dotFloatArr(cols[3], rows[i]);
		}
		
		return new Matrix4f(output);
	}
	
	public static Matrix4f add(Matrix4f a, Matrix4f b) {
		float[] mat1 = a.matrix;
		float[] mat2 = b.matrix;
		float[] output = new float[16];
		for (int i = 0; i < 16; i++) {
			output[i] = mat1[i] + mat2[i];
		}
		return new Matrix4f(output);
	}
	
	public static Matrix4f scalarMulti(Matrix4f a, Matrix4f b) {
		float[] mat1 = a.matrix;
		float[] mat2 = b.matrix;
		float[] output = new float[16];
		for (int i = 0; i < 16; i++) {
			output[i] = mat1[i] * mat2[i];
		}
		return new Matrix4f(output);
	}
	
}
