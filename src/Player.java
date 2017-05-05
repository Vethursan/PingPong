import java.awt.Color;
import java.awt.Graphics;

public class Player implements Paddle {
	
	final double FORCE = 0.94;
	double y;
	double ySpeed;
	boolean up;
	boolean down;
	int user;
	int x;
	
	public Player(int user){
		up = false;
		down = false;
		y = 210;
		ySpeed = 0;
		if (user == 1){
			x = 20;
		}
		else{
			x = 660;
		}
		
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 20, 80);
	
		
	}

	public void move() {
		if (up){
			ySpeed -= 2;
			
		}
		else if(down){
			ySpeed += 2;
		}
		else if (!up && !down){
			ySpeed *= FORCE;
		}
		
		if (ySpeed >= 5){
			ySpeed = 5;
		}
		
		else if (ySpeed <= -5){
			ySpeed = -5;
		}
		y = y + ySpeed;
		
		if (y < 0){
			y = 0;
		}
		
		if (y > 420){
			y = 420;
		}
	}

	public int getY() {
		// TODO Auto-generated method stub
		return (int)y;
	}
	
	public void setUp(boolean input){
		up = input;
	}
	public void setDown(boolean input){
		down = input;
	}

}
