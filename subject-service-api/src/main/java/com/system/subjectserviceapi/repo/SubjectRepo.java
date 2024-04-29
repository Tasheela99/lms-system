package com.system.subjectserviceapi.repo;

import com.system.subjectserviceapi.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
    List<Subject> findByIdIn(List<Long> ids);
}
