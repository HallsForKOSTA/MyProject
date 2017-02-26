package shop.service.logic;

import java.util.ArrayList;
import java.util.List;

import shop.domain.Product;
import shop.service.facade.ProductService;
import shop.store.facade.ProductStore;
import shop.store.logic.ProductStoreLogic;

public class ProductServiceLogic implements ProductService {
	private ProductStore store;

	public ProductServiceLogic() {
		store = new ProductStoreLogic();
	}

	@Override
	public List<Product> getAllProducts() {

		return store.findAll();
	}

	@Override
	public List<Product> getBuyProducts(String[] serials) { // String배열을 매개변수로 받는다.
		List<Product> list = new ArrayList<>();

		for (String serial : serials) {// 매개변수로 받아온 스트링 배열을 for문으로 하나씩 꺼내서
			Product product = store.findByNo(Integer.parseInt(serial)); //시리얼값을 인트값으로 형변환후 시리얼 번호로 해당상품을 찾는다.
			if (product != null) { //상품이 있으면 상품리스트에 추가한다.
				list.add(product);
			}
		}
		return list;
	}

	@Override
	public Product getProduct(String serial) {

		return store.findByNo(Integer.parseInt(serial));
	}

}
