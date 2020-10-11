import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private StartPage startPage;

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver","C:\\Android future\\drivers\\chromedriver85.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com");

        startPage = new StartPage(driver);
    }

    @Test
    public void changeLanguage (){
        startPage.changEnglishLanguage();
        String buttonSingUp = startPage.checkButtonRegister();
        Assert.assertEquals("Page language don't change - English!","SIGN IN",buttonSingUp);
    }

    @Test
    public void autorisationGoogle (){
        //переключение на английский
        startPage.changEnglishLanguage();
        String buttonSingUp = startPage.checkButtonRegister();
        Assert.assertEquals("Page language - English!","SIGN IN",buttonSingUp);
        RegisterGooglePage registerGooglePage = startPage.clickButtonRegister();
        //проверка на предавторизацию пользователя
        if(registerGooglePage.checkRefreshAccount().equals("Choose an account")) {
            System.out.println("Вариант выбора аккаунта.");
            registerGooglePage.clickRefreshAccount();
        }else if(registerGooglePage.checkGetInAccount().equals("Sign in"))
            System.out.println("Варивант выбора неавторизованного пользователя.");
        //ввод данных в поля гугл формы
        registerGooglePage.typeEmail("Тут эмейл");
        registerGooglePage.clickSendEmail();
        registerGooglePage.typePassword("Тут пароль");
        registerGooglePage.clickSendPassword();
        //проверка на вход в систему
        startPage.clickButtonImageAccount();
        String nameAccount = startPage.emailAccount();
        Assert.assertEquals("Account name is not OK!","Тут эмейл",nameAccount);
    }

    @Test
        public void getInVideo2 (){
            //переключение на английский
            startPage.changEnglishLanguage();
            String buttonSingUp = startPage.checkButtonRegister();
            Assert.assertEquals("Page language - English!","SIGN IN",buttonSingUp);
            RegisterGooglePage registerGooglePage = startPage.clickButtonRegister();


            //проверка на предавторизацию пользователя
            if(registerGooglePage.checkRefreshAccount().equals("Choose an account")) {
                System.out.println("Вариант выбора аккаунта.");
                registerGooglePage.clickRefreshAccount();
            }else if(registerGooglePage.checkGetInAccount().equals("Sign in"))
                System.out.println("Варивант выбора неавтроизованного пользователя.");

            //ввод данных в поля гугл формы
            registerGooglePage.typeEmail("Тут эмейл");
            registerGooglePage.clickSendEmail();
            registerGooglePage.typePassword("Тут пароль");
            registerGooglePage.clickSendPassword();

            //проверка на вход в систему
            startPage.clickButtonImageAccount();
            String nameAccount = startPage.emailAccount();
            Assert.assertEquals("Account name don't OK!","Тут эмейл",nameAccount);

            //начало загрузки видео
            YourChannelPage yourChannelPage = startPage.clickButtonYourChanel();
            yourChannelPage.clickButtonUpLoudVideo();
            yourChannelPage.uploadVideo(); //загрузка файла
            yourChannelPage.clickRadioButtonForKids();
            yourChannelPage.clickButtonDetailsNext();
            yourChannelPage.clickButtonVideoElementsNext();
            yourChannelPage.clickRadioButtonPrivate();
            yourChannelPage.clickButtonVideoSave();
            yourChannelPage.fishingProcessingLoadingVideo();

            //Assert.assertEquals("Finished processing",finishVideoLoading);
            yourChannelPage.clickButtonCloseLoadingVideo();
            String readyElements = yourChannelPage.waitReadyElements();
            Assert.assertEquals("Add description video!","Private",readyElements);
    }

    @After
    public void testDown () {
        driver.quit();
    }
}
