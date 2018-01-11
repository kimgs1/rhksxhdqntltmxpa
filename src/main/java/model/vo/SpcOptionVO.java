package model.vo;

public class SpcOptionVO {

	private String id;
	private String name;
	private String rep_mid;
	private String lcl;
	private String cl;
	private String ucl;
	private String mr_lcl;
	private String mr_cl;
	private String mr_ucl;

	private String treeid;
	private String spc_options;
	private String devname;
	
	private String start_time;
	private String end_time;
	private String recent_cnt;
	private String dbtime;
	
	private String classification;
	
	public SpcOptionVO() {
		super();
	}

	public SpcOptionVO(String id, String name, String rep_mid, String lcl, String cl, String ucl, String mr_lcl,
			String mr_cl, String mr_ucl, String treeid, String spc_options, String devname, String start_time,
			String end_time, String recent_cnt, String dbtime, String classification) {
		super();
		this.id = id;
		this.name = name;
		this.rep_mid = rep_mid;
		this.lcl = lcl;
		this.cl = cl;
		this.ucl = ucl;
		this.mr_lcl = mr_lcl;
		this.mr_cl = mr_cl;
		this.mr_ucl = mr_ucl;
		this.treeid = treeid;
		this.spc_options = spc_options;
		this.devname = devname;
		this.start_time = start_time;
		this.end_time = end_time;
		this.recent_cnt = recent_cnt;
		this.dbtime = dbtime;
		this.classification = classification;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRep_mid() {
		return rep_mid;
	}

	public void setRep_mid(String rep_mid) {
		this.rep_mid = rep_mid;
	}

	public String getLcl() {
		return lcl;
	}

	public void setLcl(String lcl) {
		this.lcl = lcl;
	}

	public String getCl() {
		return cl;
	}

	public void setCl(String cl) {
		this.cl = cl;
	}

	public String getUcl() {
		return ucl;
	}

	public void setUcl(String ucl) {
		this.ucl = ucl;
	}

	public String getMr_lcl() {
		return mr_lcl;
	}

	public void setMr_lcl(String mr_lcl) {
		this.mr_lcl = mr_lcl;
	}

	public String getMr_cl() {
		return mr_cl;
	}

	public void setMr_cl(String mr_cl) {
		this.mr_cl = mr_cl;
	}

	public String getMr_ucl() {
		return mr_ucl;
	}

	public void setMr_ucl(String mr_ucl) {
		this.mr_ucl = mr_ucl;
	}

	public String getTreeid() {
		return treeid;
	}

	public void setTreeid(String treeid) {
		this.treeid = treeid;
	}

	public String getSpc_options() {
		return spc_options;
	}

	public void setSpc_options(String spc_options) {
		this.spc_options = spc_options;
	}

	public String getDevname() {
		return devname;
	}

	public void setDevname(String devname) {
		this.devname = devname;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getRecent_cnt() {
		return recent_cnt;
	}

	public void setRecent_cnt(String recent_cnt) {
		this.recent_cnt = recent_cnt;
	}

	public String getDbtime() {
		return dbtime;
	}

	public void setDbtime(String dbtime) {
		this.dbtime = dbtime;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Override
	public String toString() {
		return "SpcOptionVO [id=" + id + ", name=" + name + ", rep_mid=" + rep_mid + ", lcl=" + lcl + ", cl=" + cl
				+ ", ucl=" + ucl + ", mr_lcl=" + mr_lcl + ", mr_cl=" + mr_cl + ", mr_ucl=" + mr_ucl + ", treeid="
				+ treeid + ", spc_options=" + spc_options + ", devname=" + devname + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", recent_cnt=" + recent_cnt + ", dbtime=" + dbtime + ", classification="
				+ classification + "]";
	}

}
