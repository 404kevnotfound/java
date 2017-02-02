import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;	 
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip; 
import javax.swing.*;


public class First extends JFrame implements ActionListener
{
	final int WID = 400 ; 
	final int HEI = 300 ;
	Font f = new Font("serif", Font.PLAIN, 17);
	Icon bg = new ImageIcon(getClass().getResource("giphy.gif"));
	JLabel inst = new JLabel("You have 3 dice, You will keep rolling as"); 
	JLabel inst1 = new JLabel("long as you get a 1 in any of the dice.");
	JLabel inst2 = new JLabel("Getting a one will add 1 point to your score.");
	JLabel inst3 = new JLabel("No partners.Anytime you get a point. If you ");
	JLabel inst4 = new JLabel("ever roll all 1's , that's a bunco, you get 20");
	JLabel inst5 = new JLabel("points added to your total score. You will have");
	JLabel inst6 = new JLabel("15 turns.Then the game will end.");
	JLabel inst7 = new JLabel("The one with the most points wins!");
	JLabel inst8 = new JLabel("Good luck and have fun.");
	JLabel inst9 = new JLabel("                          ");
	JLabel inst10 = new JLabel("        ");
	JLabel inst11 = new JLabel("          ");
	JLabel inst12 = new JLabel("                      ");
	JLabel inst13 = new JLabel("                                                     ");
	JButton click = new JButton("Lets get started!");
	
	public First()
	{
		super("Introduction!"); 
		setSize(WID,HEI) ; 
		setVisible(true) ; 
		setContentPane(new JLabel(bg));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
		inst.setFont(f); 
		inst1.setFont(f); 
		inst2.setFont(f); 
		inst3.setFont(f); 
		inst4.setFont(f); 
		inst5.setFont(f); 
		inst6.setFont(f); 
		inst7.setFont(f); 
		inst8.setFont(f); 
		inst.setOpaque(true); 
		inst.setForeground(Color.BLACK); 
		inst.setBackground(new Color(255,255,255,120));  
		inst1.setOpaque(true);
		inst1.setBackground(new Color(255,255,255,120));
		inst1.setForeground(Color.BLACK);
		inst2.setOpaque(true);
		inst2.setBackground(new Color(255,255,255,120));
		inst2.setForeground(Color.BLACK);  
		inst3.setOpaque(true);
		inst3.setBackground(new Color(255,255,255,120));
		inst3.setForeground(Color.BLACK); 
		inst4.setOpaque(true);
		inst4.setBackground(new Color(255,255,255,120)); 
		inst4.setForeground(Color.BLACK);  
		inst5.setOpaque(true);
		inst5.setBackground(new Color(255,255,255,120));
		inst5.setForeground(Color.BLACK); 
		inst6.setOpaque(true);
		inst6.setBackground(new Color(255,255,255,120)); 
		inst6.setForeground(Color.BLACK);  
		inst7.setOpaque(true);
		inst7.setBackground(new Color(255,255,255,120));
		inst7.setForeground(Color.BLACK);  
		inst8.setOpaque(true);
		inst8.setBackground(new Color(255,255,255,120));
		inst8.setForeground(Color.BLACK);  
		click.setOpaque(true); 
		click.setBackground(new Color(255,255,255,120));
		click.setForeground(Color.BLACK); 
		add(inst); 
		add(inst1);
		add(inst2);
		add(inst3);
		add(inst4);
		add(inst5);
		add(inst6);
		add(inst7);
		add(inst8);
		add(inst9); 
		add(inst10);
		add(inst11);
		add(inst12);
		add(inst13);
		add(click);
		click.addActionListener(this);
		repaint();
		revalidate(); 
		
		try
		{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(First.class.getResource("Nyan.wav"));
			Clip clip = AudioSystem.getClip(); 
			clip.open(audioIn); 
			clip.start(); 

		}
		catch(Exception a)
		{
			System.out.println("Something whent wrong!");
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == click)
		{
			this.dispose();
		}
	}
	public static void main(String[] args) 
	{
		First frame = new First(); 
	}
}