package com.system.programserviceapi.service;

import com.system.programserviceapi.dto.request.RequestProgramDto;
import com.system.programserviceapi.dto.response.ResponseProgramDto;

import java.util.List;

public interface ProgramService {

    public void createProgram(RequestProgramDto requestProgramDto);

    List<ResponseProgramDto> findAllPrograms();
}
