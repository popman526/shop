package shop.goodstudy.mall.order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.order.mapper.OrderMapper;
import shop.goodstudy.mall.order.model.OrderDetailVO;
import shop.goodstudy.mall.order.model.OrderVO;
import shop.goodstudy.mall.order.service.OrderService;
import shop.goodstudy.mall.util.CustomerSessionUtils;

@Controller
public class OrderListController {
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderService OrderServiceImpl;
	
	@PostMapping("/order/product")
	public ModelAndView insertOrder(  
			HttpServletRequest request,
			@RequestParam(value="order_quantity", required=true) List<Integer> order_quantities,
			@RequestParam(value="product_price", required=true) List<Integer> prices,
			@RequestParam(value="product_id", required=true) List<Integer> product_ids,
			@RequestParam(value="product_name", required=true) List<String> product_names
			) throws Exception {
		
		OrderVO orderVO= new OrderVO();
		OrderDetailVO orderDetailVO= new OrderDetailVO();
		
		Customer customer = CustomerSessionUtils.getCustomerFromSession(request.getSession());
		orderVO.setCustomer_code(customer.getCustomer_code());
		
		List<OrderDetailVO> oDetail = new ArrayList<OrderDetailVO>();
		
		for( int price : prices ) {
			orderVO.setOrder_total_price(price);
			// OrderServiceImpl.insertOrder(orderVO);
			
			int idx = prices.indexOf(price);
			orderDetailVO.setProduct_price(price );
			orderDetailVO.setProduct_id(product_ids.get(idx));
			orderDetailVO.setOrder_quantity(order_quantities.get(idx));
			orderDetailVO.setProduct_name(product_names.get(idx));
			
			OrderServiceImpl.insertOrderAndDetail(orderVO, orderDetailVO);
			
			// page 보여줄 값 setting
			oDetail.add(orderDetailVO);
		}
		
		//return "redirect:/orderList";
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/order/orderResult");
        mav.addObject("orderList",oDetail);
        return mav;
	}
	
	@RequestMapping("/orderList")
	public ModelAndView selectOrder() throws Exception {  
		List<OrderVO> orderList = orderMapper.selectOrder();
		ModelAndView returnPage = new ModelAndView("order/orderList");
		returnPage.addObject("orderList",orderList);
		return returnPage;
	}
	
	@RequestMapping("/deleteOrder/{order_id}")
    private String deleteOrder(@PathVariable(value="order_id") int order_id) throws Exception{
		OrderServiceImpl.deleteOrderAndDetail(order_id);
        return "redirect:/orderList";
        
    }
}
