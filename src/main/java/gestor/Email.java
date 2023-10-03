package gestor;
import java.util.ArrayList;


public class Email {
    public ArrayList<Contact> to = new ArrayList<>();
    public Contact sender;
    public String subject = "";
    public String content = "";
    
    
    public Email(Contact sender , Contact FirstTo) {
        this.sender= sender;
        to.add(FirstTo);
    }

    

}
