import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Login_Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField txtLogin;
	private JTextField txtRegister;
	private JLabel lblPass;
	private JLabel lblNewLabel_1;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Register frame = new Login_Register();
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
			if(ln>0){
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
	
	void logic(String usr, String pswd, String typ) {
		try {
			RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt","rw");
			for(int i=0;i<ln;i+=8) {
				String forUser = raf.readLine().substring(9);
				String forPswd = raf.readLine().substring(9);
				String forType = raf.readLine().substring(5);
				if(usr.contentEquals(forUser) & pswd.equals(forPswd)) {
					JOptionPane.showMessageDialog(null, "Corect");
					UserInt rgf = new UserInt();
					rgf.setVisible(true);
					rgf.pack();
					rgf.setLocationRelativeTo(null);
					rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dispose();
					break;
				}else if(i==(ln-7)){
					JOptionPane.showMessageDialog(null, "Incorect");
					break;
				}
				for(int k=1;k<=6;k++) {
					raf.readLine();
				}
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
	public Login_Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 180, 629, 360);
		setPreferredSize(new Dimension(629, 360));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(206, 97, 285, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(206, 170, 285, 29);
		contentPane.add(passwordField);
		
		txtLogin = new JTextField();
		txtLogin.setEditable(false);
		txtLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createFolder();
				readFile();
				countLines();
				logic(textField.getText(),passwordField.getText(),"user");
			}
		});
		txtLogin.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtLogin.setForeground(new Color(255, 255, 255));
		txtLogin.setBackground(new Color(255, 153, 0));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setText("LOGIN");
		txtLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLogin.setBounds(206, 242, 121, 29);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtRegister = new JTextField();
		txtRegister.setEditable(false);
		txtRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register rgf = new Register();
				rgf.setVisible(true);
				rgf.pack();
				rgf.setLocationRelativeTo(null);
				rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		txtRegister.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtRegister.setForeground(new Color(255, 255, 255));
		txtRegister.setBackground(new Color(255, 102, 51));
		txtRegister.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegister.setText("REGISTER");
		txtRegister.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRegister.setColumns(10);
		txtRegister.setBounds(370, 242, 121, 29);
		contentPane.add(txtRegister);
		
		lblPass = new JLabel("");
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setIcon(new ImageIcon(Login_Register.class.getResource("/Cheie.png")));
		lblPass.setBounds(140, 159, 64, 57);
		contentPane.add(lblPass);
		
		lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(245, 26, 173, 44);
		contentPane.add(lblNewLabel_1);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login_Register.class.getResource("/User.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(140, 81, 64, 57);
		contentPane.add(label_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(Login_Register.class.getResource("/Exit.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(599, 0, 40, 29);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int cordonataX = e.getXOnScreen();
				int cordonataY = e.getYOnScreen();
				
				setLocation(cordonataX, cordonataY); 
				
			}
		});
		lblNewLabel_2.setBounds(10, 0, 579, 29);
		contentPane.add(lblNewLabel_2);
		
		setUndecorated(true); //pentru a scoate marginile ferestrei de login
		
	}
	
	
}
