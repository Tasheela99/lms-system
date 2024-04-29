package com.system.subjectserviceapi.service;

import com.system.subjectserviceapi.dto.request.RequestSubjectDto;
import com.system.subjectserviceapi.dto.request.response.ResponseSubjectDto;

import java.util.List;

public interface SubjectService {
    void createSubject(RequestSubjectDto requestSubjectDto);

    public boolean isListAvailable(List<Long> ids);

    List<ResponseSubjectDto> getAllSubjects();
}
