package gestor;
import java.util.ArrayList;


public class Email {


    private ArrayList<Contact> to = new ArrayList<>();
    
    private Contact from;
    
    private String subject = "";
    private String content = "";
    

    public Email(Contact from, Contact FirstTo) {
        this.setFrom(from);
        addTo(FirstTo);
        
    }

     public ArrayList<Contact> getTo() {
        return to;
    }

    public void addTo(Contact to) {
        if (to == null) {
            throw new IllegalArgumentException("Estos campos son obligatorios");
        }else{
        this.to.add(to);
       }
    }    

    public Contact getFrom() {
        return from;
    }

    public void setFrom(Contact from) {
        if (from == null ) {
            throw new IllegalArgumentException("Estos campos son obligatorios");
        }else{
        this.from = from;
        }
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
