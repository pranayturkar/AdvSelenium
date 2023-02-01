package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTestJava {
	
	@Test
	public void m1() {
		WebDriver driver;
		String BROWSER = System.getProperty("browser");
		String URL= System.getProperty("url");
		String UN= System.getProperty("username");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else {    //mvn test -Dtest=classname -Dbrowser=chrome -Durl=http://localhost:8888/
			driver = new ChromeDriver();
		}
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
	}

}
