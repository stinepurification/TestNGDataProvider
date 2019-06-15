package page;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddContactPage extends BasePage {
	WebDriver driver;

	public AddContactPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(how = How.ID, using = "account")
	WebElement FullName;
	@FindBy(how = How.ID, using = "company")
	WebElement Company;
	@FindBy(how = How.ID, using = "email")
	WebElement Email;
	@FindBy(how = How.ID, using = "phone")
	WebElement Phone;
	@FindBy(how = How.ID, using = "address")
	WebElement Address;
	@FindBy(how = How.ID, using = "select2-country-container")
	WebElement Country;
	@FindBy(how = How.XPATH, using = "html/body/span/span/span[1]/input")
	WebElement CountryTextbox;
	@FindBy(how = How.ID, using = "city")
	WebElement City;
	@FindBy(how = How.ID, using = "state")
	WebElement State;
	@FindBy(how = How.ID, using = "zip")
	WebElement Zip;
	@FindBy(how = How.ID, using = "submit")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/descendant::h2[contains(text(),'Contacts')]")
	WebElement PageTitle;
	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Search by Name')]")
	WebElement SearchField;
	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	WebElement SearchButton;

//	public void waitForPage() {
//		waitForElement(PageTitle, driver);
//	}

	public void FillTheAddressForm(String name, String company, String email, String phone, String address, String city,
			String state, String zip, String country) throws InterruptedException {
		FullName.sendKeys(name);
		Company.sendKeys(company);
		Email.sendKeys(email);
		Phone.sendKeys(phone);
		Address.sendKeys(address);
		City.sendKeys(city);
		State.sendKeys(state);
		Zip.sendKeys(zip);
		Country.click();
		CountryTextbox.sendKeys(country);
		CountryTextbox.sendKeys(Keys.ENTER);
		Submit.click();
	}

	public void typeNameInSearchField(String name) {
		SearchField.sendKeys(name);
	}

	public void clickOnTheSearchButton() throws InterruptedException {
		Thread.sleep(1000);
		SearchButton.click();
	}

	public void waitForPage() {
		waitForElement(PageTitle, driver);
	}

//	public String getNameFromFirstRow() {
//		int columnIndex = getTableHeaderIndexFor("Name");
//		try {
//		return driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody/tr[1]/td[" + columnIndex + "]"))
//				.getText();
//		} catch (Exception e) {
//			fail("Column header was not found!");
//		}
//		return "";
//	}
//
//	private int getTableHeaderIndexFor(String name) {
//		try {
//		List<WebElement> elements = driver.findElements(By.xpath("//table[contains(@class, 'table')]/thead/tr/th"));
//		for (int i = 0; i < elements.size(); i++) {
//			if (elements.get(i).getText().equalsIgnoreCase(name)) {
//				return i + 1;
//			}
//		}}
//		catch (Exception e) {
//			fail("Column header was not found!");
//		}
//		return 0;
//	}
}
