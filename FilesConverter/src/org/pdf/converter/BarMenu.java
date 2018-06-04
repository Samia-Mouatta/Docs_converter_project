package org.pdf.converter;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;

public class BarMenu {
	
	String aboutImg = "FilesConverter/Resources/images/about.png";
	String optionsImg = "FilesConverter/Resources/images/options.png";
	String helpImg = "FilesConverter/Resources/images/help.png";
	String exitImg = "FilesConverter/Resources/images/exit.png";
	JMenu about,option,help,exit;
	JMenuBar menuBar;
	
	public BarMenu(){
		
	}
	
	public JMenuBar jmenuBar() {
			
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
			return menuBar;			
			
	}
	public void createImage(JMenu menu,String imageURL) {
		
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        menu.setVerticalTextPosition(SwingConstants.BOTTOM);
        menu.setIcon(new ImageIcon(imageURL));
        menuBar.add(menu);
        
	}

}
