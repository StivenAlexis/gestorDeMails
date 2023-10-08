import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gestor.Contact;
import gestor.Email;
import gestor.Tray;

public class TrayTest {
    

    @Test 
    public void TrayNotNull(){

       Tray t1 = new Tray(); 
       
       assertNotNull(t1);
    }


    
    @Test 
    public void TrayAddEmailTest(){

       Tray t1 = new Tray(); 
       Contact c1 = new Contact("stivenMO@gmail.com");
       Contact c2 = new Contact("stiven@gmail.com");
       Email e1 = new Email(c1,c2); 
       
        e1.setContent("asdasd");
        e1.setSubject("sasd");
        t1.addInbox(e1);
        t1.addOutbox(e1);

        assertEquals(e1,t1.getInbox().get(0));
        assertEquals(e1,t1.getOutbox().get(0));

        

    }


}
