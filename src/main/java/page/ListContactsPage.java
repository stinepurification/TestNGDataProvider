package page;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListContactsPage extends BasePage {
	WebDriver driver;

	public ListContactsPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
	WebElement PageTitle;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/form/div/div[1]/div/input")
	WebElement SearchField;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/form/div/div[1]/div/div[2]/button")
	WebElement SearchButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[3]/div/div/div/table/tbody/tr/td[2]/a")
	WebElement DisplayedName;

	public void waitForPage() {
		waitForElement(PageTitle, driver);
	}

	public void typeNameInTheSearchField(String name) {
		SearchField.sendKeys(name);
	}

	public void clickOnSearchButton() {
		SearchButton.click();
	}

	public String getDisplayedName() {
		int columnIndex = getColunmIndexOfName("Name");

		return driver.findElement(By.xpath("//table[contains(@class, 'table')]/tbody/tr/td["+columnIndex+"]"))
				.getText();
	}

	private int getColunmIndexOfName(String whatEver) {
		try {
			List<WebElement> elements = driver.findElements(By.xpath("//table[contains(@class, 'table')]/thead/tr/th"));
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getText().equalsIgnoreCase(whatEver)) {
					return i + 1;
				}
			}
			}
			catch (Exception e) {
				fail("Column header was not found!");
			}
			return 0;
		}
}