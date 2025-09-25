package crossme;
import java.util.Scanner;

public class mainCrossMe {

	public static void main(String[] args) {
		Scanner keyb = new Scanner(System.in);	
		
		int sizeBIG;
		String empty;
		System.out.println("I wan blocks ▣■□▦▧⬚☒");

		System.out.println("Please input the number of blocks of the total length");
		sizeBIG = keyb.nextInt();
		empty = keyb.nextLine();
		
//		String test = "  1 2 3 4 5 13 ";
		final int SQUARES = 25; // like default squares numbers
		System.out.println("Enter ordered numbers separated by spaces");
		String input = keyb.nextLine();
		keyb.close();
		System.out.print(empty);
		
		refactCrossMe cm = new refactCrossMe();
		int[] nums = cm.numberInput(input, SQUARES);
		
		cm.mainPack(nums, sizeBIG);

	}

}
