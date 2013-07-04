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
	
	enum Face{
		Top(CubeColor.ORANGE),
		Bottom(CubeColor.ORANGE),
		Left(CubeColor.WHITE),
		Right(CubeColor.WHITE),
		Front(CubeColor.WHITE),
		Back(CubeColor.WHITE),;
		
		private CubeColor requiredfront;
		
		private Face(CubeColor requiredfront){
			this.requiredfront = requiredfront;
		}
		
		CubeColor requiredFront(){
			return requiredfront;
		}
	}
	
}
