//package timerTask;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TakGo extends JFrame {
	Timer timer2;
	Timer timer3;
	Timer timer4;
	int twoTeamSec;
	int threeTeamSec;
	int fourTeamSec;
	JPanel contentPane;
	JTextField textField_1;
	JTextField textField;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	JTextField textField_6;
	JTextField textField_7;
	JTextField textField_8;
	JLabel lblNewLabel_1;
	JLabel label_14;
	JRadioButton radioButton;
	JRadioButton radioButton_1;
	JRadioButton radioButton_2;
	ButtonGroup group;
	String[] combatArray = {"練習航海",
			"長距離練習航海",
			"警備任務",
			"対潜警戒任務",
			"海上護衛任務",
			"防空射撃演習",
			"観艦式予行",
			"観艦式",
			"タンカー護衛任務",
			"強行偵察任務",
			"ボーキサイト輸送任務",
			"資源輸送任務",
			"鼠輸送作戦",
			"包囲陸戦隊撤収作戦",
			"囮機動部隊支援作戦",
			"艦隊決戦援護作戦",
			"敵地偵察作戦",
			"航空機輸送作戦",
			"北号作戦",
			"潜水艦哨戒任務",
			"北方鼠輸送作戦",
			"艦隊演習",
			"航空戦艦運用演習",
			"北方航路海上護衛",
			"通商破壊作戦",
			"敵母港空襲作戦",
			"潜水艦通商破壊作戦",
			"西方海域封鎖作戦",
			"潜水艦派遣演習",
			"潜水艦派遣作戦",
			"海外艦との接触",
			"遠洋練習航海",
			"前衛支援任務",
			"艦隊決戦支援任務",
			"MO作戦",
			"水上機基地建設",
			"東京急行",
			"東京急行(弐)",
			"遠洋潜水艦作戦",
			"水上機前線輸送",};
	String[] hourArray = {"0","0","0","0","1",
			"0","1","3","4","1",
			"5","8","4","6","12",
			"15","0","5","6","2",
			"2","3","4","8","40",
			"80","20","25","24","48",
			"2","24","0","0","7",
			"9","2","2","30","6"};
	String[] minArray = {"15","30","20","50","30",
			"40","0","0","0","30",
			"0","0","0","0","0",
			"0","45","0","0","0",
			"20","0","0","20","0",
			"0","0","0","0","0",
			"0","15","30","0","0",
			"0","45","55","0","50"};
	String[] secArray = {"0","0","0","0","0",
			"0","0","0","0","0",
			"0","0","0","0","0",
			"0","0","0","0","0",
			"0","0","0","0","0",
			"0","0","0","0","0",
			"0","0","0","0","0",
			"0","0","0","0","0"};
	JLabel label_11;
	JLabel label_15;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TakGo frame = new TakGo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TakGo() {
		setTitle("艦隊これくしょん -艦これ遠征");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7B2C2\u8266\u968A");
		label.setBounds(21, 20, 46, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7B2C3\u8266\u968A");
		label_1.setBounds(21, 97, 46, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7B2C4\u8266\u968A");
		label_2.setBounds(21, 174, 46, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6642");
		label_3.setBounds(125, 20, 46, 15);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 17, 38, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5206");
		lblNewLabel.setBounds(200, 20, 46, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(77, 17, 38, 21);
		contentPane.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(220, 17, 38, 21);
		contentPane.add(textField_2);
		
		JLabel label_4 = new JLabel("\u79D2");
		label_4.setBounds(268, 20, 46, 15);
		contentPane.add(label_4);
		
		JButton button = new JButton("\u958B\u59CB");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().length() == 0){
					textField.setText("0");
				}
				if(textField_1.getText().length() == 0){
					textField_1.setText("0");
				}
				if(textField_2.getText().length() == 0){
					textField_2.setText("0");
				}
				int hour = Integer.parseInt(textField.getText());
				int min = Integer.parseInt(textField_1.getText());
				int sec = Integer.parseInt(textField_2.getText());
				twoTeamSec = sec + 60 * min + 60 * 60 * hour;
				timer2 = new Timer();
				timer2.schedule(new DateTask(twoTeamSec), 1000, 1000);
				
				//timer2.cancel();
			}
		});
		button.setBounds(288, 16, 87, 23);
		contentPane.add(button);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(77, 94, 38, 21);
		contentPane.add(textField_3);
		
		JLabel label_5 = new JLabel("\u6642");
		label_5.setBounds(125, 97, 46, 15);
		contentPane.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(152, 94, 38, 21);
		contentPane.add(textField_4);
		
		JLabel label_6 = new JLabel("\u5206");
		label_6.setBounds(200, 97, 46, 15);
		contentPane.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(220, 94, 38, 21);
		contentPane.add(textField_5);
		
		JLabel label_7 = new JLabel("\u79D2");
		label_7.setBounds(268, 97, 46, 15);
		contentPane.add(label_7);
		
		JButton button_1 = new JButton("\u958B\u59CB");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_3.getText().length() == 0){
					textField_3.setText("0");
				}
				if(textField_4.getText().length() == 0){
					textField_4.setText("0");
				}
				if(textField_5.getText().length() == 0){
					textField_5.setText("0");
				}
				int hour = Integer.parseInt(textField_3.getText());
				int min = Integer.parseInt(textField_4.getText());
				int sec = Integer.parseInt(textField_5.getText());
				threeTeamSec = sec + 60 * min + 60 * 60 * hour;
				timer3 = new Timer();
				timer3.schedule(new DateTask3(threeTeamSec), 1000, 1000);
				
			}
		});
		button_1.setBounds(288, 93, 87, 23);
		contentPane.add(button_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(77, 171, 38, 21);
		contentPane.add(textField_6);
		
		JLabel label_8 = new JLabel("\u6642");
		label_8.setBounds(125, 174, 46, 15);
		contentPane.add(label_8);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(152, 171, 38, 21);
		contentPane.add(textField_7);
		
		JLabel label_9 = new JLabel("\u5206");
		label_9.setBounds(200, 174, 46, 15);
		contentPane.add(label_9);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(220, 171, 38, 21);
		contentPane.add(textField_8);
		
		JLabel label_10 = new JLabel("\u79D2");
		label_10.setBounds(268, 174, 46, 15);
		contentPane.add(label_10);
		
		JButton button_2 = new JButton("\u958B\u59CB");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_6.getText().length() == 0){
					textField_6.setText("0");
				}
				if(textField_7.getText().length() == 0){
					textField_7.setText("0");
				}
				if(textField_8.getText().length() == 0){
					textField_8.setText("0");
				}
				int hour = Integer.parseInt(textField_6.getText());
				int min = Integer.parseInt(textField_7.getText());
				int sec = Integer.parseInt(textField_8.getText());
				fourTeamSec = sec + 60 * min + 60 * 60 * hour;
				timer4 = new Timer();
				timer4.schedule(new DateTask4(fourTeamSec), 1000, 1000);
				
			}
		});
		button_2.setBounds(288, 170, 87, 23);
		contentPane.add(button_2);
		
		JLabel label_11 = new JLabel("\u5269\u9918\u6642\u9593\uFF1A");
		label_11.setBounds(21, 59, 68, 15);
		contentPane.add(label_11);
		
		lblNewLabel_1 = new JLabel("\u9084\u672A\u8A2D\u5B9A\u6642\u9593");
		lblNewLabel_1.setBounds(83, 59, 163, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton button_3 = new JButton("\u7D50\u675F");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				timer2.cancel();
				lblNewLabel_1.setText("");
				twoTeamSec = 0;
			}
		});
		button_3.setBounds(288, 55, 87, 23);
		contentPane.add(button_3);
		
		JLabel label_13 = new JLabel("\u5269\u9918\u6642\u9593\uFF1A");
		label_13.setBounds(21, 135, 68, 15);
		contentPane.add(label_13);
		
		label_14 = new JLabel("\u9084\u672A\u8A2D\u5B9A\u6642\u9593");
		label_14.setBounds(83, 135, 163, 15);
		contentPane.add(label_14);
		
		JButton button_4 = new JButton("\u7D50\u675F");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				timer3.cancel();
				label_14.setText("");
				threeTeamSec = 0;
			}
		});
		button_4.setBounds(288, 131, 87, 23);
		contentPane.add(button_4);
		
		radioButton = new JRadioButton("\u7B2C2\u8266\u968A");
		radioButton.setBounds(21, 263, 80, 21);
		contentPane.add(radioButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"練習航海", "長距離練習航海", "警備任務", "対潜警戒任務", "海上護衛任務", "防空射撃演習", "観艦式予行", "観艦式", "タンカー護衛任務", "強行偵察任務", "ボーキサイト輸送任務", "資源輸送任務", "鼠輸送作戦", "包囲陸戦隊撤収作戦", "囮機動部隊支援作戦", "艦隊決戦援護作戦", "敵地偵察作戦", "航空機輸送作戦", "北号作戦", "潜水艦哨戒任務", "北方鼠輸送作戦", "艦隊演習", "航空戦艦運用演習", "北方航路海上護衛", "通商破壊作戦", "敵母港空襲作戦", "潜水艦通商破壊作戦", "西方海域封鎖作戦", "潜水艦派遣演習", "潜水艦派遣作戦", "海外艦との接触", "遠洋練習航海", "前衛支援任務", "艦隊決戦支援任務", "MO作戦", "水上機基地建設", "東京急行", "東京急行(弐)", "遠洋潜水艦作戦", "水上機前線輸送"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(100, 263, 146, 21);
		contentPane.add(comboBox);
		
		radioButton_1 = new JRadioButton("\u7B2C3\u8266\u968A");
		radioButton_1.setBounds(21, 286, 80, 21);
		contentPane.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("\u7B2C4\u8266\u968A");
		radioButton_2.setBounds(21, 309, 80, 21);
		contentPane.add(radioButton_2);
		comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //
                // Get the source of the component, which is our combo
                // box.
                //
                JComboBox comboBox = (JComboBox) event.getSource();

                Object selected = comboBox.getSelectedItem();
                
                boolean flag = true;
                int index = 0;
                while(flag){
                	if(selected.toString().equals(combatArray[index])){
                		if(radioButton.isSelected()){
                			textField.setText(hourArray[index]);
                			textField_1.setText(minArray[index]);
                			textField_2.setText(secArray[index]);
                    	}else if(radioButton_1.isSelected()){
                    		textField_3.setText(hourArray[index]);
                			textField_4.setText(minArray[index]);
                			textField_5.setText(secArray[index]);
                    	}else if(radioButton_2.isSelected()){
                    		textField_6.setText(hourArray[index]);
                			textField_7.setText(minArray[index]);
                			textField_8.setText(secArray[index]);
                    	}else{
                    		
                    	}
                		flag = false;
                	}else{
                		index++;
                		if(index == combatArray.length){
                			flag = false;
                		}
                	}
                	
                }
                
            }
        });
		
		group = new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_1);
		group.add(radioButton_2);
		
		JLabel label_12 = new JLabel("\u5269\u9918\u6642\u9593\uFF1A");
		label_12.setBounds(21, 212, 68, 15);
		contentPane.add(label_12);
		
		label_15 = new JLabel("\u9084\u672A\u8A2D\u5B9A\u6642\u9593");
		label_15.setBounds(83, 212, 163, 15);
		contentPane.add(label_15);
		
		JButton button_5 = new JButton("\u7D50\u675F");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				timer4.cancel();
				label_15.setText("");
				fourTeamSec = 0;
			}
		});
		button_5.setBounds(288, 208, 87, 23);
		contentPane.add(button_5);
		    
		
	}
	
	
	public int getTwoTeamTime(){
		return twoTeamSec;
	}
	
	private class DateTask extends TimerTask {
		int sec = 0;	
		DateTask(){
			
			
		}
		DateTask(int userTime){
			sec = userTime;
		}
		
		public void run() {		
			if(sec >= 0){
				int hour = sec / (60 * 60);
				int min = ( sec - (60 * 60 * hour) ) / (60);
				int leaveSec = sec - (hour * 3600) - (min * 60);
				String temp1 = Integer.toString(hour);
				String temp2 = Integer.toString(min);
				String temp3 = Integer.toString(leaveSec);
				lblNewLabel_1.setText(temp1 + " 時 " + temp2 + " 分 " + temp3 + " 秒 ");
				sec = sec - 1;
			}else{
				lblNewLabel_1.setText("遠征回來");
			}
	    }
	}
	
	private class DateTask3 extends TimerTask {
		int sec = 0;	
		DateTask3(){
			
			
		}
		DateTask3(int userTime){
			sec = userTime;
		}
		
		public void run() {		
			if(sec >= 0){
				int hour = sec / (60 * 60);
				int min = ( sec - (60 * 60 * hour) ) / (60);
				int leaveSec = sec - (hour * 3600) - (min * 60);
				String temp1 = Integer.toString(hour);
				String temp2 = Integer.toString(min);
				String temp3 = Integer.toString(leaveSec);
				label_14.setText(temp1 + " 時 " + temp2 + " 分 " + temp3 + " 秒 ");
				sec = sec - 1;
			}else{
				label_14.setText("遠征回來");
			}
	    }
	}
	
	private class DateTask4 extends TimerTask {
		int sec = 0;	
		DateTask4(){
			
			
		}
		DateTask4(int userTime){
			sec = userTime;
		}
		
		public void run() {		
			if(sec >= 0){
				int hour = sec / (60 * 60);
				int min = ( sec - (60 * 60 * hour) ) / (60);
				int leaveSec = sec - (hour * 3600) - (min * 60);
				String temp1 = Integer.toString(hour);
				String temp2 = Integer.toString(min);
				String temp3 = Integer.toString(leaveSec);
				label_15.setText(temp1 + " 時 " + temp2 + " 分 " + temp3 + " 秒 ");
				sec = sec - 1;
			}else{
				label_15.setText("遠征回來");
			}
	    }
	}
}


