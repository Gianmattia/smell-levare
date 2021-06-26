package web.entity;

public class Artist {
	protected String nome;
	protected String cognome;
	protected String via;
	protected String info;
	private int distanza;
	protected String tipologia;


	
	public Artist() {
	this.nome = "";
	this.cognome = "";
	this.via = "";
	this.info= "";
	this.tipologia= "";
	this.distanza=0;
	
}
	
	public Artist(String nome, String cognome,String via,String info,String tipologia, int distanza) {
		this.nome = nome;
		this.cognome = cognome;
		this.via = via;
		this.info= info;
		this.distanza=distanza;
		this.tipologia=tipologia;

	}	
	public String getnome() {
		return nome;
	}
	
	public String getcognome() {
		return cognome;
	}
	
	public String getvia() {
		return via;
	}
	public String getinfo() {
		return info;
	}
	public int getdistanza() {
		return distanza;
		
	}
	public String gettipologia() {
		return tipologia;
	}
	
	
}