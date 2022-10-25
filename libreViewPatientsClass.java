package libreViewPatients;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class libreViewPatientsClass {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shaivali\\eclipse-workspace\\libreViewPatients\\chromedriver.exe");
		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();

		// Launch Website
		driver.get("https://pat.libreview.io/");

		driver.findElement(By.xpath("//button[@id=\"countryDropdownBtn\"]")).click();

		List<WebElement> States = driver.findElements(By.xpath("//ul[@id=\"countryDropdown\"]//li"));
		System.out.println(States.size());

		for (int i = 0; i <= States.size() - 1; i++) {

			if (States.get(i).getText().contains("United States (US)")) {

				States.get(i).click();
				break;

			}
		}

		driver.findElement(By.xpath("//button[@id=\"languageDropdownBtn\"]")).click();
		Thread.sleep(1000);
		List<WebElement> Language = driver.findElements(By.xpath("//ul[@id=\"languageDropdown\"]//li"));
		System.out.println(Language.size());

		for (int i = 0; i <= Language.size() - 1; i++) {

			if (Language.get(i).getText().contains("English")) {

				Language.get(i).click();
				break;

			}
		}

		driver.findElement(By.xpath("//button[@id=\"modalSubmit\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id=\"truste-consent-button\" and contains (text(), 'AGREE & PROCEED')]"))
				.click();

		String actualTitle = driver.getTitle();

		String expectedTitle = "Patient Overview";
		Assert.assertEquals("Condition true", actualTitle, expectedTitle);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
		js.executeScript("window.scrollBy(550,850)", "");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id=\"proHeaderLink\"]")).click();
		Thread.sleep(3000);
		Set<String> handle = driver.getWindowHandles();
		for (String handles : handle) {
			try {
				String text = driver.switchTo().window(handles).getPageSource();
				if (text.contains("Professionals")) {
					System.out.println("Text found");

					break;
				}
			} catch (Exception e) {
			}
		}
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//div[@id=\"languageSelectWrapperHomeHeader\"]//span[@id=\"languageText\"]"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id=\"countryDropdownBtn\"]")).click();

		List<WebElement> States1 = driver.findElements(By.xpath("//ul[@id=\"countryDropdown\"]//li"));
		System.out.println(States1.size());

		for (int i = 0; i <= States1.size() - 1; i++) {

			if (States1.get(i).getText().contains("France (FR)")) {

				States1.get(i).click();
				break;

			}
		}

		driver.findElement(By.xpath("//button[@id=\"languageDropdownBtn\"]")).click();
		Thread.sleep(1000);
		List<WebElement> Language1 = driver.findElements(By.xpath("//ul[@id=\"languageDropdown\"]//li"));
		System.out.println(Language1.size());

		for (int i = 0; i <= Language1.size() - 1; i++) {

			if (Language1.get(i).getText().contains("French")) {

				Language1.get(i).click();
				break;

			}
		}

		driver.findElement(By.xpath("//button[@id=\"modalSubmit\"]")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
