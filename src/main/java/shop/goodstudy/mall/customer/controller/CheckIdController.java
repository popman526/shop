package shop.goodstudy.mall.customer.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.customer.service.CustomerService;


@RestController
@RequestMapping("/customer/*")
public class CheckIdController {
    private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/idCheck", method = RequestMethod.POST)
    public int postIdCheck(HttpServletRequest request) throws Exception {
        logger.info("post idCheck");

        String customer_id = request.getParameter("customer_id");
        int result = 0;

        // 빈칸일 경우
        if (customer_id.equals("")) {
            return result + 1;
        }

        Customer customer = customerService.readCustomer(customer_id);

        // 이미 회원이 있다면
        if (customer != null) {
            return 1;
        }
        // 없다면
        return result;
    }
}

