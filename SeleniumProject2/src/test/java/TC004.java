import Common.Constant.Constant;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC004 {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", "src/Executables/chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().setSize(new Dimension(1080, 720));
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
    @Test (description = "TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab\n")
    public void TC04(){

        LoginPage loginPage = new LoginPage();

        String actualTxt = loginPage.getNameLogin();
        System.out.println(actualTxt);
        String expectedTxt = "Login";
        Assert.assertEquals(actualTxt,expectedTxt,"Login page do not displays instead of Book ticket page");

    }
}
