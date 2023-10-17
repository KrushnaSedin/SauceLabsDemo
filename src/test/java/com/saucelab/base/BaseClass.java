package com.saucelab.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver;

    public BaseClass(WebDriver driver)
    {
        this.driver=driver;
    }
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public boolean filterForPrice(List<WebElement> fieldElement,WebElement dropdown, String filterValue)
    {
        boolean flag;
        //Store prices before filter
        List<WebElement> beforeFilterprices = fieldElement;
        List<Double> beforeFilter = new ArrayList<>();

        for (WebElement p1 : beforeFilterprices) {
            beforeFilter.add(Double.valueOf(p1.getText().replace("$", "")));
        }

        if(filterValue.equals("lohi"))
        {
            Collections.sort(beforeFilter);
        }else {
            Collections.sort(beforeFilter, Collections.reverseOrder());
        }
        //Select Low to Hi filter

        Select setFilter= new Select(dropdown);
        setFilter.selectByValue(filterValue);

        //Store prices after filter
        List<WebElement> afterFilterprices = (List<WebElement>) fieldElement;
        List<Double> afterFilter = new ArrayList<>();
        for (WebElement p2 : afterFilterprices) {
            afterFilter.add(Double.valueOf(p2.getText().replace("$", "")));
        }
        //Printing prices before and after
        System.out.println(beforeFilter);
        System.out.println(afterFilter);

        if (beforeFilter.equals(afterFilter)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    public boolean filterByName(List<WebElement> productName,WebElement dropdown, String filterValue)
    {
        boolean flag;
        //Store product names before filter
        List<WebElement> productListBefore = productName;
        List<String> namesBeforeFilter = new ArrayList<>();

        //Storing names
        for (WebElement p : productListBefore) {
            namesBeforeFilter.add(p.getText());
        }
        if(filterValue.equals("az"))
        {
            Collections.sort(namesBeforeFilter);
        }else {
            Collections.sort(namesBeforeFilter, Collections.reverseOrder());
        }
        //Collections.sort(namesBeforeFilter);
        //Apply filter A to Z
        Select setFilter= new Select(dropdown);
        setFilter.selectByValue(filterValue);
        //Store product names after filter
        List<WebElement> productListAfter = productName;
        List<String> namesAfterFilter = new ArrayList<>();
        for (WebElement p : productListAfter) {
            namesAfterFilter.add(p.getText());
        }
        System.out.println(namesBeforeFilter);
        System.out.println(namesAfterFilter);
        //Check condition
        if (namesBeforeFilter.equals(namesAfterFilter)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

}
