package shop.store.facade;

import shop.domain.Customer;

/**
 * CustomerStore
 * 
 * @since 2016. 9. 28.
 * @author 진권기 (kwonkijin@nextree.co.kr)
 */

public interface CustomerStore {
	
	Customer findCustomerById(String id);
}
