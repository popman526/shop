package shop.goodstudy.mall.customer.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("customer")
public class Customer {
	private String customer_id;
    private String customer_pw;
    private String customer_name;
    private String customer_email;
	
    public Customer() {
    	
    }
    
    public Customer(String customer_id, String customer_pw, String customer_name, String customer_email) {
    	super();
    	this.customer_id = customer_id;
    	this.customer_pw = customer_pw;
    	this.customer_name = customer_name;
    	this.customer_email = customer_email;
    }

	public boolean matchPassword(String customer_pw) {
        if (customer_pw == null) {
            return false;
        }

        return this.customer_pw.equals(customer_pw);
    }
	
	public boolean isSameCustomer(Customer customer) {
        return isSameCustomer(customer.getCustomer_id());
    }
	
	public boolean isSameCustomer(String newCustomerId) {
        return customer_id.equals(newCustomerId);
    }
    
}
