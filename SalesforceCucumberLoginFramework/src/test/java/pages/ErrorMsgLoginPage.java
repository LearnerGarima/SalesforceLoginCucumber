package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testcase.BaseTest;

public class ErrorMsgLoginPage extends BaseTest {
	@FindBy(xpath = "//div[@id='error']")
	WebElement error;

	public ErrorMsgLoginPage(WebDriver driver) {
		super(driver);
	}

	public boolean foundErrorMessage() {
		waitforVisibilty(error, 30, "login error");
		if (isPresent(error))
			return true;
		else
			return false;
	}

}