package tictactoe;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.event.MouseInputListener;

public class GamePanel extends Panel implements MouseMotionListener, MouseInputListener{

	private Grid grid;
	
	public GamePanel(Color color) {
		super(color);
		
		grid = new Grid();
	}
	
	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		grid.update(deltaTime);
		
		
//		todo : update elements
	}
	
	@Override
	public void render() {
		super.render();
		
		grid.render(graphicsRender);
		
		super.clear();
	}
	
	
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println("Clicked");
		
		
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
//		System.out.println("moved!");
		
		grid.mouseMoved(e);
		
	}

	
	
	
	
	
}
