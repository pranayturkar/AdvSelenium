package Object_Reop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_File;

public class Homepage {
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Products")
	private WebElement productlinktext;
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignlink;
	
	@FindBy(linkText="Organizations")
	private WebElement organisationlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminlink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;

	public WebElement getProductlinktext() {
		return productlinktext;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getOrganisationlink() {
		return organisationlink;
	}

	public WebElement getAdminlink() {
		return adminlink;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	public void clickProductLink() {
		productlinktext.click();
	}
	
	public void moreLink(WebDriver driver) {
		WebDriver_File wlib = new WebDriver_File();
		wlib.mouseOverOnElement(driver, morelink);
	}
	
	public void  campaignLink() {
		campaignlink.click();
	}
	
	public void organisationLink() {
		organisationlink.click();
	}
	
	public void adminLink() {
		adminlink.click();
		
	}
	
	public void signOutLink(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(signoutlink).perform();
		signoutlink.click();
	}
}

