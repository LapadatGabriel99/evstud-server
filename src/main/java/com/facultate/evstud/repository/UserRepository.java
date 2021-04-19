package com.facultate.evstud.repository;

import com.facultate.evstud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query(value = "SELECT * FROM user, role WHERE user.role_id = role.role_id AND role.role_name = ?1",
            nativeQuery = true)
    List<User> findAllByRole(String roleName);
}
