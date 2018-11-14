package shop.goodstudy.mall.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.goodstudy.mall.customer.mapper.CustomerMapper;
import shop.goodstudy.mall.customer.model.Customer;
import shop.goodstudy.mall.customer.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public Customer selectCustomerByCustomerId(String customer_id) {
		return customerMapper.selectCustomerByCustomerId(customer_id);
	}
}
