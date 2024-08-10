package othello;
	/*
	 * CYun July 2024
		again mainly because idk what else to inherit
		ultra basic blank board first
		then choice the 5 types of starting boards
		0 is middle
		otherwise choices follow math quadrants/counter-clockwise
		2 1
		3 4
		not that anyone will know
		coordinates are (horizontal, vertical)
		love live reference anyone
	*/
	/*	board drawn kinda
	0	  X X X X X X X X X X
	1	8 X # # # # # # # # X
	2	7 X # # # # # # # # X
	3	6 X # # # # # # # # X
	4	5 X # # # O @ # # # X
	5	4 X # # # @ O # # # X
	6	3 X # # # # # # # # X
	7	2 X # # # # # # # # X
	8	1 X # # # # # # # # X
	9	  X X X X X X X X X X	
			a b c d e f g h
		  0 1 2 3 4 5 6 7 8 9
	the 'X' remain invisible
	 */

public class Board extends Overall{
	private final char EMPTY = '#';
	private final char BORDER = 'X';
//probably useless	
	public char[][] getBoard() {
		return boardo;
	}
//to change the empty to something. maybe useless except testing
	public void setSquareBLACK(int h, int v) {
		boardo[h][v] = getBLACK();
	}
	public void setSquareWHITE(int h, int v) {
		boardo[h][v] = getWHITE();
	}
//to check the square status	
	public char getSquare(int h, int v) {
		return boardo[h][v];
	}
//make empty board	
	char[][] boardo = 
		{{BORDER, BORDER, BORDER, BORDER, BORDER, BORDER, BORDER, BORDER, BORDER, BORDER},
				/*	1	   2	  3		 4		5	   6	  7		 8 */
/*1*/	 {BORDER, BORDER, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BORDER, BORDER},
/*2*/	 {BORDER, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BORDER},
/*3*/	 {BORDER, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BORDER},
/*4*/	 {BORDER, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BORDER},
/*5*/	 {BORDER, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BORDER},
/*6*/	 {BORDER, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BORDER},
/*7*/	 {BORDER, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BORDER},
/*8*/	 {BORDER, BORDER, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, BORDER, BORDER},
		{BORDER, BORDER, BORDER, BORDER, BORDER, BORDER, BORDER, BORDER, BORDER, BORDER}};
//give board options	
	public Board(int choice) {	
		if (choice == 0) {
			boardo[5][5] = getWHITE();
			boardo[4][4] = getWHITE();
			boardo[5][4] = getBLACK();
			boardo[4][5] = getBLACK();
		}
		else if (choice == 1) {
			boardo[5][3] = getWHITE();
			boardo[6][4] = getWHITE();
			boardo[6][3] = getBLACK();
			boardo[5][4] = getBLACK();
		}
		else if (choice == 2) {
			boardo[4][4] = getWHITE();
			boardo[3][3] = getWHITE();
			boardo[4][3] = getBLACK();
			boardo[3][4] = getBLACK();
		}
		else if (choice == 3) {
			boardo[3][5] = getWHITE();
			boardo[4][6] = getWHITE();
			boardo[4][5] = getBLACK();
			boardo[3][6] = getBLACK();
		}
		else if (choice == 4) {
			boardo[6][6] = getWHITE();
			boardo[5][5] = getWHITE();
			boardo[5][6] = getBLACK();
			boardo[6][5] = getBLACK();
		}
	}//constructor end
// print board
	private int PrintColumnForBoard;
	public void printBoard() {
		PrintColumnForBoard = 8;
		System.out.println("");
//v stands for vertical, h for horizontal
		for (int v=1; v<9; v++) {
			
			System.out.print("   "+PrintColumnForBoard--);
			for (int h=1; h<9; h++) {
				System.out.print(" " + getSquare(h, v));
			}
			System.out.println("   ");
		}//fors
		System.out.println("     a b c d e f g h");
	}
//temp test
	public void doSmth() {
		boardo[2][2] = '?';
		boardo[1][1]='1';
		boardo[1][2]='w';
		boardo[3][1]='2';
		boardo[2][1]='n';
		boardo[3][3]='3';
		boardo[3][2]='e';
		boardo[1][3]='4';
		boardo[2][3]='s';
	}
}
