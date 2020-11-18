package fehlzeiten_orga;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static List<Lehrer> Lehrerlist = new ArrayList<Lehrer>();

	public static void main(String args[]) {

	}

	public static void fzspeichern(String nname, String fehlgrund, Date fehltagevon, Date fehltagebis, int fehlstundenvon, int fehlstundenbis, String grundsonstige) {
		
	Lehrer tmplehrer = suche(nname);
	tmplehrer.addFehlzeiten(fehltagevon, fehltagebis, fehlstundenvon, fehlstundenbis, fehlgrund, grundsonstige);
	
	speichern();
	}

/*  Benennung der Strings  */
	
	
	public static void eingabeLuL(String tmpnname, String tmpvname, String tmpkrzl, String tmppersnr, String tmpplz,
			String tmpstrasse, String tmptelnr, String tmpmail) {

		Lehrer templehrer = new Lehrer(tmpnname, tmpvname, tmpkrzl, tmppersnr, tmpplz, tmpstrasse, tmptelnr, tmpmail);

		Lehrerlist.add(templehrer);
		
		speichern();
		
}
	
/* Löschen und Änderungen von Lehrerdaten  */	
	
	
	
protected void removeLehrer (String tmpname){
		
		Lehrer tmpLehrer = null; 
		  for(int i = 0; i < Lehrerlist.size();i++){
		  if(Lehrerlist.get(i).getNname().equals(tmpname)) { tmpLehrer =
		  Lehrerlist.remove(i); } } 
	
	}
	 protected void editLehrernname(String tmpname, String nname){
		 Lehrer edit= searchkrzl (tmpname);
		 edit.setNname(nname);
	 }
	 protected void editLehrervname(String tmpname, String vname){
		 Lehrer edit= searchkrzl (tmpname);
		 edit.setVname(vname);
	 }
	 protected void editLehrerkrzl(String tmpname, String krzl){
		 Lehrer edit= searchkrzl (tmpname);
		 edit.setKrzl(krzl);
	 }
	 protected void editLehrerpersnr(String tmpname, String persnr){
		 Lehrer edit= searchkrzl (tmpname);
		 edit.setPersnr(persnr);
	 }
	 protected void editLehrerplz(String tmpname, String plz){
		 Lehrer edit= searchkrzl (tmpname);
		 edit.setPlz(plz);
	 }
	 protected void editLehrerstrasse(String tmpname, String strasse){
		 Lehrer edit= searchkrzl (tmpname);
		 edit.setStrasse(strasse);
	 }
	 protected void editLehrertelnr(String tmpname, String telnr){
		 Lehrer edit= searchkrzl (tmpname);
		 edit.setTelnr(telnr);
	 }
	 protected void editLehrermail(String tmpname, String mail){
		 Lehrer edit= searchkrzl (tmpname);
		 edit.setNname(mail);
	 }
	
	 protected Lehrer searchkrzl(String tmpkrzl) {
			
			Lehrer tmpkrzl1 = null; 
			  for(int i = 0; i < Lehrerlist.size();i++){
			  if(Lehrerlist.get(i).getKrzl().equals(tmpkrzl)) { tmpkrzl1 =
			  Lehrerlist.get(i); } } return tmpkrzl1;
	
		}
	 
	
	
	/*  Suche der Lehrerkürzel  */
	 
	 
	

	protected static Lehrer suche(String tmpname) {
		
		
		  Lehrer tmpLehrer = null; 
		  for(int i = 0; i < Lehrerlist.size();i++){
		  if(Lehrerlist.get(i).getNname().equals(tmpname)) { tmpLehrer =
		  Lehrerlist.get(i); } } System.out.println(tmpLehrer.toString()); 
		  return tmpLehrer;
	
	}
	
	
	
		/*  Suche der Lehrernamen  */
		  
		  
	

	private static void ausgabe() {
		for (int i = 0; i < Lehrerlist.size(); i++) {

			System.out.println(Lehrerlist.get(i).toString());
		}
	}
	

	/*  Ausgabe der Daten  */
	
	
	
	public static void laden(){
		try
        {
            FileInputStream fis = new FileInputStream("lehrerdaten");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            Lehrerlist = (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Klasse nicht gefunden");
            c.printStackTrace();
            return;
        }
	}

    public static void speichern(){
    	 try
         {
             FileOutputStream fos = new FileOutputStream("lehrerdaten");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(Lehrerlist);
             oos.close();
             fos.close();
         } 
         catch (IOException ioe) 
         {
             ioe.printStackTrace();
         }
    }
    
}
    
    /* Speicherung der Daten */

