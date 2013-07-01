package me.kyle.RubiksCube.api;

public class Context {
	
	private CubeColor top;
	private CubeColor front;
	private Face face; 

	public Context(CubeColor top, CubeColor front, Face face){
		this.top = top;
		this.front = front;
		this.face = face;
	}
	
	CubeColor getTop(){
		return top;
	}
	
	CubeColor getFront(){
		return front;
	}
	
	Face getFace(){
		return face;
	}
	
	public enum Face{
		Top,
		Bottom,
		Left,
		Right,
		Front,
		Back
	}
	
}
