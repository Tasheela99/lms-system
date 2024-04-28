package com.system.programserviceapi.dto.request;

import com.system.programserviceapi.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestProgramDto {

    private String name;
    private BigDecimal price;
    private Date startDate;

    private List<Subject> subjects;
}
