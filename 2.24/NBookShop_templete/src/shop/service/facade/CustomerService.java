package shop.service.facade;

import shop.domain.Customer;

/**
 * CustomerService
 * 
 * @since 2016. 9. 28.
 * @author 진권기 (kwonkijin@nextree.co.kr)
 */

public interface CustomerService {
	
	boolean login(String userId, String password);
	
	Customer getCustomer(String userId);

}
