package com.wgcisotto.database;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DatabaseAccessTest {

    @Mock
    private Database database;

    private Credentials credentials = Credentials.builder().username("user").password("password").build();

    @Test
    void testUserSuccessfukLogin(){
        when(database.login(credentials)).thenReturn(true);
        Credentials saneCredentials = Credentials.builder().username("user").password("password").build();
        assertTrue(database.login(saneCredentials));
    }


    @Test
    void testUserFailedLogin(){
//        when(database.login(credentials)).thenReturn(true);
        Credentials otherCredentials = Credentials.builder().username("user").password("password").build();
        otherCredentials.setUsername("other");
        otherCredentials.setPassword("other");
        assertNotEquals(credentials.getUsername(), otherCredentials.getUsername());
        assertNotEquals(credentials.getPassword(), otherCredentials.getPassword());
        assertNotEquals(credentials.hashCode(), otherCredentials.hashCode());
        assertFalse(database.login(otherCredentials));
    }

}
