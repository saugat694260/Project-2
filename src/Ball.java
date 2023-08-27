import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Ball extends Rectangle{
	Random random;
	double xVelocity;
	double yVelocity;
	double Speed=2.5;
	
	
	Ball(int x, int y, int width, int height){
		super(x,y,width,height);
		//
		//random direction
		random=new Random();
		
		//x
		double randomXDirection=random.nextInt(2);
		if(randomXDirection==0)
			randomXDirection--;
		setXDirection(randomXDirection*Speed);
		//y
		int randomYDirection=random.nextInt(2);
		if(randomYDirection==0)
			randomYDirection--;
		setYDirection(randomYDirection*Speed);
		}
	//direction
	//x direction
	public void setXDirection(double randomXDirection) {
		xVelocity=randomXDirection;
	}
	//y direction
	public void setYDirection(double randomYDirection) {
		yVelocity=randomYDirection;
	}
	
	//move the ball
	
	public void move() {
		
		x+=xVelocity;
		y+=yVelocity;
	}
	//draw the ball
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
		
	}

}
