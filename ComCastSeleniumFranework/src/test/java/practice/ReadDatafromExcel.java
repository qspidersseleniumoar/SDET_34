package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatafromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/testdata.xlsx");
		
       /*step 1 : Open WorkBook in read mode*/
		Workbook wb=  WorkbookFactory.create(fis);
	   /*step 2 : get the control of required "Sheet"*/
		Sheet sh =  wb.getSheet("org");
		/*step 3 : get the control of required "Row"*/	
		Row row = sh.getRow(1);
		/*step 4 : get the control of required "Cell" & read the read*/	
		Cell cel =  row.getCell(2);
		String data = cel.getStringCellValue();
		System.out.println(data);
		
		/*step 4 : close the WorkBook"*/
		wb.close();
	}

}	










