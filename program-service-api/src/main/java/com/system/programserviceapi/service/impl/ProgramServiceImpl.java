package com.system.programserviceapi.service.impl;

import com.system.programserviceapi.dto.ProgramDto;
import com.system.programserviceapi.dto.request.RequestProgramDto;
import com.system.programserviceapi.entity.Program;
import com.system.programserviceapi.repo.ProgramRepo;
import com.system.programserviceapi.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepo programRepo;
    @Override
    public void createProgram(RequestProgramDto requestProgramDto) {

//        {
//            "name":"Full Stack Development Program",
//                "price":50000,
//                "startDate":"2024-05-01",
//                "subjects":[
//            {"id":1,"name":"Java"},
//            {"id":2,"name":"Html"},
//            {"id":3,"name":"Css"},
//            {"id":4,"name":"Php"}
//    ]
//        }

        Program program = Program.builder()
                .name(requestProgramDto.getName())
                .price(requestProgramDto.getPrice())
                .startDate(requestProgramDto.getStartDate())
                .subjects(requestProgramDto.getSubjects())
                .build();
        programRepo.save(program);
    }
}
