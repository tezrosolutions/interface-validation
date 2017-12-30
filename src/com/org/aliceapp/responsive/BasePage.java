package com.org.aliceapp.responsive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;

abstract class BasePage {

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OcularResult compare() {
        return Ocular.snapshot()
                        .from(this)
                      .sample()
                           .using(driver)
                      .compare();
    }

}