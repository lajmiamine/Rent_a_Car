package personnel;

import java.io.*;

@SuppressWarnings("serial")
public class Client extends Personnel implements Serializable{
	private String numtel;
	private int code;
	String chaine;
	public Client() {
		super();
		code=(int)(Math.random()*1000+1);
		chaine = Integer.toString(code);
		numtel="";
	}
	
	public String getNumTel(){
		return numtel;
		}
	
	public String getCode(){return chaine;}
	
	
	public void setNumTel(String nt){numtel = nt;}
	
	
	public void setCod(String cod){chaine = cod;}
	

}
