package jdbc_project;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class studentInit {
	studentInit(String a, String b, String c, String d){
		Frame f11 = new Frame();
		f11.setVisible(true);
		f11.setBounds(100, 100, 450, 300);
		f11.setLayout(null);
		
		Label label = new Label("!! STUDENT PROFILE !!");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Impact", Font.PLAIN, 15));
		label.setBackground(Color.BLACK);
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 30, 434, 22);
		f11.add(label);
		
		Label label_1 = new Label("STUDENT ID : ");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(10, 90, 189, 22);
		f11.add(label_1);
		
		Label label_2 = new Label("NAME : ");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_2.setBounds(10, 120, 189, 22);
		f11.add(label_2);
		
		Label label_3 = new Label("ENROLLMENT NO : ");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_3.setBounds(10, 190, 189, 22);
		f11.add(label_3);
		
		Label label_4 = new Label("PHONE NUMBER : ");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_4.setBounds(10, 230, 189, 22);
		f11.add(label_4);
		
		TextField textField = new TextField();
		textField.setEditable(false);
		textField.setBounds(215, 90, 189, 22);
		f11.add(textField);
		textField.setText(a);
		
		
		TextField textField_1 = new TextField();
		textField_1.setEditable(false);
		textField_1.setBounds(215, 120, 189, 22);
		f11.add(textField_1);
		textField_1.setText(c);
		
		TextField textField_2 = new TextField();
		textField_2.setEditable(false);
		textField_2.setBounds(215, 190, 189, 22);
		f11.add(textField_2);
		textField_2.setText(b);
		
		TextField textField_3 = new TextField();
		textField_3.setEditable(false);
		textField_3.setBounds(215, 230, 189, 22);
		f11.add(textField_3);
		textField_3.setText(d);
		
		Button button = new Button("MAIN MENU");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new window1();
			}
		});
		button.setBounds(165, 258, 70, 22);
		f11.add(button);
	}
	}
