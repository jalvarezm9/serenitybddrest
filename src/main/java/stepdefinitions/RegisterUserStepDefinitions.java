package stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.ResponseCodeK;
import tasks.PostRegisterUser;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterUserStepDefinitions {

    public static final String urlBase="http://localhost:5000";
    public Actor katherine;

    @Dado("^Katherine es una cliente que quiere poder administrar sus productos bancarios$")
    public void julian_es_un_cliente_que_quiere_poder_administrar_sus_productos_bancarios() {
        katherine=Actor.named("Katherine Vanessa Garcia Espejo")
                .whoCan(CallAnApi.at(urlBase));
    }

    @Cuando("^el envia la informacion requerida para el registro$")
    public void el_envia_la_informacion_requerida_para_el_registro() {
        String registerUserInfo="{\n" +
                "    \"name\":\"morpheus\",\n" +
                "    \"job\":\"leader\",\n" +
                "    \"email\": \"tracey.ramos@reqres.in\",\n" +
                "    \"password\": \"serenity\"\n" +
                "}";

        katherine.attemptsTo(
                PostRegisterUser.withInfo(registerUserInfo)
        );
    }

    @Entonces("^el debe obtener una cuenta virtual para poder ingresar cuando lo requiera$")
    public void el_debe_obtener_una_cuenta_virtual_para_poder_ingresar_cuando_lo_requiera() {
        katherine.should(   //Deberia
                seeThat("el codigo de respuesta", ResponseCodeK.was(), equalTo(200))
        );
    }

}
