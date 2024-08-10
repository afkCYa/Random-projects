package othello;

public class Player extends Overall{
// to associate names with players names
	
	public Player (String bname, String wname) {
		setNameB(bname);
		setNameW(wname);		
	}
	
	private String PlayerB = "";
	private String PlayerW = "";
	public void setNameB(String name) {
		PlayerB = name;
	}
	public void setNameW(String name) {
		PlayerW = name;
	}
	public String getNameB() {
		return PlayerB;
	}
	public String getNameW() {
		return PlayerW;
	}
	public String getNameRN() {
		if (CurrentPlayer == getBLACK()) {
			return getNameB();
		}
		else {
			return getNameW();
		}
	}
	
// to change between players	
	private char CurrentPlayer = getBLACK();
// to check for opponent	
	private char OtherPlayer = getWHITE();
	public void changePlayer() {
		if (CurrentPlayer == getBLACK()) {
			CurrentPlayer = getWHITE();
			OtherPlayer = getBLACK();
		}
		else {
			CurrentPlayer = getBLACK();
			OtherPlayer = getWHITE();
		}
	}
	public char getPlayerRN() {
		return CurrentPlayer;
	}
	public char getNonPlayer() {
		return OtherPlayer;
	}
// might be useless, practically just changePlayer, but no play	
	public void skipTurn() {
		if (CurrentPlayer == getBLACK()) {
			CurrentPlayer = getWHITE();
		}
		else {
			CurrentPlayer = getBLACK();
		}
	}

}
