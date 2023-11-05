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
    public void SearchTheSubjectTest(){
         
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
        
        

        List<Email> filteredEmails = Filter.filterEmails(ma1.getTrays().getInbox() , Filter.SearchTheSubject("Importante"));

        assertEquals(1,filteredEmails.size());
    
    
    }

    @Test
    public void SearchTheContentTest(){
         
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
        
        

        List<Email> filteredEmails = Filter.filterEmails(ma1.getTrays().getInbox() , Filter.SearchTheContent("alert"));

        assertEquals(1,filteredEmails.size());
    }

    @Test
    public void FindASenderTest(){
         
        Contact c1 = new Contact("Stiven22@ucp.com");
        Contact c2 = new Contact("alejoEs@ucp.com");
        Contact c3 = new Contact("YanilethFon@ucp.com");
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
        
        

        List<Email> filteredEmails = Filter.filterEmails(ma1.getTrays().getInbox() , Filter.FindASender("alejoEs@ucp.com"));

        assertEquals(1,filteredEmails.size());
    
    
    }

    @Test
    public void FindAAddresseeTest(){
         
        Contact c1 = new Contact("Stiven22@ucp.com");
        Contact c2 = new Contact("alejoEs@ucp.com");
        Contact c3 = new Contact("YanilethFon@ucp.com");
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
        
        List<Email> filteredEmails = Filter.filterEmails(ma1.getTrays().getInbox() , Filter.FindAAddresse("Stiven22@ucp.com"));

        assertEquals(1,filteredEmails.size());
    }

    
    @Test
    public void FindASenderWhithASubjectAndContentTest(){
         
        Contact c1 = new Contact("Stiven22@ucp.com");
        Contact c2 = new Contact("alejoEs@ucp.com");
        Contact c3 = new Contact("YanilethFon@ucp.com");
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
        
        List<Email> filteredEmails = Filter.filterEmails(ma1.getTrays().getInbox() , Filter.FindASenderWhithASubjectAndContent("alejoEs@ucp.com", "Importante","alerta"));

        assertEquals(1,filteredEmails.size());
    
    
    }

     @Test
    public void FindASenderWhithASubjectTest(){
         
        Contact c1 = new Contact("Stiven22@ucp.com");
        Contact c2 = new Contact("alejoEs@ucp.com");
        Contact c3 = new Contact("YanilethFon@ucp.com");
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
        
        List<Email> filteredEmails = Filter.filterEmails(ma1.getTrays().getInbox() , Filter.FindASenderWhithASubject("alejoEs@ucp.com", "Importante"));

        assertEquals(1,filteredEmails.size());
    
    }

     @Test
    public void FindAAddresseeWhithASubjectTest(){
         
        Contact c1 = new Contact("Stiven22@ucp.com");
        Contact c2 = new Contact("alejoEs@ucp.com");
        Contact c3 = new Contact("YanilethFon@ucp.com");
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
        
        List<Email> filteredEmails = Filter.filterEmails(ma1.getTrays().getInbox() , Filter.FindAAddresseeWhithASubject("Stiven22@ucp.com","Impor"));

        assertEquals(1,filteredEmails.size());
    }

    @Test
    public void FinalTest(){
        
    ArrayList<Email> emails = new ArrayList<>();
        Contact c1 = new Contact("Stiven@ucp.com");
        Contact c2 = new Contact("alejoEs@ucp.com");

        for (int i = 0; i <50; i++) {

            emails.add( new Email(c1,c2));     
            emails.get(i).setSubject("success");

        } 

        for (int i= 0 ; i <51; i++) {

            emails.add( new Email(c1,c2));     
            emails.get(i).setSubject("desaprobado");
            
        } 

        
        assertEquals(101,emails.size());
        

       

        List<Email> filteredEmails = Filter.filterEmails(emails , Filter.FindASenderWhithASubject("Stiven@ucp.com","desaprobado"));
        
        assertEquals(51,filteredEmails.size());

        
       

       

        
        /* 
        MailBox ma1 = new MailBox(c1.getEmailAddress());
        MailBox ma2 = new MailBox(c2.getEmailAddress());
        

        ArrayList<MailBox> mailBoxes = new ArrayList<MailBox>();
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
        */
    }

    private void asserEquals(String string, String subject) {
    }

    
    
}
    

