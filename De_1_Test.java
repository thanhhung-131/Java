package hung11101;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.w3c.dom.events.Event;

public class De_1_Test extends JFrame {

	//create label
	JLabel importdataJLabel = new JLabel();
	JLabel keywordJLabel = new JLabel();
	
	
	
	//create TextField
	JTextField importdaraField = new JTextField();
	JTextField keywordField = new JTextField();
	
	
	//create Button
	JButton importfileButton = new JButton("Import file");
	JButton soluongButton = new JButton("So luong");
	JButton tongtienButton = new JButton("Tong tien");
	JButton goiyButton = new JButton("Goi y");
	
	//create TextArea
	JTextArea textArea = new JTextArea();
	
	//create panel
	JPanel labelJPanel = new JPanel();
	JPanel bottomJPanel = new JPanel();
	
	
	
	
	
	public De_1_Test() {
		this.setTitle("Quan ly don hang");
		this.setSize(500, 600);
		this.setDefaultCloseOperation(3);
		
//		set Label
		importdataJLabel.setText("  Import data");
		keywordJLabel.setText("  Keyword");
		importdataJLabel.setAlignmentX(TOP_ALIGNMENT);
		keywordJLabel.setAlignmentX(TOP_ALIGNMENT);
		
		// set panel
		
		
		
		
		
		
		
		
		
		// set visible
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new De_1_Test();
	}

}
