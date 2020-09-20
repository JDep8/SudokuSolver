import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Sudoku {

    private int grid[][];

    public Sudoku() {

	this.grid = new int[9][9];

	inputGrid();
	solve();

	// test();

    }

    public void inputGrid() {

	try {
	    Scanner fileScanner = new Scanner(new FileReader("input.txt"));

	    int currentRow = 0;

	    while (fileScanner.hasNextLine()) {
		String inputValues[] = fileScanner.nextLine().split(",");
		for (int i = 0; i < 9; i++) {

		    this.grid[currentRow][i] = Integer.parseInt(inputValues[i]);
		}

		currentRow++;
	    }

	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void test() {

	boolean possible = checkPossible(0, 3, 1);

	if (possible == true) {
	    System.out.println("True");

	} else {
	    System.out.println("false");
	}

    }

    public void solve() {

	for (int y = 0; y < 9; y++) {

	    for (int x = 0; x < 9; x++) {

		if (this.grid[y][x] == 0) {
		    for (int n = 1; n < 10; n++) {

			boolean possible = checkPossible(y, x, n);
			if (possible == true) {

			    this.grid[y][x] = n;
			    solve();
			    this.grid[y][x] = 0;

			}

		    }
		    return;
		}
	    }
	}
	printGrid();
    }

    public boolean checkPossible(int y, int x, int n) {

	// Check Y axis
	for (int i = 0; i < 9; i++) {
	    if (this.grid[y][i] == n) {
		return false;
	    }
	}

	// Check X axis
	for (int i = 0; i < 9; i++) {
	    if (this.grid[i][x] == n) {
		return false;
	    }

	}
	// Check Square
	int x0 = (x / 3) * 3;
	int y0 = (y / 3) * 3;

	for (int i = 0; i < 3; i++) {
	    for (int o = 0; o < 3; o++) {

		if (this.grid[y0 + i][x0 + o] == n) {
		    return false;
		}
	    }

	}

	return true;
    }

    public void printGrid() {

	for (int y = 0; y < 9; y++) {

	    for (int x = 0; x < 9; x++) {
		System.out.print(this.grid[y][x]);

		if (x != 8) {
		    System.out.print(",");

		}
	    }
	    System.out.println();
	}
	System.out.println();
	System.out.println();
    }

    public static void main(String[] args) {
	Sudoku sudoku;
	sudoku = new Sudoku();

    }

}
