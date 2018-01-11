package model.vo;

public class UserConfigTreeVO {

	@Override
	public String toString() {
		return "UserConfigTreeVO [id=" + id + ", mid=" + mid + ", name=" + name + ", parentid=" + parentid + ", level="
				+ level + ", isleaf=" + isleaf + ", expanded=" + expanded + ", loaded=" + loaded + ", sl=" + sl
				+ ", su=" + su + ", lcl=" + lcl + ", ucl=" + ucl + ", userspec=" + userspec + ", userlimit=" + userlimit
				+ ", sigma_level=" + sigma_level + ", bl_apply=" + bl_apply + "]";
	}

	private int id;
	private String mid;
	private String name;
	private int parentid;
	
	private String level;
	private String isleaf;
	private String expanded;
	private String loaded;
	
	private String sl;
	private String su;
	private String lcl;
	private String ucl;
	
	private String userspec;
	private String userlimit;
	private String sigma_level;
	
	private String bl_apply;

	public UserConfigTreeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserConfigTreeVO(int id, String mid, String name, int parentid, String level, String isleaf, String expanded,
			String loaded, String sl, String su, String lcl, String ucl, String userspec, String userlimit,
			String sigma_level, String bl_apply) {
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
		this.userspec = userspec;
		this.userlimit = userlimit;
		this.sigma_level = sigma_level;
		this.bl_apply = bl_apply;
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

	public String getUserspec() {
		return userspec;
	}

	public void setUserspec(String userspec) {
		this.userspec = userspec;
	}

	public String getUserlimit() {
		return userlimit;
	}

	public void setUserlimit(String userlimit) {
		this.userlimit = userlimit;
	}

	public String getSigma_level() {
		return sigma_level;
	}

	public void setSigma_level(String sigma_level) {
		this.sigma_level = sigma_level;
	}

	public String getBl_apply() {
		return bl_apply;
	}

	public void setBl_apply(String bl_apply) {
		this.bl_apply = bl_apply;
	}
}