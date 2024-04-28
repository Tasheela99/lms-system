package com.system.programserviceapi.repo;

import com.system.programserviceapi.entity.Program;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgramRepo extends MongoRepository<Program, String> {
}
