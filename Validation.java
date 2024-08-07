package othello;
	/*
	 * CYun July 2024
		i need to add the abstraction & inheritance concepts somehow
		nvm screw that
	*/
public class Validation extends Overall /*implements CheckPossibility */{

// check if horizontal was a proper letter, then check 0-7 range
	public static boolean isOnBoard(Square sq) {
		if (sq.getHorizontal() == -1) {
			return false;
		}
		else if ((sq.getVertical() < 0)||(sq.getVertical() > 7)) {
			return false;
		}
		else {
			return true;
		}
	}
// check if the square is empty (#)
	public static boolean isSquareEmpty(BoardChange bd, Square sq) {
		if (bd.getSquare(sq.getHorizontal(), sq.getVertical()) == '#') {
			return true;
		}
		else {
			return false;
		}
	}
// check if the 8 squares has enemy color nearby
	static int WW, NW, NN, NE, EE, SE, SS, SW, cardinalSum;
	public static boolean hasEnemyNearby(BoardChange bd, Square sq, Player pl) {
		WW = 1;
		NW = 1;
		NN = 1;
		NE = 1;
		EE = 1;
		SE = 1;
		SS = 1;
		SW = 1;
		if (!(pl.getNonPlayer() == bd.getcWW(sq.getHorizontal(), sq.getVertical()))) {
			WW = 0;
		}
		if (!(pl.getNonPlayer() == bd.getcNW(sq.getHorizontal(), sq.getVertical()))) {
			NW = 0;
		}
		if (!(pl.getNonPlayer() == bd.getcNN(sq.getHorizontal(), sq.getVertical()))) {
			NN = 0;
		}
		if (!(pl.getNonPlayer() == bd.getcNE(sq.getHorizontal(), sq.getVertical()))) {
			NE = 0;
		}
		if (!(pl.getNonPlayer() == bd.getcEE(sq.getHorizontal(), sq.getVertical()))) {
			EE = 0;
		}
		if (!(pl.getNonPlayer() == bd.getcSE(sq.getHorizontal(), sq.getVertical()))) {
			SE = 0;
		}
		if (!(pl.getNonPlayer() == bd.getcSS(sq.getHorizontal(), sq.getVertical()))) {
			SS = 0;
		}
		if (!(pl.getNonPlayer() == bd.getcSW(sq.getHorizontal(), sq.getVertical()))) {
			SW = 0;
		}

		cardinalSum = WW+NW+NN+NE+EE+SE+SS+SW;

		if (cardinalSum == 0) {
			return false;
		}
		else {
			return true;
		}
	}
// check if there's an allied piece down the line	
	// and also the coordinates of the ally piece
//	1. check if it has confirmation from previous function (CC = 1)
//	2. while enemy piece, move coordinates
//	3. if empty or border, stop and set to 0
//	4. otherwise set the coordinates of the ally piece
//	static int WWL, NWL, NNL, NEL, EEL, SEL, SSL, SWL;
	static int WWh, NWh, NNh, NEh, EEh, SEh, SSh, SWh;
	static int WWv, NWv, NNv, NEv, EEv, SEv, SSv, SWv, lineSum;
	public static boolean hasAllyLined(BoardChange bd, Square sq, Player pl) {
//		WWL = WW;
//		NWL = NW;
//		NNL = NN;
//		NEL = NE;
//		EEL = EE;
//		SEL = SE;
//		SSL = SS;
//		SWL = SW;
		sq.getHorizontal();
		sq.getVertical();
		
		if (WW == 1) {
			sq.resetCopyh();
			sq.resetCopyv();
//			System.out.println(bd.getSquare(sq.getCopyh(), sq.getCopyv())+".."+ sq.getCopyh());
			sq.moveLeft();
//			System.out.println(bd.getSquare(sq.getCopyh(), sq.getCopyv())+".."+ sq.getCopyh());
			while (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getNonPlayer()) {
				sq.moveLeft();
//				System.out.println(bd.getSquare(sq.getCopyh(), sq.getCopyv()));
			}
			
			if (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getPlayerRN()) {
				WWh = sq.getCopyh();
				WWv = sq.getCopyv();
			}
			else {
				WW = 0;
			}
//			System.out.println(bd.getSquare(sq.getCopyh(), sq.getCopyv())+".??"+ sq.getCopyh());
		}// CC if
		
		if (NW == 1) {
			sq.resetCopyh();
			sq.resetCopyv();
			sq.moveLeft();
			sq.moveUp();
			while (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getNonPlayer()) {
				sq.moveLeft();
				sq.moveUp();
			}
			if (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getPlayerRN()) {
				NWh = sq.getCopyh();
				NWv = sq.getCopyv();
			}
			else {
				NW = 0;
			}
		}// CC if
		
		if (NN == 1) {
			sq.resetCopyh();
			sq.resetCopyv();
			sq.moveUp();
			while (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getNonPlayer()) {
				sq.moveUp();
			}
			if (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getPlayerRN()) {
				NNh = sq.getCopyh();
				NNv = sq.getCopyv();
			}
			else {
				NN = 0;
			}
		}// CC if
		
		if (NE == 1) {
			sq.resetCopyh();
			sq.resetCopyv();
			sq.moveUp();
			sq.moveRight();
			while (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getNonPlayer()) {
				sq.moveUp();
				sq.moveRight();
			}
			if (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getPlayerRN()) {
				NEh = sq.getCopyh();
				NEv = sq.getCopyv();
			}
			else {
				NE = 0;
			}
		}// CC if
		
		if (EE == 1) {
			sq.resetCopyh();
			sq.resetCopyv();
			sq.moveRight();
			while (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getNonPlayer()) {
				sq.moveRight();
			}
			if (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getPlayerRN()) {
				EEh = sq.getCopyh();
				EEv = sq.getCopyv();
			}
			else {
				EE = 0;
			}
		}// CC if
		
		if (SE == 1) {
			sq.resetCopyh();
			sq.resetCopyv();
			sq.moveRight();
			sq.moveDown();
			while (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getNonPlayer()) {
				sq.moveRight();
				sq.moveDown();
			}
			if (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getPlayerRN()) {
				SEh = sq.getCopyh();
				SEv = sq.getCopyv();
			}
			else {
				SE = 0;
			}
		}// CC if
		
		if (SS == 1) {
			sq.resetCopyh();
			sq.resetCopyv();
			sq.moveDown();
			while (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getNonPlayer()) {
				sq.moveDown();
			}
			if (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getPlayerRN()) {
				SSh = sq.getCopyh();
				SSv = sq.getCopyv();
			}
			else {
				SS = 0;
			}
		}// CC if
		
		if (SW == 1) {
			sq.resetCopyh();
			sq.resetCopyv();
			sq.moveDown();
			sq.moveLeft();
			while (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getNonPlayer()) {
				sq.moveDown();
				sq.moveLeft();
			}
			if (bd.getSquare(sq.getCopyh(), sq.getCopyv()) == pl.getPlayerRN()) {
				SWh = sq.getCopyh();
				SWv = sq.getCopyv();
			}
			else {
				SW = 0;
			}
		}// CC if
		
		lineSum = WW+NW+NN+NE+EE+SE+SS+SW;

		if (lineSum == 0) {
			return false;
		}
		else {
			return true;
		}
	}
// overall here
	public static boolean checkValidMove(BoardChange bd, Square sq, Player pl) {
		if (!(isOnBoard(sq))) {
			System.out.println("Invalid move, please enter a square located ON the board");
			return false;
		}//on board
		else {
//			System.out.println("move is on boardo");
			if (!(isSquareEmpty(bd, sq))) {
				System.out.println("This square is not a valid move");
				System.out.println("(Note: X marks an unplayable case)");
				return false;
			}//empty
			else {
//				System.out.println("empty");
				if (!(hasEnemyNearby(bd, sq, pl))) {
					System.out.println("Are you trying to eat air, or your own pieces?");
					return false;
				}//nearby
				else {
//					System.out.println("enemy nearby!");
					if (!(Validation.hasAllyLined(bd, sq, pl))) {
						System.out.println("There are no pieces to be flipped");
						return false;
					}//line
					else {
//						System.out.println("flippable");
						return true;
					}//line
				}//nearby
			}//empty
		}//on board
		
		
//		Validation.hasAllyLined(bd, sq, pl);
		
	}
// check winner
	static int tallyB, tallyW;
	public static void checkWinner(BoardChange bd, Player pl) {
		tallyB = 0;
		tallyW = 0;
		for (int v=1; v<9; v++) {
			for (int h=1; h<9; h++) {
				if (bd.getSquare(h, v) == bd.getBLACK()) {
					tallyB++;
				}
				else if (bd.getSquare(h, v) == bd.getWHITE()) {
					tallyW++;
				}
			}
		}//fors
		
		System.out.println("Final count:");
		System.out.println("Black pieces: " + tallyB);
		System.out.println("White pieces: " + tallyW);
		if (tallyB > tallyW) {
			System.out.println(pl.getNameB() + " wins!");
		}
		else if (tallyW > tallyB) {
			System.out.println(pl.getNameW() + " wins!");
		}
		else {
			System.out.println("It's a draw!");
		}

	}

}//class
