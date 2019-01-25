package shop.goodstudy.mall.common;
//
public class PagingUtils {
	  
	private int totalPage, startPage, endPage;
	private int startRow, endRow;
	private StringBuilder sb;

	public void paging(int pageNum, int count, int pageSize, int pageBlock) {
		totalPage = (int) Math.ceil((double) count / pageSize); // 전체 페이지
		startRow = (pageNum - 1) * pageSize + 1; // 시작 게시글 번호 지정
		endRow = pageNum * pageSize; // 끝 게시글 번호 지정

		startPage = (int) ((pageNum - 1) / pageBlock) * pageBlock + 1;
		endPage = startPage + pageBlock - 1;

		if (endPage > totalPage) {
			endPage = totalPage;
		}

		sb = new StringBuilder();
		if (startPage < pageBlock) { // 이전 페이지로 가기
			sb.append("<li><img src='/images/beforePage.png' width='35'></li>");
		} else {
			sb.append("<li><img src='/images/beforePage.png' width='35'");
			sb.append(" onclick='location.href=\"?pageNum=");
			sb.append(startPage - pageBlock);
			sb.append("\"' style='cursor:pointer'> </li>");
		}

		sb.append("&nbsp;|");
		for (int i = startPage; i <= endPage; i++) { // 페이지 번호 별 매핑
			if (i == pageNum) {
				sb.append("&nbsp;&nbsp;<b><font color='#91B7EF'>");
				sb.append(i);
				sb.append("</font></b>");
			} else {
				sb.append("&nbsp;&nbsp;<a href='/?pageNum=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}

		sb.append("&nbsp;|");
		if (endPage < totalPage) { // 다음 페이지로 가기
			sb.append("<li><img src='/images/afterPage.png'  width='35'");
			sb.append(" onclick='location.href=\"?pageNum=");
			sb.append(startPage + pageBlock);
			sb.append("\"' style='cursor:pointer'> </li>");
		} else {
			sb.append("<li><img src='/images/afterPage.png'  width='35'></li>");

		}
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public StringBuilder getSb() {
		return sb;
	}

}
