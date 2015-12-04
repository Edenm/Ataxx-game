package Bina;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class Move implements Comparable<Move>{

	//Set<Move> childrensMove;
	E_Player player;
	PriorityQueue<Move> childrensMove;
	AtaxxBoard current;
	
	int deepLevel;

//	public Move(AtaxxBoard current, int iSrc, int jSrc,int iDest, int jDest,int deepLevel) {
//		childrensMove= new HashSet<Move>();
//		this.current = current;
//	}
	
	public Move(AtaxxBoard current,int deepLevel, E_Player player) {
		System.out.println("my depth: "+deepLevel);
		System.out.println("my color: "+player);

		childrensMove = new PriorityQueue<Move>();
		
		this.current = current;
		this.deepLevel=deepLevel;
		this.player=player;
		
		if (this.deepLevel<HelperAtaxx.maxLevel){
			setChildrensMove();
		}
	}
	
	private void setChildrensMove(){
		ArrayList<AtaxxBoard> possibleChildrens=HelperAtaxx.successor(current,player);
		System.out.println("possibleChildrens :\n" +possibleChildrens);
		for (AtaxxBoard ab : possibleChildrens) {
			childrensMove.add(new Move(ab, deepLevel+1,HelperAtaxx.getSecondPlayer(player)));
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
