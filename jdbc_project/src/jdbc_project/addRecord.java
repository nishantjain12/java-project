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


public class addRecord {
	private int stid;
	private String phno1;
	private String eno1;
	private String pass1;
	private String name1;
		addRecord() {
			
		Frame f5 = new Frame();
		f5.setVisible(true);
		f5.setBounds(100, 100, 450, 300);
		f5.setLayout(null);
		
		Label label = new Label("!! ADD RECORD !!");
		label.setForeground(Color.WHITE);
		label.setBackground(Color.BLACK);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Impact", Font.PLAIN, 20));
		label.setBounds(0, 30, 434, 22);
		f5.add(label);
		
		Label label_1 = new Label("ENTER ENO NO : ");
		label_1.setBounds(10, 60, 143, 22);
		f5.add(label_1);
		
		TextField textField = new TextField();
		textField.setBounds(150, 60, 200, 22);
		f5.add(textField);
		
		
		Label label_2 = new Label("ENTER NAME : ");
		label_2.setBounds(10, 85, 131, 22);
		f5.add(label_2);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(150, 85, 200, 22);
		f5.add(textField_1);
		
		
		Label label_3 = new Label("ENTER PHONE NO : ");
		label_3.setBounds(10, 115, 131, 22);
		f5.add(label_3);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(150, 115, 200, 22);
		f5.add(textField_2);
	
		
		Label label_4 = new Label("ENTER STUDENT ID : ");
		label_4.setBounds(10, 150, 131, 22);
		f5.add(label_4);
		
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(150, 150, 200, 22);
		f5.add(textField_3);
	
		Label label_5 = new Label("SET PASSWORD : ");
		label_5.setBounds(10, 189, 131, 22);
		f5.add(label_5);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(150, 189, 200, 22);
		f5.add(textField_4);
		
		
		Button button = new Button("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stid = Integer.parseInt(textField_3.getText());
				phno1 = textField_2.getText();
				eno1 = textField.getText();
				pass1 = textField_4.getText();
				name1 = textField_1.getText();
				System.out.println(stid);
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

                    PreparedStatement st = connection.prepareStatement("INSERT INTO `student_table`(`s_id`, `eno`, `name`, `pass`, `phno`) VALUES (?,?,?,?,?)");
                    st.setInt(1,stid);
                    st.setString(2, eno1);
                    st.setString(3, name1);
                    st.setString(4, pass1);
                    st.setString(5, phno1);
                    int count = st.executeUpdate();
                    
                    System.out.println(count + "rows effected");
                    
                	Label label_6 = new Label("!! RECORD ADDED !!");
            		label_6.setAlignment(Label.CENTER);
            		label_6.setFont(new Font("Impact", Font.PLAIN, 14));
            		label_6.setBounds(100, 258, 280, 22);
            		f5.add(label_6);
            		
                        
                   
                		} catch (SQLException  sqlException) {
                    sqlException.printStackTrace();
			}
			}
		});
		button.setBounds(150, 230, 70, 22);
		f5.add(button);
		
		Button button_1 = new Button("Admin Menu");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new admin_init();
			}
		});
		button_1.setBounds(257, 230, 80, 22);
		f5.add(button_1);
		
		
	
			}
	}

