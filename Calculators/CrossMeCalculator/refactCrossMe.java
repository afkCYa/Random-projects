package crossme;
import java.util.Arrays;

public class refactCrossMe {
	
	/*functions that I'll probably never touch again*/
	
	
	// dis boi for getting the nums in an array when input
	public int[] numberInput(String in, int size) {
		int[] squares = new int[size]; 
		//usually 25 cuz rare you go over that, but in future get grid limits
		String[] splitting = in.trim().split(" ");
		
		for(int i = 0; i<splitting.length; i++) {
			squares[i] = Integer.valueOf(splitting[i]);
//			System.out.println(splitting[i]);
		}
		// i aint bothering with exceptions, i expect perfect values 
		// i wrote this code smh and im the one using it
		// one simply does not fail one's own code of misconduct
		
		return squares;
	}

	// dis boi for printing user input array
	// mostly wanted to check if the output array is outputting properly
	// aka tester function
	public void printNumberArray(int[] in) {
		System.out.println("Those are the numbers you have entered:");
		int i = 0;
		while (in[i] != 0)
		{
			System.out.print(in[i] + "  ");
			i++;
		}
		System.out.println("");
	}
	
	// dis boi cuz am too lazy to write and import the whole thing
	public int maxOfArray(int[] nums) {
		int maxNum = Arrays.stream(nums).max().getAsInt();
		return maxNum;
	}

	// dis boi was attempt to print blocks. did not go well. eventually half fixed
	public void printBlocks(int[] blocks) {
		for(int i = 0; i<blocks.length; i++) {
			if (i%5 == 0) {
				System.out.print("|");
			}
			if(blocks[i] == 0) {
				// empty
				System.out.print("⬚");
			} else if(blocks[i] == -1) {
				// full
				System.out.print("▣");
			} else if(blocks[i] == -4) {
				// x
				System.out.print("☒");
				
			} else if(blocks[i] == -11) {
				// temp full
				System.out.print("▦");
			} else if(blocks[i] == -14) {
				// temp x
				System.out.print("▧");
			}
		}
		System.out.println();
	}

	// dis boi just to print the array numbers (i gave up)
	public void printNums(int[] blocks) {
		for(int i = 0; i<blocks.length; i++) {
			if(i%5 == 0) {
				System.out.print("|");
			}
			System.out.print(blocks[i] + ".");
		}
		System.out.println();
	}
	
	// dis boi for minReq number to be put in the grid
	// [0] minReqVSMax, [1] MaxSpaceBlanks, [2] fullLine, [3] inputMax
	public int[] statsArray(int[] nums, int blocks) {
		/** so this returns an Array
		* A[0] is minimum number required so you can have a block somewhere. Usually compared with A[3] MaxNum
		* A[1] is the available blanks for the biggest number
		* A[2] is if it's full line. like 1 for full, 0 for not full
		* A[3] is maxOfArray. Biggest number of input array
		*/
		int[] out = new int[4];
		int min, maxNum, addup = -1, i = 0, remove;
		maxNum = maxOfArray(nums);
		
		out[3] = maxNum;
		
		do {
			addup = +(addup + nums[i] + 1);
			i++;
		} while (nums[i] != 0);
		
		// if full line check
		if (addup == blocks) {
			out[2] = 1;
		} else {
			out[2] = 0;
		}
		
		addup = addup - maxNum;
		
		remove = (blocks - addup);
		min = (((remove)/2)+1);
		
//		System.out.println("Minimum length that can be put is : " + min);
//		System.out.println("Blocks available for biggest number is : " + remove);
//		System.out.println("Check full line(1) or not full line(0) is : " + out[2]);

		out[0] = min;
		out[1] = remove;
		
		return out;
	}
	
