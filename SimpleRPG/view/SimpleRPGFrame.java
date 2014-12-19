package SimpleRPG.view;

import javax.swing.JFrame;

import SimpleRPG.controller.SimpleRPGController;

public class SimpleRPGFrame extends JFrame
{
	private SimpleRPGStartPanel startPanel;
	
	public SimpleRPGFrame(SimpleRPGController baseController)
	{
		startPanel = new SimpleRPGStartPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(startPanel);
		this.setSize(1200, 900);
		this.setResizable(false);
		setVisible(true);
	}
}
