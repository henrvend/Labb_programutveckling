import java.awt.Graphics2D;
import java.awt.Color;

public class ColoredBox extends Sprite{

	private Color color;
	public ColoredBox(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.color=color;
	
	}
	@Override
	public void update(Keyboard keyboard) {
		setY(getY()+2);
		
	}
	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}
	
	

}
