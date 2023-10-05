package gestor;



public class Contact{

    //var
    private String name= "";
    private String emailAddress= "";  
    private String lastName = "";
    

    //function, procedure and contructors
    public Contact (String name, String lastName, String emailAddress) {
        this.setName(name);
        this.setLastName(lastName);
        this.setEmailAddress(emailAddress);
    }

    public Contact ( String emailAddress) {
        this.setEmailAddress(emailAddress);
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
        if (!isValidMail(emailAddress)) {
            throw new IllegalArgumentException("El correo electrónico no es válido");
        }
        // Establecer el correo electrónico solo si es válido
        this.emailAddress = emailAddress;
    }
    

     public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public boolean isValidMail(String mail) {
        
        
        return mail.contains("@") && mail.contains(".");
    
    }






}