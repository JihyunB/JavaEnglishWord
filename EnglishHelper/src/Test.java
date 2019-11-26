import javax.swing.JOptionPane;
//시험기능
public class Test{
	int r;
	int counter = 0;
	int good = 0;
	boolean[] used = new boolean[1000];
	String[] pKorean;
	String[] pEnglish;
	int[] IDs;
	getWord word;
	
	public String[] getTestKorean(int day) {
		word = new getWord();
		pKorean = new String[word.getNumOfWord(day)];
		int[] d = word.getIDOfTheDay(day);
		
		for(int i=0;i<word.getNumOfWord(day);i++) {
			pKorean[i] = word.pKorean(d[i]);	
		}
		return pKorean;
	}
	public String[] getTestEnglish(int day) {
		word = new getWord();
		pEnglish = new String[word.getNumOfWord(day)];
		int[] d = word.getIDOfTheDay(day);
		
		for(int i=0;i<word.getNumOfWord(day);i++) {
			pEnglish[i] = word.pEnglish(d[i]);	
		}
		return pEnglish;
	}
	public int getRight() {
		return good;
	}
	
	public void checkWord(String s,String d) {
		if(s.equalsIgnoreCase(d)) {
			counter++;
			good++;		
			JOptionPane.showMessageDialog(null, "Á¤´äÀÔ´Ï´Ù.");
		}
		else {
			counter++;
			JOptionPane.showMessageDialog(null, "¿À´äÀÔ´Ï´Ù.");
		}
	}
	
	public int getCounter() {
		return counter;
	}
	public double getAccuracy() {
		return (double)good/counter;
	}
}


