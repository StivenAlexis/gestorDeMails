package gestor;

import java.util.ArrayList;

public class Tray {

    private ArrayList<Email> Inbox = new ArrayList<>();
    
    private ArrayList<Email> Outbox = new ArrayList<>();

    public ArrayList<Email> getInbox() {
        return Inbox;
    }
    
    public void addInbox(Email email) {
        Inbox.add(email);
    }
   
    public ArrayList<Email> getOutbox() {
        return Outbox;
    }
    public void addOutbox(Email email) {
        Outbox.add(email);
    }
}
