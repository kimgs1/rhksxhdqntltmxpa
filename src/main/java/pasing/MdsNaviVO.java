
package pasing;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 게시물 리스트 정보와 
 * 페이징 정보를 가지고 있는 클래스 
 * @author inst
 *
 */
public class MdsNaviVO {
	private ArrayList<HashMap<String, Object>> list;
	private PagingBean pagingBean;
	
	public MdsNaviVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MdsNaviVO(ArrayList<HashMap<String, Object>> pagedMdsLineChartData, PagingBean pagingBean) {
		super();
		this.list = pagedMdsLineChartData;
		this.pagingBean = pagingBean;
	}

	public ArrayList<HashMap<String, Object>> getList() {
		return list;
	}

	public void setList(ArrayList<HashMap<String, Object>>list) {
		this.list = list;
	}

	public PagingBean getPagingBean() {
		return pagingBean;
	}

	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

	@Override
	public String toString() {
		return "MdsVO [list=" + list + ", pagingBean=" + pagingBean + "]";
	}
	
}

