package utilities;

import org.testng.annotations.DataProvider;

public class DataProvisders {
	//dataproviser1...name is Logindata
	@DataProvider(name="Logindata")
	public  String[][] getdata() throws Throwable
	{
		String path=".\\testdata\\Login.xlsx";
		ExcelFileUtil xlutil=new ExcelFileUtil(path);
		int totalrows=xlutil.rowCount("opencart1");
		int totalcols=xlutil.cellCount("opencart1");
		String logindata[][]=new String[totalrows][totalcols];
		for (int i = 1; i <=totalrows; i++) {
			for (int j = 0; j <=totalcols; j++) 
			{
				logindata[i-1][j]=xlutil.getCellData("opencart1", i, j);
			}
		}
		return logindata;//two dimensional array
	}
}
//dataproviser2//for another test class
//dataproviser3//for another test class