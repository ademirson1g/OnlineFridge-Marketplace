package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAddingProduct {
	
	// Login and Adding product to favourites
	
	@SuppressWarnings("deprecation")
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://guarded-bastion-83744.herokuapp.com/home");
			driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div[1]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("noviuser");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("opetnoviuser");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[3]/div[1]/div/div/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/a[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div[1]/a")).click();
			
		}

}
