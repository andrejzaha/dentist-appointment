package com.andrejzaha.dentistappointment.service;

import com.andrejzaha.dentistappointment.model.Doctor;
import com.andrejzaha.dentistappointment.model.frontend.DoctorFront;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<DoctorFront> findAllDoctorsForFront();

    List<Doctor> findAllDoctors();

    Optional<Doctor> findById(Long id);

}
