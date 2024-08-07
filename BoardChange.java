package othello;
	/*
	 * CYun July 2024
		shall make the playable moves
		and the flips that happens
		and help checking
		
		this is the average compass system
		  N
		W ? E
		  S
		we need to mark 8 squares around the move
		NW NN NE
		WW ?? EE
		SW SS SE
		this is the naming reasoning, with ?? being the move we check for
		also usable to just continue down the line	
	 */

	/*	board drawn
			0 1 2 3 4 5 6 7
	0	8	# # # # # # # #
	1	7	# # # # # # # #
	2	6	# # O # O @ # #
	3	5	# # # O @ O # #
	4	4	# # # @ O # # #
	5	3	# # @ # # O # #
	6	2	# # # # # # # #
	7	1	# # # # # # # #

			a b c d e f g h
			0 1 2 3 4 5 6 7
	 */

public class BoardChange extends Board {

// choosing the board	
	public BoardChange(int choice) {
		super(choice);
		// TODO Auto-generated constructor stub
	}

// characters around the playing square	
	char cWW, cNW, cNN, cNE, cEE, cSW, cSS, cSE;
	public char getcWW(int h, int v) {
		h = h-1;
		cWW = boardo[h][v];
		return cWW;
	}
	public char getcNW(int h, int v) {
		h = h-1;
		v = v-1;
		cNW = boardo[h][v];
		return cNW;
	}
	public char getcNN(int h, int v) {
		v = v-1;
		cNN = boardo[h][v];
		return cNN;
	}
	public char getcNE(int h, int v) {
		h = h+1;
		v = v-1;
		cNE = boardo[h][v];
		return cNE;
	}
	public char getcEE(int h, int v) {
		h = h+1;
		cEE = boardo[h][v];
		return cEE;
	}
	public char getcSE(int h, int v) {
		h = h+1;
		v = v+1;
		cSE = boardo[h][v];
		return cSE;
	}
	public char getcSS(int h, int v) {
		v = v+1;
		cSS = boardo[h][v];
		return cSS;
	}
	public char getcSW(int h, int v) {
		h = h-1;
		v = v+1;
		cSW = boardo[h][v];
		return cSW;
	}

// to flip to current player color	
	public void setCase(int h, int v, Player pl) {
		boardo[h][v] = pl.getPlayerRN();
	}


// major flip	
	public void flip(Square sq, Player pl) {
		if (Validation.WW == 1) {
			flipWW(sq, pl);
		}
		if (Validation.NW == 1) {
			flipNW(sq, pl);
		}
		if (Validation.NN == 1) {
			flipNN(sq, pl);
		}
		if (Validation.NE == 1) {
			flipNE(sq, pl);
		}
		if (Validation.EE == 1) {
			flipEE(sq, pl);
		}
		if (Validation.SE == 1) {
			flipSE(sq, pl);
		}
		if (Validation.SS == 1) {
			flipSS(sq, pl);
		}
		if (Validation.SW == 1) {
			flipSW(sq, pl);
		}		
	}
// minor singular flips		
	public void flipWW(Square sq, Player pl) {
		int hi = sq.getHorizontal();
//		int vi = sq.getVertical();
		int hf = Validation.WWh;
		int vf = Validation.WWv;
	
		while (hf != hi) {
			setCase(hf, vf, pl);
			hf = hf+1;
		}
	}
	public void flipNW(Square sq, Player pl) {
		int hi = sq.getHorizontal();
//		int vi = sq.getVertical();
		int hf = Validation.NWh;
		int vf = Validation.NWv;
	
		while (hf != hi) {
			setCase(hf, vf, pl);
			hf = hf+1;
			vf = vf+1;
		}
	}
	public void flipNN(Square sq, Player pl) {
//		int hi = sq.getHorizontal();
		int vi = sq.getVertical();
		int hf = Validation.NNh;
		int vf = Validation.NNv;
	
		while (vf != vi) {
			setCase(hf, vf, pl);
			vf = vf+1;
		}
	}
	public void flipNE(Square sq, Player pl) {
		int hi = sq.getHorizontal();
//		int vi = sq.getVertical();
		int hf = Validation.NEh;
		int vf = Validation.NEv;
	
		while (hf != hi) {
			setCase(hf, vf, pl);
			hf = hf-1;
			vf = vf+1;
		}
	}
	public void flipEE(Square sq, Player pl) {
		int hi = sq.getHorizontal();
//		int vi = sq.getVertical();
		int hf = Validation.EEh;
		int vf = Validation.EEv;
	
		while (hf != hi) {
			setCase(hf, vf, pl);
			hf = hf-1;
		}
	}
	public void flipSE(Square sq, Player pl) {
		int hi = sq.getHorizontal();
//		int vi = sq.getVertical();
		int hf = Validation.SEh;
		int vf = Validation.SEv;
	
		while (hf != hi) {
			setCase(hf, vf, pl);
			hf = hf-1;
			vf = vf-1;
		}
	}
	public void flipSS(Square sq, Player pl) {
//		int hi = sq.getHorizontal();
		int vi = sq.getVertical();
		int hf = Validation.SSh;
		int vf = Validation.SSv;
	
		while (vf != vi) {
			setCase(hf, vf, pl);
			vf = vf-1;
		}
	}
	public void flipSW(Square sq, Player pl) {
//		int hi = sq.getHorizontal();
		int vi = sq.getVertical();
		int hf = Validation.SWh;
		int vf = Validation.SWv;
	
		while (vf != vi) {
			setCase(hf, vf, pl);
			hf = hf+1;
			vf = vf-1;
		}
	}
	
}