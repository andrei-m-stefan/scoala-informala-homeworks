package ro.sci.BookStore;

public class Book {

	private String title;
	private long ISBN;
	private String genre;
	private String author;
	private int weight;
	private double price;
	
	
	
	public Book(int iSBN2) {
		this.ISBN = iSBN2;
	}


	public String getTitle() {
		return this.title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public long getISBN() {
		return this.ISBN;
	}


	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
