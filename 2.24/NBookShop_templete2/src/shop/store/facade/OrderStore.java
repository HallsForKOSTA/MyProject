package shop.store.facade;

import shop.domain.Order;

/**
 * OrderStore
 * 
 * @since 2016. 9. 28.
 * @author 진권기 (kwonkijin@nextree.co.kr)
 */

public interface OrderStore {
	
	boolean insertOrder(Order order);

}
