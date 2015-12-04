package Bina;

import java.util.ArrayList;


public class HelperAtaxx {
	static final int maxLevel=3;
	static final int size=3;
	
	public static ArrayList<AtaxxBoard> successor (AtaxxBoard ab, E_Player p){
		ArrayList<AtaxxBoard> possibleDirection= new ArrayList<AtaxxBoard>();
		for (int i=0 ; i<HelperAtaxx.size; i++){
			for (int j=0 ; j<HelperAtaxx.size; j++){
				if (ab.board[i][j]==getSignOfPlayer(p)){
					canGoTo(possibleDirection,ab,i,j,p);
				}
			}
		}
		return possibleDirection;
	}
	
	public static int getSignOfPlayer(E_Player p){
		switch (p) {
			case Black:return 1;
			case White:return 2;
			default: return 0;
		}
	}
	
	public static E_Player getSecondPlayer(E_Player p){
		switch (p) {
			case Black:return E_Player.White;
			default:return E_Player.Black;
		}
	}
	
	private static void  canGoTo (ArrayList<AtaxxBoard> possibleDirection,AtaxxBoard ab, int xSrc, int ySrc,E_Player p ){
		
		for (int i= 1; i<=3; i++){
				if(xSrc-i>0 && ab.board[xSrc-i][ySrc]==0){
					setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc-i,  ySrc, i, p);
				}
				if(xSrc+i<HelperAtaxx.size &&  ab.board[xSrc+i][ySrc]==0){
					setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc+i,  ySrc, i, p);
				}
				
				if(ySrc-i>0 && ab.board[xSrc][ySrc-i]==0){
					setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc,  ySrc-i, i, p);
				}
				if(ySrc+i<HelperAtaxx.size &&  ab.board[xSrc][ySrc+i]==0){
					setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc,  ySrc+i, i, p);
				}
		}
		
		for (int i= 1; i<3; i++){
			if(xSrc-i>0 && ySrc-i>0 && ab.board[xSrc-i][ySrc-i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc-i,  ySrc-i, i, p);
			}
			if(xSrc+i<HelperAtaxx.size && ySrc-i>0 && ab.board[xSrc+i][ySrc-i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc+i,  ySrc-i, i, p);
			}
			if(xSrc+i<HelperAtaxx.size && ySrc+i<HelperAtaxx.size && ab.board[xSrc+i][ySrc+i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc+i,  ySrc+i, i, p);
			}
			if(xSrc-i>0 && ySrc+i<HelperAtaxx.size && ab.board[xSrc-i][ySrc+i]==0){
				setNextMove(possibleDirection,ab,xSrc,  ySrc,xSrc-i,  ySrc+i, i, p);
			}
		}
	}
	
	private static void setNextMove(ArrayList<AtaxxBoard> abArray,AtaxxBoard ab, int xSrc, int ySrc, int xDest, int yDest, int numberOfStep, E_Player p){
		AtaxxBoard tempAb= new AtaxxBoard(ab.board);
		applayMove(tempAb,xSrc, ySrc,xDest,yDest,numberOfStep,getSignOfPlayer(p),getSignOfPlayer(getSecondPlayer(p)));
		if (!abArray.contains(tempAb))
			abArray.add(tempAb);
	}
	
	public static void applayMove(AtaxxBoard ab, int xSrc, int ySrc, int xDest, int yDest, int numberOfStep, int player ,int secondPlayer){
		//System.out.println("Color: "+xDest+","+yDest );
		ab.board[xDest][yDest]=player;
		
		if (numberOfStep>1){
			ab.board[xSrc][ySrc]=0;
		}
		paintAroundMe( ab, xDest, yDest, player,secondPlayer);
	}
	

	private static void paintAroundMe(AtaxxBoard ab, int xDest, int yDest, int playerTurn, int secondPlayer){
		for (int i= 1; i<2; i++){
			if(xDest-i>=0 && ab.board[xDest-i][yDest]==secondPlayer){
				ab.board[xDest-i][yDest]=playerTurn;
				System.out.println("1");
			}
			if(xDest+i<HelperAtaxx.size &&  ab.board[xDest+i][yDest]==secondPlayer){
				ab.board[xDest+i][yDest]=playerTurn;
				System.out.println("2");
			}
			if(yDest-i>=0 && ab.board[xDest][yDest-i]==secondPlayer){
				ab.board[xDest][yDest-i]=playerTurn;
				System.out.println("3");
			}
			if(yDest+i<HelperAtaxx.size &&  ab.board[xDest][yDest+i]==secondPlayer){
				ab.board[xDest][yDest+i]=playerTurn;
				System.out.println("4");
			}
		}
	
		for (int i= 1; i<2; i++){
			if(xDest-i>=0 && yDest-i>=0 && ab.board[xDest-i][yDest-i]==secondPlayer){
				ab.board[xDest-i][yDest-i]=playerTurn;
			}
			if(xDest+i<HelperAtaxx.size && yDest-i>=0 && ab.board[xDest+i][yDest-i]==secondPlayer){
				ab.board[xDest+i][yDest-i]=playerTurn;
			}
			if(xDest+i<HelperAtaxx.size && yDest+i<HelperAtaxx.size && ab.board[xDest+i][yDest+i]==secondPlayer){
				ab.board[xDest+i][yDest+i]=playerTurn;
			}
			if(xDest-i>=0 && yDest+i<HelperAtaxx.size && ab.board[xDest-i][yDest+i]==secondPlayer){
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
