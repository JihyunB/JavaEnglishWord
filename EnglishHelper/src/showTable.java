import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class showTable{
	DefaultTableModel model;
	JTable jtable;
	
	public JTable showEntireTable(){
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
			
			for(int i = 0; i<tableLines.length;i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split("/");
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
		
		

