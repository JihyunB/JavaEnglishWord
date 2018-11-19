import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class main_menu extends JFrame {

	private JPanel contentPane;
	private JPanel studyPanel;
	private JPanel testpanel;
	private JPanel rankPanel;
	private JPanel managerPanel;
	private ImageIcon icon;
	private Test test;
	private Study study;
	private getWord word = new getWord();
	private String[] tEnglish;
	private String[] tKorean;
	private int numOfWord;
	private int i=0;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_menu frame = new main_menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	public main_menu() {
		
		icon = new ImageIcon("images/mainimg.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
			}};
		
		studyPanel = new JPanel(){
			public void paintComponent(Graphics g) {
				icon = new ImageIcon("images/stimg.png");
				g.drawImage(icon.getImage(),0,0,null);
			}};
		testpanel = new JPanel(){
			public void paintComponent(Graphics g) {
				icon = new ImageIcon("images/testimg.png");
				g.drawImage(icon.getImage(),0,0,null);
			}};
		rankPanel = new JPanel(){
			public void paintComponent(Graphics g) {
				icon = new ImageIcon("images/rankimg.png");
				g.drawImage(icon.getImage(),0,0,null);
			}};
		managerPanel = new JPanel(){
			public void paintComponent(Graphics g) {
				icon = new ImageIcon("images/wmimg.png");
				g.drawImage(icon.getImage(),0,0,null);
			}};
		
		
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		studyPanel.setLayout(null);
		testpanel.setLayout(null);
		rankPanel.setLayout(null);
		managerPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Study");
		btnNewButton.setBounds(540, 360, 200, 40);
		panel.add(btnNewButton);

		JButton button = new JButton("Test");
		button.setBounds(540, 410, 200, 40);
		panel.add(button);
		
		JButton button_1 = new JButton("Word Manager");
		button_1.setBounds(540, 460, 200, 40);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Rank");
		button_2.setBounds(540, 510, 200, 40);
		panel.add(button_2);

		//study
		btnNewButton.addActionListener(e->{
			JButton button_3 = new JButton("뒤로가기");
			button_3.setBounds(30, 30, 150, 40);
			studyPanel.add(button_3);
			panel.setVisible(false);
			contentPane.add(studyPanel);
			studyPanel.setVisible(true);
			study = new Study();
			study.showWord().setBounds(100, 100, 500, 500);
			JScrollPane sc = new JScrollPane(study.showWord());
			sc.setBounds(300, 100, 500, 500);
			studyPanel.add(sc);
			button_3.addActionListener(e2->{
				this.hide();
				main_menu frm = new main_menu();
				frm.setVisible(true);
			});
		});
		
		//test
		button.addActionListener(e->{
			
			JPanel proPanel = new JPanel();
			JLabel netLabel = new JLabel();
			JLabel nowLabel = new JLabel();
			JLabel rigLabel = new JLabel();
			JLabel info = new JLabel();
			info.setText("Test를 끝까지 진행하시면 사용자 이름 입력창이 나옵니다.");
			info.setFont(new Font("Serif", Font.PLAIN, 13));
			info.setBounds(300, 50, 400, 30);
			testpanel.add(info);
			proPanel.setLayout(null);
			proPanel.setBounds(50, 200, 200, 140);
			netLabel.setBounds(10, 20, 80, 30);
			nowLabel.setBounds(10, 60, 80, 30);
			rigLabel.setBounds(10, 100, 80, 30);
			
			proPanel.add(netLabel);
			proPanel.add(nowLabel);
			proPanel.add(rigLabel);
			
			testpanel.add(proPanel);
			
			
			word = new getWord();
			panel.setVisible(false);
			contentPane.add(testpanel);
			testpanel.setVisible(true);
			String day = null;
			test = new Test();
			day = JOptionPane.showInputDialog("시험을 볼 일차(Day)를 입력해주세요.(1~"+word.getLastDay()+")");
			int d = Integer.valueOf(day);
	
			tKorean = new String[word.getNumOfWord(d)];
			tEnglish = new String[word.getNumOfWord(d)];
			
			tKorean = test.getTestKorean(d);
			tEnglish = test.getTestEnglish(d);
			
			numOfWord = word.getNumOfWord(d);
			String word1 = tKorean[i];
			JLabel wordTestLabel = new JLabel();
			
			netLabel.setText("총 문제 수: " + Integer.toString(numOfWord));
			nowLabel.setText("현재 문제 : 1");
			rigLabel.setText("맞힌 개수 : 0");
			wordTestLabel.setText(word1);
			wordTestLabel.updateUI();
			wordTestLabel.setBounds(500, 200, 300, 100);
			wordTestLabel.setOpaque(true);
			wordTestLabel.setBackground(Color.YELLOW);
			wordTestLabel.setFont(new Font("Serif", Font.PLAIN, 15));
			wordTestLabel.setHorizontalAlignment(JTextField.CENTER);
			testpanel.add(wordTestLabel);
			JTextField checkWord = new JTextField();
			checkWord.setBounds(500, 450, 300, 100);
			testpanel.add(checkWord);
			testpanel.updateUI();
			
			checkWord.addActionListener(e2->{
					test.checkWord(checkWord.getText(),tEnglish[i]);
					i++;
					nowLabel.setText("현재 문제 : " + Integer.toString(i+1));
					rigLabel.setText("맞힌 개수 : " + Integer.toString(test.getRight()));
					checkWord.setText("");
					if(i<numOfWord) {
					wordTestLabel.setText(tKorean[i]);
					}
					if(test.getCounter()==numOfWord) {
						String resultStr = null;
						resultStr = JOptionPane.showInputDialog("이름을 입력해주세요.");
						User user = new User(resultStr,d,test.getRight(),numOfWord,test.getAccuracy());	
						this.hide();
						main_menu frm = new main_menu();
						frm.setVisible(true);
					}
			});
			
			JButton button_4 = new JButton("뒤로가기");
			testpanel.add(button_4);
			button_4.setBounds(30, 30, 150, 40);
			button_4.addActionListener(e3->{
				this.hide();
				main_menu frm = new main_menu();
				frm.setVisible(true);
			});
		});
		
		//wordmanager
		button_1.addActionListener(e->{
			JButton button_5 = new JButton("뒤로가기");
			button_5.setBounds(30, 30, 150, 40);
			managerPanel.add(button_5);
			JPanel inputPanel = new JPanel();
			inputPanel.setLayout(null);
			inputPanel.setBounds(50, 200, 300, 200);
			JTextField dayInput = new JTextField();
			JTextField engInput = new JTextField();
			JTextField korInput = new JTextField();
			JLabel engInputLabel = new JLabel();
			JLabel korInputLabel = new JLabel();
			JLabel dayInputLabel = new JLabel();
			JLabel InputLabel = new JLabel();
			JButton inputButton = new JButton("입력");
			inputPanel.add(engInput);
			inputPanel.add(korInput);
			inputPanel.add(dayInput);
			inputPanel.add(korInputLabel);
			inputPanel.add(engInputLabel);
			inputPanel.add(dayInputLabel);
			inputPanel.add(InputLabel);
			inputPanel.add(inputButton);
			
			managerPanel.add(inputPanel);
			JLabel info = new JLabel();
			info.setText("입력 결과는 Word Manager를 새로 실행시 확인 가능합니다.");
			info.setFont(new Font("Serif", Font.PLAIN, 13));
			info.setBounds(500, 150, 400, 30);
			
			engInput.setBounds(50, 110, 150, 30);
			korInput.setBounds(50, 160, 150, 30);
			dayInput.setBounds(50, 60, 150, 30);
			
		
			panel.setVisible(false);
			contentPane.add(managerPanel);
			showTable table = new showTable();
			managerPanel.setVisible(true);
			table.showEntireTable().setBounds(100, 100, 500, 400);
			JScrollPane sc2 = new JScrollPane(table.showEntireTable());
			sc2.setBounds(500, 200, 500, 400);
			managerPanel.add(info);
			managerPanel.add(sc2);
			
			engInputLabel.setText("영어");
			korInputLabel.setText("한글");
			dayInputLabel.setText("일차");
			InputLabel.setText("단어추가");
			engInputLabel.setBounds(10, 110, 30, 30);
			korInputLabel.setBounds(10, 160, 30, 30);
			InputLabel.setBounds(100, 10, 100, 30);
			dayInputLabel.setBounds(10, 60, 100, 30);
			inputButton.setBounds(220, 110, 75, 30);
			
			inputButton.addActionListener(e2->{
				WordManager word = new WordManager();
				word.nullCheck(dayInput.getText(),engInput.getText(),korInput.getText());
				korInput.setText("");
				engInput.setText("");
				dayInput.setText("");
			});
			button_5.addActionListener(e3->{
				this.hide();
				main_menu frm = new main_menu();
				frm.setVisible(true);
			});
		});
		
		//rank
		button_2.addActionListener(e->{
			JLabel info = new JLabel();
			info.setText("Rank는 Test가 완료되어 새로운 기록이 발생하면 갱신됩니다.");
			info.setFont(new Font("Serif", Font.PLAIN, 13));
			info.setBounds(300, 50, 400, 30);
			rankPanel.add(info);
			
			panel.setVisible(false);
			contentPane.add(rankPanel);
			rankPanel.setVisible(true);
			User user = new User();
			rankPanel.setVisible(true);
			user.showRankTable().setBounds(100, 100, 500, 500);
			user.showRankTable().setAutoCreateRowSorter(true);
			TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(user.showRankTable().getModel());
			user.showRankTable().setRowSorter(sorter);

			List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
			sortKeys.add(new RowSorter.SortKey(5, SortOrder.DESCENDING));
			sorter.setSortKeys(sortKeys);
			JScrollPane sc3 = new JScrollPane(user.showRankTable());
			sc3.setBounds(350, 100, 500, 500);
			rankPanel.add(sc3);

			JButton button_6 = new JButton("뒤로가기");
			button_6.setBounds(30, 30, 150, 40);
			rankPanel.add(button_6);
			
			button_6.addActionListener(e2->{
				this.hide();
				main_menu frm = new main_menu();
				frm.setVisible(true);
			});
		});
		
	}
}
