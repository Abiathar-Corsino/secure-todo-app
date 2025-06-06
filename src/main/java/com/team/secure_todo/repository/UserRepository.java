package com.team.secure_todo.repository;

import com.team.secure_todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends Jpa Repository<User, Long> {
    Optional<User> findByEmail(String email);
}

