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
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;

public class De_1_102200302_HoThanhHung extends JFrame implements ActionListener {

	// create label
	JLabel importdataJLabel = new JLabel();
	JLabel keywordJLabel = new JLabel();

	// create button
	JButton importfileButton = new JButton("Import file");
	JButton soluongButton = new JButton("So luong");
	JButton tongtienButton = new JButton("Tong tien");
	JButton goiyButton = new JButton("Goi y");

	// create TextField
	JTextField inputJTextField = new JTextField();
	JTextField keywordJTextField = new JTextField();

	// create Panel
	JPanel labelJPanel = new JPanel();
	JPanel texfieldJPanel = new JPanel();
	JPanel func1Panel = new JPanel();
	JPanel func2JPanel = new JPanel();
	JPanel topJPanel = new JPanel();
	JPanel centerJPanel = new JPanel();
	JPanel bottomJPanel = new JPanel();

	// create Textarea
	JTextArea textArea = new JTextArea(20, 40);

	public De_1_102200302_HoThanhHung() {

		this.setTitle("Quan ly don hang");
		this.setSize(600, 500);
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(3);

		// set Label
		importdataJLabel.setText("  Import data");
		importdataJLabel.getAlignmentX();
		keywordJLabel.setText("  Keyword");
		keywordJLabel.getAlignmentX();

		// set Panel
		labelJPanel.setLayout(new GridLayout(2, 1));
		this.getContentPane().add(BorderLayout.WEST, labelJPanel);
		texfieldJPanel.setLayout(new BoxLayout(texfieldJPanel, BoxLayout.Y_AXIS));
		this.getContentPane().add(BorderLayout.CENTER, texfieldJPanel);
		func2JPanel.setLayout(new FlowLayout());

		// set Button
		importfileButton.setBackground(null);
		soluongButton.setBackground(null);
		tongtienButton.setBackground(null);
		goiyButton.setBackground(null);

		// set textArea
		Border border = new LineBorder(Color.black);
		textArea.setBorder(border);
		textArea.setAlignmentY(CENTER_ALIGNMENT);
		textArea.setEditable(false);

		// add Label to frame
		labelJPanel.add(importdataJLabel, BorderLayout.WEST);
		labelJPanel.add(keywordJLabel, BorderLayout.WEST);

		// add TextField to frame
		texfieldJPanel.add(inputJTextField);
		texfieldJPanel.add(keywordJTextField);

		// add button to frame
		func1Panel.add(importfileButton);
		func2JPanel.add(soluongButton);
		func2JPanel.add(tongtienButton);
		func2JPanel.add(goiyButton);

		// add Textarea to frame
		bottomJPanel.add(textArea);

		// seperate function
		topJPanel.add(labelJPanel);
		topJPanel.add(texfieldJPanel);
		topJPanel.add(func1Panel);
		topJPanel.setLayout(new GridLayout());
		this.getContentPane().add(topJPanel, BorderLayout.CENTER);
		centerJPanel.add(func2JPanel, BorderLayout.NORTH);
		centerJPanel.add(textArea, BorderLayout.SOUTH);
		this.getContentPane().add(centerJPanel, BorderLayout.SOUTH);

		// connect sqlserver

		// Sign up listener
		importfileButton.addActionListener(this);
		soluongButton.addActionListener(this);
		tongtienButton.addActionListener(this);
		goiyButton.addActionListener(this);

		this.setVisible(true);
	}

	// ket noi, excute query sql
	public static Connection SQLconnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connnectionUrlString = "jdbc:sqlserver://DESKTOP-8622U14:1433;databasename=QuanLyDonHang;encrypt=true;user=sa;password=hung1312002;trustServerCertificate=true;";
		return connection = DriverManager.getConnection(connnectionUrlString);
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		new De_1_102200302_HoThanhHung();
	}

	String[] fileStrings;
	String line = "";

	@Override
	public void actionPerformed(ActionEvent a) {
		// Read file
		String inputtextString = inputJTextField.getText();
		String path = "C:\\Users\\DELL\\eclipse-workspace\\TestJava\\";
		BufferedReader bReader = null;
		try {
			bReader = new BufferedReader(new FileReader(path + inputtextString));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Import file function
		String keywordtextString = keywordJTextField.getText();
		Object object = a.getSource();
		try {
			if (object == importfileButton) {
				SQLconnection();
				Connection connection = De_1_102200302_HoThanhHung.SQLconnection();
				String query = "";
				textArea.setText("");
				while ((line = bReader.readLine()) != null) {
					fileStrings = line.split(",");
					textArea.setText(textArea.getText() + fileStrings[0] + " " + fileStrings[1] + " " + fileStrings[2] + "\n");
					query = "INSERT INTO dbo.DonHang (TenMatHang, SoTien, TenNguoiMua)"
							+ "VALUES (?,?,?);";
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, fileStrings[0]);
					ps.setString(2, fileStrings[1]);
					ps.setString(3, fileStrings[2]);
					ps.executeUpdate();
				}
			}
			// Soluong Button
			if (object == soluongButton) {
				textArea.setText("");
				int count = 0;
				while ((line = bReader.readLine()) != null) {
					fileStrings = line.split(",");
					for (int i = 0; i < fileStrings.length; i++) {
						if (fileStrings[i].equals(keywordtextString) == true) {
							count++;
						}
					}
				}
				if (count == 0) {
					textArea.setText("Khong tim thay mat hang nay");
				} else {
					textArea.setText(String.valueOf(count));
				}
			}
			// Tong tien button
			if (object == tongtienButton) {
				textArea.setText("");
				int tongtien = 0;
				while ((line = bReader.readLine()) != null) {
					fileStrings = line.split(",");
					if (fileStrings[2].equals(keywordtextString) == true) {
						tongtien += Integer.parseInt(fileStrings[1]);
					}
				}
				if (tongtien != 0) {
					textArea.setText(String.valueOf(tongtien));
				} else {
					textArea.setText("Khong tim thay nguoi nay");
				}
			}
			if (object == goiyButton) {
				textArea.setText("");
				int tongtien = 0;
				String tennguoimua = "";
				while ((line = bReader.readLine()) != null) {
					fileStrings = line.split(",");
					if (fileStrings[0].equals(keywordtextString) == true) {
						tennguoimua = fileStrings[2];
						if(tongtien == 0) {
							tongtien += Integer.parseInt(fileStrings[1]);
						}
					}
					if (fileStrings[0].equals(keywordtextString) == false
							&& fileStrings[2].equals(tennguoimua) == true) {
						if(tongtien < Integer.parseInt(fileStrings[1])) {
//							tongtien 
						}
						textArea.setText(textArea.getText() + fileStrings[0] + " " + String.valueOf(tongtien) + "\n");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
