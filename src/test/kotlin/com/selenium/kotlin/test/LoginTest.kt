package com.selenium.kotlin.test

import com.selenium.kotlin.page.HomePage
import com.selenium.kotlin.page.LoginPage
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Project Name    : kotlin-selenium-testng-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 4/11/2020
 * Time            : 10:06 AM
 * Description     : This is login test class
 **/

class LoginTest : TestBase() {

    private val validEmail = "osanda@mailinator.com"
    private val validPassword = "1qaz2wsx@"
    private val invalidEmail = "osa@gmail.com"
    private val invalidPassword = "password1"

    private val loginPageTitle = "Login - My Store"
    private val myAccountPageTitle = "My account - My Store"


    @Test
    fun validLogin() {
        waitForPageLoad(driver)
        val homePage = HomePage(driver)
        homePage.clickOnSignInButton()
        waitForPageLoad(driver)
        val loginPage = LoginPage(driver)
        loginPage.login(validEmail, validPassword)
        Assert.assertEquals(getPageTitle(),myAccountPageTitle)
    }

    @Test
    fun invalidLogin() {
        waitForPageLoad(driver)
        val homePage = HomePage(driver)
        homePage.clickOnSignInButton()
        waitForPageLoad(driver)
        val loginPage = LoginPage(driver)
        loginPage.login(invalidEmail, invalidPassword)
        Assert.assertEquals(getPageTitle(),loginPageTitle)
    }


}