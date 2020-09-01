package models.users;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Foo {

    private String name;
    private String lastname;
    private int edad;
    private String correo;

}
