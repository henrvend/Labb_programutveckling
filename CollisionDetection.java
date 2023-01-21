import java.util.ArrayList;

public class CollisionDetection {

		

	public CollisionDetection() {
		
	}
	public void collisionDetectionPB(Player player, Ball ball) {
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
	}
	public void collisionBlocks(ArrayList<RedBox> redBlocks, Ball ball, Keyboard keyboard, int points, int bg) {
		
				
	}
}
