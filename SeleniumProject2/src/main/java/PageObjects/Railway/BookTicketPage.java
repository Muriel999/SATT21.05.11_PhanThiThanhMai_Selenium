package PageObjects.Railway;

import Common.Constant.Constant;

public class BookTicketPage extends GeneralPage{
    public BookTicketPage open()
    {
        Constant.WEBDRIVER.navigate().to(Constant.BOOKTICKET_URL);
        return this;
    }
}
