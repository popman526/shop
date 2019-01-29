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


}
