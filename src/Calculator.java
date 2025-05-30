import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.*;
import java.io.File;
import java.io.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.Timer;
public class Calculator implements ActionListener {
	
//
	JFrame frame=new JFrame();
	//
	JLabel label=new JLabel();
	
	//
	File file = new File("src/runaway.wav");
	AudioInputStream audioStream;
	Clip clip;
	//
	JTextField input1=new JTextField();
	JTextField input2=new JTextField();
	ImageIcon icon=icon=new ImageIcon("C:\\Users\\dell\\Desktop\\Screenshot_2020-07-28-10-43-47.png");
	//
	
	JButton colorButton=new JButton();
	//
	JButton musicButton=new JButton();
	//
	
	JButton[]button=new JButton[5];
	JButton button1=new JButton("+");
	JButton button2=new JButton("-");
	JButton button3=new JButton("X");
	JButton button4=new JButton("/");
	JButton button5=new JButton("c");
	//
	
	Random random=new Random();
	//
	Ball ball;
	
	
	
	
	int seconds=0;
	
	double num1=0,num2=0,result=0;
	
	Calculator() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		//music
		audioStream=AudioSystem.getAudioInputStream(file);
		 clip=AudioSystem.getClip();
		 clip.open(audioStream);
		
		//frame
		frame.setTitle("POCKET CALCULATOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(340,300);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setIconImage(icon.getImage());
		
		//message label
		label.setBounds(72,70,270,25);
		label.setHorizontalTextPosition(JLabel.CENTER);
		
		//colorchooser
		colorButton.setBounds(25,50,15,15);
		colorButton.addActionListener(this);
		colorButton.setFocusable(false);
		colorButton.setBackground(Color.white);
		//music
		musicButton.setBounds(50,53,10,10);
		musicButton.addActionListener(this);
		musicButton.setFocusable(false);
		 musicButton.setBackground(Color.red);
		
		
		//input
		input1.setBounds(25,100,270,25);
		input2.setBounds(25,150,270,25);
		//
		
		
		//buttons
		button[0]=button1;
		button[1]=button2;
		button[2]=button3;
		button[3]=button4;
		button[4]=button5;
		
		//
		button1.setBounds(25,200,50,25);
		button2.setBounds(80,200,50,25);
		button3.setBounds(135,200,50,25);
		button4.setBounds(190,200,50,25);
		button5.setBounds(245,200,50,25);
		
		//
		
		for(int i=0;i<5;i++) {
			button[i].addActionListener(this);		
			button[i].setFocusable(false)	;
			button[i].setFont(new Font("Ink Free",Font.BOLD,25));
			frame.add(button[i]);
			}
		
		//
		button1.setBackground(new Color(255, 219, 172));
		button2.setBackground(new Color(241, 194, 125));
		button3.setBackground(new Color(224, 172, 105));
		button4.setBackground(new Color(198, 134, 66));
		button5.setBackground(new Color(190, 100, 60));
		
		//
		frame.add(label);
		frame.add(colorButton);
		frame.add(musicButton);
		frame.add(input1);
		frame.add(input2);
		frame.setVisible(true);
		
	}
	//action listeners
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try{
			
			//button random color change
			
				int a=random.nextInt(5);
				int b=random.nextInt(5);
				int c=random.nextInt(5);
				int d=random.nextInt(5);
				int g=random.nextInt(5);
				//button1
				
				if(e.getSource()==button1) {
				
				button[a].setBackground(new Color(255, 219, 172));
				
				
	}
			
			//button2
			if(e.getSource()==button2) {
					
					button[b].setBackground(new Color(241, 194, 125));
					
		}
			
			//button3
			if(e.getSource()==button3) {
	
					button[c].setBackground(new Color(224, 172, 105));
	
	}
			
			//button4
			if(e.getSource()==button4) {
	
					button[d].setBackground(new Color(198, 134, 66));
					
	}
			
			//button5
			if(e.getSource()==button5) {
					button[g].setBackground(new Color(170, 85, 36));
	
	}
				

					
		//color chooser
			
		
			if(e.getSource()==colorButton) {
				JColorChooser backgroundColor=new JColorChooser();
				Color color=backgroundColor.showDialog(null, "choose a color for your calculator", new Color(255,235,238));
				frame.getContentPane().setBackground(color);
				
				
				}
			//music
			
			if(e.getSource()==musicButton) {
				
			            if(!clip.isRunning())
			            {
			                clip.start();
			                musicButton.setBackground(new Color(34, 187, 69));
			                clip.loop(clip.LOOP_CONTINUOUSLY);
			            }
			            else
			            {
			                clip.stop();
			                musicButton.setBackground(new Color(193,66,63));
			            }
		}
			
		//add
			if(e.getSource()==button1) {
			num1=Double.parseDouble(input1.getText());
			num2=Double.parseDouble(input2.getText());
			result=num1+num2;
			input1.setText(String.valueOf(result));
			num1=result;
			input2.setText("");
			
			
			
			}
			
		//subtract
		if(e.getSource()==button2) {
			num1=Double.parseDouble(input1.getText());
			num2=Double.parseDouble(input2.getText());
			result=num1-num2;
			input1.setText(String.valueOf(result));
			num1=result;
			input2.setText("");
			
			
		}
		
		//multiply
		if(e.getSource()==button3) {
			num1=Double.parseDouble(input1.getText());
			num2=Double.parseDouble(input2.getText());
			result=num1*num2;
			input1.setText(String.valueOf(result));
			num1=result;
			input2.setText("");
			
		}
		
		//divide
		if(e.getSource()==button4) {
			num1=Double.parseDouble(input1.getText());
			num2=Double.parseDouble(input2.getText());
			result=num1/num2;
			input1.setText(String.valueOf(result));
			num1=result;
			input2.setText("");
			
		}
		//secret code
		if(e.getSource()==button5) {
			String value=input1.getText();
			String code="START";
			
			
				if(value.equals(code)) {
					frame.dispose();
					NewWindow myWindow=new NewWindow();
					
					
				}
		
		//clear
		if(e.getSource()==button5) {
			input1.setText("");
			input2.setText("");
			
		
	}
			}
		
		//erroe message
	
		}
	catch(java.lang.NumberFormatException f){
		//error label
		label.setText("Please enter valid info!!!!");
		label.setForeground(new Color(35,43,43));
		label.setFont(new Font("Ink Free",Font.BOLD,13));
		input1.setText("");
		input2.setText("");
		//timer for error message
		
		Timer timer=new Timer(2000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(true) {
					label.setText("");}
				seconds++;}});
		timer.setRepeats(false);
		timer.start();
		
	}
		
	//
	finally {
		
		
					}
		
				}
			}
