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
		if(!context.getFront().equals(context.getFace().requiredFront())){
			throw new IllegalArgumentException("The Front must be: " + context.getFace().requiredFront().toString());
		}
		if(!context.getTop().equals(surface.surface[1][1])){
			throw new IllegalArgumentException("The surface center is not consistant with the inputted context top face");
		}
		switch (context.getFace()) {
		case Back:
			backFace = surface;
			break;
		case Bottom:
			bottomFace = surface;
			break;
		case Front:
			fontFace = surface;
			break;
		case Left:
			leftFace = surface;
			break;
		case Right:
			rightFace = surface;
			break;
		case Top:
			topFace = surface;
			break;
		default:
			throw new NullPointerException("Context cannot be null!");
		}
	}
}
