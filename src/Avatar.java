import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Avatar extends Rectangle{

	int yVelocity;
	int xVelocity;
	int speed = 5;
	
	
	
	Avatar(int x, int y, int AVATAR_WIDTH, int AVATAR_HEIGHT){
		super(x,y,AVATAR_WIDTH,AVATAR_HEIGHT);
														}
	
	
	//keyboard movements
	//keypressed
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_A) {
			setXDirection(-speed);
			
		}
			if(e.getKeyCode()==KeyEvent.VK_A) {
				setXDirection(-speed);
				
			}
			if(e.getKeyCode()==KeyEvent.VK_D) {
				setXDirection(speed);
			}
			
			
			
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				setXDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				setXDirection(speed);
			}
			
		}
	//key released
	
	public void keyReleased(KeyEvent e) {
		
			
			if(e.getKeyCode()==KeyEvent.VK_A) {
				setXDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_D) {
				setXDirection(0);
			}
		
			
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				setXDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				setXDirection(0);
			}
			
		
	}
	
	//direction
	//y direction
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
		
	}
	//x direction
	public void setXDirection(int xDirection) {
		
		xVelocity=xDirection;
	}
	//move the avatar
	public void move() {
		y= y + yVelocity;
		x=x+xVelocity;
	}
	//draw avatar
	public void draw(Graphics g) {
		
			g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		
	}
}
//