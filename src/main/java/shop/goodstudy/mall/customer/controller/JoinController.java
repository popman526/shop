package shop.goodstudy.mall.customer.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.customer.service.CustomerService;

@Controller
@RequestMapping("/customer/*")
public class JoinController {
    private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

    @Autowired
    CustomerService customerService;

    // 회원가입 폼 창 요청
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String registerGET(Customer customer) {
    	return "customer/joinForm";
    }

    // 회원가입 요청
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public void registerPOST(HttpServletRequest request, HttpServletResponse response, Customer customer)
            throws Exception {
        String customer_id = request.getParameter("customer_id");
        String customer_pw = request.getParameter("customer_pw");
        String customer_pw2 = request.getParameter("customer_pw2");
        String customer_name = request.getParameter("customer_name");
        String customer_email = request.getParameter("customer_email");

        // 오류 메시지를 담을 세션객체 생성
        HttpSession session = request.getSession();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 빈칸이 있을경우
        if (customer_id == null || customer_id.equals("") || customer_pw == null || customer_pw.equals("")
                || customer_pw2 == null || customer_pw2.equals("") || customer_name == null || customer_name.equals("")
                || customer_email == null || customer_email.equals("")) {
            session.setAttribute("messageType", "오류 메시지");
            session.setAttribute("messageContent", "빈칸이 존재 합니다.");
            response.sendRedirect("/customer/join");
            return;
        }

        if (!customer_pw.equals(customer_pw2)) {
            session.setAttribute("messageType", "오류 메시지");
            session.setAttribute("messageContent", "비밀번호가 서로 일치하지 않습니다");
            response.sendRedirect("/customer/join");
            return;
        }

        customerService.registCustomer(customer);
        session.setAttribute("messageType", "성공 메시지");
        session.setAttribute("messageContent", "회원가입이 성공하였습니다!");
        response.sendRedirect("/");
        return;
    }

}
