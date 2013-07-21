package me.kyle.RubiksCube.api;

public class CubeletLocation {
	
	public int x;
	public int y;
	public int z;
	
	public CubeletLocation(int x, int y, int z){
		if(x > 3 || y > 3 || z > 3)
			throw new IllegalArgumentException("Inputted x, y, and z must be between 0 and 3");
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}
