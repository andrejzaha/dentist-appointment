package com.andrejzaha.dentistappointment.service.impl;

import com.andrejzaha.dentistappointment.service.TimeMachineService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TimeMachineServiceImpl implements TimeMachineService {

    @Override
    public LocalDate getNowLocalDate() {
        return LocalDate.now();
    }

    public LocalDateTime getNowLocalDateTime() {
        return LocalDateTime.now();
    }

}
