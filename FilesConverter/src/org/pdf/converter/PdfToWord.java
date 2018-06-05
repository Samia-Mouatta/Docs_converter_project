package org.pdf.converter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.*;

import com.aspose.pdf.DocSaveOptions;
import com.aspose.pdf.Document;

public class PdfToWord extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String exportIcon = "FilesConverter/Resources/images/export.png";
	String chooseIcon = "FilesConverter/Resources/images/select.png";
	
	JPanel panelHeader,panelCenter,panelBottom;
	JLabel label1,label2;
	JButton choose,export;
	JTextField fileName,fileExport;
	
	public PdfToWord() throws MalformedURLException, IOException{
		
		setTitle("Files Converter");
		setSize(600,400);
		setVisible(true);
		setLayout(new FlowLayout());
		setResizable(false);
		setJMenuBar(new BarMenu().jmenuBar());
		
		panelHeader = new JPanel();
		panelHeader.setLayout(new FlowLayout());
		
		label1 = new JLabel("File chooser:");
		panelHeader.add(label1);
		
		fileName = new JTextField();
		fileName.setColumns(30);
		panelHeader.add(fileName);
		
		choose = new JButton("...");
		choose.addActionListener(this);
		choose.setIcon(new ImageIcon(chooseIcon));
		choose.setBackground(Color.LIGHT_GRAY); 
		panelHeader.add(choose);
		
		this.add("North",panelHeader);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout());
		
		label2 = new JLabel("Export to:");
		panelCenter.add(label2);
		
		fileExport = new JTextField();
		fileExport.setColumns(30);
		panelCenter.add(fileExport);
		
		this.add("Center",panelCenter);
		
		panelBottom = new JPanel();
		panelBottom.setLayout(new FlowLayout());
		export = new JButton("Export");
        export.setIcon(new ImageIcon(exportIcon));
        export.addActionListener(this);
        export.setBackground(Color.LIGHT_GRAY); 
		panelBottom.add(export);
		
		this.add(panelBottom);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String pat = "((?!^)\\.(?=[^.]*$|(?<=^\\.[^.]{0,1000})$))|$";
		
		
		if(e.getSource()==choose){
			JFileChooser fOpen = new JFileChooser();
			int chooser = fOpen.showDialog(null, "Choose file");
			
			String s = fOpen.getSelectedFile().toString();
			if (chooser == JFileChooser.APPROVE_OPTION) {
				fileName.setText(s);
			}
			
			String fExport = fileName.getText().split(pat,2)[0];
			fileExport.setText(fExport+".docx");
		}if(e.getSource() == export){
			
			String f = fileName.getText();
	        //Instantiate the Document object
	        Document document = new Document(f);
	        // Create DocSaveOptions object
	        DocSaveOptions saveOption = new DocSaveOptions();
	        // Set format DOCX
	        saveOption.setFormat(DocSaveOptions.DocFormat.DocX);
	        // Set the recognition mode as Flow
	        saveOption.setMode(DocSaveOptions.RecognitionMode.Flow);
	        // Set the Horizontal proximity as 2.5
	        saveOption.setRelativeHorizontalProximity(2.5f);
	        // Enable the value to recognize bullets during conversion process
	        saveOption.setRecognizeBullets(true);
	        
			
			String fExport = fileName.getText().split(pat,2)[0];
	        
	        // Save the resultant DOC file
	        document.save(fExport+".docx", saveOption);
		}
		
	}

}
