package com.selenium.kotlin.test

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import java.util.concurrent.TimeUnit

/**
 * Project Name    : kotlin-selenium-testng-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 4/11/2020
 * Time            : 9:49 AM
 * Description     : This is the base class for tests
 **/

abstract class TestBase {

    lateinit var driver: WebDriver

    @BeforeMethod
    open fun setup() {
        WebDriverManager.chromedriver().setup()
        driver = ChromeDriver()
        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage()?.window()?.maximize()
        driver.get("http://automationpractice.com/")
    }

    @AfterMethod
    open fun tearDown() {
        driver.close()
    }

    fun getPageTitle(): String? {
        return driver.title
    }

    open fun waitForPageLoad(driver: WebDriver?) {
        val pageLoadCondition: ExpectedCondition<Boolean> =
            ExpectedCondition { driver -> (driver as JavascriptExecutor?)!!.executeScript("return document.readyState") == "complete" }
        val wait = WebDriverWait(driver, 30)
        wait.until(pageLoadCondition)
    }


}