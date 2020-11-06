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

	public void fzspeichern(String nname, String fehlgrund, Date fehltagevon, Date fehltagebis, int fehlstundenvon, int fehlstundenbis, String grundsonstige) {
		
	Lehrer tmplehrer = suche(nname);
	tmplehrer.addFehlzeiten(fehltagevon, fehltagebis, fehlstundenvon, fehlstundenbis, fehlgrund, grundsonstige);
	}

	public static String ksuche() {
		return null;

	}

	public static void eingabeLuL(String tmpnname, String tmpvname, String tmpkrzl, String tmppersnr, String tmpplz,
			String tmpstrasse, String tmptelnr, String tmpmail) {

		Lehrer templehrer = new Lehrer(tmpnname, tmpvname, tmpkrzl, tmppersnr, tmpplz, tmpstrasse, tmptelnr, tmpmail);

		Lehrerlist.add(templehrer);
		
		speichern();
		

	}

	protected Lehrer suche(String tmpname) {
		
		
		  Lehrer tmpLehrer = null; 
		  for(int i = 0; i > Lehrerlist.size();i++){
		  if(Lehrerlist.get(i).getNname().equals(tmpname)) { tmpLehrer =
		  Lehrerlist.get(i); } } return tmpLehrer;
		 

		
	}

	private static void ausgabe() {
		for (int i = 0; i < Lehrerlist.size(); i++) {

			System.out.println(Lehrerlist.get(i).toString());
		}
	}

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
