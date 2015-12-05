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
		boolean isAIWin = false;
		AtaxxBoard tempBoard = null;
		boolean goodMove = false;
		int xSrc,ySrc,xDest,yDest, numberOfStep;
		Move m = new Move(curAB, 0, E_Player.Black,null);
		System.out.println("Start game:\n"+curAB);
		while (!HelperAtaxx.isGoalState(curAB)){
		//-------------------------------- AI move-----------------------------------------//
			m = m.getNextMove(m.GetMaxOrMin());
			curAB = m.current;
			System.out.println("Move from: x-" +m.current.xsrc + " y- "+m.current.ydes +" To x- "+m.current.xdes +" y- "+m.current.ydes);
			System.out.println("AI move:\n"+curAB);
			
			if(HelperAtaxx.isGoalState(curAB))
			{
				isAIWin= true;
				System.out.println("AI Won the game :-( ");
				break;
			}
			
		//-------------------------------- Human move--------------------------------------//
			while(!goodMove)
			{
				System.out.println("Insert next step: ");
				nextStep= s.nextLine();
				String[] coordinates = nextStep.split(":");
				xSrc=Integer.parseInt(coordinates[0]);
				ySrc=Integer.parseInt(coordinates[1]);
				xDest=Integer.parseInt(coordinates[2]);
				yDest=Integer.parseInt(coordinates[3]);
				tempBoard = new AtaxxBoard(curAB.board);
				
				numberOfStep=calcNumberOfStep(xSrc,ySrc,xDest,yDest);			
				HelperAtaxx.applayMove(tempBoard, xSrc, ySrc, xDest, yDest, numberOfStep,HelperAtaxx.getSignOfPlayer(E_Player.White),HelperAtaxx.getSignOfPlayer(E_Player.Black));
				goodMove = HelperAtaxx.canGoToHuman(curAB, xSrc, ySrc, E_Player.White, tempBoard);
				if(!goodMove)
					System.out.println("can do this move!");
			}
			goodMove = false;
			
			curAB = new AtaxxBoard(tempBoard.board);
			m = new Move(curAB, 00, E_Player.Black, null);
			
			System.out.println("current:\n " + curAB);
		}
		if(!isAIWin)
			System.out.println("You Won the game :-) ");
		
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
