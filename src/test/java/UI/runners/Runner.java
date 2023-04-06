package UI.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)    //test çalıştırıcı notasyonu
@CucumberOptions(   // Seneryoların nerede ve nasıl çalışacağı,hangi raporu kullanılmasıyla

        plugin = {              // Raporlama icin
                "pretty",       // raporlarin console da okunakli sekilde cikmasi icin
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json", // json = javascript object notation
                "junit:target/xml-report/cucumber.xml"
        },
        monochrome = true,      // raporlarin daha okunakli olmasi icin

        features = "./src/test/resources/features",  // features folder path
        glue = "stepdefinitions",       // stepdefinitions path
        // tags = "@iphone and @tesla"      // tags = "@iphone or @tesla"
        //tags = "", //Çalıştırmak istediğimiz seneryoya verdiğimiz tag'i belirtiriz
        dryRun = false // Seneryonun adımlarını kontrol eder ve çalıştığını görürüz
)
public class Runner {
    // taglerin sirasinin onemi yok, feature file daki yukaridan asagiya dogru okur
}

// Bu sinif TestCase run etmek icin kullanilir
// ve configure icin kullanilir
//Runner class, features file lar ile step defitions i birbirile baglar

/*
*****Cucumber Kurulumu*****
-Cucumber page object model icin olusturduugmunuz klasorler :
    pages -> page objectler
    runners -> test caseleri run etmek, raporlar eklemek, feature file ile step definitionslari birlestirmek icin
    stepdefinitions -> java kodlari
    utilities -> reusable metotlar, driver, configreader,..
-Cucumber feature klasoru
    Tum feature file lar bu klasore gider
    Tum test caseler gherken dilinde bu klasorde yazilir
-----------19 Subat 2023---------------------------
1. Feature file olustur: ilkfeaturefile.feature
Feature: ilk feature file
  Scenario: TC01_google_iphone_arama
    Given kullanici google gider
    When kullanici iphone için arama yapar
    Then sonuclarda iphone oldugunu dogrular
2. Runner classini run et
3. Console dan missing step definitions lari kopyala
4. stepdefinitions klasorunde GoggleStepDefinitions class i olustur ve oraya yapistir
    @Given("kullanici google gider")
    public void kullanici_google_gider() {
    }
    @When("kullanici iphone için arama yapar")
    public void kullanici_iphone_için_arama_yapar() {
    }
    @Then("sonuclarda iphone oldugunu dogrular")
    public void sonuclarda_iphone_oldugunu_dogrular() {
    }
5. Step definitionslara gerekli java kodlarini yaz
    @Given("kullanici google gider")
    public void kullanici_google_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
    }
    NOTE: ELementleri bulmak icin page paketini kullan
    public GooglePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='QS5gu sy4vM'])[2]")
    public WebElement popUpAccept;
    @FindBy(name = "q")
    public WebElement searchBox;
    *
    *
    * ---------Scenario Outline-----------------
#Scenario -> Scenario Outline
#"" -> "<sutun_ismi>"
#Example kelimesi Scenario Outline dan sonra kullanilmali
#Example verilerin kullanildagi yerdir
----------
Scenario Outline Data Driven Testing icin kullanilir
Yani benzer scenarioyu tekrar tekrar farkli datalarda calistirmak icin kullanilir
Scenario Outline cucumber cok Onemlidir.
Ne zaman birden fazla data ile islem yaparsak, zaman scenario outline kullanabiliriz.
Scenario Outline Excel ile atomasyon yapmaya benzer, tek fark, kullanimi daha kolaydir
 */