import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	double xSpeed;
	double ySpeed;
	double x;
	double y;
	
	public Ball(){
		x = 350;
		y = 250;
		xSpeed = 2	;
		ySpeed = 1;
	}
	
	public void collision(Paddle player1, Computer computer ){
	
		if (x >= 650){
			if(y >= player1.getY() && y <= player1.getY() + 80){
				xSpeed = -xSpeed;
				ySpeed = -ySpeed;
			}
		}
		else if (x <= 50){
			if(y >= computer.getY() && y <= computer.getY() + 80){
				xSpeed = -xSpeed;
				ySpeed = -ySpeed;
			}
		}
	}
	public void move(){
		x += xSpeed;
		y += ySpeed;
		
		if (y < 10 || y >490){
			ySpeed = -ySpeed;
		}
	}
	
	public int getX(){
		return (int) x;
	}
	
	public int getY(){
		return (int) y;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.blue);
		g.fillOval((int)x - 10, (int) y -10, 20, 20);
	}
}
