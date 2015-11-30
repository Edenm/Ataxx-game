package Bina;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Move {

	Set<Move> childrensMove;
	
	AtaxxBoard current;
	
	int deepLevel;

//	public Move(AtaxxBoard current, int iSrc, int jSrc,int iDest, int jDest,int deepLevel) {
//		childrensMove= new HashSet<Move>();
//		this.current = current;
//	}
	
	public Move(AtaxxBoard current,int deepLevel) {
		childrensMove= new HashSet<Move>();
		this.current = current;
		
		this.deepLevel=deepLevel;
		
		if (this.deepLevel<HelperAtaxx.maxLevel){
			setChildrensMove();
		}
	}
	
	private void setChildrensMove(){
		ArrayList<AtaxxBoard> possibleChildrens=HelperAtaxx.successor(current);
		for (AtaxxBoard ab : possibleChildrens) {
			childrensMove.add(new Move(ab, deepLevel+1));
		}
	}
	
}
