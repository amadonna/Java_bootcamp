package edu.school21.services;

import edu.school21.models.User;
import edu.school21.repositories.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UsersServiceImplTest {
    UsersRepository usersRepository;
    UsersServiceImpl usersService;
    @BeforeEach
    public void setUp() {
        usersRepository = mock(UsersRepository.class);
        usersService = new UsersServiceImpl(usersRepository);
    }

    @Test
    public void testAuthenticateCorrectPassword() {
        User user = new User(1L, "TestLogin", "12345", false);
        when(usersRepository.finByLogin("TestLogin")).thenReturn(user);
        boolean result = usersService.authenticate("TestLogin", "12345");
        Assertions.assertTrue(result);
        Assertions.assertTrue(user.isAuthStatus());
        verify(usersRepository, times(1)).update(user);
    }
    @Test
    public void testAuthenticateIncorrectPassword() {
        User user = new User(1L, "TestLogin", "12345", false);
        when(usersRepository.finByLogin("TestLogin")).thenReturn(user);
        boolean result = usersService.authenticate("TestLogin", "23456");
        Assertions.assertFalse(result);
        Assertions.assertFalse(user.isAuthStatus());
    }
    @Test
    public void testAuthenticateIncorrectLogin() {
        User user = new User(1L, "TestLogin", "12345", false);
        when(usersRepository.finByLogin("TestLogin_")).thenReturn(user);
        boolean result = usersService.authenticate("TestLogin_", "23456");
        Assertions.assertFalse(result);
        Assertions.assertFalse(user.isAuthStatus());
    }

}
