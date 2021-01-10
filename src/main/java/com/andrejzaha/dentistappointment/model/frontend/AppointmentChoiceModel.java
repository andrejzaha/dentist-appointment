package com.andrejzaha.dentistappointment.model.frontend;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AppointmentChoiceModel {

    private DoctorFront doctor;

    private ReasonFront reason;

    private List<AvailabilityFront> availabilities;

}
