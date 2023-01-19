import java.awt.Color;
import java.awt.Graphics2D;

public class GreenBox extends ColoredBox{

	public GreenBox(int x, int y, int width, int height) {
		super(x, y, width, height, Color.green);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Keyboard keyboard) {
		
		
	}
	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.green);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}

	
}
