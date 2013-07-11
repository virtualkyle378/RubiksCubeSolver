package me.kyle.RubiksCube.api;

public class CubeletFacet {
	CubeColor color;
	CubeColor parentcolor;
	
	CubeletFacet(CubeColor color, CubeColor parentcolor){
		this.color = color;
		this.parentcolor = parentcolor;
	}
	
	CubeletFacet(CubeletFacet old){
		this.color = old.color;
		this.parentcolor = old.parentcolor;
	}
	
	public CubeColor getParentColor(){
		return parentcolor;
	}
	
	public CubeColor getColor(){
		return color;
	}
}
