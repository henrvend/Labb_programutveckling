import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;



public class Images{
	
	private  Image gO, win;
		
	Images(){
		
		
	}
	

	public void gameOverScreen(Graphics2D graphics, int x) {
		gO = new ImageIcon("GameOver.png").getImage();
		String points = Integer.toString(x);
		graphics.drawImage(gO, 0, 0, null);
		graphics.setColor(Color.white);
		graphics.drawString("You got a whooping "+ points+ " points but you need more to win!", 250, 500);
	}
	
	public void epicWinScreen(Graphics2D graphics) {
		win = new ImageIcon("Win.png").getImage();
		
		graphics.drawImage(win, 0, 0, null);
		graphics.setColor(Color.white);
		graphics.drawString("You WIN!!", 500, 300);
		
	}

}
