import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//사용자 
public class User{
	DefaultTableModel model;
	JScrollPane scrollpane;
	JTable jtable;
	String[] userName = new String[1000];
	int[] right = new int[1000];
	int[] count = new int[1000];
	int[] day = new int[1000];
	double[] accuracy = new double[1000];
	String name;
	double acc;
	int c;
	int d;
	int r;
	
	
	public JTable showRankTable(){
		return jtable;
	}
	public User(String n,int d,int r,int c, double a){
		name = n;
		acc = a;
		this.d = d;
		this.c = c;
		int[] rank = new int[1000];
		String[] score = new String[1000];
		File file = new File("word/userRank.txt");
		
		
		String message =  "1"+"/"+n + "/"+Integer.toString(d)+"/"+Integer.toString(r)+"/"+Integer.toString(c)+"/" + a +"\n";
        
       // File file = new File("word/userRank.txt");
        FileWriter writer = null;
        
        try {
            writer = new FileWriter(file, true);
            writer.write(message);
            writer.flush();
     
    		BufferedReader br = new BufferedReader(new FileReader(file));
    	
    		Object[] tableLines = br.lines().toArray();
    		
    		for(int i = 0; i<tableLines.length;i++) {
    			String line = tableLines[i].toString().trim();
    			String[] dataRow = line.split("/");
    			score[i] = dataRow[5];
    			userName[i] = dataRow[1];
    			right[i] = Integer.valueOf(dataRow[3]);
    			count[i] = Integer.valueOf(dataRow[4]);
    			day[i] = Integer.valueOf(dataRow[2]);
    		}
    		for(int i = 0; i<tableLines.length;i++) {
    			rank[i]=1;
    			for(int j = 0; j<tableLines.length;j++) {
    				if(Double.valueOf(score[i])<Double.valueOf(score[j])) {
    					rank[i]++;
    				}
    			}
    		}
    		writer = new FileWriter(file, false);
    		for(int i = 0 ; i<tableLines.length;i++) {
    			message = Integer.toString(rank[i]) + "/" + userName[i] + "/" + Integer.toString(day[i]) + "/" + Integer.toString(right[i]) + "/" + Integer.toString(count[i]) +"/"+ score[i]+"\n";
    			writer.write(message);
                writer.flush();

    		}
    		br.close();
    			
    		}
    		 catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
	}
	public User(){
		
	}

	{
		File file = new File("word/userRank.txt");
	
			try {
			JTable jtable1 = new JTable();
			BufferedReader br = new BufferedReader(new FileReader(file));
			String firstLine = "순위/이름/일차/맞힌 개수/총 문제 수/정답률";
			String[] columnsName = firstLine.split("/");
			model = (DefaultTableModel)jtable1.getModel();
			model.setColumnIdentifiers(columnsName);
		
			Object[] tableLines = br.lines().toArray();
			
			for(int i = 0; i<tableLines.length;i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split("/");
				model.addRow(dataRow);
			}
			br.close();
			jtable = new JTable(model);
			
			}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
		
