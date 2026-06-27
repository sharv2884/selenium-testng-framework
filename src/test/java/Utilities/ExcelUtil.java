package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	//use only if this class has to be exceuted
	/*public static void main(String[] args) throws IOException {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/LoginDetails.xlsx";
		getExcelData(filePath, "logindata");
	}*/

	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(filePath); // open and read the file in the system
		XSSFWorkbook workbook = new XSSFWorkbook(fis); // to access the entire excel file
		XSSFSheet sheet = workbook.getSheet(sheetName); // to access a single sheet from the excel file

		int rowNumber = sheet.getLastRowNum();
		//System.out.println("row number: " + rowNumber);
		int colNumber = sheet.getRow(0).getLastCellNum();

		Object[][] signUpData = new Object[rowNumber][colNumber];

		for (int i = 1; i <= rowNumber; i++) {
			for (int j = 0; j < colNumber; j++) {
				XSSFCell cellValue = sheet.getRow(i).getCell(j);
				if (cellValue == null) {
					signUpData[i - 1][j] = "";
				} else if (cellValue.getCellType() == CellType.STRING) {
					signUpData[i - 1][j] = cellValue.getStringCellValue();
				} else {
					signUpData[i - 1][j] = String.valueOf(cellValue.getNumericCellValue());
				}
				//System.out.print(signUpData[i-1][j] + " ");
			}
			//System.out.println();
		}
		workbook.close(); // if workbook not closed then memory leak
		return signUpData;
	}
}
