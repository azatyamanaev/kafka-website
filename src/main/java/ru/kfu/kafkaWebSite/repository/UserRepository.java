package ru.kfu.kafkaWebSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
