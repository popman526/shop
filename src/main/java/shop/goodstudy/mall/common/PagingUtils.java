package shop.goodstudy.mall.common;

public class PagingUtils {
	  
	private int totalPage, startPage, endPage;
	private int startRow;

	public void paging(int pageNum, int count, int pageSize, int pageBlock) {
		totalPage = (int) Math.ceil((double) count / pageSize); // 전체 페이지
		startRow = (pageNum - 1) * pageSize; // 시작 게시글 번호 지정

		startPage = (int) ((pageNum - 1) / pageBlock) * pageBlock + 1;
		endPage = startPage + pageBlock - 1;

		if (endPage > totalPage) {
			endPage = totalPage;
		}
	}

	public int getStartRow() {
		return startRow;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}
	
}
