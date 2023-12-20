package ru.kfu.kafkaWebSite.service;

import ru.kfu.kafkaWebSite.dto.UserSignUpDto;
import ru.kfu.kafkaWebSite.model.User;

import java.util.Optional;

public interface UserService {

    void signUpUser(UserSignUpDto userDto, User.Role role);
    Optional<User> findUserByEmail(String email);
}
