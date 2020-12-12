package com.andrejzaha.dentistappointment.repository;

import com.andrejzaha.dentistappointment.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("doctorRepository")
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
