import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC005 {
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

    @Test
    public void TC05(){
        System.out.println("TC05 - User cannot log into Railway with invalid password \n");
        HomePage homePage = new HomePage();
        homePage.open();
        int i=0;
        while(i<5){
            LoginPage loginPage = homePage.gotoLoginpage();

            String actuaMsg = loginPage.login(Constant.USERNAME,"matkhausai").getErrorMessage();
            String expectedMsg = "Invalid username or password. Please try again.";
            Assert.assertEquals(actuaMsg,expectedMsg,"Error message is not displayed as expected");
            i++;
            if(i>=5){
                String errorMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
                Assert.assertEquals(actuaMsg,errorMsg,"Error message is not displayed as expected");
            }
        }

    }
}
