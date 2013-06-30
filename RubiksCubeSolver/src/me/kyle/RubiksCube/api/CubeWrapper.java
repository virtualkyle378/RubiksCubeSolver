package me.kyle.RubiksCube.api;

public class CubeWrapper {
	
	/*
	 * white on bottom; top is towards the front face
	 * all side faces are top facing yellow
	 * top is top facing back
	 */
	CubeSurface topFace;
	CubeSurface fontFace;
	CubeSurface bottomFace;
	CubeSurface leftFace;
	CubeSurface rightFace;
	CubeSurface backFace;
	
	
	public void setFace(CubeSurface surface, Context context){
		
	}
	
	enum Colors{
		White,
		Yellow,
		Red,
		Orange,
		Blue,
		Green,
	}
	
}
