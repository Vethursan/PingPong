import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/* Simple ping pong java applet */
public class PingPong extends Applet implements Runnable, KeyListener{
	
	// Set the dimensions for our canvas (screen)
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	Player player1;
	Ball b1;
	// If the user tries to resize the screen we keep it at the same dimensions 
	// (just to keep it simple and not resize the entire game)
	public void init(){
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		player1 = new Player(2);
		b1 = new Ball();
		thread = new Thread(this);
		thread.start();
	}
	
	// Set the applets paint method
	public void paint(Graphics g){
		// Create a box the size of the screen and set the color the red (background)
		g.setColor(Color.red);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//g.fillOval(5, 10, 300, 100);
		if (b1.getX() < -10 || b1.getX() > 710){
			g.setColor(Color.white);
			g.drawString("GAME OVER", 350, 250);
			
		}
		else{
		player1.draw(g);
		b1.draw(g);
		}

	}
	
	public void update(Graphics g){
		// Make sure we are always painting
		paint(g);
		
	}

	public void run() {
		while(true){
			player1.move();
			b1.move();
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			player1.setUp(true);
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			player1.setDown(true);
		}
		
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			player1.setUp(false);
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			player1.setDown(false);

		}
		
	}
		

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
