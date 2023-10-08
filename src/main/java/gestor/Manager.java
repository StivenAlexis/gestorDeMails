package gestor;

import java.util.ArrayList;



public class Manager {
    
    private MailBox fromBox;
    private ArrayList<MailBox> ToBox = new ArrayList<>();

        public Manager(MailBox m1){
        
        setFromBox(m1);
        
    }

    public ArrayList<MailBox> getToBox() {
        return ToBox;
    }

    public void addToBox(MailBox mailbox) {
        ToBox.add(mailbox);
    }

    public ArrayList<MailBox> createAndAddMailBoxes(Email email){
        for (Contact contacto : email.getTo()) {
  
            addToBox(new MailBox(contacto.getEmailAddress())); 
        
        }

        return ToBox;
        
    }
    
    public void send(Email email){
       getFromBox().getTrays().addOutbox(email);
       for (MailBox mailbox : ToBox) {
        mailbox.getTrays().addInbox(email);
        }
     
    }
     
    public MailBox getFromBox() {
        return fromBox;
    }

    public void setFromBox(MailBox fromBox) {
        if (fromBox==null) {
            throw new IllegalArgumentException("Este campo es obligatorio");
        }else{
        this.fromBox = fromBox;
        }
    
    }

    /* 
    public boolean exists(String emailAddress) {
        for (MailBox mailBox : ToBox) {
            if (mailBox.getEmailAddress().equals(emailAddress)) {
                return true;
            }
        }

        return false;
    }
       */



}
