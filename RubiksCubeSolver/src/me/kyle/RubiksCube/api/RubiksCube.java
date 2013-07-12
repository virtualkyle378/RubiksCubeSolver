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
		moveFace(leftFace, topFace.getLeftDedge(), frontFace.getLeftDedge(), bottomFace.getLeftDedge(), backFace.getRightDedge());
	}
	
	public void leftInverted(){
		moveFaceInverted(leftFace, topFace.getLeftDedge(), frontFace.getLeftDedge(), bottomFace.getLeftDedge(), backFace.getRightDedge());
	}
	
	public void right(){
		moveFace(rightFace, topFace.getRightDedge(), backFace.getLeftDedge(), bottomFace.getRightDedge(), frontFace.getRightDedge());
	}
	
	public void rightInverted(){
		moveFaceInverted(rightFace, topFace.getRightDedge(), backFace.getLeftDedge(), bottomFace.getRightDedge(), frontFace.getRightDedge());
	}
	
	public void front(){
		moveFace(frontFace, topFace.getBottomDedge(), rightFace.getLeftDedge(), bottomFace.getTopDedge(), leftFace.getRightDedge());
	}
	
	public void frontInverted(){
		moveFaceInverted(frontFace, topFace.getBottomDedge(), rightFace.getLeftDedge(), bottomFace.getTopDedge(), leftFace.getRightDedge());
	}
	
	public void back(){
		moveFace(backFace, topFace.getTopDedge(), leftFace.getLeftDedge(), bottomFace.getBottomDedge(), rightFace.getRightDedge());
	}
	
	public void backInverted(){
		moveFaceInverted(backFace, topFace.getTopDedge(), leftFace.getLeftDedge(), bottomFace.getBottomDedge(), rightFace.getRightDedge());
	}
	
	public void up(){
		moveFace(topFace, backFace.getTopDedge(), rightFace.getTopDedge(), frontFace.getTopDedge(), leftFace.getTopDedge());
	}
	
	public void upInverted(){
		moveFaceInverted(topFace, backFace.getTopDedge(), rightFace.getTopDedge(), frontFace.getTopDedge(), leftFace.getTopDedge());
	}
	
	public void down(){
		moveFace(bottomFace, frontFace.getBottomDedge(), rightFace.getBottomDedge(), backFace.getBottomDedge(), leftFace.getBottomDedge());
	}
	
	public void downInverted(){
		moveFaceInverted(bottomFace, frontFace.getBottomDedge(), rightFace.getBottomDedge(), backFace.getBottomDedge(), leftFace.getBottomDedge());
	}
	
	public void x(){
		rotateSurface(rightFace);
		rotateSurfaceInverted(leftFace);
		CubeSurface temp = new CubeSurface(topFace);
		topFace = frontFace;
		frontFace = bottomFace;
		bottomFace = backFace;
		rotateSurfaceTwice(bottomFace);
		backFace = temp;
		rotateSurfaceTwice(backFace);
	}
	
	public void xInverted(){
		rotateSurfaceInverted(rightFace);
		rotateSurface(leftFace);
		CubeSurface temp = new CubeSurface(topFace);
		topFace = backFace;
		rotateSurfaceTwice(topFace);
		backFace = bottomFace;
		rotateSurfaceTwice(backFace);
		bottomFace = frontFace;
		frontFace = temp;
	}
	
	public void y(){
		rotateSurface(topFace);
		rotateSurfaceInverted(bottomFace);
		CubeSurface temp = new CubeSurface(frontFace);
		frontFace = rightFace;
		rightFace = backFace;
		backFace = leftFace;
		leftFace = temp;
	}
	
	public void yInverted(){
		rotateSurfaceInverted(topFace);
		rotateSurface(bottomFace);
		CubeSurface temp = new CubeSurface(frontFace);
		frontFace = leftFace;
		leftFace = backFace;
		backFace = rightFace;
		rightFace = temp;
	}
	
	public void moveFace(CubeSurface frontface, CubeDedge topdedge, CubeDedge rightdedge, CubeDedge bottomdedge, CubeDedge leftdedge){
		CubeletFacet[][] surface = frontface.surface;
		CubeColor temp = surface[0][1].color;//store by value not by ref
		surface[0][1].color = surface [1][0].color;
		surface[1][0].color = surface [2][1].color;
		surface[2][1].color = surface [1][2].color;
		surface[1][2].color = temp;
		temp = surface[0][0].color;
		surface[0][0].color = surface [2][0].color;
		surface[2][0].color = surface [2][2].color;
		surface[2][2].color = surface [0][2].color;
		surface[0][2].color = temp;
		CubeDedge dedge = new CubeDedge(topdedge);//create clone
		topdedge.changeTo(leftdedge);
		leftdedge.changeTo(bottomdedge);
		bottomdedge.changeTo(rightdedge);
		rightdedge.changeTo(dedge);
	}
	
	public void moveFaceInverted(CubeSurface frontface, CubeDedge topdedge, CubeDedge rightdedge, CubeDedge bottomdedge, CubeDedge leftdedge){
		CubeletFacet[][] surface = frontface.surface;
		CubeColor temp = surface[0][1].color;
		surface[0][1].color = surface [1][2].color;
		surface[1][2].color = surface [2][1].color;
		surface[2][1].color = surface [1][0].color;
		surface[1][0].color = temp;
		temp = surface[0][0].color;
		surface[0][0].color = surface [0][2].color;
		surface[0][2].color = surface [2][2].color;
		surface[2][2].color = surface [2][0].color;
		surface[2][0].color = temp;
		CubeDedge dedge = new CubeDedge(topdedge);
		topdedge.changeTo(rightdedge);
		rightdedge.changeTo(bottomdedge);
		bottomdedge.changeTo(leftdedge);
		leftdedge.changeTo(dedge);
	}
	
	private void rotateSurface(CubeSurface face){
		CubeletFacet[][] surface = face.surface;
		CubeColor temp = surface[0][1].color;
		surface[0][1].color = surface [1][0].color;
		surface[1][0].color = surface [2][1].color;
		surface[2][1].color = surface [1][2].color;
		surface[1][2].color = temp;
		temp = surface[0][0].color;
		surface[0][0].color = surface [2][0].color;
		surface[2][0].color = surface [2][2].color;
		surface[2][2].color = surface [0][2].color;
		surface[0][2].color = temp;
	}
	
	private void rotateSurfaceInverted(CubeSurface face){
		CubeletFacet[][] surface = face.surface;
		CubeColor temp = surface[0][1].color;
		surface[0][1].color = surface [1][2].color;
		surface[1][2].color = surface [2][1].color;
		surface[2][1].color = surface [1][0].color;
		surface[1][0].color = temp;
		temp = surface[0][0].color;
		surface[0][0].color = surface [0][2].color;
		surface[0][2].color = surface [2][2].color;
		surface[2][2].color = surface [2][0].color;
		surface[2][0].color = temp;
	}
	
	private void rotateSurfaceTwice(CubeSurface face){
		rotateSurface(face);
		rotateSurface(face);
	}
	
}