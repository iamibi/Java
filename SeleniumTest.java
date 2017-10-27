import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		dr.findElement(By.xpath("//*[@id=\"roundWay\"]/form/div[1]/ul/li[2]/div/ul/li[26]/a"))
		
		dr.findElement(By.xpath("//*[@id=\"roundWay\"]/form/div[1]/ul/li[3]/input")).click();
		
		WebElement em = dr.findElement(By.name("indiGoRoundTripSearch.PassengerCounts[0].Count"));
        Select drop = new Select(em);
        drop.selectByIndex(3);
		
        dr.findElement(By.xpath("//*[@id=\"depart-date\"]")).click();
        dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[3]/td[3]/a")).click();
        
        dr.findElement(By.name("indiGoRoundTripSearch.ReturnDate")).click();
        dr.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[5]/a")).click();
        
        dr.findElement(By.xpath("//*[@id=\"roundWay\"]/form/div[2]/button")).click();
        Thread.sleep(5000);
        
        dr.navigate().to("");
        
        dr.findElement(By.xpath("//*[@id=\"bookingWidgetContainer\"]/div/div/div[2]/div[2]/div/div/div[2]/div/button[3]/span/i")).click();
	}

}
