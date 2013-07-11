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
		CubeWrapper wrapper = new CubeWrapper();
		Context context = new Context(CubeColor.YELLOW, CubeColor.ORANGE, Context.Face.Top);
		CubeColor[][] yellowsurface = {{CubeColor.GREEN, CubeColor.ORANGE, CubeColor.BLUE},
				{CubeColor.YELLOW, CubeColor.YELLOW, CubeColor.GREEN},
				{CubeColor.ORANGE, CubeColor.WHITE, CubeColor.YELLOW}};
		wrapper.setFace(new CubeSurface(yellowsurface), context);
		
		for (int row = 0; row < yellowsurface.length; row++) {
			for (int col = 0; col < yellowsurface[row].length; col++) {
				System.out.print(yellowsurface[row][col].name() + "\t");
			}
			System.out.println();
		}
		
		context = new Context(CubeColor.ORANGE, CubeColor.WHITE, Context.Face.Front);
		CubeColor[][] orangesurface = {{CubeColor.WHITE, CubeColor.BLUE, CubeColor.GREEN},
				{CubeColor.WHITE, CubeColor.ORANGE, CubeColor.BLUE},
				{CubeColor.BLUE, CubeColor.YELLOW, CubeColor.YELLOW}};
		wrapper.setFace(new CubeSurface(orangesurface), context);
		
		context = new Context(CubeColor.BLUE, CubeColor.WHITE, Context.Face.Right);
		CubeColor[][] bluesurface = {{CubeColor.ORANGE, CubeColor.RED, CubeColor.RED},
				{CubeColor.RED, CubeColor.BLUE, CubeColor.WHITE},
				{CubeColor.BLUE, CubeColor.WHITE, CubeColor.RED}};
		wrapper.setFace(new CubeSurface(bluesurface), context);
		
		context = new Context(CubeColor.RED, CubeColor.WHITE, Context.Face.Back);
		CubeColor[][] redsurface = {{CubeColor.YELLOW, CubeColor.GREEN, CubeColor.RED},
				{CubeColor.GREEN, CubeColor.RED, CubeColor.RED},
				{CubeColor.WHITE, CubeColor.BLUE, CubeColor.GREEN}};
		wrapper.setFace(new CubeSurface(redsurface), context);
		
		context = new Context(CubeColor.GREEN, CubeColor.WHITE, Context.Face.Left);
		CubeColor[][] greensurface = {{CubeColor.WHITE, CubeColor.ORANGE, CubeColor.GREEN},
				{CubeColor.YELLOW, CubeColor.GREEN, CubeColor.RED},
				{CubeColor.RED, CubeColor.BLUE, CubeColor.ORANGE}};
		wrapper.setFace(new CubeSurface(greensurface), context);
		
		context = new Context(CubeColor.WHITE, CubeColor.RED, Context.Face.Bottom);
		CubeColor[][] whitesurface = {{CubeColor.WHITE, CubeColor.GREEN, CubeColor.ORANGE},
				{CubeColor.YELLOW, CubeColor.WHITE, CubeColor.ORANGE},
				{CubeColor.YELLOW, CubeColor.ORANGE, CubeColor.BLUE}};
		wrapper.setFace(new CubeSurface(whitesurface), context);
		
		RubiksCube cube = new RubiksCube(wrapper);
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
				System.out.print(face2.getCubelet(new CubeletLocation(x, y)).getFrontSide().getColor().name() + "\t");
			}
			System.out.println();
		}
		System.out.println();
		CubeFace face = cube.getTopFace();
		for (int y = 1; y > -2; y--) {
			for (int x = -1; x < 2; x++) {
				System.out.print(face.getCubelet(new CubeletLocation(x, y)).getFrontSide().getColor().name() + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		cube.top();
		cube.topInverted();
		
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
		face = cube.getBottomFace();
		System.out.println("Bottom:");
		printFace(face);
		}
	
	private static void printFace(CubeFace face){
		//System.out.println();
		System.out.print("\t\t");
		System.out.print(((EdgeCubelet)face.getCubelet(new CubeletLocation(0,1))).getOffSide().getParentColor() + "\t\n");
		System.out.print("\t");
		System.out.print(((CornerCubelet)face.getCubelet(new CubeletLocation(-1,1))).getVerticalSide().getColor() + "\t");
		System.out.print(((EdgeCubelet)face.getCubelet(new CubeletLocation(0,1))).getOffSide().getColor() + "\t");
		System.out.print(((CornerCubelet)face.getCubelet(new CubeletLocation(1,1))).getVerticalSide().getColor() + "\t");
		System.out.println();
		
		System.out.print(((CornerCubelet)face.getCubelet(new CubeletLocation(-1,1))).getOffSide().getColor() + "\t");
		System.out.print(face.getCubelet(new CubeletLocation(-1,1)).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(new CubeletLocation(0,1)).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(new CubeletLocation(1,1)).getFrontSide().getColor() + "\t");
		System.out.print(((CornerCubelet)face.getCubelet(new CubeletLocation(1,1))).getOffSide().getColor() + "\t");
		System.out.println();
		
		System.out.print(((EdgeCubelet)face.getCubelet(new CubeletLocation(-1,0))).getOffSide().getColor() + "\t");
		System.out.print(face.getCubelet(new CubeletLocation(-1,0)).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(new CubeletLocation(0,0)).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(new CubeletLocation(1,0)).getFrontSide().getColor() + "\t");
		System.out.print(((EdgeCubelet)face.getCubelet(new CubeletLocation(1,0))).getOffSide().getColor() + "\t");
		System.out.println();
		
		System.out.print(((CornerCubelet)face.getCubelet(new CubeletLocation(-1,-1))).getOffSide().getColor() + "\t");
		System.out.print(face.getCubelet(new CubeletLocation(-1,-1)).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(new CubeletLocation(0,-1)).getFrontSide().getColor() + "\t");
		System.out.print(face.getCubelet(new CubeletLocation(1,-1)).getFrontSide().getColor() + "\t");
		System.out.print(((CornerCubelet)face.getCubelet(new CubeletLocation(1,-1))).getOffSide().getColor() + "\t");
		System.out.println();
		
		System.out.print("\t");
		System.out.print(((CornerCubelet)face.getCubelet(new CubeletLocation(-1,-1))).getVerticalSide().getColor() + "\t");
		System.out.print(((EdgeCubelet)face.getCubelet(new CubeletLocation(0,-1))).getOffSide().getColor() + "\t");
		System.out.print(((CornerCubelet)face.getCubelet(new CubeletLocation(1,-1))).getVerticalSide().getColor() + "\t");
		System.out.println();
		System.out.print("\t\t");
		System.out.print(((EdgeCubelet)face.getCubelet(new CubeletLocation(0,-1))).getOffSide().getParentColor() + "\t\n");
		System.out.println();
	}
	
}
