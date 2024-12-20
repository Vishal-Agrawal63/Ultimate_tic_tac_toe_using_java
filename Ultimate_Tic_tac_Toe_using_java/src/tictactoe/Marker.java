package tictactoe;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Marker implements IGameObject{
	
	private BufferedImage marker;
	
	private int x;
	private int y;
	private int startX;
	private int startY;
	private int size;
	private int type;
	
	private boolean won = false;
	private float alpha = 1;
	private float fadeSpeed = 0.05f;
	
	public Marker(int x, int y,int startX, int startY,int size, int type) {
		this.x = x;
		this.y= y;
		this.startX= startX;
		this.startY = startY;
		this.size = size;
		
		this.type = type % 2; // so only 0 and 1
		String markerType = this.type == 0 ? "x" : "o";
		
		try {
			marker= ImageIO.read(new File("assets/" + markerType + ".png"));
			
		} catch (Exception e) { 

			e.printStackTrace();
		}
	}
	
	public Marker(int type) {
		this.type = type % 2;
	}

	@Override
	public void update(float deltatime) {
		if(won) {
			alpha += fadeSpeed;
			if(alpha>=1) {
				alpha = 1;
				fadeSpeed *= -1;
				
				return;
			}else if(alpha <= 0.5f) {
				alpha = 0.5f;
				fadeSpeed *= -1;
				
				return;
			}
		}
	}

	@Override
	public void render(Graphics2D graphicsRender) {
		
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		graphicsRender.setComposite(ac);
		
		int size = this.size / Main.ROWS;
		graphicsRender.drawImage(marker,startX + x*size,startY + y*size,size,size,null);
		
		 ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
		graphicsRender.setComposite(ac);
	}

	public int getType() {
		
		
		
		return type;
	}
	
	
	public void setWon(boolean won) {
		this.won = won;
	}
}
