package jdbc_project;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class displayRecord {
		displayRecord(String A, String B, String C) {
			
		System.out.println("Display record");
		
		System.out.println(A+ " "+ B+" "+C);
		Frame f8 = new Frame();
		f8.setVisible(true);
		f8.setBounds(100, 100, 450, 300);
		f8.setLayout(null);
		
		Label label = new Label("!! DISPLAY RECORD !!");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Impact", Font.PLAIN, 20));
		label.setAlignment(Label.CENTER);
		label.setBackground(Color.BLACK);
		label.setBounds(0, 30, 434, 22);
		f8.add(label);
		
		Label label_1 = new Label("ENROLLMENT NUMBER :");
		label_1.setBounds(30, 80, 161, 22);
		f8.add(label_1);
		
		Label label_2 = new Label("NAME : ");
		label_2.setBounds(30, 125, 161, 22);
		f8.add(label_2);
		
		Label label_3 = new Label("PHONE NUMBER : ");
		label_3.setBounds(30, 170, 161, 22);
		f8.add(label_3);
		
		TextField textField = new TextField();
		textField.setEditable(false);
		textField.setBounds(230, 80, 194, 22);
		f8.add(textField);
		textField.setText(A);
		
		TextField textField_1 = new TextField();
		textField_1.setEditable(false);
		textField_1.setBounds(230, 125, 194, 22);
		f8.add(textField_1);
		textField_1.setText(B);
		
		TextField textField_2 = new TextField();
		textField_2.setEditable(false);
		textField_2.setBounds(230, 170, 194, 22);
		f8.add(textField_2);
		textField_2.setText(C);
		
		Button button = new Button("ADMIN MENU");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_init();
			}
		});
		button.setBounds(150, 220, 85, 22);
		f8.add(button);
	}

}
