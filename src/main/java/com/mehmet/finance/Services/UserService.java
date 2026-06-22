package com.mehmet.finance.Services;

import com.mehmet.finance.Entities.User;
import com.mehmet.finance.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı! ID: " + id));
    }
}
