package shop.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Order
 * 
 * @since 2016. 9. 28.
 * @author 진권기 (kwonkijin@nextree.co.kr)
 */
public class Order {  //1주문

	private Customer customer;
	private List<Product> products; //하나의 주문을 살 때 여러개의 상품을 살수있음
	private PaymentMethod payment;     // enum 열거형
	private String shipAddress; // 주소
	
	public Order() {
		//
		this.products = new ArrayList<Product>();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public PaymentMethod getPayment() {
		return payment;
	}
	public void setPayment(PaymentMethod payment) {
		this.payment = payment;
	}
	public String getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}
	
	//--------------------------------------------------------------------------
	public void addProduct(Product product) {
		//
		products.add(product);
	}
	
	public int getTotalPrice() {
		//
		int total = 0;
		for (Product product : products) {
			total += product.getPrice();
		}
		return total;
	}
}
