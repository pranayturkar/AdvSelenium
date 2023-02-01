package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductsTest extends BaseClass{
@Test
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValue("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		//driver.manage().window().maximize();
		//FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");
		//Properties p = new Properties();
		//p.load(fis);
		//String URL = p.getProperty("url");
		//String USERNAME = p.getProperty("username");
		//String PASSWORD = p.getProperty("password");
//		File_Utility flib1= new File_Utility();
//		String URL = flib1.getKeyAndValue("url");
//		String USERNAME = flib1.getKeyAndValue("username");
//		String PASSWORD = flib1.getKeyAndValue("password");
//		
//		driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		driver.findElement(By.xpath("//a[text()='Products']")).click();
//		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		//Calling method java_Utility
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		//fetching data from excel
		//FileInputStream efis= new FileInputStream("./src/test/resources/Book1.xlsx");
		//Workbook book = WorkbookFactory.create(efis);
		//Sheet sh=book.getSheet("Organisation");
		//Row row= sh.getRow(0);
		//Cell cel =row.getCell(0);
		//String ProductName=cel.getStringCellValue()+ranNum;
		
		//calling the method from fromExcel_Utility
		Excel_Utility elib = new Excel_Utility();
		String ProductName = elib.getExcelData("Products", 0, 0)+ranNum;
		driver.findElement(By.name("productname")).sendKeys(ProductName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
	}


}

