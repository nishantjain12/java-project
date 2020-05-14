package jdbc_project;

import java.awt.Button;
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

public class Student_Frame1 {
	public void student() {
		Frame f2 = new Frame();
		f2.setVisible(true);
		f2.setBounds(100, 100, 450, 300);
		f2.setLayout(null);
		
		Label label = new Label("WELCOME STUDENT!!");
		label.setFont(new Font("Impact", Font.PLAIN, 20));
		label.setAlignment(Label.CENTER);
		label.setBounds(10, 40, 414, 50);
		f2.add(label);
		
		Label label_1 = new Label("ENROLLMENT NUMBER");
		label_1.setFont(new Font("Impact", Font.PLAIN, 14));
		label_1.setBounds(80, 100, 95, 22);
		f2.add(label_1);
		
		TextField textField = new TextField();
		textField.setBounds(80, 128, 100, 22);
		f2.add(textField);
		
		Label label_2 = new Label("PASSWORD");
		label_2.setFont(new Font("Impact", Font.PLAIN, 14));
		label_2.setBounds(80, 159, 95, 22);
		f2.add(label_2);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(78, 187, 100, 22);
		f2.add(textField_1);
		
		Button button = new Button("login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempeno = textField.getText();
				String temppass = textField_1.getText();
				try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                PreparedStatement st = connection.prepareStatement("SELECT * FROM `student_table` WHERE eno = ? AND pass = ?");

                st.setString(1, tempeno);
                System.out.println(tempeno);
                st.setString(2, temppass);
                System.out.println(temppass);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    f2.dispose();
                    String eno = rs.getString("eno");
                    String name = rs.getString("name");
                    String phone_no = rs.getString("phno");
                    String sid = rs.getString("s_id");
                    System.out.println(sid+" "+eno +" "+ name+" " + phone_no);
                    new studentInit(sid,eno,name,phone_no);
                    System.out.println("You have successfully logged in");
                } else {
                    System.out.println("Wrong Username & Password");
                    Label label_3 = new Label("Wrong ID & Password!!!");
            		label_3.setFont(new Font("Impact", Font.PLAIN, 13));
            		label_3.setAlignment(Label.CENTER);
            		label_3.setBounds(250, 164, 146, 22);
            		f2.add(label_3);
            		
            		Button button_1 = new Button("TRY AGAIN");
            		button_1.setBounds(250, 204, 70, 22);
            		button_1.addActionListener(new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				new Student_Frame1();
            			}
            		});
            		f2.add(button_1);
                }
            } catch (SQLException  sqlException) {
                sqlException.printStackTrace();
            } 
				
			}
		});
		button.setBounds(80, 224, 70, 22);
		f2.add(button);
	}
}


