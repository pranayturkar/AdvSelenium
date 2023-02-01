package Generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;


public class WebDriver_File { 
	public void maximizeScreen(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * wait for page to load before identidying any synchronised element in POM
	 * @author Ultra
	 */
	public void waitForPageToLoad(WebDriver driver) {
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**After every action it will wait for next action to perform
	 * @author Ultra
	 */
	
	public void waitforElementWithCustomTimeOut(WebDriver driver,WebElement Element, int pollingTime) {
	driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
	
	}
	/**
	 * used to wait for element to be clickaable in GUI and check for specific element for 500millisec
	 * @author Ultra
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(pollingTime));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to switch to any Window based on window title
	 * @param driver
	 * @param driver
	 * @param PartialWindowTitle
	 * @author Ultra
	 */
	public void switchToWindow(WebDriver driver, String PartialWindowTitle) {
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(PartialWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * used to switch to AlertWindow and Accept(Click on OK Button)
	 * @param driver
	 * @author Ultra
	 */
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch to AlertWindow and Dismiss(Click on Cancel Button)
	 * @param driver
	 * @author Ultra
	 */
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to switch to frame window based on Index
	 * @param driver
	 * @param index
	 * @author Ultra
	 */
	public void switchToFrame(WebDriver driver, int Index) {
		driver.switchTo().frame(Index);
	}
	
	/**
	 * used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 * @author Ultra
	 */
	
	public void switchToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the Dropdown based on Index
	 * @param element
	 * @param index
	 * @author Ultra
	 */
	public void select(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropDown based on text
	 * @param element
	 * @param text
	 * @author Ultra
	 */
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * used to mouse hover on a specified element
	 * @author Ultra
	 */
	
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * used to right click on a specific element
	 * @param driver
	 * @param element
	 * @author Ultra
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public void moveByOffset(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.moveByOffset(x,y).click().perform();
	}
	
	
	
	
	
	
	
}
