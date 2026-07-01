package com.mehmet.finance.services;

import com.mehmet.finance.entities.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
}
