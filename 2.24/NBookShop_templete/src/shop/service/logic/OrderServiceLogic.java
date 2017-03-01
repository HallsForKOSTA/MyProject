package shop.service.logic;

import shop.domain.Order;
import shop.service.facade.OrderService;
import shop.store.facade.OrderStore;
import shop.store.logic.OrderStoreLogic;

public class OrderServiceLogic implements OrderService {
	private OrderStore store;

	public OrderServiceLogic() {
		store = new OrderStoreLogic();
	}

	@Override
	public boolean order(Order order) {
		return store.insertOrder(order);
	}

}
