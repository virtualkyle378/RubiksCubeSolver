package me.kyle.RubiksCube.api;

public class EdgeCubelet extends Cubelet {

	protected CubeletFacet offside;
	
	public EdgeCubelet(CubeletFacet frontside, CubeletFacet offside) {
		this.frontside = frontside;
		this.offside = offside;
	}
	
	public CubeletFacet getOffSide(){
		return offside;
	}

}
