import java.awt.*;

import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class MyPanel extends JPanel implements Runnable{

	static final int GAME_WIDTH = 340;
	static final int GAME_HEIGHT = 300;
	static final int BALL_DIAMETER = 20;
	static final int AVATAR_WIDTH = 25;
	static final int AVATAR_HEIGHT = 2;
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Avatar avatar;
	
	Ball ball;
	Extras extra;
	String message="gameover";
	//
	JButton button=new JButton();
	//score
	int temp;
	int a;
	int b;
	
	

	
	MyPanel(){
		newAvatar();
		newBall();
		//
		button.setBounds(50, 50, 50, 50);
		this.setPreferredSize(new Dimension (GAME_WIDTH,GAME_HEIGHT));
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.add(button);
		//
		extra = new Extras(GAME_WIDTH,GAME_HEIGHT);
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	//
	public void newAvatar() {
		avatar = new Avatar((GAME_WIDTH/2),(GAME_HEIGHT-28)-(AVATAR_HEIGHT/2),AVATAR_WIDTH,AVATAR_HEIGHT);
		
	}
	
	//
	
	public void newBall() {
		random = new Random();
		ball = new Ball(random.nextInt(340),29,10,10);
	}
	//
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	//
	public void draw(Graphics g) {
		
		avatar.draw(g);
		ball.draw(g);
		extra.draw(g);
		
		//message 
		if(extra.player<=0) {
			extra.message(g);
			//damn
			
			if(extra.your_score>extra.final_score) {
			temp=extra.your_score;
			extra.your_score=a;
			a=temp;
			extra.new_high_score=a;
			b=a-extra.your_score;
			}
		//
			if(a>extra.final_score) {
				extra.highscoremessage(g);
			}
			
		
		//reset score
			if(extra.player<0) {
				extra.player=3;
				newBall();
		//
				if(a>extra.final_score) {
				extra.final_score=extra.final_score+b;

				;}
		//
				extra.your_score=0;
					
			}
			
		}
		//helps with the animation
		
Toolkit.getDefaultToolkit().sync(); 

	}
	
	//
	public void move() {
		avatar.move();
		ball.move();
	}
	//
	
	//
	
	public void checkCollision() {
		
		//bounce ball off top
		if(ball.y <=0) {
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(-ball.yVelocity);
			
			
			
		}
		//bounce ball off bottom
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			extra.player--;
			newBall();
		}
		//bounce ball off left 
		if(ball.x <=0) {
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		//bounce ball off right
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
			
		}
		//

		
		
		//bouncing ball off the avatar
		
		if(ball.intersects(avatar)) {
			ball.yVelocity = Math.abs(ball.yVelocity);
			
			
			
			ball.setXDirection(ball.xVelocity);
			
			
			
		}
		//
		if(ball.intersects(avatar)) {
			ball.yVelocity = Math.abs(ball.yVelocity);
			//To stop counting after gameover
			if(extra.player>=1) {
				extra.your_score++;
			}
	ball.setYDirection(-ball.yVelocity);
			
		}
		
	
		
			//stops avatar at window edges
		
			if(avatar.x<=1)
					avatar.x=1;
			//
				if(avatar.x >= (GAME_WIDTH-1-AVATAR_WIDTH))
					avatar.x = GAME_WIDTH-1-AVATAR_WIDTH;
				
				
	}
	//
	
	
	////game loop
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				checkCollision();
				
				repaint();
				delta--;
			}
		}
		
	}
	//class for keyboard
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			avatar.keyPressed(e);
			
		}
		public void keyReleased(KeyEvent e) {
			avatar.keyReleased(e);
		
		}
		
	}
}


