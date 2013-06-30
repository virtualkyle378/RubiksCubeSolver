package me.kyle.RubiksCube.api;

public class CubeSurface {
	
	CubeColor[][] surface = new CubeColor[3][3];
	
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
	
}
