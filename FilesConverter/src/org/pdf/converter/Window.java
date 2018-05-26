package org.pdf.converter;

import java.awt.FlowLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Window extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String aboutImg = "Resources/images/about.png";
	String optionsImg = "Resources/images/options.png";
	String helpImg = "Resources/images/help.png";
	String exitImg = "Resources/images/exit.png";
	
	JPanel panelCenter;
	JMenuBar menuBar;
   	JMenu about,option,help,exit;
   	JButton button1,button2;
	
	public Window() throws MalformedURLException, IOException{
		
        createBarMenu(about,help,exit);
        
        createPanel();
        
        //parameters
		setTitle("Files Converter");
		setSize(600,400);
		setVisible(true);
		setJMenuBar(menuBar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void createBarMenu(JMenu menu1,JMenu menu2,JMenu menu3) throws MalformedURLException, IOException{
	
		menuBar = new JMenuBar();
		
		about = new JMenu("About");
		createImage(about,aboutImg);
		menuBar.add(about);
		
		option = new JMenu("Options");
		createImage(option,optionsImg);
		menuBar.add(option);
		
		help = new JMenu("Help");
		createImage(help,helpImg);
		menuBar.add(help);
		
		
		exit = new JMenu("Exit");
		createImage(exit,exitImg);
		menuBar.add(exit);
		
	}
	
	// create image associated to the item menu
	public void createImage(JMenu menu,String imageURL) throws MalformedURLException, IOException{
		
        //BufferedImage image = ImageIO.read(new URL(imageURL));
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        menu.setVerticalTextPosition(SwingConstants.BOTTOM);
        menu.setIcon(new ImageIcon(imageURL));
        menuBar.add(menu);
        
	}
	
	//create panel
	public void createPanel(){
		
        button1 =  new JButton("PDF TO WORD");
        button2 =  new JButton("WORD TO PDF");
        panelCenter = new JPanel();
        add(panelCenter);
        panelCenter.setLayout(new FlowLayout());
        panelCenter.add(button1);
        panelCenter.add(button2);
	}

}
