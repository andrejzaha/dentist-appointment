package com.andrejzaha.dentistappointment.service;

import com.andrejzaha.dentistappointment.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAllPatients();

}
