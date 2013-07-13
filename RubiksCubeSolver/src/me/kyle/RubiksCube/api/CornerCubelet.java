package me.kyle.RubiksCube.api;

public class CornerCubelet extends EdgeCubelet {

	private CubeletFacet verticalside;
	
	CornerCubelet(CubeletFacet frontside, CubeletFacet offside, CubeletFacet verticalside) {
		super(frontside, offside);
		this.verticalside = verticalside;
	}
	
	public CubeletFacet getVerticalSide(){
		return verticalside;
	}
}
