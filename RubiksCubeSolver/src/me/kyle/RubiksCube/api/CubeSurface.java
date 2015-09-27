package me.kyle.RubiksCube.api;

public class CubeSurface {
	
	CubeletFacet[][] surface = new CubeletFacet[3][3];
	
	
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
		int x = 0, y = 0;
		for(CubeColor[] a: colors){
			for(CubeColor b: a){
				surface[y][x] = new CubeletFacet(b, colors[1][1]);
				x++;
			}
			x = 0;
			y++;
		}
		//surface = colors;
	}
	
	public CubeSurface(CubeSurface other){
		int x = 0, y = 0;
		for(CubeletFacet[] a: other.surface){
			for(CubeletFacet b: a){
				surface[y][x] = new CubeletFacet(b);
				x++;
			}
			x = 0;
			y++;
		}
	}
	
	CubeDedge getTopDedge(){
		CubeletFacet[] colors = new CubeletFacet[3];
		int i = 2;
		for(CubeletFacet x: surface[0])
			colors[i--] = x;
		return new CubeDedge(colors, surface[1][1].color);
	}
	
	CubeDedge getBottomDedge(){
		return new CubeDedge(surface[2], surface[1][1].color);
	}
	
	CubeDedge getRightDedge(){
		CubeletFacet[] colors = new CubeletFacet[3];
		int i = 2;
		for(CubeletFacet[] x: surface)
			colors[i--] = x[2];
		return new CubeDedge(colors, surface[1][1].color);
	}
	
	CubeDedge getLeftDedge(){
		CubeletFacet[] colors = new CubeletFacet[3];
		int i = 0;
		for(CubeletFacet[] x: surface)
			colors[i++] = x[0];
		return new CubeDedge(colors, surface[1][1].color);
	}
}
