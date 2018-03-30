package Frame;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import personnel.Client;
import personnel.Vehicul;
import personnel.RentedVehicul;

@SuppressWarnings("serial")
public class SearchPannel extends JFrame implements ActionListener{
	JPanel panel = new JPanel();
	private JMenuBar jMenuBar1 = new JMenuBar();
	private JMenu jMenu1 = new JMenu("Help");
	private JMenuItem jMenuItem11 = new JMenuItem("apropos...");
	JLabel codeClient = new JLabel("Client Code");
	JLabel carCode= new JLabel("Car Code");
	JLabel maker = new JLabel("Maker");
	JLabel lcol = new JLabel("Colore");
	JLabel lp = new JLabel("Price / Day");
	JLabel dinar = new JLabel(" DT");
	JLabel ldispo = new JLabel("Availability");
	JLabel nvehicul = new JLabel(" Car Number: ");
	JLabel lnm = new JLabel();
	
	JTextArea jta = new JTextArea("In order to rent the car, enter the Client Code");
	JTextField jtfcod = new JTextField();
	JTextField jtfcodice = new JPasswordField();
	private JTextField jtfc = new JTextField();
	private JTextField jtfcolor = new JTextField();
	private JTextField jtfp = new JTextField();
	private JTextField jtfdispo = new JTextField();
	
	JButton prec = new JButton("Previous");
	JButton flow = new JButton("Following");
	JButton details = new JButton("Details");
	JButton rent = new JButton("Rent");
	JButton nr = new JButton("New Research");
	private ButtonGroup bgp = new ButtonGroup();
	private JRadioButton rb1 = new JRadioButton();
	private JRadioButton rb2 = new JRadioButton();
	
	
	int i=0;
	Vehicul vehicul;
	RentedVehicul rentedCar;
	GestioneFile g ;
	Vector<?> v;
	Client client;
	
	public SearchPannel() {
		g = new GestioneFile();
	    try {
	      v=g.ReadFile("Research.dat");
	      jbInit();
	      this.setVisible(true);
	    }
	    catch(Exception e) {
	      e.printStackTrace();
	    }
	  }
	
