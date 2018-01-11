package model.vo;

public class AsGridVO {

	private String mid;
	private String name;
	private String error;
	@Override
	public String toString() {
		return "AsGridVO [mid=" + mid + ", name=" + name + ", error=" + error + ", count=" + count
				+ ", dbtime=" + dbtime + "]";
	}

	private String count;
	private String dbtime;
	
	public AsGridVO() {
		super();
	}

	public AsGridVO(String mid, String name, String error, String count, String dbtime) {
		super();
		this.mid = mid;
		this.name = name;
		this.error = error;
		this.count = count;
		this.dbtime = dbtime;
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDbtime() {
		return dbtime;
	}

	public void setDbtime(String dbtime) {
		this.dbtime = dbtime;
	}
}
