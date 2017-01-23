package a.reversi;

import java.util.Scanner;

public class Main {
    // 盤の状態
    static String[][] board = new String[10][10];

    public static void main(String[] args) {
	// 自分の得意な言語で
	// Let's チャレンジ！！
	Scanner sc = new Scanner(System.in);
	int count = sc.nextInt();

	// 最初の状態
	board[4][4] = "W";
	board[4][5] = "B";
	board[5][4] = "B";
	board[5][5] = "W";

	Reversi reversi = new Reversi();
	for (int i = 0; i < count; i++) {
	    String color = sc.next();

	    int x = sc.nextInt();
	    int y = sc.nextInt();

	    reversi.reverse(color, x, y);

	}
	int countB = 0;
	int countW = 0;
	for (int j = 0; j < 10; j++) {
	    for (int k = 0; k < 10; k++) {
		if ("B".equals(board[j][k])) {
		    countB++;
		} else if ("W".equals(board[j][k])) {
		    countW++;
		}
	    }
	}
	String ansB = "";
	String ansW = "";
	if (countB < 10) {
	    ansB = "0" + String.valueOf(countB);
	} else {
	    ansB = String.valueOf(countB);
	}
	if (countW < 10) {
	    ansW = "0" + String.valueOf(countW);
	} else {
	    ansW = String.valueOf(countW);
	}

	if (countB > countW) {
	    System.out.println(ansB + "-" + ansW + " The black won!");
	} else {
	    System.out.println(ansB + "-" + ansW + " The white won!");
	}
    }
}

class Reversi {
    int endX;
    int endY;

