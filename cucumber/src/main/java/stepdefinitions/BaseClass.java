package stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public static FileInputStream fisEx;
	public static int col_num;
	public static DataFormatter formatter;

	public static String getData(String header) throws IOException {
		
		fisEx = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\testData.xlsx");
		formatter = new DataFormatter();
		XSSFWorkbook workbook = new XSSFWorkbook(fisEx);
		XSSFSheet sheet = workbook.getSheet("custinfodata");
		XSSFRow row = sheet.getRow(0);


		for (int i = 0; i < row.getLastCellNum(); i++) {

			if (row.getCell(i).getStringCellValue().trim().equals(header))
				col_num = i;
		}

		row = sheet.getRow(1);
		XSSFCell headercell = row.getCell(col_num);
		String value =formatter.formatCellValue(headercell);
		
		
		
		
		
		return value;
	}
	

}
