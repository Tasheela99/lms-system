package com.system.subjectserviceapi.controller;

import com.system.subjectserviceapi.dto.request.RequestSubjectDto;
import com.system.subjectserviceapi.service.SubjectService;
import com.system.subjectserviceapi.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<StandardResponse> createSubject(
            @RequestBody RequestSubjectDto requestSubjectDto
            ){
        subjectService.createSubject(requestSubjectDto);
        return new ResponseEntity<>(
                new StandardResponse(
                        201,"Subject Saved",requestSubjectDto.getName()
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{ids}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isListAvailable(@PathVariable List<Long> ids){
        return subjectService.isListAvailable(ids);
    }

    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllSubjects(){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,"Subjects",
                        subjectService.getAllSubjects()
                ), HttpStatus.OK
        );
    }


}
