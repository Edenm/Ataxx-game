package Bina;

import java.util.ArrayList;

public class HelperAtaxx {
	static final int maxLevel=3;
	static final int size=7;
	
	public static ArrayList<AtaxxBoard> successor (AtaxxBoard ab){
		ArrayList<AtaxxBoard> possibleDirection= new ArrayList<AtaxxBoard>();
		for (int i=0 ; i<HelperAtaxx.size; i++){
			for (int j=0 ; j<HelperAtaxx.size; j++){
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
				if(xSrc+i<HelperAtaxx.size &&  ab.board[xSrc+i][ySrc]==0){
					setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc+i,  ySrc, i);
				}
				
				if(ySrc-i>0 && ab.board[xSrc][ySrc-i]==0){
					setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc,  ySrc-i, i);
				}
				if(ySrc+i<HelperAtaxx.size &&  ab.board[xSrc][ySrc+i]==0){
					setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc,  ySrc+i, i);
				}
		}
		
		for (int i= 1; i<3; i++){
			if(xSrc-i>0 && ySrc-i>0 && ab.board[xSrc-i][ySrc-i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc-i,  ySrc-i, i);
			}
			if(xSrc+i<HelperAtaxx.size && ySrc-i>0 && ab.board[xSrc+i][ySrc-i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc+i,  ySrc-i, i);
			}
			if(xSrc+i<HelperAtaxx.size && ySrc+i<HelperAtaxx.size && ab.board[xSrc+i][ySrc+i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc+i,  ySrc+i, i);
			}
			if(xSrc-i>0 && ySrc+i<HelperAtaxx.size && ab.board[xSrc-i][ySrc+i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc-i,  ySrc+i, i);
			}
		}
	}
	
	private static void setNextMove(ArrayList<AtaxxBoard> abArray,AtaxxBoard ab, int xSrc, int ySrc, int xDest, int yDest, int numberOfStep){
		AtaxxBoard tempAb= new AtaxxBoard(ab.board);
		applayMove(tempAb,xSrc, ySrc,xDest,yDest,numberOfStep,1,2);
		abArray.add(tempAb);
	}
	
	public static void applayMove(AtaxxBoard ab, int xSrc, int ySrc, int xDest, int yDest, int numberOfStep, int player ,int secondPlayer){
		System.out.println("Color: "+xDest+","+yDest );
		ab.board[xDest][yDest]=player;
		
		if (numberOfStep>1){
			ab.board[xSrc][ySrc]=0;
		}
		paintAroundMe( ab, xDest, yDest, player,secondPlayer);
	}
	

	private static void paintAroundMe(AtaxxBoard ab, int xDest, int yDest, int playerTurn, int secondPlayer){
		for (int i= 1; i<2; i++){
			if(xDest-i>0 && ab.board[xDest-i][yDest]==secondPlayer){
				ab.board[xDest-i][yDest]=playerTurn;
			}
			if(xDest+i<HelperAtaxx.size &&  ab.board[xDest+i][yDest]==secondPlayer){
				ab.board[xDest+i][yDest]=playerTurn;
			}
			
			if(yDest-i>0 && ab.board[xDest][yDest-i]==secondPlayer){
				ab.board[xDest][yDest-i]=playerTurn;
			}
			if(yDest+i<HelperAtaxx.size &&  ab.board[xDest][yDest+i]==secondPlayer){
				ab.board[xDest][yDest+i]=playerTurn;
			}
		}
	
		for (int i= 1; i<2; i++){
			if(xDest-i>0 && yDest-i>0 && ab.board[xDest-i][yDest-i]==secondPlayer){
				ab.board[xDest-i][yDest-i]=playerTurn;
			}
			if(xDest+i<HelperAtaxx.size && yDest-i>0 && ab.board[xDest+i][yDest-i]==secondPlayer){
				ab.board[xDest+i][yDest-i]=playerTurn;
			}
			if(xDest+i<HelperAtaxx.size && yDest+i<HelperAtaxx.size && ab.board[xDest+i][yDest+i]==secondPlayer){
				ab.board[xDest+i][yDest+i]=playerTurn;
			}
			if(xDest-i>0 && yDest+i<HelperAtaxx.size && ab.board[xDest-i][yDest+i]==secondPlayer){
				ab.board[xDest-i][yDest+i]=playerTurn;
			}
		}
	}
	
	public static boolean isGoalState(AtaxxBoard ab ){
		for (int i=0; i<HelperAtaxx.size; i++){
			for (int j=0; j<HelperAtaxx.size; j++){
				if (ab.board[i][j]==0){
					return false;
				}
			}	
		}
		return true;
	}
	
}
