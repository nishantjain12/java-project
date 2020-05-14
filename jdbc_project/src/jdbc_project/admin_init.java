package jdbc_project;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin_init {
		admin_init() {
		String ch1 = "show record ";
		String ch2 = "Add record ";
		String ch3 = "Update record ";
		String ch4= "Delete record ";


		Frame f3 = new Frame();
		f3.setVisible(true);
		f3.setBounds(100, 100, 450, 300);
		f3.setLayout(null);
		
		Label label = new Label("You have successfully logged in !!!!");
		label.setForeground(Color.WHITE);
		label.setBackground(Color.BLACK);
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 30, 434, 22);
		f3.add(label);
		
		Label label_1 = new Label("scroll down and chosse an option >");
		label_1.setFont(new Font("Impact", Font.PLAIN, 14));
		label_1.setBounds(30, 58, 236, 22);
		f3.add(label_1);
		
		Choice choice = new Choice();
		choice.setBounds(300, 58, 100, 22);
		f3.add(choice);
		
		Button button = new Button("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ch1.equals(choice.getItem(choice.getSelectedIndex()))) {
					System.out.println("show Record");
					new showRecord();
				}else if(ch2.equals(choice.getItem(choice.getSelectedIndex()))) {
					System.out.println("ADD RECORD");
					new addRecord();
				}else if(ch3.equals(choice.getItem(choice.getSelectedIndex()))) {
					System.out.println("update RECORD");
					new updateRecord();
				}else if(ch4.equals(choice.getItem(choice.getSelectedIndex()))) {
					System.out.println("Delete RECORD");
					new deleteRecord();
				}
			}
		});
		button.setBounds(160, 110, 70, 22);
		f3.add(button);
		choice.add("show record ");
		choice.add("Add record ");
		choice.add("Update record ");
		choice.add("Delete record ");
		
	}

}
