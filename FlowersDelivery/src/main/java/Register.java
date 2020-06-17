import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JButton;
import javax.swing.JToggleButton;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	File f = new File("C:\\Users\\lupei\\Documents\\Inregistrarile");
	int ln;
	String Username, Password, Email, Phone, Name, Type;
	private JTextField txtLogin;
	
	
	void createFolder() {
		if(!f.exists())
		{
			f.mkdirs();
	}
	}
	
	void readFile() {
		try {
			FileReader fr = new FileReader(f+"\\logins.txt");
			System.out.println("Fisierul Exista!");
		} catch (FileNotFoundException e) {
			try {
				FileWriter fw = new FileWriter(f+"\\logins.txt");
				System.out.print("Fisier Creat");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	void addData(String usr, String pswd, String mail, String name, String phone, String type) {
		try {
			RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt","rw");
			for(int i=0;i<ln;i++) {
				raf.readLine();
			}
			if(ln>1){
	            raf.writeBytes("\r\n");
	            raf.writeBytes("\r\n");
	            } 
			raf.writeBytes("Username:"+usr+ "\r\n");
			raf.writeBytes("Password:"+pswd+ "\r\n");
			raf.writeBytes("Email:"+mail+ "\r\n");
			raf.writeBytes("Name:"+name+ "\r\n");
			raf.writeBytes("Phone:"+phone+ "\r\n");
			raf.writeBytes("Type:"+type + "\r\n");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void checkData(String usr, String pswd) {
		try {
			RandomAccessFile raf = new RandomAccessFile (f+"\\logins.txt","rw");
			String line = raf.readLine();
			Username=line.substring(9);
			Password=raf.readLine().substring(9);
			Email=raf.readLine().substring(6);
			Name=raf.readLine().substring(5);
			Phone=raf.readLine().substring(6);
			Type=raf.readLine().substring(5);
			if(usr.equals(Username) & pswd.equals(Password)) {
				JOptionPane.showMessageDialog(null, "Parola Potrivita!");
			}else {
				JOptionPane.showMessageDialog(null, "Parola/Nume Gresit!");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	 
	void checkRegister(String usr) {
			try {
				RandomAccessFile raf= new RandomAccessFile (f+"\\logins.txt","rw");
				String line = raf.readLine();
				Username = line.substring(9);
				if(usr.equals(Username)) {
					JOptionPane.showMessageDialog(null, "Numele de utilizator este folost, folositi alt nume!");
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	void countLines() {
		try {
			ln=1;
			RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
			for(int i=0; raf.readLine()!=null;i++) {
				ln++;
			}
			System.out.println("Numarul linie"+ln);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 180, 447, 613);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 26, 139, 38);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("User");
		chckbxNewCheckBox.setBackground(new Color(255, 204, 102));
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setBounds(238, 354, 121, 38);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Flower");
		chckbxNewCheckBox_1.setBackground(new Color(255, 204, 102));
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1.setBounds(46, 354, 121, 38);
		contentPane.add(chckbxNewCheckBox_1);
		setUndecorated(true);
		setPreferredSize(new Dimension(447, 613));
		
		textField = new JTextField();
		textField.setBounds(134, 101, 256, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 189, 256, 32);
		contentPane.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(134, 144, 257, 34);
		contentPane.add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(134, 232, 256, 32);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(134, 275, 256, 32);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 101, 81, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 143, 81, 32);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(10, 187, 81, 32);
		contentPane.add(lblEmail);
		
		JLabel lblFlorarie = new JLabel("Name");
		lblFlorarie.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlorarie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFlorarie.setBounds(10, 232, 81, 32);
		contentPane.add(lblFlorarie);
		
		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhone.setBounds(10, 275, 81, 32);
		contentPane.add(lblPhone);
		
		txtRegister = new JTextField();
		txtRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				createFolder();
				readFile();
				countLines();
				if(chckbxNewCheckBox.isSelected()) {
					addData(textField.getText(),passwordField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),"User");}
				if(chckbxNewCheckBox_1.isSelected()) {
					addData(textField.getText(),passwordField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),"Flower");
				}
				
			}
		});
		txtRegister.setText("REGISTER");
		txtRegister.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegister.setForeground(Color.WHITE);
		txtRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtRegister.setColumns(10);
		txtRegister.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtRegister.setBackground(new Color(255, 153, 0));
		txtRegister.setAlignmentX(0.0f);
		txtRegister.setBounds(150, 450, 154, 29);
		contentPane.add(txtRegister);
		
		JLabel label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		label.setIcon(new ImageIcon(Register.class.getResource("/Exit.png")));
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(418, 0, 40, 29);
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int cordonataX = e.getXOnScreen();
				int cordonataY = e.getYOnScreen();
				
				setLocation(cordonataX, cordonataY); 
			}
		});
		lblNewLabel_2.setBounds(10, 0, 398, 29);
		contentPane.add(lblNewLabel_2);
		
		txtLogin = new JTextField();
		txtLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login_Register rgf = new Login_Register();
				rgf.setVisible(true);
				rgf.pack();
				rgf.setLocationRelativeTo(null);
				rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		txtLogin.setText("LOGIN");
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setForeground(Color.WHITE);
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtLogin.setColumns(10);
		txtLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtLogin.setBackground(new Color(255, 102, 102));
		txtLogin.setAlignmentX(0.0f);
		txtLogin.setBounds(46, 529, 154, 29);
		contentPane.add(txtLogin);
		
		
		
		
	}
}	

