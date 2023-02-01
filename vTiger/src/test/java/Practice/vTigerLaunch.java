package Practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class vTigerLaunch {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\Vtiger.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(@href,'index.')])[40]")).click();
		FileInputStream efis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook book = WorkbookFactory.create(efis);
		Sheet sh =  book.getSheet("Organisation");
		Row row = sh.getRow(0);
		Cell cel = row.getCell(0);
		String orgName=cel.getStringCellValue();
		Thread.sleep(3000);
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[contains(@value,'U')])[3]")).click();
		driver.findElement(By.xpath("//option[text()=' Administrator']")).click();
		driver.findElement(By.xpath("(//input[contains(@class,'crmbutton small save')])[2]")).click();
		
		
		
		
		

	}

}
