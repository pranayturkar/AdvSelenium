package Test;

import java.io.FileInputStream;
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

import Object_Reop.CreateProductPage;
import Object_Reop.Homepage;

public class CreateProductTest {
	public static void main(String[] args) throws Throwable {
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
		
		Homepage home =new Homepage(driver);
		home.clickProductLink();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		CreateProductPage prd = new CreateProductPage(driver);
		prd.productCreateImage();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		
		Random ran = new Random();
		int RanNum = ran.nextInt(1000);
		
		FileInputStream efis= new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook book = WorkbookFactory.create(efis);
		Sheet sh=book.getSheet("Organisation");
		Row row= sh.getRow(0);
		Cell cel =row.getCell(0);
		String ProductName=cel.getStringCellValue();
		driver.findElement(By.name("productname")).sendKeys(ProductName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

}
}
