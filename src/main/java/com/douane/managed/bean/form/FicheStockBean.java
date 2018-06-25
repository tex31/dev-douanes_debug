package com.douane.managed.bean.form;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@SessionScoped
@ManagedBean(name="FicheStockBean")
public class FicheStockBean {
	private Date date;
	private List<Object[]> liste;
	public FicheStockBean() {
		this.date = new Date();
	}
	public String execute(List<Object[]> l) {
		if (l != null) {
			this.liste = l;
			//System.out.println("etat Appreciatif null");
		}
		//this.liste = l;
		return "dialogFicheStock";
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Object[]> getListe() {
		return liste;
	}
	public void setListe(List<Object[]> liste) {
		this.liste = liste;
	}

}
