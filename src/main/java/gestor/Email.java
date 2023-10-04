package gestor;
import java.util.ArrayList;


public class Email {


    private ArrayList<Contact> to = new ArrayList<>();
    

    private Contact sender;
    
    private String subject = "";
    private String content = "";
    

    public Email(Contact sender, Contact FirstTo) {
        if (sender == null || FirstTo == null) {
            throw new IllegalArgumentException("Los argumentos 'sender' y 'FirstTo' no pueden ser nulos.");
        }
        this.sender = sender;
        to.add(FirstTo);
    }

     public ArrayList<Contact> getTo() {
        return to;
    }

    public void setTo(Contact to) {
        this.to.add(to);
    }    

    public Contact getSender() {
        return sender;
    }

    public void setSender(Contact sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
