package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.BaseClass;

public class FormPage extends BaseClass{
	
	public FormPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (className = "freebirdFormviewerViewHeaderTitle")
	WebElement heading;
	
	@FindBy(xpath = "//input[@aria-label=\"Name\"]")
	WebElement nameInputField;
	
	@FindBy(xpath = "//input[@aria-label=\"Email\"]")
	WebElement emailInputField;
	
	@FindBy(xpath = "//textarea[@aria-label=\"Address\"]")
	WebElement addressInputField;
	
	@FindBy(xpath = "//input[@aria-label=\"Phone number\"]")
	WebElement phoneNumberInputField;
	
	@FindBy(xpath = "//textarea[@aria-label=\"Comments\"]")
	WebElement commentInputField;
	
	@FindBy(className = "appsMaterialWizButtonPaperbuttonContent")
	WebElement submitButton;
	
	@FindBy(className = "freebirdFormviewerViewResponseConfirmationMessage")
	WebElement confirmationText;
		
	
	
	public boolean isCurrent()
	{
		return heading.isDisplayed();
	}
	
	public void inputName(String name)
	{
		nameInputField.sendKeys(name);
	}
	
	public void inputemail(String email)
	{
		emailInputField.sendKeys(email);
	}
	
	public void inputaddress(String address)
	{
		addressInputField.sendKeys(address);
	}
	
	public void inputPhoneNumber(String phoneNumber)
	{
		phoneNumberInputField.sendKeys(phoneNumber);
	}
	
	public void inputComment(String comment)
	{
		commentInputField.sendKeys(comment);
	}
	
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	
	public boolean confirmSubmission()
	{
		return confirmationText.isDisplayed();
	}

}
