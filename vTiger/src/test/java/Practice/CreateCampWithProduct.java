package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampWithProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		FileInputStream efis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook book = WorkbookFactory.create(efis);
		Sheet sh= book.getSheet("Product");
		Row row = sh.getRow(0);
		Cell cel = row.getCell(0);
		String prdData = cel.getStringCellValue()+ranNum;
		driver.findElement(By.name("productname")).sendKeys(prdData);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//navigate to more....>Campaigns
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		//click on + sign
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		//fetching data from excel to campaigns
		FileInputStream efis1 = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook book1 = WorkbookFactory.create(efis1);
		Sheet sh1 = book1.getSheet("Campaigns");
		Row row1 = sh1.getRow(0);
		Cell cel1 = row1.getCell(0);
		String CampData = cel1.getStringCellValue()+ranNum;
		driver.findElement(By.name("campaignname")).sendKeys(CampData);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		//window Switching
		Set<String> allId = driver.getWindowHandles();
		Iterator<String>it= allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String title=driver.getTitle();
			if(title.contains("Products&action")) {
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(prdData);
		driver.findElement(By.name("search")).click();
		
		Thread.sleep(1000);
		//Dynamic Xpath
		driver.findElement(By.xpath("//a[text()='"+prdData+"']")).click();
		//window Switching Back
		
		Set<String> allId1 = driver.getWindowHandles();
		Iterator<String> it1 = allId1.iterator();
		while(it1.hasNext())
		{
			String wid1 = it1.next();
			driver.switchTo().window(wid1);
			String title= driver.getTitle();
			if(title.contains("Campaigns&action")) {
				break;
			}
		}
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//logout
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("//a[text()='Sign Out']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
