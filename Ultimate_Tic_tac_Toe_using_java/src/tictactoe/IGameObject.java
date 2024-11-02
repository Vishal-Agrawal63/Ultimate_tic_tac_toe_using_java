package tictactoe;

import java.awt.Graphics2D;

public interface IGameObject {
	
	void update(float deltatime);
	void render(Graphics2D graphicsRender);

}
