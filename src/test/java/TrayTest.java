import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gestor.Contact;
import gestor.Email;
import gestor.Tray;

public class TrayTest {
    

    @Test 
    public void FUnctionalTRayTest(){

       Tray t1 = new Tray(); 
       Contact c1 = new Contact("stivenMO@gmail.com");
       Contact c2 = new Contact("stiven@gmail.com");
       Email e1 = new Email(c1,c2); 
       
        e1.setContent("asdasd");
        e1.setSubject("sasd");
        

        assertTrue(t1.Inbox.add(e1));

        

    }


}
