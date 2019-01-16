package shop.goodstudy.mall.customer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.goodstudy.mall.customer.model.CustomerVO;

@Mapper
public interface CustomerMapper {
    public void create(CustomerVO customer);

    public CustomerVO read(String customer_id);

    public void update(CustomerVO customer);

    public void delete(String customer_id);

    public List<CustomerVO> listAll();
}
