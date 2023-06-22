package fourInALine;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class LineGame extends JFrame implements KeyListener {
	private GameHandler handler;
	private JTextArea textArea = new JTextArea();

	public LineGame() {
		setTitle("Let's play 4 In A Line");
		setSize(540, 330);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 30));
		textArea.addKeyListener(this);
		add(textArea);
		textArea.setEditable(false);
		setVisible(true);

		handler = new GameHandler(textArea);
		new Thread(new GameThread()).start();
	}

	public static void main(String[] args) {
		new LineGame();
	}

	public void restart() {
		handler.initData();
		new Thread(new GameThread()).start();
	}

	class GameThread implements Runnable {
		public void run() {
			while (!handler.isGameOver()) {
				handler.gameLogic();
				handler.drawAll();
			}
			handler.drawGameOver();
		}
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			handler.moveRight();
			break;

		case KeyEvent.VK_LEFT:
			handler.moveLeft();
			break;

		case KeyEvent.VK_DOWN:
			handler.moveDown();
			break;

		case KeyEvent.VK_Y:
			if (handler.isGameOver())
				restart();
			break;

		case KeyEvent.VK_N:
			if (handler.isGameOver()) {
				BufferedWriter out;
				try {
					out = new BufferedWriter(new FileWriter("score.txt"));
					out.write(String.valueOf(handler.blackScore));
					out.newLine();
					out.write(String.valueOf(handler.whiteScore));
					out.close();
				}catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}
}