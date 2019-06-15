package test;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.ListContactsPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddContactTest {
	
	@Test
	@Parameters({"userName", "password", "name", "company", "email", "phone", "address", "city", "state", "zip", "country"})
	public void usersCanAddContact(String userName, String password, String name, String company, String email, String phone, String address, String city, String state, String zip, String country) throws InterruptedException {
		WebDriver driver = BrowserFactory.startBrowser("http://techfios.com/test/billing/?ng=login/");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);	
		loginPage.userLogsIn(userName, password);
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.waitForPage();
		
		//click on CRM and click on Add Contacts
		
		dashboardPage.navigateToAddContactPage();
		
		
		//validate Add Contact Page opened
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		
		addContactPage.waitForPage();
		
		
		//Adding Random Number
		Random random = new Random();
		String rnd = String.valueOf(random.nextInt(999));
		
		
		addContactPage.FillTheAddressForm(name+rnd, company+rnd, email+rnd, phone+rnd, address, city, state, zip, country);
		
		dashboardPage.navigatToListContactsPageFromAddContactPage();
		
		//validate List Contacts Page opened
		ListContactsPage listContactsPage = PageFactory.initElements(driver, ListContactsPage.class);
		
		listContactsPage.waitForPage();
		
		//Type the expected name in the search field
		listContactsPage.typeNameInTheSearchField(name+rnd);
		
		// Click on the search button
		listContactsPage.clickOnSearchButton();
		
		//System.out.println(listContactsPage.getDisplayedName());
		
		Assert.assertEquals(listContactsPage.getDisplayedName(), name+rnd, "Name was not found!");
	
		driver.close();
		driver.quit();
	}
}
