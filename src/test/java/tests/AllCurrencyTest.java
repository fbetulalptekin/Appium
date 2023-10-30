package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyTest {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();

    // all currency uygulamasinin yuklendigi dogulanir
    // uygulamanin acildigi dogrulanir
    // cevirmek istedigimiz para birimi zloty olarak secilir
    // cevrilecek olan para birimi Tl olarak secilir
    // cevrilen tutar screenShot olarak kaydedilir
    // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
    // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir
    @Test
    public void currencyTest() throws IOException {
    // not: bundle id app package değeriyle aynıdır
        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));

        // uygulamanin acildigi dogrulanir
        AndroidElement anasayfaApp = driver.findElementByXPath("//*[@text='CURRENCY CONVERTER']");
        String uygulamaDogrulamaActual = anasayfaApp.getText();
        String expected = "CURRENCY CONVERTER";
        Assert.assertEquals(uygulamaDogrulamaActual,expected,"uygulama basarili bir sekilde yuklenemedi");

        // cevirmek istedigimiz para birimi zloty olarak secilir
        AndroidElement ilkKategori = driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyA"));
        ilkKategori.click();
        //  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PLN\"))");
        // ust satirin methodlasmis hali:
        ReusableMethods.scrollWithUiScrollable("PLN");

        // cevrilen para birimi tl olarak secilir
        AndroidElement kategori2 = driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyB"));
        kategori2.click();
        ReusableMethods.scrollWithUiScrollable("TRY");

        // ilk satira cevrilecek tutar olarak 1500 girilir
        driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b1")).click();
        driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b5")).click();
        driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b0")).click();
        driver.findElement(By.id("com.smartwho.SmartAllCurrencyConverter:id/b0")).click();

        // cevrilen tutar screenShot olarak kaydedilir
        File ekranFotografi = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranFotografi,new File("paraSonucu.jpg"));

        ReusableMethods.getScreenshot("t108"); // bu da kullanılabilir
        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        AndroidElement cevirilenBirim=driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB");
        String sonucParaDegeriPLN =cevirilenBirim.getText();
        // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir
        ilkKategori.click();
        ReusableMethods.scrollWithUiScrollable("USD");





    }
}
