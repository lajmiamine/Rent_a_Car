package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;

import javax.swing.*;

import personnel.Client;

@SuppressWarnings("serial")
public class ClientAccess extends JFrame implements ActionListener{
	JPanel panel = new JPanel();
	JLabel l1 = new JLabel();
	
	JButton login = new JButton("Login");
	JButton register = new JButton("Register");
	
	private JTextArea jta = new JTextArea();
	private JTextArea jta2 = new JTextArea();
        JLabel registerPic= new JLabel();
        JLabel loginPic= new JLabel();
        JButton btnHome=new JButton();
	Vector<?> v;
	int i;
	Client client;
	public ClientAccess(){
		this.addWindowListener(new GestioneFrame());
		setTitle("Clients");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setContentPane(panel);
		this.getContentPane().setBackground(new Color(238,238,238));
		setLayout(null);
		jta.setFont(new java.awt.Font("Serif", 1, 16));
		jta.setText("If you are already registered, please click below for proceeding");
                jta.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jta.setForeground(Color.black);
                jta.setBackground(new Color(238,238,238));
		jta.setLineWrap(true);  
		jta.setWrapStyleWord(true);
		jta.setEditable(false);
		jta.setBounds(70, 10, 250, 50);
		jta2.setFont(new java.awt.Font("Serif", 1, 16));
                jta2.setText("If you are not registered, please click below to register");
                jta2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jta2.setForeground(Color.black);
		jta2.setBackground(new Color(238,238,238));
		jta2.setLineWrap(true);   
		jta2.setWrapStyleWord(true);
		jta2.setEditable(false);
		jta2.setBounds(70, 130, 250, 50);
		l1.setBounds(30, 215, 80, 20);
		l1.setForeground(Color.red);
		
                
                login.setBounds(new Rectangle(115, 70, 115, 30));
                
                login.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
                
		register.setBounds(new Rectangle(115, 190, 115, 30));
                
                
                register.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
                
                
                loginPic.setBounds(80, 70, 30, 30);
                
                ImageIcon img=null;
		     try {
				 img = new ImageIcon(ImageIO.read(new File("C:/Users/dell/Documents/NetBeansProjects/rent/src/Frame/login.png")));
			} catch (IOException e) {
				e.printStackTrace();
		    }
		
                loginPic.setIcon(img);
                add(loginPic);
                
                registerPic.setBounds(80, 190, 30, 30);
                
                ImageIcon img1=null;
		     try {
				 img1 = new ImageIcon(ImageIO.read(new File("C:/Users/dell/Documents/NetBeansProjects/rent/src/Frame/register.png")));
			} catch (IOException e) {
				e.printStackTrace();
		    }
		
                registerPic.setIcon(img1);
                add(registerPic);
                
               
                
                ImageIcon img2=null;
                
                try {
				 img2 = new ImageIcon(ImageIO.read(new File("C:/Users/dell/Documents/NetBeansProjects/rent/src/Frame/home.png")));
			} catch (IOException e) {
				e.printStackTrace();
		    }
                     
                
                btnHome.setIcon(img2);
                btnHome.setBounds(345, 225, 40, 40);
                btnHome.addActionListener(this);
                add(btnHome);
                     
		add(jta);
		add(jta2);
		add(l1);
		add(login);
		add(register);
		
		login.addActionListener(this);
		register.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){
			dispose();
			
					Login2  fc = new Login2();		
                                        fc.setVisible(true);
				
		}
		if(e.getSource()==register){
			dispose();
			Rent p = new Rent();
			p.setVisible(true);
		}
                
                if(e.getSource() ==btnHome){
                    Welcome1 fdte = new Welcome1();
                    fdte.setVisible(true);
                }
	}
	
	
	class GestioneFrame implements WindowListener{

		   public void windowClosing( WindowEvent e)
		       {Welcome1 w = new Welcome1();w.setVisible(true);}
		    public void windowOpened(WindowEvent e){}
		    public void windowClosed(WindowEvent e){}
		    public void windowDeiconified(WindowEvent e){}
		    public void windowDeactivated(WindowEvent e){}
		    public void windowActivated(WindowEvent e){}
		    public void windowIconified(WindowEvent e){}
		}

}
