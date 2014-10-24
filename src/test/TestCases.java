/**
 * 
 */
package test;
import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Prashant
 *
 */


public class TestCases {

	ReadCVS tester;

  @BeforeClass
  public static void testSetup() {
    
  }

  @AfterClass
  public static void testCleanup() {
    // Do your cleanup here like close URL connection , releasing resources etc
  }

  //Checking with given test data file
  @Test
  public void testRun() {  
	  System.out.println("");
	  System.out.println("Checking with given test data file");
	  tester = new ReadCVS();
	  tester.csvFile="C:\\test_shares_data.csv";
	  tester.flag=1;
      tester.run();
      System.out.println("");
      System.out.println("Comparing Company C max Share Price");
      if(tester.companyDetails.get(2).maxSharePrice==995.0){
    	  System.out.println("Test 1 Successfully completed");
      }
     
      if(tester.companyDetails.get(2).maxSharePriceYear.equalsIgnoreCase("1993")&&tester.companyDetails.get(2).maxSharePriceMonth.equalsIgnoreCase("Jun")){
    	  System.out.println("Test 2 Successfully completed");
      }
      
  }
  
  //Checking if empty file given
  @Test
  public void testEmptyData() {  
	  System.out.println("");
	  System.out.println("Checking if empty file given");
	  tester = new ReadCVS();
	  tester.csvFile="C:\\test2.csv";
	  tester.flag=1;
      tester.run();
      
      if(tester.noOfCompanies==0){
    	  System.out.println("Test 3 Successfully completed");
      }
      
  }
  
  //Checking if only Header data is given 
  @Test
  public void testHeaderDataOnly() {  
	  System.out.println("");
	  System.out.println("Checking if only Header data is given ");
	  tester = new ReadCVS();
	  tester.csvFile="C:\\test1.csv";
	  tester.flag=1;
      tester.run();
      
      if(tester.noOfCompanies==7){
    	  System.out.println("Test 4 Successfully completed");
      }
      
  }

} 