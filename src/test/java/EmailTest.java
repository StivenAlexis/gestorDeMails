
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
        
        e1.subject= "saludo";
        e1.content = "hola";
        

        assertNotEquals("",e1.subject);
        assertNotEquals(0,e1.to.size());
        assertNotEquals("",e1.content);
        assertNotEquals(null,e1.sender);  

        
        
        
    }
//EL buzon deberia recibir un cotacto.emailAddress
    


}
