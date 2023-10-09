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
        return email -> email.getTo().stream().anyMatch(contact -> contact.getEmailAddress().equals(addressee));
    }


    public static Predicate<Email> FindASenderWhithASubject(String sender,String subject) {
        Predicate<Email> senderPredicate = FindASender(sender);
        Predicate<Email> subjectPredicate = SearchTheSubject(subject);

        return senderPredicate.and(subjectPredicate);
    }

    public static Predicate<Email> FindASenderWhithASubjectAndContent(String sender, String subject,String content) {
        Predicate<Email> senderPredicate = FindASender(sender);
        Predicate<Email> subjectPredicate = SearchTheSubject(subject);
        Predicate<Email> contentPredicate = SearchTheContent(content);

        return senderPredicate.and(subjectPredicate).and(contentPredicate);
    }

    public static Predicate<Email> FindAAddresseeWhithASubject(String addressee,String subject) {
        Predicate<Email> addresseePredicate = FindAAddresse(addressee);
        Predicate<Email> subjectPredicate = SearchTheSubject(subject);

        return addresseePredicate.and(subjectPredicate);
    }

}    


    

    
