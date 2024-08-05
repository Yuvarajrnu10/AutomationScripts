package Flightbookings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPractice {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("WebDriver.chrome.driver","C:\\Chromedriver\\chromedriver-win64\\Chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		WebElement Countrydropdown = driver.findElement(By.id("autosuggest"));
		Countrydropdown.sendKeys("IND");
		Thread.sleep(2000);
		List<WebElement> Options = driver.findElements(By.cssSelector("li[class=\"ui-menu-item\"] a"));
		for ( WebElement Option: Options)
		{
			if(Option.getText().equalsIgnoreCase("India"))
			{
				Option.click();
				break;
			}
		}
		WebElement Fromaddress = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		Fromaddress.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"] //a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();
		Thread.sleep(2000);
		driver .findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		int i=1;
				for(i=1;i<5;i++)
				{
			  WebElement addadults =  driver.findElement(By.id("hrefIncAdt"));
			  addadults.click();
				}
		WebElement currencydropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(currencydropdown);
		dropdown.selectByIndex(2);
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		driver .get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Yuvarj");
		Thread.sleep(2000);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		
	}

}
