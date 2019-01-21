package com.tests;


import com.github.javafaker.Faker;
import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
.
1.Login to Web Orders application using“Tester”and“test”
2.Click edit button for any entry
3.Change the quantity to a different amount
4.ClickCalculate
5.Verifythat new quantity is displayed
6.ClickUpdate
7.Verify new quantity is displayed
8.Verify that other information in that row did not change
 */

public class WO4Edit extends TestBase{

    @Test
    public void editOrder() throws InterruptedException {
        login();
        driver.findElement(By.linkText("Order")).click();

        //Product
        WebElement select=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        Select s=new Select(select);
        Random random=new Random();
        int idx=random.nextInt(3);
        s.selectByIndex(idx);
        String product=s.getFirstSelectedOption().getText();

        //Quantity
        int qty=random.nextInt(8)+1;
        String quantity=String.valueOf(qty);
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity);
        driver.findElement(By.xpath("(//input[@class='btn_dark'])[1]")).click();

        //Name,address
        Faker f=new Faker();
        String name=f.name().firstName();
        String street=f.address().streetAddress().substring(0,8);
        String address=f.address().fullAddress().substring(0,8);
        String state=f.address().state();
        String zipCode=f.address().zipCode().substring(0,5);

        LocalDate localDate=LocalDate.now();
        String local=localDate.toString().substring(5,7)+"/"+localDate.toString().substring(8,10)+"/"+localDate.toString().substring(0,4);

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(street);
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(address);
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipCode);


        //CreditCard
        String cardNumber=f.number().digits(12);
        int month=random.nextInt(3)+10;
        int year= random.nextInt(5)+20;
        String date= String.valueOf(month)+"/"+String.valueOf(year);
        String paymentType= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_0")).getAttribute("value");

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_0")).click();
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNumber);
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(date);
        driver.findElement(By.linkText("Process")).click();
        driver.findElement(By.linkText("View all orders")).click();

        //edit button
        driver.findElement(By.xpath("(//input[@type='image'])[1]")).click();
        Thread.sleep(2000);

        //Change quantity

        int qty1=random.nextInt(8)+1;
        if (qty==qty1){
             qty1=random.nextInt(8)+1;
        }
        String quantity1=String.valueOf(qty1);
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity")).clear();
        //Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity1);
        //calculate
        driver.findElement(By.xpath("(//input[@class='btn_dark'])[1]")).click();
        //newquantity displayed
        boolean isNewQuantityDisplayed=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity")).isDisplayed();

        Assert.assertTrue(isNewQuantityDisplayed);


    }


    /*
    6.ClickUpdate
    7.Verify new quantity is displayed
    8.Verify that other information in that row did not change*/






        @Test
        public void updateOrder() throws InterruptedException {
            login();
            driver.findElement(By.linkText("Order")).click();

            //Product
            WebElement select = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
            Select s = new Select(select);
            Random random = new Random();
            int idx = random.nextInt(3);
            s.selectByIndex(idx);
            String product = s.getFirstSelectedOption().getText();

            //Quantity
            int qty = random.nextInt(8) + 1;
            String quantity = String.valueOf(qty);
            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity);
            driver.findElement(By.xpath("(//input[@class='btn_dark'])[1]")).click();

            //Name,address
            Faker f = new Faker();
            String name = f.name().firstName();
            String street = f.address().streetAddress().substring(0, 8);
            String address = f.address().fullAddress().substring(0, 8);
            String state = f.address().state();
            String zipCode = f.address().zipCode().substring(0, 5);

            LocalDate localDate = LocalDate.now();
            String local = localDate.toString().substring(5, 7) + "/" + localDate.toString().substring(8, 10) + "/" + localDate.toString().substring(0, 4);

            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);
            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(street);
            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(address);
            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);
            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipCode);


            //CreditCard
            String cardNumber = f.number().digits(12);
            int month = random.nextInt(3) + 10;
            int year = random.nextInt(5) + 20;
            String date = String.valueOf(month) + "/" + String.valueOf(year);
            String paymentType = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_0")).getAttribute("value");

            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_0")).click();
            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNumber);
            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(date);
            driver.findElement(By.linkText("Process")).click();
            driver.findElement(By.linkText("View all orders")).click();




            //edit button
            driver.findElement(By.xpath("(//input[@type='image'])[1]")).click();
            Thread.sleep(2000);

            //Change quantity

            int qty1 = random.nextInt(8) + 1;
            if (qty == qty1) {
                qty1 = random.nextInt(8) + 1;
            }
            String quantity1 = String.valueOf(qty1);
            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity")).clear();
            //Thread.sleep(2000);
            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(quantity1);

            //update button
            driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_UpdateButton")).click();
            //displayed
            boolean isdisplayed=driver.findElement(By.xpath("//table[@class='SampleTable']//tr[2]/td[4]")).isDisplayed();
            Assert.assertTrue(isdisplayed);

            //Verify that other information in row doesnot chnage.

            //Fakedata List
            List<String> fakedata=new ArrayList<String>();
            fakedata.add(name);
            fakedata.add(product);
            fakedata.add(quantity);
            fakedata.add(local);
            fakedata.add(street);
            fakedata.add(address);
            fakedata.add(state);
            fakedata.add(zipCode);
            fakedata.add(paymentType);
            fakedata.add((cardNumber));
            fakedata.add(date);
            System.out.println(fakedata);

            //OrderList
            List<String> orderList=new ArrayList<String>();
            List<WebElement> pNames=driver.findElements(By.xpath("//table[@class='SampleTable']//tr[2]/td"));
            for(WebElement d:pNames){
                orderList.add(d.getText());
            }
            //begining and ending cells are removed.
            orderList.remove(0);
            orderList.remove(11);
            System.out.println(orderList);

            for(int i=0;i<orderList.size();i++){
                if(i==2){
                    continue;
                }
                Assert.assertTrue(orderList.get(i).equals(fakedata.get(i)));

            }




        }



    public void login(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/\n" +
                "login.aspx");
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

    }

}
