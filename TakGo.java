package timerTask;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.util.*;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class TakGo extends JFrame {
	Timer timer2; // for the second team expedition timer
	Timer timer3; // for the third team expedition timer
	Timer timer4; // for the forth team expedition timer
	Timer timer5; // show the current time 
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
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_6;
	JLabel label_14;
	JLabel label_18;
	JLabel label_19;
	JTextPane textPane;
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
			"水上機前線輸送"};
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
	String[] LeaderInfoArray = {"旗艦Lv1",
			"旗艦Lv2",
			"旗艦Lv3",
			"旗艦Lv3",
			"旗艦Lv3",
			"旗艦Lv4",
			"旗艦Lv5",
			"旗艦Lv6", // no 8
			"旗艦Lv3",
			"旗艦Lv3",
			"旗艦Lv6",
			"旗艦Lv4",
			"旗艦Lv5",
			"旗艦Lv6",
			"旗艦Lv9",
			"旗艦Lv10", // no 16
			"旗艦Lv20",
			"旗艦Lv15",
			"旗艦Lv20",
			"旗艦Lv1",
			"旗艦Lv15,艦隊合計Lv30",
			"旗艦Lv30,艦隊合計Lv45",
			"旗艦Lv50,艦隊合計Lv200",
			"旗艦Lv50,艦隊合計Lv200", // no 24
			"旗艦Lv25",
			"旗艦Lv30",
			"旗艦Lv1",
			"旗艦Lv30",
			"旗艦Lv50",
			"旗艦Lv55",
			"旗艦Lv60,艦隊合計Lv200",
			"旗艦Lv5", // no 32
			"",
			"",
			"旗艦Lv40",
			"旗艦Lv30",
			"旗艦Lv50,艦隊合計Lv200",
			"旗艦Lv65,艦隊合計Lv240",
			"旗艦Lv3,艦隊合計Lv180",
			"旗艦Lv25,艦隊合計Lv150"};
	String[] combatInfoArray = {"最低2隻。艦種自由",
			"最低4。艦種自由",
			"最低3。艦種自由",
			"軽1、駆2必要",
			"軽1、駆2、他1必要",
			"最低4。艦種自由",
			"全6。艦種自由",
			"全6。艦種自由",
			"軽1、駆2、他1必要",
			"軽2、他1必要",
			"駆2、他2必要",
			"駆2、他2必要",
			"軽1、駆4、他1必要",
			"軽1、駆3、他2必要",
			"空母(軽母,水母可/潜母不可)2、駆2、他2必要",
			"軽1、駆2、他3必要",
			"軽1、駆3、他2必要",
			"空母(軽母,水母可/潜母、あきつ丸不可)3、駆2、他1必要",
			"航戦2、駆2、他2必要",
			"潜1(潜母可/潜水母艦不可)、軽1必要",
			"軽1、駆4必要，3ドラム缶(輸送用)",
			"重1、軽1、駆2、他2必要",
			"航戦2、駆2、他2必要",
			"軽1(旗艦固定)、駆4、他1必要",
			"重2、駆2必要",
			"空母(軽母,水母可/潜母不可)1、軽1、駆2必要",
			"潜2(潜母可/潜水母艦不可)必要",
			"潜3(潜母可/潜水母艦不可)必要",
			"潜3(潜母可/潜水母艦不可)必要",
			"潜4(潜母可/潜水母艦不可)必要",
			"潜4(潜母可/潜水母艦不可)必要",
			"練巡1(旗艦固定),駆2必要",
			"駆2必要",
			"駆2必要",
			"空母(装母,軽母,水母可/潜母不可)2、重1、駆1、他2必要",
			"水母(空母不可,軽母不可,潜母不可)2、軽1、駆2、他2必要",
			"軽1、駆5必要，4ドラム缶(輸送用)",
			"駆5、他1必要，8ドラム缶(輸送用)",
			"潜水母艦1、潜4(潜空母可)必要",
			"軽1(旗艦固定)、水母2、駆2、他1必要"};
	
	String[] sourceInfoArray = {"弾薬×30",
			"弾薬×100、鋼材×30、高速修復材×0,1",
			"燃料×30、弾薬×30、鋼材×40",
			"弾薬×60、高速修復材×0,1、家具箱(小)×0,1",
			"燃料×200、弾薬×200、鋼材×20、ボーキサイト×20",
			"ボーキサイト×80、家具箱(小)×0,1",
			"鋼材×50、ボーキサイト×30、高速建造材×0,1",
			"燃料×50、弾薬×100、鋼材×50、ボーキサイト×50\n高速建造材×0,1,2、開発資材×0,1",
			"燃料×350、家具箱(小)×0,1、高速修復材×0,1,2",
			"弾薬×50、ボーキサイト×30、高速修復材×0,1\n高速建造材×0,1",
			"ボーキサイト×250、家具箱(小)×0,1\n高速修復材×0,1",
			"燃料×50、弾薬×250、鋼材×200、ボーキサイト×50\n家具箱(中)×0,1、開発資材×0,1",
			"燃料×240、弾薬×300、高速修復材×0,1,2\n家具箱(小)×0,1",
			"弾薬×240、鋼材×200、高速修復材×0,1\n開発資材×0,1",
			"鋼材×300、ボーキサイト×400、家具箱(大)×0,1\n開発資材×0,1",
			"燃料×500、弾薬×500、鋼材×200、ボーキサイト×200\n高速建造材×0,1,2、開発資材×0,1,2",
			"燃料×70、弾薬×70、鋼材×50",
			"鋼材×300、ボーキサイト×100、高速修復材×0,1",
			"燃料×400、鋼材×50、ボーキサイト×30\n家具箱(小)×0,1、開発資材×0,1",
			"鋼材×150、開発資材×0,1、家具箱(小)×0,1",
			"燃料×320、弾薬×270、家具箱(小)×0,1",
			"弾薬×10",
			"弾薬×20、ボーキサイト×100",
			"燃料×500、ボーキサイト×150、開発資材×0,1,2\n高速修復材×0,1",
			"燃料×900、鋼材×500",
			"ボーキサイト×900、高速修復材×0,1,2,3",
			"鋼材×800、開発資材×0,1、家具箱(小)×0,1,2",
			"鋼材×900、ボーキサイト×350、開発資材×0,1,2\n家具箱(中)×0,1,2",
			"ボーキサイト×100、開発資材×0,1、家具箱(小)×0,1",
			"ボーキサイト×100、開発資材×0,1,2,3",
			"弾薬×30、家具箱(小)×0,1",
			"燃料×50、弾薬×50、鋼材×50、ボーキサイト×50\n家具箱(大)×0,1、開発資材×0,1,2,3",
			"",
			"",
			"鋼材×240、ボーキサイト×280、家具箱(小)×0,1,2\n開発資材×0,1",
			"燃料×480、鋼材×200、ボーキサイト×200\n家具箱(中)×0,1,2、高速修復材×0,1",
			"弾薬×380、鋼材×270、家具箱(小)×0,1",
			"燃料×420、鋼材×200、家具箱(小)×0,1",
			"鋼材×300、高速修復材×0,1,2、家具箱(中)×0,1",
			"燃料×300、弾薬×300、ボーキサイト×100\n家具箱(小)×0,1,2,3、高速修復材×0,1"};
	
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
		setBounds(100, 100, 364, 477);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7B2C2\u8266\u968A");
		label.setBounds(10, 20, 46, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7B2C3\u8266\u968A");
		label_1.setBounds(10, 97, 46, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7B2C4\u8266\u968A");
		label_2.setBounds(10, 174, 46, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6642");
		label_3.setBounds(114, 20, 46, 15);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 17, 38, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5206");
		lblNewLabel.setBounds(181, 20, 46, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(66, 17, 38, 21);
		contentPane.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(200, 17, 38, 21);
		contentPane.add(textField_2);
		
		JLabel label_4 = new JLabel("\u79D2");
		label_4.setBounds(248, 20, 46, 15);
		contentPane.add(label_4);
		
		timer2 = new Timer();
		timer3 = new Timer();
		timer4 = new Timer();
		timer5 = new Timer();
		
		timer5.schedule(new CurrentDateTask(), 1000, 1000);
		
		JButton button = new JButton("\u958B\u59CB");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timer2.cancel();
				lblNewLabel_1.setForeground(Color.BLACK);
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
		button.setBounds(268, 16, 87, 23);
		contentPane.add(button);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 94, 38, 21);
		contentPane.add(textField_3);
		
		JLabel label_5 = new JLabel("\u6642");
		label_5.setBounds(114, 97, 46, 15);
		contentPane.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(133, 94, 38, 21);
		contentPane.add(textField_4);
		
		JLabel label_6 = new JLabel("\u5206");
		label_6.setBounds(181, 97, 46, 15);
		contentPane.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(200, 94, 38, 21);
		contentPane.add(textField_5);
		
		JLabel label_7 = new JLabel("\u79D2");
		label_7.setBounds(248, 97, 46, 15);
		contentPane.add(label_7);
		
		JButton button_1 = new JButton("\u958B\u59CB");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer3.cancel();
				label_14.setForeground(Color.BLACK);
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
		button_1.setBounds(268, 93, 87, 23);
		contentPane.add(button_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(66, 171, 38, 21);
		contentPane.add(textField_6);
		
		JLabel label_8 = new JLabel("\u6642");
		label_8.setBounds(114, 174, 46, 15);
		contentPane.add(label_8);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(133, 171, 38, 21);
		contentPane.add(textField_7);
		
		JLabel label_9 = new JLabel("\u5206");
		label_9.setBounds(181, 174, 46, 15);
		contentPane.add(label_9);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(200, 171, 38, 21);
		contentPane.add(textField_8);
		
		JLabel label_10 = new JLabel("\u79D2");
		label_10.setBounds(248, 174, 46, 15);
		contentPane.add(label_10);
		
		JButton button_2 = new JButton("\u958B\u59CB");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer4.cancel();
				label_15.setForeground(Color.BLACK);
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
		button_2.setBounds(268, 170, 87, 23);
		contentPane.add(button_2);
		
		JLabel label_11 = new JLabel("\u5269\u9918\u6642\u9593\uFF1A");
		label_11.setBounds(10, 59, 68, 15);
		contentPane.add(label_11);
		
		lblNewLabel_1 = new JLabel("\u9084\u672A\u8A2D\u5B9A\u6642\u9593");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(75, 59, 163, 15);
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
		button_3.setBounds(268, 56, 87, 21);
		contentPane.add(button_3);
		
		JLabel label_13 = new JLabel("\u5269\u9918\u6642\u9593\uFF1A");
		label_13.setBounds(10, 135, 68, 15);
		contentPane.add(label_13);
		
		label_14 = new JLabel("\u9084\u672A\u8A2D\u5B9A\u6642\u9593");
		label_14.setFont(new Font("新細明體", Font.BOLD, 14));
		label_14.setBounds(75, 135, 163, 15);
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
		button_4.setBounds(268, 126, 87, 23);
		contentPane.add(button_4);
		
		radioButton = new JRadioButton("\u7B2C2\u8266\u968A");
		radioButton.setFont(new Font("新細明體", Font.BOLD, 12));
		radioButton.setBackground(new Color(255, 204, 153));
		radioButton.setBounds(10, 239, 80, 21);
		contentPane.add(radioButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"練習航海", "長距離練習航海", "警備任務", "対潜警戒任務", "海上護衛任務", "防空射撃演習", "観艦式予行", "観艦式", "タンカー護衛任務", "強行偵察任務", "ボーキサイト輸送任務", "資源輸送任務", "鼠輸送作戦", "包囲陸戦隊撤収作戦", "囮機動部隊支援作戦", "艦隊決戦援護作戦", "敵地偵察作戦", "航空機輸送作戦", "北号作戦", "潜水艦哨戒任務", "北方鼠輸送作戦", "艦隊演習", "航空戦艦運用演習", "北方航路海上護衛", "通商破壊作戦", "敵母港空襲作戦", "潜水艦通商破壊作戦", "西方海域封鎖作戦", "潜水艦派遣演習", "潜水艦派遣作戦", "海外艦との接触", "遠洋練習航海", "前衛支援任務", "艦隊決戦支援任務", "MO作戦", "水上機基地建設", "東京急行", "東京急行(弐)", "遠洋潜水艦作戦", "水上機前線輸送"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(92, 239, 146, 21);
		contentPane.add(comboBox);
		
		radioButton_1 = new JRadioButton("\u7B2C3\u8266\u968A");
		radioButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		radioButton_1.setBackground(new Color(255, 204, 153));
		radioButton_1.setBounds(10, 262, 80, 21);
		contentPane.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("\u7B2C4\u8266\u968A");
		radioButton_2.setFont(new Font("新細明體", Font.BOLD, 12));
		radioButton_2.setBackground(new Color(255, 204, 153));
		radioButton_2.setBounds(10, 285, 80, 21);
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
                		lblNewLabel_4.setText(combatArray[index]);
                		label_19.setText(LeaderInfoArray[index]);
                		lblNewLabel_6.setText(combatInfoArray[index]);
                		textPane.setText(sourceInfoArray[index]);
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
		label_12.setBounds(10, 212, 68, 15);
		contentPane.add(label_12);
		
		label_15 = new JLabel("\u9084\u672A\u8A2D\u5B9A\u6642\u9593");
		label_15.setFont(new Font("新細明體", Font.BOLD, 14));
		label_15.setBounds(75, 212, 163, 15);
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
		button_5.setBounds(268, 208, 87, 23);
		contentPane.add(button_5);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_2.setBounds(92, 270, 263, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("現在時間：");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_3.setBounds(158, 270, 80, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_16 = new JLabel("提督選擇的遠征為：");
		label_16.setFont(new Font("新細明體", Font.BOLD, 14));
		label_16.setBounds(10, 312, 150, 21);
		contentPane.add(label_16);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel_4.setBounds(147, 312, 208, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("需求為：");
		lblNewLabel_5.setFont(new Font("新細明體", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 332, 56, 21);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_6.setFont(new Font("新細明體", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 354, 345, 21);
		contentPane.add(lblNewLabel_6);
		
		JLabel label_17 = new JLabel("獲取資源為：");
		label_17.setFont(new Font("新細明體", Font.BOLD, 13));
		label_17.setBounds(10, 373, 94, 20);
		contentPane.add(label_17);
		
		label_18 = new JLabel("");
		label_18.setBounds(102, 353, 253, 20);
		contentPane.add(label_18);
		
		JButton btnNewButton = new JButton("清除資訊");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_4.setText("");
        		label_19.setText("");
        		lblNewLabel_6.setText("");
        		textPane.setText("");
			}
		});
		btnNewButton.setBounds(248, 235, 107, 29);
		contentPane.add(btnNewButton);
		
		label_19 = new JLabel("");
		label_19.setForeground(new Color(0, 0, 128));
		label_19.setFont(new Font("新細明體", Font.BOLD, 12));
		label_19.setBounds(66, 332, 280, 21);
		contentPane.add(label_19);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("新細明體", Font.BOLD, 12));
		textPane.setEditable(false);
		textPane.setForeground(new Color(0, 128, 0));
		textPane.setBounds(10, 394, 341, 39);
		contentPane.add(textPane);
		    
		
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
				lblNewLabel_1.setForeground(Color.RED);
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
				label_14.setForeground(Color.RED);
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
				label_15.setForeground(Color.RED);
				label_15.setText("遠征回來");
			}
	    }
	}
	
	private class CurrentDateTask extends TimerTask {
		
		CurrentDateTask(){
			
			
		}
		
		
		public void run() {		
			SimpleDateFormat sdFormat = new SimpleDateFormat("MM / dd   hh:mm:ss");
			java.util.Date current=new java.util.Date();
			String strDate = sdFormat.format(current);
			lblNewLabel_2.setText(strDate);
	    }
	}
}


