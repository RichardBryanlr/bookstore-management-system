package entities;

public class Product {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private double bookPrice;
	private double cashAccount;
	private int quantityInStock;
	private int quantitySoldFromStock;
	
	public Product() {}
	
	public Product(int bookId, String bookTitle, String bookAuthor, double bookPrice, int quantityInStock) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.quantityInStock = quantityInStock;
	}
	
	public Product(int bookId, String bookTitle, String bookAuthor, double bookPrice, double cashAccount,
			int quantityInStock) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.cashAccount = cashAccount;
		this.quantityInStock = quantityInStock;
	}
	
	// BOOK ID
	public int getBookId() {
		return bookId;
	}
	
	// BOOK TITLE
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	// BOOK AUTHOR
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	// BOOK PRICE
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	// CASH ACCOUNT
	public double getCashAccount() {
		return cashAccount;
	}
	
	// QUANTITY IN STOCK
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
	// QUANTITY SOLD FROM STOCK
	
	public int getQuantitySoldFromStock() {
		return quantitySoldFromStock;
	}

	public void setQuantitySoldFromStock(int quantitySoldFromStock) {
		this.quantitySoldFromStock = quantitySoldFromStock;
	}
	
	// METHODS	
	public void removeProduct() {
		this.quantityInStock -= 1;
	}
	
	public void soldProduct() {
		this.quantitySoldFromStock += 1;
	}
	
	public String toString() {
		return "ID: "
				+ bookId
				+ " | Book title: "
				+ bookTitle
				+ " | Book author: "
				+ bookAuthor
				+ " | Book price R$ "
				+ String.format("%.2f", bookPrice)
				+ " | Quantity in stock: "
				+ quantityInStock;
	}
	
	public String toStringSoldList() {
		return "Sold: "
				+ quantitySoldFromStock
				+ " | ID: "
				+ bookId
				+ " | Book title: "
				+ bookTitle
				+ " | Book author: "
				+ bookAuthor
				+ " | Book price R$ "
				+ String.format("%.2f", bookPrice)
				+ " | Quantity in stock: "
				+ quantityInStock;
	}
}
