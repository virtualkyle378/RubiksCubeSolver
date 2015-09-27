package me.kyle.RubiksCube;

import me.kyle.RubiksCube.api.Context;
import me.kyle.RubiksCube.api.CornerCubelet;
import me.kyle.RubiksCube.api.CubeColor;
import me.kyle.RubiksCube.api.CubeFace;
import me.kyle.RubiksCube.api.CubeSurface;
import me.kyle.RubiksCube.api.CubeWrapper;
import me.kyle.RubiksCube.api.CubeletLocation;
import me.kyle.RubiksCube.api.EdgeCubelet;
import me.kyle.RubiksCube.api.RubiksCube;

public class APITester {

	public static void main(String args[]){	
		
		//To scramble: Yellow on top, Orange on front. Use sequence below.
		//Scramble:  L2  U'  D  R2  D'  L2  R2  D2  U2  F2  B  U  D'  F2  U2  D2  B2  U2  F'  R2  U'  R  U2  R  F'
		
		CubeWrapper wrapper = new CubeWrapper();
		Context context = new Context(CubeColor.YELLOW, CubeColor.ORANGE, Context.Face.Top);
		
		//Keep in mind that this API was written with vision in mind. The face that you're "scanning" is facing up.
		
		CubeColor[][] yellowsurface = {{CubeColor.WHITE, CubeColor.WHITE, CubeColor.BLUE},
				{CubeColor.GREEN, CubeColor.YELLOW, CubeColor.BLUE},
				{CubeColor.WHITE, CubeColor.WHITE, CubeColor.GREEN}};
		wrapper.setFace(new CubeSurface(yellowsurface), context);
		
		for (int row = 0; row < yellowsurface.length; row++) {
			for (int col = 0; col < yellowsurface[row].length; col++) {
				System.out.print(yellowsurface[row][col].name() + "\t");
			}
			System.out.println();
		}
		
		context = new Context(CubeColor.ORANGE, CubeColor.WHITE, Context.Face.Front);
		CubeColor[][] orangesurface = {{CubeColor.BLUE, CubeColor.ORANGE, CubeColor.ORANGE},
				{CubeColor.BLUE, CubeColor.ORANGE, CubeColor.RED},
				{CubeColor.BLUE, CubeColor.GREEN, CubeColor.RED}};
		wrapper.setFace(new CubeSurface(orangesurface), context);
		
		context = new Context(CubeColor.BLUE, CubeColor.WHITE, Context.Face.Right);
		CubeColor[][] bluesurface = {{CubeColor.YELLOW, CubeColor.ORANGE, CubeColor.YELLOW},
				{CubeColor.GREEN, CubeColor.BLUE, CubeColor.BLUE},
				{CubeColor.BLUE, CubeColor.RED, CubeColor.RED}};
		wrapper.setFace(new CubeSurface(bluesurface), context);
		
		context = new Context(CubeColor.RED, CubeColor.WHITE, Context.Face.Back);
		CubeColor[][] redsurface = {{CubeColor.ORANGE, CubeColor.RED, CubeColor.GREEN},
				{CubeColor.YELLOW, CubeColor.RED, CubeColor.ORANGE},
				{CubeColor.YELLOW, CubeColor.RED, CubeColor.WHITE}};
		wrapper.setFace(new CubeSurface(redsurface), context);
		
		context = new Context(CubeColor.GREEN, CubeColor.WHITE, Context.Face.Left);
		CubeColor[][] greensurface = {{CubeColor.RED, CubeColor.YELLOW, CubeColor.RED},
				{CubeColor.YELLOW, CubeColor.GREEN, CubeColor.WHITE},
				{CubeColor.GREEN, CubeColor.ORANGE, CubeColor.ORANGE}};
		wrapper.setFace(new CubeSurface(greensurface), context);
		
		context = new Context(CubeColor.WHITE, CubeColor.RED, Context.Face.Bottom);
		CubeColor[][] whitesurface = {{CubeColor.WHITE, CubeColor.WHITE, CubeColor.YELLOW},
				{CubeColor.GREEN, CubeColor.WHITE, CubeColor.BLUE},
				{CubeColor.ORANGE, CubeColor.YELLOW, CubeColor.GREEN}};
		wrapper.setFace(new CubeSurface(whitesurface), context);
		
		RubiksCube cube = new RubiksCube(wrapper);
		
		cube.x();
		cube.xInverted();
		cube.y();
		cube.yInverted();
		
//		cube.right();
//		cube.up();
//		cube.rightInverted();
//		cube.upInverted();
//		cube.rightInverted();
//		cube.front();
//		cube.right();
//		cube.right();
//		cube.upInverted();
//		cube.rightInverted();
//		cube.upInverted();
//		cube.right();
//		cube.up();
//		cube.rightInverted();
//		cube.frontInverted();
		
		System.out.println();
		for (int y = 1; y > -2; y--) {
			for (int x = -1; x < 2; x++) {
				System.out.print("[" + (x) + "][" + (y) + "]\t");
			}
			System.out.println();
		}
		System.out.println();
		CubeFace face2 = cube.getLeftFace();
		for (int y = 1; y > -2; y--) {
			for (int x = -1; x < 2; x++) {
				System.out.print(face2.getCubelet(x, y).getFrontSide().getColor().name() + "\t");
			}
			System.out.println();
		}
		System.out.println();
		CubeFace face = cube.getTopFace();
		for (int y = 1; y > -2; y--) {
			for (int x = -1; x < 2; x++) {
				System.out.print(face.getCubelet(x, y).getFrontSide().getColor().name() + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Top:");
		printFace(face);
		face = cube.getFrontFace();
		System.out.println("Front:");
		printFace(face);
		face = cube.getBackFace();
		System.out.println("Back:");
		printFace(face);
		face = cube.getLeftFace();
		System.out.println("Left:");
		printFace(face);
		face = cube.getRightFace();
		System.out.println("Right:");
		printFace(face);
		face = cube.getDownFace();
		System.out.println("Bottom:");
		printFace(face);
		}
	
	private static void printFace(CubeFace face){
		//System.out.println();
		System.out.print("\t\t");
		System.out.print(((EdgeCubelet)face.getCubelet(0,1)).getOffSide().getParentColor() + "\t\n");
		System.out.print("\t");
		System.out.print(((CornerCubelet)face.getCubelet(-1,1)).getVerticalSide().getColor() + "\t");
		System.out.print(((EdgeCubelet)face.getCubelet(0,1)).getOffSide().getColor() + "\t");
		System.out.print(((CornerCubelet)face.getCubelet(1,1)).getVerticalSide().getColor() + "\t");
		System.out.println();
		
		System.out.print(((CornerCubelet)face.getCubelet(-1,1)).getOffSide().getColor() + "\t");
		System.out.print(face.getCubelet(-1,1).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(0,1).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(1,1).getFrontSide().getColor() + "\t");
		System.out.print(((CornerCubelet)face.getCubelet(1,1)).getOffSide().getColor() + "\t");
		System.out.println();
		
		System.out.print(((EdgeCubelet)face.getCubelet(-1,0)).getOffSide().getColor() + "\t");
		System.out.print(face.getCubelet(-1,0).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(0,0).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(1,0).getFrontSide().getColor() + "\t");
		System.out.print(((EdgeCubelet)face.getCubelet(1,0)).getOffSide().getColor() + "\t");
		System.out.println();
		
		System.out.print(((CornerCubelet)face.getCubelet(-1,-1)).getOffSide().getColor() + "\t");
		System.out.print(face.getCubelet(-1,-1).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(0,-1).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(1,-1).getFrontSide().getColor() + "\t");
		System.out.print(((CornerCubelet)face.getCubelet(1,-1)).getOffSide().getColor() + "\t");
		System.out.println();
		
		System.out.print("\t");
		System.out.print(((CornerCubelet)face.getCubelet(-1,-1)).getVerticalSide().getColor() + "\t");
		System.out.print(((EdgeCubelet)face.getCubelet(0,-1)).getOffSide().getColor() + "\t");
		System.out.print(((CornerCubelet)face.getCubelet(1,-1)).getVerticalSide().getColor() + "\t");
		System.out.println();
		System.out.print("\t\t");
		System.out.print(((EdgeCubelet)face.getCubelet(0,-1)).getOffSide().getParentColor() + "\t\n");
		System.out.println();
	}
	
}
