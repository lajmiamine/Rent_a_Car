package personnel;
import java.io.*;

@SuppressWarnings("serial")
public class Vehicul implements Serializable {

	private String maker;
	private String color;
	private String price;
	
	private String vinNumber;
	
	private String dataRent;
	
	private boolean rentable;
	public Vehicul(){
		maker= "";
		color = "";
		price = "";
		vinNumber="";
		
		rentable = false;
		dataRent = "";
	}
	
	
	public String getPrice(){
		return price;
	}
	
	public String getVinNumber(){
		return vinNumber;
	}
	public String getColore(){
		return color;
	}
	public String getMaker(){
		return maker;
	}
	public boolean getRentable(){return rentable;}
	public boolean isRentable(){
		return rentable;
	}
	
	public String getDataRent(){return dataRent;}
	
	public void setDataRent(String data){dataRent=data;}
	public void setPrice(String p){price = p;}
	public void setColore(String c){color = c;}
	public void setMaker(String costr){maker = costr;}
	public void setVinNumber(String imm){vinNumber = imm;}
	public void setrentable(boolean value){rentable = value;}
	
	
	 


}
