package com.douane.managed.bean;

import com.douane.entite.*;
import com.douane.metier.referentiel.IRefMetier;
import com.douane.metier.user.IUserMetier;
import com.douane.model.EtatOperation;
import come.douane.dao.operation.IOperationDAO;

import org.hamcrest.core.IsInstanceOf;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.SessionScoped;
import java.util.*;

import org.springframework.stereotype.Component;

import com.douane.requesthttp.RequestFilter;

/**
 * Created by hasina on 11/3/17.
 */

@ManagedBean(name = "suivieditionBean")
@ViewScoped
public class SuiviEditionBean {

	@ManagedProperty(value = "#{usermetier}")
	IUserMetier usermetierimpl;

	private Agent agentOperateur;
	private Direction direction;
	private Date startDate;
	private Date endDate;

	private Operation curentOperation;

	public IOperationDAO getOperationdao() {
		return operationdao;
	}

	public void setOperationdao(IOperationDAO operationdao) {
		this.operationdao = operationdao;
	}

	@Autowired
	@ManagedProperty(value = "#{operationdao}")
	private IOperationDAO operationdao;

	/*
	 * private List<OpEntree> listOperationEntree; private List<OpSortie>
	 * listOperationSortie; private List<Operation> listOperatoinByOperateur;
	 * private List<OpEntree> listOperationEntreeByOperator; private List<OpSortie>
	 * listOperationSortieByOperator; private List<Operation>
	 * listOperatoinByDirection; private List<OpEntree>
	 * listOperationEntreeByDirection; private List<OpSortie>
	 * listOperationSortieByDirection; private List<Operation> listOperationBetween;
	 * private List<OpEntree> listOperationEntreeByMateriel; private List<OpSortie>
	 * listOperationSortieByMateriel; private List<OpEntree>
	 * listOperationEntreeByMaterielByDate; private List<OpSortie>
	 * listOperationSortieByMaterielByDate; private List<OpAttribution>
	 * listOperationAttribution; private List<OpDettachement>
	 * listOperationDetachement; private List<OpAttribution>
	 * listOperationAttributionByOperator; private List<OpDettachement>
	 * listOperationDetachementByOperator; private List<OpAttribution>
	 * listOperationAttributionByDirection; private List<OpDettachement>
	 * listOperationDeetachementByDirection; private List<OpAttribution>
	 * listOperationAttributionByMateriel; private List<OpDettachement>
	 * listOperationDetachementByMateriel;
	 */

	private Materiel materiel;

	private int annee;

	// ----------ALL LIST BY METHOD------------------
	private List<Operation> listAllOperation;
	private List<OpEntree> listOperationEntree;
	private List<OpSortie> listOperationSortie;
	private List<Operation> listOperationByOperateur;
	private List<OpEntree> listOperationEntreeByOperator;
	private List<OpSortie> listOperationSortieByOperator;
	private List<Operation> listOperatoinByDirection;
	private List<OpEntree> listOperationEntreeByDirection;
	private List<OpSortie> listOperationSortieByDirection;
	private List<Operation> listOperationBetween;

	private List<Operation> listOperationByDirectionByYearByDateAsc;

	private List<OpEntree> listOperationEntreeByMateriel;
	private List<OpSortie> listOperationSortieByMateriel;
	private List<OpEntree> listOperationEntreeByMaterielByDate;
	private List<OpSortie> listOperationSortieByMaterielByDate;
	private List<OpAttribution> listOperationAttribution;
	private List<OpDettachement> listOperationDetachement;
	private List<OpAttribution> listOperationAttributionByOperator;
	private List<OpDettachement> listOperationDetachementByOperator;
	private List<OpDettachement> listOperationDetachementByDirection;
	private List<OpAttribution> listOperationAttributionByDirection;
	private List<OpDettachement> listOperationDeetachementByDirection;
	private List<OpAttribution> listOperationAttributionByMateriel;
	private List<OpDettachement> listOperationDetachementByMateriel;

	// ----------ALL LIST BY METHOD------------------

	private List<Materiel> listMaterielByDet;

	private Float total;

	public void setAnnee(int t) {
		this.annee = t;
	}

	public int getAnnee() {
		return this.annee;
	}

	public String setAnnee1(int t) {
		this.annee = t;
		return "annee";
	}

	public void setTotal(Float t) {
		this.total = t;
	}

	public Float getTotal() {
		return this.total;
	}

	public void setListMaterielByDet(List<Materiel> listMateriel) {
		this.listMaterielByDet = listMateriel;
	}

	public List<Materiel> getListMaterielByDet() {
		// List<Materiel> listmatcorrespondant;
		if (listMaterielByDet == null) {
			return usermetierimpl.getListMat();
		} else {
			// return usermetierimpl.getListMatByDet(getDetenteur());
			return listMaterielByDet;
		}
	}

	public List<Operation> getListAllOperation() {
		return usermetierimpl.getListOp();
	}

	public void setListAllOperation(List<Operation> l) {
		this.listAllOperation = l;
	}

	public List<OpEntree> getListOperationEntree() {
		// setListOperationEntree(usermetierimpl.getListOpEntree());
		// return listOperationEntree;
		return usermetierimpl.getListOpEntree();

	}

	public void setListOperationEntree(List<OpEntree> l) {

		this.listOperationEntree = l;
	}

	public List<OpSortie> getListOperationSortie() {
		return usermetierimpl.getListOpSortie();
	}

	public void setListOperationSortie(List<OpSortie> l) {
		this.listOperationSortie = l;
	}

	// get Agent and set Agent operator
	public Agent getAgentOperateur() {
		return agentOperateur;
	}

	public void setAgentOperateur(Agent agentOperateur) {
		this.agentOperateur = agentOperateur;
	}

	// -------------GET List of operations by OPERATOR
	// --------------------------------
	// get direction
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Operation> getListOperationByOperateur() {
		return usermetierimpl.getListOpByOperator(this.agentOperateur);
	}

	public void setListOperationByOperateur(List<Operation> l) {
		this.listOperationByOperateur = l;
	}

	public List<OpEntree> getListOperationEntreeByOperator() {
		return usermetierimpl.getListOpEntreeByOperator(this.agentOperateur);
	}

	public void setListOperationEntreeByOperator(List<OpEntree> l) {
		this.listOperationEntreeByOperator = l;
	}

	public List<OpSortie> getListOperationSortieByOperator() {
		return usermetierimpl.getListOpSortieByOperator(this.agentOperateur);
	}

	public void setListOperationSortieByOperator(List<OpSortie> l) {
		this.listOperationSortieByOperator = l;
	}

