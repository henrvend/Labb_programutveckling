import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends Sprite{
	
	private Color color;
	public Player(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color=color;
	}
	


	@Override 
	public void update(Keyboard keyboard) {
		
		if(getX()>5) {
			if(keyboard.isKeyDown(Key.Left)) {
				setX(getX()-4);
			}
		}
			if(getX()<695) {
			if(keyboard.isKeyDown(Key.Right)) {
				setX(getX()+10);
			}
		}
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}

}
