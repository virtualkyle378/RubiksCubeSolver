package me.kyle.RubiksCube.api;

public class CubeletFacet {
	CubeColor color;
	CubeColor parentcolor;
	
	public CubeColor getParentColor(){
		return parentcolor;
	}
	
	public CubeColor getColor(){
		return color;
	}
}
