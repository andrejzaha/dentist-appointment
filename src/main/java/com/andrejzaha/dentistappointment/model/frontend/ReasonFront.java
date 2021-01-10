package com.andrejzaha.dentistappointment.model.frontend;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReasonFront {

    private Long id;

    private String description;

    private Integer durationInMinutes;

}
