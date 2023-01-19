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

	private int tickcount;
	private int points;
	public int pointsMax;
	public Game(GameBoard board) {
		
		points=100;
		
		ball = new Ball(380, 300, 20, 20);
		player = new Player(350, 500, 100, 20, Color.orange);
		gameOn=true;
		gameWin = false;
		redBlocks = new ArrayList<RedBox>();
		blueBlocks = new ArrayList<BlueBox>();
		greenBlocks = new ArrayList<GreenBox>();
		
		
	}

	public void update(Keyboard keyboard) {
		player.update(keyboard);
		ball.update(keyboard);
		if(points>pointsMax) {
					pointsMax=points;
				}
	
		for(RedBox cubes : redBlocks) {
			cubes.update(keyboard);
			if(player.isCollidingRed(cubes)) {
				System.out.println("Points-2: " + (points-=2));
				}
			}
		for(GreenBox cubes: greenBlocks) {
			cubes.update(keyboard);
			if(player.isCollidingGreen(cubes)) {
				System.out.println("Points+1: " +points++);
			}
		}
		for(BlueBox cubes: blueBlocks) {
			cubes.update(keyboard);
			if(player.isCollidingBlue(cubes)) {
				System.out.println("Points+-1: " +points--);
			}
		}
		
		
		if(tickcount%100==0) {
			points+=5;
		}
		
		if(tickcount%100==0) {
			for(int i=0; i<Const.CUBES; i++) {
				redBlocks.add(new RedBox(i*75, 20, 20, 20));
				blueBlocks.add(new BlueBox(i*85, 20, 15, 15));
				greenBlocks.add(new GreenBox(i*95, 20, 10, 10));
			}
		}
		
		if(points<0) {
			System.out.println("GameOver!");
			gameOn=false;
		}
		if(points>200) {
			gameWin=true;
		}
		tickcount++;
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
