package Generic_Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		
	}
	public void onTestSuccess(ITestResult result) {
		
	}
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("--------execute---------");
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./ScreenShot/"+testName+".png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}


}



//<?xml version="1.0" encoding="UTF-8"?> 
//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd"> 
//<suite name="Suite"> 
//<listeners> 
//<listener class-name="generics_Utility.ListenersClass">
//</listener> 
//</listeners> 
//<test thread-count="5" name="Test"> 
//<classes> 
//<class name="products.CreateProduct"/> 
//<class name="campaigns.CreateCampaign"/> 
//</classes> 
//</test><!-- Test --> 
//</suite> <!-- Suite -->
//package generics_Utility; import java.io.File; import java.util.Calendar; import org.apache.commons.io.FileUtils; import org.openqa.selenium.OutputType; import org.openqa.selenium.TakesScreenshot; import org.testng.ITestContext; import org.testng.ITestListener; import org.testng.ITestResult; public class ListenersClass implements ITestListener { public void onTestStart(ITestResult result) { } public void onTestSuccess(ITestResult result) { } public void onTestFailure(ITestResult result) { TakesScreenshot ts = (TakesScreenshot)BaseClass.driver; File srcFile = ts.getScreenshotAs(OutputType.FILE); String name = result.getName(); java.util.Date date = Calendar.getInstance().getTime(); String today = date.toString().replace(":", "-"); File destFile = new File("./failedScreenshot/"+name+today+".png"); try { FileUtils.copyFile(srcFile, destFile); } catch (Exception e) { } } public void onTestSkipped(ITestResult result) { } public void onTestFailedButWithinSuccessPercentage(ITestResult result) { } public void onTestFailedWithTimeout(ITestResult result) { } public void onStart(ITestContext context) { } public void onFinish(ITestContext context) { } } 
