package shop.goodstudy.mall.customer.service;

import java.util.List;

import shop.goodstudy.mall.customer.model.Customer;

public interface CustomerService {

    public void registCustomer(Customer customer) throws Exception;

    public Customer readCustomer(String customer_id) throws Exception;

    public void modify(Customer customer) throws Exception;

    public void remove(String customer_id) throws Exception;

    public List<Customer> listAll() throws Exception;
}