package UI.stepdefinitions;

import UI.utilities.ConfigReader;
import UI.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TechproStepDefinition {
    @Given("techproeducation sayfasina gidilir")
    public void techproeducationSayfasinaGidilir() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("sayfa basligi yazdirilir")
    public void sayfaBasligiYazdirilir() {
        System.out.println("Title = " + Driver.getDriver().getTitle());
    }

    @Then("sayfa basliginda Bootcamp yazisi oldugu test edilir")
    public void sayfaBasligindaBootcampYazisiOlduguTestEdilir() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Bootcamp"));
    }

    @And("sayfa kapatilir")
    public void sayfaKapatilir() {
        Driver.closeDriver();
    }
}
