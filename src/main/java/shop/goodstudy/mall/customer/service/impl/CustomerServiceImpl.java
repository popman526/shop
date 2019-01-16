package shop.goodstudy.mall.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.customer.mapper.CustomerMapper;
import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.customer.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public void registCustomer(Customer customer) throws Exception {
        customerMapper.create(customer);
    }

    @Override
    public Customer readCustomer(String customer_id) throws Exception {
        return customerMapper.read(customer_id);
    }

    @Override
    public void modify(Customer customer) throws Exception {
        customerMapper.update(customer);
    }

    @Override
    public void remove(String customer_id) throws Exception {
        customerMapper.delete(customer_id);
    }

    @Override
    public List<Customer> listAll() throws Exception {
        return customerMapper.listAll();
    }



}
