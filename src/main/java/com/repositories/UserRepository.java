package com.repositories;

import com.models.User;
import com.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findOneByUsername(String username);

    List<User> findAllByOrderByIdDesc();

    @Transactional
    @Modifying
    @Query("update User u set u.enable = ?2 where u.id = ?1")
    void enabled(Integer id, boolean enabled);

    @Transactional
    @Modifying
    @Query("update User u set u.role = ?2 where u.id = ?1")
    void promote(Integer id, UserRole role);
}
