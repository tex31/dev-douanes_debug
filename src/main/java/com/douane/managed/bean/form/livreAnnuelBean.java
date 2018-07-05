package com.douane.managed.bean.form;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.douane.managed.bean.SuiviEditionBean;
@SessionScoped
@ManagedBean(name="livreAnnuelBean")
public class livreAnnuelBean {
	private String trois;
	private String quatre;
	private Date d;
	private Integer anne;
	private List<Object[]> liste;
	public livreAnnuelBean() {
		this.d = new Date();
	}
	public String execute(SuiviEditionBean s) {
		this.setListe(s.getListESForGrandLivre());
		this.trois  = s.getDirection().getTrois();
		this.quatre =  s.getDirection().getQuatre();
		return "dialogLivre";
	}
	public String executer(SuiviEditionBean s, Integer i) {
		this.anne = i;
		this.trois  = s.getDirection().getTrois();
		this.quatre =  s.getDirection().getQuatre();
		Date sdate = new GregorianCalendar(i, Calendar.JANUARY, 1).getTime();
		Date edate = new GregorianCalendar(i, Calendar.DECEMBER, 31).getTime();
		this.liste=s.getListESForGrandLivre(sdate,edate);
		return "dialogLivre"; 
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public List<Object[]> getListe() {
		return liste;
	}
	public void setListe(List<Object[]> liste) {
		this.liste = liste;
	}
	public Integer getAnne() {
		return anne;
	}
	public void setAnne(Integer anne) {
		this.anne = anne;
	}
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

}
