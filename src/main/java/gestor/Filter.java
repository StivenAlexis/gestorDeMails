package gestor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

List<Email> emails = new ArrayList<>();

   public static List<Email> filterEmails(ArrayList<Email> emails, Predicate<Email> filter) {
        return emails.stream()
            .filter(filter)
            .collect(Collectors.toList());
    }

    // Example filter methods
    public static Predicate<Email> SearchTheSubject(String subject) {
        return email -> email.getSubject().contains(subject);
    }

    public static Predicate<Email> SearchTheContent(String content) {
        return email -> email.getContent().contains(content);
    }

    public static Predicate<Email> FindASender(String sender) {
        return email -> email.getFrom().getEmailAddress().equals(sender);
    }

    public static Predicate<Email> FindAAddresse(String addressee) {
        return email -> email.getTo().iterator().next().getEmailAddress().equals(addressee);
    }


 
}


    

    
