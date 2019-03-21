package shop.goodstudy.mall.order.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import shop.goodstudy.mall.order.model.OrderDetailVO;
import shop.goodstudy.mall.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderRestController {

	@Autowired OrderService orderService;
	
	
	
}//end of OrderRestController
