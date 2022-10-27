package ObjectRepository;

import Utilities.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PageObjects extends Base {

    WebDriver driver;

    public PageObjects(WebDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id='amount']")
    WebElement amount;

    @FindBy(xpath = "//input[@id='midmarketFromCurrency']")
    WebElement from;

    @FindBy(xpath = "//input[@id='midmarketToCurrency']")
    WebElement to;

    @FindBy(xpath = "//button[text()='Convert']")
    WebElement convert;

    @FindBy(xpath = "//p[@class='result__BigRate-sc-1bsijpp-1 iGrAod']")
    WebElement afterConvert;

    @FindBy(xpath = "//div[@class='unit-rates___StyledDiv-sc-1dk593y-0 dEqdnx']//p[1]")
    WebElement line1;


    public String getConvertedAmount() {
        String convertedamount = afterConvert.getText();
        return convertedamount;
    }

    public WebElement getAfterConvert() {
        return afterConvert;
    }

    public WebElement getAmount() {
        return amount;
    }

    public WebElement getFrom() {
        return from;
    }

    public WebElement getTo() {
        return to;
    }

    public WebElement getConvert() {
        return convert;
    }

    public String getLine1() {
        String line_1 = line1.getText();
        return line_1;
    }

}
