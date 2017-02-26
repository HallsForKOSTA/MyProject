package shop.domain;

/**
 * Customer
 * 
 * @since 2016. 9. 28.
 * @author 진권기 (kwonkijin@nextree.co.kr)
 */
public class Customer {

	private String name;
	private String userId;
	private String password;
	
	public Customer(){}
	
	public Customer(String name, String userId, String password) {
		//
		this.name = name;
		this.userId = userId;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
