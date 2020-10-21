package fehlzeiten_orga;





import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;






public class main {
	
	static List <Lehrer> Lehrerlist = new ArrayList<Lehrer>();
	
public static void main(String args[]){
	
	
	
	
	
}


public static String ksuche(){ 

	
public void fzspeichern(String name, String grund,date datumvon, date datumbis, int zeitvon, int zeitbis){
	Lehrer lehrertemp1 = new Lehrer(name,grund,datumvon,datumbis,zeitvon,zeitbis);
}	
	
	
	
}
private static void eingabeLuL(String tmpvname, String tmpnname, String tmpkrzl, int tmppersnr, int tmptelnr, String tmpmail, int  tmpfz){
	
	

	Lehrer templehrer = new Lehrer(tmpvname, tmpnname, tmpkrzl, tmppersnr, tmptelnr, tmpmail, tmpfz);
	
	Lehrerlist.add(templehrer);
	
	
	
	
}

protected Lehrer suche(String tmpname){
	
	
	return ;
}

private static void ausgabe(){
	for(int i = 0; i < Lehrerlist.size(); i++){
		
		System.out.println(Lehrerlist.get(i).toString());
	}
}

}
