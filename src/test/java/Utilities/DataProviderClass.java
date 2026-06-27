package Utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name = "loginData")
	public Object[][] getData() throws Exception {
	    String filePath = System.getProperty("user.dir") 
	                      + "/src/test/resources/testdata/LoginDetails.xlsx";
	    return ExcelUtil.getExcelData(filePath, "logindata");
	}
}
