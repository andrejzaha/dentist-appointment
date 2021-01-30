package com.andrejzaha.dentistappointment.service;

import com.andrejzaha.dentistappointment.model.frontend.PeriodCodeFront;

import java.util.List;

public interface PeriodService {

    List<PeriodCodeFront> findAllPeriods();

}
