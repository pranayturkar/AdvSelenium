package Generic_Utility;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void BS() {
		System.out.println("Database Connection");
	}
	@BeforeTest(groups= {"smoke","regression"})
	public void BT() {
		System.out.println("Parallel Execution");
	}
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regression"})
	//public void BC() throws Throwable {{
	public void BC(String BROWSER) throws Throwable {{
		//File_Utility flib = new File_Utility();
		//String BROWSER = flib.getKeyAndValue("browser");
		
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
	}
		System.out.println("Launching the Browser");
		sdriver = driver;
	}
	@BeforeMethod
	public void BM() {
		System.out.println("Login to Application");
	}
	@AfterMethod
	public void AM() {
		System.out.println("Logout to Application");
	}
	@AfterClass
	public void AC() {
		System.out.println("Close the Browser");
	}
	@AfterTest
	public void AT() {
		System.out.println("Execution done");
	}
	@AfterSuite
	public void AS() {
		System.out.println("Application closed");
	}

}
