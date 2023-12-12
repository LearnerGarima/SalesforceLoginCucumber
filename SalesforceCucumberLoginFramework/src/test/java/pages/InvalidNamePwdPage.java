package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testcase.BaseTest;

public class InvalidNamePwdPage extends BaseTest {
	@FindBy(xpath = "//div[@id='error']") WebElement errorMsg;
	public InvalidNamePwdPage(WebDriver driver) {
		super(driver);
		
	}
	
	public boolean foundErrorMessage()
	{
		waitExplicit(errorMsg);
		return isPresent(errorMsg);
	}

}