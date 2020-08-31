package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetUsers implements Task {

    private final int page;

    public GetUsers(int page) {
        this.page=page;
    }

    public static Performable fromPage(int page){   //Metodo Factory - A traves de este metodo -instrumented -se crea una nueva instancia de Getuser
        return Tasks.instrumented(GetUsers.class,page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/users?page="+page)
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                .header("header1","value1"))
        );
    }
}
