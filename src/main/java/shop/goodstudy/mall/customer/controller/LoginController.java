package shop.goodstudy.mall.customer.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.customer.service.CustomerService;

@Controller
@RequestMapping("/customer/*")
public class LoginController {

    @Autowired
    private CustomerService customerService;

    // 로그인 페이지 요청
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginFormJsp() {
        return "customer/login";
    }

    // 로그인 요청
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginJsp(@RequestParam("customer_id") String customer_id,
                           @RequestParam("customer_pw") String customer_pw,
                           HttpSession session) throws Exception {
        Customer customer = customerService.readCustomer(customer_id);

        // 회원가입이 안되었을 경우
        if (customer == null) {
            throw new NullPointerException("사용자를 찾을 수 없습니다.");
        }

        // 패스워드 일치 여부
        if (customer.matchPassword(customer_pw)) {
            session.setAttribute("customer", customer);
            return "redirect:/";
        } else {
            throw new IllegalStateException("비밀번호가 틀립니다.");
        }
    }
}
