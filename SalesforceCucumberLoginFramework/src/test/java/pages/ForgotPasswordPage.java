package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testcase.BaseTest;



public class ForgotPasswordPage extends BaseTest {

	@FindBy(xpath="//input[@id='un']") WebElement uname;
	@FindBy(xpath="//input[@id='continue']") WebElement cont;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void enterUname(String username)
	{
		waitExplicit(uname);
		enterText(uname,username,"userName");
	}
	public void clickOnContinue()
	{
		waitExplicit(cont);
		clickElement(cont,"continue button");
	}

}