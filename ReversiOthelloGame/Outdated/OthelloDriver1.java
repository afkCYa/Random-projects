package othello;

//imports
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class OthelloDriver1 {

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
			String filenam, line;
			String nblack = "";
			String nwhite = "";
			char zz, aa, bb, cc, dd, ee, ff, gg, hh, yy;
			int linenum = 1;
			int arrayrow = 0;
			System.out.println("Please enter the name of the saved file");
			filenam = keyb.nextLine();
			try (FileReader fr = new FileReader(filenam);
					BufferedReader br = new BufferedReader(fr)) {
				Player pl = null;
				BoardChange bd = new BoardChange(0);
				while((line = br.readLine()) != null) {
					if (linenum == 1) {
						nblack = line;
					} 
					else if (linenum == 2) {
						nwhite = line;
						pl = new Player(nblack, nwhite);
					}
					else if (linenum == 3) {
						if (line.equals("@")) {
							pl.setPlayerB();
						}
						else {
							pl.setPlayerW();
						}
					}
					else {
						zz = line.charAt(0);
						aa = line.charAt(1);
						bb = line.charAt(2);
						cc = line.charAt(3);
						dd = line.charAt(4);
						ee = line.charAt(5);
						ff = line.charAt(6);
						gg = line.charAt(7);
						hh = line.charAt(8);
						yy = line.charAt(9);
						bd.setFullRow(arrayrow, zz, aa, bb, cc, dd, ee, ff, gg, hh, yy);
						arrayrow++;
					}
					linenum++;
				}//while
			
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
				FileWriter writer = new FileWriter(filenam, false);

				BufferedWriter buffw = new BufferedWriter(writer);
				buffw.write(pl.getNameB()+"\n");
				buffw.write(pl.getNameW()+"\n");
				buffw.write(pl.getPlayerRN()+"\n");
				
				buffw.write(""+bd.getSquare(0,0)+bd.getSquare(1,0)+bd.getSquare(2,0)
				+bd.getSquare(3,0)+bd.getSquare(4,0)+bd.getSquare(5,0)+bd.getSquare(6,0)
				+bd.getSquare(7,0)+bd.getSquare(8,0)+bd.getSquare(9,0)+"\n");
				
				buffw.write(""+bd.getSquare(0,1)+bd.getSquare(1,1)+bd.getSquare(2,1)
				+bd.getSquare(3,1)+bd.getSquare(4,1)+bd.getSquare(5,1)+bd.getSquare(6,1)
				+bd.getSquare(7,1)+bd.getSquare(8,1)+bd.getSquare(9,1)+"\n");

				buffw.write(""+bd.getSquare(0,2)+bd.getSquare(1,2)+bd.getSquare(2,2)
				+bd.getSquare(3,2)+bd.getSquare(4,2)+bd.getSquare(5,2)+bd.getSquare(6,2)
				+bd.getSquare(7,2)+bd.getSquare(8,2)+bd.getSquare(9,2)+"\n");
				
				buffw.write(""+bd.getSquare(0,3)+bd.getSquare(1,3)+bd.getSquare(2,3)
				+bd.getSquare(3,3)+bd.getSquare(4,3)+bd.getSquare(5,3)+bd.getSquare(6,3)
				+bd.getSquare(7,3)+bd.getSquare(8,3)+bd.getSquare(9,3)+"\n");

				buffw.write(""+bd.getSquare(0,4)+bd.getSquare(1,4)+bd.getSquare(2,4)
				+bd.getSquare(3,4)+bd.getSquare(4,4)+bd.getSquare(5,4)+bd.getSquare(6,4)
				+bd.getSquare(7,4)+bd.getSquare(8,4)+bd.getSquare(9,4)+"\n");

				buffw.write(""+bd.getSquare(0,5)+bd.getSquare(1,5)+bd.getSquare(2,5)
				+bd.getSquare(3,5)+bd.getSquare(4,5)+bd.getSquare(5,5)+bd.getSquare(6,5)
				+bd.getSquare(7,5)+bd.getSquare(8,5)+bd.getSquare(9,5)+"\n");

				buffw.write(""+bd.getSquare(0,6)+bd.getSquare(1,6)+bd.getSquare(2,6)
				+bd.getSquare(3,6)+bd.getSquare(4,6)+bd.getSquare(5,6)+bd.getSquare(6,6)
				+bd.getSquare(7,6)+bd.getSquare(8,6)+bd.getSquare(9,6)+"\n");

				buffw.write(""+bd.getSquare(0,7)+bd.getSquare(1,7)+bd.getSquare(2,7)
				+bd.getSquare(3,7)+bd.getSquare(4,7)+bd.getSquare(5,7)+bd.getSquare(6,7)
				+bd.getSquare(7,7)+bd.getSquare(8,7)+bd.getSquare(9,7)+"\n");

				buffw.write(""+bd.getSquare(0,8)+bd.getSquare(1,8)+bd.getSquare(2,8)
				+bd.getSquare(3,8)+bd.getSquare(4,8)+bd.getSquare(5,8)+bd.getSquare(6,8)
				+bd.getSquare(7,8)+bd.getSquare(8,8)+bd.getSquare(9,8)+"\n");

				buffw.write(""+bd.getSquare(0,9)+bd.getSquare(1,9)+bd.getSquare(2,9)
				+bd.getSquare(3,9)+bd.getSquare(4,9)+bd.getSquare(5,9)+bd.getSquare(6,9)
				+bd.getSquare(7,9)+bd.getSquare(8,9)+bd.getSquare(9,9)+"\n");

				
				buffw.close();
				
			} catch(IOException e) {
				System.out.println("Something broke");
			}
			}
			catch (IOException e){
				System.out.println("Encountered problem" + e);
				e.printStackTrace();
			}

			
		}// if old
		
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
			
			buffw.write(""+bd.getSquare(0,0)+bd.getSquare(1,0)+bd.getSquare(2,0)
			+bd.getSquare(3,0)+bd.getSquare(4,0)+bd.getSquare(5,0)+bd.getSquare(6,0)
			+bd.getSquare(7,0)+bd.getSquare(8,0)+bd.getSquare(9,0)+"\n");
			
			buffw.write(""+bd.getSquare(0,1)+bd.getSquare(1,1)+bd.getSquare(2,1)
			+bd.getSquare(3,1)+bd.getSquare(4,1)+bd.getSquare(5,1)+bd.getSquare(6,1)
			+bd.getSquare(7,1)+bd.getSquare(8,1)+bd.getSquare(9,1)+"\n");

			buffw.write(""+bd.getSquare(0,2)+bd.getSquare(1,2)+bd.getSquare(2,2)
			+bd.getSquare(3,2)+bd.getSquare(4,2)+bd.getSquare(5,2)+bd.getSquare(6,2)
			+bd.getSquare(7,2)+bd.getSquare(8,2)+bd.getSquare(9,2)+"\n");
			
			buffw.write(""+bd.getSquare(0,3)+bd.getSquare(1,3)+bd.getSquare(2,3)
			+bd.getSquare(3,3)+bd.getSquare(4,3)+bd.getSquare(5,3)+bd.getSquare(6,3)
			+bd.getSquare(7,3)+bd.getSquare(8,3)+bd.getSquare(9,3)+"\n");

			buffw.write(""+bd.getSquare(0,4)+bd.getSquare(1,4)+bd.getSquare(2,4)
			+bd.getSquare(3,4)+bd.getSquare(4,4)+bd.getSquare(5,4)+bd.getSquare(6,4)
			+bd.getSquare(7,4)+bd.getSquare(8,4)+bd.getSquare(9,4)+"\n");

			buffw.write(""+bd.getSquare(0,5)+bd.getSquare(1,5)+bd.getSquare(2,5)
			+bd.getSquare(3,5)+bd.getSquare(4,5)+bd.getSquare(5,5)+bd.getSquare(6,5)
			+bd.getSquare(7,5)+bd.getSquare(8,5)+bd.getSquare(9,5)+"\n");

			buffw.write(""+bd.getSquare(0,6)+bd.getSquare(1,6)+bd.getSquare(2,6)
			+bd.getSquare(3,6)+bd.getSquare(4,6)+bd.getSquare(5,6)+bd.getSquare(6,6)
			+bd.getSquare(7,6)+bd.getSquare(8,6)+bd.getSquare(9,6)+"\n");

			buffw.write(""+bd.getSquare(0,7)+bd.getSquare(1,7)+bd.getSquare(2,7)
			+bd.getSquare(3,7)+bd.getSquare(4,7)+bd.getSquare(5,7)+bd.getSquare(6,7)
			+bd.getSquare(7,7)+bd.getSquare(8,7)+bd.getSquare(9,7)+"\n");

			buffw.write(""+bd.getSquare(0,8)+bd.getSquare(1,8)+bd.getSquare(2,8)
			+bd.getSquare(3,8)+bd.getSquare(4,8)+bd.getSquare(5,8)+bd.getSquare(6,8)
			+bd.getSquare(7,8)+bd.getSquare(8,8)+bd.getSquare(9,8)+"\n");

			buffw.write(""+bd.getSquare(0,9)+bd.getSquare(1,9)+bd.getSquare(2,9)
			+bd.getSquare(3,9)+bd.getSquare(4,9)+bd.getSquare(5,9)+bd.getSquare(6,9)
			+bd.getSquare(7,9)+bd.getSquare(8,9)+bd.getSquare(9,9)+"\n");

			
			buffw.close();
			
		} catch(IOException e) {
			System.out.println("Something broke");
		}
		}//ELSE IF for new game

		

//bye bye keyb		
		keyb.close();
	}//main

}//class
