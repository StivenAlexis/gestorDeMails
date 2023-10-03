
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import gestor.Contact;
import gestor.Email;

public class EmailTest {
    

    @Test
    public void emailValid(){

        
        Contact c1 = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        Contact c2 = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        Email e1 = new Email(c1,c2);
        
        e1.subject= "no se que poner";
        e1.content = "hola";
        

        assertNotEquals("",e1.subject);
        assertNotEquals(0,e1.to.size());
        assertNotEquals("",e1.content);
        assertNotEquals(null,e1.sender);  

    }

    


}
