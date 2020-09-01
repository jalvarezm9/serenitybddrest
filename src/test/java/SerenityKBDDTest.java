import facts.NetflixPlans;
import models.users.Datum;
import models.users.Foo;
import models.users.RegisterUserInfo;
import models.users.UsersRegister;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.GetUsersQuestion;
import questions.ResponseCodeK;
import questions.UserRegisterQuestion;
import tasks.GetUsersK;
import tasks.PostRegisterUser;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SerenityRunner.class)
public class SerenityKBDDTest {
    public static final String urlBase="http://localhost:5000";

    @Test
    public void getUsers(){

        Actor katherine=Actor.named("Katherine Vanessa Garcia Espejo")
        .whoCan(CallAnApi.at(urlBase));

        katherine.attemptsTo(
                GetUsersK.fromPage(1)
        );

        //Assertions.assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);

        katherine.should(   //Deberia
                seeThat("el codigo de respuesta", ResponseCodeK.was(), equalTo(200)) //ver eso
        );

        //http://www.jsonschema2pojo.org/

        Datum userEspecifico= new GetUsersQuestion().answeredBy(katherine)
                .getData().stream().filter(x->x.getId()==1).findFirst().orElse(null);

        katherine.should(
                seeThat("usuario no es nulo",act->userEspecifico,notNullValue())
        );

        katherine.should(
                seeThat("el email del usuario",act->userEspecifico.getEmail(),equalTo("george.bluth@reqres.in")),
                seeThat("el avatar del usuario",act->userEspecifico.getAvatar(),equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"))
        );

    }

    @Test
    public void registerUserTest(){

        Actor katherine=Actor.named("Katherine Vanessa Garcia Espejo")
                .whoCan(CallAnApi.at(urlBase));

        String registerUserInfo="{\n" +
                "    \"name\":\"morpheus\",\n" +
                "    \"job\":\"leader\",\n" +
                "    \"email\": \"tracey.ramos@reqres.in\",\n" +
                "    \"password\": \"serenity\"\n" +
                "}";

        katherine.attemptsTo(
                PostRegisterUser.withInfo(registerUserInfo)
        );

        katherine.should(   //Deberia
                seeThat("el codigo de respuesta", ResponseCodeK.was(), equalTo(200))
        );

    }

    @Test
    public void registerUserTest2(){

        Actor katherine=Actor.named("Katherine Vanessa Garcia Espejo")
                .whoCan(CallAnApi.at(urlBase));

        RegisterUserInfo registerUserInfo=new RegisterUserInfo();
        registerUserInfo.setName("morpheus");
        registerUserInfo.setJob("leader");
        registerUserInfo.setEmail("tracey.ramos@reqres.in");
        registerUserInfo.setPassword("serenity");

        katherine.attemptsTo(
                PostRegisterUser.withInfo(registerUserInfo)
        );

        katherine.should(   //Deberia
                seeThat("el codigo de respuesta", ResponseCodeK.was(), equalTo(200))
        );

        UsersRegister usersRegister= new UserRegisterQuestion().answeredBy(katherine);

        katherine.should(
                seeThat("el id del registro",act->usersRegister.getId(),equalTo(6)),
                seeThat("el token del registro",act->usersRegister.getToken(),equalTo("QpwL5tke4Pnpja7X6"))
        );

    }

    @Test
    public void factTest(){

        Actor katherine=Actor.named("Katherine Vanessa Garcia Espejo")
                .whoCan(CallAnApi.at(urlBase));

        katherine.has(NetflixPlans.toViewSeries());

    }

    @Test
    public void builderTest(){
        Foo foo=Foo.builder()
                .name("Juan")
                .lastname("Alvarez")
                .edad(37)
                .correo("jalvarezm@outlook.com")
                .build();

        Foo foo2=Foo.builder()
                .edad(37)
                .build();

        System.out.println(foo.toString());
        System.out.println(foo2.toString());

    }

}
