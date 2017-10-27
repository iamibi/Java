//Hover
        WebElement element1 = dr.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[8]/ul/li[3]/a/span[1]/span/span"));
        Actions ac = new Actions(dr);
        ac.moveToElement(element1).click().build().perform();
		
//Dropdown
        WebElement em = dr.findElement(By.xpath("//*[@id=\"continents\"]"));
        Select drop = new Select(em);
        drop.selectByIndex(3);
		
//Scroll
        WebElement lang = dr.findElement(By.xpath("//*[@id=\"continents\"]"));
		((JavascriptExecutor)dr).executeScript("arguments[0].scrollIntoView();", lang);
		
//Frame
		dr.switchTo().frame("a077aa5e");
		dr.findElement(By.xpath("html/body/a/img")).click();
		
//Excel
		FileInputStream fs = new FileInputStream("C:\\Users\\1354518\\Desktop\\Work\\mysheet.xls");
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
