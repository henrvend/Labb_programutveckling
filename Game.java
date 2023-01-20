import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

import javax.swing.JFrame;

public class Game {
	
	public static boolean gameOn;
	public static boolean gameWin;
	private Player player;
	private Ball ball;
	private ArrayList<RedBox> redBlocks;
	private ArrayList<BlueBox> blueBlocks;
	private ArrayList<GreenBox> greenBlocks;

	private int tickCount=0;
	private int points;
	public int pointsMax;
	public Game(GameBoard board) {
		
		points=100;
		
		ball = new Ball(380, 300, Const.BALLSIZE, Const.BALLSIZE);
		player = new Player(350, 500, Const.PLAYER_WIDTH, Const.PLAYER_HEIGHT, Color.orange);
		gameOn=true;
		gameWin = false;
		redBlocks = new ArrayList<RedBox>();
		blueBlocks = new ArrayList<BlueBox>();
		greenBlocks = new ArrayList<GreenBox>();
		
		for(int i=0; i<Const.CUBES; i++) {
				redBlocks.add(new RedBox(i*70+50, 40, 60, 30));
				blueBlocks.add(new BlueBox(i*70+50, 80, 60, 30));
				greenBlocks.add(new GreenBox(i*70+50, 120, 60, 30));
		}
	}

	public void update(Keyboard keyboard) {
		player.update(keyboard);
		ball.update(keyboard);
		if(points>pointsMax) {
			pointsMax=points;		
		}
		
		if(ball.isCollidingPlayer(player)) {
			ball.setDirectionY(Const.BALL_DIRECTION);
		}
		
		for(int i=redBlocks.size()-1; i>0; i--) {
			redBlocks.get(i).update(keyboard);
			if(ball.isCollidingRed(redBlocks.get(i))) {
				ball.setDirectionY(Const.BALL_DIRECTION);
				redBlocks.remove(redBlocks.get(i));
				}
			}
		for(int i=blueBlocks.size()-1; i>0; i--) {
			blueBlocks.get(i).update(keyboard);
			if(ball.isCollidingBlue(blueBlocks.get(i))) {
				ball.setDirectionY(Const.BALL_DIRECTION);
				redBlocks.remove(redBlocks.get(i));
				}
			}
		
		for(int i=greenBlocks.size()-1; i>0; i--) {
			greenBlocks.get(i).update(keyboard);
			if(ball.isCollidingGreen(greenBlocks.get(i))) {
				ball.setDirectionY(Const.BALL_DIRECTION*-1);
				System.out.println("test");
				greenBlocks.remove(greenBlocks.get(i));
			}
		}
		
	/*	for(GreenBox cubes: greenBlocks) {
			cubes.update(keyboard);
			if(ball.isCollidingGreen(cubes)) {
				
				
			}
		}*/
		if(points<0) {
			System.out.println("GameOver!");
			gameOn=false;
		}
		if(points>200) {
			gameWin=true;
		}
		tickCount++;
	}
	
	public void draw(Graphics2D graphics) {
		Images i = new Images();
		player.draw(graphics);
		ball.draw(graphics);
		
		for(RedBox cubes: redBlocks) {
		cubes.draw(graphics);
		}
		for(GreenBox cubes: greenBlocks) {
			cubes.draw(graphics);
		}
		for(BlueBox cubes: blueBlocks) {
			cubes.draw(graphics);
		}
		if(!gameOn) {
			System.out.println(pointsMax);
			i.gameOverScreen(graphics, pointsMax);
			
		}
		if(gameWin) {
			i.epicWinScreen(graphics);
			
		}
	}
}
