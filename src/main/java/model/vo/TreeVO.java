package model.vo;

import java.util.ArrayList;

public class TreeVO {
	private int gridIdx;
	private int id;
	private String mid;
	private String name;
	private int parentid;
	private ArrayList<TreeVO> sons;
	
	private String level;
	private String levelName;
	private String isleaf;
	private String expanded;
	private String loaded;
	
	private String sl;
	private String su;
	private String lcl;
	private String ucl;
	
	private String datatype;
	
	
	public TreeVO() {
		super();
		this.sl = "";
		this.su = "";
		this.lcl = "";
		this.ucl = "";
		this.datatype = "0";
	}

	public TreeVO(int id, String mid, String name, int parentid, String level, String isleaf, String expanded,
			String loaded, String sl, String su, String lcl, String ucl) {
		super();
		this.id = id;
		this.mid = mid;
		this.name = name;
		this.parentid = parentid;
		this.level = level;
		this.isleaf = isleaf;
		this.expanded = expanded;
		this.loaded = loaded;
		this.sl = sl;
		this.su = su;
		this.lcl = lcl;
		this.ucl = ucl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	public String getLevelName() {
		return levelName;
	}

	public String getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}

	public String getExpanded() {
		return expanded;
	}

	public void setExpanded(String expanded) {
		this.expanded = expanded;
	}

	public String getLoaded() {
		return loaded;
	}

	public void setLoaded(String loaded) {
		this.loaded = loaded;
	}

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public String getSu() {
		return su;
	}

	public void setSu(String su) {
		this.su = su;
	}

	public String getLcl() {
		return lcl;
	}

	public void setLcl(String lcl) {
		this.lcl = lcl;
	}

	public String getUcl() {
		return ucl;
	}

	public void setUcl(String ucl) {
		this.ucl = ucl;
	}

	public void addSon(TreeVO son){
		if(this.sons == null){
			this.sons = new ArrayList<TreeVO>();
		}
		this.sons.add(son);
	}
	
	public ArrayList<TreeVO> getSons(){
		if(this.sons == null){
			this.sons = new ArrayList<TreeVO>();
		}
		return this.sons;
	}

	public int getGridIdx() {
		return gridIdx;
	}

	public void setGridIdx(int gridIdx) {
		this.gridIdx = gridIdx;
	}
	
	@Override
	public String toString() {
		return "TreeVO [grididx=" + gridIdx + ", id=" + id + ", mid=" + mid + ", name=" + name + ", parentid=" + parentid + ", level=" + level + ", levelName=" + levelName
				+ ", isleaf=" + isleaf + ", expanded=" + expanded + ", loaded=" + loaded + ", sl=" + sl + ", su=" + su
				+ ", lcl=" + lcl + ", ucl=" + ucl + "]";
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
}