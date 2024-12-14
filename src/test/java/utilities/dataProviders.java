package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProviders {

	
	/*
	DataProvider Method - will get the data from the excel sheet and store it into a two dimensional array
	 */
	
	
	
		//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path=".\\testData\\opencart_test_data.xlsx";//taking excel file from testData
		ExcelUtilities xlutil=new ExcelUtilities(path); //creating object of XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String loginData[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) 
		{
			for (int j=0;j<totalcols;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j); //0,1
			}
		}
		return loginData; //returning two dimensional array
		
	}
	
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
	
	//DataProvider 5
	
	
}
