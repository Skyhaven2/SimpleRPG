package SimpleRPG.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.Timer;
import javax.swing.text.html.ImageView;

import SimpleRPG.controller.SimpleRPGController;

public class SimpleRPGStartPanel extends JPanel
{
	private SimpleRPGController baseController;
	private SpringLayout startLayout;
	private JLabel userCharacter;
	private ImageIcon userCharacterDown = new ImageIcon(SimpleRPGStartPanel.class.getResource("/SimpleRPG/view/images/rpg_character_down.png"));
	private ImageIcon userCharacterDownTwo = new ImageIcon(SimpleRPGStartPanel.class.getResource("/SimpleRPG/view/images/rpg_character_down_two.png"));
	private ImageIcon userCharacterUp = new ImageIcon(SimpleRPGStartPanel.class.getResource("/SimpleRPG/view/images/rpg_character_up.png"));
	private ImageIcon userCharacterUpTwo = new ImageIcon(SimpleRPGStartPanel.class.getResource("/SimpleRPG/view/images/rpg_character_up_two.png"));
	private ImageIcon userCharacterLeft = new ImageIcon(SimpleRPGStartPanel.class.getResource("/SimpleRPG/view/images/rpg_character_left.png"));
	private ImageIcon userCharacterLeftTwo = new ImageIcon(SimpleRPGStartPanel.class.getResource("/SimpleRPG/view/images/rpg_character_left_Two.png"));
	private ImageIcon userCharacterRight = new ImageIcon(SimpleRPGStartPanel.class.getResource("/SimpleRPG/view/images/rpg_character_right.png"));
	private ImageIcon userCharacterRightTwo = new ImageIcon(SimpleRPGStartPanel.class.getResource("/SimpleRPG/view/images/rpg_character_right_Two.png"));
	private Color darkGreen = new Color(50, 150, 30);
	private boolean wPressed = false;
	private boolean aPressed = false;
	private boolean sPressed = false;
	private boolean dPressed = false;
	private int frameCounter = 0;

	public SimpleRPGStartPanel(SimpleRPGController baseController)
	{
		this.baseController = baseController;

		startLayout = new SpringLayout();

		userCharacter = new JLabel(userCharacterDown);

		setupPane();
		setupPanel();
		setupLayout();
		setupListners();
	}

	private void setupPane()
	{
		userCharacter.setFocusable(true);
	}

	private void setupPanel()
	{
		this.setSize(1200, 900);
		this.setFocusable(true);
		this.setLayout(startLayout);
		this.setBackground(darkGreen);
		this.add(userCharacter);
	}

	private void setupLayout()
	{
		startLayout.putConstraint(SpringLayout.NORTH, userCharacter, 400, SpringLayout.NORTH, this);
		startLayout.putConstraint(SpringLayout.EAST, userCharacter, -500, SpringLayout.EAST, this);
	}

	private void setupListners()
	{
		this.addKeyListener(new KeyListener()
		{

			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyChar() == 'w')
				{
					wPressed = true;
				}
				else if (e.getKeyChar() == 'a')
				{
					aPressed = true;
				}
				else if (e.getKeyChar() == 's')
				{
					sPressed = true;
				}
				else if (e.getKeyChar() == 'd')
				{
					dPressed = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				if (e.getKeyChar() == 'w')
				{
					wPressed = false;
				}
				else if (e.getKeyChar() == 'a')
				{
					aPressed = false;
				}
				else if (e.getKeyChar() == 's')
				{
					sPressed = false;
				}
				else if (e.getKeyChar() == 'd')
				{
					dPressed = false;
				}
			}

			@Override
			public void keyTyped(KeyEvent e)
			{

			}

		});

		ActionListener update = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if ((wPressed) && (aPressed))
				{
					userCharacter.setLocation(userCharacter.getX() - 20, (userCharacter.getY() - 20));
					if(frameCounter <= 4)
					{
						userCharacter.setIcon(userCharacterUp);
					}
					else if(frameCounter > 4)
					{
						userCharacter.setIcon(userCharacterUpTwo);
					}
				}
				else if ((wPressed) && (dPressed))
				{
					userCharacter.setLocation(userCharacter.getX() + 20, (userCharacter.getY() - 20));
					if(frameCounter <= 4)
					{
						userCharacter.setIcon(userCharacterUp);
					}
					else if(frameCounter > 4)
					{
						userCharacter.setIcon(userCharacterUpTwo);
					}
				}
				else if ((sPressed) && (aPressed))
				{
					userCharacter.setLocation(userCharacter.getX() - 20, (userCharacter.getY() + 20));
					if(frameCounter <= 4)
					{
						userCharacter.setIcon(userCharacterDown);
					}
					else if(frameCounter > 4)
					{
						userCharacter.setIcon(userCharacterDownTwo);
					}
				}
				else if ((sPressed) && (dPressed))
				{
					userCharacter.setLocation(userCharacter.getX() + 20, (userCharacter.getY() + 20));
					if(frameCounter <= 4)
					{
						userCharacter.setIcon(userCharacterDown);
					}
					else if(frameCounter > 4)
					{
						userCharacter.setIcon(userCharacterDownTwo);
					}
				}
				else if (wPressed)
				{
					userCharacter.setLocation(userCharacter.getX(), (userCharacter.getY() - 20));
					if(frameCounter <= 4)
					{
						userCharacter.setIcon(userCharacterUp);
					}
					else if(frameCounter > 4)
					{
						userCharacter.setIcon(userCharacterUpTwo);
					}
					
				}
				else if (aPressed)
				{
					userCharacter.setLocation(userCharacter.getX() - 20, (userCharacter.getY()));
					if(frameCounter <= 4)
					{
						userCharacter.setIcon(userCharacterLeft);
					}
					else if(frameCounter > 4)
					{
						userCharacter.setIcon(userCharacterLeftTwo);
					}
					
				}
				else if (sPressed)
				{
					userCharacter.setLocation(userCharacter.getX(), (userCharacter.getY() + 20));
					if(frameCounter <= 4)
					{
						userCharacter.setIcon(userCharacterDown);
					}
					else if(frameCounter > 4)
					{
						userCharacter.setIcon(userCharacterDownTwo);
					}
				}
				else if (dPressed)
				{
					userCharacter.setLocation(userCharacter.getX() + 20, (userCharacter.getY()));
					if(frameCounter <= 4)
					{
						userCharacter.setIcon(userCharacterRight);
					}
					else if(frameCounter > 4)
					{
						userCharacter.setIcon(userCharacterRightTwo);
					}
				}
				
				frameCounter++;
				frameCounter = frameCounter % 10;
			}
		};
		
		Timer myTimer = new Timer(100, update);
		myTimer.setRepeats(true);
		myTimer.start();
	}
}
