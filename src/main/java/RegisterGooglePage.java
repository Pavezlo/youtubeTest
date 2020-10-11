import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterGooglePage {
    private WebDriver driver;

    public RegisterGooglePage (WebDriver driver){
        this.driver = driver;
    }

    //выбор смены аккаунта
    private By refreshAccount = By.xpath("//li[@class='JDAKTe eARute W7Aapd zpCp3 SmR8']//div[@class='lCoei YZVTmd SmR8']");
    private By title = By.xpath("//h1/span");
    //ввод эмейла
    private By inPutEmail =By.xpath("//input[@type='email']");
    private By getInPutEmail =By.xpath("//span[text()='Next']/.."); //кнопка для перехода на ввод пароля
    //ввод пароля
    private By inPutPassword = By.xpath("//input[@type='password']");
    private By getInPutPassword = By.xpath("//span[text()='Next']/..");//кнопки конечной авторизации

    //страница входа через гугл без выбора аккаунта
    private By title1 = By.xpath("//h1/span");


    //проверка страницы
    //на Выбор аккаунта
    public String checkRefreshAccount (){
        return driver.findElement(title).getText();
    }
    //на Вход

    public String checkGetInAccount (){
        return driver.findElement(title1).getText();
    }

    public RegisterGooglePage clickRefreshAccount (){
        driver.findElement(refreshAccount).click();
        return this;
    }

    //проверка аккаунта на ввод без авторизированных аккаунтов


    //ввод эмейла
    public RegisterGooglePage typeEmail (String email){
        driver.findElement(inPutEmail).sendKeys(email);
        return this;
    }

    public RegisterGooglePage clickSendEmail (){
        driver.findElement(getInPutEmail).click();
        return this;
    }

    //ввод пароля
    public RegisterGooglePage typePassword (String password){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(inPutPassword)).sendKeys(password);
        return this;
    }

    public StartPage clickSendPassword (){
        driver.findElement(getInPutPassword).click();
        return new StartPage(driver);
    }

}
