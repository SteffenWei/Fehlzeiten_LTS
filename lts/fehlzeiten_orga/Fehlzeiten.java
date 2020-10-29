package fehlzeiten_orga;

import java.util.Date;

import fehlzeiten_orga.main;

public class Fehlzeiten {

	private Date fehltagevon;
	private Date fehltagebis;
	private int fehlstundenvon;
	private int fehlstundenbis;
	private String fehlgrund;
	private String grundsonstige;

//Konstruktor

	public Fehlzeiten(Date fehltagevon, Date fehltagebis, int fehlstundenvon, int fehlstundenbis, String fehlgrund,
			String grundsonstige) {

		this.fehltagevon = fehltagevon;
		this.fehltagebis = fehltagebis;
		this.fehlstundenvon = fehlstundenvon;
		this.fehlstundenbis = fehlstundenbis;
		this.fehlgrund = fehlgrund;
		this.grundsonstige = grundsonstige;
	}

	public Date getFehltagevon() {
		return fehltagevon;
	}

	public void setFehltagevon(Date fehltagevon) {
		this.fehltagevon = fehltagevon;
	}

	public Date getFehltagebis() {
		return fehltagebis;
	}

	public void setFehltagebis(Date fehltagebis) {
		this.fehltagebis = fehltagebis;
	}

	public int getFehlstundenvon() {
		return fehlstundenvon;
	}

	public void setFehlstundenvon(int fehlstundenvon) {
		this.fehlstundenvon = fehlstundenvon;
	}

	public int getFehlstundenbis() {
		return fehlstundenbis;
	}

	public void setFehlstundenbis(int fehlstundenbis) {
		this.fehlstundenbis = fehlstundenbis;
	}

	public String getFehlgrund() {
		return fehlgrund;
	}

	public void setFehlgrund(String fehlgrund) {
		this.fehlgrund = fehlgrund;
	}

	public String getGrundsonstige() {
		return grundsonstige;
	}

	public void setGrundsonstige(String grundsonstige) {
		this.grundsonstige = grundsonstige;
	}

}
