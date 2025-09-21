package com.HealthCare.Management.Service;

import com.HealthCare.Management.Entity.User;
import com.HealthCare.Management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user){
        return userRepository.save(user);
    }
    @Override
    public User validateUser(String userName, String password){
        return userRepository.findByUserNameAndPassword(userName,password);
    }
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
