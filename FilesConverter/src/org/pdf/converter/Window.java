package org.pdf.converter;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Window extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String pdfToWord  = "FilesConverter/Resources/images/help.png";
	

	JPanel panelHeader,panelCenter,panelBottom;
	JMenuBar menuBar;
   	JMenu about,option,help,exit;
   	JButton button1,button2,button3,button4;
	
	public Window() throws MalformedURLException, IOException{
		
		setJMenuBar(new BarMenu().jmenuBar());
		
        createPanel();
        
        //parameters
		setTitle("Files Converter");
		setSize(550,300);
		setVisible(true);
		setLayout(new GridLayout(2,3));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
        button1.setIcon(new ImageIcon(pdfToWord));
        button1.addActionListener(this);
        
        button2 =  new JButton("WORD TO PDF");
        button2.setIcon(new ImageIcon(pdfToWord));
        button3 =  new JButton("PDF TO EXCEL");
        button3.setIcon(new ImageIcon(pdfToWord));
        button4 =  new JButton("PDF TO Image");
        button4.setIcon(new ImageIcon(pdfToWord));
        
        
        panelHeader = new JPanel();
        panelHeader.setLayout(new FlowLayout());  
        panelHeader.add(button1);
        panelHeader.add(button2);
        this.add("North",panelHeader);
        
        panelCenter = new JPanel();
        panelCenter.setLayout(new FlowLayout());
        panelCenter.add(button3);
        panelCenter.add(button4);
        this.add("Center",panelCenter);
	}	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==button1){
			this.setVisible(false);
			try {
				new PdfToWord();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(arg0.getSource()==button2){
			hideButton();

		}else if(arg0.getSource()==button3){
			hideButton();
		}else {
			hideButton();
		}

	}
	
	public void hideButton(){
		button1.setVisible(false);
		button2.setVisible(false);
		button3.setVisible(false);
		button4.setVisible(false);
	}
}

