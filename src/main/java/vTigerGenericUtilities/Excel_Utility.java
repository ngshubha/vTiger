package vTigerGenericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	/**
	 * This method is used to read data from ExcelSheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	public String readDataFromExcelSheet(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		// step1:- path connection
				FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

				// step2:- keep workbook in read mode
				Workbook book = WorkbookFactory.create(fis1);

				// step3:- Navigates into particular sheet
				Sheet sheet = book.getSheet(sheetName);

				// step4:- Navigates into particular Row
				Row row = sheet.getRow(rowNum);

				// step5:-Navigates into particular cell

				Cell cell = row.getCell(cellNum);

				String data = cell.getStringCellValue();
				System.out.println(data);
				return data;


	}
	
	/**
	 * This method is used to read data from EXcel Using DataFormatter
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelUsingDataProvider(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		// step1:- path connection
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

		// step2:- keep workbook in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigates into particular sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:- Navigates into particular Row
		Row row = sheet.getRow(rowNum);

		// step5:-Navigates into particular cell

		Cell cell = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(cell);
		System.out.println(data);
		return data;
	}
}

