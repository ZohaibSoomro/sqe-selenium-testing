package sqe;

// Import the required packages
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Create a class for testing
public class YouTubeTest {

	// Declare a WebDriver instance
	WebDriver driver;

	// Declare some boolean variables for validation
	boolean titleTest, searchTest, playTest;

	// Create a constructor for the class
	public YouTubeTest() {
		// Set the system property for Chrome driver
		System.setProperty("webdriver.chrome.driver", "C://Users/zohaib/Downloads/chromedriver-Win64/chromedriver.exe");

		// Create a Chrome driver instance
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// Navigate to the YouTube homepage
		driver.get("https://www.youtube.com/");

		// Call the test methods
		testTitle();
		testSearch();
		testPlay();

		// Print the results of the tests
		System.out.println("Title Test: " + titleTest);
		System.out.println("Search Test: " + searchTest);
		System.out.println("Play Test: " + playTest);

		// Close the browser window
//		driver.quit();
	}

	// Test the title of the homepage
	public void testTitle() {
		// Get the title of the page
		String title = driver.getTitle();

		// Check if the title contains "YouTube"
		titleTest = title.contains("YouTube");
	}

	// Test the search functionality
	public void testSearch() {
		// Find the search box element by name
		WebElement searchBox = driver.findElement(By.name("search_query"));

		// Enter "selenium tutorial" in the search box
		searchBox.sendKeys("selenium tutorial");

		// Find the search button element by id
		WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));

		// Click on the search button
		searchButton.click();

		// Wait for the results page to load
		driver.findElement(By.id("video-title"));

		// Get the current URL of the page
		String url = driver.getCurrentUrl();

		// Check if the URL contains "selenium+tutorial"
		searchTest = url.contains("selenium+tutorial");
	}

	// Test the play functionality of a video
	public void testPlay() {
		// Find the first video element by id
		WebElement video = driver.findElement(By.id("video-title"));

		// Click on the video
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", video);

		// Get the title of the video
		String videoTitle = video.getText();
		System.out.println(videoTitle);
		// Wait for the video page to load
		driver.findElement(By.className("ytp-play-button"));

		// Find the play button element by class name
		WebElement playButton = driver.findElement(By.className("ytp-play-button"));

		// Get the aria-label attribute of the play button
		String playLabel = playButton.getAttribute("aria-label");

		// Check if the play button label is "Pause"
		playTest = !playLabel.equals("Pause");

		// Print the title of the video
		System.out.println("Playing: " + videoTitle);
	}

	// Create a main method to run the class
	public static void main(String[] args) {
		new YouTubeTest();
	}
}
