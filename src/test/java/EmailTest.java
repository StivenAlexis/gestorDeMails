
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import gestor.Contact;
import gestor.Email;


public class EmailTest {
    

    @Test
    public void emailValid(){

        
        Contact remitente = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        Contact c1 = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        Email e1 = new Email(remitente,c1);
        
        e1.setSubject("saludo");
        e1.setContent("hola");
        

        assertNotEquals("",e1.getSubject());
        assertNotEquals(0,e1.getTo().size());
        assertNotEquals("",e1.getContent());
        assertNotEquals(null,e1.getSender());  

        
        
        
    }
//EL buzon deberia recibir un cotacto.emailAddress
    

     @Test
    public void emailInvalidFrom(){

        
        
        Contact c1 = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        Email e1 = new Email(c1,c1);
        
        e1.setSubject("saludo");
        e1.setContent("hola");
        

        assertNotEquals("",e1.getSubject());
        assertNotEquals(0,e1.getTo().size());
        assertNotEquals("",e1.getContent());
        assertNotEquals(null,e1.getSender());  

        
        
        
    }
}
