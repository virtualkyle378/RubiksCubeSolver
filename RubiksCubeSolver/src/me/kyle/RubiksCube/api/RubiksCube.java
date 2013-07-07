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
		return null;
	}

	public CubeFace getRightFace() {
		return null;
	}

	public CubeFace getFrontFace() {
		return null;
	}
	
	public CubeFace getBackFace() {
		return null;
	}
	
	public CubeFace getTopFace() {
		return null;
	}
	
	public CubeFace getBottomFace() {
		return null;
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
	
	public void moveFace(CubeSurface frontface, ArrayList<CubeColor> topdedge, ArrayList<CubeColor> rightdedge, ArrayList<CubeColor> bottomface, ArrayList<CubeColor> leftface){
		
	}
	
	public void moveFaceInverted(CubeSurface frontface, ArrayList<CubeColor> topdedge, ArrayList<CubeColor> rightdedge, ArrayList<CubeColor> bottomface, ArrayList<CubeColor> leftface){
		
	}
}