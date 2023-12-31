package co.com.practice.stepdefinitions;

import co.com.practice.exceptions.AssertionsServices;
import co.com.practice.questions.*;
import co.com.practice.tasks.ConsumeGet;
import co.com.practice.tasks.Load;
import co.com.practice.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.practice.exceptions.AssertionsServices.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;
import java.util.Map;

public class GetStepdefinitions {
    @Given("Load customer information")
    public void loadCustomerInformation(List<Map<String,String>> data) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(data.get(0))
        );
    }

    @When("I call Get user API")
    public void iCallGetUserAPI() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGet.service(
                        WebServiceEndPoints.URI.getUrl()
                )
        );

    }

    @Then("I Should see the status code {int}")
    public void iShouldSeeTheStatusCode(int resposeCode) {
        theActorInTheSpotlight()
                .should(seeThat(StatusCode.is(resposeCode))
                        .orComplainWith(AssertionsServices.class, THE_STATUS_CODE_SERVECE_IS_NOT_EXPECTED)
                );
    }

    @And("I validate quantity key is {int}")
    public void iValidateQuantityKeyIs(int quantity) {
        theActorInTheSpotlight()
                .should(seeThat(TheQuantityFieldsService.are(quantity))
                .orComplainWith(AssertionsServices.class, QUANTITY_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );

    }

    @And("I validate schema response {string}")
    public void iValidateSchemaResponse(String schemaResponse) {
        theActorInTheSpotlight()
                .should(seeThat(TheSchemaIs.expected(schemaResponse))
                .orComplainWith(AssertionsServices.class, SCHEMA_SERVICE_IS_NOT_EXPECTED)

                );

    }

    @And("Ivalidate fields get response api")
    public void ivalidateFieldsGetResponseApi() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsGetServicesResponseAre.expected())
                .orComplainWith(AssertionsServices.class, THE_FIELDS_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @And("I validate get response contains data expected")
    public void iValidateGetResponseContainsDataExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuesGetResponseAre.expected())
                .orComplainWith(AssertionsServices.class, THE_FIELDS_AND_VALUES_SERVICE_IS_NOT_EXPECTED)
                );
    }
}
