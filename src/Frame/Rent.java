package Frame;

import personnel.Client;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Rent extends JFrame implements ActionListener{
	JComboBox<?> jcbornday1;
	JComboBox<?> jcbornday2;
	JComboBox<?> jcbornday3;
	String[] tab1 = {"Day","1", "2", "3", "4", "5", "6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] tab2 = {"Month","1", "2", "3", "4", "5", "6","7","8","9","10","11","12"};
	String[] tab3 = {"Year","1939", "1940", "1941","1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950","1951","1952","1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960",
					"1961","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978",
					"1979", "1980","1981", "1982", "1983", "1984", "1985","1986", "1987", "1988", "1989", "1990", "1991", "1992" };
	JPanel panel = new JPanel();
	JButton ok = new JButton("Save Data");
	JButton exit = new JButton("Exit");
	JButton reset = new JButton("RESET");
	JLabel label = new JLabel("ACQUISITION OF CUSTOMER DATA");
	JLabel label1 = new JLabel("Fields with '*' are required");
	JLabel name = new JLabel("Name*");
	JLabel numtel = new JLabel("Phone Number*");
	JLabel lastName = new JLabel("Last Name*");
	JLabel cin = new JLabel("CIN*");
            JLabel country = new JLabel("Country of Residence");
	JLabel city = new JLabel("City of Residence");
	JLabel adress = new JLabel("Adress");
	JLabel bornday = new JLabel("Date of Birth");
	JTextField jtfname = new JTextField(20);
	JTextField jtflastName = new JTextField(20);
	JTextField jtfcountry = new JTextField(15);
	JTextField jtfcity = new JTextField(15);
	JTextField jtfadress = new JTextField(50);
	JTextField jtfcin = new JTextField(16);
	JTextField jtfnumtel = new JTextField(16);
	JRadioButton rb[] ; 
	Client clte;
	int i;
	Vector<?> vFind;
	GestioneFile gf;
	public  Rent(){
		this.setTitle("Registration");
		this.setBounds(150, 75, 550, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.getContentPane().setBackground(new Color(238, 238, 238));;
	
		rb = new JRadioButton[2];
		rb[0] = new JRadioButton("Street");
		rb[1] = new JRadioButton("Road");
		ButtonGroup bg = new ButtonGroup();
		
		jcbornday1 = new JComboBox<Object>(tab1);
		jcbornday2 = new JComboBox<Object>(tab2);
		jcbornday3 = new JComboBox<Object>(tab3);
		jcbornday1.setBackground(Color.white);
		jcbornday2.setBackground(Color.white);
		jcbornday3.setBackground(Color.white);

		
		panel.setLayout(null);
		reset.setBounds(200, 400, 100, 30);
                reset.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		exit.setBounds(20, 400, 100, 30);
                exit.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		ok.setBounds(400, 400, 100, 30);
                ok.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		label.setBounds(175,0,300,20);
                label.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		label1.setBounds(20, 30, 300,15);
                label1.setForeground(Color.red);
                label1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		name.setBounds(20, 65, 90, 20);
                name.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jtfname.setBounds(135, 60, 250, 25);
                jtfname.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lastName.setBounds(20, 95, 80, 20);
                lastName.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jtflastName.setBounds(135, 90, 250, 25);
                jtflastName.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		cin.setBounds(20, 125, 90, 30);
                cin.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jtfcin.setBounds(135, 125, 250, 25);
                jtfcin.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		country.setBounds(20, 165, 110, 20);
                country.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jtfcountry.setBounds(135,160, 250, 25);
                jtfcountry.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		city.setBounds(20, 195, 105, 20);
                city.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jtfcity.setBounds(135,195, 250, 25);
                jtfcity.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		adress.setBounds(20, 227, 80, 20);
                adress.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jtfadress.setBounds(235, 225, 150, 25);
                jtfadress.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		numtel.setBounds(20, 295, 125, 20);
                numtel.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jtfnumtel.setBounds(135, 295, 250, 25);
                jtfnumtel.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		bornday.setBounds(20, 260, 150, 20);
                bornday.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jcbornday1.setBounds(135, 260, 70, 20);
                jcbornday1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jcbornday2.setBounds(215, 260, 75, 20);
                jcbornday2.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		jcbornday3.setBounds(295, 260, 75, 20);
                jcbornday3.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		rb[0].setBounds(80, 225, 70, 20);
                rb[0].setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		rb[1].setBounds(160, 225, 65, 20);
                rb[1].setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		
		add(numtel);
		add(jtfnumtel);
		panel.add(label);
		panel.add(label1);
		panel.add(name);
		panel.add(jtfname);
		panel.add(lastName);
		panel.add(jtflastName);
		panel.add(cin);
		panel.add(jtfcin);
		panel.add(country);
		panel.add(jtfcountry);
		panel.add(city);
		panel.add(jtfcity);
		panel.add(adress);
		panel.add(jtfadress);
		add(bornday);
		add(jcbornday1);
		add(jcbornday2);
		add(jcbornday3);
		panel.add(ok);
		panel.add(exit);
		add(reset);
		
		for(int i=0; i<2; i++){
			bg.add(rb[i]);
		}
		for(int i=0; i<2; i++){
			add(rb[i]);
		}
		for(int i=0; i<2; i++){
			rb[i].addActionListener(this);
		}
		
		reset.addActionListener(this);
		exit.addActionListener(this);
		ok.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == ok){
			gf=new GestioneFile();
			Vector<Client> vCliente = new Vector<Client>(1);
			vFind=gf.ReadFile("DBclients.dat");
			clte=null;
			boolean trovato=false;
			i=0;
			if(jtfname.getText().equals("") || jtflastName.getText().equals("") || jtfcin.getText().equals("") ||jtfnumtel.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Fields with \"* \" are required","",JOptionPane.ERROR_MESSAGE);
			else {
				while(!trovato && i<vFind.size()){
					clte=(Client)vFind.elementAt(i);
					if(jtfcin.getText().compareTo(clte.getCIN())==0) trovato=true;
					else i++;
				}
			
				if(trovato) JOptionPane.showMessageDialog(null, "CUSTOMER WITH "+"\n"+"CIN "+jtfcin.getText()+"\n"+"Not found ","ERRORE",JOptionPane.ERROR_MESSAGE);
				else{
				
					Client client = new Client();
					client.setName(jtfname.getText());
					client.setLastName(jtflastName.getText());
					client.setCIN(jtfcin.getText());
					client.setCountry(jtfcountry.getText());
					client.setCity(jtfcity.getText());
					client.setAdress(jtfadress.getText());
					client.setNumTel(jtfnumtel.getText());
					client.setBornDay(String.valueOf((String)jcbornday1.getSelectedItem()));
					client.setBornMonth(String.valueOf((String)jcbornday2.getSelectedItem()));
					client.setBornYear(String.valueOf((String)jcbornday3.getSelectedItem()));
					client.setCod(client.getCode());
					vCliente.addElement(client);
					try {
						gf.Scrivi(vCliente, "add", "DBclients.dat");
						int resp = JOptionPane.showConfirmDialog(this, "Registration was successful"+"\n"+"It's Access Code "+client.getCode()+"\n"+"Continu Searching for a Car? ","CONFIRMATION",JOptionPane.YES_NO_CANCEL_OPTION);
						if(resp== JOptionPane.YES_OPTION){
						dispose();
						FrameCliente fc = new FrameCliente();
						fc.setVisible(true);
						}else if(resp== JOptionPane.NO_OPTION){dispose(); Welcome1 w = new Welcome1(); w.setVisible(true);}
						else {
							jtfname.setText("");
							jtflastName.setText("");
							jtfcin.setText("");
							jtfcountry.setText("");
							jtfcity.setText("");
							jtfadress.setText("");
							jtfnumtel.setText("");}
					} catch (IOException e) {e.printStackTrace();}
				
				}
		
			}
			
				
				
			
		}
		else {
		
			if(event.getSource() == exit){
				ClientAccess ac = new ClientAccess();
				dispose();
				ac.setVisible(true);
			}
			else {
				if(event.getSource() == reset){
					jtfname.setText("");
					jtflastName.setText("");
					jtfcin.setText("");
					jtfcountry.setText("");
					jtfcity.setText("");
					jtfadress.setText("");
                                        
			
				}
				else {
					
						if(rb[0].isSelected()) jtfadress.setText("Street " );
						if(rb[1].isSelected()) jtfadress.setText("Road");
				}
			}
			
		}
	}

}
