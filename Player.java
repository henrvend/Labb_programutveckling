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
		
		if(keyboard.isKeyDown(Key.Left)) {
			setX(getX()-4);
		}
		if(keyboard.isKeyDown(Key.Right)) {
			setX(getX()+4);
		}
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}



	public boolean isCollidingRed(RedBox cubes) {
		Rectangle playerBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
		Rectangle enemyBlock = new Rectangle(cubes.getX(), cubes.getY(), cubes.getWidth(), cubes.getHeight());
		return playerBox.intersects(enemyBlock);		
		
	}
	public boolean isCollidingGreen(GreenBox cubes) {
		Rectangle playerBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
		Rectangle enemyBlock = new Rectangle(cubes.getX(), cubes.getY(), cubes.getWidth(), cubes.getHeight());
		return playerBox.intersects(enemyBlock);		
		
	}
	public boolean isCollidingBlue(BlueBox cubes) {
		Rectangle playerBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
		Rectangle enemyBlock = new Rectangle(cubes.getX(), cubes.getY(), cubes.getWidth(), cubes.getHeight());
		return playerBox.intersects(enemyBlock);		
		
	}
}
