package test;

import java.io.FileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	WebDriver driver;
	JsonElement jsonEleObj;
	
	String userName; 
	String password;
	String dashboardHeaderText;
	String userAlertText;
	String passwordAlertText;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	
	public void readJson() {
		try {
			FileReader reader= new FileReader("src\\main\\java\\testData\\TF_TestData.json");
			JsonParser perserObj = new JsonParser();
			jsonEleObj = perserObj.parse(reader);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validUserShouldBeAbleToLogin() {

		driver = BrowserFactory.init();

		// LogPage lp= new LoginPage();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginPage.insertPssword(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("Password").getAsString());
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		Assert.assertEquals(dashboardPage.validateDashboardPageText(),jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("ValidationTextLogin").getAsString(),
				"Dashboard page is not available!");
		BrowserFactory.tearDown();

	}

	//@Test
	public void validateAlertPopup() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSigninButton();
		Assert.assertEquals(loginPage.getUSerAlertMsg(),jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("ValidationUserAlertText").getAsString(), "user Alert msg doesn't match!!");

		loginPage.insertUserName(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginPage.clickSigninButton();
		Assert.assertEquals(loginPage.getUSerAlertMsg(),jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("ValidationUserAlertText").getAsString(),
				"Password Alert msg doesn't match!!");
		BrowserFactory.tearDown();
	}

}
