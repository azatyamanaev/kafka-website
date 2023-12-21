package ru.kfu.kafkaWebSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
