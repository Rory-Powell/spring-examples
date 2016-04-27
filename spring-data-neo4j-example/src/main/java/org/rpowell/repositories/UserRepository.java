package org.rpowell.repositories;

import org.rpowell.domain.User;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GraphRepository<User> {

    /**
     * This method will find an {@link User} instance in the database by its first name.
     *
     * It is not implemented, its working code will be automatically generated from its
     * signature by Spring Data.
     *
     * The @param tag is used to match to the field in the {@link User} domain object
     *
     * The @param tag can be excluded if the parameter matches the field already but it
     * is good practice to leave it in in case of future modifications.
     */
    User findByFirstName(@Param("firstName") String first);

    User findByLastName(@Param("lastName") String last);

    User findByEmail(@Param("email") String email);
}

