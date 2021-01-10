package com.andrejzaha.dentistappointment.service;

import com.andrejzaha.dentistappointment.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<Doctor> findAllDoctors();

    Optional<Doctor> findById(Long id);

}
