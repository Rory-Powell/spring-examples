package org.rpowell.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import java.util.*;

@NodeEntity
public class User {

    @GraphId
    private Long id;

    @Property
    private String firstName;

    @Property
    private String lastName;

    @Property
    private String email;

    @Relationship(type = "Friend", direction = Relationship.UNDIRECTED)
    private List<User> friends = new ArrayList<>();

    // For use by spring data
    protected User() {}

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addFriend(User user) {
        this.friends.add(user);
    }

    public void addFriends(List<User> users) {
        this.friends.addAll(users);
    }

    public List<User> getFriends() {
        return this.friends;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, firstName='%s', lastName='%s', email='%s']",
                                    id, firstName, lastName, email);
    }

}

