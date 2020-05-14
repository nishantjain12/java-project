package jdbc_project;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updatePhoneNo {
	updatePhoneNo(int sid){
		Frame f10 = new Frame();
		f10.setVisible(true);
		f10.setBounds(100,100,450,300);
		f10.setLayout(null);
		
		Label label = new Label("!! UPDATE PHONE NUMBER !!");
		label.setAlignment(Label.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Impact", Font.PLAIN, 15));
		label.setBackground(Color.BLACK);
		label.setBounds(0, 30, 434, 22);
		f10.add(label);
		
		Label label_1 = new Label("ENTER NEW PHONE NO : ");
		label_1.setBounds(20, 80, 182, 22);
		f10.add(label_1);
		
		TextField textField = new TextField();
		textField.setBounds(231, 80, 150, 22);
		f10.add(textField);
		
		
		Button button = new Button("UPDATE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newpno = textField.getText();
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                    PreparedStatement st = connection.prepareStatement("UPDATE `student_table` SET `phno`= ? WHERE s_id = ?");
                    System.out.println(newpno);
                    st.setString(1,newpno);
                    System.out.println(sid);
                    st.setInt(2, sid);
                    int count = st.executeUpdate();
                    
                    System.out.println(count + "rows effected");
                    
                    Label label_2 = new Label("!! PHONE NUMBER UPDATED !!");
            		label_2.setFont(new Font("Impact", Font.PLAIN, 15));
            		label_2.setAlignment(Label.CENTER);
            		label_2.setBounds(90, 220, 230, 22);
            		f10.add(label_2);
                        
                   
                		} catch (SQLException  sqlException) {
                    sqlException.printStackTrace();
			}
			}
		});
		button.setBounds(171, 169, 70, 22);
		f10.add(button);
		
		Button button_1 = new Button("ADMIN MENU");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_init();
			}
		});
		button_1.setBounds(267, 169, 84, 22);
		f10.add(button_1);
	}
	}


