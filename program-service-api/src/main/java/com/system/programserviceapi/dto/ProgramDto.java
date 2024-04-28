package com.system.programserviceapi.dto;


import com.system.programserviceapi.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDto {
    private String id;
    private String name;
    private BigDecimal price;
    private Date startDate;

    private List<Subject> subjects;
}
