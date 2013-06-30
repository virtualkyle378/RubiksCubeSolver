package me.kyle.RubiksCube.api;

public class Context {
	
	private CubeColor top;
	private CubeColor front;

	public Context(CubeColor top, CubeColor front){
		this.top = top;
		this.front = front;
	}
	
	CubeColor getTop(){
		return top;
	}
	
	CubeColor getFront(){
		return front;
	}
	
}