	public void jbInit() throws Exception {
	    
		setTitle("Search results");
		setSize(500,400);
		setLocationRelativeTo(null);
		this.setResizable(false);
		this.setContentPane(panel);
		setLayout(null);
		this.setJMenuBar(jMenuBar1);
		jMenuBar1.setBorder(null);
		this.getContentPane().setBackground(new Color(238, 238, 238));
		
		jtfc.setFont(new java.awt.Font("Serif", 1, 16));
	    jtfcolor.setForeground(new Color(217, 97, 155));
	    jtfp.setFont(new java.awt.Font("Serif", 1, 16));
	    jtfdispo.setForeground(new Color(143, 34, 34));
	    jta.setForeground(Color.red);
		jta.setLineWrap(true);  
		jta.setWrapStyleWord(true);
		jta.setEditable(false);
		
		lnm.setBounds(165, 5, 30, 20);
		nvehicul.setBounds(10, 5, 155, 20);
	    carCode.setBounds(10, 40, 100, 20);
	    jtfcod.setBounds(115, 40, 80, 30);
	    jtfcod.setEditable(false);
	    maker.setBounds(new Rectangle(10, 80, 50, 20));
	    jtfc.setBounds(new Rectangle(80, 80, 200, 30));
	    jtfc.setEditable(false);
	    lcol.setBounds(new Rectangle(10, 150, 75, 20));
	    jtfcolor.setBounds(new Rectangle(80, 150, 200, 30 ));
	    jtfcolor.setEditable(false);
	    lp.setBounds(new Rectangle(10, 220, 120, 20));
	    jtfp.setBounds(new Rectangle(130, 220, 95, 30));
	    dinar.setBounds(230, 220, 20, 20);
	    jtfp.setEditable(false);
	    ldispo.setBounds(new Rectangle(10, 290, 100, 30));
	    
	    rb1.setEnabled(false);
	    rb2.setEnabled(false);
	    rb1.setText("YES");
	    rb1.setBounds(new Rectangle(120, 300, 44, 18));
	    rb1.setActionCommand("jRadioButton1");
	    
	    rb2.setText("No");
	    rb2.setBounds(new Rectangle(170, 300, 44, 18));
	    
	    codeClient.setBounds(230, 300, 100, 30);
	    jtfcodice.setBounds(330, 305, 75, 30);
	  
	    prec.setEnabled(false);
	    flow.setBounds(new Rectangle(390, 0, 100, 20));
	    prec.setBounds(new Rectangle(280,0, 100,20));
	    details.setBounds(new Rectangle(350, 100, 120, 30));
	    rent.setBounds(new Rectangle(350, 150, 120, 30));
	    
	    jta.setBounds(300, 240, 150, 55);
	    nr.setBounds(new Rectangle(350, 200, 120, 30));
	    
	    jMenuBar1.add(jMenu1);
	    jMenu1.add(jMenuItem11);
	    add(lnm);
	    add(nvehicul);
	    add(carCode);
	    add(jtfcod);
	    add(jta);
	    add(codeClient);
	    add(jtfcodice);
	    add(rb1);
	    add(rb2);
	    add(maker);
	    add(lcol);
	    add(lp);
	    add(dinar);
	    add(ldispo);
	    add(jtfc);
	    add(jtfcolor);
	    add(jtfp);
	    add(jtfdispo);
	    add(flow);
	    add(prec);
	    add(details);
	    add(rent);
	    add(nr);
	    bgp.add(rb1);
	    bgp.add(rb2);
	    flow.addActionListener(this);
	    prec.addActionListener(this);
	    details.addActionListener(new SeeDetails());
	    rent.addActionListener(this);
	    nr.addActionListener(this);
	    jMenuItem11.addActionListener(this);
	    jtfcodice.addActionListener(this);
	    
	    
	    
	    Vector<?> vR = new Vector<Object>();
	    g = new GestioneFile();
	    vR = g.ReadFile("Research.dat");
	    lnm.setText(String.valueOf(vR.size()));  
	     naviga();
	   
	}
	
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		if(ev.getSource()==nr){
			dispose();
		}else 
			if(ev.getSource()==flow){
				prec.setEnabled(true);
				if(i<v.size()-1) i++;
				naviga();
				if(i==v.size()-1) flow.setEnabled(false);
				
				
				Vector<?> vS = new Vector<Object>();
			    g = new GestioneFile();
			    vS = g.ReadFile("autoRented.dat");
			    rentedCar = new RentedVehicul();
			    boolean trouver = false;
			    rentedCar = null;
			    int j=0;
			    while(!trouver && j<vS.size()){
			    	rentedCar = (RentedVehicul)vS.elementAt(j);
			    	if(jtfcod.getText().equals(rentedCar.getVinNumber())){
			    		trouver = true;
			    		rent.setEnabled(false);
			    		rb2.setSelected(true);
			    		rb1.setSelected(false);
			    	}else j++;
			    }
			    
			    if(!trouver) {rb1.setSelected(true); rb2.setSelected(false); rent.setEnabled(true);}
			    
				
			}
			else
				if(ev.getSource()==prec){
					flow.setEnabled(true);
					if(i>0)i--;
					naviga();
					if(i==0) prec.setEnabled(false);
					
					
					Vector<?> vS = new Vector<Object>();
				    g = new GestioneFile();
				    vS = g.ReadFile("autoRented.dat");
				    rentedCar = new RentedVehicul();
				    boolean trouver = false;
				    rentedCar = null;
				    int j=0;
				    while(!trouver && j<vS.size()){
				    	rentedCar = (RentedVehicul)vS.elementAt(j);
				    	if(jtfcod.getText().equals(rentedCar.getVinNumber())){
				    		trouver = true;
				    		rent.setEnabled(false);
				    		rb2.setSelected(true);
				    		rb1.setSelected(false);
				    	}else j++;
				    }
				    
				    if(!trouver) {rb1.setSelected(true); rb2.setSelected(false); rent.setEnabled(true);}
				    
				    
				}
				else
					if(ev.getSource()==rent){
						if(jtfcodice.getText().equals("")) JOptionPane.showMessageDialog(this, "  Enter Client Code. Thank you ","INFORMATION",JOptionPane.ERROR_MESSAGE);
						else{
							jtfcodice.setEditable(false);
							g = new GestioneFile();
							rentedCar=new RentedVehicul();
							Vector<?> vScan = new Vector<Object>();
							Vector<?> vScanf = new Vector<Object>();
							Vector<RentedVehicul> vMF = new Vector<RentedVehicul>(1);
							vScan = g.ReadFile("DBclients.dat");
							client = null;
							boolean trouver = false;
							String cin=null;
							i=0;
							while(!trouver && i<vScan.size()){
								client = (Client)vScan.elementAt(i);
								if(jtfcodice.getText().equals(client.getCode())){
									trouver = true;
									rentedCar.setRentNumber(client.getCIN());
									rentedCar.setNameC(client.getName());
									cin=client.getCIN();
								}else i++;
							}
							int j=0;
							RentedVehicul mf = new RentedVehicul();
							boolean trov = false;
							vScanf = g.ReadFile("autoRented.dat");
							if(trouver){
								while(!trov && j<vScanf.size()){
									mf=(RentedVehicul)vScanf.elementAt(j);
									if(cin.equals(mf.getRentNumber()) || jtfcod.getText().equals(mf.getVinNumber())){
										trov=true;
										JOptionPane.showMessageDialog(this, "Car not found"+"\n"+"Person not authorized ","INFORMATION",JOptionPane.ERROR_MESSAGE);
									}else j++;
								}
								if(!trov){
									Date data = new Date();
									rentedCar.setVinNumber(jtfcod.getText());
									rentedCar.setMaker(jtfc.getText());
									rentedCar.setColore(jtfcolor.getText());
									rentedCar.setPrice(jtfp.getText());
									rentedCar.setReleaseDate(data);
									rentedCar.setVinNumber(jtfcod.getText());
									vMF.addElement(rentedCar);
									
									try{g.Scrivi(vMF,"add","autoRented.dat");
								    JOptionPane.showMessageDialog(null, "Car Rented","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
								    }catch(IOException ex){ JOptionPane.showInternalMessageDialog(null,"An erroe has occured","Error",JOptionPane.ERROR_MESSAGE); }
								    	
								}
							}else {JOptionPane.showMessageDialog(null, "Client not found","ERROR",JOptionPane.ERROR_MESSAGE);
								jtfcodice.setEditable(true);
								jtfcodice.setText("");
							}
						}
						
					}
					else
						if(ev.getSource()==jMenuItem11){
							JOptionPane.showMessageDialog(null, "SEARCH RESULTS"+"\n"+"you can rent a car only if you are in possession of "+"\n"+" the registration number received at registration"+"\n"+"\n"+"Click Previous\\next you find "+"\n"+"the search result"+"\n"+"The details on the car, if available are shown "+"\n"+"clicking on the \"Details \""+"\n"+"\n","ABOUT Result panel",JOptionPane.DEFAULT_OPTION);
						}
						else{
							jtfcodice.setEditable(false);
							
							g = new GestioneFile();
							Vector<?> vScan = new Vector<Object>();
							vScan = g.ReadFile("DBclients.dat");
							client = null;
							boolean trouver = false;
							
							i=0;
							while(!trouver && i<vScan.size()){
								client = (Client)vScan.elementAt(i);
								if(jtfcodice.getText().equals(client.getCode())) trouver = true;
								else i++;
							}
							if(!trouver)
								{
								int resp = JOptionPane.showConfirmDialog(this, "Not registered: REGISTER?"+"\n"+"YES or NO to register","REQUEST",JOptionPane.YES_NO_OPTION);
								if(resp== JOptionPane.YES_OPTION){dispose(); Rent p = new Rent(); p.setVisible(true);}
								else jtfcodice.setEditable(true);
							}
						
						}
		
	}
	
	
	public void naviga(){
		
		
		  if(v.size()>0){
		    Vehicul vehicul=(Vehicul)v.elementAt(i);

		   File f=new File("Details",vehicul.getVinNumber()+".txt");
		    if(f.exists())details.setEnabled(true);
		    else details.setEnabled(false);
		    jtfcod.setText(vehicul.getVinNumber());
		    jtfc.setText(vehicul.getMaker());
		    jtfcolor.setText(vehicul.getColore());
		    jtfp.setText(vehicul.getPrice());
		    
		    Vector<?> vS = new Vector<Object>();
		    g = new GestioneFile();
		    vS = g.ReadFile("autoRented.dat");
		    rentedCar = new RentedVehicul();
		    boolean trouver = false;
		    rentedCar = null;
		    int j=0;
		    while(!trouver && j<vS.size()){
		    	rentedCar = (RentedVehicul)vS.elementAt(j);
		    	if(jtfcod.getText().equals(rentedCar.getVinNumber())){
		    		trouver = true;
		    		rent.setEnabled(false);
		    		rb2.setSelected(true);
		    		rb1.setSelected(false);
		    	}else j++;
		    }
		    
		    if(!trouver) {rb1.setSelected(true); rb2.setSelected(false); rent.setEnabled(true);}
		    
		    

		  }
		}

	class SeeDetails implements ActionListener{
	  String line;

	 public void actionPerformed(ActionEvent e){
	try{
	     File res=new File("Details",jtfcod.getText()+".txt");
	    BufferedReader fe=new BufferedReader(new FileReader(res));
	    Details d=new Details();

	    while((line=fe.readLine())!=null){
	      d.view(line);
	    }
	    d.setVisible(true);
	           }catch(Exception ex){JOptionPane.showMessageDialog(null,"File not found","error",JOptionPane.ERROR_MESSAGE);}
	  }
	}

}
