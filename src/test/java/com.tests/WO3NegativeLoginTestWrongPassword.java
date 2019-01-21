package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



/*1.
Open browser
2.
G
o to website
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/l
ogin.aspx
3.
Verify title equals “Web Orders Login”
4.
Save the current
url
5.
Enter username “Tester”
6.
Enter password “Tester”
7.
Click on Login button
8.
Verify title still equals “Web Orders Login”*/


public class WO3NegativeLoginTestWrongPassword  extends TestBase {

    /*1.
Open browser
2.
G
o to website
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/l
ogin.aspx
3.
Verify title equals “Web Orders Login”
4.
Save the current
url
5.
Enter username “Tester”
6.
Enter password “Tester”
7.
Click on Login button
8.
Verify title still equals “Web Orders Login”
9.
Verify the current url equals the string saved in step 4
*/


    String urla;
    @Test
    public void verifyTitle() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/l\n" +
                "ogin.aspx");
        String title = driver.getTitle();
        String url=driver.getCurrentUrl();

        urla=driver.getCurrentUrl();
        System.out.println(urla);
        Assert.assertEquals(title, "Web Orders Login");

    }
    /*
   5.
Enter username “Tester”
6.
Enter password “Tester”
7.
Click on Login button
8.
Verify title still equals “Web Orders Login”


*/

    @Test
    public void verifyTitle2() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/l\n" +
                "ogin.aspx");
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");

    }
/*9.
Verify
the current
url equals the string saved in step 4
*/

    @Test
    public void verifyUrl() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/l\n" +
                "ogin.aspx");
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$username']")).sendKeys("Test");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        System.out.println(urla);
        Assert.assertEquals(driver.getCurrentUrl(),urla);

    }
}
