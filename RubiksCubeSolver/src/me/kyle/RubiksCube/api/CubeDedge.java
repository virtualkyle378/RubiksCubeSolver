package me.kyle.RubiksCube.api;

public class CubeDedge {
	
	CubeColor[] colors;
	CubeColor parentcolor;
	
	CubeDedge(CubeColor[] colors, CubeColor parentcolor) {
		this.colors = colors;
		this.parentcolor = parentcolor;
	}
	
}
