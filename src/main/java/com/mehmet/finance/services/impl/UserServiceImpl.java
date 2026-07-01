package com.mehmet.finance.services.impl;

import com.mehmet.finance.entities.User;
import com.mehmet.finance.exception.ResourceNotFoundException;
import com.mehmet.finance.repositories.UserRepository;
import com.mehmet.finance.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kullanici bulunamadi."));
    }

}
