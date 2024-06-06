package test;

import java.io.FileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import page.AddCustomerPage;
import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {

	WebDriver driver;
	JsonElement jsonEleObj;
	
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

	
	String userName;
	String password;
	String dashboardHeaderText;
	String addCustomerHeaderText;
	String fullName;
	String email;
	String company;
	String phone;
	String address;
	String city;
	String zip;
	String country;
	String group;

	@Test
	public void userShouldBeAbleToCreateNewCustomer()throws InterruptedException {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginPage.insertPssword(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("Password").getAsString());
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		 Assert.assertEquals(dashboardPage.validateDashboardPageText(),jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("ValidationTextLogin").getAsString(),"Dashboard page not available!!");
		
		
		dashboardPage.clickOnCustomerButton();
		dashboardPage.clickOnAddCustomerButton();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		 Assert.assertEquals(addCustomerPage.validateAddCustomerPage(),jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("ValidationTextAddCustomer").getAsString(),"Add Customer page not found!!");
		
		  fullName=jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("FullName").getAsString();
		 email=jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Email").getAsString();
		 company=jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Company").getAsString();
		 phone=jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Phone").getAsString();
		 address=jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("Street").getAsString();
		 city=jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("City").getAsString();
		 zip=jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("Zip").getAsString();
		 country=jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("Country").getAsString();
		 group=jsonEleObj.getAsJsonObject().get("AddContact").getAsJsonObject().get("Group").getAsString();
		 
		 
		 
		
		addCustomerPage.insertFullName(fullName);
		
		addCustomerPage.insertEmail(email);
		addCustomerPage.selectCompany(company);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.selectgroup(group);
		addCustomerPage.clickOnSaveButton();
		dashboardPage.clickListCustomer();

	}

}
