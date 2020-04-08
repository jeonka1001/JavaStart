package vo;

public class Comics {
	private String title;
	private int id;
	private int price;
	private String categoryCode;
	private String publisherCode;
	private Category category; // 본인이 어떤 종류인지 구분하기 위한 카테고리 변수
	
	public Comics() {}
	public Comics(String title, int id, int price, String categoryCode, String publisherCode,Category category) {
		super();
		this.title = title;
		this.id = id;
		this.price = price;
		this.categoryCode = categoryCode;
		this.publisherCode = publisherCode;
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getPublisherCode() {
		return publisherCode;
	}
	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}
	public void setCategory(Category category) {
		this.category =category;
	}
	public Category getCategory() {
		return this.category;
	}
	
}
