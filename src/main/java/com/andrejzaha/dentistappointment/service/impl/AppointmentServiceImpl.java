package com.andrejzaha.dentistappointment.service.impl;

import com.andrejzaha.dentistappointment.model.Doctor;
import com.andrejzaha.dentistappointment.model.Reason;
import com.andrejzaha.dentistappointment.model.frontend.AppointmentChoiceModel;
import com.andrejzaha.dentistappointment.model.frontend.DoctorFront;
import com.andrejzaha.dentistappointment.model.frontend.ReasonFront;
import com.andrejzaha.dentistappointment.service.AppointmentService;
import com.andrejzaha.dentistappointment.service.AvailabilityService;
import com.andrejzaha.dentistappointment.service.DoctorService;
import com.andrejzaha.dentistappointment.service.ReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ReasonService reasonService;

    @Autowired
    private AvailabilityService availabilityService;

    @Override
    public AppointmentChoiceModel getAppointmentChoiceModel(Long doctorId, Long reasonId,
                                                            LocalDate fromDate, LocalDate toDate) {
        return doctorService.findById(doctorId)
                .map(doctor -> getModelFollowingDoctorRetrieval(doctor, reasonId, fromDate, toDate))
                .orElse(getEmptyAppointmentChoiceModel());

    }
    private AppointmentChoiceModel getModelFollowingDoctorRetrieval(Doctor doctor, Long reasonId,
                                                                    LocalDate fromDate, LocalDate toDate) {
        return reasonService.findById(reasonId)
                .map(reason -> getModelFollowingDoctorAndReasonRetrieval(doctor, reason, fromDate, toDate))
                .orElse(getEmptyAppointmentChoiceModel());
    }

    private AppointmentChoiceModel getModelFollowingDoctorAndReasonRetrieval(Doctor doctor, Reason reason,
                                                                   LocalDate fromDate, LocalDate toDate) {
        AppointmentChoiceModel appointmentChoiceModel = new AppointmentChoiceModel();

        appointmentChoiceModel.setDoctor(getDoctorFront(doctor));
        appointmentChoiceModel.setReason(getReasonFront(reason));
        appointmentChoiceModel.setAvailabilities(
                availabilityService.getAvailabilitiesForFront(
                        doctor.getAvailabilities(),
                        reason.getDurationInMinutes(),
                        fromDate,
                        toDate
                )
        );

        return appointmentChoiceModel;
    }

    private DoctorFront getDoctorFront(Doctor doctor) {
        DoctorFront doctorFront = new DoctorFront();

        doctorFront.setId(doctor.getId());
        doctorFront.setDisplayedName(doctor.getLastName(), doctor.getFirstName());

        return doctorFront;
    }


    private ReasonFront getReasonFront(Reason reason) {
        ReasonFront reasonFront = new ReasonFront();

        reasonFront.setId(reason.getId());
        reasonFront.setDescription(reason.getDescription());
        reasonFront.setDurationInMinutes(reason.getDurationInMinutes());

        return reasonFront;
    }

    private AppointmentChoiceModel getEmptyAppointmentChoiceModel() {
        AppointmentChoiceModel appointmentChoiceModel = new AppointmentChoiceModel();

        DoctorFront doctorFront = new DoctorFront();
        doctorFront.setDisplayedName("");

        ReasonFront reasonFront = new ReasonFront();
        reasonFront.setDescription("");

        appointmentChoiceModel.setDoctor(doctorFront);
        appointmentChoiceModel.setReason(reasonFront);
        appointmentChoiceModel.setAvailabilities(Collections.emptyList());

        return appointmentChoiceModel;
    }

}
