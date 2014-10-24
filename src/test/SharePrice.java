/**
 * This Class contains share prices on (year,month) basis
 */
package test;

/**
 * @author Prashant
 *
 */
public class SharePrice {
	 private String year;  
	 private String month;  
	 private double price;
	 
	 public SharePrice(String year, String month, double price) {  
	          
	        this.year = year;   
	        this.month = month;   
	        this.price = price;  
	    }

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}  
	 
	
}
