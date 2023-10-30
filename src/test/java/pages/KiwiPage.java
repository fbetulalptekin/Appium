package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.asm.IProgramElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.Driver;

import javax.accessibility.Accessible;
import java.time.Duration;

public class KiwiPage {
    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement asAGuest;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnButton;

    @FindBy(xpath ="//*[@text='One way']" )
    public WebElement oneWay;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement kalkisButonu;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Clear All\"]")
    public WebElement defaultUlkeSILME;

    @FindBy(xpath = "//*[@text='İzmir, Turkey']")
    public WebElement izmir;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement choose;

    @FindBy(xpath = "(//*[@text='Anywhere'])[2]")
    public WebElement varisButonu;

    @FindBy(xpath = "//*[@text='Istanbul, Turkey']")
    public WebElement istanbul;

    @FindBy(xpath = "(//*[@text='Anytime'])[2]")
    private WebElement departureAnyTime;

    public void departureAnyTimeClick(){
        departureAnyTime.click();
    }

    @FindBy(xpath = "(//*[@text='Anytime'])[4]")
    public WebElement returnAnyTime;

    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement setDate;

    @FindBy(xpath = "(//*[@text='Search'])[1]")
    public WebElement searchButonu;

    @FindBy(xpath = "//*[@text='Best']")
    public WebElement best;

    @FindBy(xpath = "//*[@text='Cheapest']")
    public WebElement cheapest;

    @FindBy(xpath = "//*[@text='Stops']")
    public WebElement stops;

    @FindBy(xpath = "//*[@text='Nonstop']")
    public WebElement nonstop;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[22]")
    public WebElement biletFiyati;

    @FindBy(xpath = "//*[@text='Continue']")
    public WebElement continueButonu;

    @FindBy(xpath = "//*[@text='//*[@text='Edit']']")
    public WebElement editButonu;

    @FindBy(xpath = "//android.view.View[1]/android.widget.EditText")
    public WebElement nameBox;

    @FindBy(xpath = "//*[ @text='e.g. Jordan']")
    public WebElement surnameBox;

    @FindBy(xpath = "//*[@text='Female']")
    public WebElement fGender;

    @FindBy(xpath = "//android.view.View[3]/android.view.View/android.widget.TextView") // bunlari class'ın üzerinden xpath ile alabiliriz
    public WebElement nationality;

    @FindBy(xpath = "//android.view.View/android.view.View/android.view.View[2]")
    public WebElement searchBox;

    @FindBy(xpath = "//android.view.View[5]/android.view.View")
    public WebElement dateOfBirth;

    @FindBy(xpath = "//*[@text='OK']")
    public WebElement ok;

    @FindBy(xpath = "//*[@text='1994']")
    public WebElement yil;

    @FindBy(xpath = "//android.view.View[@content-desc=\"22 January 1994\"]")
    public WebElement ayGun;

    @FindBy(xpath = "//*[@text='Save traveler']")
    public WebElement saveTraveler;

    @FindBy(xpath = "//*[@text='Standard']")
    public WebElement ticketFareStandard;

    @FindBy(xpath = "//*[@text='I want disruption protection']")
    public WebElement guaranteeProtection;

    @FindBy(xpath = "(//android.view.View/android.view.View[3]/android.widget.Button)[1]")
    public WebElement select1;

    @FindBy(xpath = "(//*[@text='F'])[5]")
    public WebElement seatF5;

    @FindBy(xpath = "(//android.view.View/android.view.View/android.widget.Button)[2]")
    public WebElement confirmButton;


    public static void ardisikButtonTiklama(int baslangic, int bitis, int xkoordinat, int ykoordinat, int wait){

        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        for (int i=baslangic; i<bitis; i++){
            action.press(PointOption.point(xkoordinat,ykoordinat))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                    .release()
                    .perform();
        }
    }

    public void swipeByCoordinates(int x1,int y1,int x2,int y2,int wait) {
        AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(x1,y1))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(x2,y2)).release().perform();
    }
}

