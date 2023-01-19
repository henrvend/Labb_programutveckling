import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends Sprite{

	private int directionX=Const.BALL_DIRECTION;
	private int directionY=Const.BALL_DIRECTION;
	//private Rectangle ballBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	
	@Override
	public void update(Keyboard keyboard) {
		
		if(getX()<0||getX()>800-Const.BALLSIZE) {
			directionX=-directionX;
		}
		if(getY()<0) {
			directionY=-directionY;
		}
		setX(getX()-directionX);
		setY(getY()-directionY*-1);
		
		
		if(getY()==600-Const.BALLSIZE) {
			Game.gameOn=false;
		}
		
		
	}

	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.cyan);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
		
	}
	
	
	public boolean isCollidingRed(RedBox cubes) {
		Rectangle ballBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
		Rectangle enemyBlock = new Rectangle(cubes.getX(), cubes.getY(), cubes.getWidth(), cubes.getHeight());
		return ballBox.intersects(enemyBlock);		
		
	}
	public boolean isCollidingGreen(GreenBox cubes) {
		Rectangle ballBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
		Rectangle enemyBlock = new Rectangle(cubes.getX(), cubes.getY(), cubes.getWidth(), cubes.getHeight());
		return ballBox.intersects(enemyBlock);		
		
	}
	public boolean isCollidingBlue(BlueBox cubes) {
		Rectangle ballBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
		Rectangle enemyBlock = new Rectangle(cubes.getX(), cubes.getY(), cubes.getWidth(), cubes.getHeight());
		return ballBox.intersects(enemyBlock);		
		
	}
	public boolean isCollidingPlayer(Player player) {
		Rectangle ballBox = new Rectangle(getX(), getY(), getWidth(), getHeight());
		Rectangle playerBlock = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
		return ballBox.intersects(playerBlock);
	
	}

}
