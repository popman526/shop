package shop.goodstudy.mall.customer.service;

import shop.goodstudy.mall.customer.model.Customer;

public interface CustomerService {

	Customer selectCustomerByCustomerId(String customer_id);

}