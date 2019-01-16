package shop.goodstudy.mall.customer.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.customer.service.CustomerService;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    // 회원 리스트 목록 요청
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public void listAll(Model model) throws Exception {
        logger.info("show all list...............");
        model.addAttribute("list", customerService.listAll());
    }

    // 회원 정보 조회
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public void read(@RequestParam("customer_id") String customer_id, Model model) throws Exception {
        model.addAttribute("customerVO", customerService.readCustomer(customer_id));
    }

    // 회원 탈퇴
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("customer_id") String customer_id, RedirectAttributes ra, HttpSession session) throws Exception {
        customerService.remove(customer_id);

        ra.addFlashAttribute("msg", "SUCCESS");
        session.invalidate();
        return "redirect:/";
    }

    // 회원 수정 페이지 요청
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public void modifyGET(String customer_id, Model model) throws Exception {
        model.addAttribute(customerService.readCustomer(customer_id));
    }

    // 회원 수정
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyGET(Customer customer, RedirectAttributes ra) throws Exception {
        logger.info("mod post.................");

        customerService.modify(customer);
        ra.addFlashAttribute("msg", "SUCCESS");

        return "redirect:/";
    }
}
