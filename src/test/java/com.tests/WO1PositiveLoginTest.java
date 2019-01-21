package com.tests;


/*1.
Open
browser
2.
Go to website
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3.
Verify title equals “Web Orders Login”
4.
Enter username “Tester”
5.
Enter password “test
6.
Click on Login button
7.
Verify title equals “Web Orders”
8.
Verify url equals
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/
”*/


import com.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WO1PositiveLoginTest extends TestBase {

    @Test
    public void verifyTitle() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/\n" +
                "login.aspx");

        String title = driver.getTitle();

        Assert.assertEquals(title, "Web Orders Login");
    }

    @Test
    public void verifyTitle2() {
       driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/\n" +
             "login.aspx");
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Assert.assertEquals(driver.getTitle(),"Web Orders");

    }

    /*8.
Verify url equals
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/*/

    @Test
    public void verifyUrl (){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/\n" +
                "login.aspx");
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/");

    }






}