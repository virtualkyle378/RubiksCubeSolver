package me.kyle.RubiksCube.api;

public class CubeletLocation {
	
	int x;
	int y;
	
	public CubeletLocation(int x, int y){
		if(Math.abs(x) > 1 || Math.abs(y) > 1)
			throw new IllegalArgumentException("Inputted x and y must be between 1 and -1");
		this.x = x;
		this.y = y;
	}
	
}
