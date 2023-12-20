package ru.kfu.kafkaWebSite.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kfu.kafkaWebSite.dto.UserSignUpDto;
import ru.kfu.kafkaWebSite.mappers.UserMapper;
import ru.kfu.kafkaWebSite.model.User;
import ru.kfu.kafkaWebSite.repository.UserRepository;
import ru.kfu.kafkaWebSite.service.UserService;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public void signUpUser(UserSignUpDto userDto, User.Role role) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new EntityExistsException("Пользователь с такой почтой уже существует");
        }
        if (!userDto.getPassword().equals(userDto.getRepeatPassword())) {
            throw new IllegalArgumentException("Пароли не совпадают");
        }
        User user = userMapper.toUser(userDto);
        user.setRole(role);
        user.setPasswordHash(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
