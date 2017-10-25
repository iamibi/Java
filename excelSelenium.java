package com;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;

public class Excel {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\1354518\\Desktop\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		FileInputStream fs = new FileInputStream("C:\\Users\\1354518\\Desktop\\New folder\\mysheet.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(0);
		
		int row = sh.getRows();
		for (int i = 0; i < row; i++)
		{
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(sh.getCell(0, i).getContents());
			driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.findElement(By.id("twotabsearchtextbox")).clear();
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0,250);");
		}
	}

}
