package org.biblio.p7.bean;

import java.util.ArrayList;

public class Genre {
	private int iD;
	private String intituleGenre;
	private String descriptionGenre;
	private String webographie;
	//private ArrayList<Ouvrage> ouvrage = new ArrayList<Ouvrage>();


	public Genre(int iD) {
		this.iD = iD;
	}

	public Genre() {
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getIntituleGenre() {
		return intituleGenre;
	}

	public void setIntituleGenre(String intituleGenre) {
		this.intituleGenre = intituleGenre;
	}

	public String getDescriptionGenre() {
		return descriptionGenre;
	}

	public void setDescriptionGenre(String descriptionGenre) {
		this.descriptionGenre = descriptionGenre;
	}

	public String getWebographie() {
		return webographie;
	}

	public void setWebographie(String webographie) {
		this.webographie = webographie;
	}

	/*public ArrayList<Ouvrage> getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(ArrayList<Ouvrage> ouvrage) {
		this.ouvrage = ouvrage;
	}*/

	@Override
	public String toString() {
		return "Genre{" +
				"iD=" + iD +
				", intituleGenre='" + intituleGenre + '\'' +
				", descriptionGenre='" + descriptionGenre + '\'' +
				", webographie='" + webographie + '\'' +
			//	", ouvrage=" + ouvrage +
				'}';
	}
}