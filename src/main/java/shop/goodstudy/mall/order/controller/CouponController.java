package shop.goodstudy.mall.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.common.CustomerSessionUtils;
import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.order.mapper.CouponMapper;
import shop.goodstudy.mall.order.model.CouponVO;
import shop.goodstudy.mall.order.model.OrderVO;

@Controller
@RequestMapping("/coupon/*")
public class CouponController {

    //private static final Logger logger = LoggerFactory.getLogger(CouponController.class);

    @Autowired
	private CouponMapper couponMapper;

    // 회원 리스트 목록 요청
    @RequestMapping(value = "/couponList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView couponList(HttpServletRequest request, Model model) throws Exception {
    	List<CouponVO> couponList = null;
    	
    	Customer customer = CustomerSessionUtils.getCustomerFromSession(request.getSession());
    	if( !"".equals(customer) && customer != null ) {
    		couponList = couponMapper.selectAllCoupon(customer.getCustomer_id());
    	}
    	
		ModelAndView returnPage = new ModelAndView("/order/couponList");
		returnPage.addObject("couponList", couponList);
		return returnPage;
    }
    
    // 회원 리스트 목록 요청
    @RequestMapping(value = "/couponPopup", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView couponPopup(HttpServletRequest request, Model model) throws Exception {
    	List<CouponVO> couponList = null;
    	
    	Customer customer = CustomerSessionUtils.getCustomerFromSession(request.getSession());
    	if( !"".equals(customer) && customer != null ) {
    		couponList = couponMapper.selectAllCoupon(customer.getCustomer_id());
    	}
    	
		ModelAndView returnPage = new ModelAndView("/order/couponPopup");
		returnPage.addObject("couponList", couponList);
		return returnPage;
    }
    
    // 쿠폰존 ( 쿠폰 free download 장소 )
    @RequestMapping(value = "/couponZone", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView couponZone(HttpServletRequest request, Model model) throws Exception {
    	
		ModelAndView returnPage = new ModelAndView("/order/couponZone");
		//returnPage.addObject("couponList", couponList);
		return returnPage;
    }
    
    // 쿠폰 다운로드
    @RequestMapping(value = "/getCoupon", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getCoupon(HttpServletRequest request, Model model) throws Exception {
    	if (!CustomerSessionUtils.isLogined(request.getSession())) {
            return new ModelAndView("/customer/loginForm");
        }
    	
    	int coupon_id = ( request.getParameter("coupon_id") == null ) ? 0 : Integer.parseInt(request.getParameter("coupon_id")) ;
    	String coupon_type = ( request.getParameter("coupon_type") == null ) ? "P" : request.getParameter("coupon_type");
    	
    	CouponVO couponVO = new CouponVO();
    	
    	Customer customer = CustomerSessionUtils.getCustomerFromSession(request.getSession());
    	couponVO.setCoupon_name("할인쿠폰");
    	couponVO.setCustomer_id(customer.getCustomer_id());
    	couponVO.setDiscount(coupon_id); 
    	couponVO.setDiscount_type(coupon_type);
    	
    	int result = couponMapper.insertCoupon(couponVO);
    	
    	ModelAndView returnPage = new ModelAndView("/order/couponZone");
    	if( result > 0 ) {
    		returnPage.addObject("result", "쿠폰을 성공적으로 다운로드 받았습니다.");
    	} else {
    		returnPage.addObject("result", "쿠폰을 다운로드 받지 못했습니다.");
    	}
		return returnPage;
		//return "redirect:/order/couponZone";
    }


}
