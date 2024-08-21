package othello;

//imports
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class OthelloDriver0 {

	public static void main(String[] args) {
// scanner magic
		Scanner keyb = new Scanner(System.in);
//		System.out.println("");		
		@SuppressWarnings("unused") //it IS used ffs
		String whatev, action;
		String exit = "EXIT";
			System.out.println("Welcome to this Othello/Reversi game variation");
			System.out.println("Please type in what you wish to do");
			System.out.println("1. Write NEW if you wish to start a new game");
			System.out.println("2. Write OLD if you wish to continue a game");
			System.out.println("3. Write EXIT if you opened this by accident & want to quit");

		action = keyb.nextLine();	
		if (action.equals("OLD")) {
			
		}
		else if(action.equals(exit)) {
			System.out.println("Good night");
			System.exit(0);
		}	
		else if(action.equals("NEW")) {
			System.out.println("Please enter the name.txt you wish to give to the game file");
		String filename;
		filename = keyb.nextLine();
		File game = new File(filename);
		try {
			if (game.createNewFile()) {
				System.out.println("New game created");
			}
			else {
				System.out.println("Game already exists");
			}
		} catch (IOException e) {
			System.out.println("Error...");
			e.printStackTrace();
		}
		
		
			System.out.println("Please enter the name of the player using black pieces (@)");
			System.out.println("(Black starts first)");
		String nameblack, namewhite;
		nameblack = keyb.nextLine();
			System.out.println("Please enter the name of the player using white pieces (O)");
		namewhite = keyb.nextLine();
		Player pl = new Player(nameblack, namewhite);
			System.out.println("Now please enter a number from 1 to 4 for the board " +
				"you wish to use");
			System.out.println("2 1");
			System.out.println("3 4");
			System.out.println("Please avoid missinputting and crashing the program");
		int boardchoice;
		boardchoice = keyb.nextInt();
		whatev = keyb.nextLine();//eat the rest of the line
		whatev = null;
		BoardChange bd = new BoardChange(boardchoice);
			System.out.println("Here is the board. @ are black pieces, O are white pieces");
			System.out.println("# are empty cases and X are unplayable cases");
		bd.printBoard();
		char car;
		String cars;
		String carp;
		int mint;
		int skip = 0;
		
		while (skip != 2) {
				System.out.println(pl.getNameRN() +"'s turn.");
				System.out.println("Please enter your move in the format of: letter number");
				System.out.println("l n --- separate them with ONE  s p a c e  then hit enter");
				System.out.println("Please again avoid missinputting and crashing the program");
				System.out.println("Write SKIP if you have to skip your turn");			
			
			cars = keyb.nextLine();
			if (cars.equals("SKIP")) {
				System.out.println("Turn skipped");
				pl.skipTurn();
				skip = skip + 1;
			}
			else if(cars.equals(exit)) {
				System.out.println("Saving and leaving");
				System.exit(0);
			}
			else {
				car = cars.charAt(0);
				carp = cars.substring(2);
				mint = Integer.parseInt(carp);
				Square sq = new Square(car, mint);
				
				// check if valid move before moving
				if (Validation.checkValidMove(bd, sq, pl)) {
					//check which player to set the square
					if (pl.getPlayerRN()==pl.getBLACK()) {
						bd.setSquareBLACK(sq.getHorizontal(), sq.getVertical());
					}
					else {
						bd.setSquareWHITE(sq.getHorizontal(), sq.getVertical());
					}
					// flip the pieces
					bd.flip(sq, pl);
					//change player
					pl.changePlayer();
					//print board
					bd.printBoard();
				}//valid move if
				
			}//skip else
		}//while skip
		bd.printBoard();
		Validation.checkWinner(bd, pl);
		System.out.println("am out meow");

		try {
			FileWriter writer = new FileWriter(game, true);

			BufferedWriter buffw = new BufferedWriter(writer);
			buffw.write(pl.getNameB()+"\n");
			buffw.write(pl.getNameW()+"\n");
			buffw.write(pl.getPlayerRN()+"\n");
			
			buffw.write(bd.getSquare(0,0)+bd.getSquare(1,0)+bd.getSquare(2,0)
			+bd.getSquare(3,0)+bd.getSquare(4,0)+bd.getSquare(5,0)+bd.getSquare(6,0)
			+bd.getSquare(7,0)+bd.getSquare(8,0)+bd.getSquare(9,0)+"\n");
			
			buffw.close();
			
		} catch(IOException e) {
			System.out.println("Something broke");
		}

		}//ELSE IF for new game

//bye bye keyb		
		keyb.close();
	}//main

}//class
