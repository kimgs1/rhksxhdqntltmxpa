package pasing;

public class ContentInfoPagingBean extends PagingBean {
	
	/**
	 * 한 페이지에서 보여줄 게시물 수 
	 */
	public static final int numberOfContentPerPage=15;
	/**
	 * 한 페이지 그룹내 페이지 수 
	 */
	public static final int numberOfPageGroup=10;
	/**
	 * PagingBean을 통해 페이징 로직을 정의하기 위해서는 
	 * 전체 게시물 수와 현재 페이지 넘버를 필요로 한다. 
	 * @param totalContent
	 * @param nowPage
	 */
	public ContentInfoPagingBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ContentInfoPagingBean(int totalContent, int nowPage) {
		super(totalContent,nowPage,numberOfContentPerPage , numberOfPageGroup);
//		super();
//		this.totalContent = totalContent;
//		this.nowPage = nowPage;
	}
	
}
