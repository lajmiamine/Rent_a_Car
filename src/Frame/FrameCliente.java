package Frame;
import personnel.RentedVehicul;
import personnel.Vehicul;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;

@SuppressWarnings("serial")
public class FrameCliente extends JFrame implements ActionListener{
	
	private JPanel panel = new JPanel(new GridLayout(5,1));
	
	private JButton restor = new JButton("Return  car");
	
	private JButton search1 = new JButton("Search by Make");
	private JButton search2 = new JButton("Search by Price");
	
	private JButton menu = new JButton("Return to Home page");
	
	private JButton exit = new JButton("Exit");
	
	//private JLabel label = new JLabel("Costumers Space");
	
	RentedVehicul rented; 
	int indice;
	public FrameCliente(){
		setTitle("Client Area");
		setSize(300, 400);
	     this.setLocationRelativeTo(null);
	     this.setResizable(true);
	     setContentPane(panel);
	     this.getContentPane();
	     panel.setBackground(Color.white);
	    
            restor.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
            search1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
            search2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
            menu.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
            exit.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
            //label.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
	    
	    add(restor);
	    add(search1);
	    add(search2);
	    add(menu);
	    add(exit);
	    //add(label);
	    
	    exit.addActionListener(this);
	    menu.addActionListener(this);
	    search1.addActionListener(this);
	    search2.addActionListener(this);
	   
	    restor.addActionListener(this);
		
	   
		
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit){
			System.exit(0);
			
		}
		if(e.getSource() == menu){
			Welcome1 w1 = new Welcome1();
			w1.setVisible(true);
			dispose();
		}
		
