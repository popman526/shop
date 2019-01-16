package shop.goodstudy.mall.customer.model;

import lombok.Data;

@Data
public class CustomerDTO {
    private String customer_id;
    private String customer_pw;
    private String customer_pw2;
    private String customer_name;
    private String customer_email;

}
