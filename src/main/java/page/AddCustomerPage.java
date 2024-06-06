package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage extends BasePage {
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver= driver;
	}
	
	@FindBy(how=How.XPATH,using="//strong[text()='New Customer']") WebElement addCustomerHeaderElement;
	@FindBy(how=How.XPATH,using="//input[@name='name']") WebElement fullNameElement;
	@FindBy(how=How.XPATH,using="//select[@name='company_name']") WebElement companyDropdownElement;
	@FindBy(how=How.XPATH,using="//input[@class='form-control email ']") WebElement emailElement;		
	@FindBy(how=How.XPATH,using="//input[@id='phone']") WebElement phoneElement;
	@FindBy(how=How.XPATH,using="//input[@name='address']") WebElement addressElement;
	@FindBy(how=How.XPATH,using="//input[@name='city']") WebElement cityElement;
	@FindBy(how=How.XPATH,using="//input[@id='port']") WebElement zipElement;
	@FindBy(how=How.XPATH,using="//select[@name='country']") WebElement countryDropdownElement;
	@FindBy(how=How.XPATH,using="//select[@id='customer_group']") WebElement groupDropdownElement;
	@FindBy(how=How.XPATH,using="//button[@id='save_btn']") WebElement saveButtonElement;
	
	
	public String validateAddCustomerPage() {
		String actualNewCustomerHeaderText =  addCustomerHeaderElement.getText();
		return  actualNewCustomerHeaderText;
	}
		
	public void validateAddCustomerPage(String addCustomerHeaderText) { 
	
	//Assert.assertEquals(addCustomerHeaderElement.getText(),addCustomerHeaderText,"Dashboard page not found!!");

	}

	public void insertFullName(String fullName) {
		String insertedName= fullName + generateRandomNum(999);
		fullNameElement.sendKeys(insertedName);
}
	public void selectCompany(String visibleText) {
		selectFromDropdown(companyDropdownElement,visibleText);
		
	
	}
	public void insertEmail(String email) {
		emailElement.sendKeys(generateRandomNum(9999) + email);
	}
	public void insertPhone(String phone) {
		phoneElement.sendKeys(phone + generateRandomNum(9999));
	}
	public void insertAddress(String address) {
		addressElement.sendKeys(address);
	}
	public void insertCity(String city) {
		cityElement.sendKeys(city);
	}
	public void insertZip(String zip) {
		zipElement.sendKeys(zip);
	}

	public void selectCountry(String country) {
		selectFromDropdown(countryDropdownElement, country);
	}
	public void selectgroup(String group) {
		selectFromDropdown(groupDropdownElement,group);
	
	}
	public void clickOnSaveButton() {
		saveButtonElement.click();
	}
	}
