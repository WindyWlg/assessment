package com.anz.homeloan.stepdefentions;

import com.anz.homeloan.pages.HomeLoanPage;
import net.thucydides.core.annotations.Step;

public class HomeLoanCalcSteps {

    HomeLoanPage homeLoanPage;

    @Step("User navigating to ANZ home loan calculator webpage")
    public void launchCalculator() {
        homeLoanPage.open();
    }

    @Step("User selecting applicant type whether Single/Joint")
    public void selectApplicantType(String appType) {
        homeLoanPage.selectAppType(appType);
    }

    @Step("User selecting number of dependents in household")
    public void selectDependents(String dependents) {
        homeLoanPage.selectDependents(dependents);
    }

    @Step("User selecting to buy Home to live in or Investment property type ")
    public void selectPropertyType(String propType) {
        homeLoanPage.selectPropType(propType);
    }

    @Step("User entering his yearly income")
    public void enterIncome(String income) {
        homeLoanPage.enterIncome(income);
    }

    @Step("User entering other type of income")
    public void enterOtherIncome(String otherIncome) {
        homeLoanPage.enterOtherIncome(otherIncome);
    }

    @Step("User entering his/her living expenses")
    public void enterLivingExpenses(String livingExpenses) {
        homeLoanPage.enterlivingExpenses(livingExpenses);
    }

    @Step("User entering current home loan repayments")
    public void enterHomeLoanRepayments(String homeLoans) {
        homeLoanPage.enterHomeloans(homeLoans);
    }

    @Step("User entering any other outstanding loan amounts")
    public void enterOtherLoans(String otherLoans) {
        homeLoanPage.enterOtherloans(otherLoans);
    }

    @Step("User entering any misc commitments")
    public void enterCommitments(String commitments) {
        homeLoanPage.enterOtherCommitments(commitments);
    }

    @Step("User entering his/her credit card limits")
    public void enterCreditCardLimit(String creditCardLimit) {
        homeLoanPage.enterCredit(creditCardLimit);
    }

    @Step("Calculated loan amount for the details entered by User")
    public String getLoanAmount() {
        return homeLoanPage.getCalcValue();
    }

    @Step("Test validating the amount displayed is what is expected result")
    public void validateAmountCalculated(String amount) {
        homeLoanPage.validateLoanAmount(amount);
    }

    @Step("Test validating whether web app throws proper error msg")
    public void validateErrorMsg() {
        homeLoanPage.validateErrorMsg();
    }

    @Step
    public String getErrorMsg() {
        return homeLoanPage.getErrorMsg();
    }

    @Step("User resetting calc to re-calc")
    public void resetCalc() {
        homeLoanPage.reCalc();
    }

    @Step("User clicking on the Calculate Loan amount button")
    public void clickLoanCalcButton() {
        homeLoanPage.clickCalcButton();
    }
}
