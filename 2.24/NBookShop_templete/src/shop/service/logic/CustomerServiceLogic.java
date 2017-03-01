package shop.service.logic;

import shop.domain.Customer;
import shop.service.facade.CustomerService;
import shop.store.facade.CustomerStore;
import shop.store.logic.CustomerStoreLogic;

public class CustomerServiceLogic implements CustomerService {
	private CustomerStore store;

	public CustomerServiceLogic() {
		store = new CustomerStoreLogic();
	}

	@Override
	public boolean login(String userId, String password) {

		Customer customer = store.findCustomerById(userId);  // store에서 userId로 해당되는 customer를 찾는다.

		if (customer != null && customer.getPassword().equals(password)) {//로그인 아이디가 해당 디비에 있고 (널이 아니고)
			return true;											      //그 cusomer의 비밀번호가 입력한 값과 같으면 true
		}

		return false;  // 로그인안됨 
	}

	@Override
	public Customer getCustomer(String userId) {

		return store.findCustomerById(userId);
	}
}
