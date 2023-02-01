package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	public String getExcelData(String SheetName,int RowNum, int celNum) throws Throwable, IOException {
	FileInputStream efis= new FileInputStream("./src/test/resources/Book1.xlsx");
	Workbook book = WorkbookFactory.create(efis);
	Sheet sh=book.getSheet(SheetName);
	Row row= sh.getRow(RowNum);
	Cell cel =row.getCell(celNum);
	String Value=cel.getStringCellValue();
	return Value;
	}
}
