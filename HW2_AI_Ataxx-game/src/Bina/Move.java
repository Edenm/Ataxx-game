package Bina;

import java.util.Set;


public class Move {

	
	Set<Move> childrensMove;
	
	AtaxxBoard current;
	
	int deepLevel;

	public Move(AtaxxBoard current, int iSrc, int jSrc,int iDest, int jDest,int deepLevel) {
		this.current = current;
	}
	
	
	
}
