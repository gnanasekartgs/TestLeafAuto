package POM.TestLeaf;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

class AppTest
{
	WebDriver d;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().driverVersion("83.0.4103.39").setup();
		//WebDriverManager.firefoxdriver().setup();
		//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		d = new ChromeDriver();
	}
	@Test
	public void launch()
	{
		d.get("https://www.google.com");
		System.out.println(d.getTitle());
	}
		@AfterMethod
		public void finish()
		{
		d.quit();
	}
}