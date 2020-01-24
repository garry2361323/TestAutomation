package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static long PAGELAYOUT_TIME = 20;
    public static long IMPLICIT_TIME = 20;
    public static String TESTDATA_SHEET_PATH = "C:\\Users\\gsharma\\Desktop\\Books\\Selenium\\PageObjectModel-master\\PageObjectModel-master\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";
    static Workbook book;
    static Sheet sheet;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    public static Object[][] readXLS(String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
        book = WorkbookFactory.create(file);
        sheet = book.getSheet(sheetName);
        Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int row=0;row<=sheet.getLastRowNum();row++){
            for (int cell=0;cell<=sheet.getRow(0).getLastCellNum()){
                    data[row][cell] = sheet.getRow(row+1).getCell(cell).toString();
            }
        }
        return data;
    }
}
