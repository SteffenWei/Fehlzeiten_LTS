package fehlzeiten_orga;

public class Buecher {

	private String name;
	private String autor;
	private String thema;
	private int ausgeliehen;
	private int ISBN;
	private int id;
	
	
//Konstruktor
	
	public Buecher(String name, String autor, String thema, int ausgeliehen, int ISBN, int id){
		super();
		this.name = name;
		this.autor = autor;
		this.thema = thema;
		this.ausgeliehen = ausgeliehen;
		this.ISBN = ISBN;
		this.id = id;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getThema() {
		return thema;
	}


	public void setThema(String thema) {
		this.thema = thema;
	}


	public int getAusgeliehen() {
		return ausgeliehen;
	}


	public void setAusgeliehen(int ausgeliehen) {
		this.ausgeliehen = ausgeliehen;
	}


	public int getISBN() {
		return ISBN;
	}


	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "name " + "von " + "autor" + "thema: ";
	}
	
}
