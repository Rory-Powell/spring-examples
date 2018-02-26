package org.rpowell;

import org.rpowell.domain.User;
import org.rpowell.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;
import org.springframework.util.Assert;

import java.io.IOException;

@Import(AppConfiguration.class)
public class App implements CommandLineRunner {

    @Autowired
    IUserService userService;


    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Override
    public void run(String... args) throws Exception {

        log.info("Started Application");

        // Testing the db
        String first = "first";
        String last = "last";
        String email = "Email";

        // Creation
        userService.createUser(first, last, email);

        // Read
        User user = userService.getUserByEmail(email);
        Assert.notNull(user);
        Assert.isTrue(user.getEmail().equals(email));
        Assert.isTrue(user.getFirstName().equals(first));
        Assert.isTrue(user.getLastName().equals(last));

        // Read
        Assert.isNull(userService.getUserByEmail("incorrect_email"));

        // Update
        User updatedUser = new User(first, "last1", "email1");
        userService.updateUser(email, updatedUser);

        updatedUser = userService.getUserByEmail("email1");
        Assert.isTrue(updatedUser.getFirstName().equals(first));
        Assert.isTrue(updatedUser.getLastName().equals("last1"));

        // Add friend
        userService.createUser(first, "last2", "email2");
        userService.addFriendship("email1", "email2");
        Assert.isTrue(userService.getUserByEmail("email1").getFriends().size() > 0);

        // Delete
        userService.deleteUser("email1");
        Assert.isNull(userService.getUserByEmail("email1"));

        // Delete
        userService.deleteUser("email2");
        Assert.isNull(userService.getUserByEmail("email2"));
    }
}