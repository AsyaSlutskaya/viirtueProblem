package atsign;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueEmailsTest {

    @Test
    public void getUniqueEmails() {
        String[] str = {"test.email+alex@viirtue.com", "test.e.mail+bob.cathy@viirtue.com", "testemail+david@viir+tue.com"};
        int uniqueEmailsCnt = new UniqueEmails().getUniqueEmails(str);

        assertEquals(2, uniqueEmailsCnt);
    }

    @Test
    public void getUniqueEmailsEmptyList() {
        String[] str = {};
        int uniqueEmailsCnt = new UniqueEmails().getUniqueEmails(str);

        assertEquals(0, uniqueEmailsCnt);
    }

    @Test
    public void cleanEmailEmpty() {
        assertEquals("", new UniqueEmails().cleanEmail(""));
    }

    @Test
    public void cleanEmailWithoutDot() {
        assertEquals("ab@gmail.com", new UniqueEmails().cleanEmail("ab@gmail.com"));
    }

    @Test
    public void cleanEmailWithDot() {
        assertEquals("ab@gmail.com", new UniqueEmails().cleanEmail("a.b@gmail.com"));
    }

    @Test
    public void cleanEmailWithPlus() {
        assertEquals("my@email.com", new UniqueEmails().cleanEmail("m.y+name@email.com"));
    }

    @Test
    public void cleanEmailWithDots() {
        assertEquals("testemail@viirtue.com", new UniqueEmails().cleanEmail("test..e..mail.+bob.cathy@viirtue.com"));
    }
}