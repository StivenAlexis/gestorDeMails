import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import gestor.Contact;
import gestor.Email;
import gestor.MailBox;
import gestor.Manager;

public class ManagerTest {
    
    @Test
    public void emailValid(){
         
        Contact remitente = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        Contact c1 = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        Email e1 = new Email(remitente,c1);
        
        e1.subject= "saludo";
        e1.content = "hola";
        
        MailBox ma1 = new MailBox(remitente.getEmailAddress());

        Manager m1= new Manager(ma1);

        ArrayList<MailBox> ToBox = m1.converter(e1);

;


        assertEquals(1, ToBox.size());
        assertEquals(1, m1.senderBox.trays.Outbox.size());


    
    }
}
