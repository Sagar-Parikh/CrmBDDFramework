package com.crm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 15;
	public static long EXPLICIT_WAIT = 15;
	static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";


	public void javaScripExecutorClick(WebElement E) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", E);
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\screenshots\\" + System.currentTimeMillis() + ".png"));

	}

}
