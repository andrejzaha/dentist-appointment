package com.andrejzaha.dentistappointment.service;

import com.andrejzaha.dentistappointment.model.frontend.AppointmentChoiceModel;

import java.time.LocalDate;

public interface AppointmentService {

    AppointmentChoiceModel getAppointmentChoiceModel(Long doctorId, Long reasonId,
                                                     LocalDate fromDate, LocalDate toDate);

    AppointmentChoiceModel getAppointmentChoiceModelByPeriodCodeAsString(Long doctorId,
                                                                         Long reasonId,
                                                                         String periodCode);

}
