package Frame;

import personnel.RentedVehicul;
import personnel.Client;
import personnel.Vehicul;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;

import javax.swing.*;




@SuppressWarnings("serial")
public class FrameEmployee extends JFrame implements ActionListener{
	JPanel panel = new JPanel();
	JTable tab = new JTable();
	JButton rent = new JButton("Rent Car");
	JButton ret = new JButton("Return");
	JButton newCar = new JButton("Enter new car");
	JButton cancel = new JButton("Delete car");
	JButton listauto = new JButton("Visualize Car List");
	JButton dispo = new JButton("AutoDispo");
	JButton nondispo = new JButton("AutoNondispo");
	JButton searchClient = new JButton("Search a Client");
	JButton home = new JButton();
	JButton exit = new JButton("exit");
	
	JLabel label1= new JLabel("Protected area: EXCLUSIVELY RESERVED TO STAFF");
	
	JLabel make = new JLabel("Maker");
	JLabel color = new JLabel("Color");
	JLabel price = new JLabel("Price");
	JLabel vinNumber = new JLabel("Vin Number*");
	JLabel mileage = new JLabel("Mileage ");
	
	JTextField jtfmileage= new JTextField();
	JTextField jtfmake = new JTextField();
	JTextField jtfcolor = new JTextField();
	JTextField jtfprice = new JTextField();
	JTextField jtfn_im = new JTextField();
	JTextField date = new JTextField();
	JTextArea jtf2;
	JTextArea jtf1;
	private String []Tmake={"BMW","Chevrolet","Citroén","Dacia","Ferrari","Fiat","Ford","Lamborghini","Maserati","Mercedes","Peugeot","Porsche","Renault","Rover"};
	JComboBox<?> jcmake = new JComboBox<Object>(Tmake);
	private String []TColor={"Silver","Blue","White","Red","Black"};
	JComboBox<?> jcColor = new JComboBox<Object>(TColor);
	
	JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
	JPanel onglet1 = new JPanel();
	JPanel onglet2 = new JPanel();
	Object title[] = {"Maker","color","Price / Day","Vin Number","dispo"};
	
	
	Vehicul vehicul;
	int indice;
	GestioneFile gf;
	RentedVehicul rentedCar ;
	public FrameEmployee(){
		super();
		this.setTitle("Personal Company");
		this.setSize(700,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(255, 255, 247));
		
		onglet1.setLayout(null);
		onglet2.setLayout(new BorderLayout());
		panel.add(onglets);
		this.getContentPane().add(panel, null);
		label1.setForeground(Color.red);
		/*jtf1 = new JTextArea();
		jtf1.setLineWrap(true);   
		jtf1.setWrapStyleWord(true);
		jtf1.setEditable(false);
		jtf1.setBounds(220, 175, 200, 128);
		//jtf1.setBackground(Color.red);
		jtf1.setForeground(Color.black);
		jtf1.setText(" To return or to cancel a car, ONLY enter the registration number of the car");*/
                JLabel blopLab=new JLabel();
                
                ImageIcon img1=null;
		     try {
				 img1 = new ImageIcon(ImageIO.read(new File("C:/Users/dell/Documents/NetBeansProjects/rent/src/Frame/blop.png")));
			} catch (IOException e) {
				e.printStackTrace();
		    }
                     
                blopLab.setIcon(img1);
                blopLab.setBounds(290, 225, 170, 130);
                
                onglet1.add(blopLab);
                
                
                
		jtf2 = new JTextArea();
		jtf2.setBackground( new Color(238, 238, 238) );
		jtf2.setForeground(Color.black);
		jtf2.setText("Fill in the fields mentioned below and click INSERT / RENT A CAR / RETURN");
		jtf2.setLineWrap(true);        
		jtf2.setWrapStyleWord(true);  
		jtf2.setEditable(false);
		jtf2.setBounds(300, 50, 250, 50);
		
		jtfn_im.setBounds(300, 200, 200, 20);
		vinNumber.setBounds(180, 200, 125, 20);
		jtfprice.setBounds(300, 170, 200, 20);
		price.setBounds(200, 175, 80, 20);
		jcColor.setBounds(300, 140, 150, 20);
		
		color.setBounds(200, 145, 80, 20);
		jcmake.setBounds(new Rectangle(300, 110, 175, 20));
		
		make.setBounds(200, 110, 80, 20);
		label1.setBounds(130, 0, 350, 40);
		
		listauto.setBounds(170, 300, 100, 30);
		mileage.setBounds(new Rectangle(10, 40, 115, 20));
		jtfmileage.setBounds(new Rectangle(140, 35, 50, 30));
		jtfmileage.setEditable(false);
		newCar.setBounds(20, 90, 150, 30);
		rent.setBounds(20, 130, 150, 30);
		ret.setBounds(20, 170, 150, 30);
		searchClient.setBounds(20, 210, 150, 30);
		cancel.setBounds(20, 253, 150, 30);
		date.setBounds(250, 360, 200, 40);
		
                
                dispo.setBounds(20, 310, 150, 30);
		nondispo.setBounds(20, 350, 150, 30);
		exit.setBounds(20, 390, 75, 30);
                
                JLabel sep= new JLabel();
                sep.setBounds(0, 294, 170, 1);
                
                ImageIcon img2=null;
		     try {
				 img2 = new ImageIcon(ImageIO.read(new File("C:/Users/dell/Documents/NetBeansProjects/rent/src/Frame/color.png")));
			} catch (IOException e) {
				e.printStackTrace();
		    }
                     
                sep.setIcon(img2);
                
                
                onglet1.add(sep);
                
		home.setBounds(550, 400, 40, 40);
                ImageIcon img=null;
		     try {
				 img = new ImageIcon(ImageIO.read(new File("C:/Users/dell/Documents/NetBeansProjects/rent/src/Frame/home.png")));
			} catch (IOException e) {
				e.printStackTrace();
		    }
                     
                home.setIcon(img);
		onglet1.setPreferredSize(new Dimension(600, 450));
		date.setEditable(false);
		Date data = new Date();
		date.setText((String)String.valueOf(data));
		
		onglet1.add(dispo);
		onglet1.add(nondispo);
		onglet1.add(date);
		onglet1.add(cancel);
		onglet1.add(mileage);
		onglet1.add(jtfmileage);
		onglet1.add(vinNumber);
		onglet1.add(jtfn_im);
		//onglet1.add(jtf1);
		onglet1.add(jtf2);
		onglet1.add(color);
		onglet1.add(jcColor);
		onglet1.add(price);
		onglet1.add(jtfprice);
		onglet1.add(jcmake);
		onglet1.add(make);
		onglet1.add(label1);
		onglet1.add(newCar);
		onglet1.add(searchClient);
		onglet1.add(ret);
		onglet1.add(exit);
		onglet1.add(home);
		onglet1.add(rent);
		
		onglets.addTab( "Operations", onglet1);
		onglets.addTab("Display Cars", onglet2);
		
		dispo.addActionListener(this);
		nondispo.addActionListener(this);
		cancel.addActionListener(this);
		rent.addActionListener(this);
		listauto.addActionListener(this);
		newCar.addActionListener(this);
		searchClient.addActionListener(this);
		ret.addActionListener(this);
		exit.addActionListener(this);
		home.addActionListener(this);
		
		gf = new GestioneFile();
		Vector<?> v = new Vector<Object>();
		vehicul = new Vehicul();
		v=gf.ReadFile("DBauto.dat");
		int n = v.size();
		String s=Integer.toString(n);
		jtfmileage.setText(s);
		
		CarList();
		
		rent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(jtfprice.getText().equals("") || jtfn_im.getText().equals("")) 
					JOptionPane.showMessageDialog(null, "FILL ALL FIELDS ","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
				else{
					RentedVehicul rentedCar = new RentedVehicul();
					GestioneFile gf = new GestioneFile();
					String code = JOptionPane.showInputDialog(null, "Enter Coustumer Code", "Code", JOptionPane.INFORMATION_MESSAGE);
					
					Vector<RentedVehicul> vRentedCar = new Vector<RentedVehicul>(1);
					Vector<?> vAuto = new Vector<Object>();
					Vector<?> vClienti = new Vector<Object>();
					vClienti = gf.ReadFile("DBclients.dat");
					vAuto = gf.ReadFile("DBauto.dat");
					Client cl = new Client();
					Vehicul m = new Vehicul();
					boolean trouver = false;
					cl=null;
					m = null;
					indice = 0;
					String cin=null;
					while(!trouver && indice<vClienti.size() && code!=null){
						cl = (Client)vClienti.elementAt(indice);
						if(code.equals(cl.getCode())){
							trouver = true;
							 cin=cl.getCIN();
						}else indice++;
					}
					if(trouver){
						
						int i =0;
						boolean trov = false;
						while(!trov && i<vAuto.size()){
							m = (Vehicul)vAuto.elementAt(i);
							if(jtfn_im.getText().equals(m.getVinNumber()) && jtfprice.getText().equals(m.getPrice()) && jcmake.getSelectedItem().equals(m.getMaker()) && jcColor.getSelectedItem().equals(m.getColore())){
								trov = true;
							}else i++;
						}
						int j = 0;
							boolean tro = false;
							Vector<?> vScanf = new Vector<Object>();
							vScanf = gf.ReadFile("autoRented.dat");
							if(trov){
								while(!tro && j<vScanf.size()){
									rentedCar=(RentedVehicul)vScanf.elementAt(j);
									if(cin.equals(rentedCar.getRentNumber()) || jtfn_im.getText().equals(rentedCar.getVinNumber())){
										tro=true;
										JOptionPane.showMessageDialog(null, "  CAR NOT AVAILABLE "+"\n"+"o CLIENTE IN SITUAZIONE NON REGOLARE, RESTITUIRE LA MACCHINA IN POSSESSO ","INFORMATION",JOptionPane.ERROR_MESSAGE);
									}else j++;
								}
								RentedVehicul macf = new RentedVehicul();
								if(!tro){
									Date data = new Date();
									macf.setVinNumber(jtfn_im.getText());
									macf.setMaker((String)jcmake.getSelectedItem());
									macf.setColore((String)jcColor.getSelectedItem());
									macf.setPrice(jtfprice.getText());
									macf.setVinNumber(jtfn_im.getText());
									macf.setReleaseDate(data);
									vRentedCar.addElement(macf);
									
									try{gf.Scrivi(vRentedCar,"add","autoRented.dat");
								    JOptionPane.showMessageDialog(null, "Car Rented ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
								    }catch(IOException ex){ JOptionPane.showInternalMessageDialog(null,"An Error has occured","Error",JOptionPane.ERROR_MESSAGE); }
								    	
								}
						}else {
							int resp = JOptionPane.showConfirmDialog(null, "Car with the characteristics required  do not exist in the DB:"+"\n"+ "Research?"+"\n"+"YES or NO to try again","REQUEST",JOptionPane.YES_NO_OPTION);
							if(resp== JOptionPane.YES_OPTION){dispose(); FrameCliente p = new FrameCliente(); p.setVisible(true);}
								
						}
					}else {
						int resp = JOptionPane.showConfirmDialog(null, "Clinet of the code  "+code+"is not registered: REGISTER?"+"\n"+"YES or NO to register","REQUEST",JOptionPane.YES_NO_OPTION);
						if(resp== JOptionPane.YES_OPTION){dispose(); Rent p = new Rent(); p.setVisible(true);}
					}
				}
			}		
			});
		
	}
	
	
	public void CarList(){
		
		gf = new GestioneFile();
		Vector<Vehicul> vTot= new Vector<Vehicul>(); 
		
		@SuppressWarnings("rawtypes")
		Vector<Vector> rowData = new Vector<Vector>();
		vTot = gf.ReadFile("DBauto.dat");
		vehicul = new Vehicul();
		vehicul = null;
		
		for(int i=0;i<vTot.size();i++){
			Vector<String> vRowi =  new Vector<String>();
			vehicul = (Vehicul)vTot.elementAt(i);
			vRowi.addElement(vehicul.getMaker());
			
			vRowi.addElement(vehicul.getColore());
			vRowi.addElement(vehicul.getPrice());
			vRowi.addElement(vehicul.getVinNumber());
			gf = new GestioneFile();
			rowData.addElement(vRowi);
			
		}
		
		
		Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("Maker");
	    columnNames.addElement("color");
	    columnNames.addElement("price / Day");
	    columnNames.addElement("Vin Number");
		JTable table = new JTable(rowData, columnNames){
		public boolean isCellEditable(int row, int column) { 

			return false; 

			} 

			};
		JScrollPane scrollPane = new JScrollPane(table);
	    onglet2.add(scrollPane, BorderLayout.CENTER);
	  
	}
	

	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource() == exit) System.exit(0);
		else if(ev.getSource() == home) dispose();
		else if(ev.getSource() == listauto){
			
		}
		else if(ev.getSource() == newCar){
			Vector<Vehicul> v = new Vector<Vehicul>(1);
			Vector<?> vControl = new Vector<Object>();
			 gf = new GestioneFile();
			vehicul = new Vehicul();
			vehicul.setMaker((String)jcmake.getSelectedItem());
			vehicul.setColore((String)jcColor.getSelectedItem());
			vehicul.setrentable(true);
			vehicul.setVinNumber(jtfn_im.getText());
			vehicul.setPrice(jtfprice.getText());
			
			
			v.addElement(vehicul);
			vControl = gf.ReadFile("DBauto.dat");
			String chaine = Integer.toString(vControl.size());
			jtfmileage.setText(chaine);
			
			boolean trouver = false;
			 indice=0;
			 
			  Vehicul mac=null;
			 while((!trouver)&&(indice<vControl.size())){
			   mac=(Vehicul)vControl.elementAt(indice);
			   	if(jtfn_im.getText().compareTo(mac.getVinNumber())==0){ trouver=true;}
			      else indice++;
			   	
			  }
			
			 
			if(trouver){
				
				JOptionPane.showMessageDialog(null, "Car with Vin number" +vehicul.getVinNumber()+" in the DB", "Errore", JOptionPane.ERROR_MESSAGE);
			}else{ 
				if( jtfprice.getText().equals("") || jtfn_im.getText().equals("") ){
				
				JOptionPane.showMessageDialog(null, "FILL ALL FIELDS", "Errore", JOptionPane.ERROR_MESSAGE);
				}else{
				try{gf.Scrivi(v,"add","DBauto.dat");}catch(IOException ex){ JOptionPane.showInternalMessageDialog(null,"Une erreur est survenue","Error",JOptionPane.ERROR_MESSAGE); }
				
				JOptionPane.showMessageDialog(null, "Insertion successful " +"\n"+"Car Code: "+vehicul.getVinNumber()+" \n "+"Thank You" , "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
				
				
				int resp=JOptionPane.showConfirmDialog(null,"Add details about the car ?","Request",JOptionPane.YES_NO_OPTION);

			     if(resp==JOptionPane.YES_OPTION){
			       Details d=new Details();
			       d.setFile((String)jtfn_im.getText());
			       d.setVisible(true);
			     }
				
				Vector<?> vLunghezza = gf.ReadFile("DBauto.dat");
				int lung = vLunghezza.size();
				
				jtfmileage.setText(Integer.toString(lung));
				
				}
			}
				
						
				
			
			
			
			
			jtfprice.setText("");
			jtfn_im.setText("");
		}
		else if(ev.getSource() == searchClient){
			String cin = JOptionPane.showInputDialog(null, "Enter the CIN of the customer", "Code", JOptionPane.INFORMATION_MESSAGE);
			gf = new GestioneFile();
			Client cl = new Client();
			rentedCar = new RentedVehicul();
			Vector<?> vCl = new Vector<Object>();
			Vector<?> vRentedCar = new Vector<Object>();
			vCl = gf.ReadFile("DBclients.dat");
			vRentedCar = gf.ReadFile("autoRented.dat");
			String name = "";
			String lastName = "";
			String city = "";
			String tel = "";
			String make = "";
			String carCode = "";
			cin = "";
                    
			boolean trouver = false;
			cl = null;
			int i = 0;
			while(!trouver && i<vCl.size() && cin!=null){
				cl = (Client)vCl.elementAt(i);
				if(cin.equals(cl.getCIN())) {
					trouver = true;
					name = cl.getName();
					lastName=cl.getLastName();
					city = cl.getCity();
					tel=cl.getNumTel();
					cin=cl.getCIN();
				}
				else i++;
			}
			
			if(trouver){
				int j =0;
				rentedCar = null;
				boolean trov = false;
				while(!trov && j<vRentedCar.size()){
					rentedCar = (RentedVehicul)vRentedCar.elementAt(j);
					if(cin.equals(rentedCar.getRentNumber())){
						trov = true;
						make = rentedCar.getMaker();
						carCode = rentedCar.getVinNumber();
					}else j++;
				}
				JOptionPane.showMessageDialog(null, "Name: "+name+"\n"+"Last Name: "+lastName+"\n"+"CIN :  "+cin+"\n"+"Phone Number: "+tel+"\n"+"City of Residence:  "+city+"\n"+"Car in possession: "+make+"\n"+"Vin Number:  "+carCode+"\n","",JOptionPane.DEFAULT_OPTION);
			}else JOptionPane.showMessageDialog(null, "Customer with CIN= "+"\n"+cin+"\n"+"is not registered","ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else if(ev.getSource() == ret){
			Vector<?> vFind = new Vector<Object>();
			GestioneFile gf = new GestioneFile();
			 vFind=gf.ReadFile("autoRented.dat");  
			RentedVehicul rentedCar = new RentedVehicul();
			boolean trouver=false;
			  indice=0;
			 
			 rentedCar  = null;
			if(jtfn_im.getText().equals("")){
				JOptionPane.showMessageDialog(this, "WARNING: Enter the registration number","ERRORE", JOptionPane.ERROR_MESSAGE);
			}else{
				while((!trouver)&&(indice<vFind.size())){
			   		rentedCar =(RentedVehicul)vFind.elementAt(indice);
			    	if(jtfn_im.getText().equals(rentedCar .getVinNumber())){
			    		trouver=true;
			    		
			    		Date data = new Date();
			    		Date date = rentedCar .getReleaseDate();
			    		@SuppressWarnings("deprecation")
						int dataP = date.getDate();
			    		@SuppressWarnings("deprecation")
						int dataR = data.getDate();
			    		int price =Integer.parseInt(rentedCar .getPrice());
			    		int priceTot = ((dataR-dataP)+1)*price;
			    		int response = JOptionPane.showConfirmDialog(null,"Hello "+rentedCar .getNameC()+"\n"+"Confirm return?","QUESTION",JOptionPane.YES_NO_OPTION);
						if(response==JOptionPane.YES_OPTION){
								jtfn_im.setText("");
								vFind.removeElementAt(indice);
					    		try{gf.Scrivi(vFind,"sov","autoRented.dat");}catch(IOException ex){ JOptionPane.showInternalMessageDialog(null,"Une erreur est survenue","Error",JOptionPane.ERROR_MESSAGE); }
					    		JOptionPane.showMessageDialog(null, "The return is done. "+"\n"+"PAY THE AMOUNT OF "+priceTot+"  at the checkout"+"\n"+"thank you","Information", JOptionPane.INFORMATION_MESSAGE);
						  }
			    	}
			      	else indice++;
			 
				}
				if(!trouver) JOptionPane.showMessageDialog(null, "Car not found","Information", JOptionPane.INFORMATION_MESSAGE); 
			 	}
			
			
		}else if(ev.getSource() == cancel){
			if(jtfn_im.getText().equals("")) JOptionPane.showMessageDialog(null, "Enter the Vin Number of the Car","",JOptionPane.ERROR_MESSAGE);
			else{
				int resp=JOptionPane.showConfirmDialog(this,"Do you want to delete the car ?","Question",JOptionPane.YES_NO_OPTION);
			    if(resp==JOptionPane.YES_OPTION){
			    	Vector<?> vFind = new Vector<Object>();
			    	vehicul = new Vehicul();
			    	vFind=gf.ReadFile("DBauto.dat");
			    	File f=new File("Details","*"+jtfn_im.getText()+".txt");
			    	f.delete();
			    	boolean trouver = false;
			    	int i =0;
			    	vehicul = null;
			    	while(!trouver && i<vFind.size()){
			    		vehicul = (Vehicul)vFind.elementAt(i);
			    		if(jtfn_im.getText().equals(vehicul.getVinNumber())){
			    			trouver = true;
			    			vFind.removeElementAt(indice);
					    	try{
					    		gf.Scrivi(vFind,"update","DBauto.dat");}catch(IOException ex){;}
					    		jtfn_im.setText("");
					    		jtfmileage.setText(String.valueOf(vFind.size()));
					    		
			    		}else i++;
			    	}
			    	if(!trouver) JOptionPane.showMessageDialog(this,"Car not found inr the DB","ERROR",JOptionPane.ERROR_MESSAGE);
				
			
		}
			}
		}
		else if(ev.getSource() == dispo){
			Dispo d = new Dispo();
			d.setVisible(true);
		}
		else if(ev.getSource() == nondispo){
			NonDispo nd = new NonDispo();
			nd.setVisible(true);
		}
	}
	
	public class Registrazione extends JDialog implements ActionListener{
		JPanel pane = new JPanel();
		JTextField user = new JTextField();
		JPasswordField pass = new JPasswordField();
		JLabel labeluser = new JLabel("User Name");
		JLabel labelpass = new JLabel("Password");
		JLabel label = new JLabel("Enter User Name and Password");
		JButton ok = new JButton("OK");
		JButton no = new JButton("Cancel");
		
		public Registrazione(){
			super();
			this.setTitle("Registration");
			this.setSize(250, 300);
			this.setLocationRelativeTo(null);
			this.setContentPane(pane);
			this.setAlwaysOnTop(true);  
			this.setResizable(false);
			pane.setLayout(null);
			pass.setEchoChar('*');
			label.setBounds(10, 0, 300, 20);
			labeluser.setBounds(30, 50, 50, 20);
			user.setBounds(100, 50, 100, 30);
			labelpass.setBounds(30, 90, 80, 20);
			pass.setBounds(100, 90, 100, 30);
			
			ok.setBounds(20, 200, 80, 30);
			no.setBounds(125, 200, 80, 30);
			ok.setBackground(Color.green);
			no.setBackground(Color.red);
			
			add(label);
			add(labeluser);
			add(user);
			add(labelpass);
			add(pass);
			add(ok);
			add(no);
			no.addActionListener(this);
			ok.addActionListener(this);
			user.addActionListener(this);
			pass.addActionListener(this);
			
		}
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == no){
				dispose();
			}
			else {
				
					if((user.getText().equals("73869")) && (pass.getText().equals("0000"))){
						dispose();
						FrameEmployee fdte = new FrameEmployee();
						fdte.setVisible(true);
					}
					else{
						
						JOptionPane.showMessageDialog(null, "AUTENTICATION FALLED: RETRY", "Errore", JOptionPane.ERROR_MESSAGE);
						user.setText("");
						pass.setText("");
					}
				
			}
			
		} 
	}
	
	
	
	public class NonDispo extends JFrame {
		JPanel panel = new JPanel();
		public NonDispo(){
			this.setSize(new Dimension(500, 500));
			this.setLocationRelativeTo(null);
			this.setContentPane(panel);
			this.getContentPane().setLayout(new BorderLayout());
			
			

			
			gf = new GestioneFile();
			Vector<Vehicul> vTot= new Vector<Vehicul>(); 
			@SuppressWarnings("rawtypes")
			Vector<Vector> rowData = new Vector<Vector>();
			vTot = gf.ReadFile("autoRented.dat");
			RentedVehicul vehicul = new RentedVehicul();
			vehicul = null;
			
			for(int i=0;i<vTot.size();i++){
				Vector<String> vRowi =  new Vector<String>();
				vehicul = (RentedVehicul)vTot.elementAt(i);
				vRowi.addElement(vehicul.getMaker());
				
				vRowi.addElement(vehicul.getColore());
				vRowi.addElement(vehicul.getPrice());
				//vRowi.addElement(vehicul.getN_Imm());
				vRowi.addElement(vehicul.getNameC());
				gf = new GestioneFile();
				rowData.addElement(vRowi);
				
			}
			
			
			Vector<String> columnNames = new Vector<String>();
		    columnNames.addElement("Maker");
		    columnNames.addElement("color");
		    columnNames.addElement("Price / Day");
		    columnNames.addElement("Client in possession");
			JTable table = new JTable(rowData, columnNames){
			public boolean isCellEditable(int row, int column) { 

				return false; 

				} 

				};
			JScrollPane scrollPane = new JScrollPane(table);
		    panel.add(scrollPane, BorderLayout.CENTER);
		  
		
		}
	}
	
	
	
	public class Dispo extends JFrame {
		JPanel panel = new JPanel();
		public Dispo(){
			this.setSize(new Dimension(500, 500));
			this.setLocationRelativeTo(null);
			this.setContentPane(panel);
			this.getContentPane().setLayout(new BorderLayout());
			
			

			
			gf = new GestioneFile();
			Vector<Vehicul> vTot= new Vector<Vehicul>(); 
			Vector<?> v = new Vector<Object>();
			@SuppressWarnings("rawtypes")
			Vector<Vector> rowData = new Vector<Vector>();
			//String f = "DBauto.dat";
			//File fi = new File("DBauto.dat") ;
			vTot = gf.ReadFile("DBauto.dat");
			v = gf.ReadFile("autoRented.dat");
			RentedVehicul rentCar = new RentedVehicul();
			Vehicul vehicul = new Vehicul();
			vehicul = null;
			rentCar = null;
			int j =0;
			boolean trouver = false;
			//boolean trov = false;
			for(int i=0;i<vTot.size();i++){
				//Vector<String> vRowi =  new Vector<String>();
				vehicul = (Vehicul)vTot.elementAt(i);
				while(!trouver && j<v.size()){
					rentCar = (RentedVehicul)v.elementAt(j);
					if(vehicul.getMaker().equals(rentCar.getMaker()) && vehicul.getPrice().equals(rentCar.getPrice())) {
						trouver = true;
						vTot.removeElementAt(i);
						}
					else j++;
					//trov = true;
				
				}
				
				
			}
			for(int i =0; i<vTot.size(); i++){
				Vector<String> vRowi =  new Vector<String>();
				vehicul = (Vehicul)vTot.elementAt(i);
				vRowi.addElement(vehicul.getMaker());
				
				vRowi.addElement(vehicul.getColore());
				vRowi.addElement(vehicul.getPrice());
				vRowi.addElement(vehicul.getVinNumber());
				rowData.addElement(vRowi);
			}
			
			
			Vector<String> columnNames = new Vector<String>();
		    columnNames.addElement("Maker");
		    columnNames.addElement("color");
		    columnNames.addElement("Price /  Day");
		    columnNames.addElement("Vin Number");
			JTable table = new JTable(rowData, columnNames){
			public boolean isCellEditable(int row, int column) { 

				return false; 

				} 

				};
			JScrollPane scrollPane = new JScrollPane(table);
		    panel.add(scrollPane, BorderLayout.CENTER);
		  
		
		}
	}

}
