package me.kyle.RubiksCube.api;

import java.util.ArrayList;

public class RubiksCube {
	
	private CubeSurface topFace;
	private CubeSurface frontFace;
	private CubeSurface bottomFace;
	private CubeSurface leftFace;
	private CubeSurface rightFace;
	private CubeSurface backFace;
	
	ArrayList<String> moves = new ArrayList<String>();
	boolean logMoves = false;

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
			throw new NullPointerException("All faces must not be null");
		}
	}
	
	public String[] getVaildFaces(){
		return new String[]{
			"L",
			"R",
			"F",
			"B",
			"T",
			"D",
		};
	}
	
	public CubeFace getFace(String face) {
		switch(face){
		case "L": return getLeftFace();
		case "R": return getRightFace();
		case "F": return getFrontFace();
		case "B": return getBackFace();
		case "T": return getTopFace();
		case "D": return getDownFace();
		default: return null;
		}
	}
	
	public CubeFace getLeftFace() {
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
	
	public CubeFace getDownFace() {
		return new CubeFace(bottomFace, frontFace.getBottomDedge(), rightFace.getBottomDedge(), backFace.getBottomDedge(), leftFace.getBottomDedge());
	}
	
	public String[] getFaceMoves(){
		return new String[]{
				"R","R'",
				"L","L'",
				"U","U'",
				"D","D'",
				"B","B'",
				"F","F'",
				"M","M'",
				"x","x'",
				"y","y'"
		};
	}
	
	public void moveFace(String move){
		switch(move){
		case "R":
			right();
			break;
		case "R'":
			rightInverted();
			break;
		case "L":
			left();
			break;
		case "L'":
			leftInverted();
			break;
		case "U":
			up();
			break;
		case "U'":
			upInverted();
			break;
		case "D":
			down();
			break;
		case "D'":
			downInverted();
			break;
		case "B":
			back();
			break;
		case "B'":
			backInverted();
			break;
		case "F":
			front();
			break;
		case "F'":
			frontInverted();
			break;
		case "M":
			middle();
			break;
		case "M'":
			middleInverted();
			break;
		case "x":
			x();
			break;
		case "x'":
			xInverted();
			break;
		case "y":
			y();
			break;
		case "y'":
			yInverted();
			break;
		default: throw new IllegalArgumentException(move + " is not a valid move");
		}
	}
	
	public void left(){
		submitMove("L");
		moveFace(leftFace, topFace.getLeftDedge(), frontFace.getLeftDedge(), bottomFace.getLeftDedge(), backFace.getRightDedge());
	}
	
	public void leftInverted(){
		submitMove("L'");
		moveFaceInverted(leftFace, topFace.getLeftDedge(), frontFace.getLeftDedge(), bottomFace.getLeftDedge(), backFace.getRightDedge());
	}
	
	public void right(){
		submitMove("R");
		moveFace(rightFace, topFace.getRightDedge(), backFace.getLeftDedge(), bottomFace.getRightDedge(), frontFace.getRightDedge());
	}
	
	public void rightInverted(){
		submitMove("R'");
		moveFaceInverted(rightFace, topFace.getRightDedge(), backFace.getLeftDedge(), bottomFace.getRightDedge(), frontFace.getRightDedge());
	}
	
	public void front(){
		submitMove("F");
		moveFace(frontFace, topFace.getBottomDedge(), rightFace.getLeftDedge(), bottomFace.getTopDedge(), leftFace.getRightDedge());
	}
	
	public void frontInverted(){
		submitMove("F'");
		moveFaceInverted(frontFace, topFace.getBottomDedge(), rightFace.getLeftDedge(), bottomFace.getTopDedge(), leftFace.getRightDedge());
	}
	
	public void back(){
		submitMove("B");
		moveFace(backFace, topFace.getTopDedge(), leftFace.getLeftDedge(), bottomFace.getBottomDedge(), rightFace.getRightDedge());
	}
	
	public void backInverted(){
		submitMove("B'");
		moveFaceInverted(backFace, topFace.getTopDedge(), leftFace.getLeftDedge(), bottomFace.getBottomDedge(), rightFace.getRightDedge());
	}
	
	public void up(){
		submitMove("U");
		moveFace(topFace, backFace.getTopDedge(), rightFace.getTopDedge(), frontFace.getTopDedge(), leftFace.getTopDedge());
	}
	
	public void upInverted(){
		submitMove("U'");
		moveFaceInverted(topFace, backFace.getTopDedge(), rightFace.getTopDedge(), frontFace.getTopDedge(), leftFace.getTopDedge());
	}
	
	public void down(){
		submitMove("D");
		moveFace(bottomFace, frontFace.getBottomDedge(), rightFace.getBottomDedge(), backFace.getBottomDedge(), leftFace.getBottomDedge());
	}
	
	public void downInverted(){
		submitMove("D'");
		moveFaceInverted(bottomFace, frontFace.getBottomDedge(), rightFace.getBottomDedge(), backFace.getBottomDedge(), leftFace.getBottomDedge());
	}
	
	public void middle(){
		submitMove("M");
		x();
		rightInverted();
		left();
	}
	
	public void middleInverted(){
		submitMove("M'");
		xInverted();
		right();
		leftInverted();
	}
	
	public void x(){
		submitMove("x");
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
		submitMove("x'");
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
		submitMove("y");
		rotateSurface(topFace);
		rotateSurfaceInverted(bottomFace);
		CubeSurface temp = new CubeSurface(frontFace);
		frontFace = rightFace;
		rightFace = backFace;
		backFace = leftFace;
		leftFace = temp;
	}
	
	public void yInverted(){
		submitMove("y'");
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
	
//	public CubeletLocation findEdgeCubelet(CubeColor side1, CubeColor side2){//0,0 is on top left of front face
//		
//	}
//	
//	private boolean edgeCubeletValid(EdgeCubelet cubelet, CubeColor color1, CubeColor color2){
//		return (cubelet.getFrontSide().getColor().equals(color1) && cubelet.getOffSide().getColor().equals(color2)) ||
//				(cubelet.getFrontSide().getColor().equals(color2) && cubelet.getOffSide().getColor().equals(color1));
//	}
//	
//	public CubeletLocation findCornerCubelet(CubeColor side1, CubeColor side2, CubeColor side3){//0,0 is on top left of front face
//		
//	}
	
//	private boolean cornerCubeletValid(CornerCubelet cubelet, CubeColor side1, CubeColor side2, CubeColor side3){
//		CubeColor[] colors = {side1, side2, side3};
//		int istrue = 0;
//		for (CubeColor orignal: new CubeColor[]{cubelet.getFrontSide().getColor(), cubelet.getOffSide().getColor(), cubelet.getVerticalSide().getColor()}) {
//			for (CubeColor i : colors) {
//				if (cubelet.getFrontSide().getColor().equals(i)) {
//					istrue++;
//					break;
//				}
//			}
//		}
//		return istrue == 3;
//	}
	
	public void enableMoveLogging(){
		logMoves = true;
	}
	
	public void disableMoveLogging(){
		logMoves = false;
	}
	
	public void clearMoveLog(){
		moves.clear();
	}
	
	public ArrayList<String> getMoveLog(){
		return moves;
	}
	
	private void submitMove(String move){
		moves.add(move);
	}
	
}