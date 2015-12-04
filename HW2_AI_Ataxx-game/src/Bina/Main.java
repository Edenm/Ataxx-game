package Bina;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		AtaxxGame game=new AtaxxGame();
		//ArrayList<AtaxxBoard> successor = HelperAtaxx.successor(game.curAB);
		Move m = new Move(game.curAB, 0);
		System.out.println(m.childrensMove.size()+"  knafo");
		System.out.println("min max : "+ m.GetMaxOrMin().current +" Depth: "+m.GetMaxOrMin().deepLevel);
		//game.run();
	}

}
