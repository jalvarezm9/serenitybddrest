package stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

public class WithdrawStepDefinitions {

    @Dado("^Katherine es una cliente con una cuenta de ahorros$")
    public void katherine_es_una_cliente_con_una_cuenta_de_ahorros() {

    }

    @Y("^en su cuenta tiene un saldo disponible de (\\d+)$")
    public void en_su_cuenta_tiene_un_saldo_disponible_de(int arg1) {

    }

    @Cuando("^el envia el intenta retirar de su cuenta (\\d+)$")
    public void el_envia_el_intenta_retirar_de_su_cuenta(int arg1) {

    }

    @Entonces("^el debe debera optener (\\d+)$")
    public void el_debe_debera_optener(int arg1) {

    }

    @Y("^el nuevo saldo de su cuenta deberia ser (\\d+)$")
    public void el_nuevo_saldo_de_su_cuenta_deberia_ser(int arg1) {

    }
}
