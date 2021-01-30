package com.andrejzaha.dentistappointment.controller.api;

import com.andrejzaha.dentistappointment.model.Doctor;
import com.andrejzaha.dentistappointment.model.frontend.DoctorFront;
import com.andrejzaha.dentistappointment.service.AvailabilityService;
import com.andrejzaha.dentistappointment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/find-all-doctors")
    public List<DoctorFront> findAllDoctors() {
        return doctorService.findAllDoctorsForFront();
    }

}
