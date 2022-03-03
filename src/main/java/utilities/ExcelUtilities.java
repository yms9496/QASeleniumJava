package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {


	// test data path - relative
	final String testDataPath = System.getProperty("user.dir") + "\\test data\\TestData.xlsx";

	// Method to read value from excel
	public String excelRead(String key) {

		// string value to be returned
		String val = "";

		// Split sheetname, rownum, colnum
		String keySeparated[] = key.split(",");

		if (keySeparated.length != 3) {
			System.out.println("Incorrect key Passed to Excel Read Method");
			return null;
		}

		String sheetName = keySeparated[0];
		int row = Integer.parseInt(keySeparated[1]);
		int col = Integer.parseInt(keySeparated[2]);

		// empty sheet object
		Sheet sheet = null;

		try {

			// load file
			FileInputStream fis = new FileInputStream(testDataPath);

			// initialize excel as a workbook
			Workbook workbook = WorkbookFactory.create(fis);

			// load the sheet from excel
			sheet = workbook.getSheet(sheetName);

			// get value from respective location
			val = sheet.getRow(row).getCell(col).getStringCellValue();
		}

		catch (Exception e) {

			System.out.println("Excel Read Error");
			e.printStackTrace();
		}

		// System.out.println("Value Read From Excel: " + val);
		return val;
	}

	// Method to write value to excel
	public void excelWrite(String key, String value) {

		String keySeparated[] = key.split(",");

		if (keySeparated.length != 3) {
			System.out.println("Incorrect key Passed to Excel Read Method");
		}

		String sheetName = keySeparated[0];
		int row = Integer.parseInt(keySeparated[1]);
		int col = Integer.parseInt(keySeparated[2]);

		// empty sheet object
		Sheet sheet = null;

		try {

			// load file
			FileInputStream fis = new FileInputStream(testDataPath);

			// initialize excel as a workbook
			Workbook workbook = WorkbookFactory.create(fis);

			// load the sheet from excel
			sheet = workbook.getSheet(sheetName);

			// get value from respective location
			sheet.getRow(row).getCell(col).setCellValue(value);

			FileOutputStream fos = new FileOutputStream(testDataPath);

			workbook.write(fos);

			workbook.close();

		} catch (Exception e) {

			System.out.println("Excel Write Error");
			e.printStackTrace();
		}

		System.out.println("Value Written to Excel: " + value);

	}

	// ---Override excelRead Method---
	public String excelRead(String sheetName, String row, String column) {

		// string value to be returned
		String val = "";

		int row_num = Integer.parseInt(row);
		int col_num = Integer.parseInt(column);

		// empty sheet object
		Sheet sheet = null;

		try {

			// load file
			FileInputStream fis = new FileInputStream(testDataPath);

			// initialize excel as a workbook
			Workbook workbook = WorkbookFactory.create(fis);

			// load the sheet from excel
			sheet = workbook.getSheet(sheetName);

			// get value from respective location
			val = sheet.getRow(row_num).getCell(col_num).getStringCellValue();
		}

		catch (Exception e) {

			System.out.println("Excel Read Error");
			e.printStackTrace();
		}

		// System.out.println("Value Read from Excel: " + val);
		return val;
	}

	// ---Override excelWrite Method---
	public void excelWrite(String sheetName, String row, String column, String value) {

		int row_num = Integer.parseInt(row);
		int col_num = Integer.parseInt(column);

		// empty sheet object
		Sheet sheet = null;

		try {

			// load file
			FileInputStream fis = new FileInputStream(testDataPath);

			// initialize excel as a workbook
			Workbook workbook = WorkbookFactory.create(fis);

			// load the sheet from excel
			sheet = workbook.getSheet(sheetName);

			// get value from respective location
			sheet.getRow(row_num).getCell(col_num).setCellValue(value);

			FileOutputStream fos = new FileOutputStream(testDataPath);

			workbook.write(fos);

			workbook.close();

		} catch (Exception e) {

			System.out.println("Excel Write Error");
			e.printStackTrace();
		}

		System.out.println("Value Written to Excel: " + value);
	}


}
