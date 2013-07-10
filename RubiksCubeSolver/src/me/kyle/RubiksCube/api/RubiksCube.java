package me.kyle.RubiksCube.api;

import java.util.ArrayList;

public class RubiksCube {
	
	private CubeSurface topFace;
	private CubeSurface frontFace;
	private CubeSurface bottomFace;
	private CubeSurface leftFace;
	private CubeSurface rightFace;
	private CubeSurface backFace;

	public RubiksCube(CubeWrapper wrapper){
		if (wrapper.topFace != null && wrapper.frontFace != null
				&& wrapper.bottomFace != null && wrapper.leftFace != null
				&& wrapper.rightFace != null && wrapper.backFace != null) {
			this.topFace = wrapper.topFace;
			this.frontFace = wrapper.frontFace;
			this.bottomFace = wrapper.bottomFace;
			this.leftFace = wrapper.leftFace;
			this.rightFace = wrapper.rightFace;
			this.backFace = wrapper.backFace;
		} else {
			throw new NullPointerException("All faces need not be null");
		}
	}
	
	public CubeFace getLeftFace() {//returns constructFace with desired arguments
		return new CubeFace(leftFace, topFace.getLeftDedge(), frontFace.getLeftDedge(), bottomFace.getLeftDedge(), backFace.getRightDedge());
	}

	public CubeFace getRightFace() {
		return new CubeFace(rightFace, topFace.getRightDedge(), backFace.getLeftDedge(), bottomFace.getRightDedge(), frontFace.getRightDedge());
	}

	public CubeFace getFrontFace() {
		return new CubeFace(frontFace, topFace.getBottomDedge(), rightFace.getLeftDedge(), bottomFace.getTopDedge(), leftFace.getRightDedge());
	}
	
	public CubeFace getBackFace() {
		return new CubeFace(backFace, topFace.getTopDedge(), leftFace.getLeftDedge(), bottomFace.getBottomDedge(), rightFace.getRightDedge());
	}
	
	public CubeFace getTopFace() {
		return new CubeFace(topFace, backFace.getTopDedge(), rightFace.getTopDedge(), frontFace.getTopDedge(), leftFace.getTopDedge());
	}
	
	public CubeFace getBottomFace() {
		return new CubeFace(bottomFace, frontFace.getBottomDedge(), rightFace.getBottomDedge(), backFace.getBottomDedge(), leftFace.getBottomDedge());
	}
	
	public void left(){
		
	}
	
	public void leftInverted(){
		
	}
	
	public void right(){
		
	}
	
	public void rightInverted(){
		
	}
	
	public void front(){
		
	}
	
	public void frontInverted(){
		
	}
	
	public void back(){
		
	}
	
	public void backInverted(){
		
	}
	
	public void top(){
		
	}
	
	public void topInverted(){
		
	}
	
	public void bottom(){
		
	}
	
	public void bottomInverted(){
		
	}
	
	public void moveFace(CubeSurface frontface, CubeDedge topdedge, CubeDedge rightdedge, CubeDedge bottomface, CubeDedge leftface){
		CubeColor[][] surface = frontface.surface;
		CubeColor temp = surface[0][1];
		surface[0][1] = surface [1][0];
		surface[1][0] = surface [2][1];
		surface[2][1] = surface [1][2];
		surface[0][1] = temp;
		temp = surface[0][0];
		surface[0][0] = surface [2][0];
		surface[2][0] = surface [2][2];
		surface[2][2] = surface [0][2];
		surface[0][2] = temp;
	}
	
	public void moveFaceInverted(CubeSurface frontface, CubeDedge topdedge, CubeDedge rightdedge, CubeDedge bottomface, CubeDedge leftface){
		
	}
}