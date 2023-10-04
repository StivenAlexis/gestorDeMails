package gestor;

import java.util.ArrayList;



public class Manager {
    
    public MailBox senderBox;
    public ArrayList<MailBox> ToBox = new ArrayList<>();


    public Manager(MailBox m1){
        senderBox= m1;
        
    }

    public ArrayList<MailBox> converter(Email email){
        for (Contact contacto : email.to) {
        ToBox.add(new MailBox(contacto.getEmailAddress()));
        }
           
        return ToBox;
        
    }
    

    public void send(Email email){
       senderBox.trays.Outbox.add(email);
       for (MailBox mailbox : ToBox) {
        mailbox.trays.Inbox.add(email);
        }
    
    }
       
       



}