	// -------------GET List of operations by DIRECTION
	// --------------------------------
	public List<Operation> getListOperatoinByDirection() {
		Agent agent = (Agent) RequestFilter.getSession().getAttribute("agent");
		return usermetierimpl.getListOpByDirection(agent.getDirection());
	}

	public void setListOperatoinByDirection(List<Operation> l) {
		this.listOperatoinByDirection = l;
	}

	public List<OpEntree> getListOperationEntreeByDirection() {
		Agent agent = (Agent) RequestFilter.getSession().getAttribute("agent");
		return usermetierimpl.getListOpEntreeByDirection(agent.getDirection());
	}

	public void setListOperationEntreeByDirection(List<OpEntree> l) {
		this.listOperationEntreeByDirection = l;
	}

	public List<OpSortie> getListOperationSortieByDirection() {
		Agent agent = (Agent) RequestFilter.getSession().getAttribute("agent");
		return usermetierimpl.getListOpSortieByDirection(agent.getDirection());
	}

	public void setListOperationSortieByDirection(List<OpSortie> l) {
		this.listOperationSortieByDirection = l;
	}

	// ------------GET List of Operations By DATE-------------------
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Operation> getListOperationBetween(Date startDate, Date endDate) {
		return getListOperationBetween(startDate, endDate);
	}

	public void setListOperationBetween(List<Operation> l) {
		this.listOperationBetween = l;
	}

	public List<Operation> getListOperationByDirectionByYearByDateAsc() {
		// return getListOperationBetween(startDate, endDate);

		Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
		Date sdate = new GregorianCalendar(getAnnee(), Calendar.JANUARY, 1).getTime();
		Date edate = new GregorianCalendar(getAnnee(), Calendar.DECEMBER, 30).getTime();
		return usermetierimpl.getListOperationByDirectionByYearByDateAsc(cur.getDirection(), sdate, edate);
	}

	public void setListOperationByDirectionByYearByDateAsc(List<Operation> l) {
		this.listOperationByDirectionByYearByDateAsc = l;
	}

