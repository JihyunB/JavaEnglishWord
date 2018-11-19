import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class WordManager {
	public void WordAdd(String day,String eng, String kor) {
		String message = "\n" + day + "/" + eng + "/" + kor;
        
        File file = new File("word/wordlist.txt");
        FileWriter writer = null;
        
        
        try {
            writer = new FileWriter(file, true);
            writer.write(message);
            writer.flush();
            
        }  catch(IOException e) {
                e.printStackTrace();
            }
        }
	
	public void nullCheck(String day,String eng, String kor) {
		if(day.equalsIgnoreCase("")||eng.equalsIgnoreCase("")||kor.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "날짜,영어,한글 뜻 모두 입력해주세요.");
		}
		else
			{WordAdd(day,eng,kor);
			JOptionPane.showMessageDialog(null, "추가 되었습니다.");
			}
	}
}
