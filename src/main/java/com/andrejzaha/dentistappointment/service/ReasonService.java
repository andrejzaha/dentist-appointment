package com.andrejzaha.dentistappointment.service;

import com.andrejzaha.dentistappointment.model.Reason;

import java.util.Optional;

public interface ReasonService {

    Optional<Reason> findById(Long reasonId);

}
