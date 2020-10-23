package fehlzeiten_orga;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;






public class main {
	
	static List <Lehrer> Lehrerlist = new ArrayList<Lehrer>();
	
public static void main(String args[]){
	
	
	
	
	
}

public void fzspeichern(String name, String grund,Date datumvon, Date datumbis, int zeitvon, int zeitbis){
	Lehrer lehrertemp1 = new Lehrer(name,grund,datumvon,datumbis,zeitvon,zeitbis);
}	

public static String ksuche(){
	return null; 
	
}

private static void eingabeLuL(String tmpvname, String tmpnname, String tmpkrzl, int tmppersnr, int tmptelnr, String tmpmail, int  tmpfz){
	
	

	Lehrer templehrer = new Lehrer(tmpvname, tmpnname, tmpkrzl, tmppersnr, tmptelnr, tmpmail, tmpfz);
	
	Lehrerlist.add(templehrer);
	
	
	
	
}

protected Lehrer suche(String tmpname){
	
	
	return null;
}

private static void ausgabe(){
	for(int i = 0; i < Lehrerlist.size(); i++){
		
		System.out.println(Lehrerlist.get(i).toString());
	}
}

}
