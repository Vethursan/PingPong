import java.awt.Color;
import java.awt.Graphics;

public class Computer implements Paddle {
	
	final double FORCE = 0.94;
	double y;
	double ySpeed;
	boolean up;
	boolean down;
	int user;
	int x;
	Ball watchBall;
	
	public Computer(int user, Ball b1){
		watchBall = b1;
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
		g.setColor(Color.black);
		g.fillRect(x, (int)y, 20, 80);
	
		
	}

	public void move() {
		y = watchBall.getY() -40;
		
		if (y < 0){
			y = 0;
		}
		
		if (y > 420){
			y = 420;
		}
	}

	public int getY() {
		return (int)y;
	}

}