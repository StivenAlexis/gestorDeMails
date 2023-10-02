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

    
    public boolean esCorreoValido(String correo) {
        // Patrón de expresión regular para verificar un correo electrónico válido
        String patronCorreo = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Compilar el patrón
        Pattern pattern = Pattern.compile(patronCorreo);

        // Crear un objeto Matcher
        Matcher matcher = pattern.matcher(correo);

        // Verificar si el correo coincide con el patrón
        return matcher.matches();
    }



}