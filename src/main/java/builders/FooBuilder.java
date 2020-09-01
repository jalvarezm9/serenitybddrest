package builders;

public class FooBuilder {

    private String name;
    private String lastname;
    private int edad;
    private String correo;

    public FooBuilder(String name) {
        this.name = name;
    }

    public static FooBuilder whitName(String name){
        return new FooBuilder(name);
    }
}
