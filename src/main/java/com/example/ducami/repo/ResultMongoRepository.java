package com.example.ducami.repo;

import com.example.ducami.dto.StudentScore;
import com.example.ducami.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultMongoRepository extends MongoRepository<StudentScore,Long> {
}
