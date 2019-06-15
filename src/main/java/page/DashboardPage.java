package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage {
	WebDriver driver;

	public DashboardPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")
	WebElement PageTitle;
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'CRM')]")
	WebElement CRM;
	@FindBy(how = How.XPATH, using = ".//*[contains(text(),'Add Contact')]")
	WebElement AddContact;
	@FindBy(how = How.XPATH, using = "//div[@id='wrapper']/descendant::a[contains(text(),'List Contacts')]")
	WebElement ListContacts;
	@FindBy(how = How.NAME, using = "name")
	WebElement SearchCustomer;

	public void waitForPage() {
		waitForElement(PageTitle, driver);
	}

	public void navigateToAddContactPage() throws InterruptedException {
			CRM.click();
			waitForElement(AddContact, driver);
			AddContact.click();
	}

	public void navigatToListContactsPageFromAddContactPage() {
		ListContacts.click();
	}

//	public void navigateToAddContactPage() {
//		CRM.click();
//		AddContact.click();
//	}
//
//	public void VerifyPageLogin() {
//		CRM.isDisplayed();
//		SearchCustomer.isDisplayed();
//	}
//
//	public void navigateToListContactsPage() {
//		//CRM.click();
//		waitForElement(ListContacts, driver);
//		ListContacts.click();
//	}
}