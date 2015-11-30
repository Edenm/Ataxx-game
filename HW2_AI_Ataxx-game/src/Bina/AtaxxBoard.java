package Bina;

import java.util.Arrays;


public class AtaxxBoard {

	public int  [][] board;

	public AtaxxBoard() {
		this.board = new int[HelperAtaxx.size][HelperAtaxx.size];
		board[0][0]=1;
		board[6][6]=1;
		board[6][0]=2;
		board[0][6]=2;
	}
	
	public AtaxxBoard(int[][] board) {
		this.board = new int[HelperAtaxx.size][HelperAtaxx.size];
		for(int i=0; i<HelperAtaxx.size; i++)
			  for(int j=0; j<HelperAtaxx.size; j++)
				  this.board[i][j]=board[i][j];
	
	}

	public int value(){
		int black=0;
		int white=0;
		
		for (int i=0; i<HelperAtaxx.size ;i++) {
			for (int j=0; j<HelperAtaxx.size ;j++) {
					if (this.board[i][j]==1)
						white++;
					else 
						black--;
			}
		}
		
		return white+black;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(board);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AtaxxBoard){
			for (int i=0; i<HelperAtaxx.size;i++){
				for (int j=0; j<HelperAtaxx.size;j++){
					if (((AtaxxBoard)obj).board[i][j]!=board[i][j]){
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String board="";
		for (int i=0; i<HelperAtaxx.size ;i++) {
			for (int j=0; j<HelperAtaxx.size ;j++) {
					board+=this.board[i][j];
					if (j!=HelperAtaxx.size-1)
						board+=":";
			}
			board+="\n";
		}
		return board;
	}
	
}
	
	
