package tictactoe;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class Grid implements IGameObject{
	
	private ArrayList<Placement> placements = new ArrayList<Placement>(Main.SIZE);
	private Marker[][] markers;
	
	private int gridThickness = 16;
	private int markerIndex = 0;
	private boolean gameEnd = false;
	private int winType = -1;
	
	public Grid() {
		
		
//		find the marker
		markers = new Marker[Main.ROWS][Main.ROWS];
		
		
		for(int i=0;i<Main.SIZE;i++) {
			
			// 0%3=0, 1%3=1; 2%3=2
			int xIndex = i % Main.ROWS;  
			
			
			int yIndex = i / Main.ROWS;
			
			int size = Main.WIDTH / Main.ROWS;
			
			placements.add(new Placement(xIndex * size, yIndex*size,xIndex, yIndex,size,size));
		}
		
		reset();
		
	}

	@Override
	public void update(float deltatime) {
		for(Placement placement : placements) {
			placement.update(deltatime);
		}
		
		for (int x = 0;  x < markers.length; x++) {
			for (int y = 0; y < markers.length; y++) {
				
				if(markers[x][y] == null) {
					continue;
				}
				
				markers[x][y].update(deltatime);
			}
		}
	}

	@Override
	public void render(Graphics2D graphicsRender) {
		
		for(Placement placement : placements) {
			placement.render(graphicsRender);
		}
		
		for (int x = 0;  x < markers.length; x++) {
			for (int y = 0; y < markers.length; y++) {
				
				if(markers[x][y] == null) {
					continue;
				}
				
				markers[x][y].render(graphicsRender);
			}
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

	public void mouseReleased(MouseEvent e) {
		for (Placement placement : placements) {
			if(placement.isActive()) {
				
				int x = placement.getxIndex();
				int y = placement.getyIndex();
				markers[x][y] = new Marker(x, y, markerIndex);
				
				markerIndex ++;
			}
		}
		
	}
	
	public void reset() {
		for (int x = 0;  x < markers.length; x++) {
			for (int y = 0; y < markers.length; y++) {
				markers[x][y] = null;
			}
		}
		
		for(Placement placement : placements) {
			placement.set(false);
		}
		
		gameEnd = false;
		winType = -1;
		markerIndex = 0;
	}
	

}




