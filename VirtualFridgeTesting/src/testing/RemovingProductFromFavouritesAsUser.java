package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemovingProductFromFavouritesAsUser {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:3000/home");
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("ademirson1233");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("ademirson");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/a[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[2]/div/div/div/button")).click();
		Thread.sleep(2000);
		
	}
}
