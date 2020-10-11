import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {
    private WebDriver driver;

    public StartPage (WebDriver driver) {
        this.driver=driver;
    }
    private By buttonSetting = By.xpath("//button[@aria-label='Настройки'][1]");
    private By buttonLanguage = By.xpath("//*[text()='Язык:']/../..");
    private By buttonEnglishLanguage = By.xpath("//p[text()='English (UK)']/..");
    private By buttonSingIn = By.xpath("//paper-button[@aria-label='Sign in']/..");
    private By buttonAccount = By.xpath("//img[@alt='Avatar image']/../..");
    private By emailAccount = By.xpath("//yt-formatted-string[@id='email']");
    private By buttonYourChanel = By.xpath("//yt-formatted-string[text()='Your channel']/../..");


    public StartPage clickButtonSetting(){
        driver.findElement(buttonSetting).click();
        return new StartPage(driver);
    }

    public StartPage clickButtonLanguage(){
        driver.findElement(buttonLanguage).click();
        return new StartPage(driver);
    }

    public StartPage clickButtonEnglishLanguage(){
        driver.findElement(buttonEnglishLanguage).click();
        return new StartPage(driver);
    }

    public StartPage changEnglishLanguage(){
        clickButtonSetting();
        clickButtonLanguage();
        clickButtonEnglishLanguage();
        return new StartPage(driver);
    }

    public String checkButtonRegister(){
        return driver.findElement(buttonSingIn).getText();
    }

    public RegisterGooglePage clickButtonRegister(){
        driver.findElement(buttonSingIn).click();
        return new RegisterGooglePage(driver);
    }

    public StartPage clickButtonImageAccount(){
        driver.findElement(buttonAccount).click();
        return new StartPage(driver);
    }

    public String emailAccount (){
        return driver.findElement(emailAccount).getText();
    }

    public YourChannelPage clickButtonYourChanel(){
        driver.findElement(buttonYourChanel).click();
        return new YourChannelPage(driver);
    }
}
