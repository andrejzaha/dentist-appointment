package com.andrejzaha.dentistappointment.service;

import com.andrejzaha.dentistappointment.model.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> findAllDoctors();

}
