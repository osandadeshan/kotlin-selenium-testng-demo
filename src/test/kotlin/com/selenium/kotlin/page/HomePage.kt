package com.selenium.kotlin.page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

/**
 * Project Name    : kotlin-selenium-testng-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 4/11/2020
 * Time            : 9:25 AM
 * Description     : This is homepage page object class
 **/

class HomePage(driver: WebDriver) {

    @FindBy(xpath = "//a[@class='login']")
    private val signInButton: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun clickOnSignInButton() {
        signInButton?.click()
    }


}