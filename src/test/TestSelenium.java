package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;


import static org.junit.Assert.*;

public class testselenium {
   public static void main(String[] args) {
	   System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
	   driver.get("http://localhost:8080/FinaleIspw/register");
	   driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
	   driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("valerio");
	   driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
	   driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("valeprova");

	   driver.findElement(By.xpath("/html/body/p[2]/input")).click();
	   driver.close();
	  
   }
}


