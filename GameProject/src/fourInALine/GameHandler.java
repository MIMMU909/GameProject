package fourInALine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class GameHandler {
	private final int BOARD_SIZE = 7;
	private final int SCREEN_WIDTH = 45;
	private final int SCREEN_HEIGHT = 35;
	private JTextArea textArea;
	private String[][] buffer;
	private String stone, preBlack, preWhite;
	private boolean gameOver;
	private int switchPlayer, point, downPoint;
	int whiteScore = 0;
	int blackScore = 0;

	public GameHandler(JTextArea ta) {
		textArea = ta;
		buffer = new String[SCREEN_HEIGHT][SCREEN_WIDTH];
		initData();
	}

	public void initData() {
		switchPlayer = 1;
		point = 7;
		downPoint = 4;
		gameOver = false;
		clearBuffer();
		try {
			BufferedReader in = new BufferedReader(new FileReader("score.txt"));
				preBlack = in.readLine();
				preWhite = in.readLine();
				in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void clearBuffer() {
		for (int i = 0; i < SCREEN_HEIGHT; i++)
			for (int j = 0; j < SCREEN_WIDTH; j++)
				buffer[i][j] = " ";

		buffer[1][1] = "┌";
		for (int i = 1; i < BOARD_SIZE - 1; i++)
			buffer[1][i + 1] = "┬";
		buffer[1][BOARD_SIZE] = "┐";
		for (int i = 1; i < BOARD_SIZE - 2; i++) {
			buffer[i + 1][1] = "├";
			for (int j = 1; j < BOARD_SIZE - 1; j++)
				buffer[i + 1][j + 1] = "┼";
			buffer[i + 1][BOARD_SIZE] = "┤";
		}
		buffer[BOARD_SIZE - 1][1] = "└";
		for (int i = 1; i < BOARD_SIZE - 1; i++)
			buffer[BOARD_SIZE - 1][i + 1] = "┴";
		buffer[BOARD_SIZE - 1][BOARD_SIZE] = "┘";
	}

	private void drawToBuffer(int px, int py, String c) {
		buffer[py][px] = c;
	}

	public void drawAll() {
		scoreBoard();
		stonePoint();
		render();
	}

	private void stonePoint() {
		if (gameOver == false)
			stone = (switchPlayer % 2 == 0) ? "○" : "●";
		for (int i = 0; i < 14; i++)
			drawToBuffer(i, 0, " ");
		drawToBuffer(point, 0, stone);
	}

	private void scoreBoard() {
		drawToBuffer(15, 0, "┌──CURRENT──┐");
		drawToBuffer(9, 1, "│ ●:" + blackScore + "  ○:" + whiteScore + "  │");
		drawToBuffer(9, 2, "└───────────┘");

		drawToBuffer(9, 4, "┌──PREVIOUS─┐");
		drawToBuffer(9, 5, "│ ●:" + preBlack + "  ○:" + preWhite + "  │");
		drawToBuffer(9, 6, "└───────────┘");
	}

	private void render() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SCREEN_HEIGHT; i++) {
			for (int j = 0; j < SCREEN_WIDTH; j++) {
				if (j > 1 && j < 8 && i > 0 && i < 7)
					sb.append("─" + buffer[i][j]);
				else
					sb.append(buffer[i][j]);
			}
			sb.append("\n");
		}
		textArea.setText(sb.toString());
	}

	public void moveRight() {
		if (point < 12) {
			point += 2;
			downPoint++;
		}
	}

	public void moveLeft() {
		if (point > 1) {
			point -= 2;
			downPoint--;
		}
	}

	public void moveDown() {
		if (buffer[1][downPoint] == "○" || buffer[1][downPoint] == "●") {
		} else {
			int i = 1;
			while (true) {
				if (buffer[i][downPoint] == "○" || buffer[i][downPoint] == "●") {
					i--;
					break;
				} else {
					if (i == BOARD_SIZE - 1)
						break;
					else
						i++;
				}
			}
			buffer[i][downPoint] = stone;
			switchPlayer++;
		}
	}

	public void gameLogic() {
		for (int i = 1; i < BOARD_SIZE; i++) {
			for (int j = 1; j < BOARD_SIZE; j++) {
				if (j > 0 && j < 5 && buffer[i][j] == stone && buffer[i][j + 1] == stone && buffer[i][j + 2] == stone // 가로
						&& buffer[i][j + 3] == stone)
					gameOver = true;

				else if (i > 0 && i < 4 && buffer[i][j] == stone && buffer[i + 1][j] == stone
						&& buffer[i + 2][j] == stone // 세로
						&& buffer[i + 3][j] == stone)
					gameOver = true;

				else if (i < 4 && j < 5 && buffer[i][j] == stone && buffer[i + 1][j + 1] == stone // 왼오 대각선
						&& buffer[i + 2][j + 2] == stone && buffer[i + 3][j + 3] == stone)
					gameOver = true;

				else if (i > 3 && j < 5 && buffer[i][j] == stone && buffer[i - 1][j + 1] == stone // 오왼 대각선
						&& buffer[i - 2][j + 2] == stone && buffer[i - 3][j + 3] == stone)
					gameOver = true;
			}
		}
		if (gameOver == true) {
			if (stone == "○")
				whiteScore++;
			else
				blackScore++;
		}
	}

	public void drawGameOver() {
		drawToBuffer(8, 3, "╔═════════════╗");
		drawToBuffer(8, 4, "║   " + stone + " WINS!   ║");
		drawToBuffer(8, 5, "║             ║");
		drawToBuffer(8, 6, "║ AGAIN? (Y/N)║");
		drawToBuffer(14, 7, "╚═════════════╝");
		render();
	
	}

	public boolean isGameOver() {
		return gameOver;
	}
}
