package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	public void LogPage(WebDriver driver) {
		this.driver=driver;
	}
	//WebElements (attributes)
	@FindBy(how = How.XPATH, using= "//*[@id=\"user_name\"]") WebElement USER_NAME_ELEMENT;
	@FindBy(how =How.XPATH, using = "//*[@id=\"password\"]") WebElement PASSWORD_ELEMENT;
	@FindBy(how =How.XPATH, using = "//*[@id=\"login_submit\"]") WebElement SIGIN_BUTTON_ELEMENT;
	
	
	
	//Methods (actions)
	public void insertUserName(String userName) {
		USER_NAME_ELEMENT.sendKeys(userName);
	}
	public void insertPssword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	public void clickSigninButton() {
		SIGIN_BUTTON_ELEMENT.click();
	}
	public String getUSerAlertMsg() {
		String actualUserAlertMag = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return actualUserAlertMag;
	}
	public String getPasswordAlertMsg() {
		String actualPasswordAlertMag = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return actualPasswordAlertMag;
	}
}
