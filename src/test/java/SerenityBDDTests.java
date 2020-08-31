import models.users.Datum;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.assertj.core.api.Assertions;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import questions.GetUsersQuestion;
import questions.ResponseCode;
import tasks.GetUsers;


@RunWith(SerenityRunner.class)
public class SerenityBDDTests {

    private static final String restApiUrl="http://localhost:5000";

    @Test
    public void initialTest1(){

        Actor juanCarlos=Actor.named("Juan Carlos Alvarez Mantari")
                .whoCan(CallAnApi.at(restApiUrl)); //QuienPuede - Llamar_A_Una_API a la URL "restApiURL"
                //Basicamente es un actor que le dimos la habilidad de comunicarse con una API

        juanCarlos.attemptsTo(  //JuanCarlos "intenta" hacer que??
                Get.resource("/api/users?page=2") //intenta hacer una petición GET al recurso /users?page=2
        );

        Assertions.assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
    }

    @Test
    public void initialTest2(){

        Actor jennyMery=Actor.named("Jenny Mery")
                .whoCan(CallAnApi.at(restApiUrl));

        jennyMery.attemptsTo(
               GetUsers.fromPage(2)
        );

        Assertions.assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
    }

    @Test
    public void initialTest3(){

        Actor cesarAugusto=Actor.named("Cesar Augusto")
                .whoCan(CallAnApi.at(restApiUrl));

        cesarAugusto.attemptsTo(
                GetUsers.fromPage(2)
        );

        //Assertions.assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);

        cesarAugusto.should(   //CesarAugusto debería
                seeThat("el codigo de respuesta",ResponseCode.was(), equalTo(200)) //ver eso
        );

        Datum user= new GetUsersQuestion().answeredBy(cesarAugusto)
                .getData().stream().filter(objUser ->objUser.getId()==4).findFirst().orElse(null);

        cesarAugusto.should(
                seeThat("usuario no es nulo",act -> user, notNullValue())
        );

        cesarAugusto.should(
                seeThat("el email del usuario es",act -> user.getEmail(), equalTo("eve.holt@reqres.in"))
        );

        cesarAugusto.should(
                seeThat("el avatar del usuario es",act->user.getAvatar(),equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"))
        );

    }

}
