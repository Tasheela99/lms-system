package com.system.subjectserviceapi.service.impl;

import com.system.subjectserviceapi.dto.request.RequestSubjectDto;
import com.system.subjectserviceapi.dto.request.response.ResponseSubjectDto;
import com.system.subjectserviceapi.entity.Subject;
import com.system.subjectserviceapi.repo.SubjectRepo;
import com.system.subjectserviceapi.service.SubjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepo subjectRepo;
    @Override
    public void createSubject(RequestSubjectDto requestSubjectDto) {
        Subject subject = Subject.builder()
                .name(requestSubjectDto.getName())
                .status(requestSubjectDto.isStatus())
                .build();
        subjectRepo.save(subject);
    }

    public boolean isListAvailable(List<Long> ids){
        for (Subject subject : subjectRepo.findAllById(ids)){
            if (!subject.isStatus()){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<ResponseSubjectDto> getAllSubjects() {
        List<Subject> all = subjectRepo.findAll();
        List<ResponseSubjectDto> responseSubjectDtoList = new ArrayList<>();
        for (Subject subject : all){
            responseSubjectDtoList.add(
                    new ResponseSubjectDto(
                            subject.getId(),
                            subject.getName(),
                            subject.isStatus()
                    )
            );
        }
        return responseSubjectDtoList;
    }
}
