import java.math.*;
import java.util.*;
import java.lang.Math;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;	 
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip; 
import java.io.*;
import javax.imageio.*;

public class GameFrame extends JFrame implements ActionListener
{
	int player1Score;
	int player1Total; 
	int player1Bunco; 

	int player2Score; 
	int player2Total;
	int player2Bunco; 

	int player3Score; 
	int player3Total; 
	int player3Bunco; 

	int player4Score; 
	int player4Total; 
	int player4Bunco; 
 
	int dice1; 
	int dice2;
	int dice3;
	int players = 1 ; 
	int rolls = 0 ; 
	int rounds = 1 ;
	final int NUMBERTURN = 15;  
	String pl1Score; 
	String pl2Score; 
	String pl3Score;
	String pl4Score; 
	String pl1Bunco;
	String pl2Bunco;
	String pl3Bunco; 
	String pl4Bunco;
	String pl1Total;
	String pl2Total; 
	String pl3Total;
	String pl4Total; 
	public int ran1 = 0 ; 
	public int ran2 = 0 ; 
	public int ran3 = 0 ;
	JLabel player1 = new JLabel("You") ; 
	JLabel player2 = new JLabel("Mordakai"); 
	JLabel player3 = new JLabel("Lee"); 
	JLabel player4 = new JLabel("Myra"); 
	final int WID = 800 ; 
	final int HEI = 520 ;
	Icon bg = new ImageIcon(getClass().getResource("Table.png"));
	Icon die1 = new ImageIcon(getClass().getResource("one.png")); 
	Icon die2 = new ImageIcon(getClass().getResource("two.png"));
	Icon die3 = new ImageIcon(getClass().getResource("three.png"));
	Icon die4 = new ImageIcon(getClass().getResource("four.png"));
	Icon die5 = new ImageIcon(getClass().getResource("five.png"));
	Icon die6 = new ImageIcon(getClass().getResource("six.png"));
	JPanel panel = new JPanel(new BorderLayout());
	JPanel panel1 = new JPanel(new GridLayout(3,1));
	JPanel panel2 = new JPanel(new GridLayout(3,1)); 
	JPanel panel3 = new JPanel(new GridLayout(2,1)); 
	JPanel panel4 = new JPanel(new FlowLayout()); 
	JPanel panel5 = new JPanel(new GridLayout(3,1));
	JPanel panel6 = new JPanel(); 
	JPanel panel7 = new JPanel(); 
	JPanel panel8 = new JPanel(); 
	JLabel lab = new JLabel(" ");  
	JLabel lab2 = new JLabel(); 
	
	JLabel score = new JLabel("Your Score"); 
	JLabel bunco = new JLabel("Buncos"); 

	JLabel lab9 = new JLabel(" "); 
	JLabel lab10 = new JLabel(" "); 
  
	JLabel block3 = new JLabel(die3); 
	JLabel block2 = new JLabel(die2); 
	JLabel lab18 = new JLabel("18"); 
	JLabel block1 = new JLabel(die1); 
	JMenuBar mainBar = new JMenuBar();
	JMenu menu1 = new JMenu("File");
	JMenuItem exit = new JMenuItem("Close"); 
	JMenuItem instr = new JMenuItem("Instructions");  
	JButton play = new JButton("ROLL!");
	boolean back = true ; 

	public GameFrame() 
	{
		super("Bunco"); 
		setSize(WID,HEI) ; 
		setVisible(true) ; 
		setContentPane(new JLabel(bg));
		setLayout(new BorderLayout()); 
		setJMenuBar(mainBar); 
		mainBar.add(menu1); 
		menu1.add(instr); 
		menu1.add(exit); 
		add(panel); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new BorderLayout()); 
		panel.add(panel1, BorderLayout.WEST); 
		panel.add(panel2, BorderLayout.EAST);
		panel.add(panel3, BorderLayout.NORTH);
		panel.add(panel4, BorderLayout.SOUTH);
		panel.add(panel5, BorderLayout.CENTER); 
		panel.setOpaque(false); 
		panel1.setOpaque(false);
		panel2.setOpaque(false); 
		panel3.setOpaque(false); 
		panel4.setOpaque(false); 
		panel5.setOpaque(false); 
		panel1.add(lab);
		lab.setHorizontalAlignment(lab.CENTER); 
		
