import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class NewWindow{
NewWindow (){
	
	
	
	JFrame frame=new JFrame();
	MyPanel panel =panel= new MyPanel();
	frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("calculator crusador");
		frame.setResizable(false);
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	

}}
