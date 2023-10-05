package gestor;

import java.util.ArrayList;



public class Manager {
    
    public MailBox fromBox;
    public ArrayList<MailBox> ToBox = new ArrayList<>();


    public Manager(MailBox m1){
        
        setfromBox(m1);
        
    }

    public ArrayList<MailBox> converter(Email email){
        for (Contact contacto : email.getTo()) {
        ToBox.add(new MailBox(contacto.getEmailAddress()));
        }
           
        return ToBox;
        
    }
    
    public void send(Email email){
       fromBox.trays.Outbox.add(email);
       for (MailBox mailbox : ToBox) {
        mailbox.trays.Inbox.add(email);
        }
     
    }
     
    public MailBox getfromBox() {
        return fromBox;
    }

    public void setfromBox(MailBox fromBox) {
        if (fromBox==null) {
            throw new IllegalArgumentException("Este campo es obligatorio");
        }else{
        this.fromBox = fromBox;
        }
    }

       



}
