package com.douane.managed.bean.JasperData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.douane.entite.Designation;
import com.douane.entite.TypeMateriel;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class InventaireData {
	List <Object[]> list;
	public InventaireData(List <Object[]> l){
		
		this.list = l;
	}
	public JRBeanCollectionDataSource getDataSource() {
		List<Inventaire> newOne = new ArrayList<Inventaire>();
		for (Object[] i : this.list ) {
			Inventaire la = new Inventaire(i);
			newOne.add(la);
		}
		
		return new JRBeanCollectionDataSource(newOne);
	}
	
	public class Inventaire{
		private String row0;
		private Long row1;
		private String row2;
		private String row3;
		private Float row4;
		private int row5;
		private Integer row6;
		private Integer row7;
		private Integer row8;
		private Float row9;
		private TypeMateriel row10;
		private Designation row11;
		
		public Inventaire(Object[] i) {
			this.row0= (String)i[0];
			this.row1= (Long)i[1];
			this.row2= (String)i[2];
			this.row3= (String)i[3];
			this.row4= (Float)i[4];
			this.row5= (Integer) i[5];
			this.row6= (Integer)i[6];
			this.row7= (Integer)i[7];
			this.row8= (Integer)i[8];
			this.row9= (Float)i[9];
			this.row10= (TypeMateriel)i[10];
			this.row11= (Designation)i[11];
		}

		public String getRow0() {
			return row0;
		}

		public void setRow0(String row0) {
			this.row0 = row0;
		}

		public Long getRow1() {
			return row1;
		}

		public void setRow1(Long row1) {
			this.row1 = row1;
		}

		public String getRow2() {
			return row2;
		}

		public void setRow2(String row2) {
			this.row2 = row2;
		}

		public String getRow3() {
			return row3;
		}

		public void setRow3(String row3) {
			this.row3 = row3;
		}

		public Float getRow4() {
			return row4;
		}

		public void setRow4(Float row4) {
			this.row4 = row4;
		}

		public int getRow5() {
			return row5;
		}

		public void setRow5(int row5) {
			this.row5 = row5;
		}

		public Integer getRow6() {
			return row6;
		}

		public void setRow6(Integer row6) {
			this.row6 = row6;
		}

		public Integer getRow7() {
			return row7;
		}

		public void setRow7(Integer row7) {
			this.row7 = row7;
		}

		public Integer getRow8() {
			return row8;
		}

		public void setRow8(Integer row8) {
			this.row8 = row8;
		}

		public Float getRow9() {
			return row9;
		}

		public void setRow9(Float row9) {
			this.row9 = row9;
		}

		public TypeMateriel getRow10() {
			return row10;
		}

		public void setRow10(TypeMateriel row10) {
			this.row10 = row10;
		}

		public Designation getRow11() {
			return row11;
		}

		public void setRow11(Designation row11) {
			this.row11 = row11;
		}

	}

	public List<Object[]> getList() {
		return list;
	}
	public void setList(List<Object[]> list) {
		this.list = list;
	}
}
