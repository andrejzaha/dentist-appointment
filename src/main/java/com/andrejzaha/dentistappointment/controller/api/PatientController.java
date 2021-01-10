package com.andrejzaha.dentistappointment.controller.api;

import com.andrejzaha.dentistappointment.model.Patient;
import com.andrejzaha.dentistappointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/find-all-patients")
    public List<Patient> findAllPatients() {
        return patientService.findAllPatients();
    }

}
