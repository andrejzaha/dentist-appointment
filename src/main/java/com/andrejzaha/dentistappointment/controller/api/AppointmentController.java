package com.andrejzaha.dentistappointment.controller.api;

import com.andrejzaha.dentistappointment.model.frontend.AppointmentChoiceModel;
import com.andrejzaha.dentistappointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/get-appointment-choice-model")
    public AppointmentChoiceModel getAppointmentChoiceModel(
            @RequestParam(name = "doctor-id") Long doctorId,
            @RequestParam(name = "reason-id") Long reasonId,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate fromDate,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate toDate) {
        return appointmentService
                .getAppointmentChoiceModel(doctorId, reasonId, fromDate, toDate);
    }

    @GetMapping("/get-appointment-choice-model-by-period-code")
    public AppointmentChoiceModel getAppointmentChoiceModelUsingCustomPeriod(
            @RequestParam(name = "doctor-id") Long doctorId,
            @RequestParam(name = "reason-id") Long reasonId,
            @RequestParam(name="period-code") String periodCode) {
        return appointmentService
                .getAppointmentChoiceModelByPeriodCodeAsString(doctorId, reasonId, periodCode);
    }

}
