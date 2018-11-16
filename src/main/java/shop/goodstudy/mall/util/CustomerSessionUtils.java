package shop.goodstudy.mall.util;

import javax.servlet.http.HttpSession;

import shop.goodstudy.mall.customer.model.Customer;

public class CustomerSessionUtils {
    public static final String CUSTOMER_SESSION_KEY = "customer";

    public static Customer getCustomerFromSession(HttpSession session) {
        Object customer = session.getAttribute(CUSTOMER_SESSION_KEY);
        if (customer == null) {
            return null;
        }
        return (Customer) customer;
    }

    public static boolean isLogined(HttpSession session) {
        if (getCustomerFromSession(session) == null) {
            return false;
        }
        return true;
    }

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
