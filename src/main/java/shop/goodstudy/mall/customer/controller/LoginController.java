package shop.goodstudy.mall.customer.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.customer.service.CustomerService;

@Controller
@RequestMapping("/customer/*")
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginFormJsp() {
        return "customer/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginJsp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String customer_id = request.getParameter("customer_id");
        String customer_pw = request.getParameter("customer_pw");
        Customer customer = customerService.readCustomer(customer_id);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 회원가입이 안되었을 경우
        if (customer == null) {
            throw new NullPointerException("사용자를 찾을 수 없습니다.");
        }

        // 패스워드 일치 여부
        if (customer.matchPassword(customer_pw)) {
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            return "redirect:/";
        } else {
            throw new IllegalStateException("비밀번호가 틀립니다.");
        }
    }
}
