package gestor;



public class Contact{

    //var
    private String name= "";
    private String emailAddress= "";  
    private String lastName = "";


    //function, procedure and contructors
    public Contact (String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.emailAddress = email;
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



}