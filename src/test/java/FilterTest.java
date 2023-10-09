import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import gestor.Contact;
import gestor.Email;
import gestor.Filter;
import gestor.MailBox;
import gestor.Manager;

public class FilterTest {
    
     @Test
    public void ManagercreateAndAddMailBoxes(){
         
        Contact c1 = new Contact("Stiven22@gmail.com");
        Contact c2 = new Contact("alejoEs@gmai.com");
        Contact c3 = new Contact("YanilethFon@gmail.com");
        Email e1 = new Email(c2,c3);

     
        e1.setSubject("Importante");
        e1.setContent("alerta");
        e1.addTo(c1);
        
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
        m1.send(e1);
        

        List<Email> filteredEmails = Filter.filterEmails(ma1.getTrays().getInbox(), Filter.SearchTheSubject("Importante"));

        assertEquals(2,filteredEmails.size());
    
    
    }
    
}

