import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//파일 
public class getWord{
	String[] korean = new String[1000];
	String[] english = new String[1000];
	Integer lastday = 0;
	Integer[] day = new Integer[1000];
	Test t = new Test();
	int rows = 0;
	int numOfWord = 0;
	int[] IDOfTheDay;
	int q=0;
	public String[] getKorean(){
		return korean;
	}
	public String[] getEnglish(){
		return english;
	}
	public int getLastDay() {
		return lastday;
	}
	public Integer[] getDay(){
		return day;
	}
	public String pEnglish(int r){
		return english[r];
	}
	public String pKorean(int r){
		return korean[r];
	}
	public int getNumOfWord(int day){
		numOfWord = 0;
		for(int i=0;i<rows;i++) {		
			if(this.day[i]==day) {
				numOfWord++;
				}
		}	
		return numOfWord;
	}
	public int[] getIDOfTheDay(int day){
		IDOfTheDay = new int[getNumOfWord(day)];
		for(int i=0;i<rows;i++) {
			if(this.day[i]==day) {
				IDOfTheDay[q] = i;
				q++;
			}
		}
		return IDOfTheDay;
	}
	
	{
		File file = new File("word/wordlist.txt");
	
			try {

			BufferedReader br = new BufferedReader(new FileReader(file));
	
			
			Object[] tableLines = br.lines().toArray();
			rows = tableLines.length;
			
			for(int i = 0; i<tableLines.length;i++) {
				String line = tableLines[i].toString().trim();
				String[] dataRow = line.split("/");
				day[i] = Integer.valueOf(dataRow[0]);
				english[i] = dataRow[1];
				korean[i] = dataRow[2];
				if(lastday<Integer.valueOf(day[i])) {
					lastday = Integer.valueOf(day[i]);
				}
			}
			br.close();
	}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
		
		
