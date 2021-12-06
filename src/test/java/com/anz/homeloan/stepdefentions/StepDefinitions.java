package com.anz.homeloan.stepdefentions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class StepDefinitions {

    @Steps
    HomeLoanCalcSteps homeLoanCalcSteps;

    @Given("Anna visits anz homeloan calculator webpage")
    public void anna_visits_anz_homeloan_calculator_webpage() {
        homeLoanCalcSteps.launchCalculator();
    }

    @When("Anna entering details on the form with following data")
    public void anna_entering_details_on_the_form_with_following_data(DataTable dataTable) {

        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

        String appType = list.get(0).get("appType");
        String dependents = list.get(0).get("dependents");
        String propertyType = list.get(0).get("propertyType");
        String income = list.get(0).get("income");
        String otherIncome = list.get(0).get("otherIncome");
        String livingExpenses = list.get(0).get("livingExpenses");
        String loanRepayments = list.get(0).get("loanRepayments");
        String otherloanRepayments = list.get(0).get("otherloanRepayments");
        String otherCommitments = list.get(0).get("otherCommitments");
        String totalCClimit = list.get(0).get("totalCClimit");

        homeLoanCalcSteps.selectApplicantType(appType);
        homeLoanCalcSteps.selectDependents(dependents);
        homeLoanCalcSteps.selectPropertyType(propertyType);
        homeLoanCalcSteps.enterIncome(income);
        homeLoanCalcSteps.enterOtherIncome(otherIncome);
        homeLoanCalcSteps.enterLivingExpenses(livingExpenses);
        homeLoanCalcSteps.enterHomeLoanRepayments(loanRepayments);
        homeLoanCalcSteps.enterOtherLoans(otherloanRepayments);
        homeLoanCalcSteps.enterCommitments(otherCommitments);
        homeLoanCalcSteps.enterCreditCardLimit(totalCClimit);
        homeLoanCalcSteps.clickLoanCalcButton();
    }

    @Then("Anna should see the response returning expected message as {string}")
    public void anna_should_see_the_response_returning_expected_message_as(String amount) {

        if (!amount.contains("error")) {
            homeLoanCalcSteps.validateAmountCalculated(amount);
        } else {
            homeLoanCalcSteps.validateErrorMsg();
        }
    }

}