		panel1.add(player4); 
		player4.setHorizontalAlignment(player4.CENTER); 
		
		panel1.add(lab9); 
		lab9.setHorizontalAlignment(lab9.CENTER); 
		panel2.add(lab2); 
		lab2.setHorizontalAlignment(lab2.CENTER); 
		panel2.add(player3);
		player3.setHorizontalAlignment(player3.CENTER); 
		panel2.add(lab10); 
		lab10.setHorizontalAlignment(lab10.CENTER); 
		panel3.add(score);
		score.setHorizontalAlignment(score.CENTER); 
		panel3.add(bunco); 
		bunco.setHorizontalAlignment(bunco.CENTER); 
		panel4.add(play); 
		play.addActionListener(this);
		panel5.add(player2); 
		player2.setHorizontalAlignment(player2.CENTER); 
		
		//THIS IS FOR THE DICES!!
		panel5.add(panel6); 
		lab18.setHorizontalAlignment(lab18.CENTER); 
		panel6.setOpaque(false);
		panel6.add(block1); 
		panel6.add(block2); 
		panel6.add(block3);
		panel5.add(player1); 
		player1.setHorizontalAlignment(player1.CENTER); 
		exit.addActionListener(this); 
		instr.addActionListener(this); 
		repaint();
		revalidate();
		try
		{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(GameFrame.class.getResource("Casino.wav"));
			Clip clip = AudioSystem.getClip(); 
			clip.open(audioIn); 
			clip.start(); 
			clip.loop(10);
		}
		catch(Exception a)
		{
			System.out.println(a.getStackTrace()); 
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();

		if(source == play)
		{
			if(rolls < NUMBERTURN)
			{
				playersTurns(players); 
				rolls += 1; 
			 }
			else 
			{
				winner(); 
			}
		}
	    if(source == exit)
		{
			System.exit(0); 
		}
		else if(source == instr)
		{
			First ins = new First(); 
			ins.setVisible(true); 
		}
	}
	public int roll()
	{
		this.ran1 = (int)(Math.random()* 10000) % 6 + 1;  
		return ran1;
		
	}
	public int roll2()
	{ 
		this.ran2 = (int)(Math.random()* 10000) % 6 + 1;
		return ran2;
	
	}
	public int roll3()
	{

		this.ran3 = (int)(Math.random()* 10000) % 6 + 1;
		return ran3 ;
	}
	public void setIcons()
	{
		if(dice1 == 1)
		{
			block1.setIcon(die1);
		}
		else if(dice1 == 2)
		{
			block1.setIcon(die2);
		}
		else if(dice1 == 3)
		{
			block1.setIcon(die3);
		}
		else if(dice1 == 4)
		{
			block1.setIcon(die4);
		}
		else if(dice1 == 5)
		{
			block1.setIcon(die5);
		}
		else if(dice1 == 6)
		{
			block1.setIcon(die6);
		}
		else if(dice2 == 1)
		{
			block2.setIcon(die1); 
	
		}
		if(dice2 == 2)
		{
			block2.setIcon(die2); 
		}
		else if(dice2 == 3)
		{
			block2.setIcon(die3); 
		}
		else if(dice2 == 4)
		{
			block2.setIcon(die4); 
		}
		else if(dice2 == 5)
		{
			block2.setIcon(die5); 
		}
		else if(dice2 == 6)
		{
			block2.setIcon(die6); 
		}
		if(dice3 == 1)
		{
			block3.setIcon(die1);
		}
		else if(dice3 == 2)
		{
			block3.setIcon(die2);
		}
		else if(dice3 == 3)
		{
			block3.setIcon(die3);
		}
		else if(dice3 == 4)
		{
			block3.setIcon(die4);
		}
		else if(dice3 == 5)
		{
			block3.setIcon(die5);
		}
		else if(dice3 == 6)
		{
			block3.setIcon(die6);
		}	
	}
	public void playersTurns(int player)
		{
			if(player < 5)
				{		
					dice1 = roll(); 
					dice2 = roll2();
					dice3 = roll3();
					setIcons();
					if(dice1 == rounds && dice2 == rounds && dice3 == rounds)//Bunco
					{
						if(player == 1)
						{
							player1Score += 20; 
							
							JOptionPane.showMessageDialog(null, "Congrats you rolled all 1's");
						}
						else if(player == 2)
						{
							player2Score += 20; 
			
							JOptionPane.showMessageDialog(null, "Congrats you rolled all 1's");
						}
						else if(player == 3)
						{
							player3Score += 20; 
							
							JOptionPane.showMessageDialog(null, "Congrats you rolled all 1's");
						}
						else if(player == 4)
						{
							player4Score += 20; 
							
							JOptionPane.showMessageDialog(null, "Congrats you rolled all 1's");
						}
						playersTurns(player);
					}// end of bunco statement.
					else 
					{
						if(dice1 == rounds || dice2 == rounds || dice3 == rounds)
						{
							if(player == 1)
							{
								player1Score += 1 ; 
							
								pl1Score = Integer.toString(player1Score); 
								pl1Bunco = Integer.toString(player1Bunco);
								score.setText(pl1Score);
								bunco.setText(pl1Bunco); 
							}
							else if(player == 2)
							{
								player2Score += 1; 
								
							}
							else if(player == 3)
							{
								player3Score += 1; 
								
								pl1Score = Integer.toString(player1Score); 
								pl1Bunco = Integer.toString(player1Bunco);
								score.setText(pl1Score);
								bunco.setText(pl1Bunco); 
							}
							else if(player == 4)
							{
								player4Score += 1; 
								
							}//end of which player to add a point too
							playersTurns(player);// starts it over again. 
							
						}else
						{
							repaint(); 
							revalidate();
							JOptionPane.showMessageDialog(null, "Player " +player+ " is over."); 
							player += 1; 
							playersTurns(player);
						}//Tell that the player round is over and display the amount. 
						
					}//end of else statement.
				}//end of first IF statement.
	}//end of PlayersTurn Meth. 
	public void winner()
		{
			if(player1Score > player2Score && player1Score > player3Score && player1Score > player4Score)
			{
				JOptionPane.showMessageDialog(null,"Then winner is Player 1 with " + player1Score+
				"\n Player 2 Score "+ player2Score +
				"\n Player 3 Score "+ player3Score +
				"\n Player 4 Score "+ player4Score);
				
			}
			else if(player2Score > player1Score && player2Score > player3Score && player2Score > player4Score)
			{
				JOptionPane.showMessageDialog(null, "The winner is Player 2 with " + player2Total +
				"\n Player 1 Score "+ player1Score +
				"\n Player 3 Score "+ player3Score +
				"\n Player 4 Score "+ player4Score);
			}
			else if(player3Score > player1Score && player3Score > player2Score && player3Score > player4Score)
			{
				JOptionPane.showMessageDialog(null, "The winner is Player 3 with "+ player3Total +
				"\n Player 2 Score "+ player2Score +
				"\n Player 1 Score "+ player1Score +
				"\n Player 4 Score "+ player4Score);
			}
			else if(player4Score > player1Score && player4Score > player2Score && player4Score > player3Score)
			{
				JOptionPane.showMessageDialog(null, "The winner is Player 4 with " + player4Score +
				"\n Player 2 Score "+ player2Score +
				"\n Player 3 Score "+ player3Score +
				"\n Player 1 Score "+ player1Score );
			}
			else
			{
				JOptionPane.showMessageDialog(null,"It is tie!" +
				"\n Player 1 Score "+ player1Score +
				"\n Player 2 Score "+ player2Score +
				"\n Player 3 Score "+ player3Score +
				"\n Player 4 Score "+ player4Score );
				
			}
		}


	public static void main(String[] args) 
	{
		GameFrame frame = new GameFrame();
		frame.setVisible(true); 
	}

}
