package pasing;
import java.util.HashMap;

/**
 * 게시물 리스트 정보와 
 * 페이징 정보를 가지고 있는 클래스 
 * @author inst
 *
 */
public class RecordNaviVO {
	private HashMap<String, Object> recordChartMap;
	private PagingBean pagingBean;
	
	public RecordNaviVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecordNaviVO(HashMap<String, Object> recordChartMap, PagingBean pagingBean) {
		super();
		this.recordChartMap = recordChartMap;
		this.pagingBean = pagingBean;
	}

	public HashMap<String, Object> getRecordChartMap() {
		return recordChartMap;
	}

	public void setRecordChartMap(HashMap<String, Object> recordChartMap) {
		this.recordChartMap = recordChartMap;
	}
	
	public PagingBean getPagingBean() {
		return pagingBean;
	}

	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

	@Override
	public String toString() {
		return "RecordNaviVO [recordChartMap=" + recordChartMap + ", pagingBean=" + pagingBean + "]";
	}
}