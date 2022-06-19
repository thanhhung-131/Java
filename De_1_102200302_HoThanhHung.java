package hung11101;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;

public class De_1_102200302_HoThanhHung extends JFrame implements ActionListener {
	
	//create label
			JLabel importdataJLabel = new JLabel();
			JLabel keywordJLabel = new JLabel();
	
	//create button
			JButton importfileButton = new JButton("Import file");
			JButton soluongButton = new JButton("So luong");
			JButton tongtienButton = new JButton("Tong tien");
			JButton goiyButton = new JButton("Goi y");
	
	//create TextField
			JTextField inputJTextField = new JTextField();
			JTextField keywordJTextField = new JTextField();
	
	//create Panel
			JPanel labelJPanel = new JPanel();
			JPanel texfieldJPanel = new JPanel();
			JPanel func1Panel = new JPanel();
			JPanel func2JPanel = new JPanel();
			JPanel topJPanel = new JPanel();
			JPanel centerJPanel = new JPanel();
			JPanel bottomJPanel = new JPanel();
	
	//create Textarea
			JTextArea textArea = new JTextArea(20, 40);	
			
	
	public De_1_102200302_HoThanhHung() {		
		
		
		this.setTitle("Quan ly don hang");
		this.setSize(600,500);
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(3);
		
		//set Label
		importdataJLabel.setText("  Import data");
		importdataJLabel.getAlignmentX();
		keywordJLabel.setText("  Keyword");
		keywordJLabel.getAlignmentX();
		
		//set Panel
		labelJPanel.setLayout(new GridLayout(2,1));
		this.getContentPane().add(BorderLayout.WEST, labelJPanel);
		texfieldJPanel.setLayout(new BoxLayout(texfieldJPanel, BoxLayout.Y_AXIS));
		this.getContentPane().add(BorderLayout.CENTER, texfieldJPanel);
		func2JPanel.setLayout(new FlowLayout());
		
		//set Button
		importfileButton.setBackground(null);	
		soluongButton.setBackground(null);
		tongtienButton.setBackground(null);
		goiyButton.setBackground(null);
		
		
		
		//set textArea
		Border border = new LineBorder(Color.black);
		textArea.setBorder(border);
		textArea.setAlignmentY(CENTER_ALIGNMENT);
		textArea.setEditable(false);
		
		
		//add Label to frame
		labelJPanel.add(importdataJLabel, BorderLayout.WEST);
		labelJPanel.add(keywordJLabel, BorderLayout.WEST);
		
		//add TextField to frame
		texfieldJPanel.add(inputJTextField);
		texfieldJPanel.add(keywordJTextField);
		
		//add button to frame
		func1Panel.add(importfileButton);
		func2JPanel.add(soluongButton);
		func2JPanel.add(tongtienButton);
		func2JPanel.add(goiyButton);
		
		//add Textarea to frame
		bottomJPanel.add(textArea);
		
		//seperate function
		topJPanel.add(labelJPanel);
		topJPanel.add(texfieldJPanel);
		topJPanel.add(func1Panel);
		topJPanel.setLayout(new GridLayout());
		this.getContentPane().add(topJPanel, BorderLayout.CENTER);
		
		centerJPanel.add(func2JPanel, BorderLayout.NORTH);		
		centerJPanel.add(textArea, BorderLayout.SOUTH);
		this.getContentPane().add(centerJPanel, BorderLayout.SOUTH);
		
		//create file r/w

		
		//Sign up listener
		importfileButton.addActionListener(this);
		soluongButton.addActionListener(this);
		
		//event
		
		
		
		this.setVisible(true);
		// repaint
	}
	
	public static void main(String[] args) {
		new De_1_102200302_HoThanhHung();
	}
	@Override
	public void actionPerformed(ActionEvent a){
		//Import file function
		String inputtextString = inputJTextField.getText();
		
		if (importfileButton.isEnabled() == true) {
			try {
				BufferedReader bReader = new BufferedReader(
						new FileReader("C:\\Users\\DELL\\eclipse-workspace\\TestJava\\" + inputtextString));
				String s;
				while ((s = bReader.readLine())!= null) {
					String[] aStrings = s.split(",");
					for(int i = 0; i < 3; i++) {
						textArea.setText(textArea.getText() + " " + aStrings[i] + " " + "\n");
					}
					
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					} catch (ClassNotFoundException e1) {
						// 
						e1.printStackTrace();
					}
					String connnectionUrlString = "jdbc:sqlserver://DESKTOP-8622U14:1433;encrypt=true;user=sa;password=hung1312002;trustServerCertificate=true;";
			        try (Connection connection = DriverManager.getConnection(connnectionUrlString)){
			        }
			        catch (SQLException el) {
			            el.printStackTrace();
			        }
				}
				bReader.close();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
		}

	}
}


