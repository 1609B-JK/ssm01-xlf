package common.util;

public class Page {

	//当前页
	private int pageIndex = 1;
	
	//每页条数
	private int pageSize = 3;
	
	//总条数
	private int totalCount;
	
	//总页数
	private int totalPage;
	
	//开始位置
	private int startPos;
	
	//结束位置
	private int endPos;
	
	//计算分页信息
	public void countInfo() {
		if (0 == pageSize) {
			pageSize = 3;
		}
		//总页数
		totalPage = totalCount % pageSize == 0 
				? totalCount / pageSize
				: totalCount / pageSize + 1;
		if (pageIndex > totalPage) {
			pageIndex = totalPage;
		}
		if (pageIndex < 1) {
			pageIndex = 1;
		}
		//开始位置
		startPos = pageSize * (pageIndex - 1)+1;//easyui_oracle
		//结束位置
		endPos = pageSize * pageIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPos() {
		return startPos;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public int getEndPos() {
		return endPos;
	}

	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}
}
