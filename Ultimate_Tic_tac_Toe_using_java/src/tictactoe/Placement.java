package tictactoe;

import java.awt.Color;
import java.awt.Graphics2D;

public class Placement implements IGameObject{
	
	private Color hoverColor = new Color(0xa0a0a0);
	private boolean fadeIn = false;
	private boolean markerPlaced = false;
	private float alpha = 0f;
	private float fadespeed = 0.1f; 
	
	private int x;
	private int y;
	private int xIndex;
	private int yIndex;
	private int width;
	private int height;
	
	public Placement(int x, int y, int xIndex, int yIndex, int width, int height) {
		this.x = x;
		this.y = y;
		this.xIndex = xIndex;
		this.yIndex = yIndex;
		this.width = width;
		this.height=height;
	}


	@Override
	public void update(float deltatime) {
		
		if(fadeIn && alpha!=1) {
			alpha +=fadespeed;
			if(alpha>1) {
				alpha=1;
			}
		}
		else if(!fadeIn && alpha!=0){
			alpha -= fadespeed;
			if(alpha < 0) {
				alpha = 0;
			}
			
		}
		
	}

	@Override
	public void render(Graphics2D graphicsRender) {
		graphicsRender.setColor(new Color(hoverColor.getRed(),
				hoverColor.getGreen(),
				hoverColor.getBlue(),
				(int)(alpha * 225)
				));
		
		graphicsRender.fillRect(x, y, width, height);
		
		graphicsRender.setColor(Color.white);
	}
	
	public void checkCollision(int x, int y) {
		
//		check if 'x' or 'o' is placed
		if(markerPlaced) {
			return;
		}
		
		if(x>this.x && x<this.x + width && y>this.y && y<this.y + height) {
			fadeIn = true;
		}
		else {
			fadeIn = false;
		}
	}
	
	public int getxIndex() {
		return xIndex;
	}

	public int getyIndex() {
		return yIndex;
	}

	public boolean isActive() {
		return fadeIn;
	}
	
	public void set(boolean isSet) {
		markerPlaced = isSet;
		
		if(isSet) {
			fadeIn = false;
		}
	}
	

}
