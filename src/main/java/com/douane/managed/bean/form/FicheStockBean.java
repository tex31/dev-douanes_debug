package com.douane.managed.bean.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.douane.managed.bean.DepositaireBean;
import com.douane.managed.bean.SuiviEditionBean;
@SessionScoped
@ManagedBean(name="FicheStockBean")
public class FicheStockBean {
	private Date date;
	private Date dateF;
	private List<Object[]> liste;
	private String folio;
	private String designation;
	private String espece;
	public FicheStockBean() {
		this.date = new Date();
		this.dateF = new Date();
		this.liste = new ArrayList<Object[]>();
	}
	public String execute(List<Object[]> l) {
		if (l != null) {
			this.liste = l;
			//System.out.println("etat Appreciatif null");
		}
		//this.liste = l;
		return "dialogFicheStock";
	}
	public String execute(SuiviEditionBean s,DepositaireBean d) {
		//suivieditionBean.getListForJournalStockByCod(depositaireBean.articleToFiche)
		if (d != null && s != null) {
			this.liste = s.getListForJournalStockByCod(d.getArticleToFiche(),this.date,this.dateF);
			//#{depositaireBean.articleToFiche.typeObjet.designation} (#{depositaireBean.articleToFiche.designation}
			//this.folio = d.getArticle().getReference();
			this.designation = d.getArticleToFiche().getTypeObjet().getDesignation() + "(" + d.getArticleToFiche().getDesignation() +")";
			if(this.liste.size() > 0)
				this.espece = (String) ((this.liste.get(0)) [8]);
			//System.out.println("etat Appreciatif null");
		}else {
			System.out.println("tsy misy depositaire");
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
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	public Date getDateF() {
		return dateF;
	}
	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}

}
