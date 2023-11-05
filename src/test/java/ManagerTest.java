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
        MailBox ma2 = new MailBox(c1.getEmailAddress());

        ArrayList<MailBox> mailBoxes = new ArrayList<MailBox>();
        mailBoxes.add(ma1);
        mailBoxes.add(ma2);

        Manager m1= new Manager(mailBoxes);

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
         
        Contact c1 = new Contact("Stiven22@gmail.com");
        Contact c2 = new Contact("alejoEs@gmai.com");
        Contact c3 = new Contact("YanilethFon@gmail.com");
        Email e1 = new Email(c1,c2);
        Email e2 = new Email(c2,c3);

        e1.setSubject("saludo");
        e1.setContent("hola");
        e1.addTo(c3);

        e2.setSubject("importante");
        e2.setContent("alerta");
        e2.addTo(c1);
        
        MailBox ma1 = new MailBox(c1.getEmailAddress());
        MailBox ma2 = new MailBox(c2.getEmailAddress());
        MailBox ma3 = new MailBox(c3.getEmailAddress());

        ArrayList<MailBox> mailBoxes = new ArrayList<MailBox>();
        mailBoxes.add(ma3);
        mailBoxes.add(ma1);
        mailBoxes.add(ma2);

        Manager m1= new Manager(mailBoxes);

        m1.sort(e1);
        m1.send(e1);
        
        //corroboramos que el email esta cada bandeja

        assertEquals(e1,ma1.getTrays().getOutbox().get(0));

        assertEquals(e1,ma2.getTrays().getInbox().get(0));

        assertEquals(e1,ma3.getTrays().getInbox().get(0));

        m1.sort(e2);
        m1.send(e2);
        

        //corroboramos que el email esta cada bandeja 
        
        assertEquals(e2,ma2.getTrays().getOutbox().get(0));

        assertEquals(e2,ma1.getTrays().getInbox().get(0));

        assertEquals(e2,ma3.getTrays().getInbox().get(1));
    
    }


    @Test
    public void sortTest(){
         
        Contact remitente = new Contact("Juan", "martinez", "Stiven22@gmail.com");
        Contact c1 = new Contact("Alejo", "Espinoza", "alejoEs@gmai.com");
        Contact c2 = new Contact("Yanileth", "Fontalvo", "YanilethFon@gmail.com");
        Email e1 = new Email(remitente,c1);
     
        e1.setSubject("saludo");
        e1.setContent("hola");
        e1.addTo(c2);

        MailBox ma1 = new MailBox(remitente.getEmailAddress());
        MailBox ma2 = new MailBox(c1.getEmailAddress());
        MailBox ma3 = new MailBox(c2.getEmailAddress());

        ArrayList<MailBox> mailBoxes = new ArrayList<MailBox>();
        mailBoxes.add(ma1);
        mailBoxes.add(ma2);
        mailBoxes.add(ma3);

        Manager m1= new Manager(mailBoxes);

        m1.sort(e1);
        

        //corroboramos que cada mailBox se creo con el email asociado correcto
        assertEquals("Stiven22@gmail.com",m1.getFromBox().getEmailAddress());

        assertEquals("alejoEs@gmai.com",m1.getToBox().get(0).getEmailAddress());

        assertEquals("YanilethFon@gmail.com",m1.getToBox().get(1).getEmailAddress());

        
        
    
    
    }


   
}
