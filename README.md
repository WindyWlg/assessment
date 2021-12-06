# ANZ HomeLoan Calculator UI Automation with Serenity and Cucumber

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/ Action Classes approach, and the more sophisticated and flexible Screenplay pattern.

The latest version of Serenity supports Cucumber 6.x.

### Stepup:

Install Java
Install Maven

### The project directory structure
The project has build scripts for Maven, and follows the standard directory structure used in most Serenity projects:
Gherkin
src
+ main
+ test
    + java                        Test runners and supporting code
    + resources
        + features                  Feature files


## Executing the tests
To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
json
$ mvn clean verify -Ddriver=firefox


The test results will be recorded in the `target/site/serenity` directory.


## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.
### Webdriver configuration
The WebDriver configuration is managed entirely from this file, as illustrated below:
java
webdriver {
driver = chrome
}
headless.mode = true

chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
--disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
--incognito;--disable-infobars,--disable-gpu"""



### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, _dev, _staging and prod, with different starting URLs for each:
json
environments {
default {
webdriver.base.url = "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
}
dev {
webdriver.base.url = "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
}
test {
webdriver.base.url = "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
}
ppt {
webdriver.base.url = "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
}
}


You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
json
$ mvn clean verify -Denvironment=test


See [*this article*](https://johnfergusonsmart.com/environment-specific-configuration-in-serenity-bdd/) for more details about this feature.

## Want to learn more?
For more information about Serenity BDD, you can read the [*Serenity BDD Book*](https://serenity-bdd.github.io/theserenitybook/latest/index.html), the official online Serenity documentation source. Other sources include:
* **[Learn Serenity BDD Online](https://expansion.serenity-dojo.com/)** with online courses from the Serenity Dojo Training Library
* **[Byte-sized Serenity BDD](https://www.youtube.com/channel/UCav6-dPEUiLbnu-rgpy7_bw/featured)** - tips and tricks about Serenity BDD
* For regular posts on agile test automation best practices, join the **[Agile Test Automation Secrets](https://www.linkedin.com/groups/8961597/)** groups on [LinkedIn](https://www.linkedin.com/groups/8961597/) and [Facebook](https://www.facebook.com/groups/agiletestautomation/)
* [*Serenity BDD Blog*](https://johnfergusonsmart.com/category/serenity-bdd/) - regular articles about Serenity BDD