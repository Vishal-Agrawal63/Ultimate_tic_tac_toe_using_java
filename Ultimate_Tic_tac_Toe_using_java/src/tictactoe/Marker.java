package tictactoe;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Marker implements IGameObject{
	
	private BufferedImage marker;
	
	private int x;
	private int y;
	private int type;
	
	public Marker(int x, int y, int type) {
		this.x = x;
		this.y= y;
		
		this.type = type % 2; // so only 0 and 1
		String markerType = this.type == 0 ? "x" : "o";
		
		try {
			marker= ImageIO.read(new File("assets/" + markerType + ".png"));
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void update(float deltatime) {
		
	}

	@Override
	public void render(Graphics2D graphicsRender) {
		
		int size = Main.WIDTH / Main.ROWS;
		graphicsRender.drawImage(marker,x*size,y*size,size,size,null);
	}
	
}
