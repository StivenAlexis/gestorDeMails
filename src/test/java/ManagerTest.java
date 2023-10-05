import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    public void ManagerSendTest(){
         
        Contact remitente = new Contact("Juan", "martinez", "Stiven22@gmail.comn");
        Contact c1 = new Contact("Alejo", "Espinoza", "alejoEs@gmai.com");
        Contact c2 = new Contact("Yanileth", "Fontalvo", "YanilethFon@gmail.com");
        Email e1 = new Email(remitente,c1);
     
        e1.setSubject("saludo");
        e1.setContent("hola");
        e1.addTo(c2);

        MailBox ma1 = new MailBox(remitente.getEmailAddress());
        MailBox ma2 = new MailBox(c1.getEmailAddress());
        MailBox ma3 = new MailBox(c2.getEmailAddress());

        Manager m1= new Manager(ma1);

        m1.addToBox(ma2);
        m1.addToBox(ma3);
        m1.send(e1);

        //corroboramos que el email esta cada bandeja 
        assertEquals(e1,m1.getFromBox().getTrays().getOutbox().get(0));

        assertEquals(e1,m1.getToBox().get(0).getTrays().getInbox().get(0));

        assertEquals(e1,m1.getToBox().get(1).getTrays().getInbox().get(0));
        
        
    
    
    }


    @Test
    public void ManagercreateAndAddMailBoxes(){
         
        Contact remitente = new Contact("Juan", "martinez", "Stiven22@gmail.com");
        Contact c1 = new Contact("Alejo", "Espinoza", "alejoEs@gmai.com");
        Contact c2 = new Contact("Yanileth", "Fontalvo", "YanilethFon@gmail.com");
        Email e1 = new Email(remitente,c1);
     
        e1.setSubject("saludo");
        e1.setContent("hola");
        e1.addTo(c2);

        MailBox ma1 = new MailBox(remitente.getEmailAddress());
        Manager m1= new Manager(ma1);

        m1.createAndAddMailBoxes(e1);

        //corroboramos que cada mailBox se creo con el email asociado correcto
         assertEquals("Stiven22@gmail.com",m1.getFromBox().getEmailAddress());

        assertEquals("alejoEs@gmai.com",m1.getToBox().get(0).getEmailAddress());

        assertEquals("YanilethFon@gmail.com",m1.getToBox().get(1).getEmailAddress());

        
        
    
    
    }
}
