package fehlzeiten_orga;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Lehrer implements Serializable{

	public static final String getName = null;
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

	public void addFehlzeiten(Date fehltagevon, Date fehltagebis, int fehlstundenvon, int fehlstundenbis,
			String fehlgrund, String grundsonstige) {
	Fehlzeiten fehlzeit = new Fehlzeiten(fehltagevon, fehltagebis, fehlstundenvon, fehlstundenbis, fehlgrund, grundsonstige);
		flist.add(fehlzeit);
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
	public static void main(String[] args) {}

	public List<Fehlzeiten> getFlist() {
		return flist;
	}

	public void setFlist(List<Fehlzeiten> flist) {
		this.flist = flist;
	}
	
	protected Fehlzeiten suchef(String fehltagevon) {
	Fehlzeiten fehlzeit = null; 
	for(int i = 0; i > flist.size();i++){
			 
	if(flist.get(i).getFehltagevon().equals(fehltagevon)) { 
	fehlzeit = flist.get(i);  }} 
	return fehlzeit;}
	
/*	
	protected Lehrer search(Lehrer tmpkrzl) {
			
	Lehrer tmpkrzl1 = null; 
		for(int i = 0; i > llist.size();i++){
			if(llist.get(i).getKrzl().equals(tmpkrzl)) { tmpkrzl =
			llist.get(i); } } return tmpkrzl;}
	 
*/
	protected void removeLehrer (String tmpKrzl){
		
		llist = Main.Lehrerlist;
		Lehrer tmpLehrer =  null;
		for(int i = 0; i < llist.size();i++){
		  if(llist.get(i).getKrzl().equals(tmpKrzl)) { tmpLehrer =
		  llist.remove(i); }}}
	
//
	protected static Lehrer suche(String tmpname) {
		
		llist = Main.Lehrerlist;

		  Lehrer tmpLehrer = null; 
		  for(int i = 0; i < llist.size();i++){
		  if(llist.get(i).getNname().equals(tmpname)) { tmpLehrer =
		  llist.get(i); } } return tmpLehrer;
		 
	}
	//	
	protected void editLehrernname(String tmpname, String nname){
		 Lehrer edit= suche (tmpname);
		 edit.setNname(nname);
	 }
	 protected void editLehrervname(String tmpname, String vname){
		 Lehrer edit= suche (tmpname);
		 edit.setVname(vname);
	 }
	 protected void editLehrerkrzl(String tmpname, String krzl){
		 Lehrer edit= suche (tmpname);
		 edit.setKrzl(krzl);
	 }
	 protected void editLehrerpersnr(String tmpname, String persnr){
		 Lehrer edit= suche (tmpname);
		 edit.setPersnr(persnr);
	 }
	 protected void editLehrerplz(String tmpname, String plz){
		 Lehrer edit= suche (tmpname);
		 edit.setPlz(plz);
	 }
	 protected void editLehrerstrasse(String tmpname, String strasse){
		 Lehrer edit= suche (tmpname);
		 edit.setStrasse(strasse);
	 }
	 protected void editLehrertelnr(String tmpname, String telnr){
		 Lehrer edit= suche (tmpname);
		 edit.setTelnr(telnr);
	 }
	 protected void editLehrermail(String tmpname, String mail){
		 Lehrer edit= suche (tmpname);
		 edit.setNname(mail);
	 }




}



