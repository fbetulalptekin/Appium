package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.Driver;

public class KiwiTest {
    // uygulamanin yuklendigi dogrulanir
// uygulamanin basariyla acildigi dogrulanir
// misafir olarak devam et e tiklanir
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
// Trip type,one way olarak secilir
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
// gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
// search butonuna tiklanir
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    KiwiPage page = new KiwiPage();

    @Test
    public void kiwiTest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"),"uygulama yuklenemedi");

        // uygulamanin basariyla acildigi dogrulanir
        String yaziTextActual= page.asAGuest.getText();
        String yaziTextExpected="Continue as a guest";
        Assert.assertEquals(yaziTextActual,yaziTextExpected,"uygulama basarili bir sekilde baslatilamadi");

        // misafir olarak devam et e tiklanir
        page.asAGuest.click();

        // ardinda gelecek olan 3 adima da yesil butona basilarak devam edilir
        KiwiPage.ardisikButtonTiklama(0,3,538,2037,500);

        // Trip type,one way olarak secilir
        page.returnButton.click();
        page.oneWay.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        page.kalkisButonu.click();
        page.defaultUlkeSILME.click();

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        driver.getKeyboard().pressKey("izmir");
            page.izmir.click();
            page.choose.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        page.varisButonu.click();
        driver.getKeyboard().pressKey("istanbul");

        page.istanbul.click();
        page.choose.click();

        // gidis tarihi mayis ayinin 28'i olarak secilir ve set date e tiklanir
        page.departureAnyTimeClick();
        Thread.sleep(2000);
        page.swipeByCoordinates(546,1663,561,150,500);
        KiwiPage.ardisikButtonTiklama(0,1,120,751,500);
        page.setDate.click();

        // search butonuna tiklanir
        page.searchButonu.click();

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        page.best.click();
        page.cheapest.click();
        page.stops.click();
        page.nonstop.click();

        // gelen bilet fiyati kaydedilir ve kullanicinin telefonuna sms olarak gonderilir
        String fiyat = page.biletFiyati.getText();
        driver.sendSMS("5555555555",fiyat);

/*
        // ============================================================================ //
        page.continueButonu.click();
        page.editButonu.click();
        page.nameBox.click();
        if (driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey("Betul");
        }
        else {
            page.nameBox.sendKeys("Betul");
        }
        page.surnameBox.click();
        if (driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey("Alptekin");
        }
        else {
            page.surnameBox.sendKeys("Alptekin");
        }
        page.swipeByCoordinates(527,1250,590,49,500);
        page.fGender.click();
        page.nationality.click();
        if (driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey("turkey");
        }
        else {
            page.searchBox.sendKeys("turkey");
        }
        page.dateOfBirth.click();
        page.swipeByCoordinates(759,1600,747,994,500);
        page.yil.click();
        page.ayGun.click();
        page.ok.click();
        page.saveTraveler.click();
        KiwiPage.ardisikButtonTiklama(0,3,534,2037,500);
        page.ticketFareStandard.click();
        page.continueButonu.click();
        page.guaranteeProtection.click();
        page.continueButonu.click();
        page.select1.click();
        page.seatF5.click();
        page.confirmButton.click();
        KiwiPage.ardisikButtonTiklama(0,2,534,2037,500);

*/


    }

}