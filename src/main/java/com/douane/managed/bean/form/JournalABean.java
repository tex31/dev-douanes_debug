package com.douane.managed.bean.form;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.douane.managed.bean.SuiviEditionBean;
@SessionScoped
@ManagedBean(name="JournalABean")
public class JournalABean {
	private String trois;
	public String getTrois() {
		return trois;
	}
	public void setTrois(String trois) {
		this.trois = trois;
	}
	public String getQuatre() {
		return quatre;
	}
	public void setQuatre(String quatre) {
		this.quatre = quatre;
	}
	private String quatre;
	private Date date;
	private Date datF;
	private List<Object[]> liste;
	private String dateF;
	private String dateD;
	public JournalABean() {
		this.date = new Date();
		this.datF = new Date();
	}
	public String execute(SuiviEditionBean s) {
		this.liste = s.getListForJournalStock(this.date , this.datF);//this.date , this.datF
		DateFormat  df = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
		this.dateD = df.format(this.date);
		this.dateF  = df.format(this.datF);
		this.trois = this.quatre ="tsy misy";
		if(s.getDirection() !=null) {
			this.trois = s.getDirection().getTrois();
			this.quatre = s.getDirection().getQuatre();
		}else System.out.println("tsy tonga ny journal.Direction");
		return "dialogJournalAdmin";
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
	public String getDateD() {
		return dateD;
	}
	public void setDateD(String dateD) {
		this.dateD = dateD;
	}
	public String getDateF() {
		return dateF;
	}
	public void setDateF(String dateF) {
		this.dateF = dateF;
	}
	public Date getDatF() {
		return datF;
	}
	public void setDatF(Date datF) {
		this.datF = datF;
	}

}
