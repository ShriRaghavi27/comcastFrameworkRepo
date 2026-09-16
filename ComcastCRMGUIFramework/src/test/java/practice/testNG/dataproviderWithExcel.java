package practice.testNG;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class dataproviderWithExcel {
	
	@DataProvider
	public Object[][] getdata() throws IOException
	{
		ExcelUtility eLib=new ExcelUtility();
		int count = eLib.getRowCount("data");
		Object[][] obj=new Object[count][2];
		
		for(int i=0;i<count;i++) {
		obj[i][0]=eLib.getDataFromExcelFile("data", i+1,0 );
		obj[i][1]=eLib.getDataFromExcelFile("data", i+1,1 );
				}
		
		return obj;
		
	}
	@Test(dataProvider = "getdata")
	public void dataproviderTest(String productCat,String productName) {
		System.out.println(productCat+" "+productName);
		
	}

}
