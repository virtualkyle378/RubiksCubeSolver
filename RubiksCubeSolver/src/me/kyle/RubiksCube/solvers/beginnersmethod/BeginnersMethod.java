package me.kyle.RubiksCube.solvers.beginnersmethod;

import me.kyle.RubiksCube.api.CubeColor;
import me.kyle.RubiksCube.api.CubeletLocation;
import me.kyle.RubiksCube.api.RubiksCube;
import me.kyle.RubiksCube.solvers.CubeSolver;

public class BeginnersMethod implements CubeSolver {
	
	private RubiksCube cube;

	public BeginnersMethod(RubiksCube cube){
		this.cube = cube;
	}

	@Override
	public void startSolve() {
		//step one: solve the cross
		CubeColor frontColor = cube.getFrontFace().getCubelet(0,0).getFrontSide().getColor();
		CubeColor sideColor = CubeColor.WHITE;
	}

	@Override
	public void displaySolution() {
		
	}

}
