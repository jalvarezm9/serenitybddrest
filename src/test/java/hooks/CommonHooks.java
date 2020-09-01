package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonHooks {

    @Before
    public void cleanDataBase(){
        System.out.println("#############Inicio#############");
    }

    @After
    public void exitDataBase(){
        System.out.println("#############Fin#############");
    }
}
