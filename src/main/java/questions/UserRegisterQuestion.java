package questions;

import models.users.UsersRegister;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UserRegisterQuestion implements Question {

    @Override
    public UsersRegister answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(UsersRegister.class);
    }
}
