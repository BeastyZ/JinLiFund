package utils;
/*
 * 翻页控制实体类
 */
public class PageControler {

	private final int pageSize = 10;
	private final int firstPageNo = 1;
	private int prePageNo;
	private int nextPageNo;
	private int lastPageNo;
	private int totalPage;
	private int currentPageNo;
	
	public PageControler(int totalRecord, int currentPageNo) {
		super();
		this.currentPageNo = currentPageNo;
		
		if(totalRecord % this.pageSize == 0)
			this.totalPage = totalRecord / this.pageSize;
		else
			this.totalPage = totalRecord / this.pageSize + 1;
		
		// 最后一页
		this.lastPageNo = this.totalPage;
		
		// 下一页
		if(currentPageNo < this.totalPage) {
			this.nextPageNo = currentPageNo + 1;
		}
		else{
			this.nextPageNo = this.lastPageNo;
		}
		
		//前一页
		if(currentPageNo > 1) {
			this.prePageNo = currentPageNo - 1;
		}
		else {
			this.prePageNo = 1;
		}
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getFirstPageNo() {	
		return firstPageNo;
	}
	public int getPrePageNo() {
		return prePageNo;
	}
	public void setPrePageNo(int prePageNo) {
		this.prePageNo = prePageNo;
	}
	public int getNextPageNo() {		
		return nextPageNo;
	}
	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}
	public int getLastPageNo() {
		return lastPageNo;
	}
	public void setLastPageNo(int lastPageNo) {
		this.lastPageNo = lastPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
}
