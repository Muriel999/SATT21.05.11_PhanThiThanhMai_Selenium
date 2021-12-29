package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //Locators
    private final By _txtEmail = By.xpath("//input[@id=\"email\"]");
    private final By _txtPassRegister = By.xpath("//input[@id=\"password\"]");
    private final By _txtConfirmPassword = By.xpath("//input[@id=\"confirmPassword\"]");
    private final By _txtPidNumber = By.xpath("//input[@id=\"pid\"]");
    private final By _btnRegister = By.xpath("//p[@class=\"form-actions\"]//input[@value=\"Register\"]");
    private final By WelcomeMessage = By.xpath("//div[@class='account']/strong");

    //Elements
    public WebElement getTxtEmail()
    {
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }

    public WebElement getTxtPassRegister()
    {
        return Constant.WEBDRIVER.findElement(_txtPassRegister);
    }

    public WebElement getBtnRegister()
    {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    public WebElement getTxtConfirmPassword(){ return Constant.WEBDRIVER.findElement(_txtConfirmPassword); };

    public WebElement getTxtPidNumber(){ return Constant.WEBDRIVER.findElement(_txtPidNumber); }

    public void register(String email, String passRegister, String ConfPass, String pidNumber)
    {
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassRegister().sendKeys(passRegister);
        this.getTxtConfirmPassword().sendKeys(ConfPass);
        this.getTxtPidNumber().sendKeys(pidNumber);
        this.getBtnRegister().click();
    }
}
