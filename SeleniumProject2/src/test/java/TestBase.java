import Common.Constant.Constant;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", "src/Executables/chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().setSize(new Dimension(2000, 1080));
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