		if(e.getSource() == restor){
			GestioneFile gf = new GestioneFile();
			String code = JOptionPane.showInputDialog(this, "Enter the code of the Cars", "Code", JOptionPane.INFORMATION_MESSAGE);
			 
			 Vector<?> vFind = new Vector<Object>();
			vFind=gf.ReadFile("autoRented.dat");  
				 rented = new RentedVehicul();
				boolean trouver=false;
				  indice=0;
				 
				 rented = null;
				
					while((!trouver)&&(indice<vFind.size()) &&(code!=null)){
				   		rented=(RentedVehicul)vFind.elementAt(indice);
				    	if(code.equals(rented.getVinNumber())){
				    		trouver=true;
				    		
				    			Date data = new Date();
				    			Date date = rented.getReleaseDate();
				    			int dataP = date.getDate();
				    			int dataR = data.getDate();
				    			int price =Integer.parseInt(rented.getPrice());
				    			int priceTot = ((dataR-dataP)+1)*price;
				    			int response = JOptionPane.showConfirmDialog(null,"Hello"+rented.getNameC()+"\n"+"Confirm return ?","QUESTION",JOptionPane.YES_NO_OPTION);
								if(response==JOptionPane.YES_OPTION){
									
									vFind.removeElementAt(indice);
						    		try{gf.Scrivi(vFind,"update","autoRented.dat");}catch(IOException ex){ JOptionPane.showInternalMessageDialog(null,"An error has occurred","Error",JOptionPane.ERROR_MESSAGE); }
						    		JOptionPane.showMessageDialog(null,"PAY THE AMOUNT OF = "+priceTot+"\n"+"Thank you","Information", JOptionPane.INFORMATION_MESSAGE);
							     }
				    	}
				      	else indice++;
				 
					}
					if(!trouver) JOptionPane.showMessageDialog(null, "Car not found.","Information", JOptionPane.INFORMATION_MESSAGE); 
				 
			
			
		}
		if(e.getSource() == search1){
				SearchByMake rpm = new SearchByMake();
				rpm.setVisible(true);
			dispose();
		}
		if(e.getSource() == search2){
			SerchByPrice  rpp = new SerchByPrice ();
			rpp.setVisible(true);
			dispose();
		}
	}
	
	public class SearchByMake extends JFrame implements ActionListener{
		JPanel p = new JPanel();
		JLabel label = new JLabel("SELECT THE DESIRED BRAND");
		private String []TMake={"BMW","Chevrolet","Citroén","Dacia","Ferrari","Fiat","Ford","Lamborghini","Maserati","Mercedes","Peugeot","Porsche","Renault","Rover"};
		JTextArea jtf = new JTextArea();
		JButton search = new JButton("Start Search");
		JButton cancel = new JButton("Cancel");
		JComboBox<?> jcsearch = new JComboBox<Object>(TMake);
		
		Vehicul car;
		Vehicul car1;
		
		public  SearchByMake(){
			this.setTitle("Search");
			this.setSize(400, 300);
			this.setLocationRelativeTo(null);
			this.setContentPane(p);
			this.setLayout(null);
                        this.getContentPane().setBackground(new Color(238,238,238));
			jtf = new JTextArea();
			jtf.setForeground(Color.red);
                        jtf.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			jtf.setLineWrap(true);  
			jtf.setWrapStyleWord(true);
			jtf.setEditable(false);
			label.setBounds(90, 10, 450, 20);
                        label.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			jcsearch.setBounds(30, 50, 300, 30);
                        jcsearch.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			
			jtf.setBounds(0, 130, 400, 80);
			
			
			cancel.setBounds(150, 220, 100, 30);
                        cancel.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			search.setBounds(125, 90, 150, 30);
                        search.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			
			add(jcsearch);
			add(label);
			add(jtf);
			add(cancel);
			add(search);
			
			search.addActionListener(this);
			cancel.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent ev) {
			if(ev.getSource() == cancel) {
				dispose();
				FrameCliente fc = new FrameCliente();
				fc.setVisible(true);
			}
			else if(ev.getSource()==search){
				GestioneFile gf = new GestioneFile();
				Vector<?> vControl =new Vector<Object>();
				vControl = gf.ReadFile("DBauto.dat");
				Vector<Vehicul> vtrouver = new Vector<Vehicul>(vControl.size());
				
				
				indice=0;
				 @SuppressWarnings("unused")
				boolean trouver=false;
				   car=null;
				  
				  String cost = (String)String.valueOf((String)jcsearch.getSelectedItem());
				 while((indice<vControl.size())){
				   car=(Vehicul)vControl.elementAt(indice);
				   if(cost.equals(car.getMaker())){
					   trouver=true;
					   
					   
				   	   vtrouver.addElement(car);	
				   } indice++;
				   	
				 }
				if(vtrouver.isEmpty()){
					jtf.setText("NO ITEM FOUND, MAKE ANOTHER SEARCH");
				}else{
					try{gf.Scrivi(vtrouver,"","Research.dat");}catch(IOException ex){ JOptionPane.showInternalMessageDialog(null,"An error has occurred","Error",JOptionPane.ERROR_MESSAGE); }
					 
					SearchPannel pr = new SearchPannel();
					pr.setVisible(true);
					
					}
			}else{}
		}
	}
	
	
	public class SerchByPrice extends JFrame implements ActionListener{
		JPanel p = new JPanel();
		JLabel label = new JLabel("SELECT A PRICE RANGE");
		private String []TDa={"From","25","50","100","150","200","300","500"};
		private String []TA={"To","50","100","150","200","300","500"};
		JTextArea jta = new JTextArea();
		JButton search = new JButton("Start Search");
		JButton cancel = new JButton("Cancel");
		JComboBox<?> da = new JComboBox<Object>(TDa);
		JComboBox<?> a = new JComboBox<Object>(TA);
		
		String max,min;
		int maxint,minint;
		Vehicul car;
		public SerchByPrice (){
			this.setTitle("Search");
			this.setSize(400, 300);
			this.setLocationRelativeTo(null);
			this.setContentPane(p);
			this.setLayout(null);
                        this.getContentPane().setBackground(new Color(238,238,238));
			
			jta.setForeground(Color.red);
                        jta.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			jta.setEditable(false);
			label.setForeground(Color.black);
                        label.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			label.setBounds(100, 10, 450, 20);
			da.setBounds(100, 50, 75, 30);
                        da.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			a.setBounds(190, 50, 75, 30);
                        a.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			jta.setBounds(0, 130, 400, 80);
			
			cancel.setBounds(150, 220, 100, 30);
                        cancel.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			search.setBounds(125, 90, 150, 30);
                        search.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
			
			add(label);
			add(da);
			add(a);
			add(cancel);
			add(search);
			add(jta);
			
			cancel.addActionListener(this);
			search.addActionListener(this);
			
			
		}

		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==cancel){
				dispose();
				FrameCliente fc = new FrameCliente();
				fc.setVisible(true);
			}
			else{
				GestioneFile gfile = new GestioneFile();
				min=(String)String.valueOf((String)da.getSelectedItem());
				max=(String)String.valueOf((String)a.getSelectedItem());
				Vector<?> vScaner = new Vector<Object>();
				Vector<Vehicul> vtrouver = new Vector<Vehicul>();
				vScaner = gfile.ReadFile("DBauto.dat");
				
				int i =0;
				car=null;
				maxint = Integer.parseInt(max);
				minint = Integer.parseInt(min);
				if((min.compareTo("From")!=0) && (max.compareTo("To")!=0))
					while(i<vScaner.size()){
						car=(Vehicul)vScaner.elementAt(i);
						int carint = Integer.parseInt(car.getPrice());
						if(maxint>=minint){
							if((carint>=minint) && (carint<=maxint)){
								vtrouver.addElement(car);
							}
						}else {
							if((carint>=maxint) && (carint<=minint)){
								
								vtrouver.addElement(car);
							}
						}
						i++;
					}
				else jta.setText("Select the price range");
				 
				if(vtrouver.isEmpty()){
					jta.setText("NO ITEM FOUND, MAKE ANOTHER SEARCH");
				}else{
					try{gfile.Scrivi(vtrouver,"","Research.dat");}catch(IOException ex){ JOptionPane.showInternalMessageDialog(null,"An error has occured","Error",JOptionPane.ERROR_MESSAGE); }
					 
					jta.setText("");
					SearchPannel pr = new SearchPannel();
					pr.setVisible(true);
				}
				
				
			}
			
		}

		
	}
}

