package jdbc_project;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window1  {
	
	window1(){
		Frame f = new Frame();
		f.setVisible(true);
		f.setBounds(100,100,450,300);
		f.setLayout(null);
		
		
		Label label = new Label("WHO AER YOU!!");
		label.setFont(new Font("Impact", Font.PLAIN, 20));
		label.setAlignment(Label.CENTER);
		label.setBounds(90, 70, 270, 22);
		f.add(label);

		
		Button button = new Button("ADMIN");
		button.setFont(new Font("Impact", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ADMIN_FRAME1();
			}
		});
		button.setSize(70, 22);
		button.setLocation(140, 110);
		f.add(button);
		
		
		
		Button button_1 = new Button("STUDENT");
		button_1.setFont(new Font("Impact", Font.PLAIN, 14));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_Frame1 sf = new Student_Frame1();
				sf.student();
			}
		});
		button_1.setSize(70, 22);
		button_1.setLocation(230, 110);
		f.add(button_1);
		
	};

	public static void main(String[] args) {
		System.out.println("inside window1 main method "); 
		new window1();
		
	}

}



