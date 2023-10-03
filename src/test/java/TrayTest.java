import org.junit.Test;

import gestor.Contact;
import gestor.Email;
import gestor.Tray;

public class TrayTest {
    

    @Test 
    public void FUnctionalTRayTest(){

       Tray t1 = new Tray(); 
       Email e1 = new Email(); 
       Contact c1 = new Contact("stivenMO@gmail.com");
       Contact c2 = new Contact("stiven@gmail.com");
       
        e1.content= "asdasd";
        e1.subject="sdsad ";
        e1.sender= c1;
        e1.to.add(c2);

        t1.Inbox.add(e1);

        assert

    }


}
