package com.example.ducami.repo;

import com.example.ducami.dto.StudentScore;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultMongoRepository extends MongoRepository<StudentScore,Long> {
}
