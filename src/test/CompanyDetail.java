/**
 * This Class contains Company name its share Prices based on (year,month) basis
 */
package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Prashant
 *
 */
public class CompanyDetail {

	String name="";
	List<SharePrice> sharePrices=new ArrayList<SharePrice>();
	
	Double maxSharePrice=0.0;
	String maxSharePriceYear="";
	String maxSharePriceMonth="";
	
	//Add the Share Price object to List of sharePrices
	public void addTosharePrices(SharePrice sharePrice){
		this.sharePrices.add(sharePrice);
	}
	
	
	/**
	 * @return the sharePrices
	 */
	public List<SharePrice> getSharePrices() {
		return sharePrices;
	}
	/**
	 * @param sharePrices the sharePrices to set
	 */
	public void setSharePrices(List<SharePrice> sharePrices) {
		this.sharePrices = sharePrices;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the maxSharePrice
	 */
	public Double getMaxSharePrice() {
		return maxSharePrice;
	}
	/**
	 * @param maxSharePrice the maxSharePrice to set
	 */
	public void setMaxSharePrice(Double maxSharePrice) {
		this.maxSharePrice = maxSharePrice;
	}
	/**
	 * @return the maxSharePriceYear
	 */
	public String getMaxSharePriceYear() {
		return maxSharePriceYear;
	}
	/**
	 * @param maxSharePriceYear the maxSharePriceYear to set
	 */
	public void setMaxSharePriceYear(String maxSharePriceYear) {
		this.maxSharePriceYear = maxSharePriceYear;
	}
	/**
	 * @return the maxSharePriceMonth
	 */
	public String getMaxSharePriceMonth() {
		return maxSharePriceMonth;
	}
	/**
	 * @param maxSharePriceMonth the maxSharePriceMonth to set
	 */
	public void setMaxSharePriceMonth(String maxSharePriceMonth) {
		this.maxSharePriceMonth = maxSharePriceMonth;
	}
}
