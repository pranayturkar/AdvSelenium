package Object_Reop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationCreatePage {
	public OrganisationCreatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement organisationCreateImage;
	@FindBy(name="accountname")
	private WebElement organisationnameTextField;
	
	@FindBy(name="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getOrganisationCreateImage() {
		return organisationCreateImage;
	}

	public WebElement getOrganisationnameTextField() {
		return organisationnameTextField;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public void clickOrganisationCreateImage(){
	organisationCreateImage.click();
	}
	public void organsiationNamesTextField(String orgName) {
		organisationnameTextField.sendKeys(orgName);
	}
	public void saveButton()
	{
		savebutton.click();
	}
	
}
