package personnel;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class RentedVehicul extends Vehicul implements Serializable{
	Date releaseDate;
	String rentalDate;
	Client client;
	String rentalNumber;
	String nameC;
	String ni;
	public RentedVehicul(){
		super();
		ni = "";
		rentalDate="";
		rentalNumber="";
		nameC = "";
		client = null;
	}
	public String getNameC(){return nameC;}
	public String getEntryDate(){
		return rentalDate;}
	public Date getReleaseDate(){
		return releaseDate;}
	
	public String getRentNumber(){return rentalNumber;}
	public void setRentNumber(String cf){rentalNumber = cf; }
	public void setNameC(String n){nameC = n;}
	public void setReleaseDate(Date date){releaseDate = date;}
	
}

