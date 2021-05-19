package com.ryo616.Mathematics;

public class Transformation4f {

	private Matrix4f global_matrix, local_matrix;
	private Vector3f local_pos, global_pos, local_rotation, global_rotation;

	public Transformation4f() {
		this.global_matrix = Matrix4fBuilder.buildIdentityMatrix();
		this.local_matrix = Matrix4fBuilder.buildIdentityMatrix();
	}

	public static Transformation4f createTransformation() {
		return new Transformation4f();
	}

	public Vector4f transformVertex(Vector4f input) {
		Vector4f output; 
		output = Matrix4f.vMul(input, this.local_matrix);
		output = Matrix4f.vMul(output, this.global_matrix);
		return output;
	}

	public void setLocalPosition(Vector3f newPos) {
		this.local_pos = newPos;
		Matrix4f translate = Matrix4fBuilder.buildTranslationMatrix(this.local_pos);
		Matrix4f rotate = Matrix4fBuilder.buildGeneralRotation(this.local_rotation.x, this.local_rotation.y, this.local_rotation.z);
		this.local_matrix = Matrix4f.matrixMulMatrix(translate, rotate);
	}

	public void setLocalRotation(Vector3f newRotation) {
		this.local_rotation = newRotation;
		Matrix4f translate = Matrix4fBuilder.buildTranslationMatrix(this.local_pos);
		Matrix4f rotate = Matrix4fBuilder.buildGeneralRotation(this.local_rotation.x, this.local_rotation.y, this.local_rotation.z);
		this.local_matrix = Matrix4f.matrixMulMatrix(translate, rotate);
	}
	
	public void setGlobalPosition(Vector3f newPosition) {
		this.global_pos = newPosition;
		Matrix4f translate = Matrix4fBuilder.buildTranslationMatrix(this.global_pos);
		Matrix4f rotate = Matrix4fBuilder.buildGeneralRotation(this.global_rotation.x, this.global_rotation.y, this.global_rotation.z);
		this.local_matrix = Matrix4f.matrixMulMatrix(translate, rotate);
	}
	
	public void setGlobalRotation(Vector3f newRotation) {
		this.global_rotation = newRotation;
		Matrix4f translate = Matrix4fBuilder.buildTranslationMatrix(this.global_pos);
		Matrix4f rotate = Matrix4fBuilder.buildGeneralRotation(this.global_rotation.x, this.global_rotation.y, this.global_rotation.z);
		this.local_matrix = Matrix4f.matrixMulMatrix(translate, rotate);
	}

	public void resetGlobalMatrix() {
		this.global_matrix = Matrix4fBuilder.buildIdentityMatrix();
		this.global_pos = new Vector3f(0, 0, 0);
		this.global_rotation = new Vector3f(0, 0, 0);
	}

	public void resetLocalMatrix() {
		this.local_matrix = Matrix4fBuilder.buildIdentityMatrix();
		this.local_pos = new Vector3f(0, 0, 0);
		this.local_rotation = new Vector3f(0, 0, 0);
	}

	public void resetAllMatrices() {
		this.resetGlobalMatrix();
		this.resetLocalMatrix();
	}
}
