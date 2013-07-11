package me.kyle.RubiksCube.api;

public class CubeDedge {
	
	CubeletFacet[] colors;
	CubeColor parentcolor;
	
	CubeDedge(CubeletFacet[] colors2, CubeColor surface) {
		this.colors = colors2;
		this.parentcolor = surface;
	}
	
	CubeDedge(CubeDedge old) {
		CubeletFacet[] newarray = new CubeletFacet[3];
		for(int i = 0; i < newarray.length; i++){
			newarray[i] = new CubeletFacet(old.colors[i]);
		}
		this.colors = newarray;
		this.parentcolor = old.parentcolor;
	}
	
	void changeTo(CubeDedge other){
		for(int i = 0; i < colors.length; i++){
			colors[i].color = other.colors[i].color;
		}
	}
	
}
