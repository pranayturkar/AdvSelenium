package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Object_Reop.OrganisationCreatePage;
public class CreateOrganisationTest extends BaseClass {
	
	@Test(retryAnalyzer = Generic_Utility.RetryImpClass.class)
	//@Test(groups = {"regression", "smoke"})
	
	public void CreateOrganisation()
	{
		Excel_File elib = new Excel_File();
		Java_File jlib = new Java_File();
		WebDriver_File wlib = new WebDriver_File();
		wlib.waitForPageToLoad(driver);
		HomePage home = new HomePage(driver);
		home.clickOrganizationLinkText();
		
		//SoftAssert soft = new SoftAssert();
		//soft.assertEquals("A","B");
		
		OrganisationCreatePage org = new OrganisationCreatePage(driver);
		org.clickOrganisationCreateImage();
		
		int RanNum = jlib.getRanDomNum();
		String Orgdata = elib.getExcelData("Organisation",0,0)+RanNum;
		
		Thread.sleep(1000);
		org.organsiationNamesTextField(Orgdata);
		//hardAssert
		Assert.assertEquals("A","B");
		
		
		
		
		
	}

}
