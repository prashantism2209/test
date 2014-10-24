package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

 
public class ReadCVS extends JPanel {
	   JFileChooser fc;
	   String csvFile;
	   int flag=0;
	   List<CompanyDetail> companyDetails=null;
	   int noOfCompanies=0;
  public static void main(String[] args) {
 
	ReadCVS obj = new ReadCVS();
	
	obj.setCSVFile();
	obj.run();
	
 
  }
 
  public void run() {
 
	String csvFile = this.csvFile;  //file.getAbsolutePath();   //"C:\\test_shares_data.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	
	companyDetails=new ArrayList<CompanyDetail>();
	 
	try {
		if(flag==1){
		br = new BufferedReader(new FileReader(csvFile));
		
		if((line = br.readLine()) != null){
			String [] companyHeaders=line.split(cvsSplitBy);
			noOfCompanies=companyHeaders.length-2;
			
			for(int i=0;i<noOfCompanies;i++){
				CompanyDetail companyDetail=new CompanyDetail();
				companyDetail.setName(companyHeaders[i+2]);
				companyDetails.add(companyDetail);
			}
		}
		else{
			System.out.println("No Data Found inside File");
		}
		
		int dataFlag=0;		
		while ((line = br.readLine()) != null) {
			dataFlag=1;
		
			String [] companyLine=line.split(cvsSplitBy);
			for(int i=0;i<noOfCompanies;i++){
				CompanyDetail companyDetail=companyDetails.get(i);
				SharePrice sharePrice=new SharePrice(companyLine[0],companyLine[1],Double.parseDouble(companyLine[i+2]));
				companyDetail.addTosharePrices(sharePrice);
				
			}
		}
		
		//Listing Maximum Share Prices for Each Company
		if(dataFlag==1){
				for(int i=0;i<noOfCompanies;i++){
					CompanyDetail companyDetail=companyDetails.get(i);
					Double maxSharePrice=0.0;
				
					for (int j = 0; j < companyDetail.getSharePrices().size(); j++) {
						if(companyDetail.getSharePrices().get(j).getPrice()>maxSharePrice)
							maxSharePrice=companyDetail.getSharePrices().get(j).getPrice();
						//System.out.println(companyDetail.getSharePrices().get(j));
					}
					
					companyDetail.maxSharePrice=maxSharePrice;
		//Printing MaxShare Price and its year, month. Here if more than one instance of max price exists it prints all instances			
					System.out.println("Company: "+companyDetail.getName()+" Maximum Share Price="+companyDetail.maxSharePrice+" in");
					for (int j = 0; j < companyDetail.getSharePrices().size(); j++) {
						if(companyDetail.getSharePrices().get(j).getPrice()==companyDetail.maxSharePrice)
						{
							System.out.println("Year:"+companyDetail.getSharePrices().get(j).getYear()+" Month:"+companyDetail.getSharePrices().get(j).getMonth());
							// if more than one instances of max share prices. It takes latest value of month
							companyDetail.maxSharePriceMonth=companyDetail.getSharePrices().get(j).getMonth();
							// if more than one instances of max share prices. It takes latest value of year
							companyDetail.maxSharePriceYear=companyDetail.getSharePrices().get(j).getYear();
						}	
					}
				
			}
		}else{
			System.out.println("No Data Found");
		}
	}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	//System.out.println("Done");
  }
 
  public void setCSVFile(){
	  fc = new JFileChooser();
	  
	  //For choosing only CSV Files
	  fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	  fc.addChoosableFileFilter(new FileNameExtensionFilter("CSV Documents", "csv"));
      
		int returnVal = fc.showOpenDialog(ReadCVS.this); //Where frame is the parent component
		
		File file = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		    file = fc.getSelectedFile();
		    this.csvFile=file.getAbsolutePath();
		   flag=1;
		} else {
		    System.out.println("Invalid File");
		}  
	  
  }
	
}
 
 

