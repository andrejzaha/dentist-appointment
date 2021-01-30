package com.andrejzaha.dentistappointment.service;

import com.andrejzaha.dentistappointment.model.Reason;
import com.andrejzaha.dentistappointment.model.frontend.ReasonFront;

import java.util.List;
import java.util.Optional;

public interface ReasonService {

    Optional<Reason> findById(Long reasonId);

    List<ReasonFront> findAllReasons();

}
