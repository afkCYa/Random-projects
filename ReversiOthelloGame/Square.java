package othello;
	/*
	 * CYun July 2024
		set up coordinates and ways to get references across
		the board for check and flip purposes
	*/
public class Square {
	private int h, v;
	private String UndoCaps;

//enter coordinates, allows for returning the array version	
	public Square(char horizontal, int vertical) {
//this thing just to make the char lower case		
		UndoCaps = ""+ horizontal + "Meow";
		UndoCaps = UndoCaps.toLowerCase();
		horizontal = UndoCaps.charAt(0);
//-1 as default to break the array if it doesn't fit	
		int equivalent = -1;
		if (horizontal == 'a') {
			equivalent = 0;
		}
		else if (horizontal == 'b') {
			equivalent = 1;
		}
		else if (horizontal == 'c') {
			equivalent = 2;
		}
		else if (horizontal == 'd') {
			equivalent = 3;
		}
		else if (horizontal == 'e') {
			equivalent = 4;
		}
		else if (horizontal == 'f') {
			equivalent = 5;
		}
		else if (horizontal == 'g') {
			equivalent = 6;
		}
		else if (horizontal == 'h') {
			equivalent = 7;
		}
// to get the actual array, entering 1 is the equivalent of array location 8
// meanwhile entering 8 is location 1, so just (9-entered) gives array place
	// due to board change and me being lazy i just changed equivalent to +1
		vertical = 9 - vertical;
		h = equivalent+1;
		v = vertical;
	}//constructor for points
//getter for the 2 values from point, setter is just make a new point every time
	public int getHorizontal() {
		return h;
	}
	public int getVertical() {
		return v;
	}

	private int copyh, copyv;
// to not move the OG h & v and to have a position to return to
//	by not moving the OGs cause we go down multiple lanes
	public void resetCopyh() {
		copyh = h;
	}
	public void resetCopyv() {
		copyv = v;
	}
	public int getCopyh() {
		return copyh;
	}
	public int getCopyv() {
		return copyv;
	}
// combine them to move in directions for board	
	public void moveUp () {
		this.copyv = copyv - 1;
	}
	public void moveDown () {
		this.copyv = copyv + 1;
	}
	public void moveLeft () {
		this.copyh = copyh - 1;
	}
	public void moveRight () {
		this.copyh = copyh + 1;
	}

}
