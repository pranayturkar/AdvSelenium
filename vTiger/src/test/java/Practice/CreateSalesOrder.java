package Practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;

public class CreateSalesOrder {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		File_Utility flib= new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Sales Order")).click();
		driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String SalesOrder = elib.getExcelData("SalesOrder",0,0)+ranNum;
		driver.findElement(By.name("subject")).sendKeys(SalesOrder);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}

}
