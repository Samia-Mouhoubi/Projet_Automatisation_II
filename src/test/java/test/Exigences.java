package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exigences {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void teardown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	@Test 
	public void exigence1() throws Exception {
		driver.findElement(By.cssSelector(".list-inline>*:nth-child(2)>a")).click();
		driver.findElement(By.cssSelector(".dropdown-menu-right>li:first-child>a")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Samia");
		driver.findElement(By.id("input-lastname")).sendKeys("Mouhoubi");
		driver.findElement(By.id("input-email")).sendKeys("samia.mouhoubi@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("4385281234");
		driver.findElement(By.id("input-password")).sendKeys("samiamouhoubi");
		driver.findElement(By.id("input-confirm")).sendKeys("samiamouhoubi");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector(".btn-primary")).click();
		// post condition : "supprimer compte" ne peut pas être realisée dans le site
	}
	
	@Test
	public void exigence2() throws Exception {
		driver.findElement(By.cssSelector(".list-inline>*:nth-child(2)>a")).click();
		driver.findElement(By.cssSelector(".dropdown-menu-right>li:first-child>a")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Samia");
		driver.findElement(By.id("input-lastname")).sendKeys("Mouhoubi");
		driver.findElement(By.id("input-email")).sendKeys("samia.mouhoubi@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("4385281234");
		driver.findElement(By.id("input-password")).sendKeys("samiamouhoubi");
		driver.findElement(By.id("input-confirm")).sendKeys("samiamouhoubi");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
		driver.findElement(By.cssSelector(".btn-primary")).click();
		// post condition : "supprimer compte" ne peut pas être realisée dans le site
	}
	
	@Test
	public void exigence3() throws Exception {
		driver.findElement(By.cssSelector(".list-inline>*:nth-child(2)>a")).click();
		driver.findElement(By.cssSelector(".dropdown-menu-right>li:first-child>a")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Samia");
		driver.findElement(By.id("input-lastname")).sendKeys("Mouhoubi");
		driver.findElement(By.id("input-email")).sendKeys("samia.mouhoubi@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("4385281234");
		driver.findElement(By.id("input-password")).sendKeys("samiamouhoubi");
		driver.findElement(By.id("input-confirm")).sendKeys("samiamouhoubi");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector(".btn-primary")).click();
		Thread.sleep(1000);
		String msgActuel = driver.findElement(By.className("alert-danger")).getText();
		String msgAttendu = "Warning: E-Mail Address is already registered!";
		assertEquals(msgActuel, msgAttendu);
	}
	
	@Test
	public void exigence4() throws Exception {
		driver.findElement(By.cssSelector(".list-inline>*:nth-child(2)>a")).click();
		driver.findElement(By.cssSelector(".dropdown-menu-right>li:nth-child(2)>a")).click();
		driver.findElement(By.id("input-email")).sendKeys("samia.mouhoubi@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("samiamouhoubi");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		String urlActuel = driver.getCurrentUrl();
		String urlAttendu = "https://tutorialsninja.com/demo/index.php?route=account/account";
		Thread.sleep(2000);
		assertEquals(urlActuel, urlAttendu);
	}
	
	@Test
	public void exigence5() throws Exception {
		driver.findElement(By.cssSelector(".list-inline>*:nth-child(2)>a")).click();
		driver.findElement(By.cssSelector(".dropdown-menu-right>li:nth-child(2)>a")).click();
		driver.findElement(By.xpath("//div[@class='form-group'][2]/a")).click();
		driver.findElement(By.id("input-email")).sendKeys("samia.mouhoubi@gmail.com");
		driver.findElement(By.className("btn-primary")).click();
		String msgActuel = driver.findElement(By.className("alert-success")).getText();
		String msgAttendu = "An email with a confirmation link has been sent your email address.";
		Thread.sleep(2000);
		assertEquals(msgActuel, msgAttendu);
	}
	
	@Test
	public void exigence6() throws Exception {
		driver.findElement(By.cssSelector("[name='search']")).sendKeys("samsung");
		driver.findElement(By.className("btn-default")).click();
		String nomProduitAttendu = "Samsung SyncMaster 941BW";
		String lienProduitActuel = "//a[contains(text(),'Samsung SyncMaster 941BW')]";
		String nomProduitActuel = driver.findElement(By.xpath(lienProduitActuel)).getText();
		Thread.sleep(2000);
		assertEquals(nomProduitActuel, nomProduitAttendu);

	}
	
	@Test
	public void exigence7() throws Exception {
		driver.findElement(By.cssSelector("[name='search']")).sendKeys("888");
		driver.findElement(By.className("btn-default")).click();
		String localisateurMsgActuel = "//input[@id='button-search']/following-sibling::p";
		String msgActuel = driver.findElement(By.xpath(localisateurMsgActuel)).getText();
		String msgAttendu = "There is no product that matches the search criteria.";
		Thread.sleep(2000);
		assertEquals(msgActuel, msgAttendu);
	}
	
//	@Test
//	public void exigence8() throws Exception {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
//		Thread.sleep(2000);
//		
//		
//		
//		driver.quit();
//	}

}    