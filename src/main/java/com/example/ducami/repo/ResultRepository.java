package com.example.ducami.repo;

import com.example.ducami.entity.Result;
import com.example.ducami.entity.User;
import com.example.ducami.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Long> {
}
