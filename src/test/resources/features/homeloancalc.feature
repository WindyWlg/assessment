Feature: ANZ Customer using HomeLoan borrowing power calculator to get a quick estimate on how much
  you may be able to borrow based on your current income and existing financial commitments.
  JIRA - HL-1, HL-2

  @functional
  Scenario Outline: Anna checking her borrowing power by using online ANZ homeloan calculator
    Given Anna visits anz homeloan calculator webpage
    When Anna entering details on the form with following data
      | appType   | dependents   | propertyType   | income   | otherIncome   | livingExpenses   | loanRepayments   | otherloanRepayments   | otherCommitments   | totalCClimit   |
      | <appType> | <dependents> | <propertyType> | <income> | <otherIncome> | <livingExpenses> | <loanRepayments> | <otherloanRepayments> | <otherCommitments> | <totalCClimit> |
    Then Anna should see the response returning expected message as "<expectedmessage>"
    Examples: Anna using home loan calculator to check her borrowing power
      | testCase                                   | expectedmessage | appType | dependents | propertyType | income | otherIncome | livingExpenses | loanRepayments | otherloanRepayments | otherCommitments | totalCClimit |
      | Testcase HL-1 : User entering valid data   | $482,000        | Single  | 0          | Home         | 80000  | 10000       | 500            | 0              | 100                 | 0                | 10000        |
      | Testcase HL-2 : User entering Invalid data | error           | Single  | 0          | Home         | 0      | 0           | 1              | 0              | 0                   | 0                | 0            |
      | Testcase HL-2 : User entering Invalid data | error           | Single  | 0          | Home         | 0      | 0           | 1              | 0              | 0                   | 0                | 0            |
      | Testcase HL-2 : User entering Invalid data | error           | Single  | 0          | Home         | 1      | 0           | 1              | 0              | 0                   | 0                | 0            |
      | Testcase HL-2 : User entering Invalid data | error           | Single  | 0          | Home         | 0      | 1           | 1              | 0              | 0                   | 0                | 0            |
      | Testcase HL-2 : User entering Invalid data | error           | Single  | 0          | Home         | 0      | 0           | 1              | 1              | 0                   | 0                | 0            |
      | Testcase HL-2 : User entering Invalid data | error           | Single  | 0          | Home         | 0      | 0           | 1              | 0              | 1                   | 0                | 0            |
      | Testcase HL-2 : User entering Invalid data | error           | Single  | 0          | Home         | 0      | 0           | 1              | 0              | 0                   | 1                | 0            |
      | Testcase HL-2 : User entering Invalid data | error           | Single  | 0          | Home         | 0      | 0           | 1              | 0              | 0                   | 0                | 1            |

