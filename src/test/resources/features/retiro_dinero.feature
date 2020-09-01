# language:es
Característica: Retiro de dinero
  Con el fin de poder tener flujo de dinero
  Yo como usuario quiero poder retirar dinero de mis cuentas de ahorro
  Para poder realizar pagos y compras en establecimientos donde solo reciban efectivo

  Escenario: Cliente retira dinero de su cuenta de ahorros
    Dado Katherine es una cliente con una cuenta de ahorros
    Y en su cuenta tiene un saldo disponible de 1000000
    Cuando el envia el intenta retirar de su cuenta 100000
    Entonces el debe debera optener 100000
    Y el nuevo saldo de su cuenta deberia ser 900000