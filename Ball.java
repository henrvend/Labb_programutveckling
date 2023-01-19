import java.awt.Color;
import java.awt.Graphics2D;

public class Ball extends Sprite{

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Keyboard keyboard) {
		
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.cyan);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
		
	}

}
