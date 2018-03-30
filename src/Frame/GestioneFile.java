package Frame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import personnel.Vehicul;

public class GestioneFile {

	public Vector<Vehicul> ReadFile (String fileName){ 
	    Vector<Vehicul> vLecture=new Vector<Vehicul>();
	    try{
	      ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName));
	      int n=ois.readInt();

	      for(int i=0;(i<n);i++){
	      vLecture.addElement((Vehicul) ois.readObject());
	    	 
	    }

	      ois.close();
	      }catch(Exception e){;}
	      return vLecture;
	      
	  }
	  
	  public void Scrivi(Vector<?> vNouv, String mode, String fileName)throws IOException{
		  		File fich=new File(fileName);

			      if(fich.exists()&&mode=="add"){
			        GestioneFile f=new GestioneFile();
			       Vector<Vehicul> vL=f.ReadFile(fileName);
			       ObjectOutputStream ecrit=new ObjectOutputStream(new FileOutputStream(fileName));
			           ecrit.writeInt(vL.size()+vNouv.size());

			           for(int i=0;(i<vL.size());i++){
			            ecrit.writeObject(vL.elementAt(i));
			          }
			          for(int i=0;(i<vNouv.size());i++){
			           ecrit.writeObject(vNouv.elementAt(i));
			          }
			            ecrit.close();

			      }

			  else{

			      ObjectOutputStream ecrit=new ObjectOutputStream(new FileOutputStream(fileName));
			          ecrit.writeInt(vNouv.size());
			          for(int i=0;(i<vNouv.size());i++){
			            ecrit.writeObject(vNouv.elementAt(i));
			          }
			        ecrit.close();

			      }
			  }


}
