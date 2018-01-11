package model.vo;

import java.util.List;

public class QuantileVO {

	private double low;
	private double high;
	private double Q1;
	private double Q2;
	private double Q3;
	private double min;
	private double max;
	private List<Double> outliers;
	
	public QuantileVO() {
		super();
	}
	
	public QuantileVO(double low, double high, double Q1, double Q2, double Q3, double min, double max, List<Double> outliers) {
		super();
		
		this.low = low;
		this.high = high;
		this.Q1 = Q1;
		this.Q2 = Q2;
		this.Q3 = Q3;
		this.min = min;
		this.max = max;
		this.outliers = outliers;
	}

	public double getlow() {
		return low;
	}
	
	public void setlow(double low) {
		this.low = low;
	}
	
	public double gethigh() {
		return high;
	}
	
	public void sethigh(double high) {
		this.high = high;
	}
	
	public double getQ1() {
		return Q1;
	}
	
	public void setQ1(double Q1) {
		this.Q1 = Q1;
	}
	
	public double getQ2() {
		return Q2;
	}
	
	public void setQ2(double Q2) {
		this.Q2 = Q2;
	}
	
	public double getQ3() {
		return Q3;
	}
	
	public void setQ3(double Q3) {
		this.Q3 = Q3;
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
	
	public List<Double> getoutliers() {
		return outliers;
	}
	
	public void setoutliers(List<Double> outliers) {
		this.outliers = outliers;
	}
	
	@Override
	public String toString() {
		return "QuantileVO [low=" + low + ", high=" + high + ", Q1=" + Q1 + ", Q2=" + Q2 + ", Q3=" + Q3 + ", min=" + min
				+ ", max=" + max + ", outliers=" + outliers + "]";
	}
}