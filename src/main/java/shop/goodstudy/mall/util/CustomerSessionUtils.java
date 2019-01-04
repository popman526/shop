package shop.goodstudy.mall.util;

import javax.servlet.http.HttpSession;

import shop.goodstudy.mall.customer.model.Customer;

public class CustomerSessionUtils {
	
    public static final String CUSTOMER_SESSION_KEY = "customer";

    /**
     * 세션으로부터 고객VO 가져오기
     * @param session
     * @return
     */
    public static Customer getCustomerFromSession(HttpSession session) {
        Object customer = session.getAttribute(CUSTOMER_SESSION_KEY);
        if (customer == null) {
            return null;
        }
        return (Customer) customer;
    }

    
    /**
     * 로그인 유무 확인하기
     * @param session
     * @return
     */
    public static boolean isLogined(HttpSession session) {
        if (getCustomerFromSession(session) == null) {
            return false;
        }
        return true;
    }

    
    /**
     * 동일 유저인지 확인하기(세션의 고객정보와 넘어온 고객 객체정보간)
     * @param session
     * @param customer
     * @return
     */
    public static boolean isSameCustomer(HttpSession session, Customer customer) {
        if (!isLogined(session)) {
            return false;
        }

        if (customer == null) {
            return false;
        }

        return customer.isSameCustomer(getCustomerFromSession(session));
    }
}
