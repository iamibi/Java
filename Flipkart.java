package com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Flipkart
{
	public static void main(String[] args) throws InterruptedException, BiffException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\selenium-2.47.1\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.flipkart.com/");
		
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//HOVER
		WebElement element1 = dr.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[2]/div/ul/li[7]/a"));
        Actions ac = new Actions(dr);
        ac.moveToElement(element1).click().build().perform();
        dr.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[2]/div/ul/li[7]/a")).click();
        
        WebElement element2 = dr.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[2]/div/ul/li[7]/ul/li/ul/li[5]/ul/li[4]/a"));
        Actions ac1 = new Actions(dr);
        ac1.moveToElement(element2).click().build().perform();
        
        //Scroll
        WebElement lang = dr.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[2]/div/div[1]/div/div/div[3]/section/div[1]/label/div[2]/div"));
		((JavascriptExecutor)dr).executeScript("arguments[0].scrollIntoView();", lang);
		
		Thread.sleep(2000);
		
		WebElement checkBox1 = dr.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[2]/div/div[1]/div/div/div[6]/section/div[2]/div[1]/div[2]/div/div/label/div[1]"));
		WebElement checkBox2 = dr.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[2]/div/div[1]/div/div/div[3]/section/div[1]/label/div[1]"));
		checkBox1.click();
		checkBox2.click();
		
		Thread.sleep(2000);
		List<WebElement> links = dr.findElements(By.className("_3liAhj"));
		
		int i = 0;
		for (WebElement l: links)
		{
			if (i == 4)
			{
				l.click();
				break;
			}
			i++;
		}
		System.out.println(dr.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/h1")).getText());
		System.out.println(dr.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div/div[1]")).getText());
		
		dr.navigate().to("https://www.amazon.in/");
		
		FileInputStream fs = new FileInputStream("C:\\Users\\1354518\\Desktop\\Work\\mysheet.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(0);
		
		int row = sh.getRows();
		for (i = 0; i < row; i++)
		{
			dr.findElement(By.id("twotabsearchtextbox")).sendKeys(sh.getCell(0, i).getContents());
			dr.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
			Thread.sleep(2000);
			dr.findElement(By.id("twotabsearchtextbox")).clear();
		}
		dr.close();
	}
}
