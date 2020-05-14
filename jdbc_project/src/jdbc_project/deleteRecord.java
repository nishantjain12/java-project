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

public class deleteRecord {
		deleteRecord() {
		Frame f7 = new Frame();
		f7.setVisible(true);
		f7.setBounds(100, 100, 450, 300);
		f7.setLayout(null);
		
		Label label = new Label("!! DELETE RECORD !!");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Impact", Font.PLAIN, 20));
		label.setBackground(Color.BLACK);
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 0, 434, 22);
		f7.add(label);
		
		Label label_1 = new Label("ENTER ENO TO DELETE RECORD : ");
		label_1.setBounds(25, 50, 195, 22);
		f7.add(label_1);
		
		TextField textField = new TextField();
		textField.setBounds(221, 50, 203, 22);
		f7.add(textField);
		
		Button button = new Button("DELETE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dEno = textField.getText();
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                    PreparedStatement st = connection.prepareStatement("DELETE  FROM `student_table` WHERE eno = ?");
                    System.out.println(dEno);
                    st.setString(1,dEno);
                    int count = st.executeUpdate();
                    
                    System.out.println(count + "rows effected");
                    
                    Label label_2 = new Label("!! RECORD DELETED !!");
            		label_2.setFont(new Font("Impact", Font.PLAIN, 15));
            		label_2.setAlignment(Label.CENTER);
            		label_2.setBounds(100, 203, 261, 22);
            		f7.add(label_2);
                        
                   
                		} catch (SQLException  sqlException) {
                    sqlException.printStackTrace();
			}
			}
		});
		button.setBounds(165, 165, 70, 22);
		f7.add(button);
		
		Button button_1 = new Button("ADMIN MENU");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_init();
			}
		});
		button_1.setBounds(257, 165, 85, 22);
		f7.add(button_1);
		
		
	}

}
