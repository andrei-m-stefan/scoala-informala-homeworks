/**
 * 
 */
package ro.sci.BookStore;

/**
 * @author andreistefan
 *
 */
public class CartEntry {
// make these private
	Book book;
	int qty;
	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
