package me.kyle.RubiksCube.api;

public abstract class Cubelet {
	
	protected CubeletFacet frontside;
	
	public CubeletFacet getFrontSide(){
		return frontside;
	}
}
