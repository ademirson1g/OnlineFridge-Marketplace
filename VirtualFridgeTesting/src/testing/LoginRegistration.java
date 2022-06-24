package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginRegistration {
	// Registration and Login as User and Login as Admin
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:3000/home");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("ademirson1233");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("ademirson");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[3]/input")).sendKeys("ademirson");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[4]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("ademirson1233");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("ademirson");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div[1]/a")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div[1]/a")).click();
	}

}
