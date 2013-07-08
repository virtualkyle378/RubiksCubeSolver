package me.kyle.RubiksCube.api;

public class CubeSurface {
	
	CubeColor[][] surface = new CubeColor[3][3];
	
	
	/**
	 * @param colors oriented with 0,0 on top left hand corner and 0,2 in top right corner
	 */
	public CubeSurface(CubeColor[][] colors){
		if(colors.length !=3)
			throw new ArrayIndexOutOfBoundsException("Array is not a 3x3 array");
		for(CubeColor[] a: colors){
			if(a.length !=3)
				throw new ArrayIndexOutOfBoundsException("Array is not a 3x3 array");
			for(CubeColor b: a){
				if(b == null)
					throw new NullPointerException("Cannot have a null entry");
			}
		}
		surface = colors;
	}
	
	CubeDedge getTopDedge(){
		return new CubeDedge(surface[0], surface[1][1]);
	}
	
	CubeDedge getBottomDedge(){
		CubeColor[] colors = new CubeColor[3];
		int i = 2;
		for(CubeColor x: surface[2])
			colors[i--] = x;
		return new CubeDedge(colors, surface[1][1]);
	}
	
	CubeDedge getRightDedge(){
		CubeColor[] colors = new CubeColor[3];
		int i = 0;
		for(CubeColor[] x: surface)
			colors[i++] = x[2];
		return new CubeDedge(colors, surface[1][1]);
	}
	
	CubeDedge getLeftDedge(){
		CubeColor[] colors = new CubeColor[3];
		int i = 2;
		for(CubeColor[] x: surface)
			colors[i--] = x[0];
		return new CubeDedge(colors, surface[1][1]);
	}
}
