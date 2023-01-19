import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RedBox extends ColoredBox{
	
	public RedBox(int x, int y, int width, int height) {
		super(x, y, width, height, Color.red);
		
	}
	
	@Override
	public void update(Keyboard keyboard) {
		
		
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.red);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}
}