    public void reverse(String color, int x, int y) {
	Main.board[x][y] = color;
	if (x < 3) {
	    if (y < 3) {
		// 東
		endX = 0;
		endY = 0;
		checkEast(color, x, y);
		reverseEast(color, x, y, endX, endY);
		// 南東
		endX = 0;
		endY = 0;
		checkSouthEast(color, x, y);
		reverseSouthEast(color, x, y, endX, endY);
		// 南
		endX = 0;
		endY = 0;
		checkSouth(color, x, y);
		reverseSouth(color, x, y, endX, endY);
	    } else if (y < 7) {
		// 北
		endX = 0;
		endY = 0;
		checkNorth(color, x, y);
		reverseNorth(color, x, y, endX, endY);
		// 北東
		endX = 0;
		endY = 0;
		checkNorthEast(color, x, y);
		reverseNorthEast(color, x, y, endX, endY);
		// 東
		endX = 0;
		endY = 0;
		checkEast(color, x, y);
		reverseEast(color, x, y, endX, endY);
		// 南東
		endX = 0;
		endY = 0;
		checkSouthEast(color, x, y);
		reverseSouthEast(color, x, y, endX, endY);
		// 南
		endX = 0;
		endY = 0;
		checkSouth(color, x, y);
		reverseSouth(color, x, y, endX, endY);
	    } else {
		// 北
		endX = 0;
		endY = 0;
		checkNorth(color, x, y);
		reverseNorth(color, x, y, endX, endY);
		// 北東
		endX = 0;
		endY = 0;
		checkNorthEast(color, x, y);
		reverseNorthEast(color, x, y, endX, endY);
		// 東
		endX = 0;
		endY = 0;
		checkEast(color, x, y);
		reverseEast(color, x, y, endX, endY);
	    }
	} else if (x < 7) {
	    if (y < 2) {
		// 東
		endX = 0;
		endY = 0;
		checkEast(color, x, y);
		reverseEast(color, x, y, endX, endY);
		// 南東
		endX = 0;
		endY = 0;
		checkSouthEast(color, x, y);
		reverseSouthEast(color, x, y, endX, endY);
		// 南
		endX = 0;
		endY = 0;
		checkSouth(color, x, y);
		reverseSouth(color, x, y, endX, endY);
		// 南西
		endX = 0;
		endY = 0;
		checkSouthWest(color, x, y);
		reverseSouthWest(color, x, y, endX, endY);
		// 西
		endX = 0;
		endY = 0;
		checkWest(color, x, y);
		reverseWest(color, x, y, endX, endY);
	    } else if (y < 7) {
		// 東
		endX = 0;
		endY = 0;
		checkEast(color, x, y);
		reverseEast(color, x, y, endX, endY);
		// 南東
		endX = 0;
		endY = 0;
		checkSouthEast(color, x, y);
		reverseSouthEast(color, x, y, endX, endY);
		// 南
		endX = 0;
		endY = 0;
		checkSouth(color, x, y);
		reverseSouth(color, x, y, endX, endY);
		// 南西
		endX = 0;
		endY = 0;
		checkSouthWest(color, x, y);
		reverseSouthWest(color, x, y, endX, endY);
		// 西
		endX = 0;
		endY = 0;
		checkWest(color, x, y);
		reverseWest(color, x, y, endX, endY);
		// 北東
		endX = 0;
		endY = 0;
		checkNorthWest(color, x, y);
		reverseNorthWest(color, x, y, endX, endY);
		// 北
		endX = 0;
		endY = 0;
		checkNorth(color, x, y);
		reverseNorth(color, x, y, endX, endY);
		// 北東
		endX = 0;
		endY = 0;
		checkNorthEast(color, x, y);
		reverseNorthEast(color, x, y, endX, endY);
	    } else {
		// 西
		endX = 0;
		endY = 0;
		checkWest(color, x, y);
		reverseWest(color, x, y, endX, endY);
		// 北東
		endX = 0;
		endY = 0;
		checkNorthWest(color, x, y);
		reverseNorthWest(color, x, y, endX, endY);
		// 北
		endX = 0;
		endY = 0;
		checkNorth(color, x, y);
		reverseNorth(color, x, y, endX, endY);
		// 北東
		endX = 0;
		endY = 0;
		checkNorthEast(color, x, y);
		reverseNorthEast(color, x, y, endX, endY);
		// 東
		endX = 0;
		endY = 0;
		checkEast(color, x, y);
		reverseEast(color, x, y, endX, endY);
	    }
	} else {
	    if (y < 3) {
		// 南
		endX = 0;
		endY = 0;
		checkSouth(color, x, y);
		reverseSouth(color, x, y, endX, endY);
		// 南西
		endX = 0;
		endY = 0;
		checkSouthWest(color, x, y);
		reverseSouthWest(color, x, y, endX, endY);
		// 西
		endX = 0;
		endY = 0;
		checkWest(color, x, y);
		reverseWest(color, x, y, endX, endY);
	    } else if (y < 7) {
		// 南
		endX = 0;
		endY = 0;
		checkSouth(color, x, y);
		reverseSouth(color, x, y, endX, endY);
		// 南西
		endX = 0;
		endY = 0;
		checkSouthWest(color, x, y);
		reverseSouthWest(color, x, y, endX, endY);
		// 西
		endX = 0;
		endY = 0;
		checkWest(color, x, y);
		reverseWest(color, x, y, endX, endY);
		// 北東
		endX = 0;
		endY = 0;
		checkNorthWest(color, x, y);
		reverseNorthWest(color, x, y, endX, endY);
		// 北
		endX = 0;
		endY = 0;
		checkNorth(color, x, y);
		reverseNorth(color, x, y, endX, endY);
	    } else {
		// 西
		endX = 0;
		endY = 0;
		checkWest(color, x, y);
		reverseWest(color, x, y, endX, endY);
		// 北東
		endX = 0;
		endY = 0;
		checkNorthWest(color, x, y);
		reverseNorthWest(color, x, y, endX, endY);
		// 北
		endX = 0;
		endY = 0;
		checkNorth(color, x, y);
		reverseNorth(color, x, y, endX, endY);
	    }
	}
    }

    // 東
    private void checkEast(String color, int x, int y) {
	endY = y;
	for (int j = x + 2; j < 9; j++) {
	    if (Main.board[j][y] != null && color.equals(Main.board[j][y])) {
		endX = j;
		break;
	    }
	}
    }

    private void reverseEast(String color, int x, int y, int endX, int endY) {
	if (endX == 0 || endY == 0) {
	    return;
	}
	for (int j = x + 1; j < endX; j++) {
	    Main.board[j][y] = color;
	}
    }

