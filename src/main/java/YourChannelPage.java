import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourChannelPage {
    public WebDriver driver;
    public Actions actions;

    public YourChannelPage (WebDriver driver){
        this.driver=driver;
    }

    private By buttonUpLoudVideo = By.xpath("//paper-button[@aria-label='Upload video']/..");
    private By buttonVideo = By.xpath("//input[@type='file']");
    private By radioButtonForKids = By.xpath("//paper-radio-button[@name='MADE_FOR_KIDS']");
    private By buttonDetailsNext = By.xpath("//ytcp-button[@id='next-button']");
    private By buttonVideoElementsNext = By.xpath("//ytcp-button[@id='next-button']");
    private By radioButtonPrivate = By.xpath("//paper-radio-button[@name='PRIVATE']");
    private By buttonVideoSave = By.xpath("//ytcp-button[@id='done-button']");
    private By buttonCloseLoadingVideo = By.xpath("//ytcp-button[@id='close-button']");
    private By fishingProcessing = By.xpath("//span[text()='Finished processing'][last()]");
    private By readyElements = By.xpath("//span[text()='Private'][1]"); //появление имени и окончание закгрузки
    private By formButtonDetails = By.xpath("//div[@id='row-container'][1]");
    private By buttonDetails = By.xpath("//ytcp-icon-button[@aria-label='Details']");
    private By addDescription = By.xpath("//a[@id='video-title']/../../div");







    public YourChannelPage clickButtonUpLoudVideo (){
        driver.findElement(buttonUpLoudVideo).click();
        return new YourChannelPage(driver);
    }

    public YourChannelPage uploadVideo (){
        driver.findElement(buttonVideo).sendKeys("C:\\Android future\\ScreenShot\\Postman.mp4");
        return new YourChannelPage(driver);
    }

    public YourChannelPage clickRadioButtonForKids (){
        driver.findElement(radioButtonForKids).click();
        return new YourChannelPage(driver);
    }

    public YourChannelPage clickButtonDetailsNext (){
        driver.findElement(buttonDetailsNext).click();
        return new YourChannelPage(driver);
    }

    public YourChannelPage clickButtonVideoElementsNext (){
        driver.findElement(buttonVideoElementsNext).click();
        return new YourChannelPage(driver);
    }

    public YourChannelPage clickRadioButtonPrivate (){
        driver.findElement(radioButtonPrivate).click();
        return new YourChannelPage(driver);
    }

    public YourChannelPage clickButtonVideoSave (){
        driver.findElement(buttonVideoSave).click();
        return new YourChannelPage(driver);
    }

    public YourChannelPage clickButtonCloseLoadingVideo (){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(buttonCloseLoadingVideo)).click();
        return new YourChannelPage(driver);
    }


    public String waitReadyElements (){
        return new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(readyElements)).getText();
    }

    public String addDescription (){
        return new WebDriverWait(driver,40).until(ExpectedConditions.visibilityOfElementLocated(addDescription)).getText();
    }

    public String fishingProcessingLoadingVideo (){
        new WebDriverWait(driver,500).until(ExpectedConditions.presenceOfElementLocated(fishingProcessing));
        return driver.findElement(fishingProcessing).getText();
    }
}
