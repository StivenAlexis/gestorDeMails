import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import gestor.Contact;
import gestor.Email;

public class EmailTest {
    

    @Test
    public void emailValid(){

        Email e1 = new Email();
        Contact c1 = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        Contact c2 = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        
        e1.subject= "no se que poner";
        e1.content = "hola";
        e1.sender= c1;
        e1.to.add(c2);

        assertNotEquals("",e1.subject);
        assertNotEquals(0,e1.to.size());
        assertNotEquals("",e1.content);
        assertNotEquals(null,e1.sender);  

    }
//EL buzon deberia recibir un cotacto.emailAddress
    


}
