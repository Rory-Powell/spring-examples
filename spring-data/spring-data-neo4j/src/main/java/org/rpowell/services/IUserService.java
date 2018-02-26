package org.rpowell.services;

import org.rpowell.domain.User;

public interface IUserService {

    User getUserByEmail(String email);

    void deleteUser(String email);

    void updateUser(String email, User updatedUser);

    void createUser(String firstName, String lastName, String email);

    void addFriendship(String email1, String email2);
}
