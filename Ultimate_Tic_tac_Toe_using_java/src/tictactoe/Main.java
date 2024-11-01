package tictactoe;

import javax.swing.JFrame;

public class Main {
	
	public static int WIDTH = 300;
	public static int HEIGHT = 300;
	
	public static int ROWS = 3;
	public static int MATCH = 3;
	public static int SIZE = ROWS * ROWS;
	
	
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("Tic-Tac-Toe :)");
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
