package me.kyle.RubiksCube.api;

public class CubeFace {
	
	Cubelet[][] cubelets = new Cubelet[3][3];
	
	/**
	 * You must supply each dedge in a left to right pattern in relation to the frontface and the parent color in the 3rd index
	 */
	CubeFace(CubeSurface frontface, CubeDedge topdedge, CubeDedge rightdedge, CubeDedge bottomdedge, CubeDedge leftdedge){
		for (int row = 0; row < cubelets.length; row++) {
			for (int col = 0; col < cubelets[row].length; col++) {
				CubeletFacet frontside = null, offside = null, verticalside = null; 
				frontside = new CubeletFacet(frontface.surface[row][col], frontface.surface[1][1]);
				if(row == 0)
					 verticalside = new CubeletFacet(topdedge.colors[col], topdedge.parentcolor);
				if(col == 2)
					 offside = new CubeletFacet(rightdedge.colors[row], rightdedge.parentcolor);
				if(row == 2)
					 verticalside = new CubeletFacet(bottomdedge.colors[Math.abs(col - 2)], bottomdedge.parentcolor);
				if(col == 0)
					 offside = new CubeletFacet(leftdedge.colors[Math.abs(row - 2)], leftdedge.parentcolor);
				
				if(offside != null && verticalside != null){
					cubelets[row][col] = new CornerCubelet(frontside, offside, verticalside);
				} else {
					offside = (offside != null) ? offside : verticalside;
					cubelets[row][col] = new EdgeCubelet(frontside, offside);
				}
			}
		}
	}
	
	public Cubelet getCubelet(CubeletLocation x){
		return cubelets[(x.y * -1) + 1][x.x + 1];
	}
	
}
