package hung11101;

import java.io.*;

import javax.swing.plaf.basic.BasicBorders.SplitPaneBorder;

public class testNhapxuatFile {

	public testNhapxuatFile() {
		try {
			BufferedReader bReader = new BufferedReader(
					new FileReader("C:\\Users\\DELL\\eclipse-workspace\\TestJava\\Input"));
			String s = bReader.readLine();
			while ((s = bReader.readLine())!= null) {
				String[] aString = s.split(",");
				for(int i = 0; i < aString.length / 3; i++) {
					for(int j = 0; j < aString.length; j++) {
					System.out.print(aString[j] + " ");
				}
					System.out.println("");
			 }
//				String[] tenmathangString = null;
//	        	String[] sotienStrings = null;
//	        	String[] tennguoimuaStrings = null;
//	        	for(int i = 0; i < aString.length + 3; i++) {
//	            	for(int j = 0; j < aString.length / 3; j++)
//	            		tenmathangString[j] = ;
//	            	}
//	            	for(int j = 0; j < aString.length / 3; j++) {
//	            	System.out.println(tenmathangString[j]);
//	            	}
//	        	for(int i = 1; i < aString.length + 3; i++) {
//	            	for(int j = 0; j < aString.length / 3; j++)
//	            		sotienStrings[j] = aString[i];
//	            	}
//	        	for(int i = 2; i < aString.length + 3; i++) {
//	            	for(int j = 0; j < aString.length / 3; j++)
//	            		tennguoimuaStrings[j] = aString[i];
//	            	}
			}
			bReader.close();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
//		try {
//			BufferedWriter bwBufferedWriter = new BufferedWriter(
//					new FileWriter("D:\\Learning\\Năm 2\\Kỳ 2\\Java\\Code\\TestJava\\src\\hung11101\\Input.txt"));
//			bwBufferedWriter.write("hungpro131");
//			bwBufferedWriter.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static void main(String[] args) {
		new testNhapxuatFile();
	}

}
