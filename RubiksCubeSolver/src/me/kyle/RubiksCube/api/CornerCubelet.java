package me.kyle.RubiksCube.api;

public class CornerCubelet extends Cubelet {

	private CubeletFacet verticalside;
	
	CornerCubelet(CubeletFacet frontside, CubeletFacet offside, CubeletFacet verticalside) {
		this.frontside = frontside;
		this.offside =  offside;
		this.verticalside = verticalside;
	}
	
	public CubeletFacet getVerticalSide(){
		return verticalside;
	}
}
