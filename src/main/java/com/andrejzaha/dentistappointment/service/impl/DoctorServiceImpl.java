package com.andrejzaha.dentistappointment.service.impl;

import com.andrejzaha.dentistappointment.model.Doctor;
import com.andrejzaha.dentistappointment.model.frontend.DoctorFront;
import com.andrejzaha.dentistappointment.repository.DoctorRepository;
import com.andrejzaha.dentistappointment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<DoctorFront> findAllDoctorsForFront() {
        return doctorRepository.findAll().stream()
                .map(this::getDoctorFront)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    private DoctorFront getDoctorFront(Doctor doctor) {
        DoctorFront doctorFront = new DoctorFront();

        doctorFront.setId(doctor.getId());
        doctorFront.setDisplayedName(doctor.getLastName(), doctor.getFirstName());

        return doctorFront;
    }

}
