package com.test.springsecurity.Service;

import com.test.springsecurity.Repository.RoleRepository;
import com.test.springsecurity.Repository.UserRepository;
import com.test.springsecurity.entity.Role;
import com.test.springsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public void register(String email, String password) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        if (email.contains("admin")) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            user.setRoles(roles);
        } else {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
        }
        userRepository.save(user);

    }
}
