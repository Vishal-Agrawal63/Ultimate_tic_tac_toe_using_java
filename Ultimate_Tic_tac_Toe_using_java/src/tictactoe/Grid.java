package tictactoe;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Grid implements IGameObject{
	
	private ArrayList<Placement> placements = new ArrayList<Placement>(Main.SIZE);
	
	private int gridThickness = 16;
	
	public Grid() {
		for(int i=0;i<Main.SIZE;i++) {
			
			// 0%3=0, 1%3=1; 2%3=2
			int xIndex = i % Main.ROWS;  
			
			
			int yIndex = i / Main.ROWS;
			
			int size = Main.WIDTH / Main.ROWS;
			
			placements.add(new Placement(xIndex * size, yIndex*size,xIndex, yIndex,size,size));
		}
		
	}

	@Override
	public void update(float deltatime) {
		for(Placement placement : placements) {
			placement.update(deltatime);
		}
	}

	@Override
	public void render(Graphics2D graphicsRender) {
		for(Placement placement : placements) {
			placement.render(graphicsRender);
		}
		renderGrid(graphicsRender);
	}

	private void renderGrid(Graphics2D graphicsRender) {
		
		graphicsRender.setColor(new Color(0x2e2e2e));
		
		int rowSize = Main.WIDTH / Main.ROWS;
		
		for (int i = 0; i < Main.ROWS+1; i++) { //for vertical lines
			
			graphicsRender.fillRect(i*rowSize - (gridThickness / 2), 0, gridThickness, Main.WIDTH);
			
			for (int j = 0; j < Main.ROWS+1; j++) { // for horizontal lines
				
				graphicsRender.fillRect( 0,j*rowSize - (gridThickness / 2), Main.WIDTH, gridThickness);
			}
		}
		
		
		
		graphicsRender.setColor(Color.white);
		
	}
	
	public void mouseMoved(MouseEvent e) {
		for (Placement placement : placements) {
			placement.checkCollision(e.getX(), e.getY() - 30);
		}
	}
	

}
