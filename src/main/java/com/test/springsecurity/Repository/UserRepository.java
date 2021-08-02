package com.test.springsecurity.Repository;

import com.test.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select User from User where User.email = ?1")
    User findByEmail(String email);
}
