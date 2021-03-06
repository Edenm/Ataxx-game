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
		boolean isAIWin = false, goodMove = false;
		long tStart, tEnd ,tDelta;
		double elapsedSeconds;
		int xSrc,ySrc,xDest,yDest, numberOfStep;
		AtaxxBoard tempBoard = null;
		
		tStart = System.currentTimeMillis();
		Move m = new Move(curAB, 0, E_Player.Black,null);
		tEnd = System.currentTimeMillis();
		tDelta = tEnd - tStart;
		elapsedSeconds = tDelta / 1000.0;
		System.out.println("Start game:\n"+curAB);
		while (!HelperAtaxx.isGoalState(curAB)){
		//-------------------------------- AI move-----------------------------------------//
			m = m.getNextMove(m.GetMaxOrMin());
			curAB = m.current;
			System.out.println("AI move:\n");
			System.out.println("Time of calc this move is: "+elapsedSeconds+" sec");
			System.out.println("Number of leaf: "+Move.numberOfLeaf );
			System.out.println("Move from: x-" +m.current.xsrc + " y- "+m.current.ysrc +" To x- "+m.current.xdes +" y- "+m.current.ydes);
			System.out.println(curAB);
			
			if(HelperAtaxx.isGoalState(curAB))
			{
				isAIWin= true;
				System.out.println("AI Won the game :-( ");
				break;
			}
			
		//-------------------------------- Human move--------------------------------------//
			while(!goodMove)
			{
				try{
					System.out.println("Insert next step: ");
					nextStep= s.nextLine();
					String[] coordinates = nextStep.split(":");
					xSrc=Integer.parseInt(coordinates[0]);
					ySrc=Integer.parseInt(coordinates[1]);
					xDest=Integer.parseInt(coordinates[2]);
					yDest=Integer.parseInt(coordinates[3]);
					tempBoard = new AtaxxBoard(curAB.board);
				
					if (curAB.board[xSrc][ySrc]==HelperAtaxx.getSignOfPlayer(E_Player.White)){
						numberOfStep=calcNumberOfStep(xSrc,ySrc,xDest,yDest);	
						HelperAtaxx.applayMove(tempBoard, xSrc, ySrc, xDest, yDest, numberOfStep,HelperAtaxx.getSignOfPlayer(E_Player.White),HelperAtaxx.getSignOfPlayer(E_Player.Black));
						goodMove = HelperAtaxx.canGoToHuman(curAB, xSrc, ySrc, E_Player.White, tempBoard);
					}
					if(!goodMove)
						System.out.println("can do this move!");
					
				}catch(Exception ex){
					System.out.println("Please insert step in this template:  xSrc:ySrc:xDest:yDest \n");
				}
			}
			goodMove = false;
			
			curAB = new AtaxxBoard(tempBoard.board);
			Move.numberOfLeaf=0;
			tStart = System.currentTimeMillis();
			m = new Move(curAB, 0, E_Player.Black, null);
			tEnd = System.currentTimeMillis();
			tDelta = tEnd - tStart;
			elapsedSeconds = tDelta / 1000.0;
			
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
