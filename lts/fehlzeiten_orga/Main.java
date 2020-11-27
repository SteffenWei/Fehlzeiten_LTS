package fehlzeiten_orga;

import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static List<Lehrer> lehrerList = new ArrayList<Lehrer>();
	private static final String endsign = System.getProperty("line.separator");

	/*public static void main(String args[]) {

	}*/

	public static void fzspeichern(String nname, String fehlgrund, Date fehltagevon, Date fehltagebis, int fehlstundenvon, int fehlstundenbis, String grundsonstige, String krzl1) {
		Lehrer tmplehrer = null;
		if(nname == ""){tmplehrer = searchkrzl(krzl1);
		}else{
			tmplehrer = suche(nname);
		}
	
		
	tmplehrer.addFehlzeiten(fehltagevon, fehltagebis, fehlstundenvon, fehlstundenbis, fehlgrund, grundsonstige);
	
	speichern();
	}

/*  Benennung der Strings  */
	
	
	public static void eingabeLuL(String tmpnname, String tmpvname, String tmpkrzl, String tmppersnr, String tmpplz,
			String tmpstrasse, String tmptelnr, String tmpmail) {

		Lehrer templehrer = new Lehrer(tmpnname, tmpvname, tmpkrzl, tmppersnr, tmpplz, tmpstrasse, tmptelnr, tmpmail);

		lehrerList.add(templehrer);
		
		speichern();
		
}
	
/* Löschen und Änderungen von Lehrerdaten  */	
	
	
	
