package pages;


import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Products {

    public Products() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "View all products")
    public WebElement viewAllProducts;

    @FindBy(xpath = "//table[@class='ProductsTable']//tr/td[1]")
    public List<WebElement> productNames;

    @FindBy(linkText = "View all orders")
    public WebElement viewAllOrders;

    @FindBy(xpath = "//table[@class='SampleTable']//tr/td[3]")
    public List<WebElement> pNames;


    public void login(){

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        Driver.getDriver().findElement(By.cssSelector("input[name='ctl00$MainContent$username']")).sendKeys("Tester");
        Driver.getDriver().findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();
    }

    public WebElement product(String productName) {
        String xpath = "//h5//a[@title='"+productName+"'])[1]";
        return Driver.getDriver().findElement(By.xpath(xpath));

    }

}