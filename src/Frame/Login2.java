package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;
import javax.swing.*;

import personnel.Client;

public class Login2 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -943988002748119083L;
	JPanel panel = new JPanel();
	JLabel loginLab = new JLabel("User Name:");
        JLabel passLab = new JLabel("Password:");
	
	JTextField login = new JTextField();
	JPasswordField passwd = new JPasswordField();
	
        JButton btnLogin=new JButton("Login");
	Vector<?> v;
	int i;
	Client client;
	public Login2(){
		this.addWindowListener(new GestioneFrame());
		setTitle("Login");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setContentPane(panel);
		this.getContentPane().setBackground(new Color(238,238,238));
		setLayout(null);
		
		
		
                
                login.setBounds(new Rectangle(130, 50, 130, 30));
                
                login.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
                
                loginLab.setBounds(new Rectangle(40, 50, 100, 30));
                
                loginLab.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
                
		passwd.setBounds(new Rectangle(130, 110, 130, 30));
                
                passwd.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
                
                passLab.setBounds(new Rectangle(40, 110, 100, 30));
                
                passLab.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
                
                btnLogin.setBounds(new Rectangle(190, 190, 100, 30));
                
                btnLogin.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
                
                add(loginLab);
                add(passLab);
                add(login);
		add(passwd);
                add(btnLogin);
		
		btnLogin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
                
                if(e.getSource() ==btnLogin){
                    this.setVisible(false);
                    dispose();
                    FrameCliente homepage = new FrameCliente();
                    homepage.setVisible(true);
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
