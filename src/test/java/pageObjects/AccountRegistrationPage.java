package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{
	
public AccountRegistrationPage(WebDriver driver) 
{
super(driver);
}

@FindBy(xpath="//*[@id=\"input-firstname\"]")
WebElement firstname;

@FindBy(xpath="//*[@id=\"input-lastname\"]")
WebElement lastname;

@FindBy(xpath="//*[@id=\"input-email\"]")
WebElement email;

@FindBy(xpath="//*[@id=\"input-telephone\"]")
WebElement telephone;

@FindBy(xpath="//*[@id=\"input-password\"]")
WebElement password;

@FindBy(xpath="//*[@id=\"input-confirm\"]")
WebElement confirmpwd;


@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
WebElement chkpolicy;

@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
WebElement btncontinu;

@FindBy(xpath="//*[@id=\"content\"]/p[1]")
WebElement Accountconfirmation;


public void setFirstname(String fname) {
	firstname.sendKeys(fname);
}

public void setLastName(String lname) {
	lastname.sendKeys(lname);
}

public void setemail(String mail) {
	email.sendKeys(mail);
}

public void setPhone(String phone) {
	telephone.sendKeys(phone);
}

public void setPwd(String pwd) {
	password.sendKeys(pwd);
	
}

public void setconfirmpwd(String pwd) {
	confirmpwd.sendKeys(pwd);
	
}


public void ClickAgree() {
	chkpolicy.click();	
}

public void Clickcontinueed() {
	//sol-1
//	btncontinu.click();
	
	//sol-2
//	btncontinu.submit();
	
	//sol-3
	Actions act=new Actions(driver);
	act.moveToElement(btncontinu).click().build().perform();
	
	//sol-4
//	JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("arguments[0].click()", btncontinu);
//	
	//sol-5
//	btncontinu.sendKeys(Keys.RETURN);
//	
	//sol-6
//	WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
//	mywait.until(ExpectedConditions.elementToBeClickable(btncontinu)).click();
}

public String getConfirmationmsg() {
	try {
		return(Accountconfirmation.getText());
	}catch(Exception e) {
		return (e.getMessage());
	}
}



}
