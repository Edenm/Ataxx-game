package Bina;

import java.util.Scanner;

public class AtaxxGame {
	
	AtaxxBoard curAB;
	
	
	public AtaxxGame() {
		curAB=new AtaxxBoard();
	}



	public void run(){
		Scanner s= new Scanner(System.in);
		String nextStep;
		int xSrc,ySrc,xDest,yDest, numberOfStep;
		while (!HelperAtaxx.isGoalState(curAB)){
			System.out.println(curAB);
			/////////Human Player////////
			System.out.println("Insert next step: ");
			nextStep= s.nextLine();
			String[] coordinates = nextStep.split(":");
			xSrc=Integer.parseInt(coordinates[0]);
			ySrc=Integer.parseInt(coordinates[1]);
			xDest=Integer.parseInt(coordinates[2]);
			yDest=Integer.parseInt(coordinates[3]);
			numberOfStep=calcNumberOfStep(xSrc,ySrc,xDest,yDest);
			
			
			HelperAtaxx.applayMove(curAB, xSrc, ySrc, xDest, yDest, numberOfStep,2,1);
			//need to add check if coordinates is valid
			//ArrayList<AtaxxBoard> possibleDirection= HelperAtaxx.successor(curAB);
//			if (possibleDirection.contains(curAB)){
//				
//			}
			
			////////////////////////////
		}
		s.close();
	}
	
	private int calcNumberOfStep(int xSrc,int ySrc,int xDest,int yDest){
		if(xSrc-1==xDest && ySrc==yDest ){
			return 1;
		}
		if(xSrc+1==xDest && ySrc==yDest ){
			return 1;
		}
		if(xSrc==xDest && ySrc-1==yDest ){
			return 1;
		}
		if(xSrc==xDest && ySrc+1==yDest ){
			return 1;
		}
		if(xSrc+1==xDest && ySrc+1==yDest ){
			return 1;
		}
		if(xSrc+1==xDest && ySrc-1==yDest ){
			return 1;
		}
		if(xSrc-1==xDest && ySrc+1==yDest ){
			return 1;
		}
		if(xSrc-1==xDest && ySrc-1==yDest ){
			return 1;
		}
		return 2;
	}
}