	// ------------GET List of Operations By Materiel-------------------
	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Long materielid) {
		Materiel a = usermetierimpl.getMatById(materielid);
		System.out.print(
				"======================================SET MAT================================================================="+materielid);

		this.materiel = a;
	}

	public List<OpEntree> getListOperationEntreeByMateriel() {
		return usermetierimpl.getListOpEntreeByMat(getMateriel());
	}

	public void setListOperationEntreeByMateriel(List<OpEntree> l) {
		this.listOperationEntreeByMateriel = l;
	}

	public List<OpSortie> getListOperationSortieByMateriel() {
		return usermetierimpl.getListOpSortieByMat(getMateriel());
	}

	public void setListOperationSortieByMateriel(List<OpSortie> l) {
		this.listOperationSortieByMateriel = l;
	}

	// ------------GET List of Materiel By Date-------------------
	public List<OpEntree> getListOperationEntreeByMaterielByDate(Date startDate, Date endDate) {
		return usermetierimpl.getListOpEntreeByMatBDate(getMateriel(), startDate, endDate);
	}

	public void setListOperationEntreeByMaterielByDate(List<OpEntree> l) {
		this.listOperationEntreeByMaterielByDate = l;
	}

	public List<OpSortie> getListOperationSortieByMaterielByDate(Date startDate, Date endDate) {
		return usermetierimpl.getListOpSortieByMatBDate(getMateriel(), startDate, endDate);
	}

	public void setListOperationSortieByMaterielByDate(List<OpSortie> l) {
		this.listOperationSortieByMaterielByDate = l;
	}

	// ------------------liste des operations atributions et dettachements
	// ---------------------
	public List<OpAttribution> getListOperationAttribution() {
		return usermetierimpl.getListOpAttribution();
	}

	public void setListOperationAttribution(List<OpAttribution> l) {
		this.listOperationAttribution = l;
	}

	public List<OpDettachement> getListOperationDetachement() {
		return usermetierimpl.getListOpDettachement();
	}

	public void setListOperationDetachement(List<OpDettachement> l) {
		this.listOperationDetachement = l;
	}

	public List<OpAttribution> getListOperationAttributionByOperator() {
		return usermetierimpl.getListOpAttrByOperator(getAgentOperateur());
	}

	public void setListOperationAttributionByOperator(List<OpAttribution> l) {
		this.listOperationAttributionByOperator = l;
	}

	public List<OpDettachement> getListOperationDetachementByOperator() {
		return usermetierimpl.getListOpDettByOperatort(getAgentOperateur());
	}

	public void setListOperationDetachementByOperator(List<OpDettachement> l) {
		this.listOperationDetachementByOperator = l;
	}

	public List<OpAttribution> getListOperationAttributionByDirection() {
		Agent agent = (Agent) RequestFilter.getSession().getAttribute("agent");
		return usermetierimpl.getListOpAttrByDirection(agent.getDirection());
	}

	public void setListOperationAttributionByDirection(List<OpAttribution> l) {
		this.listOperationAttributionByDirection = l;
	}

	public List<OpDettachement> getListOperationDeetachementByDirection() {
		Agent agent = (Agent) RequestFilter.getSession().getAttribute("agent");
		return usermetierimpl.getListOpDettByDirection(agent.getDirection());
	}

	public void setListOperationDeetachementByDirection(List<OpDettachement> l) {
		this.listOperationDeetachementByDirection = l;
	}

	public List<OpAttribution> getListOperationAttributionByMateriel() {
		return usermetierimpl.getListOpAttrByMat(getMateriel());
	}

	public List<OpAttribution> getListOperationAttributionByMateriel1(Materiel m) {
		return usermetierimpl.getListOpAttrByMat(m);
	}

	public void setListOperationAttributionByMateriel(List<OpAttribution> l) {
		this.listOperationAttributionByMateriel = l;
	}

	public List<OpDettachement> getListOperationDetachementByMateriel() {
		return usermetierimpl.getListOpDettByMat(getMateriel());
	}

	public void setListOperationDetachementByMateriel(List<OpDettachement> l) {
		this.listOperationDetachementByMateriel = l;
	}

	// ----------------NEW SETTER AND GETTER---------------------

	public IUserMetier getUsermetierimpl() {
		return usermetierimpl;
	}

	public void setUsermetierimpl(IUserMetier usermetierimpl) {
		this.usermetierimpl = usermetierimpl;
	}

	public void setCurentOperation(Operation operation) {
		this.curentOperation = operation;
	}

	public void setCurentOperation2(Operation operation) {
		this.curentOperation = operation;

		if (((OpAttribution) operation).getDetenteur() != null) {
			this.setListMaterielByDet(usermetierimpl.getListMatByDet(((OpAttribution) operation).getDetenteur()));

			ListIterator<Materiel> it = this.getListMaterielByDet().listIterator();
			if (it != null) {
				this.setTotal(Float.parseFloat("0"));
				while (it.hasNext()) {
					setTotal(this.total + (Float) (it.next().getPu()));
				}
			}
		} else {

		}

	}

	public Operation getCurentOperation() {
		return this.curentOperation;
	}

	// -----------------GETTER AND SETTER FOR OPERATION --------------
	private List<OpEntree> listOpEn;
	private List<OpSortie> listOpSo;
	private List<OpAttribution> listOpAttr;
	private List<OpDettachement> listOpDet;

	public List<OpEntree> getListOpEn() {
		return usermetierimpl.getListOpEntreeByMatAndByState(getMateriel(), EtatOperation.ACCEPTED);
	}

	public void setListOpEn(List<OpEntree> listOpEn) {
		this.listOpEn = listOpEn;
	}

	public List<OpSortie> getListOpSo() {
		return usermetierimpl.getListOpSortieByMatAndByState(getMateriel(), EtatOperation.ACCEPTED);
	}

	public void setListOpSo(List<OpSortie> listOpSo) {
		this.listOpSo = listOpSo;
	}

	public List<OpAttribution> getListOpAttr() {
		return usermetierimpl.getListOpAttrByMatAndByState(getMateriel(), EtatOperation.ACCEPTED);
	}

	public void setListOpAttr(List<OpAttribution> listOpAttr) {
		this.listOpAttr = listOpAttr;
	}

	public List<OpDettachement> getListOpDet() {
		return usermetierimpl.getListOpDettByMatAndByState(getMateriel(), EtatOperation.ACCEPTED);
	}

	public void setListOpDet(List<OpDettachement> listOpDet) {
		this.listOpDet = listOpDet;
	}

	// -----------------TO DO 30 12--------------
	private List<Operation> listOpEntreeAndSortieByDirectionByYearByDateAsc;

	public List<Operation> getListOpEntreeAndSortieByDirectionByYearByDateAsc() {
		Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
		Date sdate = new GregorianCalendar(2010, Calendar.JANUARY, 1).getTime();
		Date edate = new GregorianCalendar(2018, Calendar.DECEMBER, 30).getTime();
		// List<Operation> l =
		// usermetierimpl.getListOpEntreeAndSortieByDirectionByYearByDateAsc(cur.getDirection(),
		// sdate, edate);
		System.out.print(
				"=======================================================================================================");
		System.out.print(
				"=======================================================================================================");
		System.out.print(
				"=======================================================================================================");
		List<Operation> l = operationdao.getListOpEntreeAndSortieByDirectionByYearByDateAsc(cur.getDirection(), sdate,
				edate);
		for (Operation o : l) {
			System.out.print("listOperation=======" + o.getState());
		}
		return usermetierimpl.getListOpEntreeAndSortieByDirectionByYearByDateAsc(cur.getDirection(), sdate, edate);
		// return
		// usermetierimpl.getListOpEntreeAndSortieByDirectionByYearByDateAsc(cur.getDirection(),
		// getStartDate(), getEndDate());
	}

	public void setListOpEntreeAndSortieByDirectionByYearByDateAsc(
			List<Operation> listOpEntreeAndSortieByDirectionByYearByDateAsc) {
		this.listOpEntreeAndSortieByDirectionByYearByDateAsc = listOpEntreeAndSortieByDirectionByYearByDateAsc;
	}

	// -------TEST FINAL-------

	public List<OpEntree> getListOpEntreeByDirectionByYearByDateAsc(Direction d, Date startDate, Date endDate) {
		return usermetierimpl.getListOpEntreeByDirectionByYearByDateAsc(d, startDate, endDate);
	}

	public List<OpSortie> getListOpSortieByDirectionByYearByDateAsc(Direction d, Date startDate, Date endDate) {
		return usermetierimpl.getListOpSortieByDirectionByYearByDateAsc(d, startDate, endDate);
	}

	// -----NEW FORM OF GETTER
	private List<OperationES> listOpESForJournal;

	public List<OperationES> getListOpESForJournal() {
		Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		Date sdate = new GregorianCalendar(year - 2, Calendar.JANUARY, 1).getTime();
		Date edate = new GregorianCalendar(year + 1, Calendar.DECEMBER, 30).getTime();
		return usermetierimpl.getListOpESForJournal(cur.getDirection(), sdate, edate);
	}

	public void setListOpESForJournal(List<OperationES> listOpESForJournal) {
		this.listOpESForJournal = listOpESForJournal;
	}

	private List<OpSortie> listOpSortieValideByDirection;

	public List<OpSortie> getListOpSortieValideByDirection() {
		Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
		return usermetierimpl.getListOpSortieValideByDirection(cur.getDirection());
	}

	public void setListOpSortieValideByDirection(List<OpSortie> listOpSortieValideByDirection) {
		this.listOpSortieValideByDirection = listOpSortieValideByDirection;
	}

	// ------------EDITION

	public void setListobjectForInvetaire(List<Object[]> listobjectForInvetaire) {
		this.listobjectForInvetaire = listobjectForInvetaire;
	}

	public List<OpEntree> getListOpentreeForOrdre() {
		Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
		return usermetierimpl.listOpentreeByStateByDirection(EtatOperation.ACCEPTED, cur.getDirection());
	}

	public void setListOpentreeForOrdre(List<OpEntree> listOpentreeForOrdre) {
		this.listOpentreeForOrdre = listOpentreeForOrdre;
	}

	private List<Object[]> listobjectForInvetaire;

	private List<OpEntree> listOpentreeForOrdre;

	/*
	 * LISTE OF METHODS FOR CA EDITIONS
	 * 
	 */

	private List<Operation> listOpESArtByDirection;

	public List<Operation> getListOpESArtByDirection() {
		Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		Date sdate = new GregorianCalendar(year - 2, Calendar.JANUARY, 1).getTime();
		Date edate = new GregorianCalendar(year + 1, Calendar.DECEMBER, 30).getTime();
		return usermetierimpl.getListOpESArtValideByDirection(cur.getDirection(), sdate, edate);
	}

	public void setListOpESArtByDirection(List<Operation> listOpESArtByDirection) {
		this.listOpESArtByDirection = listOpESArtByDirection;
	}

	private List<Object[]> listESForJournal;

	public List<Object[]> getListESForJournal() {
		if (listESForJournal == null) {
			Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
			Date date = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			Date sdate = new GregorianCalendar(year - 2, Calendar.JANUARY, 1).getTime();
			Date edate = new GregorianCalendar(year + 1, Calendar.DECEMBER, 30).getTime();
			List<OperationES> listop = usermetierimpl.getListOpESForJournal(cur.getDirection(), sdate, edate);
			List<Object[]> listobjectForJournal = new ArrayList<Object[]>();
			for (OperationES op : listop) {
				Object[] row = new Object[12];
				if (op instanceof OpEntree) {
					List<Object[]> bydesignation1 = (this.getDesingationByOpEntree(op));

					for (Object[] nom : bydesignation1) {
						List<Object[]> liste = (List<Object[]>) nom[2];
						for (Object[] des : liste) {
							Designation d = (Designation) des[0];
							// id
							row[0] = op.getId();
							// numero d'ordre
							row[1] = op.getNumoperation();
							// date
							row[2] = op.getDate();
							// origine
							row[3] = d.getOrigine();
							// designation
							row[4] = d.getTypematerieladd().getDesignation() + " - " + d.getMarque() + " - "
									+ d.getRenseignement() + " - "
							// mat.getNumSerie();
							;
							// espece unite
							row[5] = d.getEspeceUnite();
							// pu
							row[6] = d.getPu();
							// nombre par desingation entree
							row[7] = des[1];
							// total entree
							row[8] = d.getPu() * (Long) row[7];
							// nombre par desingation sortie
							row[9] = new Long(0);
							// total sortie
							row[10] = new Float(0);
							row[11] = d;
							listobjectForJournal.add(row);
							row = new Object[12];
						}
					} /*
						 * for(Materiel mat :((OpEntree) op).getListMat()) { //id row[0] = op.getId();
						 * //numero d'ordre row[1] = op.getNumoperation(); //date row[2] = op.getDate();
						 * //origine row[3] = mat.getDesign().getOrigine(); // designation row[4] =
						 * mat.getDesign().getTypematerieladd().getDesignation() + " - " +
						 * mat.getDesign().getMarque() + " - " + mat.getDesign().getRenseignement() +
						 * " - " + mat.getNumSerie(); //espece unite row[5] =
						 * mat.getDesign().getEspeceUnite(); //pu row[6] = mat.getDesign().getPu();
						 * //nombre par desingation entree row[7] = 1; //total entree row[8] =
						 * mat.getDesign().getPu()*(Integer)row[7]; //nombre par desingation sortie
						 * row[9] = 0; //total sortie row[10] = 0; row[11] = mat;
						 * listobjectForJournal.add(row); row = new Object[12]; }
						 */

				} else if (op instanceof OpSortie) {
					// id
					row[0] = op.getId();
					// numero d'ordre
					row[1] = op.getNumoperation();
					// date
					row[2] = op.getDate();
					// origine
					row[3] = ((OpSortie) op).getMotifsortie().getDesignation();
					// designation
					Materiel mat = op.getMat();
					row[4] = mat.getDesign().getTypematerieladd().getDesignation() + " - " + mat.getDesign().getMarque()
							+ " - " + mat.getDesign().getRenseignement() + " - " + mat.getNumSerie();
					// espece unite
					row[5] = mat.getDesign().getEspeceUnite();
					// pu
					row[6] = mat.getDesign().getPu();
					// nombre par desingation entree
					row[7] = new Long(0);
					// total entree
					row[8] = new Float(0);
					// nombre par desingation sortie
					row[9] = 1L;
					// total sortie
					row[10] = mat.getDesign().getPu() * (Long) row[9];
					row[11] = mat.getDesign();
					listobjectForJournal.add(row);
					row = new Object[12];
				}
			}

			listESForJournal = listobjectForJournal;

		}

		return listESForJournal;
	}

	public void setListESForJournal(List<Object[]> listESForJournal) {
		this.listESForJournal = listESForJournal;
	}

	private List<Object[]> listESForGrandLivre;
	private List<Object[]> listESForGrandLivreOld;

	// OLD

	public List<Object[]> getListESForGrandLivreOld() {
		if (listESForGrandLivreOld == null) {

			Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
			Date date = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			Date sdate = new GregorianCalendar(year - 2, Calendar.JANUARY, 1).getTime();
			Date edate = new GregorianCalendar(year + 1, Calendar.DECEMBER, 30).getTime();
			List<OperationES> listop = usermetierimpl.getListOpESForJournal(cur.getDirection(), sdate, edate);
			List<Object[]> listobjectForLivre = new ArrayList<Object[]>();
			for (OperationES op : listop) {
				Object[] row = new Object[16];
				if (op instanceof OpEntree) {
					List<Object[]> bydesignation1 = (this.getDesingationByOpEntree(op));
					// operation
					// row[1] = op;
					// numeros operation
					row[1] = op.getNumoperation();
					// date
					row[15] = op.getDate();
					// Désignation sommaire des opérations
					row[2] = "";

					// par nomenclature
					row[4] = new Float(0);
					row[6] = new Float(0);
					row[7] = new Float(0);
					row[8] = new Float(0);
					row[9] = new Float(0);
					row[10] = new Float(0);
					row[11] = new Float(0);
					row[12] = new Float(0);
					row[13] = new Float(0);
					row[14] = new Float(0);

					for (Object[] nom : bydesignation1) {
						List<Object[]> liste = (List<Object[]>) nom[2];
						Nomenclature nomenclcurrent = (Nomenclature) nom[0];
						if (nomenclcurrent.getNomenclature().equals("1")) {
							row[4] = nom[1];
						} else if (nomenclcurrent.getNomenclature().equals("2")) {
							row[7] = nom[1];
						} else if (nomenclcurrent.getNomenclature().equals("3")) {
							row[9] = nom[1];
						} else if (nomenclcurrent.getNomenclature().equals("4")) {
							row[11] = nom[1];
						} else if (nomenclcurrent.getNomenclature().equals("5")) {
							row[13] = nom[1];
						}
						// nomenclature
						row[0] = nom[0];

						// total charge
						// row[4] = nom[1];
						// total decharge
						// row[6] = 0;
						for (Object[] des : liste) {
							row[2] = row[2] + " " + ((Designation) des[0]).getOrigine();
						}
						// row[2] = row[2] + " xx: " + ((Nomenclature)row[0]).getNomenclature();

						/*
						 * for(Object[] des: liste) { Designation d = (Designation)des[0]; //designation
						 * row[0] = d; //operation row[1] = op;
						 * 
						 * //numeros operation row[11] = op.getNumoperation(); //date row[12] =
						 * op.getDate();
						 * 
						 * 
						 * //origine row[2] = d.getOrigine(); //nombre par desingation entree annee X
						 * row[3] = des[1]; //total entree annee X row[4] = d.getPu()*(Long)row[3];
						 * //nombre par desingation sortie row[5] = 0; //total sortie row[6] = 0;
						 * 
						 * //existant X-1 row[7] = 0L; //valeur X-1 row[8] = (Long)row[7] * d.getPu();
						 * 
						 * //restant X row[9] = (Long)row[3] + (Long)row[7]; //valeur restant X
						 * //row[10] = (Float)row[8] + d.getPu()*(Long)row[9]; row[10] =
						 * d.getPu()*(Long)row[9];
						 * 
						 * 
						 * }
						 */
					}
					listobjectForLivre.add(row);
					row = new Object[16];

				} else if (op instanceof OpSortie) {
					Materiel mat = op.getMat();
					row[0] = mat.getDesign();
					// row[1] = op;

					// numeros operation
					row[1] = op.getNumoperation();
					// date
					row[15] = op.getDate();

					// origine
					row[2] = ((OpSortie) op).getMotifsortie().getDesignation();

					// par nomenclature
					row[4] = new Float(0);
					row[6] = new Float(0);
					row[7] = new Float(0);
					row[8] = new Float(0);
					row[9] = new Float(0);
					row[10] = new Float(0);
					row[11] = new Float(0);
					row[12] = new Float(0);
					row[13] = new Float(0);
					row[14] = new Float(0);

					// total sortie
					Nomenclature nomenclcurrent = mat.getDesign().getNomenMat();
					if (nomenclcurrent.getNomenclature().equals("1")) {
						row[6] = mat.getDesign().getPu();
					} else if (nomenclcurrent.getNomenclature().equals("2")) {
						row[8] = mat.getDesign().getPu();
					} else if (nomenclcurrent.getNomenclature().equals("3")) {
						row[10] = mat.getDesign().getPu();
					} else if (nomenclcurrent.getNomenclature().equals("4")) {
						row[12] = mat.getDesign().getPu();
					} else if (nomenclcurrent.getNomenclature().equals("5")) {
						row[14] = mat.getDesign().getPu();
					}

					/*
					 * //row[6] = mat.getDesign().getPu()*(Long)row[5];
					 * 
					 * //existant X-1 row[7] = 1L; //valeur X-1 row[8] = mat.getDesign().getPu() *
					 * (Long) row[7];
					 * 
					 * //restant X row[9] = (Long)row[7] - (Long)row[5]; //valeur restant X-X
					 * row[10] = (Long) row[9] * mat.getDesign().getPu();
					 * 
					 */

					listobjectForLivre.add(row);
					row = new Object[16];
				}
			}

			/*
			 * //group by designation List<Object[]> resultstableGrouped = new
			 * ArrayList<Object[]>();
			 * 
			 * Map<Long, List<Object[]>> map = new HashMap<Long, List<Object[]>>();
			 * 
			 * for (Object[] o : listobjectForLivre) { Long key =
			 * ((Designation)o[0]).getIdDesignation(); if(map.containsKey(key)){
			 * List<Object[]> list = map.get(key); list.add(o);
			 * 
			 * }else{ List<Object[]> list = new ArrayList<Object[]>(); list.add(o);
			 * map.put(key, list); }
			 * 
			 * } for (Map.Entry<Long, List<Object[]>> entry : map.entrySet()) {
			 * System.out.println(" gp by livre"); System.out.println(entry.getKey() + ":" +
			 * entry.getValue().size()); Object[] row = new Object[12]; Designation des =
			 * (Designation)(entry.getValue().get(0))[0]; List<Object[]> infos =
			 * entry.getValue(); //Operations List<OperationES> opes = new
			 * ArrayList<OperationES>(); for(Object[] o: infos) {
			 * opes.add((OperationES)(o[1])); }
			 * 
			 * //Designation row[0] = des; //Numéros des operations row[1] = "";
			 * for(OperationES op:opes) { row[1] = row[1]+op.getNumoperation()+" "; }
			 * //origine row[2] = ""; for(OperationES op:opes) { if(op instanceof OpEntree)
			 * { row[2] = row[2] + des.getOrigine() + " "; } else if(op instanceof OpSortie)
			 * { row[2] = row[2] + ((OpSortie) op).getMotifsortie().getDesignation() + " ";
			 * } }
			 * 
			 * ///nombre par desingation entree annee X row[3] = 0L; for(Object[] o: infos)
			 * { if((OperationES)(o[1]) instanceof OpEntree) { row[3] = (Long)o[3]; } }
			 * //total entree annee X row[4] = des.getPu()*(Long)row[3];
			 * 
			 * //nombre par desingation sortie row[5] = 0L; for(Object[] o: infos) {
			 * if((OperationES)(o[1]) instanceof OpSortie) { row[5] = (Long)row[5]+1L; } }
			 * 
			 * //total sortie row[6] = des.getPu()*(Long)row[5];
			 * 
			 * //existant X-1 MBOLA TSY MMETY row[7] = 0L; for(Object[] o: infos) {
			 * if((OperationES)(o[1]) instanceof OpSortie) { row[7] = 1L; } } //valeur X-1
			 * row[8] = des.getPu() * (Long) row[7];
			 * 
			 * //restant X row[9] = (Long)row[7] + (Long)row[3] - (Long)row[5]; //valeur
			 * restant X-X row[10] = (Long) row[9] * des.getPu();
			 * 
			 * //date row[11] = ""; for(OperationES op:opes) { row[11] = row[11] +
			 * op.getDate().toString() + " "; }
			 * 
			 * 
			 * resultstableGrouped.add(row); }
			 */
			// set result GP By
			listESForGrandLivreOld = listobjectForLivre;
		}
		return listESForGrandLivreOld;
	}

	public List<Object[]> getListESForGrandLivre() {
		if (listESForGrandLivre == null) {

			Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
			Date date = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			Date sdate = new GregorianCalendar(year, Calendar.APRIL, 30).getTime();
			Date edate = new GregorianCalendar(year + 1, Calendar.DECEMBER, 30).getTime();
			System.out.println("RRRRRRRRRRR Begin:");
			List<Object[]> r = usermetierimpl.getListObjectForinvetaire(cur.getDirection(), sdate, edate);
			System.out.println("RRRRRRRRRRR Ending:");
			/*
			 * for(Object[] o:r) { System.out.println(String.valueOf(o[0]));
			 * System.out.println(String.valueOf(o[1])); }
			 */
			List<Object[]> resultstable = new ArrayList<Object[]>();

			for (Object[] m : r) {
				Object[] row = new Object[14];
				Materiel mat = (Materiel) m[1];
				OpSortie o = (OpSortie) m[0];
				// Nomenclature
				row[0] = mat.getDesign().getNomenMat().getNomenclature();
				// Numéros du folio du grand livre
				row[1] = mat.getIdMateriel();
				// Désignation du matériel
				row[2] = mat.getDesign().getTypematerieladd().getDesignation() + " - "
						+ mat.getDesign().getMarque().getDesignation() + " - " + mat.getDesign().getRenseignement()
						+ " - "
				// + mat.getNumSerie()
				;
				// Espèce des unités
				row[3] = mat.getDesign().getEspeceUnite();
				// Prix de l’unité
				row[4] = mat.getDesign().getPu();
				// Existantes au 1er Janvier X
				row[5] = 0;
				// Entrées pendant l’année X
				if (mat.getMyoperationEntree() == null || mat.getMyoperationEntree().getDate().compareTo(sdate) < 0) {
					row[6] = "Materiel Existant";
					row[5] = 1;
				} else {
					row[6] = mat.getMyoperationEntree().getNumoperation();
				}

				// Sortie pendant l’année X
				if (o == null) {
					row[7] = "Aucune sortie";
				} else {
					row[7] = o.getNumoperation();
				}
				// Reste au 31 déc. X
				row[8] = "reste";
				// Décompte
				row[9] = "decompte";
				row[10] = mat.getDesign().getTypematerieladd();
				row[11] = mat.getDesign();
				row[12] = mat;
				if (o != null) {
					row[13] = o.getDate().toString();// set année sortie for affichage
				}

				resultstable.add(row);
			}

			// group by designation
			List<Object[]> resultstableGrouped = new ArrayList<Object[]>();

			Map<Designation, List<Object[]>> map = new HashMap<Designation, List<Object[]>>();

			for (Object[] o : resultstable) {
				Designation key = (Designation) o[11];
				if (map.containsKey(key)) {
					List<Object[]> list = map.get(key);
					list.add(o);

				} else {
					List<Object[]> list = new ArrayList<Object[]>();
					list.add(o);
					map.put(key, list);
				}

			}
			for (Map.Entry<Designation, List<Object[]>> entry : map.entrySet()) {
				// System.out.println(entry.getKey().getIdDesignation() + ":" +
				// entry.getValue().size());
				Object[] row = new Object[16];
				Designation des = entry.getKey();
				List<Object[]> infos = entry.getValue();
				// materiels
				List<Materiel> materiels = new ArrayList<Materiel>();
				for (Object[] o : infos) {
					materiels.add((Materiel) ((infos.get(0))[12]));
				}

				// Nomenclature
				row[0] = des.getNomenMat().getNomenclature();
				// Espèces des unités
				row[1] = des.getEspeceUnite();
				// Désignation des objets (1)
				row[2] = (infos.get(0))[2];
				;
				String series = "";
				for (Object[] o : infos) {
					series = series + ((Materiel) (o[12])).getNumSerie();
				}
				row[2] = row[2] + series;
				// Prix de l’unité
				row[3] = des.getPu();
				;
				// Prix de l’unité
				row[4] = des.getPu();
				// Existantes au 1er Janvier X
				row[5] = 0;
				// Entrées pendant l’année X
				row[6] = "";
				// date des entrées et des sorties
				row[14] = ""; // entrée
				row[15] = ""; // sorties

				int entreeAx = 0;// entree pendant année X
				if (materiels.get(0).getMyoperationEntree() == null
						|| materiels.get(0).getMyoperationEntree().getDate().compareTo(sdate) < 0) {
					String es = " manuellement ";
					if (materiels.get(0).getMyoperationEntree() != null
							&& materiels.get(0).getMyoperationEntree().getDate().compareTo(sdate) < 0) {
						es = materiels.get(0).getMyoperationEntree().getDate().toString();
					}
					row[6] = "Materiel Existant du " + es;
					row[5] = materiels.size();
					entreeAx = 0;

				} else {
					row[6] = materiels.get(0).getMyoperationEntree().getNumoperation();
					entreeAx = materiels.size();
					row[14] = materiels.get(0).getMyoperationEntree().getDate();
				}

				// Sortie pendant l’année X
				String sortie = "";
				String sortieAnnee = "xxxx";
				int sortieAx = 0;
				for (Object[] o : infos) {
					if (!o[7].equals("Aucune sortie")) {
						sortie = sortie + " - " + (String) o[7];
						sortieAx = sortieAx + 1;
						sortieAnnee = sortieAnnee + " , " + (String) o[13];
					}

				}
				row[15] = sortieAnnee; // set annees sorties
				row[7] = sortie;
				/*
				 * if(o ==null) { row[7] = "Aucune sortie"; } else { row[7] =
				 * o.getNumoperation(); }
				 */
				// Reste au 31 déc. X
				row[8] = (Integer) row[5] + entreeAx - sortieAx; // existant + entree en X - sortie en X
				// Décompte
				row[9] = (Integer) row[8] * des.getPu();
				row[10] = des.getTypematerieladd();
				row[11] = des;

				// nombre entree et sortie pour affichage
				row[12] = entreeAx;
				row[13] = sortieAx;

				resultstableGrouped.add(row);
			}

			listESForGrandLivre = resultstableGrouped;
		}
		return listESForGrandLivre;
	}

	public void setListESForGrandLivre(List<Object[]> listESForGrandLivre) {
		this.listESForGrandLivre = listESForGrandLivre;
	}

	public void setListESForGrandLivreOld(List<Object[]> listESForGrandLivre) {
		this.listESForGrandLivreOld = listESForGrandLivre;
	}

	public List<Object[]> getDesingationByOpEntree(Operation op) {
		List<Object[]> results = usermetierimpl.listDesignationByOperationEntree((OpEntree) op);
		HashMap<Nomenclature, Float> bynom = new HashMap<Nomenclature, Float>();
		for (Object[] o : results) {
			Designation a = (Designation) (o[0]);
			Long nbr = (Long) (o[1]);
			if (bynom.isEmpty()) {
				bynom.put(a.getNomenMat(), nbr * a.getPu());
			} else {
				for (Map.Entry<Nomenclature, Float> entry : bynom.entrySet()) {

					if (entry.getKey() == a.getNomenMat()) {
						entry.setValue(entry.getValue() + (nbr * a.getPu()));
					} else {
						bynom.put(a.getNomenMat(), nbr * a.getPu());
					}
				}
			}
		}
		List<Object[]> resultatfinal = new ArrayList<Object[]>();
		for (Map.Entry<Nomenclature, Float> entry : bynom.entrySet()) {
			Object[] item = new Object[3];
			item[0] = entry.getKey();
			item[1] = entry.getValue();
			List<Object[]> ourlist = new ArrayList<Object[]>();
			for (Object[] o : results) {
				Designation a = (Designation) o[0];
				if (a.getNomenMat() == entry.getKey()) {
					ourlist.add(o);
				}
			}
			item[2] = ourlist;
			resultatfinal.add(item);
		}
		return resultatfinal;
	}

	public List<Object[]> getListobjectForInvetaire() {
		if (listobjectForInvetaire == null) {
			Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
			Date date = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			Date sdate = new GregorianCalendar(year, Calendar.APRIL, 30).getTime();
			Date edate = new GregorianCalendar(year, Calendar.DECEMBER, 31).getTime();
			System.out.println("RRRRRRRRRRR Begin:");
			List<Object[]> r = usermetierimpl.getListObjectForinvetaire(cur.getDirection(), sdate, edate);
			System.out.println("RRRRRRRRRRR Ending:");
			/*
			 * for(Object[] o:r) { System.out.println(String.valueOf(o[0]));
			 * System.out.println(String.valueOf(o[1])); }
			 */
			List<Object[]> resultstable = new ArrayList<Object[]>();

			for (Object[] m : r) {
				Object[] row = new Object[13];
				Materiel mat = (Materiel) m[1];
				OpSortie o = (OpSortie) m[0];
				// Nomenclature
				row[0] = mat.getDesign().getNomenMat().getNomenclature();
				// Numéros du folio du grand livre
				row[1] = mat.getIdMateriel();
				// Désignation du matériel
				row[2] = mat.getDesign().getTypematerieladd().getDesignation() + " - "
						+ mat.getDesign().getMarque().getDesignation() + " - " + mat.getDesign().getRenseignement()
						+ " - "
				// + mat.getNumSerie()
				;
				// Espèce des unités
				row[3] = mat.getDesign().getEspeceUnite();
				// Prix de l’unité
				row[4] = mat.getDesign().getPu();
				// Existantes au 1er Janvier X
				row[5] = 0;
				// Entrées pendant l’année X
				if (mat.getMyoperationEntree() == null || mat.getMyoperationEntree().getDate().compareTo(sdate) < 0) {
					row[6] = "Materiel Existant";
					row[5] = 1;
				} else {
					row[6] = mat.getMyoperationEntree().getNumoperation();
				}

				// Sortie pendant l’année X
				if (o == null) {
					row[7] = "Aucune sortie";
				} else {
					row[7] = o.getNumoperation();
				}
				// Reste au 31 déc. X
				row[8] = "reste";
				// Décompte
				row[9] = "decompte";
				row[10] = mat.getDesign().getTypematerieladd();
				row[11] = mat.getDesign();
				row[12] = mat;

				resultstable.add(row);
			}

			// group by designation
			List<Object[]> resultstableGrouped = new ArrayList<Object[]>();

			Map<Designation, List<Object[]>> map = new HashMap<Designation, List<Object[]>>();

			for (Object[] o : resultstable) {
				Designation key = (Designation) o[11];
				if (map.containsKey(key)) {
					List<Object[]> list = map.get(key);
					list.add(o);

				} else {
					List<Object[]> list = new ArrayList<Object[]>();
					list.add(o);
					map.put(key, list);
				}

			}
			for (Map.Entry<Designation, List<Object[]>> entry : map.entrySet()) {
				// System.out.println(entry.getKey().getIdDesignation() + ":" +
				// entry.getValue().size());
				Object[] row = new Object[12];
				Designation des = entry.getKey();
				List<Object[]> infos = entry.getValue();
				// materiels
				List<Materiel> materiels = new ArrayList<Materiel>();
				for (Object[] o : infos) {
					materiels.add((Materiel) ((infos.get(0))[12]));
				}

				// Nomenclature
				row[0] = des.getNomenMat().getNomenclature();
				// Numéros du folio du grand livre
				row[1] = des.getIdDesignation();
				// Désignation du matériel
				row[2] = (infos.get(0))[2];
				;
				String series = "";
				for (Object[] o : infos) {
					series = series + ((Materiel) (o[12])).getNumSerie();
				}
				row[2] = row[2] + series;
				// Espèce des unités
				row[3] = des.getEspeceUnite();
				// Prix de l’unité
				row[4] = des.getPu();
				// Existantes au 1er Janvier X
				row[5] = 0;
				// Entrées pendant l’année X
				int entreeAx = 0;// entree pendant année X
				if (materiels.get(0).getMyoperationEntree() == null
						|| materiels.get(0).getMyoperationEntree().getDate().compareTo(sdate) < 0) {
					String es = "old";
					if (materiels.get(0).getMyoperationEntree() != null
							&& materiels.get(0).getMyoperationEntree().getDate().compareTo(sdate) < 0) {
						es = materiels.get(0).getMyoperationEntree().getDate().toString();
					}
					row[6] = "Materiel Existant " + es;
					row[5] = materiels.size();
					entreeAx = 0;

				} else {
					row[6] = materiels.get(0).getMyoperationEntree().getNumoperation();
					entreeAx = materiels.size();
				}

				// Sortie pendant l’année X
				String sortie = "0";
				int sortieAx = 0;
				for (Object[] o : infos) {
					if (!o[7].equals("Aucune sortie")) {
						sortie = sortie + (String) o[7] + " and ";
						sortieAx = sortieAx + 1;
					}

				}
				row[7] = sortie;
				/*
				 * if(o ==null) { row[7] = "Aucune sortie"; } else { row[7] =
				 * o.getNumoperation(); }
				 */
				// Reste au 31 déc. X
				row[8] = (Integer) row[5] + entreeAx - sortieAx; // existant + entree en X - sortie en X
				// Décompte
				row[9] = (Integer) row[8] * des.getPu();
				row[10] = des.getTypematerieladd();
				row[11] = des;

				// set nombre entree et sortie pendant X
				row[6] = entreeAx;
				row[7] = sortieAx;

				resultstableGrouped.add(row);
			}

			listobjectForInvetaire = resultstableGrouped;
		}

		return listobjectForInvetaire;
	}

	// List object format for fiche de stock
	public List<Object[]> getListForFicheStock() {
		List<Operation> lesoperations = getListOpESArtByDirection();
		// structure de données
		List<Object[]> resulttable = new ArrayList<Object[]>();
		Object[] row = new Object[8];
		for (Operation o : lesoperations) {
			// Date operation
			row[0] = null;
			// reference entrée
			row[1] = "";
			// quantite entrée
			row[2] = 0;
			// quantite entrée cumulée
			row[3] = 0;
			// reference sortie
			row[4] = "";
			// quantite sortie
			row[5] = 0;
			// quantite finale
			row[6] = new Long(0);

			// Remplissage à partir du liste des operations

			// initiale
			row[0] = o.getDate();

			// entree
			if (o instanceof OpEntreeArticle) {
				row[1] = o.getId(); // need to add this attribut for operation reference
				row[2] = (Long) (((OpEntreeArticle) o).getArticle().getNombre());
				row[3] = (Long) row[2] + 0; // need to set previous nombre
			}
			// sortie
			else if (o instanceof OpSortieArticle) {
				row[4] = o.getId();
				row[5] = (Long) (((OpSortieArticle) o).getNombreToS());

			}
			// finale quantity
			// row[6] = (Long)row[3] - (Long)row[5];
			resulttable.add(row);
			row = new Object[8];
		}

		Collections.sort(resulttable, new Comparator<Object[]>() {
			public int compare(Object[] s1, Object[] s2) {
				Date d1 = (Date) s1[0];
				Date d2 = (Date) s2[0];
				System.out.println("date :" + d1);
				return d1.compareTo(d2);
			}
		});

		return resulttable;
	}

	// list objet format pour journal
	public List<Object[]> getListForJournalStock() {
		List<Operation> lesoperations = getListOpESArtByDirection();
		// structure de données
		List<Object[]> resulttable = new ArrayList<Object[]>();
		Object[] row = new Object[8];
		for (Operation o : lesoperations) {
			// numero d'ordre
			row[0] = "" + o.getId().toString();
			// date operation
			row[1] = o.getDate();
			// reference
			row[2] = " a ajouter " + o.getId();
			// origine
			row[3] = "";
			// designation des articles
			row[4] = "";
			// quantite
			row[5] = new Long (0);
			// prix unitaire
			row[6] = new Float(0);
			// Montant total
			row[7] = new Float(0);

			// processing
			if (o instanceof OpEntreeArticle) {
				row[0] = row[0] + "/E";
				row[3] = "a ajouter origine";
				Article a = ((OpEntreeArticle) o).getArticle();
				row[4] = a.getCodeArticle().getTypeObjet().getDesignation() + " (" + a.getCodeArticle().getDesignation()
						+ " ) " + a.getMarqueArticle();
				row[5] = a.getNombre();
				row[6] = a.getPrix();
				row[7] = (Long) row[5] * (Float) row[6];
				//set reference entree
				if(a.getReference()!=null) {
					row[2] = a.getReference();
				}
				if(a.getOrigine()!=null) {
					row[3] = a.getOrigine();
				}
				

			} else if (o instanceof OpSortieArticle) {
				row[0] = row[0] + "/S";
				row[3] = (((OpSortieArticle) o).getBeneficiaire()).getNomAgent();
				Article a = ((OpSortieArticle) o).getArticle();
				row[4] = a.getCodeArticle().getTypeObjet().getDesignation() + " (" + a.getCodeArticle().getDesignation()
						+ " ) " + a.getMarqueArticle();
				row[5] = a.getNombre();
				row[6] = a.getPrix();
				row[7] = (Long) row[5] * (Float) row[6];
				if(((OpSortieArticle) o).getDecision()!=null) {
					row[2]=((OpSortieArticle) o).getDecision();
				}

			}

			resulttable.add(row);
			row = new Object[8];
		}
		return resulttable;
	}

	public List<Operation> getListOpESArtByDirectionByCod(CodeArticle codeart) {
		Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		Date sdate = new GregorianCalendar(year , Calendar.MAY, 1).getTime();
		Date edate = new GregorianCalendar(year + 1, Calendar.DECEMBER, 30).getTime();
		return usermetierimpl.getListOpESArtValideByDirectionByCod(codeart, cur.getDirection(), sdate, edate);
	}

	// list objet format pour journal By codification
	public List<Object[]> getListForJournalStockByCod(CodeArticle code) {
		List<Operation> lesoperations = getListOpESArtByDirectionByCod(code);
		// structure de données
		List<Object[]> resulttable = new ArrayList<Object[]>();
		Object[] row = new Object[9];
		for (Operation o : lesoperations) {
			// Date operation
			row[0] = null;
			// reference entrée
			row[1] = new Long(0);//"";
			// quantite entrée
			row[2] = new Long(0);
			// quantite entrée cumulée
			row[3] = new Long(0);
			// reference sortie
			row[4] = new Long(0);//"";
			// quantite sortie
			row[5] = new Long(0);
			// quantite de depart à reporter
			row[6] = new Long(0);

			// Remplissage à partir du liste des operations

			// initiale
			row[0] = o.getDate();

			// entree
			if (o instanceof OpEntreeArticle) {
				row[1] = o.getId(); // need to add this attribut for operation reference
				row[2] = (Long) (((OpEntreeArticle) o).getArticle().getNombre());
				row[3] = (Long) row[2] + 0; // need to set previous nombre
			}
			// sortie
			else if (o instanceof OpSortieArticle) {
				row[4] = o.getId();
				row[5] = (Long) (((OpSortieArticle) o).getNombreToS());

			}
			// report
			row[6] = areportByCod(code);
			//row[6] = 5;
			resulttable.add(row);
			row = new Object[9];
		}

		Collections.sort(resulttable, new Comparator<Object[]>() {
			public int compare(Object[] s1, Object[] s2) {
				Date d1 = (Date) s1[0];
				Date d2 = (Date) s2[0];
				System.out.println("date :" + d1);
				return d1.compareTo(d2);
			}
		});

		return resulttable;
	}
	
	public Long areportByCod(CodeArticle code)
	{
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		Date stopdate = new GregorianCalendar(year, Calendar.MAY, 1).getTime();
		Agent cur = (Agent) RequestFilter.getSession().getAttribute("agent");
		Long nombreareporter = usermetierimpl.getAreporter(code,cur.getDirection(),stopdate);
		return nombreareporter;
	}
	
private List<Materiel> listHistoriqueMatDirection;
	
	

	public List<Materiel> getListHistoriqueMatDirection() {
		if(listHistoriqueMatDirection == null) {
			Agent agent = (Agent) RequestFilter.getSession().getAttribute("agent");
			listHistoriqueMatDirection= usermetierimpl.getListMatByDirection(agent.getDirection());
		}
		return listHistoriqueMatDirection;
	}

	public void setListHistoriqueMatDirection(List<Materiel> listHistoriqueMatDirection) {
		this.listHistoriqueMatDirection = listHistoriqueMatDirection;
	}
	

}
