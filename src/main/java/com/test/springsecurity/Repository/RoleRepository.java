package com.test.springsecurity.Repository;

import com.test.springsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("SELECT Role FROM Role WHERE Role.name like %?1")
    Role findByName(String name);
}
