package othello;

//import
import java.util.Scanner;

public class OthelloDrivertesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// scanner magic
		Scanner keyb = new Scanner(System.in);			
		
		BoardChange bd = new BoardChange(0);
		char car = 'f';
		int mint = 4;
		Square sq = new Square(car, mint);
		Player pl = new Player("a", "b");
		
//		System.out.println(pl.getPlayerRN());
//		pl.changePlayer();
//		System.out.println(pl.getPlayerRN());
//		pl.changePlayer();
//		System.out.println(pl.getPlayerRN());
//		System.out.println(pl.getNonPlayer());
		
		/* System.out.println(sq.getHorizontal());
		sq.setCopyh();
		System.out.println(sq.getCopyh());
		sq.dotest();
		System.out.println(sq.getHorizontal());
		System.out.println(sq.getCopyh());
		sq.setCopyh();
		System.out.println(sq.getCopyh()); */

		
//		for (int m = 1; m < 3; m++) {
////			String mov = "";
////			mov = mov.concat("move" + m);
//			Square mov = new Square( 'a' , 3);
//			System.out.println("Move"+m + " is "+mov.getHorizontal());
//			System.out.println(mov);
//			mov = null;
//			System.out.println(mov);
//		}
		
//		test.doSmth();
		
//		System.out.println(sq.getHorizontal());
//		System.out.println(sq.getVertical());

		bd.setSquareBLACK(sq.getHorizontal(), sq.getVertical());
		
		if (!(Validation.isOnBoard(sq))) {
			System.out.println("Invalid move, please enter a square located ON the board");
		}
		else {
			System.out.println("move is on boardo");
		}
//		System.out.println(Validation.isOnBoard(sq.getHorizontal(), sq.getVertical()));
		if (!(Validation.isSquareEmpty(bd, sq))) {
			System.out.println("not empty");
		}
		else {
			System.out.println("empty");
		}
		Validation.hasEnemyNearby(bd, sq, pl);
		if (!(Validation.hasEnemyNearby(bd, sq, pl))) {
			System.out.println("no enemy nearby");
		}
		else {
			System.out.println("enemy nearby!");
		}
//		Validation.hasAllyLined(bd, sq, pl);
		if (!(Validation.hasAllyLined(bd, sq, pl))) {
			System.out.println("nothing to flip");
		}
		else {
			System.out.println("flippable");
		}
		
		bd.flip(sq, pl);
//		System.out.println(Validation.cardinalSum);
//		System.out.println(Validation.lineSum);
//		System.out.println(Validation.WWL);
		
//		System.out.println(test.getcWW(sq.getHorizontal(), sq.getVertical()));
//		System.out.print(test.getcNW(sq.getHorizontal(), sq.getVertical()));
//		System.out.print(test.getcNN(sq.getHorizontal(), sq.getVertical()));
//		System.out.println(test.getcNE(sq.getHorizontal(), sq.getVertical()));
//		System.out.println(test.getcEE(sq.getHorizontal(), sq.getVertical()));
//		System.out.print(test.getcSE(sq.getHorizontal(), sq.getVertical()));
//		System.out.print(test.getcSS(sq.getHorizontal(), sq.getVertical()));
//		System.out.println(test.getcSW(sq.getHorizontal(), sq.getVertical()));
//		System.out.println(test.getSquare(sq.getHorizontal(), sq.getVertical()));
		
//		System.out.println("");
////v stands for vertical, h for horizontal
//		int PrintColumnForBoard = 8;
//		for (int v=1; v<9; v++) {
//			
//			System.out.print("   "+PrintColumnForBoard--);
//			for (int h=1; h<9; h++) {
//				System.out.print(" " + bd.getSquare(h, v));
//			}
//			System.out.println("   ");
//		}//fors
//		System.out.println("     a b c d e f g h");
		bd.printBoard();

		keyb.close();
	}//main

}//class
