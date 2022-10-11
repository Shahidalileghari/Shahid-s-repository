import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;



                 public class Employee 
                 {

	public JFrame frame;
	private JTextField jtEmpID;
	private JLabel lblEmpnic;
	private JTextField EmpNIC;
	private JLabel lblNewLabel_2;
	private JLabel lblName;
	private JTextField Name;
	private JTextField SurName;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblGender;
	private JTextField Gender;
	private JTextField DOB;
	private JTextField Age;
	private JTextField Salarry;
	private JButton btnReset;
	private JButton btnNewButton_2;

	
             Connection conn=null;
	 
	 PreparedStatement pst=null;
	  
	   ResultSet rs=null;
	   
	   DefaultTableModel model=new DefaultTableModel();
	   private JTable table;
	   

	
	                        public void updateTable()
	                          {
		 conn = EmployeeData.connectdata();
		 
		if (conn!=null) {
			 
			 
			 String sql=  "select * from emptable" ;
			 try {
				 
				 pst=conn.prepareStatement(sql);
				 
				 rs=pst.executeQuery();
				 
				 Object[] columndata=new Object[8];
				 
				 while (rs.next()) {
					 
					 columndata[0]=rs.getString("Id");
					 columndata[1]=rs.getString("Name");
					 columndata[2]=rs.getString("NIC");
					 columndata[3]=rs.getString("Surname");
					 columndata[4]=rs.getString("Gender");
					 columndata[5]=rs.getString("DoB");
					 columndata[6]=rs.getString("Age");
					 columndata[7]=rs.getString("Salary");
					 
					 model.addRow(columndata);
					 
					 
	
					
				}
				
			} 
			 
			 
			 catch (Exception e) {
				
				 JOptionPane.showMessageDialog(null, e);
				 
				 
			}		
		}
	}
	   
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
					window.frame.setVisible(true);
					window.frame.setTitle("EMPLOYEE MANAGE");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Employee() {
		initialize();
		
		 conn = EmployeeData.connectdata();
		 if(!Name.getText().equals("shahid")) {
		 Object col[]= {"EmpId","Name","EmpNIC","SurName","Gender","DoB","Age","Salary"};
		 model.setColumnIdentifiers(col);
		 }
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EmpId");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(90, 91, 169, 30);
		frame.getContentPane().add(lblNewLabel);
		
		jtEmpID = new JTextField();
		jtEmpID.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtEmpID.setBounds(235, 90, 206, 33);
		frame.getContentPane().add(jtEmpID);
		jtEmpID.setColumns(10);
		
		JButton btnNewButton = new JButton("AddNew");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if("".equals(jtEmpID.getText()) || "".equals(Name.getText())|| "".equals(EmpNIC.getText())||"".equals(SurName.getText())
						||"".equals(Gender.getText())||"".equals(DOB.getText())||"".equals(Age.getText())||"".equals(Salarry.getText())) {
					JOptionPane.showMessageDialog(frame, "You can't have empty fields ");
				}
				else {
					try {		
						Connection conn = EmployeeData.connectdata();
						String sql ="INSERT INTO `emptable`(`Id`, `Name`, `NIC`, `Surname`, `Gender`, `DoB`, `Age`, `Salary`) VALUES (?,?,?,?,?,?,?,?)";
						PreparedStatement pst=conn.prepareStatement(sql);
						
						pst.setString(1, jtEmpID.getText());
						pst.setString(2, Name.getText());
						pst.setString(3, EmpNIC.getText());
						pst.setString(4, SurName.getText());
						pst.setString(5, Gender.getText());
						pst.setString(6, DOB.getText());
						pst.setString(7, Age.getText());
						pst.setString(8, Salarry.getText());
						
						pst.execute();
						

						conn.close();
						}
					catch (Exception e2) 
					{
			        e2.printStackTrace();
					}

					DefaultTableModel model=(DefaultTableModel) table.getModel();
					
					model.addRow(new Object[] {
						 jtEmpID.getText(),
						 Name.getText(),
						 EmpNIC.getText(),
						 SurName.getText(),
						 Gender.getText(),
						 DOB.getText(),
						 Age.getText(),
						Salarry.getText(),
						
					});
					
					if(table.getSelectedRow()==-1)
					{
						if(table.getRowCount()==0)
						{
							Object EmptyStackException=0;
							if (table.equals(EmptyStackException)) {
								JOptionPane.showMessageDialog(null, "Data is not filled");
							}
							JOptionPane.showMessageDialog(null, "Membership update confirmed","Employee database sytsem"
							
							,JOptionPane.OK_OPTION);
						}
					}
					
					}
			}
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(75, 572, 144, 47);
		frame.getContentPane().add(btnNewButton);
		
		lblEmpnic = new JLabel("EmpNIC");
		lblEmpnic.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmpnic.setBounds(90, 132, 169, 30);
		frame.getContentPane().add(lblEmpnic);
		
		EmpNIC = new JTextField();
		EmpNIC.setFont(new Font("Tahoma", Font.BOLD, 18));
		EmpNIC.setColumns(10);
		EmpNIC.setBounds(235, 130, 206, 33);
		frame.getContentPane().add(EmpNIC);
		
		lblNewLabel_2 = new JLabel("SurName");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(90, 214, 169, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(90, 173, 169, 30);
		frame.getContentPane().add(lblName);
		
		Name = new JTextField();
		Name.setFont(new Font("Tahoma", Font.BOLD, 18));
		Name.setColumns(10);
		Name.setBounds(235, 172, 206, 33);
		frame.getContentPane().add(Name);
		
		SurName = new JTextField();
		SurName.setFont(new Font("Tahoma", Font.BOLD, 18));
		SurName.setColumns(10);
		SurName.setBounds(235, 212, 206, 33);
		frame.getContentPane().add(SurName);
		
		lblNewLabel_4 = new JLabel("Salary");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(90, 381, 169, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Age");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(90, 340, 169, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("DoB");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(90, 299, 169, 30);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGender.setBounds(90, 255, 169, 30);
		frame.getContentPane().add(lblGender);
		
		Gender = new JTextField();
		Gender.setFont(new Font("Tahoma", Font.BOLD, 18));
		Gender.setColumns(10);
		Gender.setBounds(235, 256, 206, 33);
		frame.getContentPane().add(Gender);
		
		DOB = new JTextField();
		DOB.setFont(new Font("Tahoma", Font.BOLD, 18));
		DOB.setColumns(10);
		DOB.setBounds(235, 297, 206, 33);
		frame.getContentPane().add(DOB);
		
		Age = new JTextField();
		Age.setFont(new Font("Tahoma", Font.BOLD, 18));
		Age.setColumns(10);
		Age.setBounds(235, 339, 206, 33);
		frame.getContentPane().add(Age);
		
		Salarry = new JTextField();
		Salarry.setFont(new Font("Tahoma", Font.BOLD, 18));
		Salarry.setColumns(10);
		Salarry.setBounds(235, 379, 206, 33);
		frame.getContentPane().add(Salarry);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtEmpID.setText(null);
				Name.setText(null);
				EmpNIC.setText(null);
				SurName.setText(null);
				Gender.setText(null);
				DOB.setText(null);
				Age.setText(null);
				Salarry.setText(null);
			
				
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(352, 572, 144, 47);
		frame.getContentPane().add(btnReset);
		
		btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame=new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame,"confirm if you want to exit","Employee management system"
						,JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
					
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(616, 572, 139, 47);
		frame.getContentPane().add(btnNewButton_2);
		


		
		JLabel lblNewLabel_1 = new JLabel("   Employee Management database");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(321, 11, 565, 47);
		frame.getContentPane().add(lblNewLabel_1);
		
		table = new JTable();
		table.setForeground(UIManager.getColor("Button.shadow"));
		table.setFont(new Font("Arial Black", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"EmID", "EmNIC", "Name", "Surname", "Gender", "DOB", "Age", "Salary"
			}
		));
		table.setBounds(505, 91, 828, 320);
		frame.getContentPane().add(table);
	}
}
