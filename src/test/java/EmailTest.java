
import static org.junit.Assert.assertNotEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gestor.Contact;
import gestor.Email;


public class EmailTest {
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void emailValid(){

        
        Contact remitente = new Contact("Juan", "martinez", "demo1@ucp.com");
        Contact c1 = new Contact("alejo", "alvarado", "demo2@ucp.com");
        Email e1 = new Email(remitente,c1);
        
        e1.setSubject("saludo");
        e1.setContent("hola");
        

        assertNotEquals("",e1.getSubject());
        assertNotEquals(0,e1.getTo().size());
        assertNotEquals("",e1.getContent());
        assertNotEquals(null,e1.getSender());  

        
    }


    @Test
    public void emailInvalidFrom(){

        
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Estos campos son obligatorios");
        
        Contact c1 = new Contact("Juan", "martinez", "demo1@ucp.com");
        new Email(null,c1);

        
    }

     @Test
    public void emailInvalidTo(){

        
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Estos campos son obligatorios");
        
        Contact c1 = new Contact("Juan", "martinez", "demo1@ucp.com");
        new Email(c1,null);
        
        
    }
}
