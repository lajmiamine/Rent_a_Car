package personnel;

import java.io.*;

public  class Personnel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String lastName;
	private String cin;
	private String country;
	private String city;
	private String adress;
	private String day;
	private String month;
	private String year; 
	
	public Personnel(){
		name = "";
		lastName ="";
		cin = "";
		country = "";
		city = "";
		adress = "";
		day = "";
		month = "";
		year = "";
	}
	
	public String getName(){
		return name;
		
	}
	public String getLastName(){
		return lastName;
		
	}
	public String getCIN(){
		return cin;
	}
	public String getCountry(){return country;}
	public String getCity(){return city;}
	public String getAdress(){return adress;}
	public String getBornDay(){return day;}
	public String getBornMonth(){return month;}
	public String getBornYear(){return year;}
	
	
	public void setCIN(String val){cin = val;}
	public void setName(String n){name = n;}
	public void setLastName(String c){lastName = c;}
	public void setCountry(String count){country=count;}
	public void setCity(String city){this.city = city;}
	public void setAdress(String ind){adress = ind;}
	public void setBornDay(String dataN){day = dataN;}
	public void setBornMonth(String mN){month=mN;}
	public void setBornYear(String aN){year = aN;}
}
