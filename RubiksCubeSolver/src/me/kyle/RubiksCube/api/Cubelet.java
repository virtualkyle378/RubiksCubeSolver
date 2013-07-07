package me.kyle.RubiksCube.api;

public abstract class Cubelet {
	protected CubeletFacet frontside;
	protected CubeletFacet offside;
	
	public CubeletFacet getFrontSide(){
		return frontside;
	}
	
	public CubeletFacet getOffSide(){
		return offside;
	}
}
