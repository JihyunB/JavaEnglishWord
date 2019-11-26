import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//
public class Study{
	DefaultTableModel model;
	JTable jtable;
	String[] korean = new String[1000];
	String[] english = new String[1000];
	Integer lastday = 0;
	Integer[] day = new Integer[1000];
	getWord word = new getWord();
	
	public JTable showWord(){
		return jtable;
	}
	
	{
		File file = new File("word/wordlist.txt");
	
			try {
				
			JTable jtable1 = new JTable();
			BufferedReader br = new BufferedReader(new FileReader(file));
			String firstLine = "날짜/영어/한글";
			String[] columnsName = firstLine.split("/");
			model = (DefaultTableModel)jtable1.getModel();
			model.setColumnIdentifiers(columnsName);
			
			Object[] tableLines = br.lines().toArray();
			String resultStr = null;
			resultStr = JOptionPane.showInputDialog("학습할 날짜를 입력해주세요(1~"+word.getLastDay()+")");
			
			for(int i = 0; i<tableLines.length;i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split("/");
				day[i] = Integer.valueOf(dataRow[0]);
				english[i] = dataRow[1];
				korean[i] = dataRow[2];
				if(lastday<Integer.valueOf(day[i])) {
					lastday = Integer.valueOf(day[i]);
				}
				
				if(day[i] == Integer.valueOf(resultStr))
				model.addRow(dataRow);
			}
				
				jtable = new JTable(model);
				br.close();
			
				
	}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
		
		




		
	


