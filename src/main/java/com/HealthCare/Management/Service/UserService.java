package com.HealthCare.Management.Service;


import com.HealthCare.Management.Entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    User save(User user);
    User validateUser(String userName, String password);
    Optional<User> findById(Long id);
}
