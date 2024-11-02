package tictactoe;

import java.awt.Color;
import java.awt.Graphics2D;

public class Grid implements IGameObject{
	
	private int gridThickness = 16;
	
	public Grid() {
		
	}

	@Override
	public void update(float deltatime) {
		
	}

	@Override
	public void render(Graphics2D graphicsRender) {
		
		renderGrid(graphicsRender);
	}

	private void renderGrid(Graphics2D graphicsRender) {
		
		graphicsRender.setColor(new Color(0x2e2e2e));
		
		int rowSize = Main.WIDTH / Main.ROWS;
		
		for (int i = 0; i < Main.ROWS+1; i++) {
			
			graphicsRender.fillRect(i*rowSize - (gridThickness / 2), 0, gridThickness, Main.WIDTH);
			for (int j = 0; j < Main.ROWS+1; j++) {
				graphicsRender.fillRect( 0,j*rowSize - (gridThickness / 2), Main.WIDTH, gridThickness);
			}
		}
		
		
		
		graphicsRender.setColor(Color.white);
		
	}
	

}
