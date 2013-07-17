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
				frontside = frontface.surface[row][col];
				if(row == 0)
					 verticalside = topdedge.colors[col];
				if(col == 2)
					 offside = rightdedge.colors[row];
				if(row == 2)
					 verticalside = bottomdedge.colors[Math.abs(col - 2)];
				if(col == 0)
					 offside = leftdedge.colors[Math.abs(row - 2)];
				
				if(offside != null && verticalside != null){
					cubelets[row][col] = new CornerCubelet(frontside, offside, verticalside);
				} if(offside == null && verticalside == null){
					cubelets[row][col] = new CenterCubelet(frontside);
				} else {
					offside = (offside != null) ? offside : verticalside;
					cubelets[row][col] = new EdgeCubelet(frontside, offside);
				}
			}
		}
	}
	
	public Cubelet getCubelet(int x, int y){
		if(Math.abs(x) > 1 || Math.abs(y) > 1)
			throw new IllegalArgumentException("Inputted x and y must be between 1 and -1");
		return cubelets[(y * -1) + 1][x + 1];
	}
	
}
