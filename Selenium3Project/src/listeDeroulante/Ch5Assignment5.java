package listeDeroulante;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ch5Assignment5 {

	public static void main(String[] args) throws InterruptedException {

//Using the chrome Driver
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
//Defining driver
		WebDriver driver;

		driver = new ChromeDriver();
//Launching the dropdown Page
		driver.get("https://techcanvass.com/examples/dropdown.html");

//Maximize the newly loaded window
		driver.manage().window().maximize();

//Creating instance of Drop down list box
		Select drpdwn = new Select(driver.findElement(By.name("model")));

//List Element to capture all the elements from the dropdown list
		List<WebElement> allOptions = drpdwn.getOptions();

		Iterator<WebElement> it = allOptions.iterator();

		System.out.println(allOptions.size());

		while (it.hasNext()) {

			WebElement el = (WebElement) it.next();
//Check for the required element by Text and click it
			if (el.getText().equals("Samsung Note 3")) {
				System.out.println(el.getAttribute("value"));
				el.click();
				System.out.println("Test Passed");
			} else {
				System.out.println(el.getAttribute("value"));
				System.out.println("Test Failed");
			}
		}

		drpdwn.selectByIndex(3);
		Thread.sleep(5000);

//close Chrome
		driver.close();
		driver.quit();
	}
}