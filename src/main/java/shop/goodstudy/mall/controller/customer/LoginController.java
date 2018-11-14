package shop.goodstudy.mall.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.customer.service.CustomerService;

@Controller
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	
    @PostMapping("/customer/login")
    public String loginJsp(HttpServletRequest request) {
        String customer_id = request.getParameter("customer_id");
        String customer_pw = request.getParameter("customer_pw");
        Customer customer = customerService.selectCustomerByCustomerId(customer_id);

        if (customer == null) {
            throw new NullPointerException("사용자를 찾을 수 없습니다.");
        }

        if (customer.matchPassword(customer_pw)) {
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            return "redirect:/";
        } else {
            throw new IllegalStateException("비밀번호가 틀립니다.");
        }
    }
}
