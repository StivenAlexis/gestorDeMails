package gestor;

public class MailBox {

private String emailAddress;

private Tray trays = new Tray();

    public MailBox(String emailAddress){

        this.setEmailAddress(emailAddress);
    }
  
        
    public String getEmailAddress() {
        return emailAddress;
    }


    public void setEmailAddress(String emailAddress) {
        
            if (emailAddress==null) {
                throw new IllegalArgumentException("Este campo es obligatorio");
            }else{
            this.emailAddress = emailAddress;
            }
    }


    public Tray getTrays() {
    return trays;
    }

    public void setTrays(Tray trays) {
        this.trays = trays;
    }

   
}
