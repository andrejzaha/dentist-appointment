package com.andrejzaha.dentistappointment.service.impl;

import com.andrejzaha.dentistappointment.model.Patient;
import com.andrejzaha.dentistappointment.repository.PatientRepository;
import com.andrejzaha.dentistappointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

}
