package com.org.aliceapp.test;

import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.org.aliceapp.responsive.ErrorPage404;
import com.org.aliceapp.responsive.GuestPage;
import com.testautomationguru.ocular.Ocular;

public class ResponsiveDesignTest {
	WebDriver driver;
	

	@Test
	public void test1440() throws InterruptedException {
		String dimension = "1440x900";
		
		 //Ocular config - Ocular should look for the baseline image depends on the dimension or device
        Path snapShotPath = Paths.get("./src/test/resources/", dimension);
        Ocular.config()
             	.snapshotPath(snapShotPath)
                .resultPath(Paths.get("./src/test/resources/results"));
    
        //Launch Browser with the dimension or use appium driver to test on mobile devices
        driver = new FirefoxDriver();
        driver.get("https://preview.hs-sites.com/_hcms/preview/template/multi?is_buffered_template_layout=true&portalId=1799160&tc_deviceCategory=desktop&template_layout_id=5457222999");
        //driver.get("http://google.com");
        
        int width = Integer.parseInt(dimension.split("x")[0]);
        int height = Integer.parseInt(dimension.split("x")[1]);
        
        driver.manage().window().setSize(new Dimension(width, height));
        
        ErrorPage404 guest = new ErrorPage404(driver);
        
        //verify Guest page
        Assert.assertTrue(guest.compare().isEqualsImages());
        
       
    }
	

    

    /*@AfterTest
    public void afterTest() {
        driver.quit();
    }*/

}




