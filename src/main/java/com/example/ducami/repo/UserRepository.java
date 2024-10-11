package com.example.ducami.repo;

import com.example.ducami.entity.User;
import com.example.ducami.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsernameAndPasswordAndAuthority(String username, String password, UserType authority);
    boolean existsByUsernameAndPasswordAndAuthorityAndGradeAndClsAndNumAndName(String username, String password, UserType authority, Integer grade, Integer cls, Integer num, String name);
}
