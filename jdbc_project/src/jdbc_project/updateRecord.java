package jdbc_project;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateRecord {
	private int stid1;
	private String password1 = "PASSWORD";
	private String phoneno = "PHONE NUMBER" ;
		updateRecord() {
			
		Frame f6 = new Frame();
		f6.setVisible(true);
		f6.setBounds(100, 100, 450, 300);
		f6.setLayout(null);
		
		Label label = new Label("!! UPDATE RECORD !!");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Impact", Font.PLAIN, 20));
		label.setBackground(Color.BLACK);
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 30, 434, 22);
		f6.add(label);
		
		Label label_1 = new Label("Enter Student ID : ");
		label_1.setBounds(10, 60, 170, 22);
		f6.add(label_1);
		
		TextField textField = new TextField();
		textField.setBounds(200, 60, 83, 22);
		f6.add(textField);
		
		Label label_2 = new Label("Select item to updata : ");
		label_2.setBounds(10, 118, 170, 22);
		f6.add(label_2);
		
		Choice choice = new Choice();
		choice.setBounds(200, 118, 120, 20);
		f6.add(choice);
		choice.add("PASSWORD");
		choice.add("PHONE NUMBER");
		
		Button button = new Button("Next");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				stid1 = Integer.parseInt(textField.getText());
				if(password1.equals(choice.getItem(choice.getSelectedIndex()))) {
					System.out.println("password will change");
					new updatePassword(stid1);
				}else if(phoneno.equals(choice.getItem(choice.getSelectedIndex()))) {
					System.out.println("phone number will change");
					new updatePhoneNo(stid1);
				}
			}
		});
		button.setFont(new Font("Dialog", Font.PLAIN, 14));
		button.setBounds(172, 172, 70, 22);
		f6.add(button);
		}
}
