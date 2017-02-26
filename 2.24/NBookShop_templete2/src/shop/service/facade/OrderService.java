package shop.service.facade;

import shop.domain.Order;


/**
 * OrderService
 * 
 * @since 2016. 9. 28.
 * @author 진권기 (kwonkijin@nextree.co.kr)
 */
public interface OrderService {

	boolean order(Order order);
}
