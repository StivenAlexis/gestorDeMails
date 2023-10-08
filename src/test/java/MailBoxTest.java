

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import gestor.MailBox;



public class MailBoxTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void MailBoxNotNullTest(){
               
        MailBox m1 = new MailBox("demo@ucp.con");
        MailBox m2 = new MailBox("demo@ucp.con");

        assertNotNull(m1);
        assertNotNull(m2);
      
    
    }

    @Test
    public void MailBoxNullTest(){
        
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Este campo es obligatorio");
        MailBox m1= new MailBox(null);

        assertNotNull(m1);
    
    }

 


}
