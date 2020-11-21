package POM.TestLeaf;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ImageDisable 
{

	public static void main(String[] args)
	{
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");	
	ChromeOptions options = new ChromeOptions();
	disableImage(options);
	WebDriver d = new ChromeDriver();
	d.get("http://www.amazon.in");
	System.out.println(d.getTitle());
	}
	
	public static void disableImage(ChromeOptions options)
	{
		HashMap<String, Object> image = new HashMap<>();
		image.put("images", 2);
		
		HashMap<String, Object> pref = new HashMap<>();
		pref.put("profile.default_content_setting_values", image);
	options.setExperimentalOption("prefs", pref);
	}
}
