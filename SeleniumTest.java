import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;

public class GoIndigo {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\selenium-2.47.1\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.goindigo.in/");
		
		Thread.sleep(5000);
		FileInputStream fs = new FileInputStream("C:\\Users\\1354518\\Desktop\\Work\\mysheet.xls");
		Workbook workbook = Workbook.getWorkbook(fs);
		Sheet sheet = workbook.getSheet(0);
		
		dr.findElement(By.xpath("//*[@id=\"roundWay\"]/form/div[1]/ul/li[1]/input[1]")).clear();
		dr.findElement(By.xpath("//*[@id=\"roundWay\"]/form/div[1]/ul/li[1]/input[1]")).sendKeys(sheet.getCell(0,0).getContents());
		dr.findElement(By.xpath("//*[@id=\"roundWay\"]/form/div[1]/ul/li[2]/input[1]")).sendKeys(sheet.getCell(0,1).getContents());
		dr.findElement(By.xpath("//*[@id=\"roundWay\"]/form/div[1]/ul/li[2]/div/ul/li[26]/a"));
		
		dr.findElement(By.xpath("//*[@id=\"roundWay\"]/form/div[1]/ul/li[3]/input")).click();
		
		WebElement em = dr.findElement(By.name("indiGoRoundTripSearch.PassengerCounts[0].Count"));
        Select drop = new Select(em);
        drop.selectByIndex(3);
		
        dr.findElement(By.xpath("//*[@id=\"depart-date\"]")).click();
        dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[3]/td[3]/a")).click();
        
        dr.findElement(By.name("indiGoRoundTripSearch.ReturnDate")).click();
        dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[5]/a")).click();
        
        dr.findElement(By.xpath("//*[@id=\"roundWay\"]/form/div[2]/button")).click();
        
        TakesScreenshot scrShot =((TakesScreenshot)dr);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile=new File("D:\\MyScreenshot-1.jpg");
        FileUtils.copyFile(SrcFile, DestFile);
        
        Thread.sleep(5000);
        
        dr.navigate().to("https://www.flipkart.com/");
        
        dr.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[1]/div/input")).sendKeys(sheet.getCell(0,2).getContents());
        dr.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[2]/button")).click();
        
        JavascriptExecutor jse = (JavascriptExecutor)dr;
        jse.executeScript("window.scrollBy(0,250)", "");
        
		Thread.sleep(2000);
		
		WebElement checkBox1 = dr.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[2]/div/div[1]/div/div/div[6]/section/div[2]/div[1]/div[2]/div/div/label/div[1]"));
		WebElement checkBox2 = dr.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[2]/div/div[1]/div/div/div[3]/section/div[1]/label/div[1]"));
		checkBox1.click();
		checkBox2.click();
		Thread.sleep(2000);
		
		//Click on the book by iterating
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
		
		//Take Screenshot
		TakesScreenshot ss =((TakesScreenshot)dr);
		File sf = ss.getScreenshotAs(OutputType.FILE);

		File df = new File("D:\\MyScreenshot-2.jpg");
		FileUtils.copyFile(sf, df);
		
		//Print Book Fare
		System.out.println(dr.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div/div[1]")).getText());
		
		
		dr.close();
	}

}
