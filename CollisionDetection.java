import java.util.ArrayList;

public class CollisionDetection {

	private int blocksGenerated=30;

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
	public void collisionBlocksRed(ArrayList<RedBox> redBlocks, Ball ball, Keyboard keyboard, int points) {
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
	}
	
	public void collisionBlocksBlue(ArrayList<BlueBox> blueBlocks, Ball ball, Keyboard keyboard, int points) {
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
	}
	public void collisionBlocksGreen(ArrayList<GreenBox> greenBlocks, Ball ball, Keyboard keyboard, int points) {
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
	}
	public int getBlocksGenerated() {
		return blocksGenerated;
	}
	public void setBlocksGenerated(int blocksGenerated) {
		this.blocksGenerated = blocksGenerated;
	}

}

