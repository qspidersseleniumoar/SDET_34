package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

public class RealAllDataFromExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./data/testdata.xlsx");
		
			Workbook wb=  WorkbookFactory.create(fis);
			Sheet sh =  wb.getSheet("Sheet1");
			
			int rowCount =   sh.getLastRowNum();
		for(int i=1 ; i<rowCount ; i++) {	
			Row row = sh.getRow(i);
			String colum_1_data =  row.getCell(0).getStringCellValue();
			String colum_2_data = row.getCell(1).getStringCellValue();
			System.out.println(colum_1_data + "\t" + colum_2_data);
		}
			
			wb.close();
			
			
			
		
	}

}
