package gestor;

import java.util.ArrayList;



public class Manager {
    
    private MailBox fromBox;
    private ArrayList<MailBox> ToBox = new ArrayList<>();
    

    private ArrayList<MailBox> Boxes = new ArrayList<>();

        
    public Manager(ArrayList<MailBox> mailBoxes){
            
        setBoxes(mailBoxes);
        
    }

    public ArrayList<MailBox> getToBox() {
    
        return ToBox;
    }
    
    public void setToBox(ArrayList<MailBox> toBox) {
        ToBox = toBox;
    }

    public void addToBox(MailBox mailbox) {
        ToBox.add(mailbox);
    }

    public ArrayList<MailBox> sort(Email email) {
        ArrayList<MailBox> temporalList = new ArrayList<>();
        
            // Verificar si un MailBox con la misma dirección de correo electrónico ya existe en ToBox
            for (MailBox mailbox : Boxes) {
                if (mailbox.getEmailAddress().equals(email.getFrom().getEmailAddress())) {
                    setFromBox(mailbox);
                }
            }

            for (Contact contacto : email.getTo()) {
            String emailAddress = contacto.getEmailAddress();

                for (MailBox mailbox : Boxes) {
                    if (mailbox.getEmailAddress().equals(emailAddress)) {
                    
                    temporalList.add(mailbox);

                    }
                }
            }
            ToBox.clear();
            ToBox.addAll(temporalList);


        return getToBox();
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
        
        this.fromBox = fromBox;
        }
    
    

    public ArrayList<MailBox> getBoxes() {
        return Boxes;
    }

    public void setBoxes(ArrayList<MailBox> boxes) {
        if (boxes==null) {
            throw new IllegalArgumentException("Este campo es obligatorio");
        }else{
        Boxes = boxes;
        }
    }



}
  



