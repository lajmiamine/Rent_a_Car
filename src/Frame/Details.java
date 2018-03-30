package Frame;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;



@SuppressWarnings("serial")
public class Details extends JFrame {
	private String fileName="0000";
	 private JTextArea jta = new JTextArea();
	  private JButton save = new JButton("Save");
	public Details(){
	    this.setVisible(true);
	    setTitle("Cars Features");
		this.setSize(400, 275);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(255, 255, 247));
		jta.setBounds(new Rectangle(11, 17, 375, 178));
		jta.setForeground(Color.blue);
	    this.getContentPane().setLayout(null);
	    save.setBounds(new Rectangle(141, 211, 126, 28));
	    this.getContentPane().add(jta, null);
	    this.getContentPane().add(save, null);
	    
	    save.addActionListener(new java.awt.event.ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        save_actionPerformed(e);
		      }
		    });
	}
  
	public void setFile(String n){fileName=n+".txt";}
	
	
	public void creat(){

	    File directory=new File("Details");   
	    if(!directory.exists())directory.mkdir();
	    File f1=new File(directory,fileName);  

	    if(!f1.exists()){
	      try{
	      PrintWriter fich=new PrintWriter(new FileWriter(f1));
	      fich.println(jta.getText());
	      fich.close();
	      }catch(IOException e){}
	    }
	  }
	
	
	void view(String l){
	  if(jta.isEditable()==true)jta.setEditable(false);
	  if(save.isEnabled()==true)save.setEnabled(false);
	  jta.append(l);
	  jta.append("\n");
	}
	
	@SuppressWarnings("deprecation")
	void save_actionPerformed(ActionEvent e) {
		creat();
		this.hide();}


}
