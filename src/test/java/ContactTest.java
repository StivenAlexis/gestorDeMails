
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gestor.Contact;

public class ContactTest {
    
     @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

     @Test
    public void contactIfExists(){

        Contact c1 = new Contact("Jose", "Ramirez", "JoseRam@gmail.com") ;

        assertNotNull(c1);

    }

    @Test
    public void contactEmailValid(){

        Contact c1 = new Contact("demo@ucp.com");


        assertEquals(true,c1.isValidMail("demo@ucp.com"));
        
    }

    @Test
    public void contactEmailInValid(){

        Contact c1 = new Contact("demo@ucp.com");


        assertEquals(true,c1.isValidMail("demo@ucp.com"));
        
    }

    @Test
    public void contactNullEmail(){

        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("El correo electrónico no es válido");

        new Contact(null);

        

    }

}
