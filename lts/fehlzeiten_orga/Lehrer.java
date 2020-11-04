package fehlzeiten_orga;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Lehrer implements Serializable{

	/**
	 * 
	 */

	private String nname;
	private String vname;
	private String krzl;
	private String persnr;
	private String plz;
	private String strasse;
	private String telnr;
	private String mail;

	private List<Fehlzeiten> flist = new ArrayList<Fehlzeiten>();

	public Lehrer(String nname, String vname, String krzl, String persnr, String plz, String strasse, String telnr,
			String mail) {
		super();
		this.nname = nname;
		this.vname = vname;
		this.krzl = krzl;
		this.persnr = persnr;
		this.plz = plz;
		this.strasse = strasse;
		this.telnr = telnr;
		this.mail = mail;
		this.setFlist(null);

	}

	/*
	 * Ihr müsstet noch eine Methode einbauen, mit der man Fehlzeiten hinzufügen
	 * kann. Diese ruft den Konstruktor Fehlzeiten public Fehlzeiten(Date
	 * fehltagevon,Date fehltagebis, int fehlstundenvon, int fehlstundenbis, String
	 * fehlgrund, String grundsonstige) aus der Klasse Fehlzeiten auf. Die Variablen
	 * müssen in den Methodenaufruf und werden beim Aufruf mitgegeben.
	 */

	public void addFehlzeiten(Date fehltagevon, Date fehltagebis, int fehlstundenvon, int fehlstundenbis,
			String fehlgrund, String grundsonstige) {
		// Vorlage
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getKrzl() {
		return krzl;
	}

	public void setKrzl(String krzl) {
		this.krzl = krzl;
	}

	public String getPersnr() {
		return persnr;
	}

	public void setPersnr(String persnr) {
		this.persnr = persnr;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getTelnr() {
		return telnr;
	}

	public void setTelnr(String telnr) {
		this.telnr = telnr;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	//
	public String toString() {
		return nname + "," + vname + "," + krzl + "," + persnr + "," + plz + "," + strasse + "," + telnr + "," + mail;
	}

	//
	static List<Lehrer> llist = new ArrayList<Lehrer>();

	//
	public static void main(String[] args) {

		Lehrer l0 = new Lehrer("Pinther", "Hubertus", "PINT", "69", "66666, Hades", "Felder von Asphodel 66",
				"66666/666420", "h.pinther@lahntalschule.de");
		llist.add(l0);
		System.out.println(llist.get(0).toString());
		System.out.println(llist.get(0).getNname());

	}

	public List<Fehlzeiten> getFlist() {
		return flist;
	}

	public void setFlist(List<Fehlzeiten> flist) {
		this.flist = flist;
	}
}
/*
 * https://github.com/SteffenWei/Fehlzeiten_LTS
 */
