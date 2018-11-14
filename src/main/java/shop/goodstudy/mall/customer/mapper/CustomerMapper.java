package shop.goodstudy.mall.customer.mapper;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.customer.model.Customer;

@Mapper
public interface CustomerMapper {
	Customer selectCustomerByCustomerId(String customer_id);
}
