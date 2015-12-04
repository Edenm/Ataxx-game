package Bina;

public class Main {

	public static void main(String[] args) {
		AtaxxGame game=new AtaxxGame();
		//ArrayList<AtaxxBoard> successor = HelperAtaxx.successor(game.curAB);
		Move m = new Move(game.curAB, 0, E_Player.Black);
		System.out.println(m.childrensMove.size()+"  knafo");
		System.out.println("min max : \n"+ m.GetMaxOrMin().current +" Depth: "+m.GetMaxOrMin().deepLevel);
		//game.run();
	}

}