    // 南東
    private void checkSouthEast(String color, int x, int y) {
	for (int j = 2; x + j < 9; j++) {
	    int tmpX = x + j;
	    int tmpY = y + j;

	    if (Main.board[tmpX][tmpY] == null) {
		break;
	    }
	    if (color.equals(Main.board[tmpX][tmpY])) {
		endX = tmpX;
		endY = tmpY;
		break;
	    }
	}
    }

    private void reverseSouthEast(String color, int x, int y, int endX, int endY) {
	if (endX == 0 || endY == 0) {
	    return;
	}
	for (int j = 1; x + j < endX; j++) {
	    Main.board[x + j][y + j] = color;
	}
    }

    // 南
    private void checkSouth(String color, int x, int y) {
	endX = x;
	for (int j = y + 2; j < 9; j++) {
	    if (Main.board[x][j] != null && color.equals(Main.board[x][j])) {
		endY = j;
		break;
	    }
	}
    }

    private void reverseSouth(String color, int x, int y, int endX, int endY) {
	if (endX == 0 || endY == 0) {
	    return;
	}
	for (int j = y + 1; j < endY; j++) {
	    Main.board[x][j] = color;
	}
    }

    // 南西
    private void checkSouthWest(String color, int x, int y) {
	for (int j = 2; 0 < x - j; j++) {
	    int tmpX = x - j;
	    int tmpY = y + j;
	    if (Main.board[tmpX][tmpY] == null) {
		break;
	    }
	    if (color.equals(Main.board[tmpX][tmpY])) {
		endX = tmpX;
		endY = tmpY;
		break;
	    }
	}
    }

    private void reverseSouthWest(String color, int x, int y, int endX, int endY) {
	if (endX == 0 || endY == 0) {
	    return;
	}
	for (int j = 1; endX < x - j; j++) {
	    Main.board[x - j][y + j] = color;
	}
    }

    // 西
    private void checkWest(String color, int x, int y) {
	endY = y;
	for (int j = x - 2; 0 < j; j--) {
	    if (Main.board[j][y] != null && color.equals(Main.board[j][y])) {
		endX = j;
		break;
	    }
	}
    }

    private void reverseWest(String color, int x, int y, int endX, int endY) {
	if (endX == 0 || endY == 0) {
	    return;
	}
	for (int j = x - 1; endX < j; j--) {
	    Main.board[j][y] = color;
	}
    }

    // 北西
    private void checkNorthWest(String color, int x, int y) {
	for (int j = 2; 0 < x - j; j++) {
	    int tmpX = x - j;
	    int tmpY = y - j;
	    if (Main.board[tmpX][tmpY] == null) {
		break;
	    }
	    if (color.equals(Main.board[tmpX][tmpY])) {
		endX = tmpX;
		endY = tmpY;
		break;
	    }
	}
    }

    private void reverseNorthWest(String color, int x, int y, int endX, int endY) {
	if (endX == 0 || endY == 0) {
	    return;
	}
	for (int j = 1; endX < x - j; j++) {
	    Main.board[x - j][y - j] = color;
	}
    }

    // 北
    private void checkNorth(String color, int x, int y) {
	endX = x;
	for (int j = y - 2; 0 < j; j--) {
	    if (Main.board[x][j] != null && color.equals(Main.board[x][j])) {
		endY = j;
		break;
	    }
	}
    }

    private void reverseNorth(String color, int x, int y, int endX, int endY) {
	if (endX == 0 || endY == 0) {
	    return;
	}
	for (int j = y - 1; endY < j; j--) {
	    Main.board[x][j] = color;
	}
    }

    // 北東
    private void checkNorthEast(String color, int x, int y) {
	for (int j = 2; x + j < 9; j++) {
	    int tmpX = x + j;
	    int tmpY = y - j;
	    if (Main.board[tmpX][tmpY] == null) {
		break;
	    }
	    if (color.equals(Main.board[tmpX][tmpY])) {
		endX = tmpX;
		endY = tmpY;
		break;
	    }
	}
    }

    private void reverseNorthEast(String color, int x, int y, int endX, int endY) {
	if (endX == 0 || endY == 0) {
	    return;
	}
	for (int j = 1; x + j < endX; j++) {
	    Main.board[x + j][y - j] = color;
	}
    }
}