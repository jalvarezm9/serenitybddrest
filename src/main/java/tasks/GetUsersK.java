package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetUsersK implements Task {

    private final int page;

    public GetUsersK(int page) {
        this.page = page;
    }

    public static Performable fromPage(int page){
        return Tasks.instrumented(GetUsersK.class,page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/users?page="+page)
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .header("value","123456")
                )
        );
    }
}
