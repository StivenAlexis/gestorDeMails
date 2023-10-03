package gestor;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact{

    //var
    private String name= "";
    private String emailAddress= "";  
    private String lastName = "";
    

    //function, procedure and contructors
    public Contact (String name, String lastName, String emailAddress) {
        this.name = name;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        
    }

    public Contact ( String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

     public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public boolean isValidMail(String mail) {
        
        String patronMail = "^[A-Za-z0-9+_.-]+@(.+)$";
        
        Pattern pattern = Pattern.compile(patronMail);
        
        Matcher matcher = pattern.matcher(mail);

        return matcher.matches();
    }





}