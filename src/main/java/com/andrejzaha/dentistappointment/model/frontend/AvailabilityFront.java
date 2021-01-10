package com.andrejzaha.dentistappointment.model.frontend;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AvailabilityFront {

    private String dayOfWeek;

    private String fromHour;

    private String fromMinute;

    private String toHour;

    private String toMinute;

}
