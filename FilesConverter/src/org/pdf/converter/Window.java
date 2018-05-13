package org.pdf.converter;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class Window extends JFrame{
	
	public Window() throws MalformedURLException, IOException{
		
        JMenuBar menuBar = new JMenuBar();

        String imageURL = "http://blogs.discovermagazine.com/" +
            "drone360/wp-content/themes/discoverblog/images/" +
            "gear_icon.png";
        

        // Create a menu
        JMenu menu = new JMenu("About");
        BufferedImage image = ImageIO.read(new URL(imageURL));
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        menu.setVerticalTextPosition(SwingConstants.BOTTOM);
        menu.setIcon(new ImageIcon(image));
        menuBar.add(menu);

		setTitle("Files Converter");
		setJMenuBar(menuBar);
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
