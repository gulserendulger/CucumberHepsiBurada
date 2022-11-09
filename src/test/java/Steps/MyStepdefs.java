package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import static Steps.Base.appiumDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStepdefs {

    @Given("^Uygulamaya giris yapilir$")
    public void uygulamayaGirisYapılır() throws InterruptedException {
        Thread.sleep(5000);
        MobileElement premiumkesfet = appiumDriver.findElementByAccessibilityId("Premium'u keşfet");
        premiumkesfet.click();
        Thread.sleep(5000);
    }

    @When("^Arama ekranindan bilgisayar aratilir$")
    public void aramaEkranindanBilgisayarAratilir() throws InterruptedException {
        MobileElement searchBox = appiumDriver.findElementById("com.pozitron.hepsiburada:id/etSearchBox");
        searchBox.click();
        Thread.sleep(5000);
        MobileElement searchBoxSend = appiumDriver.findElementById("com.pozitron.hepsiburada:id/etSearchBox");
        searchBoxSend.sendKeys("bilgisayar");
        Thread.sleep(5000);
        MobileElement searchSelectTitle =  appiumDriver.findElementByXPath("//*[@resource-id='com.pozitron.hepsiburada:id/search_suggestion_title'][1]");
        searchSelectTitle.click();
        Thread.sleep(3000);
    }

    @And("^Urunlerden bir tanesi secilir$")
    public void urunlerdenBirTanesiSeçilir() throws InterruptedException {
        Thread.sleep(20000);
        MobileElement selectProduct =  appiumDriver.findElementByXPath("//*[@resource-id='com.pozitron.hepsiburada:id/ll_product_list_item_info_container']");
        selectProduct.click();
    }

    @And("^Secilen urun sepete eklenir$")
    public void seçilenÜrünSepeteEklenir() throws InterruptedException {
        Thread.sleep(5000);
        MobileElement addToCart = appiumDriver.findElementById("com.pozitron.hepsiburada:id/product_detail_add_to_cart_text");
        addToCart.click();
    }

    @Then("^Sepette secilen urunun gozukmesi gerekmektedir$")
    public void sepetteSeçilenÜrününGözükmesiGerekmektedir() throws InterruptedException {
        Thread.sleep(5000);
        MobileElement goCart = appiumDriver.findElementById("com.pozitron.hepsiburada:id/goBasketTxt");
        goCart.click();
        Thread.sleep(10000);
        MobileElement continueStep = appiumDriver.findElementById("continue_step_btn");
        assertTrue(continueStep.isDisplayed());
        Thread.sleep(5000);
    }
}
