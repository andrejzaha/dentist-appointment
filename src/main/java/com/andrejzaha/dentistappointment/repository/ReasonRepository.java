package com.andrejzaha.dentistappointment.repository;

import com.andrejzaha.dentistappointment.model.Reason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReasonRepository extends JpaRepository<Reason, Long> {
}
