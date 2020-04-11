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
 * Time            : 9:35 AM
 * Description     : This is loginpage page object class
 **/

class LoginPage(driver: WebDriver) {

    @FindBy(id = "email")
    private val emailTextBox: WebElement? = null

    @FindBy(id = "passwd")
    private val passwordTextBox: WebElement? = null

    @FindBy(xpath = "//p[@class='submit']//span[1]")
    private val signInButton: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun login(email: String, password : String){
        emailTextBox?.sendKeys(email)
        passwordTextBox?.sendKeys(password)
        signInButton?.click()
    }


}