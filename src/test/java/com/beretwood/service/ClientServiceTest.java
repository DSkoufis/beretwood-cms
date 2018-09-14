package com.beretwood.service;

import com.beretwood.domain.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class ClientServiceTest {

    private ClientService service;

    public static @DataPoints
    String[] emptyStringParameters = {"", "  "};

    @Before
    public void setup() {
        service = new ClientService();
    }

    @Test
    public void createsNewClientWithLowerCaseEmail() {
        String email = "newClient";

        Client client = service.createClient(email);
        assertTrue(email.equalsIgnoreCase(client.getEmail()));
    }

    @Theory
    @Test(expected = IllegalArgumentException.class)
    public void passingAnEmptyStringThrowsAnException(String param) {
        service.createClient(param);
    }

    @Test
    public void trimsTheEmailBeforeCreatingTheClient() {
        String email = " withTrailingSpaces  ";

        Client client = service.createClient(email);
        assertTrue(email.trim().equalsIgnoreCase(client.getEmail()));
    }

    @Test
    public void turnsTheEmailIntoLowerCaseBeforeAssigningIt() {
        String email = "camelCase";

        Client client = service.createClient(email);
        assertEquals("camelcase", client.getEmail());
    }
}
