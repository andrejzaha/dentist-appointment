package com.andrejzaha.dentistappointment.service.impl;

import com.andrejzaha.dentistappointment.model.Doctor;
import com.andrejzaha.dentistappointment.repository.DoctorRepository;
import com.andrejzaha.dentistappointment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

}
