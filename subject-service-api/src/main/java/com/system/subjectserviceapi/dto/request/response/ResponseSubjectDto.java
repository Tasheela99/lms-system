package com.system.subjectserviceapi.dto.request.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSubjectDto {
    private Long id;
    private String name;
    private boolean status;
}
