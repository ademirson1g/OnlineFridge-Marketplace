package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingProductAsAdmin {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:3000/home");
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/div[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/a[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[5]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[5]/form/div[1]/input")).sendKeys("Cokoladaaa");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[5]/form/div[2]/input")).sendKeys("Dobra pravo");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[5]/form/div[3]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[1]/div[3]/form/input")).sendKeys("Cokoladaaa");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[1]/div[3]/form/button")).click();
		
	}

}
