package shop.goodstudy.mall.customer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.customer.model.Customer;

@Mapper
public interface CustomerMapper {
    public void create(Customer customer);

    public Customer read(String customer_id);

    public void update(Customer customer);

    public void delete(String customer_id);

    public List<Customer> listAll();
}
