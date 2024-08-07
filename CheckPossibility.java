package othello;
/*
 * 	CYun July 2024
	making interface for checking moves-ish 
		like if it's a valid move
		and in this exact order
		main reason is we have to use inheritance and idk what to inherit
  0. if it's outside the board what are you doing
  1. if it ain't empty don't play there
  edit: begone 2. if there's nothing nearby don't play there
  3. if there's no enemy piece nearby what are you changing
  4. just to not mess up and end up checking for outside the board
  5. if there's no piece of your color in the line how are you eating
*/

public interface CheckPossibility {
	public static boolean isOnBoard(int horizontal, int vertical) {
		return false;
	}
	
	public static boolean isSquareEmpty(char square) {
		return false;
	}
	
	public boolean hasNearbyPieces(int horizontal, int vertical);
	public boolean hasEnemyColor(int horizontal, int vertical);
	public void hasBorder(int horizontal, int vertical);
	public boolean hasAllyColor(int horizontal, int vertical);	
}