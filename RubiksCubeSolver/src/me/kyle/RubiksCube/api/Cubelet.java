package me.kyle.RubiksCube.api;

public abstract class Cubelet {
	CubeletFacet frontside;
	CubeletFacet offside;
	
	public CubeletFacet getFrontSide(){
		return frontside;
	}
	
	public CubeletFacet getOffSide(){
		return offside;
	}
}
