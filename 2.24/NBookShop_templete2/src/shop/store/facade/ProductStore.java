package shop.store.facade;

import java.util.List;

import shop.domain.Product;

/**
 * ProductStore
 * 
 * @since 2016. 9. 28.
 * @author 진권기 (kwonkijin@nextree.co.kr)
 */

public interface ProductStore {
	
	List<Product> findAll();
	
	Product findByNo(int serial);
	

}
