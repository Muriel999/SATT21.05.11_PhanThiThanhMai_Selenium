import Common.Constant.Constant;
//import org.apache.http.util.Asserts;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002 {
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

    @Test (description = "TC02 - User can't login with blank \"Username\" textbox\n" )
    public void TC02(){
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginpage();
        loginPage.login("", Constant.PASSWORD);

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
    }
}