	// dis boi checks if you can fill any squares on the row column
	public boolean canBlocks(int[] usable) {
		int maxArr = usable[3];
		int usableMax = usable[0];
//		System.out.println(maxArr);
//		System.out.println(usableMax);
		
		// literal full line better be tru
		if (usable[2] == 1) {
			return true;
		}
		
		if (maxArr >= usableMax) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	/*uncertain code still*/
	
	
	// dis MAIN boi just contains the rest also is the flowchart
	public void mainPack(int[] nums, int blocks) {
		printNumberArray(nums);
		int[] usable = statsArray(nums, blocks);
		
		// if full line
		if (usable[2] == 1) {
			blocksFullLineArray(nums, blocks);
		} else { // not full line check if you can put any blocks
			boolean check = canBlocks(usable);
			if (check) { // some blocks can be put
				
			} else { // can't put any block, just tell user to look elsewhere
				System.out.println("This line has no filling prediction for now");
			}
		}
		
	}
	
	// dis boi to know which actual lowest number can get fitted w max in the fray
	// but dont run this if the canBlocks is false
	// still iffy about it
	public int actualLowestNumber(int[] info) {
		int max = info[3];
		int spaces = info[1];

		int out = spaces-max + 1;
		System.out.println("Anything equal or bigger than >" + out + "< can have blocks");
		
		return out;
	}
	
	// quickly -11 = temp full, -14 = temp x
	// dis boi to create the array for not full line blocks
	public int[] blocksArray(int[] nums, int blocks) {
		int[] out = new int[blocks];
		int[] process = new int[blocks];
		int[] duo = statsArray(nums, blocks);
		boolean forCheck = true;
		//int check = actualLowestNumber(duo);
		int tempSize, index = 0;
		
		try {
			// case that every number can be fully fitted (full line)
			if(duo[2] == 1) {
				forCheck = false;
				for (int i = 0; i<nums.length; i++) {
					// set size to the blocks adding count
					tempSize = nums[i];
					// from where the index was to the amount of blocks, fill blocks
					for (int j = index; j < index+tempSize; j++) {
						out[j] = -1;
					}
					// put the x
					out[index+tempSize] = -4;
					index = index+tempSize+1;
				}
			}
		
		} catch (ArrayIndexOutOfBoundsException e) {
			// mostly for the last x that goes out of bounds
			System.out.println("Ik it breaks but i lazy");
		}
		
		if (forCheck) {
			// get the good nums in the out array
			for(int i=0; i<blocks; i++) {
				if(process[i] == -1) {
					out[i] = process[i];
				} 
				if(process[i] == -4) {
					out[i] = process[i];
				} 
			}
			System.out.println("This is process");
			printNums(process);
			printBlocks(process);
		}
		
		System.out.println("This is out");
		printNums(out);
		printBlocks(out);
		
		return out;
	}
	
	// quickly, 0 = empty, -1 = full, -4 = x
	// dis boi to create the array for full line
	public int[] blocksFullLineArray(int[] nums, int blocks) {
		int[] out = new int[blocks];
		int tempSize, index = 0;

		try {
			for (int i = 0; i<nums.length; i++) {
				// set size to the blocks adding count
				tempSize = nums[i];
				// from where the index was to the amount of blocks, fill blocks
				for (int j = index; j < index+tempSize; j++) {
					out[j] = -1;
				}
				// put the x
				out[index+tempSize] = -4;
				index = index+tempSize+1;
			}


		} catch (ArrayIndexOutOfBoundsException e) {
			// mostly for the last x that goes out of bounds

//			System.out.println("Ik it OOB breaks but i lazy");
		}

		System.out.println("This is out");
//		printNums(out);
		printBlocks(out);
		
		return out;
	}

	
	// dead code.

	public int[] blocksArrayDeprecated(int[] nums, int blocks) {
		int[] out = new int[blocks];
		int[] process = new int[blocks];
		int[] duo = statsArray(nums, blocks);
		int check = actualLowestNumber(duo);
		int tempSize, index = 0;
		int minusIndex;

		try {
			for(int i = 0; i<nums.length; i++) {
				tempSize = nums[i];
				if (tempSize >= check) {
					// empty is even means you need 2 blocks fillers
					if(duo[1]%2 == 0) {
						// fill the 2 default
						process[index+check-1] = -1;
						process[index+check] = -1;

						// check if "if" is deadcode
						if (tempSize == check) {
							// if is = default, continue
						} else {
							// else go from the big num and go down w minus index till filled block
							minusIndex = 0;
							while(true) {
								if(process[index+tempSize-minusIndex] == -1) {
									break;
								} else {
									process[index+tempSize-minusIndex] = -1;
									minusIndex--;
								}
							}
							// now get the other half

							for(int k = minusIndex; k != 0; k--) {
								process[index+check-2-minusIndex] = -1;
							}
						}
					} else {
						// if this is odd
						process[index+check] = -1;
						// check if "if" is deadcode
						if (tempSize == check) {
							// if is = default, continue
						} else {
							minusIndex = 0;
							while(true) {
								if(process[index+tempSize-minusIndex] == -1) {
									break;
								} else {
									process[index+tempSize-minusIndex] = -1;
									minusIndex--;
								}
							}
							// now get the other half

							for(int k = minusIndex; k != 0; k--) {
								process[index+check-1-minusIndex] = -1;
							}
						}
					}
					// add temp x & go on
					process[index+tempSize] = -14;
					index = index+tempSize+1;
				} else {
					for(int j = index; j<index+tempSize; j++) {
						process[j] = -11;
					}
					process[index+tempSize] = -14;
					index = index+tempSize+1;
				}

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Ik it breaks i lazy");
		}

		// get the good nums in the out array
		for(int i=0; i<blocks; i++) {
			if(process[i] == -1) {
				out[i] = process[i];
			} 
			if(process[i] == -4) {
				out[i] = process[i];
			} 
		}

		System.out.println("This is process");
		printNums(process);
		System.out.println("This is out");
		printNums(out);

		return out;
	}

}
