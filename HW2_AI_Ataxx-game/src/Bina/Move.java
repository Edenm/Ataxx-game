package Bina;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


public class Move implements Comparable<Move>{

	//Set<Move> childrensMove;
	PriorityQueue<Move> childrensMove;
	AtaxxBoard current;
	
	int deepLevel;

//	public Move(AtaxxBoard current, int iSrc, int jSrc,int iDest, int jDest,int deepLevel) {
//		childrensMove= new HashSet<Move>();
//		this.current = current;
//	}
	
	public Move(AtaxxBoard current,int deepLevel) {
		System.out.println("my depth: "+deepLevel);
		//childrensMove= new HashSet<Move>();
		childrensMove = new PriorityQueue<Move>();
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
	
	public Move GetMaxOrMin()
	{
		System.out.println("my depth : "+ this.deepLevel);
		if(childrensMove.size() > 0)
		{
		return childrensMove.peek().GetMaxOrMin();
		}
	
		return this;
	}

	

	public int compareTo(Move move) {
		if(deepLevel % 2 == 0)
		{
		if(this.GetMaxOrMin().current.value() >= move.GetMaxOrMin().current.value())
			return 1;
		return -1;
		}
		else
		{
			if(this.GetMaxOrMin().current.value() >= move.GetMaxOrMin().current.value())
				return -1;
			return 1;
		}
	}
	
	
	
}
