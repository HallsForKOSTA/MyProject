package shop.domain;

/**
 * Product
 * 
 * @since 2016. 9. 28.
 * @author 진권기 (kwonkijin@nextree.co.kr)
 */
public class Product {
	//
	private int serialNo;
	private String name;
	private int price;
	private int like; // 선호도 (0~5) 별점 

	public Product() {
	}

	public Product(int serialNo, String name, int price, int like) {
		//
		this.serialNo = serialNo;
		this.name = name;
		this.price = price;
		this.like = like;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getStar() {  // 별점
		int star = 0;
		for (int i = 0; i < like; i++) {  //like를 받아서 찍는다
			star += 1;
		}
		return star * 20;
	}
}
