package crossme;

//welcome to this dumb program
//		there's a game on the app store (apple) called crossme
//		basically pixel art but puzzle
//		i am being lazy to math how to fill out the blocks
//		so ill spend a few hours writing a program to not do a 2 min task of counting
//		here we go~

//actual better explanation?
//	ok so that game has a grid
//	next to the grid theres a bunch of numbers that are the amount of filled squares in order
//	need at least one space (usually we mark those with x) between number blocks
//	for example
//	you have one row with 11 empty blocks, and you need to fill 6 of them
//	⬚⬚⬚⬚⬚⬚⬚⬚⬚⬚⬚ 11 empty blocks
//	☒☒☒☒☒▣▣▣▣▣▣ 2 "extreme" possibilities
//	▣▣▣▣▣▣☒☒☒☒☒
//	☒☒☒☒☒▣☒☒☒☒☒ certainty
//	the middle block will be filled no matter how you position 6
//	so 6 is the minimum for there to be something
//	and 1 is the number you can fill
//	ill try to manage to get the 6 output
//	
//nvm not really

import java.util.Scanner;
//import keyboard

public class crossmecalc {

	public static void main(String[] args) {
// scanner magic
		Scanner keyb = new Scanner(System.in);	
		
//variables		
		int sizeBIG, inputnums, addup, remove;
//		int remove2;
		int i;
		String empty;
		int[] squares = new int[25]; //25 cuz its rare you go over that
//sizebig is total length, inputnums is the numbers
		System.out.println("Please input the number of blocks of the total length");
		sizeBIG = keyb.nextInt();
		empty = keyb.nextLine();
		System.out.println("Please input numbers one by one followed by enter");
		System.out.println("Put 0 to stop");
// fill input with the data every time		
		i = 0;
		do
		{
			inputnums = keyb.nextInt();
			empty = keyb.nextLine();
			squares [i] = inputnums;
			i++;

		}
		while (inputnums != 0);

// print out numbers		
		System.out.println("Those are the numbers you have entered:");
		i = 0;
		while (squares [i] != 0)
		{
			System.out.print(squares [i] + "  ");
			i++;
		}
		System.out.println(""+empty);
		
// i need the biggest number first
		i = 0;
		int storeit = 0;
		while (squares [i] != 0)
		{
			if (squares [0] < squares [i])
			{
				storeit = squares [0];
				squares [0] = squares [i];
				squares [i] = storeit;
			}//if close
			i++;

		}//while close
		
//		System.out.println("Biggest = " + squares[0]);
		
// add up stuff
		addup = -1;
// start at -1 bcs uh there will be an extra x (idk how i logic it in my mind but it is what it is)	
// will cancel it out with the +1 in loop dw minimum one number, its important tho	
		i = 0;
		do
		{
			addup = +(addup + squares [i] + 1);
			i++;
//			System.out.println(addup);
		}
		while (squares [i] != 0);

// remove biggest number bcs we gonna check if that one can be put		
		addup = addup - squares[0];
//		System.out.println("fin"+addup);
		
//remove from og blocks and divide by 2
		remove = (sizeBIG - addup);
//		System.out.println(remove +"=");

//		remove2 = remove/2;

//if conditions
//		if (remove%4 == 0)
//		{
//			System.out.println("Minimum length that can be put is : " + (((remove)/2)+1));
//		}
//		else
//		{
			System.out.println("Minimum length that can be put is : " + (((remove)/2)+1));
//		}

// wait why is it working im so confused with remove	
// why does it stop working aaa		
// it stops working if only remove
// but it fixed if remove2
// wtf code ok dont question it its working hey
// now i can be even lazier for thinking 
//		NVM BROKE
//		OK WHY %4 THO
//		ok the if thing literally does not matter
//		ive been fooled and overthinking
//		now my code works and i know why
//		happyyy gaming~
		
//provide closure
	keyb.close();	
//no void sad
	}
//end class
}
//System.out.println("");
