import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Extras extends Rectangle{

	
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int player=3;
	int your_score=0;
	int final_score=0;
	int new_high_score=0;
	String message="Gameover";
	
	
	Extras(int GAME_WIDTH, int GAME_HEIGHT){
		Extras.GAME_WIDTH = GAME_WIDTH;
		Extras.GAME_HEIGHT = GAME_HEIGHT;
	
	}
	//borders and display message
	public void draw(Graphics g) {
		//colour of messages
		g.setColor(Color.white);
		//lives message
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.drawString(String.valueOf(player),8,25);
		//game over message
		g.setFont(new Font("TimesRoman", Font.PLAIN, 17));
		g.drawString("Highest Score:"+String.valueOf(final_score),205,293);
		//your score
		g.setFont(new Font("TimesRoman", Font.PLAIN, 17));
		g.drawString("Your Score:"+String.valueOf(your_score),8,293);
		//color of left and right border
		g.setColor(Color.black);
		//left border
		g.drawLine(1, 0, 1, GAME_HEIGHT);
		//right border
		g.drawLine(GAME_WIDTH-1, 0, GAME_WIDTH-1, GAME_HEIGHT);
		//bottom border
		g.setColor(Color.red);
		g.drawLine(0, GAME_HEIGHT-1, GAME_WIDTH, GAME_HEIGHT-1);
		
		//top border
		g.setColor(Color.BLACK);
		g.drawLine(0, 2, GAME_WIDTH, 2);
	
	
	}
	//gameover message
	public void message(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
			g.drawString("gameover", 40, 150);
			
		
	}
	//new highscore message
	public void highscoremessage(Graphics g) {
		g.setColor(Color.green);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString(" you set new high score: "+String.valueOf(new_high_score),60,190);
			
		
	}
	}
