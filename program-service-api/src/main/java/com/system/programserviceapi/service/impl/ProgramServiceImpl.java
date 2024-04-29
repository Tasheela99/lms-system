package com.system.programserviceapi.service.impl;

import com.system.programserviceapi.dto.ProgramDto;
import com.system.programserviceapi.dto.request.RequestProgramDto;
import com.system.programserviceapi.dto.response.ResponseProgramDto;
import com.system.programserviceapi.entity.Program;
import com.system.programserviceapi.entity.Subject;
import com.system.programserviceapi.repo.ProgramRepo;
import com.system.programserviceapi.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepo programRepo;
    private final WebClient webClient;

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

        ArrayList<Long> list = new ArrayList<>();
        for (Subject subject : program.getSubjects()) {
            list.add(subject.getId());
        }

        String ids = list.stream().map(Objects::toString).collect(Collectors.joining(", "));

        Boolean isOk = webClient.get().uri("http://localhost:8082/api/v1/subjects/{id}", ids)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if (Boolean.TRUE.equals(isOk)) {
            programRepo.save(program);
        } else {
            throw new IllegalArgumentException("Try Again With Available Subjects");
        }
    }

    @Override
    public List<ResponseProgramDto> findAllPrograms() {
        List<Program> programs = programRepo.findAll();
        List<ResponseProgramDto> responseProgramDtoList = new ArrayList<>();
        for (Program program : programs) {
            responseProgramDtoList.add(
                    new ResponseProgramDto(
                            program.getId(),
                            program.getName(),
                            program.getPrice(),
                            program.getStartDate(),
                            program.getSubjects()
                    )
            );
        }
        return responseProgramDtoList;
    }
}
