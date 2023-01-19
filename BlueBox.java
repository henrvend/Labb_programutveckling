import java.awt.Color;
import java.awt.Graphics2D;

public class BlueBox extends ColoredBox{

	public BlueBox(int x, int y, int width, int height) {
		super(x, y, width, height, Color.blue);
		
	}

	@Override
	public void update(Keyboard keyboard) {
		setY(getY()+1);
		
	}
	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.blue);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}

}
