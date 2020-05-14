package jdbc_project;

import java.sql.*;


import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADMIN_FRAME1 {
	
		ADMIN_FRAME1(){
			
		Frame f1 = new Frame();
		f1.setVisible(true);
		f1.setBounds(100, 100, 450, 300);
		f1.setLayout(null);
		
		
		Label label = new Label("LOGIN ID");
		label.setBounds(110, 80, 100, 22);
		f1.add(label);
		
		TextField textField = new TextField();
		textField.setBounds(110, 108, 100, 22);
		f1.add(textField);
		
		Label label_1 = new Label("PASSWORD");
		label_1.setBounds(110, 136, 100, 22);
		f1.add(label_1);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(110, 164, 100, 22);
		f1.add(textField_1);
		
		Label label_2 = new Label("WELCOME ADMIN!!");
		label_2.setFont(new Font("Impact", Font.PLAIN, 20));
		label_2.setAlignment(Label.CENTER);
		label_2.setBounds(10, 40, 414, 39);
		f1.add(label_2);
		
		Button button = new Button("login");
		button.setBounds(110, 204, 70, 22);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = textField_1.getText();
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                    PreparedStatement st = connection.prepareStatement("SELECT login_id, password FROM table1 WHERE login_id=? AND password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        f1.dispose();
                        new admin_init();
                        System.out.println("You have successfully logged in");
                    } else {
                        System.out.println("Wrong Username & Password");
                        Label label_3 = new Label("Wrong ID & Password!!!");
                		label_3.setFont(new Font("Impact", Font.PLAIN, 13));
                		label_3.setAlignment(Label.CENTER);
                		label_3.setBounds(250, 164, 146, 22);
                		f1.add(label_3);
                		
                		Button button_1 = new Button("TRY AGAIN");
                		button_1.setBounds(250, 204, 70, 22);
                		button_1.addActionListener(new ActionListener() {
                			public void actionPerformed(ActionEvent e) {
                				new ADMIN_FRAME1();
                			}
                		});
                		f1.add(button_1);
                    }
                } catch (SQLException  sqlException) {
                    sqlException.printStackTrace();
                } 
            }
        });
		f1.add(button);
		
	}
	
}

