package Bina;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class Move implements Comparable<Move>{

	E_Player player;
	PriorityQueue<Move> childrensMove;
	AtaxxBoard current;
	Move fatherMove;
	int deepLevel;
	
	public Move(AtaxxBoard current,int deepLevel, E_Player player, Move father) {
		childrensMove = new PriorityQueue<Move>();
		this.current = current;
		this.deepLevel=deepLevel;
		this.player=player;
		this.fatherMove = father;
		
		if (this.deepLevel<HelperAtaxx.maxLevel){
			setChildrensMove();
		}
	}
	
	private void setChildrensMove(){
		ArrayList<AtaxxBoard> possibleChildrens=HelperAtaxx.successor(current,player);
		
		for (AtaxxBoard ab : possibleChildrens) {
			childrensMove.add(new Move(ab, deepLevel+1,HelperAtaxx.getSecondPlayer(player),this));
		}
	}
	
	public Move GetMaxOrMin()
	{
		if(childrensMove.size() > 0)
		{
			return childrensMove.peek().GetMaxOrMin();
		}
		return this;
	}

	

	public int compareTo(Move move) {
		if(player  == E_Player.Black)
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
	
	public Move getNextMove(Move move)
	{
		while (move.fatherMove != this)
		{
			move = move.fatherMove;
		}
		return move;
	}
	
	
	
}
