package com.andrejzaha.dentistappointment.repository;

import com.andrejzaha.dentistappointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("patientRepository")
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
