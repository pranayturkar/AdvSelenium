package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampaigns {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		FileInputStream efis= new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook book = WorkbookFactory.create(efis);
		Sheet sh=book.getSheet("Organisation");
		Row row= sh.getRow(0);
		Cell cel =row.getCell(0);
		String ProductName=cel.getStringCellValue()+ranNum;
		
		driver.findElement(By.name("productname")).sendKeys(ProductName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		

	}

}
