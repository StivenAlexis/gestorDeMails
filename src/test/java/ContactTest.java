import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gestor.Contact;

public class ContactTest {
    

     @Test
    public void contactIfExists(){

        Contact c1 = new Contact("Jose", "Ramirez", "JoseRam@gmail.com") ;

        assertNotNull(c1);

    }

    @Test
    public void contactEmailValid(){

        Contact c1 = new Contact("Stiven22@gmail.com");


        assertTrue(c1.esCorreoValido(c1.getEmailAddress()));

    }

    @Test
    public void contactEmailInvalid(){

        
        Contact c1 = new Contact("Stiven22com");

        assertFalse(c1.esCorreoValido(c1.getEmailAddress()));

    }

}
