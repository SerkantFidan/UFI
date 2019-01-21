package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Products;

import java.util.ArrayList;
import java.util.List;

/*
.
1.Login to Web Orders application using “Tester”and “test”
2.Click on View all products link
3.Remember all the product names from the table
4.Click on View all orders link
5.Verify that all the values in the Products column match  the names from step 4.
 */
public class WO1Products extends TestBase{

     Products products =new Products();

    @Test
    public void verifyProduct() throws InterruptedException {
        products.login();
        products.viewAllProducts.click();

        List<String> productList=new ArrayList<String>();
        for(WebElement s:products.productNames){
            productList.add(s.getText());
        }
        products.viewAllOrders.click();
        Thread.sleep(2000);

        List<String> pList=new ArrayList<String>();
        for(WebElement a:products.pNames){
            pList.add(a.getText());
        }
        System.out.println(productList);
        System.out.println(pList);

        for(String s:pList){
           Assert.assertTrue(productList.contains(s));
        }


    }

}
