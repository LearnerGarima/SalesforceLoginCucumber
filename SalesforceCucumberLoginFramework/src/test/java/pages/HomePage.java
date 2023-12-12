package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testcase.BaseTest;



public class HomePage extends BaseTest {
	@FindBy(xpath = "//span[@id='userNavLabel']") WebElement usermenu;
	@FindBy(linkText="Logout") static WebElement logout_button;


	public HomePage(WebDriver driver) {
		super(driver);
	}

	public static String getTextFromHomePage() throws InterruptedException {
		Thread.sleep(5000);
		return getPageTitle();
	}

	public void selectUserMenu() {
		
		waitforVisibilty(usermenu, 20, "user menu label");
		moveandClickAction(usermenu, "mouse hover user menu");
		System.out.println("inside user menu ");
		logout();
	}

	public void logout() 
	{
		clickElement(logout_button, "log out ");
	}


}
