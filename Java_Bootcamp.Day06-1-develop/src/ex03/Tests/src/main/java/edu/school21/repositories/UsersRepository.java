package edu.school21.repositories;

import edu.school21.models.User;

public interface UsersRepository {
    User finByLogin(String login);
    void update(User user);
}
