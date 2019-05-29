package shoppingWebsiteTests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingTests {
	public static WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Ignore
	@Test
	public void testForDress() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

		WebElement checkDress = driver.findElement(By.id("search_query_top"));
		checkDress.sendKeys("Dress");
		checkDress.submit();
		checkDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/h5/a"));
		assertTrue(checkDress.isDisplayed());

		Thread.sleep(10000);
	}

	@Test
	public void testCheckOut() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

		WebElement checkOut = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		WebDriverWait waitHover = new WebDriverWait(driver, 20);
		Actions action = new Actions(driver);

		checkOut.click();
		checkOut = driver.findElement(By.id("email"));
		checkOut.sendKeys("hello@me.com");
		checkOut = driver.findElement(By.id("passwd"));
		checkOut.sendKeys("password");
		checkOut = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
		checkOut.click();

		checkOut = driver.findElement(By.id("search_query_top"));
		checkOut.sendKeys("Dress");
		checkOut.submit();
		checkOut = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]"));
		checkOut.click();
		waitHover.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[2]/a[1]/span")));
		checkOut = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[2]/a[1]/span"));
		checkOut.click();
		waitHover.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]")));
		checkOut = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		checkOut.click();
		checkOut = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		checkOut.click();
		checkOut = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
		checkOut.click();
		checkOut = driver.findElement(By.xpath("//*[@id=\"cgv\"]"));
		checkOut.click();
		checkOut = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
		checkOut.click();
		checkOut = driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a"));
		checkOut.click();
		checkOut = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1"));
		assertTrue(checkOut.isDisplayed());
	}
}
