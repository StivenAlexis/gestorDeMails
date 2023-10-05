import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import gestor.Contact;
import gestor.Email;
import gestor.MailBox;
import gestor.Manager;
public class ManagerTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();


    @Test
    public void ManagerNotNullTest(){
         
        Contact remitente = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        Contact c1 = new Contact("Alejo", "Espinoza", "alejoEs@gmai.com");
        Email e1 = new Email(remitente,c1);
        
        e1.setSubject("saludo");
        e1.setContent("hola");

        MailBox ma1 = new MailBox(remitente.getEmailAddress());

        Manager m1= new Manager(ma1);

        assertNotNull(m1);
      
    
    }

    @Test
    public void ManagerNullTest(){
        
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Este campo es obligatorio");
        Manager m1= new Manager(null);

        assertNotNull(m1);
      
    
    }
    @Test
    public void ManagerNullsTest(){
         
        Contact remitente = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        Contact c1 = new Contact("Alejo", "Espinoza", "alejoEs@gmai.com");
        Contact c2 = new Contact("Yanileth", "Fontalvo", "YanilethFon@gmail.com");
        Email e1 = new Email(remitente,c1);
        
        ArrayList<Contact> to = new ArrayList<>();
        to.add(c2);
        e1.setSubject("saludo");
        e1.setContent("hola");
        e1.addTo(c2);

        MailBox ma1 = new MailBox(remitente.getEmailAddress());

        Manager m1= new Manager(ma1);

        m1.converter(e1);

        m1.send(e1);

        assertEquals("Stiven22@gmail.comn" ,m1.fromBox.emailAddress);
        assertEquals(1,m1.fromBox.trays.Outbox.size());
        assertEquals("alejoEs@gmai.com",m1.ToBox.get(0).emailAddress);
        assertEquals("YanilethFon@gmail.com",m1.ToBox.get(1).emailAddress);
        assertEquals(1,m1.ToBox.get(0).trays.Inbox.size());
    
    
    }
}
