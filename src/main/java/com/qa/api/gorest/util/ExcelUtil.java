package com.qa.api.gorest.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author dzmitryrazhkou
 */

public class ExcelUtil {

    public static Workbook book;
    public static Sheet sheet;

    public static String TESTDATA_SHEET_PATH = "/Users/dzmitryrazhkou/Documents/Automation/RestAssuredFramework" +
            "/src/main/java/com/qa/api/gorest/testdata/data.xlsx";

    /**
     *
     * @param sheetName
     * @return
     */

    public static Object[][] getTestData(String sheetName){
        try {
            FileInputStream ip = new FileInputStream(TESTDATA_SHEET_PATH);
            book = WorkbookFactory.create(ip);
            sheet = book.getSheet(sheetName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }

        }
        return data;
    }

}
