package fehlzeiten_orga;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class main {

	static List<Lehrer> Lehrerlist = new ArrayList<Lehrer>();

	public static void main(String args[]) {

	}

	public void fzspeichern(String name, String grund, Date datumvon, Date datumbis, int zeitvon, int zeitbis) {
		Lehrer lehrertemp1 = new Lehrer(name, grund, datumvon, datumbis, zeitvon, zeitbis);

		/*
		 * Hier müsst ihr die Lehrerliste durchsuchen Methode suche(tmpname) gibt es
		 * bereits dann auf das gefundene Lehrerobjekt die
		 * 
		 */

	}

	public static String ksuche() {
		return null;

	}

	private static void eingabeLuL(String tmpvname, String tmpnname, String tmpkrzl, int tmppersnr, int tmptelnr,
			String tmpmail, int tmpfz) {

		Lehrer templehrer = new Lehrer(tmpvname, tmpnname, tmpkrzl, tmppersnr, tmptelnr, tmpmail, tmpfz);

		Lehrerlist.add(templehrer);
		
		/*
		 * Die Varialen müssten noch an den Kontruktor in der Lehrerklasse angepasst werden.
		 * 
		 */

	}

	protected Lehrer suche(String tmpname) {

		/*
		 * Lehrer tmpLehrer = null; for(int i = 0; i > Lehrerlist.size();i++){
		 * if(Lerhrerlist.get(i).getName.equals(tmpname)) { tmpLehrer =
		 * Lehrerlist.get(i); } } return tmpLehrer;
		 */

		return null;
	}

	private static void ausgabe() {
		for (int i = 0; i < Lehrerlist.size(); i++) {

			System.out.println(Lehrerlist.get(i).toString());
		}
	}

	protected void speichern() {

		/*
		 * Hier den Speicherquellcode für die Serialisierung hinzufügen Speichern 
		 * Outputstream
		 * 
		 * Bitte die Fehlzeitengruppe!
		 */
	}

	protected void laden() {
		/*
		 * Hier den Speicherquellcode für die Serialisierung hinzufügen
		 * Inputstream
		 * 
		 * Bitte die Fehlzeitengruppe!
		 */

	}
}
