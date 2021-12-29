package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    //Locators
    private final By _txtCurrentPass = By.xpath("//input[@id=\"currentPassword\"]");
    private final By _txtNewPassword = By.xpath("//input[@id=\"newPassword\"]");
    private final By _txtConfNewPassword = By.xpath("//input[@id=\"confirmPassword\"]");
    private final By _btnChangePassword = By.xpath("//p[@class=\"form-actions\"]//input[@value=\"Change Password\"]");

    //Elements
    public WebElement getTxtCurrentPassword()
    {
        return Constant.WEBDRIVER.findElement(_txtCurrentPass);
    }

    public WebElement getTxtNewPassword()
    {
        return Constant.WEBDRIVER.findElement(_txtNewPassword);
    }

    public WebElement getTxtConfNewPassword()
    {
        return Constant.WEBDRIVER.findElement(_txtConfNewPassword);
    }

    public WebElement getBtnChangePassword(){ return Constant.WEBDRIVER.findElement(_btnChangePassword); };


    public HomePage changePassword(String currentPass, String newPass)
    {
        this.getTxtCurrentPassword().sendKeys(currentPass);
        this.getTxtNewPassword().sendKeys(newPass);
        this.getTxtConfNewPassword().sendKeys(newPass);
        this.getBtnChangePassword().click();
        return new HomePage();
    }
}
