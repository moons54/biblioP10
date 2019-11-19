package org.biblio.p7.bean;

public class SituationDemprunt {
	private int iD;
	private String situation;

	public SituationDemprunt(int iD) {
		this.iD = iD;
	}

	public SituationDemprunt() {
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}
}