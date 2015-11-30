package Bina;


public class AtaxxBoard {
	
	static final int size=7;
	public int  [][] board;

	public AtaxxBoard() {
		this.board = new int[size][size];
		board[0][0]=1;
		board[0][1]=2;
		board[6][6]=1;
		board[6][0]=2;
		board[0][6]=2;
	}
	
	public AtaxxBoard(int[][] board) {
		this.board = new int[size][size];
		for(int i=0; i<size; i++)
			  for(int j=0; j<size; j++)
				  this.board[i][j]=board[i][j];
	
	}

	public int value(){
		int black=0;
		int white=0;
		
		for (int i=0; i<size ;i++) {
			for (int j=0; j<size ;j++) {
					if (this.board[i][j]==1)
						white++;
					else 
						black++;
			}
		}
		
		return white;
	}

	public String toString() {
		
		String board="";
		
		for (int i=0; i<size ;i++) {
			for (int j=0; j<size ;j++) {
					board+=this.board[i][j];
					if (j!=size-1)
						board+=":";
			}
			board+="\n";
		}
		return board;
	}
	
}
	
	
