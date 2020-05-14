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

public class updatePassword {
	updatePassword(int sid){
		Frame f9 = new Frame();
		f9.setVisible(true);
		f9.setBounds(100,100,450,300);
		f9.setLayout(null);
		
		Label label = new Label("!! UPDATE PASSWORD !!");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Impact", Font.PLAIN, 15));
		label.setBackground(Color.BLACK);
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 30, 434, 22);
		f9.add(label);
		
		Label label_1 = new Label("ENTER NEW PASSWORD : ");
		label_1.setBounds(20, 70, 170, 22);
		f9.add(label_1);
		
		TextField textField = new TextField();
		textField.setBounds(217, 70, 156, 22);
		f9.add(textField);
		
		Button button = new Button("Update");
		button.setBounds(166, 165, 70, 22);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newpass = textField.getText();
				try {
					
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                    PreparedStatement st = connection.prepareStatement("UPDATE `student_table` SET `pass`= ? WHERE s_id = ?");
                    System.out.println(newpass);
                    st.setString(1,newpass);
                    System.out.println(sid);
                    st.setInt(2, sid);
                    int count = st.executeUpdate();
                    
                    System.out.println(count + "rows effected");
                    
                    Label label_2 = new Label("!! PASSWORD UPDATED !!");
            		label_2.setAlignment(Label.CENTER);
            		label_2.setBounds(100, 210, 200, 22);
            		f9.add(label_2);
                        
                   
                		} catch (SQLException  sqlException) {
                    sqlException.printStackTrace();
			}
				
			}
		});
		f9.add(button);
		
		Button button_1 = new Button("ADMIN MENU");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_init();
			}
		});
		button_1.setBounds(269, 165, 77, 22);
		f9.add(button_1);
	
	}

}
