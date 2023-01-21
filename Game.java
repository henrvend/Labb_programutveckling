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

	private int tickCount;
	private int points;
	private int timePoints;
	public int pointsMax;
	private int blocksGenerated=30;
	public Game(GameBoard board) {
		timePoints 	= 100;
		points		= 100;
		tickCount	= 0;
		
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
		if(tickCount%100==0) {
			timePoints--;
		}
		
		if(ball.isCollidingPlayer(player)) {
			//check where ball lands on plattform and from that position gives or take away speed 
			if((ball.getX()>(player.getX()+(player.getWidth()/3)))&&(ball.getX()<(player.getX()+(player.getWidth()/3*2)))) {
				ball.setDirectionY(ball.getDirectionY()*ball.getDirection());
				if(ball.getDirectionX()>0) {
					ball.setDirectionX((ball.getDirectionX()-1));
				}else {
					ball.setDirectionX((ball.getDirectionX()+1));
				}
				System.out.println("Mitten");
			}else if(ball.getDirectionX()<0){
				ball.setDirectionY(ball.getDirectionY()*ball.getDirection());
				ball.setDirectionX(ball.getDirectionX()-1);
			}else {
				ball.setDirectionY(ball.getDirectionY()*ball.getDirection());
				ball.setDirectionX(ball.getDirectionX()+1);
			}
		}
		
		//blockcolision detection
		for(int i=redBlocks.size()-1; i>=0; i--) {
			redBlocks.get(i).update(keyboard);
			if(ball.isCollidingRed(redBlocks.get(i))) {
				ball.setDirectionY(ball.getDirectionY()*ball.getDirection());
				points+=2;
				System.out.println("points+2 : "+points); 
				redBlocks.remove(redBlocks.get(i));
				blocksGenerated--;
				
				}
			}
		for(int i=blueBlocks.size()-1; i>=0; i--) {
			blueBlocks.get(i).update(keyboard);
			if(ball.isCollidingBlue(blueBlocks.get(i))) {
				ball.setDirectionY(ball.getDirectionY()*ball.getDirection());
				points++;
				System.out.println("points+1 : "+points); 
				blueBlocks.remove(blueBlocks.get(i));
				blocksGenerated--;
				}
			}
		
		for(int i=greenBlocks.size()-1; i>=0; i--) {
			greenBlocks.get(i).update(keyboard);
			if(ball.isCollidingGreen(greenBlocks.get(i))) {
				ball.setDirectionY(ball.getDirectionY()*ball.getDirection());
				points++;
				System.out.println("points+1 : "+points); 
				greenBlocks.remove(greenBlocks.get(i));
				blocksGenerated--;
			}
		}
		
	
		if(points<0||timePoints<0) {
			System.out.println("GameOver!");
			gameOn=false;
		}
		if(blocksGenerated==0) {
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
			System.out.println(pointsMax+timePoints);
			i.gameOverScreen(graphics, (pointsMax+timePoints));
			FileHandler file = new FileHandler(pointsMax+timePoints);
			
			
		}
		if(gameWin) {
			i.epicWinScreen(graphics);
			
		}
	}
}
