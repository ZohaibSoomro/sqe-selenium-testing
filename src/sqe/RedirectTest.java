package sqe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedirectTest {

	public static void main(String[] args) {
		// Set the system property to point to the Chrome WebDriver executable
		System.setProperty("webdriver.chrome.driver", "C://Users/zohaib/Downloads/chromedriver-Win64/chromedriver.exe");

		// Create a WebDriver object that represents the Chrome browser
		WebDriver driver = new ChromeDriver();

		// Navigate to the YouTube website
		driver.get("https://www.youtube.com/");

		// Get the current URL of the page
		String currentUrl = driver.getCurrentUrl();

		// Print the current URL to the console
		System.out.println("Current URL: " + currentUrl);

		// Click on the subscriptions link on the left sidebar of the page

		buildClickEventForButton(driver, "Subscriptions");
		sleep(1);
		// Print the new URL to the console
		System.out.println("New URL: " + driver.getCurrentUrl());

		// Click on the library link on the left sidebar of the page
		buildClickEventForButton(driver, "Library");
		sleep(1);
		// Print the new URL to the console

		System.out.println("New URL: " + driver.getCurrentUrl());

		// Click on the shorts link on the left sidebar of the page
		buildClickEventForButton(driver, "Shorts");
		sleep(1);
		// Print the new URL to the console
		System.out.println("New URL: " + driver.getCurrentUrl());

		// Close the browser
		driver.quit();
	}

	/**
	 * @param driver
	 */
	public static void buildClickEventForButton(WebDriver driver, String title) {
		String fTitle = "[title='" + title + "']";
		System.out.println(fTitle);
		WebElement element = driver.findElement(By.cssSelector(fTitle));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	private static void sleep(int seconds) {
		try {
			// Sleep for 1000 milliseconds, which is 1 second
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// Handle the exception if the thread is interrupted
			e.printStackTrace();
		}

	}
}
