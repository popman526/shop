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

import shop.goodstudy.mall.cart.service.CartService;
import shop.goodstudy.mall.image.service.ImageService;
import shop.goodstudy.mall.order.mapper.OrderMapper;
import shop.goodstudy.mall.order.model.OrderDetailVO;
import shop.goodstudy.mall.order.model.OrderVO;
import shop.goodstudy.mall.order.service.OrderService;
//import shop.goodstudy.mall.util.CustomerSessionUtils;

@Controller
public class OrderListController {
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderService OrderServiceImpl;
	@Autowired
	private ImageService imageService;
	@Autowired
	private CartService cartService;
	
	@PostMapping("/order/product")
	public ModelAndView insertOrder(  
			HttpServletRequest request,
			@RequestParam(value="order_quantity", required=true) List<Integer> order_quantities,
			@RequestParam(value="product_price", required=false) List<Integer> prices,
			@RequestParam(value="finalPrice", required=true) List<Integer> finalPrices,
			@RequestParam(value="product_id", required=true) List<Integer> product_ids,
			@RequestParam(value="product_name", required=true) List<String> product_names
			) throws Exception {
		
		int idx = 0;
		OrderVO orderVO= new OrderVO();
		OrderDetailVO orderDetailVO= new OrderDetailVO();
		List<OrderDetailVO> oDetail = new ArrayList<OrderDetailVO>();
		
		//Customer customer = CustomerSessionUtils.getCustomerFromSession(request.getSession());
		//orderVO.setCustomer_code(customer.getCustomer_code());
		
		for( int price : finalPrices ) {
			orderVO.setOrder_total_price(price);
			
			idx = finalPrices.indexOf(price);
			orderDetailVO.setProduct_price(price );
			int product_id = product_ids.get(idx);
			orderDetailVO.setProduct_id(product_id);
			orderDetailVO.setOrder_quantity(order_quantities.get(idx));
			orderDetailVO.setProduct_name(product_names.get(idx));
			
			OrderServiceImpl.insertOrderAndDetail(orderVO, orderDetailVO);
			// page 보여줄 값 setting
			oDetail.add(orderDetailVO);
		}
		
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
	
	@PostMapping("/order")
	public String cartOrder(@RequestParam("cart_id") List<Long> list, @RequestParam("total") int total) throws Exception {
		
		OrderVO order = new OrderVO();
		order.setOrder_total_price(total);
		OrderServiceImpl.insertCartOrder(order,list);
		
		return "redirect:/orderList";
	}
	
}
