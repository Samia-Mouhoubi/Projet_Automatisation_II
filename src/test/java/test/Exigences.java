package test;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
        // Charger le compteur depuis le fichier compteur.txt
        int compteur = chargerCompteur();
        // Ajouter le compteur aux données
        String firstName = "test" + compteur;
        String lastName = "test" + compteur;
        String email = "test" + compteur + "@test" + compteur + ".com";
        String telephone = "1234567890";
        String password = "test" + compteur;
        // Incrémenter le compteur pour la prochaine exécution
        compteur++;
        // Enregistrer le nouveau compteur dans le fichier compteur.txt
        enregistrerCompteur(compteur);
        // Votre code restant...
        driver.findElement(By.cssSelector(".list-inline>*:nth-child(2)>a")).click();
        Thread.sleep(1000);
		driver.findElement(By.cssSelector(".dropdown-menu-right>li:first-child>a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
		Thread.sleep(1000);
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
		Thread.sleep(1000);
		driver.findElement(By.id("input-email")).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		Thread.sleep(1000);
		driver.findElement(By.id("input-password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.name("agree")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".btn-primary")).click();
		Thread.sleep(1000);
		String msgConfirmationActuel = driver.findElement(By.cssSelector("#content>h1")).getText();
		String msgConfirmationAttendu = "Your Account Has Been Created!";
		assertEquals(msgConfirmationActuel, msgConfirmationAttendu);	
		// post condition : "supprimer compte" ne peut pas être realisé dans le site
		// aucun moyen de supprimer un compte créé
    }
	
	@Test 
	public void exigence2() throws Exception {
        // Charger le compteur depuis le fichier compteur.txt
        int compteur = chargerCompteur();
        // Ajouter le compteur aux données
        String firstName = "test" + compteur;
        String lastName = "test" + compteur;
        String email = "test" + compteur + "@test" + compteur + ".com";
        String telephone = "1234567890";
        String password = "test" + compteur;
        // Incrémenter le compteur pour la prochaine exécution
        compteur++;
        // Enregistrer le nouveau compteur dans le fichier compteur.txt
        enregistrerCompteur(compteur);
        // Votre code restant...
        driver.findElement(By.cssSelector(".list-inline>*:nth-child(2)>a")).click();
        Thread.sleep(1000);
		driver.findElement(By.cssSelector(".dropdown-menu-right>li:first-child>a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
		Thread.sleep(1000);
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
		Thread.sleep(1000);
		driver.findElement(By.id("input-email")).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		Thread.sleep(1000);
		driver.findElement(By.id("input-password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.name("agree")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".btn-primary")).click();
		Thread.sleep(1000);
		String msgConfirmationActuel = driver.findElement(By.cssSelector("#content>h1")).getText();
		String msgConfirmationAttendu = "Your Account Has Been Created!";
		assertEquals(msgConfirmationActuel, msgConfirmationAttendu);	
		// post condition : "supprimer compte" ne peut pas être realisé dans le site
		// aucun moyen de supprimer un compte créé
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
	
	@Test
	public void exigence8() throws Exception {
		driver.findElement(By.cssSelector(".list-inline>*:nth-child(2)>a")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".dropdown-menu-right>li:nth-child(2)>a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("input-email")).sendKeys("samia.mouhoubi@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("input-password")).sendKeys("samiamouhoubi");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#logo>h1>a")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[onclick=\"cart.add('43');\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[title='Checkout']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("button-payment-address")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("button-payment-method")).click();
		// Impossible de continuer a l'étape suivante, 
		// impossible d'ajouter une methode de paiement
	}
	
	
	// methode pour charger le compteur de creation de compte (exigences 1 et 2)
    private int chargerCompteur() throws IOException {
        File file = new File("compteur.txt");
        if (!file.exists()) {
            // Si le fichier n'existe pas, commencer à partir de 2
            return 2;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            return Integer.parseInt(line);
        }
    }

    //methode pour enregistrer le compteur de creation de compte (exigences 1 et 2)
    private void enregistrerCompteur(int compteur) throws IOException {
        File file = new File("compteur.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(String.valueOf(compteur));
        }
    }
	
}    