protected void removeLehrer (String tmpname){
		
		Lehrer tmpLehrer = null; 
		  for(int i = 0; i < lehrerList.size();i++){
		  if(lehrerList.get(i).getNname().equals(tmpname)) { tmpLehrer =
		  lehrerList.remove(i); } } 
	
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
	
	 protected static Lehrer searchkrzl(String tmpkrzl) {
			
			Lehrer tmpkrzl1 = null; 
			  for(int i = 0; i < lehrerList.size();i++){
			  if(lehrerList.get(i).getKrzl().equals(tmpkrzl)) { tmpkrzl1 =
			  lehrerList.get(i); } } return tmpkrzl1;
	
		}
	 
	
	
	/*  Suche der Lehrerkürzel  */
	 
	 
	

	protected static Lehrer suche(String tmpname) {
		
		
		  Lehrer tmpLehrer = null; 
		  for(int i = 0; i < lehrerList.size();i++){
		  if(lehrerList.get(i).getNname().equals(tmpname)) { tmpLehrer =
		  lehrerList.get(i); } } System.out.println(tmpLehrer.toString()); 
		  return tmpLehrer;
	
	}
	
	
	
		/*  Suche der Lehrernamen  */
		  
		  
	

	private static void ausgabe() {
		for (int i = 0; i < lehrerList.size(); i++) {

			System.out.println(lehrerList.get(i).toString());
		}
	}
	

	/*  Ausgabe der Daten  */
	
	
	
	public static void laden(){
		try
        {
            FileInputStream fis = new FileInputStream("lehrerdaten");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            lehrerList = (ArrayList) ois.readObject();
 
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
             oos.writeObject(lehrerList);
             oos.close();
             fos.close();
         } 
         catch (IOException ioe) 
         {
             ioe.printStackTrace();
         }
    }
    
    
    //NEU
    
    protected static String auswahl() {
		JFileChooser fc = new JFileChooser();
	    fc.setFileFilter( new FileNameExtensionFilter("Textdateien", ".txt", "*.html", "*.log", "*.csv" ) );

	    int state = fc.showOpenDialog( null );

	    if ( state == JFileChooser.APPROVE_OPTION )
	    {
	      File file = fc.getSelectedFile().getAbsoluteFile();
	      System.out.println( file.getName() );
	      return file.getAbsolutePath();
	    }
	    else
	      System.out.println( "Auswahl abgebrochen" );
	      return "Abgebrochen";
	  }
    
    protected static String auswahlSpei() {
		JFileChooser fc = new JFileChooser();
	    fc.setFileFilter( new FileNameExtensionFilter("Textdateien", ".txt", "*.html", "*.log", "*.csv" ) );

	    int state = fc.showSaveDialog( null );

	    if ( state == JFileChooser.APPROVE_OPTION )
	    {
	      File file = fc.getSelectedFile().getAbsoluteFile();
	      System.out.println( file.getName() );
	      return file.getAbsolutePath();
	    }
	    else
	      System.out.println( "Auswahl abgebrochen" );
	      return "Abgebrochen";
	  }
    
    
    public static List<Lehrer> loadLehrer(String adrLehr) {
		List <Lehrer> tmpLehrerlist = new ArrayList<Lehrer>();
    	Path pathToLehrer = Paths.get(adrLehr);
    	System.out.println(adrLehr);
		try (BufferedReader br = Files.newBufferedReader(pathToLehrer, StandardCharsets.ISO_8859_1))
		{ 
			String line = br.readLine(); 
			
			 
			while (line != null) { 
				
				
				String[] attributes = line.split(","); 
				
				Lehrer tmpLehrer = createLehrer(attributes); 
								
				tmpLehrerlist.add(tmpLehrer); 
				
				
				
				line = br.readLine(); 
				} 
			} catch (IOException ioe) { 
				ioe.printStackTrace(); 
				} 
			return tmpLehrerlist;
			}
		
	
	private static Lehrer createLehrer(String[] attributes) {
		String tmpnname = attributes[0];
		String tmpvname = attributes[1];
		String tmpkrzl = attributes[2]; 
		String tmppersnr = attributes[3];
		String tmpplz = attributes[4]; 
		String tmpstrasse = attributes[5]; 
		String tmptelnr = attributes[6]; 
		String tmpmail = attributes[7];
		
		
		Lehrer tmp1Lehrer = new Lehrer(tmpnname, tmpvname, tmpkrzl, tmppersnr, tmpplz, tmpstrasse, tmptelnr, tmpmail);
		
	return 	tmp1Lehrer;
	}
	
	public List<Lehrer> sort(int l, int r) {
        int q;
        if (l < r) {
            q = partition(l, r);
            sort(l, q);
            sort(q + 1, r);
        }
        return lehrerList;
    }

    int partition(int l, int r) {

        int i, j, x = lehrerList.get((l + r) / 2).getNname().charAt(0);
        i = l - 1;
        j = r + 1;
        while (true) {
            do {
                i++;
            } while (lehrerList.get(i).getNname().charAt(0) < x);

            do {
                j--;
            } while (lehrerList.get(j).getNname().charAt(0) > x);

            if (i < j) {
                Lehrer k = lehrerList.get(i);
                lehrerList.add(i,lehrerList.get(j));
                lehrerList.add(j,k);
            } else {
                return j;
            }
        }
    }
    
    
    public static void export(String adr) {
    	File file = new File(adr);
    	try {
			file.createNewFile();
			FileReader fr = new FileReader(file);
	        BufferedReader br = new BufferedReader(fr);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
            	
    	String ausg = "";
    	for(int i = 0; i<lehrerList.size();i++) {
    		ausg = ausg + lehrerList.get(i).getNname() + "," +  lehrerList.get(i).getVname() + "," +  lehrerList.get(i).getKrzl() + "," +  lehrerList.get(i).getPersnr() + "," +  lehrerList.get(i).getPlz() + "," +  lehrerList.get(i).getStrasse() + "," +  lehrerList.get(i).getTelnr() + "," +  lehrerList.get(i).getMail() + endsign;
    	}
    	FileWriter fw;
		try {
			fw = new FileWriter(adr);
			BufferedWriter bw = new BufferedWriter(fw);
	        
	        bw.write(ausg);
	        bw.close();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

	public static int position(String tmpkrzl) {
		int tmppos = 0;
		  for(int i = 0; i < lehrerList.size();i++){
		  if(lehrerList.get(i).getKrzl().equals(tmpkrzl)) 
		  	{ tmppos = i;
		  	break;} } 
		return tmppos;
	}

    
}
    
    /* Speicherung der Daten */

