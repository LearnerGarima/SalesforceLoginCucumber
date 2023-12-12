package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testcase.BaseTest;

public class LogOutPage  extends BaseTest {

	@FindBy(xpath="//a[contains(text(),'Return to Login')]") WebElement logout;

	public LogOutPage(WebDriver driver) {
		super(driver);
		
	}

}