package Bina;

import java.util.ArrayList;

public class HelperAtaxx {

	public static ArrayList<AtaxxBoard> successor (AtaxxBoard ab){
		ArrayList<AtaxxBoard> possibleDirection= new ArrayList<AtaxxBoard>();
		
		for (int i=0 ; i<AtaxxBoard.size; i++){
			for (int j=0 ; j<AtaxxBoard.size; j++){
				if (ab.board[i][j]==1){
					canGoTo(possibleDirection,ab,i,j);
				}
			}
		}
		return possibleDirection;
	}
	
	
	private static void  canGoTo (ArrayList<AtaxxBoard> possibleDirection,AtaxxBoard ab, int xSrc, int ySrc){
		
		for (int i= 1; i<=3; i++){
				if(xSrc-i>0 && ab.board[xSrc-i][ySrc]==0){
					setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc-i,  ySrc, i);
				}
				if(xSrc+i<AtaxxBoard.size &&  ab.board[xSrc+i][ySrc]==0){
					setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc+i,  ySrc, i);
				}
				
				if(ySrc-i>0 && ab.board[xSrc][ySrc-i]==0){
					setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc,  ySrc-i, i);
				}
				if(ySrc+i<AtaxxBoard.size &&  ab.board[xSrc][ySrc+i]==0){
					setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc,  ySrc+i, i);
				}
		}
		
		for (int i= 1; i<3; i++){
			if(xSrc-i>0 && ySrc-i>0 && ab.board[xSrc-i][ySrc-i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc-i,  ySrc-i, i);
			}
			if(xSrc+i<AtaxxBoard.size && ySrc-i>0 && ab.board[xSrc+i][ySrc-i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc+i,  ySrc-i, i);
			}
			if(xSrc+i<AtaxxBoard.size && ySrc+i<AtaxxBoard.size && ab.board[xSrc+i][ySrc+i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc+i,  ySrc+i, i);
			}
			if(xSrc-i>0 && ySrc+i<AtaxxBoard.size && ab.board[xSrc-i][ySrc+i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc-i,  ySrc+i, i);
			}
		}
	}
	
	private static void setNextMove(ArrayList<AtaxxBoard> abArray,AtaxxBoard ab, int xSrc, int ySrc, int xDest, int yDest, int numberOfStep){
		AtaxxBoard tempAb= new AtaxxBoard(ab.board);
		applayMove(tempAb,xSrc, ySrc,xDest,yDest,numberOfStep);
		abArray.add(tempAb);
	}
	
	private static void applayMove(AtaxxBoard ab, int xSrc, int ySrc, int xDest, int yDest, int numberOfStep ){
		System.out.println("Color: "+xDest+","+yDest );
		ab.board[xDest][yDest]=1;
		
		if (numberOfStep>1){
			ab.board[xSrc][ySrc]=0;
			paintAroundMe( ab, xDest, yDest);
		}
	}
	

	private static void paintAroundMe(AtaxxBoard ab, int xDest, int yDest){
		for (int i= 1; i<2; i++){
			if(xDest-i>0 && ab.board[xDest-i][yDest]==2){
				ab.board[xDest-i][yDest]=1;
			}
			if(xDest+i<AtaxxBoard.size &&  ab.board[xDest+i][yDest]==2){
				ab.board[xDest+i][yDest]=1;
			}
			
			if(yDest-i>0 && ab.board[xDest][yDest-i]==2){
				ab.board[xDest][yDest-i]=1;
			}
			if(yDest+i<AtaxxBoard.size &&  ab.board[xDest][yDest+i]==2){
				ab.board[xDest][yDest+i]=1;
			}
	}
	
	for (int i= 1; i<2; i++){
		if(xDest-i>0 && yDest-i>0 && ab.board[xDest-i][yDest-i]==2){
			ab.board[xDest-i][yDest-i]=1;
		}
		if(xDest+i<AtaxxBoard.size && yDest-i>0 && ab.board[xDest+i][yDest-i]==2){
			ab.board[xDest+i][yDest-i]=1;
		}
		if(xDest+i<AtaxxBoard.size && yDest+i<AtaxxBoard.size && ab.board[xDest+i][yDest+i]==2){
			ab.board[xDest+i][yDest+i]=1;
		}
		if(xDest-i>0 && yDest+i<AtaxxBoard.size && ab.board[xDest-i][yDest+i]==2){
			ab.board[xDest-i][yDest+i]=1;
		}
}
	}
	
	public static boolean isGoalState(AtaxxBoard m ){
//		if (m.theMaze[m.curI][m.curJ].sign=='g'){
//			return true;
//		}
		return false;
	}
	
	private static boolean canGoTO()
	{ 
		
		return true;
	}
}
