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
import java.sql.ResultSet;
import java.sql.SQLException;

public class showRecord {
	private String Eeno = null;
		showRecord() {
		Frame f4 = new Frame();
		f4.setVisible(true);
		f4.setBounds(100, 100, 450, 300);
		f4.setLayout(null);
		
		Label label = new Label("!!SHOW RECORD !!");
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Impact", Font.PLAIN, 20));
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 30, 434, 22);
		f4.add(label);
		
		Label label_1 = new Label("Enter Enrollment no : ");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label_1.setBounds(10, 70, 140, 22);
		f4.add(label_1);
		
		TextField textField = new TextField();
		textField.setBounds(157, 70, 200, 22);
		f4.add(textField);
		
		
		Button button = new Button("Search");
		button.setBounds(150, 140, 70, 22);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eeno = textField.getText();
				System.out.println("out of try "+ Eeno);
				
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                    PreparedStatement st = connection.prepareStatement("SELECT `eno`, `name`, `phno` FROM `student_table` WHERE `eno` = ? ");

                    st.setString(1, Eeno);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        f4.dispose();
                        String eno = rs.getString("eno");
                        String name = rs.getString("name");
                        String phone_no = rs.getString("phno");
                        System.out.println(eno +" "+ name+" " + phone_no);
                        
                        new displayRecord(eno,name,phone_no);
                        
                    } else {
                    	Label label_2 = new Label("Enrollment number not available!!!");
                		label_2.setBounds(157, 98, 200, 40);
                		f4.add(label_2);
                			}
                		} catch (SQLException  sqlException) {
                    sqlException.printStackTrace();
			}
		}
	});
		f4.add(button);
		Button button_1 = new Button("Admin menu");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_init();
			}
		});
		button_1.setBounds(240, 140, 80, 22);
		f4.add(button_1);
}
}
