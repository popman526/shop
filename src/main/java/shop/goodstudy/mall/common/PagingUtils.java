package shop.goodstudy.mall.common;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.product.model.Product;

public abstract class PagingUtils {
	
	private int pageSize = 10; //한 페이지의 글의 갯수
	private int pageBlock = 10; //한 블럭에 보여줄 페이지 갯수
	
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
	
	/**
	 * 공통 페이징 처리 부분
	 * ModelAndView를 반환 후 뷰네임을 심어준다.
	 * ex) mav.setViewName("home");
	 * 
	 * @param pageNum
	 * @param srchTerm 검색어
	 * @return {@link ModelAndView}
	 */
	public ModelAndView getPagingMav(String pageNum, String srchTerm) {
		ModelAndView mav = new ModelAndView();
		int count = 0;
		List<Product> products;
		
		if (pageNum == null) {
			pageNum = "1";
		}
		
		count = getProductCount(srchTerm); // 검색어에 해당하는 
		
		paging(Integer.parseInt(pageNum), count, pageSize, pageBlock);
		
		if (count > 0) {
			products = selectAllProduct(getStartRow(), srchTerm); // 현재 페이지에 해당하는 글 목록 가져오기
		} else {
			products = null;
		}
		
		mav.addObject("count", count);
		mav.addObject("pageNum", pageNum);
		mav.addObject("pageBlock", pageBlock);
		mav.addObject("startPage", getStartPage());
		mav.addObject("endPage", getEndPage());
		mav.addObject("totalPage", getTotalPage());
		mav.addObject("products", products);
		return mav;
	}
	
	public abstract int getProductCount(String srchTerm);
	
	public abstract List<Product> selectAllProduct(int startRow, String srchTerm);
}
