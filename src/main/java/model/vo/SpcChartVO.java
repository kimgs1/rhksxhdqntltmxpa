package model.vo;

public class SpcChartVO {

	private String id;
	private double value1;
	private double value2;
	private double value3;
	private double value4;
	private double lcl;
	private double ucl;
	private double mrlcl;
	private double mrcl;
	private double mrucl;
	private String dbtime;
	private double min;
	private double max;
	private double mrmin;
	private double mrmax;
	private String comment;
	
	public SpcChartVO() {
		super();
	}
	
	public SpcChartVO(String id, double value1, double value2, double value3, double value4, double lcl, double ucl, double mrlcl, double mrcl, double mrucl, String dbtime, double min, double max, double mrmin, double mrmax, String comment) {
		super();
		
		this.id = id;
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		this.value4 = value4;
		this.lcl = lcl;
		this.ucl = ucl;
		this.mrlcl = mrlcl;
		this.mrcl = mrcl;
		this.mrucl = mrucl;
		this.dbtime = dbtime;
		this.min = min;
		this.max = max;
		this.mrmin = mrmin;
		this.mrmax = mrmax;
		this.comment = comment;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public double getValue1() {
		return value1;
	}
	
	public void setValue1(double value1) {
		this.value1 = value1;
	}
	
	public double getValue2() {
		return value2;
	}
	
	public void setValue2(double value2) {
		this.value2 = value2;
	}
	
	public double getValue3() {
		return value3;
	}
	
	public void setValue3(double value3) {
		this.value3 = value3;
	}
	
	public double getValue4() {
		return value4;
	}
	
	public void setValue4(double value4) {
		this.value4 = value4;
	}
	
	public double getLcl() {
		return lcl;
	}

	public void setLcl(double lcl) {
		this.lcl = lcl;
	}

	public double getUcl() {
		return ucl;
	}

	public void setUcl(double ucl) {
		this.ucl = ucl;
	}
	
	public double getMrlcl() {
		return mrlcl;
	}

	public void setMrlcl(double mrlcl) {
		this.mrlcl = mrlcl;
	}

	public double getMrcl() {
		return mrcl;
	}

	public void setMrcl(double mrcl) {
		this.mrcl = mrcl;
	}

	public double getMrucl() {
		return mrucl;
	}

	public void setMrucl(double mrucl) {
		this.mrucl = mrucl;
	}

	public String getDBtime() {
		return dbtime;
	}
	
	public void setDBtime(String dbtime) {
		this.dbtime = dbtime;
	}
	
	public double getmin() {
		return min;
	}
	
	public void setmin(double min) {
		this.min = min;
	}
	
	public double getmax() {
		return max;
	}
	
	public void setmax(double max) {
		this.max = max;
	}
	
	public double getmrmin() {
		return mrmin;
	}
	
	public void setmrmin(double mrmin) {
		this.mrmin = mrmin;
	}
	
	public double getmrmax() {
		return mrmax;
	}
	
	public void setmrmax(double mrmax) {
		this.mrmax = mrmax;
	}
	
	public String getcomment() {
		return comment;
	}
	
	public void setcomment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "SpcChartVO [id=" + id + ", value1=" + value1 + ", value2=" + value2 + ", value3=" + value3 + ", value4="
				+ value4 + ", lcl=" + lcl + ", ucl=" + ucl + ", mrlcl=" + mrlcl + ", mrcl=" + mrcl + ", mrucl=" + mrucl
				+ ", dbtime=" + dbtime + ", min=" + min + ", max=" + max + ", mrmin=" + mrmin + ", mrmax=" + mrmax
				+ ", comment=" + comment + "]";
	}
}