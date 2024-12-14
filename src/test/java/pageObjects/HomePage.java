package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement lnkmyaccount;

@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
WebElement clkregister;

@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
WebElement BtnLogin;

public void clickMyAccount() {
	lnkmyaccount.click();
}

public void clickRegister() {
	clkregister.click();
}
	
public void btnclickaction() {
	BtnLogin.click();
}

}
