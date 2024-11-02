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
	

}
