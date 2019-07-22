package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.get("https://www.myntra.com/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		d.findElementByXPath("(//div[@class='desktop-navLink']/a)[1]").click();
		d.findElementByXPath("(//a[@class='navi-link  navi-underline'])[1]").click();
		
		Actions action = new Actions(d);
		action.moveToElement(By.xpath("(//picture[@class='img-responsive'])[1]")))
		
	}

}
