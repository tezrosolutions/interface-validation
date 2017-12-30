package com.org.aliceapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TitleTest
{
   public static void main(String[] args)
   {
       WebDriver driver = new FirefoxDriver();
       driver.get("https://info.aliceapp.com");
       System.out.println(driver.getTitle());
       driver.close();
   }
}
