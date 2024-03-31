package org.example.accounts;

import org.example.repository.UserRepository;

public class UserService {

    private UserRepository repository;

    public UserService() {
        this.repository = new UserRepository();
    }

    public void AddNewUser(User user) {
        repository.createUser(user);
    }

    public User getUserByLogin(String login) {
        return repository.getUser(login);
    }
}
