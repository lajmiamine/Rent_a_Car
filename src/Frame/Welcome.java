package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


    @SuppressWarnings("serial")
	class Welcome1 extends JFrame {
    	//private JMenuItem esci = new JMenuItem("esci");
    	JPanel panel = new JPanel();
    	JButton client = new JButton("Client");
	     JButton agent = new JButton("Agent");
	     JButton close = new JButton("Exit");
	  public Welcome1 () {
		 setTitle ("Rnetal Car Agency") ;
	     this.setSize(new Dimension(700, 600));
	     this.setLocationRelativeTo(null);
	     this.setResizable(false);
	     this.setContentPane(new Pannel());
	     
	     Container c = 	getContentPane();
	     c.setLayout(null) ;
	     client.setBounds(250, 470, 100, 40);
             client.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
	     agent.setBounds(360, 470, 100, 40);
             agent.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
	     //close.setBounds(225, 500, 310, 50);
	     c.add(client) ;
	     c.add(agent);
	     c.add(close);
	    
	     
	    
		client.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				ClientAccess ac = new ClientAccess();
				ac.setVisible(true);
				dispose();
				}		
			});
		
		agent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				FrameEmployee fd = new FrameEmployee();		
				
				fd.setVisible(true);
				
			}				
		});
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0); 						
			}
		});
	 
		  
	  }
	
}
    
public class Welcome{
	public static void main(String[] args){
		Welcome1 fin = new Welcome1();
		fin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fin.setVisible(true);
	}
}
	
	@SuppressWarnings("serial")
	class Pannel extends JPanel{  
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			GradientPaint gp = new GradientPaint(0, 0, Color.cyan, 30, 30, Color.pink, true);
			g.setColor(Color.black);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
                g.setFont(new Font("Segoe UI Light", Font.BOLD, 28));
            gp = new GradientPaint(-40, -40, Color.yellow, 100, 100, Color.white, false);
            g2d.setPaint(gp);
            g.drawString("Rental Car Agency !!!",40, 30);
            Image img;
		     try {
				 img = ImageIO.read(new File("/recources/splash2.png"));
				 g.drawImage(img, 70, 90, this);
			} catch (IOException e) {
				e.printStackTrace();
		    }
           
            
    }   
		
	}


   