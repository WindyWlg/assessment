package com.anz.homeloan.pages;

import com.anz.homeloan.helpers.LoggerHelper;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomeLoanPage extends PageObject {

    private static Logger log = LoggerHelper.getLog(HomeLoanPage.class);

    @Managed
    WebDriver webDriver;

    @FindBy(css = ".borrow__question:nth-child(2) .selected > .btn")
    WebElementFacade Single;

    @FindBy(css = ".borrow__question:nth-child(2) li:nth-child(2) > .btn")
    WebElementFacade Joint;

    @FindBy(css = ".borrow__question__answer > select")
    WebElementFacade noDependents;

    @FindBy(css = ".borrow__question--tall .selected > .btn")
    WebElementFacade HomePropertyType;

    @FindBy(css = ".selected:nth-child(2) > .btn")
    WebElementFacade InvestPropertyType;

    @FindBy(css = ".borrow__question:nth-child(2) > .input__wrapper:nth-child(2) > input")
    WebElementFacade income;

    @FindBy(xpath = "(//input[@value='0'])[2]")
    WebElementFacade otherIncome;

    @FindBy(id = "expenses")
    WebElementFacade livingExpenses;

    @FindBy(id = "otherloans")
    WebElementFacade otherloans;

    @FindBy(id = "homeloans")
    WebElementFacade homeloans;

    @FindBy(id = "credit")
    WebElementFacade credit;

    @FindBy(css = ".container__main__element:nth-child(3) .borrow__question:nth-child(5) input")
    WebElementFacade otherCommitments;

    @FindBy(id = "btnBorrowCalculater")
    WebElementFacade btnBorrowCalculater;

    @FindBy(id = "borrowResultTextAmount")
    WebElementFacade borrowResultTextAmount;

    @FindBy(css = ".borrow__error .start-over")
    WebElementFacade startOver;

    @FindBy(css = ".borrow__error__text")
    WebElementFacade errorMsg;

    public void selectAppType(String AppType) {
        if (AppType.contains("Single")) {
            waitFor(Single);
            this.Single.click();
        } else {
            this.Joint.click();
        }
    }

    public void selectDependents(String dependants) {
        waitFor(noDependents);
        shouldBeVisible(noDependents);
        this.noDependents.click();
    }

    public void selectPropType(String propType) {
        if (propType.contains("Home")) {
            waitFor(HomePropertyType);
            this.HomePropertyType.click();
        } else {
            this.InvestPropertyType.click();
        }
    }

    public void enterIncome(String income) {
        this.income.waitUntilPresent();
        this.income.isEnabled();
        this.income.clear();
        this.income.sendKeys(income);

    }

    public void enterOtherIncome(String otherIncome) {
        this.otherIncome.sendKeys(otherIncome);
    }

    public void enterlivingExpenses(String livingExpenses) {
        this.livingExpenses.clear();
        this.livingExpenses.sendKeys(livingExpenses);
    }

    public void enterHomeloans(String homeloans) {
        this.homeloans.clear();
        this.homeloans.sendKeys(homeloans);
    }

    public void enterOtherloans(String otherloans) {
        this.otherloans.clear();
        this.otherloans.sendKeys(otherloans);
    }

    public void enterOtherCommitments(String otherCommitments) {
        this.otherCommitments.clear();
        this.otherCommitments.sendKeys(otherCommitments);
    }

    public void enterCredit(String credit) {
        this.credit.clear();
        this.credit.sendKeys(credit);
    }

    public void clickCalcButton() {
        this.btnBorrowCalculater.click();
    }

    public String getCalcValue() {
        return this.borrowResultTextAmount.getText();
    }

    public String getErrorMsg() {
        return this.errorMsg.getText();
    }

    public void validateLoanAmount(String amount) {
        waitFor(borrowResultTextAmount);
        shouldBeVisible(borrowResultTextAmount);
        Assert.assertEquals(borrowResultTextAmount.getText(), amount);
    }

    public void validateErrorMsg() {
        waitFor(errorMsg);
        shouldBeVisible(errorMsg);
        String error = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
        Assert.assertEquals(errorMsg.getText(), error);
    }

    public void reCalc() {
        this.startOver.click();
    }

    public void launchPage(String url) {
        this.openUrl(url);
    }
}
