package JDBC_Students_data_Manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.Border;

public class Main {
	
	static JFrame f;
	static JLabel l1,l2,l3,l4,l5,ls,ol1,ol2,ol3,ol4,ol5;
	static JButton b6,search_button;
	static JPanel p1,p2,p3,p4,p5,p6,op1,op2,op3,op4,op5,op6;
	static JTextField t1,t2,t3,t4,t5,ts;
	static JTextField ot1,ot2,ot3,ot4,ot5;
	
	
	public static void main(String args[])
	{
		String databaseURL = "jdbc:ucanaccess://studentData.accdb";
		
		try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
		
		f=new JFrame("Student Data");
		f.setSize(700,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(1,2));
		
		l1=new JLabel("Student ID: ");
		l2=new JLabel("Name: ");
		l3=new JLabel("Date Of Birth: ");
		l4=new JLabel("Phone: ");
		l5=new JLabel("Email: ");
		
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		ts=new JTextField("Student ID",25);
		
		b6=new JButton("Add Data!");
		search_button=new JButton("Search");
		
		p1= new JPanel(new FlowLayout());
		p2= new JPanel(new FlowLayout());
		p3= new JPanel(new FlowLayout());
		p4= new JPanel(new FlowLayout());
		p5= new JPanel(new FlowLayout());
		p6= new JPanel(new FlowLayout());
		
		p1.add(l1); p1.add(t1);
		p2.add(l2); p2.add(t2);
		p3.add(l3); p3.add(t3);
		p4.add(l4); p4.add(t4);
		p5.add(l5); p5.add(t5);
		p6.add(b6);
		
		JPanel pp1 =new JPanel(new GridLayout(6,1));
		
		
		pp1.add(p1);
		pp1.add(p2);
		pp1.add(p3);
		pp1.add(p4);
		pp1.add(p5);
		pp1.add(p6);
		Border border = BorderFactory.createLineBorder(Color.black);
		pp1.setBorder(border);
		
		ot1=new JTextField(25);
		ot2=new JTextField(25);
		ot3=new JTextField(25);
		ot4=new JTextField(25);
		ot5=new JTextField(25);
		
		ot1.setEditable(false); ot2.setEditable(false);
		ot3.setEditable(false); ot4.setEditable(false);
		ot5.setEditable(false);
		
		ol1=new JLabel("Student ID: ");
		ol2=new JLabel("Name: ");
		ol3=new JLabel("Date Of Birth: ");
		ol4=new JLabel("Phone: ");
		ol5=new JLabel("Email: ");
		
		op1= new JPanel(new FlowLayout(FlowLayout.LEFT));
		op2= new JPanel(new FlowLayout(FlowLayout.LEFT));
		op3= new JPanel(new FlowLayout(FlowLayout.LEFT));
		op4= new JPanel(new FlowLayout(FlowLayout.LEFT));
		op5= new JPanel(new FlowLayout(FlowLayout.LEFT));
		op6= new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		op1.add(search_button); op1.add(ts);
		op2.add(ol1); op2.add(ot1);
		op3.add(ol2); op3.add(ot2);
		op4.add(ol3); op4.add(ot3);
		op5.add(ol4); op5.add(ot4);
		op6.add(ol5); op6.add(ot5);
		
		
		JPanel pp2 = new JPanel(new GridLayout(6,1));
		
		pp2.add(op1); pp2.add(op2);
		pp2.add(op3); pp2.add(op4);
		pp2.add(op5); pp2.add(op6);
		
		f.add(pp1);
		
		f.add(pp2);
		f.setVisible(true);
		
		
		b6.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						String s1,s2,s3,s4,s5;
						s1=t1.getText();
						s2=t2.getText();
						s3=t3.getText();
						s4=t4.getText();
						s5=t5.getText();
						
						try {
							Connection connection =DriverManager.getConnection(databaseURL );
							System.out.println("Connected to ms access.");
							String sql= "INSERT INTO StudentsData (StudentID,StudentName, StudentDateofBirth, MobileNumber, Email) VALUES" + "(?,?,?,?,?)";
							PreparedStatement statement = connection.prepareStatement(sql);
							
							int id=Integer.parseInt(s1);
							
							statement.setInt(1, id);
							statement.setString(2,s2);
							statement.setString(3, s3);
							statement.setString(4,s4);
							statement.setString(5, s5);
							
							
							int rows = statement.executeUpdate();
							
							if(rows>0)
							{
								System.out.println("A new Student data added");
							}
							statement.close();
							connection.close();
							
							t1.setText("");t2.setText("");
							t3.setText("");t4.setText("");
							t5.setText("");
							
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					}
			
				}
				);
		search_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection connection =DriverManager.getConnection(databaseURL );
					System.out.println("Connected to ms access.");
					String sql="SELECT * FROM StudentsData";
					
					Statement statement= connection.createStatement();
					ResultSet result = statement.executeQuery(sql);
					String s1=ts.getText();
					
					boolean flag=false;
					
					while(result.next())
					{
						int id=result.getInt("StudentID");
						String str=Integer.toString(id);
						
						if(s1.equals(str))
						{
							flag=true;
							ot1.setText(str);
							String name=result.getString("StudentName");
							ot2.setText(name);
							String dob=result.getString("StudentDateofBirth");
							ot3.setText(dob);
							String phone=result.getString("MobileNumber");
							ot4.setText(phone);
							String email=result.getString("Email");
							ot5.setText(email);
							break;
							
						}
					}
					if(flag==false)ot1.setText("Sorry, No such Student");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		

	}

}
