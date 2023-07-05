package co.com.practice.interactions;

import co.com.practice.exceptions.ErrorServiceException;
import co.com.practice.models.TestData;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.hc.core5.http.HttpStatus;

public class ExecuteGet implements Interaction {

private final String resource;

    public ExecuteGet(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(resource)
                        .with(request -> request
                                .contentType(ContentType.JSON).params(TestData.getData())
                                .relaxedHTTPSValidation()
                        )
        );
        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
            throw new ErrorServiceException("Apparently there is an error in the consumption of the service");

        }
    }
    public static ExecuteGet service(String resource) {
        return Tasks.instrumented(ExecuteGet.class, resource);
    }
}
